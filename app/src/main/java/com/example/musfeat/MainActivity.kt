package com.example.musfeat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.musfeat.presentation.signup.SignUpFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.main_container, TestFragment())
            .commit()

        supportFragmentManager.commit {
            add(R.id.container, SignUpFragment())
        }
    }

}