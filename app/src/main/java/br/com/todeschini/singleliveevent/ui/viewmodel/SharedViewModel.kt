package br.com.todeschini.singleliveevent.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.todeschini.singleliveevent.event.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {

    private val validateIfShouldGoToSecondFragment = MutableLiveData<Boolean>()
    val shouldNavigate: LiveData<Boolean>
    get() = validateIfShouldGoToSecondFragment

    private val singleLiveEventValidateIfShouldGoToSecondFragment = SingleLiveEvent<Boolean>()
    val singleLiveEventShouldNavigate: SingleLiveEvent<Boolean>
        get() = singleLiveEventValidateIfShouldGoToSecondFragment



    fun makeFakeRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            Thread.sleep(3000)
            validateIfShouldGoToSecondFragment.postValue(true)
            singleLiveEventValidateIfShouldGoToSecondFragment.postValue(true)
        }
    }
}