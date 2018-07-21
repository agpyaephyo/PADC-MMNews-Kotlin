package com.padcmyanmar.mmnews.kotlin.data.vos

import android.arch.persistence.room.*
import android.text.TextUtils
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.mmnews.kotlin.persistence.typeconvertors.CommentActionsTypeConverter
import com.padcmyanmar.mmnews.kotlin.persistence.typeconvertors.FavoriteActionsTypeConverter
import com.padcmyanmar.mmnews.kotlin.persistence.typeconvertors.NewsImagesTypeConverter
import com.padcmyanmar.mmnews.kotlin.persistence.typeconvertors.SentToActionsTypeConverter
import java.util.ArrayList

@Entity(tableName = "news")
@TypeConverters(NewsImagesTypeConverter::class,
        FavoriteActionsTypeConverter::class,
        CommentActionsTypeConverter::class,
        SentToActionsTypeConverter::class)
class NewsVO {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @SerializedName("news-id")
    @ColumnInfo(name = "news_id")
    var newsId: String? = null

    @SerializedName("brief")
    @ColumnInfo(name = "brief")
    var brief: String? = null

    @SerializedName("details")
    @ColumnInfo(name = "details")
    var details: String? = null

    @SerializedName("images")
    @ColumnInfo(name = "images")
    var images: List<String>? = null
        get() = if (field == null) ArrayList() else field

    @SerializedName("posted-date")
    @ColumnInfo(name = "posted_date")
    var postedDate: String? = null

    @SerializedName("publication")
    @Embedded
    var publication: PublicationVO? = null

    @SerializedName("favorites")
    @ColumnInfo(name = "favorites")
    var favoriteActions: List<FavoriteActionVO>? = null
        get() = if (field == null) ArrayList() else field

    @SerializedName("comments")
    @ColumnInfo(name = "comments")
    var commentActions: List<CommentActionVO>? = null
        get() = if (field == null) ArrayList() else field

    @SerializedName("sent-tos")
    @ColumnInfo(name = "sent-tos")
    var sentToActions: List<SentToActionVO>? = null
        get() = if (field == null) ArrayList<SentToActionVO>() else field
}