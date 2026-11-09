package com.example.android_music

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.android_music.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {
    private val editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == RESULT_OK){
            result.data?.extras?.let {
                    bundle ->
                with(binding){
                    tvNameMusic.text = bundle.getString("TenBaiNew")
                    tvDuration.text = bundle.getDouble("ThoiLuongNew").toString()
                    tvAuthor.text = bundle.getString("TacGiaNew")
                }
            }
        }
    }
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let{
            bundle ->
                with(binding){
                    tvNameMusic.text = bundle.getString("TenBai")
                    tvDuration.text = bundle.getDouble("ThoiLuong").toString()
                    tvAuthor.text = bundle.getString("TacGia")
                }
        }
        binding.btnEdit.setOnClickListener {
            with(binding){
                val intent = Intent(this@DetailActivity, EditDetailActivity::class.java).apply {
                    putExtra("TenBaiNow",tvNameMusic.text.toString())
                    val DurationDouble = tvDuration.text.toString().toDoubleOrNull()?:0.0
                    putExtra("ThoiLuongNow",DurationDouble)
                    putExtra("TacGiaNow",tvAuthor.text.toString())
                }
                editLauncher.launch(intent)
            }

        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}