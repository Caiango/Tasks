package com.example.tasks.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TaskDataBase(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NOME, null, DATABASE_VERSAO) {

    //O companion serve para deixar estático, só consigo acessar a variável acima se for estática
    companion object {
        val DATABASE_NOME: String = "tasks.bd"
        val DATABASE_VERSAO: Int = 1
    }

    //SQLite, BD do android, tem 4 tipos dee valores: integer, real, text, blob (tipos de arquivos)
    //Script de criação do BD

    private val createTableUser = """ CREATE TABLE ${DataBaseConstants.USER.TABLE_NAME} (
    ${DataBaseConstants.USER.COLUNAS.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
    ${DataBaseConstants.USER.COLUNAS.NOME} TEXT,
    ${DataBaseConstants.USER.COLUNAS.EMAIL} TEXT,
    ${DataBaseConstants.USER.COLUNAS.SENHA} TEXT);"""

    private val deleteTableUser = "drop table if exists ${DataBaseConstants.USER.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase) {
        //Quando eu acessar o BD pela primeira vez ele vai criar o onCreate utilizando o meu script criado acima,
        //só é acessado uma vez
        db.execSQL(createTableUser)
    }

    //Quando eu fizer uma atualização do app ele vai acessar o upgrade para atuaizar o BD
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //Vou deletar e chamar a criação novamente para atualizar
        db.execSQL(deleteTableUser)
        db.execSQL(createTableUser)

        //caso seja necessário fazer muitos atualizaçoes no bd pode ser feito assim:
        //when (oldVersion){
        //    1-> {
        //       scripts verrsão 1 para 2, 2 para 3 ....
        //        }
        //  }
    }


}