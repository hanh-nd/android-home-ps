package me.hanhngo.homeps.view.billdetail.adapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import me.hanhngo.homeps.domain.Bill
import me.hanhngo.homeps.domain.Event
import me.hanhngo.homeps.util.DateTimeUtil
import me.hanhngo.homeps.util.NumberUtil
import me.hanhngo.homeps.util.Resource
import me.hanhngo.homeps.domain.OrderService

@BindingAdapter("services")
fun bindServices(recyclerView: RecyclerView, orderServices: List<OrderService>) {
    if (orderServices.isNotEmpty()){
        recyclerView.visibility = View.VISIBLE
        val adapter = getOrCreateAdapter(recyclerView)
        adapter.updateItems(orderServices)
    }
    else recyclerView.visibility = View.GONE
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
    println("Hanh: quantity $quantity")
    val result = "x$quantity"
    textView.text = result
}

@BindingAdapter("total_price")
fun bindTotalPrice(textView: TextView, price: Int) {
    val result = "${NumberUtil.moneyFormat(price)} đ"
    textView.text = result
}

@BindingAdapter("bill_id")
fun bindBillId(textView: TextView, id: Int) {
    val result = "Mã hoá đơn: $id"
    textView.text = result
}

@BindingAdapter("ps_id")
fun bindPsId(textView: TextView, id: Int) {
    val result = "Mã máy: $id"
    textView.text = result
}

@BindingAdapter("startTime")
fun bindStartTime(textView: TextView, timeStart: String) {
    val result = "Bắt đầu: ${DateTimeUtil.formatInstantStringWithPattern(timeStart, "hh:mm, dd/MM/yy")}"
    textView.text = result
}

@BindingAdapter("endTime")
fun bindEndTime(textView: TextView, timeEnd: String?) {
    if (timeEnd == null)
        textView.text = "Kết thúc: Chưa kết thúc"
    else {
        val result = "Kết thúc: ${DateTimeUtil.formatInstantStringWithPattern(timeEnd, "hh:mm, dd/MM/yy")}"
        textView.text = result
    }
}

@BindingAdapter("price")
fun bindEndTime(textView: TextView, price: Int?) {
    if (price == null)
        textView.text = "Thành tiền: Chưa kết thúc"
    else {
        val result = "Thành tiền: ${NumberUtil.moneyFormat(price)} đ"
        textView.text = result
    }
}

@BindingAdapter("isPaidGone")
fun bindIsPaidGone(view: View, paid: Boolean) {
    if (paid) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter("isPaidVisible")
fun bindIsPaidVisible(view: View, paid: Boolean) {
    if (!paid) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}



@BindingAdapter("discount")
fun bindDiscount(textView: TextView, event: Event?) {
    if (event == null) {
        textView.text = "Giảm giá: 0%"
    } else {
        val result = "Giảm giá: ${event.percentDiscount}%"
        textView.text = result
    }
}

@BindingAdapter("playedTime")
fun bindPlayedTime(textView: TextView, playedTime: Double) {
    val result = "Thời gian chơi: ${playedTime}h"
    textView.text = result
}

@BindingAdapter("serviceTitle")
fun bindServiceTitle(textView: TextView, bill: Bill) {
    if (bill.services.isEmpty()) {
        textView.text = "Dịch vụ: Không có"
    } else {
        textView.text = "Dịch vụ:"
    }
}