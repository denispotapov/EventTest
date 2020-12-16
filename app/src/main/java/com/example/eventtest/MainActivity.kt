package com.example.eventtest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: EventViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(EventViewModel::class.java)

        button.setOnClickListener {
            viewModel.onButtonClick()
        }

        viewModel.showToast.observe(this, EventObserver {
            if (it) {
                Toast.makeText(this, "New Toast", Toast.LENGTH_SHORT).show()
            }
        })

        /*viewModel.showToast.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let {
                if (it) {
                    Toast.makeText(this, "New Toast", Toast.LENGTH_SHORT).show()
                }
            }
        })*/
    }
}