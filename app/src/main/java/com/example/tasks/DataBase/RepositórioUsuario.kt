package com.example.tasks.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import java.lang.Exception

// classe responsável por acessar o bd e inserir dados apenas para usuario
//singletone só permite ter uma instancia por vez da classe, sempre faz isso com classes de repositorio
class RepositórioUsuario private constructor(context: Context) {
    //variavel que vaia cessar o banco de dados
    var mTasksDataBase: TaskDataBase = TaskDataBase(context)

    companion object {
        fun getInstance(context: Context): RepositórioUsuario {
            if (INSTANCE == null) {
                INSTANCE = RepositórioUsuario(context)
            }
            return INSTANCE as RepositórioUsuario
        }

        //variável que vai armazenar a instancia dessa classe
        private var INSTANCE: RepositórioUsuario? = null
    }

    fun emailExiste(email: String): Boolean {
        // variável que le o retorno do banco de daods é cursor
        var ret: Boolean = false
        try {
            val cursor: Cursor
            val db = mTasksDataBase.readableDatabase

            val projection = arrayOf(DataBaseConstants.USER.COLUNAS.ID)
            val selection = "${DataBaseConstants.USER.COLUNAS.EMAIL} = ?"
            val selectionArgs = arrayOf(email)

            cursor = db.query(DataBaseConstants.USER.TABLE_NAME, projection, selection, selectionArgs, null, null, null)
            ret = cursor.count > 0
            cursor.close()
        } catch (e: Exception) {
            throw e
        }
        return ret
    }

    fun insert(nome: String, email: String, senha: String): Int {
        val db = mTasksDataBase.writableDatabase

        val insertValues = ContentValues()
        //colunas onde vou inserir
        insertValues.put(DataBaseConstants.USER.COLUNAS.NOME, nome)
        insertValues.put(DataBaseConstants.USER.COLUNAS.EMAIL, email)
        insertValues.put(DataBaseConstants.USER.COLUNAS.SENHA, senha)

        //estou inserindo na tabela usuario
        return db.insert(DataBaseConstants.USER.TABLE_NAME, null, insertValues).toInt()

    }
}
