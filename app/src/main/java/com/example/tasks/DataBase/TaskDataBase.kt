package com.example.tasks.DataBase

class TaskDataBase {
    //SQLite, BD do android, tem 4 tipos dee valores: integer, real, text, blob (tipos de arquivos)

    private val createTableUser = """ CREATE TABLE ${DataBaseConstants.USER.TABLE_NAME} (
    ${DataBaseConstants.USER.COLUNAS.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
    ${DataBaseConstants.USER.COLUNAS.NOME} TEXT,
    ${DataBaseConstants.USER.COLUNAS.EMAIL} TEXT,
    ${DataBaseConstants.USER.COLUNAS.SENHA} TEXT,);"""
}