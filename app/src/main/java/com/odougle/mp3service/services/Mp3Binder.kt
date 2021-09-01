package com.odougle.mp3service.services

import android.os.Binder

class Mp3Binder (val service: Mp3Service) : Binder() {
}