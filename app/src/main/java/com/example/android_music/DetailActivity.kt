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
                val name = bundle.getString("TenBai", "Chưa có tên")
                val duration = bundle.getDouble("ThoiLuong", 0.0)
                val author = bundle.getString("TacGia", "Chưa có tác giả")

                tvNameMusic.text = "Tên bài hát: $name"
                tvDuration.text = "Thời lượng: ${duration} phút"
                tvAuthor.text = "Tác giả: $author"

            }
        }

        // Xử lý sự kiện nút bấm
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnEdit.setOnClickListener {
            with(binding){
                val intent = Intent(this@DetailActivity, ChinhSuaChiTietActivity::class.java).apply{
                    with(binding){
                        putExtra("TenBaiNow",tvNameMusic.text)
                        putExtra("ThoiLuongNow", tvDuration.text)
                        putExtra("TacGiaNow",tvAuthor.text)
                    }
                    editLauncher.launch(intent)
                }

            }
        }
    }
}