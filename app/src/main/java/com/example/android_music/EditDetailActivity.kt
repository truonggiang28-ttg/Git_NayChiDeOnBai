package com.example.android_music

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import com.example.android_music.databinding.ActivityEditdetailBinding
import kotlin.time.Duration

class EditDetailActivity: AppCompatActivity(){
    private lateinit var binding: ActivityEditdetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditdetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let{
            bundle ->
                with(binding){
                    val NameMusicNow_313 = bundle.getString("TenBaiNow")
                    val DurationNow_313 = bundle.getDouble("ThoiLuongNow")
                    val AuthorNow_313 = bundle.getString("TacGiaNow")

                    edtNameMusicSua.setText(NameMusicNow_313)
                    edtDurationSua.setText(DurationNow_313.toString())
                    edtAuthorSua.setText(AuthorNow_313)
                }
        }
        binding.btnSave.setOnClickListener {
            with(binding){
                val NameMusicNew_313 = edtNameMusicSua.text.toString()
                val DurationNew_313 = edtDurationSua.text.toString().toDoubleOrNull()?:0.0
                val AuthorNew_313 = edtAuthorSua.text.toString()

                val result = Intent().apply {
                    putExtra("TenBaiNew", NameMusicNew_313)
                    putExtra("ThoiLuongNew", DurationNew_313)
                    putExtra("TacGiaNew",AuthorNew_313)
                }
                setResult(Activity.RESULT_OK,result)
                finish()
            }
        }
        binding.btnExit.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

    }
}