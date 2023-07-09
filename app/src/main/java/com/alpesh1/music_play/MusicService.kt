package com.alpesh1.music_play

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {

    lateinit var mp : MediaPlayer
    override fun onBind(p0: Intent?): IBinder? {

        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        var music = intent?.getIntExtra("music",0)

        mp = MediaPlayer.create(this,music!!)
        mp.isLooping = true
        mp.start()

        return START_NOT_STICKY
    }

    override fun onDestroy() {

        mp.stop()
    }
}