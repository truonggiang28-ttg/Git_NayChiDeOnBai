package com.example.android_music

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.android_music.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
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


        intent.extras?.let { bundle ->
            with(binding) {
                tvNameMusic.text = bundle.getString("TenBai", "Chưa có tên")
                tvDuration.text = bundle.getDouble("ThoiLuong", 0.0).toString()
                tvAuthor.text = bundle.getString("TacGia", "Chưa có tác giả")
            }
        }

        // Xử lý sự kiện nút bấm
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnEdit.setOnClickListener {

            with(binding){
                val intent = Intent(this@DetailActivity, ChinhSuaChiTietActivity::class.java).apply{
                        putExtra("TenBaiNow",tvNameMusic.text.toString())
                        val ThoiLuongDouble = tvDuration.text.toString().toDoubleOrNull()
                        putExtra("ThoiLuongNow", ThoiLuongDouble)
                        putExtra("TacGiaNow",tvAuthor.text.toString())
                    }
                    editLauncher.launch(intent)
                }
            }
        }
    }