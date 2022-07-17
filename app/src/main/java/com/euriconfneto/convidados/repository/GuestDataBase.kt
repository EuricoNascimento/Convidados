package com.euriconfneto.convidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.euriconfneto.convidados.constants.DataBaseConstants
import com.euriconfneto.convidados.model.GuestModel

@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDataBase : RoomDatabase() {
    abstract fun guestDAO() : GuestDAO
    companion object {
        private lateinit var INSTANCE: GuestDataBase
        fun getDatabase(context: Context): GuestDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(GuestDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, GuestDataBase::class.java, "guestdb")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}

/*class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME,  null, VERSION) {

    companion object {
        private const val NAME = "guestdb"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table " + DataBaseConstants.GUEST.TABLE_NAME + "( " +
                DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement," +
                DataBaseConstants.GUEST.COLUMNS.NAME +" text, " +
                DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer );")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}*/