package me.hanhngo.homeps.view.billdetail.adapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.util.DateTimeUtil
import me.hanhngo.homeps.util.NumberUtil
import me.hanhngo.homeps.util.Resource

@BindingAdapter("services")
fun bindServices(recyclerView: RecyclerView, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        if (bill.data?.services?.isNotEmpty() == true) {
            recyclerView.visibility = View.VISIBLE
            val adapter = getOrCreateAdapter(recyclerView)
            adapter.updateItems(bill.data.services)
        }
    } else recyclerView.visibility = View.GONE
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): OrderServiceAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is OrderServiceAdapter) {
        recyclerView.adapter as OrderServiceAdapter
    } else {
        val listBillAdapter = OrderServiceAdapter()
        recyclerView.adapter = listBillAdapter
        listBillAdapter
    }
}

@BindingAdapter("quantity")
fun bindQuantity(textView: TextView, quantity: Int) {
    val result = "x$quantity"
    textView.text = result
}

@BindingAdapter("total_price")
fun bindTotalPrice(textView: TextView, price: Int) {
    val result = "${NumberUtil.moneyFormat(price)} đ"
    textView.text = result
}

@BindingAdapter("bill_id")
fun bindBillId(textView: TextView, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        val result = "Mã hoá đơn: ${bill.data?.id}"
        textView.text = result
    }
}

@BindingAdapter("ps_id")
fun bindPsId(textView: TextView, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        val result = "Mã máy: ${bill.data?.ps?.id}"
        textView.text = result
    }
}

@BindingAdapter("startTime")
fun bindStartTime(textView: TextView, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        val result =
            "Bắt đầu: ${DateTimeUtil.formatInstantStringWithPattern(bill.data?.startTime!!, "hh:mm, dd/MM/yy")}"
        textView.text = result
    }
}

@BindingAdapter("endTime")
fun bindEndTime(textView: TextView, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        if (bill.data?.endTime == null)
            textView.text = "Kết thúc: Chưa kết thúc"
        else {
            val result =
                "Kết thúc: ${DateTimeUtil.formatInstantStringWithPattern(bill.data.endTime, "hh:mm, dd/MM/yy")}"
            textView.text = result
        }
    }
}

@BindingAdapter("price")
fun bindPrice(textView: TextView, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        if (bill.data?.price == null)
            textView.text = "Thành tiền: Chưa kết thúc"
        else {
            val result = "Thành tiền: ${NumberUtil.moneyFormat(bill.data.price)} đ"
            textView.text = result
        }
    }

}

@BindingAdapter("isPaidGone")
fun bindIsPaidGone(view: View, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        if (bill.data?.paid == true) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
        }
    }
}

@BindingAdapter("isPaidVisible")
fun bindIsPaidVisible(view: View, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        if (bill.data?.paid == true) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }
}


@BindingAdapter("discount")
fun bindDiscount(textView: TextView, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        if (bill.data?.event == null) {
            textView.text = "Giảm giá: 0%"
        } else {
            val result = "Giảm giá: ${bill.data.event.percentDiscount}%"
            textView.text = result
        }
    }
}

@BindingAdapter("playedTime")
fun bindPlayedTime(textView: TextView, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        val result = "Thời gian chơi: ${bill.data?.totalHourPlayed}h"
        textView.text = result
    }

}

@BindingAdapter("serviceTitle")
fun bindServiceTitle(textView: TextView, bill: Resource<Bill>) {
    if (bill is Resource.Success) {
        if (bill.data?.services?.isEmpty() == true) {
            textView.text = "Dịch vụ: Không có"
        } else {
            textView.text = "Dịch vụ:"
        }
    }
}