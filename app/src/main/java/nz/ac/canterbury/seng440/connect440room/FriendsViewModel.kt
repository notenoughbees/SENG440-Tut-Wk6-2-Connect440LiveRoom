package nz.ac.canterbury.seng440.connect440room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class FriendsViewModel(private val friendRepository: FriendRepository): ViewModel() {

    val friends: LiveData<List<Friend>> = friendRepository.friends.asLiveData()
    val numFriends: LiveData<Int> = friendRepository.numFriends.asLiveData()

    // executes insert() in the view model coroutine scope, using viewModelScope.launch
    // - this ensures the fun will be cancelled if the ViewModel is cleared.
    fun addFriend(friend: Friend) = viewModelScope.launch {
        friendRepository.insert(friend)
    }

}


/**
 * Factory to run for our FriendsViewModel.
 */
class FriendsViewModelFactory(private val repository: FriendRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FriendsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FriendsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}