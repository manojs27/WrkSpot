package com.manoj.wrkspot.data.db

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.manoj.wrkspot.R
import com.manoj.wrkspot.data.model.Country
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.lang.Exception

class PopulateRoomCallback(private val context: Context) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        CoroutineScope(Dispatchers.IO).launch {
            prePopulateUsers(context)
        }
    }

    suspend fun prePopulateUsers(context: Context) {
        try {
            val countryDao = CountryDb.getDatabase(context).countryDao()
            val userList: JSONArray =
                context.resources.openRawResource(R.raw.country).bufferedReader().use {
                    JSONArray(it.readText())
                }
            userList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val countryObj = list.getJSONObject(index)
                    val mediaObject = countryObj.getJSONObject("media")
                    countryDao.insertCountry(
                        Country(
                            countryObj.getInt("id"),
                            countryObj.getString("abbreviation"),
                            countryObj.getString("capital"),
                            countryObj.getString("currency"),
                            countryObj.getString("name"),
                            countryObj.getString("phone"),
                            countryObj.optLong("population", 0),
                            mediaObject.getString("flag")
                        )
                    )
                }
            }
        } catch (exception: Exception) {
            Log.d("ileana", exception.message.toString())
            Log.e(
                "App",
                exception.localizedMessage ?: "failed to pre-populate users into database"
            )
        }
    }
}