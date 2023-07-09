package com.alpesh1.music_play

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.alpesh1.music_play.R.raw.*
import com.alpesh1.music_play.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var musics = arrayOf(song,song1, song2, song3, song4, song5)
    var music_name = arrayOf("song","song1", "song2", "song3", "song4", "song5")
    lateinit var binding: ActivityMainBinding

    var select = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.musicList.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,music_name)

        binding.musicList.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                select = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        findViewById<Button>(R.id.btnPlay).setOnClickListener {

            startService(Intent(this,MusicService::class.java).putExtra("music",musics[select]))
        }

        findViewById<Button>(R.id.btnStop).setOnClickListener {

            stopService(Intent(this,MusicService::class.java))


        }
    }
}