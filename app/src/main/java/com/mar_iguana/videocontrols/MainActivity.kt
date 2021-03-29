package com.mar_iguana.videocontrols

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.mar_iguana.videocontrols.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.videoView)


        // Button videos
        binding.buttonVideo1.setOnClickListener {
            binding.videoView.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.video}"))
            binding.videoView.requestFocus()
        }
        binding.buttonVideo2.setOnClickListener {
            binding.videoView.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.video2}"))
            binding.videoView.requestFocus()
        }
        binding.buttonVideo3.setOnClickListener {
            binding.videoView.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.video3}"))
            binding.videoView.requestFocus()
        }

        // Video actions
        binding.buttonPlay.setOnClickListener {
            if (binding.textInput.text.toString().isNotEmpty()) {
                Toast.makeText(this, "Playing video from web address", Toast.LENGTH_SHORT).show()
//        var uriVideo: String = "https://www.videvo.net/videvo_files/converted/2016_01/preview/Forest_15_3b_Videvo.mov47209.webm"
//                val content = "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"
//                binding.videoView.setVideoURI(Uri.parse(content))
                binding.videoView.setVideoURI(Uri.parse(binding.textInput.text.toString()))
                binding.videoView.requestFocus()

            }
            binding.videoView.start()
        }
        binding.buttonPause.setOnClickListener {
            binding.videoView.pause()
        }

    }
}