package com.odougle.mp3service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.mp3service.databinding.ActivityMp3Binding

class Mp3Activity : AppCompatActivity() {

    private val binding : ActivityMp3Binding by lazy{
        ActivityMp3Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}