package com.exemple.exemplomvvm

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.app.R
import com.example.app.databinding.ActivityMainMvvmBinding

class MainMvvmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainMvvmBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainMvvmBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.login().observe(this, Observer {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })

        binding.buttonEntrar.setOnClickListener {
            viewModel.doLogin(binding.editEmail.text.toString(), binding.editPassword.text.toString())
        }
    }
}