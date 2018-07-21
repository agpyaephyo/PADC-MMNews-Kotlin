package com.padcmyanmar.mmnews.kotlin.persistence.typeconvertors

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.mmnews.kotlin.data.vos.FavoriteActionVO

class FavoriteActionsTypeConverter {

    @TypeConverter
    fun toString(favoriteActions : List<FavoriteActionVO>) : String {
        return Gson().toJson(favoriteActions)
    }

    @TypeConverter
    fun toFavoriteActions(favoriteActionsJson : String) : List<FavoriteActionVO> {
        val listType = object : TypeToken<List<FavoriteActionVO>>() {}.type
        return Gson().fromJson(favoriteActionsJson, listType)
    }
}