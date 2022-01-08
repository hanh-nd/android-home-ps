package me.hanhngo.homeps.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.hanhngo.homeps.view.home.model.BillHeader
import me.hanhngo.homeps.view.home.model.BillItem
import me.hanhngo.homeps.view.home.model.ItemViewModel

class ListBillAdapter :
    ListAdapter<ItemViewModel, ListBillAdapter.ListBillViewHolder>(DiffCallBack) {

//    var itemViewModels: List<ItemViewModel> = emptyList()
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

    class ListBillViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemViewModel) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<ItemViewModel>() {

        override fun areItemsTheSame(oldItem: ItemViewModel, newItem: ItemViewModel): Boolean {
            return if (oldItem is BillItem && newItem is BillItem) {
                oldItem.id == newItem.id
            } else if (oldItem is BillHeader && newItem is BillHeader) {
                oldItem.time == newItem.time
            } else false
        }

        override fun areContentsTheSame(oldItem: ItemViewModel, newItem: ItemViewModel): Boolean {
            return if (oldItem is BillItem && newItem is BillItem) {
                oldItem == newItem
            } else if (oldItem is BillHeader && newItem is BillHeader) {
                oldItem == newItem
            } else false
        }
    }


    fun updateItems(items: List<ItemViewModel>?) {
        val itemViewModels = items ?: emptyList()
        this.submitList(itemViewModels)
        itemViewModels.forEach { println("Hanh: $it") }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListBillViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?: 0,
            parent,
            false
        )
        return ListBillViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListBillViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        if (!viewTypeToLayoutId.containsKey(item.viewType)) {
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        return item.viewType
    }
}