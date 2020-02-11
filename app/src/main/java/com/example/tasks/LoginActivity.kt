package com.example.tasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setListeners()

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonEntrar) {
            handleSave()
        }
    }

    private fun setListeners() {
        buttonEntrar.setOnClickListener(this)
    }

    private fun handleSave() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

