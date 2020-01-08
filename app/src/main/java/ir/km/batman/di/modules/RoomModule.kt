package ir.km.batman.di.modules

import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Reusable
import ir.km.batman.App
import ir.km.batman.db.BatmanDb


@Module
object RoomModule {

    @Reusable
    @Provides
    fun provideDataBase(app: App) : BatmanDb =
        Room.databaseBuilder<BatmanDb>(app , BatmanDb::class.java , "BatmanDatabase.db").build()
}