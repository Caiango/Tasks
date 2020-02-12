package com.example.tasks.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tasks.DataBase.RepositórioUsuario
import com.example.tasks.R
import kotlinx.android.synthetic.main.activity_login.*

class RegistroActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setListeners()
        RepositórioUsuario.getInstance(this)

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

