package me.hanhngo.homeps.view.home.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import me.hanhngo.homeps.util.DateTimeUtil
import me.hanhngo.homeps.view.home.model.ItemViewModel

@BindingAdapter("items")
fun bindItem(recyclerView: RecyclerView, itemViewModels: List<ItemViewModel>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(itemViewModels)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): ListBillAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is ListBillAdapter) {
        recyclerView.adapter as ListBillAdapter
    } else {
        val listBillAdapter = ListBillAdapter()
        recyclerView.adapter = listBillAdapter
        listBillAdapter
    }
}

@BindingAdapter("startHour")
fun bindStartHour(textView: TextView, startHour: String) {
    textView.text = DateTimeUtil.formatInstantStringToHour(startHour)
}