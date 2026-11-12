package com.example.multi

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import pl.droidsonroids.gif.GifImageView

class catselector : AppCompatActivity() {
    private var currentMediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catselector)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)

        val gif1: GifImageView = findViewById(R.id.image1)
        val gif2: GifImageView = findViewById(R.id.image2)
        val gif3: GifImageView = findViewById(R.id.image3)

        button1.setOnClickListener {
            playSound(R.raw.sound1)
        }

        button2.setOnClickListener {
            playSound(R.raw.sound2)
        }

        button3.setOnClickListener {
            playSound(R.raw.sound3)
        }
    }

    private fun playSound(soundResId: Int) {
        currentMediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
                it.release()
            }
        }

        currentMediaPlayer = MediaPlayer.create(this, soundResId)
        currentMediaPlayer?.setOnCompletionListener {
            it.release()
            currentMediaPlayer = null
        }

        currentMediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        currentMediaPlayer?.release()
        currentMediaPlayer = null
    }
}