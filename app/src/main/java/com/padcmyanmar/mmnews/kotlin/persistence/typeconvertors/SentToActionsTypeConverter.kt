package com.padcmyanmar.mmnews.kotlin.persistence.typeconvertors

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.mmnews.kotlin.data.vos.SentToActionVO

class SentToActionsTypeConverter {

    @TypeConverter
    fun toString(sentToActions: List<SentToActionVO>): String {
        return Gson().toJson(sentToActions)
    }

    @TypeConverter
    fun toSentToActions(sentToActionsJson: String): List<SentToActionVO> {
        val listType = object : TypeToken<List<SentToActionVO>>() {}.type
        return Gson().fromJson(sentToActionsJson, listType)
    }
}