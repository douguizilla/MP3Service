package com.odougle.mp3service

import android.content.ServiceConnection
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import androidx.loader.app.LoaderManager
import com.odougle.mp3service.databinding.ActivityMp3Binding

class Mp3Activity : AppCompatActivity(), ServiceConnection, AdapterView.OnItemClickListener,
    LoaderManager.LoaderCallbacks<Cursor> {

    private val binding: ActivityMp3Binding by lazy {
        ActivityMp3Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}