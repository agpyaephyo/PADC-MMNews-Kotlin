package com.padcmyanmar.mmnews.kotlin.persistence.typeconvertors

import android.arch.persistence.room.TypeConverter
import java.util.*

class NewsImagesTypeConverter {

    @TypeConverter
    fun toStringList(imagesCommaSeparated: String): List<String> {
        return imagesCommaSeparated.split(",".toRegex())
    }

    @TypeConverter
    fun toString(imageList: List<String>): String {
        val stringBuilder = StringBuilder()
        for (image in imageList) {
            stringBuilder.append(image).append(",")
        }
        if (stringBuilder.length > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length - 1)
        }
        return stringBuilder.toString()
    }
}