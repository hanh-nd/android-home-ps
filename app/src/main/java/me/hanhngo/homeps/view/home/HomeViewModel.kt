package me.hanhngo.homeps.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.mapper.domain.DomainMapper
import me.hanhngo.homeps.repository.ListBillRepository
import me.hanhngo.homeps.util.DateTimeUtil
import me.hanhngo.homeps.util.Event
import me.hanhngo.homeps.util.Resource
import me.hanhngo.homeps.view.home.event.ListBillEvent
import me.hanhngo.homeps.view.home.model.BillHeader
import me.hanhngo.homeps.view.home.model.BillItem
import me.hanhngo.homeps.view.home.model.ItemViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ListBillRepository,
    private val domainMapper: DomainMapper
) : ViewModel() {

    companion object {
        const val BILL_ITEM = 0
        const val BILL_HEADER = 1
    }

    private var _data = MutableLiveData<Resource<List<ItemViewModel>>>()
    val data: LiveData<Resource<List<ItemViewModel>>> get() = _data

    val events: LiveData<Event<ListBillEvent>>
        get() = _events
    private val _events = MutableLiveData<Event<ListBillEvent>>()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            repository.fetchBillFromNetwork().collect {
                if (it is Resource.Loading) _data.value = it

                if (it is Resource.Success) {
                    val bills = it.data?.map { bill ->
                        domainMapper.fromDomainToBillItem(bill, ::onBillClickListener)
                    }

                    val billByDate = bills?.groupBy { item ->
                        DateTimeUtil.formatInstantStringWithPattern(item.bill.startTime, "dd/MM/yy")
                    }

                    val viewData = createViewData(billByDate)

                    _data.value = viewData
                }

                if (it is Resource.Error) _data.value = Resource.Error(it.message)
            }
        }
    }

    private fun createViewData(billByDate: Map<String, List<BillItem>>?): Resource<List<ItemViewModel>> {
        val viewData = mutableListOf<ItemViewModel>()

        billByDate?.keys?.forEach {
            viewData.add(BillHeader(it))
            val bills = billByDate[it]
            bills?.forEach { bill ->
                viewData.add(bill)
            }
        }

        return Resource.Success(viewData)
    }

    private fun onBillClickListener(bill: Bill) {
        _events.value = Event(ListBillEvent.ShowBillDetail(bill))
    }
}