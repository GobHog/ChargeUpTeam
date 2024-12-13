package com.example.chargeup

import android.content.ContentValues
import android.content.Context
import android.util.Log


class DatabaseOperations(context: Context?) {
    private val dbHelper = DatabaseHelper(context)

    // Метод для добавления записи в таблицу "зарядка"
    fun addZaryadka(name: String?) {
        val db = dbHelper.writableDatabase

        val values = ContentValues()
        values.put(DatabaseHelper.COLUMN_NAME, name)

        db.insert(DatabaseHelper.TABLE_ZARYADKA, null, values)
        db.close()
    }

    // Метод для добавления записи в таблицу "упражнение"
    fun addUprajnyenie(name: String?, zaryadkaId: Int) {
        val db = dbHelper.writableDatabase

        val values = ContentValues()
        values.put(DatabaseHelper.COLUMN_UPRAJNYENIE_NAME, name)
        values.put(DatabaseHelper.COLUMN_ZARYADKA_ID, zaryadkaId)

        db.insert(DatabaseHelper.TABLE_UPRAJNYENIE, null, values)
        db.close()
    }
    // Метод для удаления записи по ID из таблицы "зарядка"
    fun deleteZaryadka(id: Int) {
        val db = dbHelper.writableDatabase

        // Удаляем запись по ID
        val rowsDeleted = db.delete(
            DatabaseHelper.TABLE_ZARYADKA,
            "${DatabaseHelper.COLUMN_ID} = ?",
            arrayOf(id.toString())
        )

        if (rowsDeleted > 0) {
            Log.d("DatabaseOperations", "Record with ID $id deleted successfully.")
        } else {
            Log.d("DatabaseOperations", "No record found with ID $id.")
        }

        db.close()
    }
}