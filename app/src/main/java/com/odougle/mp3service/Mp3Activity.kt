package com.odougle.mp3service

import android.content.ServiceConnection
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.text.format.DateUtils
import android.widget.AdapterView
import android.widget.SimpleCursorAdapter
import androidx.loader.app.LoaderManager
import com.odougle.mp3service.databinding.ActivityMp3Binding
import com.odougle.mp3service.services.Mp3Service
import java.util.*

class Mp3Activity : AppCompatActivity(), ServiceConnection, AdapterView.OnItemClickListener,
    LoaderManager.LoaderCallbacks<Cursor> {

    private val binding: ActivityMp3Binding by lazy {
        ActivityMp3Binding.inflate(layoutInflater)
    }

    private var service: Mp3Service? = null
    private var music: String = ""
    private val columns = arrayOf(
        MediaStore.MediaColumns.DISPLAY_NAME,
        MediaStore.MediaColumns.DATA,
        MediaStore.MediaColumns._ID
    )

    private val adapter : SimpleCursorAdapter by lazy {
        SimpleCursorAdapter(
            this,
            android.R.layout.simple_list_item_2,
            null,
            columns,
            intArrayOf(android.R.id.text1, android.R.id.text2),
            0
        )
    }

    private lateinit var handler: Handler
    private lateinit var threadProgress: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        handler = Handler()
        threadProgress = object : Thread(){
            override fun run() {
                updateScreen()
                if(service?.totalTime ?: 0 > service?.elapsedTime ?: 0){
                    handler.postDelayed(this, 1000)
                }
            }
        }
        binding.btnPlay.setOnClickListener { play() }
        binding.btnPlay.setOnClickListener { pause() }
        binding.btnStop.setOnClickListener { stop() }
    }

    private fun updateScreen(){
        music = service?.currentSong ?: ""
        binding.txtSong.text = music
        val elapsedTime = service?.elapsedTime ?: 0
        binding.txtTime.text = DateUtils.formatElapsedTime(elapsedTime.toLong() / 1000)
        binding.progressBar.max = service?.totalTime ?: 0
        binding.progressBar.progress = elapsedTime
    }

    private fun play(){
        handler.removeCallbacks(threadProgress)
        if(music.isNotBlank()){
            service?.play(music)
            handler.post(threadProgress)
        }
    }

    private fun pause(){
        service?.pause()
        handler.removeCallbacks(threadProgress)
    }

    private fun stop(){
        service?.stop()
        handler.removeCallbacks(threadProgress)
        binding.progressBar.progress = 0
        binding.txtTime.text = DateUtils.formatElapsedTime(0)
    }


}