package me.hanhngo.homeps.view.addbill

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.domain.PlayStation
import me.hanhngo.homeps.domain.mapper.DomainMapper
import me.hanhngo.homeps.repository.PlayStationRepository
import me.hanhngo.homeps.util.Event
import me.hanhngo.homeps.util.Resource
import me.hanhngo.homeps.view.addbill.event.ListPsEvent
import me.hanhngo.homeps.view.addbill.model.PsItem
import me.hanhngo.homeps.view.addbill.model.request.PsRequest
import javax.inject.Inject

@HiltViewModel
class AddBillViewModel @Inject constructor(
    private val repository: PlayStationRepository,
    private val domainMapper: DomainMapper
) : ViewModel() {

    private var _psList = MutableLiveData<Resource<List<PsItem>>>()
    val psList: LiveData<Resource<List<PsItem>>> get() = _psList

    private var _events = MutableLiveData<Event<ListPsEvent>>()
    val events: LiveData<Event<ListPsEvent>> get() = _events

    private var _bill = MutableLiveData<Resource<Bill>>()
    val bill: LiveData<Resource<Bill>> get() = bill

    init {
        fetchPsFromNetWork()
    }

    private fun fetchPsFromNetWork() {
        viewModelScope.launch {
            repository.fetchPsFromNetwork(50).collect {
                when (it) {
                    is Resource.Loading -> _psList.value = it
                    is Resource.Success -> {
                        val item = it.data?.psList?.map { ps ->
                            domainMapper.fromDomainToPsItem(ps, ::onPsItemClickListener)
                        }
                        _psList.value = Resource.Success(item)
                    }

                    is Resource.Error -> _psList.value = Resource.Error(it.message)
                }
            }
        }

    }

    private fun onPsItemClickListener(ps: PlayStation) {
        _events.value = Event(ListPsEvent.CreateNewTurn(ps))
    }

    fun createNewTurn(ps: PlayStation) {
        viewModelScope.launch {
            repository.createNewBill(PsRequest(ps.id)).collect {
                _bill.value = it
            }
        }
    }
}