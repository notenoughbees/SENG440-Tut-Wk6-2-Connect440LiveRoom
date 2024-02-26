package nz.ac.canterbury.seng440.connect440room

import android.app.Application

class Connect440RoomApplication: Application() {

    // "by lazy": the variable will only be created once it is used
    val database by lazy { FriendDatabase.getDatabase(this) }
    val repository by lazy { FriendRepository(database.friendDao()) }

}