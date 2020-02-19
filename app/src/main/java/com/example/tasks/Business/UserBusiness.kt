package com.example.tasks.Business

import android.content.Context
import com.example.tasks.DataBase.RepositórioUsuario
import com.example.tasks.DataBase.TaksConstants
import com.example.tasks.R
import com.example.tasks.Validacao.SecurityPreferences
import com.example.tasks.Validacao.ValidacaoException
import java.lang.Exception

class UserBusiness(val context: Context) {

    private val mRepositorioUsuario: RepositórioUsuario = RepositórioUsuario.getInstance(context)
    private val mSecurityPreferences: SecurityPreferences = SecurityPreferences(context)

    fun insert(nome: String, email: String, senha: String) {



        //validação dos dados recebidos
        try {

            if (nome == "" || email == "" || senha == "") {
                throw ValidacaoException(context.getString(R.string.Campos))
            }

            if (mRepositorioUsuario.emailExiste(email)) {
                throw ValidacaoException(context.getString(R.string.Email))
            }

            val userID = mRepositorioUsuario.insert(nome, email, senha)

            //salvar dados do usuario no sharespreferences
            mSecurityPreferences.storeString(TaksConstants.KEY.USER_ID, userID.toString())
            mSecurityPreferences.storeString(TaksConstants.KEY.USER_NOME, nome)
            mSecurityPreferences.storeString(TaksConstants.KEY.USER_EMAIL, email)

        } catch (e: Exception) {
            throw e
        }


    }


}