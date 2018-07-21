package com.padcmyanmar.mmnews.kotlin.persistence.typeconvertors

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.mmnews.kotlin.data.vos.CommentActionVO

class CommentActionsTypeConverter {

    @TypeConverter
    fun toString(commentActions: List<CommentActionVO>): String {
        return Gson().toJson(commentActions)
    }

    @TypeConverter
    fun toCommentActions(commentActionsJson: String): List<CommentActionVO> {
        val listType = object : TypeToken<List<CommentActionVO>>() {}.type
        return Gson().fromJson(commentActionsJson, listType)
    }
}