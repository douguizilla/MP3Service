package com.odougle.mp3service.services

interface MP3Service {
    fun play(file: String)
    fun pause()
    fun stop()
    val currentSong: String?
    val totalTime: Int
    val elapsedTime: Int
}