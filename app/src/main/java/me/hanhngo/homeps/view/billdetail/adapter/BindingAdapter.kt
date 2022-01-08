package me.hanhngo.homeps.view.billdetail.adapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import me.hanhngo.homeps.util.DateTimeUtil
import me.hanhngo.homeps.util.NumberUtil

@BindingAdapter("quantity")
fun bindQuantity(textView: TextView, quantity: Int) {
    textView.text = "x$quantity"
}

@BindingAdapter("total_price")
fun bindTotalPrice(textView: TextView, price: Int) {
    textView.text = "${price} đ"
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

@BindingAdapter("isPaid")
fun bindIsPaid(view: View, paid: Boolean) {
    if (paid) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}