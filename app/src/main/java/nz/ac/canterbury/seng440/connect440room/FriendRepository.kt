package nz.ac.canterbury.seng440.connect440room

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


class FriendRepository(private val friendDao: FriendDao) {
    val friends: Flow<List<Friend>> = friendDao.getAll()
    val numFriends: Flow<Int> = friendDao.getCount()

//    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(friend: Friend) {
        friendDao.insert(friend)
    }


}