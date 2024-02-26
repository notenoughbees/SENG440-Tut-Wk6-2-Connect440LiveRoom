package nz.ac.canterbury.seng440.connect440room;

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.jvm.Volatile

@Database(entities = [Friend::class], version = 1)
abstract class FriendDatabase : RoomDatabase() {

    abstract fun friendDao(): FriendDao

    companion object {
        // Singleton pattern to prevent multiple instances of database being open at once
        @Volatile
        private var INSTANCE: FriendDatabase? = null
        fun getDatabase(context: Context): FriendDatabase {
            // if the instance is not null, return it, else, create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder( // create the database using Room's db builder to create a RoomDatabase object...
                    context.applicationContext,      // ...in the application context...
                    FriendDatabase::class.java,      // ...from the FriendDatabase object...
                    "friend_database"           // ...and name it "friend_database".
                ).build()
                INSTANCE = instance
                // return the instance
                instance
            }
        }
    }


}
