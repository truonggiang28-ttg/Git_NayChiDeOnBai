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

    }
}