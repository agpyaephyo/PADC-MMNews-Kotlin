package com.padcmyanmar.mmnews.kotlin.data.vos

import android.arch.persistence.room.*
import android.text.TextUtils
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.mmnews.kotlin.persistence.typeconvertors.NewsImagesTypeConvertor
import java.util.ArrayList

@Entity(tableName = "news")
@TypeConverters(NewsImagesTypeConvertor::class)
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
    @Ignore
    var publication: PublicationVO? = null

    @ColumnInfo(name = "publication_id")
    var publicationId: String? = null
        get() {
            if (TextUtils.isEmpty(field)) {
                this.publicationId = publication!!.publicationId
            }
            return field
        }

    @SerializedName("favorites")
    @Ignore
    var favoriteActions: List<FavoriteActionVO>? = null
        get() = if (field == null) ArrayList() else field

    @SerializedName("comments")
    @Ignore
    var commentActions: List<CommentActionVO>? = null
        get() = if (field == null) ArrayList() else field

    @SerializedName("sent-tos")
    @Ignore
    var sentToActions: List<SentToActionVO>? = null
        get() = if (field == null) ArrayList<SentToActionVO>() else field
}