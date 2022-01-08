package me.hanhngo.homeps.view.home.adapter

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import me.hanhngo.homeps.util.DateTimeUtil
import me.hanhngo.homeps.util.Resource
import me.hanhngo.homeps.view.home.model.ItemViewModel

@BindingAdapter("items")
fun bindItem(recyclerView: RecyclerView, itemViewModels: Resource<List<ItemViewModel>>?) {
    if (itemViewModels is Resource.Success) {
        recyclerView.visibility = View.VISIBLE
        val adapter = getOrCreateAdapter(recyclerView)
        adapter.updateItems(itemViewModels.data)
    }

    else recyclerView.visibility = View.GONE
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
fun bindStartHour(textView: TextView, startTime: String) {
    textView.text = DateTimeUtil.formatInstantStringWithPattern(startTime, "hh:mm")
}

@BindingAdapter("onLoading")
fun bindLoading(view: View, itemViewModels: Resource<List<ItemViewModel>>?) {
    if (itemViewModels is Resource.Loading) {
        view.visibility = View.VISIBLE
    }

    else view.visibility = View.GONE
}

@BindingAdapter("onError")
fun bindError(view: TextView, itemViewModels: Resource<List<ItemViewModel>>?) {
    if (itemViewModels is Resource.Error) {
        view.visibility = View.VISIBLE
        view.text = itemViewModels.message
    }

    else view.visibility = View.GONE
}