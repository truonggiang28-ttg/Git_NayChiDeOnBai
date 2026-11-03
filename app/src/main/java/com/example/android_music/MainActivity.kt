package com.example.android_music

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_music.databinding.ActivityMainBinding
import kotlin.time.Duration

class MainActivity : AppCompatActivity() {
    var Name_313 : String? = null
    var Duration_313 : Double? = null
    var Author_313 : String? = null
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            with(binding){
                val TenBai_313 = edtNameMucsic.text.toString()
                val ThoiLuong_313 = edtDuration.text.toString()
                val TacGia_313 = edtAuthor.text.toString()

                if(TenBai_313.isEmpty()){
                        edtNameMucsic.error = "Vui long nhap ten bai"
                        edtNameMucsic.requestFocus()
                    return@setOnClickListener
                }
                else{
                    edtNameMucsic.error = null
                }

                if(ThoiLuong_313.isEmpty()){
                    edtDuration.error = "Vui long nhap thoi luong"
                    edtDuration.requestFocus()
                    return@setOnClickListener
                }
                else{
                    edtDuration.error = null
                }

                if(TacGia_313.isEmpty()){
                    edtAuthor.error = "Vui long nhap tac gia"
                    edtAuthor.requestFocus()
                    return@setOnClickListener
                }
                else{
                    edtAuthor.error = null
                }

                val ThoiGian = ThoiLuong_313.toDoubleOrNull() ?: 0.0

                if (ThoiGian <= 0){
                    Toast.makeText(this@MainActivity,"Du lieu khong hop le",Toast.LENGTH_SHORT)
                }
                Name_313 = TenBai_313
                Duration_313 = ThoiGian
                Author_313 = TacGia_313

                Toast.makeText(this@MainActivity,"Da them bai hat", Toast.LENGTH_SHORT)

            }
        }
        binding.btnDetail.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                with(binding) {
                    putExtra("TenBai", Name_313)
                    putExtra("ThoiLuong", Duration_313)
                    putExtra("TacGia", Author_313)
                }
                startActivity(intent)
            }
        }
    }
}