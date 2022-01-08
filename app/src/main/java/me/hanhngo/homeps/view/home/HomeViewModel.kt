package me.hanhngo.homeps.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.util.DateTimeUtil
import me.hanhngo.homeps.view.home.model.BillHeader
import me.hanhngo.homeps.view.home.model.BillItem
import me.hanhngo.homeps.view.home.model.ItemViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val provider: BillProvider
) : ViewModel() {

    companion object {
        const val BILL_ITEM = 0
        const val BILL_HEADER = 1
    }

    private var _data = MutableLiveData<List<ItemViewModel>>()
    val data: LiveData<List<ItemViewModel>> get() = _data

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val bills = provider.getBillListData()

            val billByDate = bills
                .sortedBy { it.timeStart }
                .reversed()
                .groupBy {
                    DateTimeUtil.formatInstantStringToDate(it.timeStart)
                }

            val viewData = createViewData(billByDate)

            _data.value = viewData
        }
    }

    private fun createViewData(billByDate: Map<String, List<Bill>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()

        billByDate.keys.forEach {
            viewData.add(BillHeader(it))
            val bills = billByDate[it]
            bills?.forEach { bill ->
                val item = BillItem(
                    bill.billId,
                    bill.playStation,
                    bill.timeStart,
                    if (bill.paid) "Đã kết thúc" else "Đang chơi"
                )
                viewData.add(item)
            }
        }

        return viewData
    }

}