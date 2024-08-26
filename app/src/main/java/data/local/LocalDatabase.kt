package data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import data.local.db.dao.PortfolioDao
import data.local.db.entity.PortfolioDb

@Database(
    entities = [
        PortfolioDb::class
    ],
    version = 1
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun gePortfolioDao(): PortfolioDao
}
