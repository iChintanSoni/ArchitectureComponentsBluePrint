package com.chintansoni.android.architecturecomponentsblueprint.model.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Sneh on 07-03-2018.
 */
@Entity(tableName = "user")
data class User(@PrimaryKey(autoGenerate = true) var id: Long?,
                @ColumnInfo(name = "name") var name: String,
                @ColumnInfo(name = "email") var email: String,
                @ColumnInfo(name = "picture") var picture: String
) {
    constructor() : this(null, "", "", "")
}