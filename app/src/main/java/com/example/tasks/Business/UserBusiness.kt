package com.example.tasks.Business

import android.content.Context
import com.example.tasks.DataBase.RepositórioUsuario

class UserBusiness ( val context: Context){

    private val mRepositórioUsuario: RepositórioUsuario = RepositórioUsuario.getInstance(context)

    fun insert (nome: String, email: String, senha: String){
       val userID = mRepositórioUsuario.insert(nome, email, senha)

       val srt = "oi"
    }


}