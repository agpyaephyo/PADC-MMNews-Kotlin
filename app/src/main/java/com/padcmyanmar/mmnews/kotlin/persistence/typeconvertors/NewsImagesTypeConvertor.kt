package com.padcmyanmar.mmnews.kotlin.persistence.typeconvertors

import android.arch.persistence.room.TypeConverter
import java.util.*

object NewsImagesTypeConvertor {

    @TypeConverter
    fun toStringList(imagesCommaSeparated: String): List<String> {
        val imagesArray = imagesCommaSeparated.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return Arrays.asList(*imagesArray)
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