package nz.ac.canterbury.seng440.connect440room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import kotlinx.coroutines.flow.Flow;

@Dao
public interface FriendDao {
    @Insert
    suspend fun insert(friend: Friend): Long

    @Update
    suspend fun update(friend: Friend)

    @Delete
    suspend fun delete(friend: Friend)

    @Query("SELECT * FROM friend")
    fun getAll(): Flow<List<Friend>>

    @Query("SELECT COUNT(*) FROM friend")
    fun getCount(): Flow<Int>


}
