package me.hanhngo.homeps.view.billdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.repository.BillDetailRepository
import me.hanhngo.homeps.util.Resource
import javax.inject.Inject

@HiltViewModel
class BillDetailViewModel @Inject constructor(
    private val repository: BillDetailRepository
) : ViewModel() {
    var _bill = MutableLiveData<Resource<Bill>>()
    val bill: LiveData<Resource<Bill>> get() = _bill

    fun fetchBillDetail(id: Int) {
        viewModelScope.launch {
            repository.fetchBillDetail(id).collect {
                _bill.value = it
            }
        }
    }
    fun checkout(id: Int) {
        viewModelScope.launch {
            repository.checkout(id).collect {
                _bill.value = it
            }
        }
    }
}