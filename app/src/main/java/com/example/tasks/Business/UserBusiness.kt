package com.example.tasks.Business

import android.content.Context
import com.example.tasks.DataBase.RepositórioUsuario
import com.example.tasks.Validacao.ValidacaoException
import java.lang.Exception

class UserBusiness ( val context: Context){

    private val mRepositorioUsuario: RepositórioUsuario = RepositórioUsuario.getInstance(context)


    fun insert (nome: String, email: String, senha: String){

        //validação dos dados recebidos
        try {

            if (nome == "" || email == "" || senha == ""){
                throw ValidacaoException("Preencha todos os campos!")
            }



            val userID = mRepositorioUsuario.insert(nome, email, senha)
        }catch (e: Exception){
            throw e
        }


    }


}