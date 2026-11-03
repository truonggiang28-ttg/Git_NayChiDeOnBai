package com.example.android_music

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_music.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        intent.extras?.let { bundle ->
            with(binding) {
                val name = bundle.getString("TenBai", "Chưa có tên")
                val duration = bundle.getDouble("ThoiLuong", 0.0)
                val author = bundle.getString("TacGia", "Chưa có tác giả")

                tvNameMusic.text = "Tên bài hát: $name"
                tvDuration.text = "Thời lượng: ${duration.toString()} phút"
                tvAuthor.text = "Tác giả: $author"
            }
        }

        // Xử lý sự kiện nút bấm
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnEdit.setOnClickListener {
            with(binding){
                val intent = Intent(this@DetailActivity, ChinhSuaChiTietActivity::class.java)
                startActivity(intent)
            }
        }
    }
}