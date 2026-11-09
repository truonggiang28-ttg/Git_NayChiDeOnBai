package com.example.android_music

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_music.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var NameSave_313 : String? = null
    var Duration_313 : Double? = null
    var Author_313 : String? = null
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            with(binding){
                val TenNhac_313 = edtNameMusic.text.toString()
                val ThoiLuong_313 = edtDuration.text.toString()
                val TacGia_313 = edtAuthor.text.toString()

                val ThoiLuongDouble = ThoiLuong_313.toDoubleOrNull()

                NameSave_313 = TenNhac_313
                Duration_313 = ThoiLuongDouble
                Author_313 = TacGia_313

                Toast.makeText(this@MainActivity, "Da them bai hat moi",
                    Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnDetail.setOnClickListener {
            with(binding){
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("TenBai",NameSave_313)
                    putExtra("ThoiLuong",Duration_313)
                    putExtra("TacGia",Author_313)
                }
                startActivity(intent)
            }
        }
    }
}