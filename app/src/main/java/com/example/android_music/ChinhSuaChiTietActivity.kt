package com.example.android_music

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_music.databinding.ActivityChinhSuaChiTietBinding
import kotlin.time.Duration


class ChinhSuaChiTietActivity: AppCompatActivity() {
    private lateinit var binding: ActivityChinhSuaChiTietBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChinhSuaChiTietBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let{
            bundle ->
            with(binding){
                val NameMusicNow = bundle.getString("TenBaiNow")
                val DurationNow = bundle.getDouble("ThoiLuongNow")
                val AuthorNow = bundle.getString("TacGiaNow")

                edtNameBai.setText(NameMusicNow)
                edtDurationBai.setText(DurationNow.toString())
                edtAuthorBai.setText(AuthorNow)
            }
        }
        binding.btnSave.setOnClickListener {
            with(binding){
                val NameMusicNew = edtNameBai.text.toString()
                val DurationNew = edtDurationBai.text.toString().toDoubleOrNull()?:0.0
                val AuthorNew = edtAuthorBai.text.toString()

                val resultIntent = Intent().apply{
                    putExtra("TenBaiNew", NameMusicNew)
                    putExtra("ThoiLuongNew",DurationNew)
                    putExtra("TacGiaNew",AuthorNew)
                }
                setResult(Activity.RESULT_OK, resultIntent)
            }
            finish()
        }
        binding.btnExit.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}