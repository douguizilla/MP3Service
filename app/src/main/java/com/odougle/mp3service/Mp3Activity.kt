package com.odougle.mp3service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.mp3service.databinding.ActivityMainBinding

class Mp3Activity : AppCompatActivity() {

    private val binding :  ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}