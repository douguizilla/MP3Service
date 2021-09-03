package com.odougle.mp3service

import android.content.ServiceConnection
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.AdapterView
import androidx.loader.app.LoaderManager
import com.odougle.mp3service.databinding.ActivityMp3Binding
import com.odougle.mp3service.services.Mp3Service

class Mp3Activity : AppCompatActivity(), ServiceConnection, AdapterView.OnItemClickListener,
    LoaderManager.LoaderCallbacks<Cursor> {

    private var service: Mp3Service? = null
    private var music: String = ""
    private val columns = arrayOf(
        MediaStore.MediaColumns.DISPLAY_NAME,
        MediaStore.MediaColumns.DATA,
        MediaStore.MediaColumns._ID
    )

    private val binding: ActivityMp3Binding by lazy {
        ActivityMp3Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}