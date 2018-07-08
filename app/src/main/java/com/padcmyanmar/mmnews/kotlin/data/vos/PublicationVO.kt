package com.padcmyanmar.mmnews.kotlin.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "publication")
class PublicationVO {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @SerializedName("publication-id")
    @ColumnInfo(name = "publication_id")
    var publicationId: String? = null

    @SerializedName("title")
    @ColumnInfo(name = "title")
    var title: String? = null

    @SerializedName("logo")
    @ColumnInfo(name = "logo")
    var logo: String? = null
}