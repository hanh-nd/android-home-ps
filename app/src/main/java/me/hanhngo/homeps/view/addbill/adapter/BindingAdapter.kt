package me.hanhngo.homeps.view.addbill.adapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import me.hanhngo.homeps.domain.PlayStation
import me.hanhngo.homeps.util.Resource
import me.hanhngo.homeps.view.addbill.model.PsItem
import me.hanhngo.homeps.view.home.adapter.ListBillAdapter

@BindingAdapter("playStations")
fun bindPlayStations(recyclerView: RecyclerView, psItem: Resource<List<PsItem>>?) {
    if (psItem is Resource.Success) {
        recyclerView.visibility = View.VISIBLE
        val adapter = getOrCreateAdapter(recyclerView)
        adapter.updateItems(psItem.data)
    } else {
        recyclerView.visibility = View.GONE
    }
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): PlayStationAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is PlayStationAdapter) {
        recyclerView.adapter as PlayStationAdapter
    } else {
        val adapter = PlayStationAdapter()
        recyclerView.adapter = adapter
        adapter
    }
}

@BindingAdapter("ps_id")
fun bindPsId(textView: TextView, id: Int) {
    val result = "ID: $id"
    textView.text = result
}