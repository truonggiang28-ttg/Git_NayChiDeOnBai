package com.example.android_music

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.android_music.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {
    private val editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
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
            val intent = Intent(this@DetailActivity, EditDetailActivity::class.java)
            editLauncher.launch(intent)
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}