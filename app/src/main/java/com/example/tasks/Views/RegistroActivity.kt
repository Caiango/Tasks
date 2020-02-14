package com.example.tasks.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tasks.Business.UserBusiness
import com.example.tasks.DataBase.RepositórioUsuario
import com.example.tasks.R
import com.example.tasks.Validacao.ValidacaoException
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class RegistroActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mUserBusiness: UserBusiness

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setListeners()

        //Instanciar variáveis
        mUserBusiness = UserBusiness(this)

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

        try {
            val nome = EditNome.text.toString()
            val email = EditEmail.text.toString()
            val senha = EditSenha.text.toString()

            //Faz inserção do usuário
            mUserBusiness.insert(nome, email, senha)

//        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
        } catch (e: ValidacaoException){
            Snackbar.make(LayoutReg, "Preencha todos os campos", Snackbar.LENGTH_LONG).show()
        }
    }

}

