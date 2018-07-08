package com.padcmyanmar.mmnews.kotlin.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padcmyanmar.mmnews.kotlin.data.vos.PublicationVO

@Dao
interface PublicationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPublication(publication: PublicationVO): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPublications(publications: List<PublicationVO>): LongArray

    @Query("SELECT * FROM publication WHERE publication_id = :publicationId")
    fun getPublicationById(publicationId: String): PublicationVO
}