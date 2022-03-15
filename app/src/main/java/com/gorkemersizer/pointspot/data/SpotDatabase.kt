package com.gorkemersizer.pointspot.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SpotEntity::class],
    version = 1
)
abstract class SpotDatabase: RoomDatabase() {

    abstract val dao: SpotDao
}