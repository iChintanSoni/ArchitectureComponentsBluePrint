package com.chintansoni.android.architecturecomponentsblueprint.model.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.chintansoni.android.architecturecomponentsblueprint.model.database.entity.User

/**
 * Created by Sneh on 07-03-2018.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUserData(): LiveData<User>

    @Insert(onConflict = REPLACE)
    fun insert(user: User)

    @Query("DELETE * FROM user")
    fun deleteAllUserData()
}