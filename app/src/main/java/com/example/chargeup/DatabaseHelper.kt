package com.example.chargeup

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        // Создание таблиц
        db.execSQL(CREATE_TABLE_ZARYADKA)
        db.execSQL(CREATE_TABLE_UPRAJNYENIE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Если версия базы данных изменяется, удаляем старую и создаём новую
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UPRAJNYENIE)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ZARYADKA)
        onCreate(db)
    }

    companion object {
        // Имя базы данных
        const val DATABASE_NAME = "exercise_db"
        const val DATABASE_VERSION = 1

        // Названия таблиц и столбцов
        const val TABLE_ZARYADKA = "зарядка"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "название"

        const val TABLE_UPRAJNYENIE = "упражнение"
        const val COLUMN_UPRAJNYENIE_ID = "id"
        const val COLUMN_UPRAJNYENIE_NAME = "название"
        const val COLUMN_ZARYADKA_ID = "зарядка_id" // Внешний ключ

        // SQL запрос для создания таблицы "зарядка"
        const val CREATE_TABLE_ZARYADKA = ("CREATE TABLE " + TABLE_ZARYADKA + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT NOT NULL"
                + ");")

        // SQL запрос для создания таблицы "упражнение"
        const val CREATE_TABLE_UPRAJNYENIE = ("CREATE TABLE " + TABLE_UPRAJNYENIE + " ("
                + COLUMN_UPRAJNYENIE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_UPRAJNYENIE_NAME + " TEXT NOT NULL, "
                + COLUMN_ZARYADKA_ID + " INTEGER, "
                + "FOREIGN KEY (" + COLUMN_ZARYADKA_ID + ") REFERENCES " + TABLE_ZARYADKA + " (" + COLUMN_ID + ")"
                + ");")
    }
}