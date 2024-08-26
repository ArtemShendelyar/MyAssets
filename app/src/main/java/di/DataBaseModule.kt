package di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import data.local.LocalDatabase
import data.local.db.dao.PortfolioDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    @Singleton
    fun provideApplicationDb(@ApplicationContext context: Context): LocalDatabase {
        return Room.databaseBuilder(
            context,
            LocalDatabase::class.java,
            "my_assets"
        ).build()
    }

    @Provides
    fun providePortfolioDao(localDatabase: LocalDatabase): PortfolioDao {
        return localDatabase.gePortfolioDao()
    }
}
