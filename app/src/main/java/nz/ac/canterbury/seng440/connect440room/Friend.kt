package nz.ac.canterbury.seng440.connect440room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "friend")
class Friend (@ColumnInfo var name: String,
              @ColumnInfo var slackId: String,
              @ColumnInfo var home: String,
              @ColumnInfo var email: String,
              @ColumnInfo var phone: String) {

    @PrimaryKey(autoGenerate = true) var id: Long = 0
    override fun toString() = name
}