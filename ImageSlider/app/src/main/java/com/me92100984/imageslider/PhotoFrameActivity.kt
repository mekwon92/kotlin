package com.me92100984.imageslider

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PhotoFrameActivity : AppCompatActivity() {
    private val photoList = mutableListOf<Uri>()
    private var currentPosition = 0
    private var timeHandler: Handler? = null

    private lateinit var photoImageView: ImageView
    private lateinit var backgroundPhotoImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photoframe)

        photoImageView = findViewById(R.id.ImageView)
        backgroundPhotoImageView = findViewById(R.id.PhotoImageView)

        getPhotoUriFromIntent()
    }

    private fun getPhotoUriFromIntent() {
        val size = intent.getIntExtra("photoListSize", 0)
        for (i in 0 until size) {
            intent.getStringExtra("photo$i")?.let {
                photoList.add(Uri.parse(it))
            }
        }
    }

    private val timeRunnable = object:Runnable {
        override fun run() {
            val current = currentPosition
            val next = if (photoList.size <= currentPosition + 1) 0
            else currentPosition + 1

            backgroundPhotoImageView.setImageURI(photoList[current])

            photoImageView.alpha = 0f
            photoImageView.setImageURI(photoList[next])
            photoImageView.animate()
                .alpha(1.0f)
                .setDuration(1000)
                .start()

            currentPosition = next

            startTimer()
        }
    }

    private fun startTimer() {
        timeHandler?.removeCallbacks(timeRunnable)
        timeHandler = Handler(Looper.getMainLooper())
        timeHandler?.postDelayed(timeRunnable, 3000)
    }

    override fun onStart() {
        super.onStart()
        startTimer()
    }

    override fun onStop() {
        super.onStop()
        timeHandler?.removeCallbacks(timeRunnable)

    }

    override fun onDestroy() {
        super.onDestroy()
        timeHandler?.removeCallbacks(timeRunnable)
    }

}