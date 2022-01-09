package me.hanhngo.homeps.view.billdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.hanhngo.homeps.BR
import me.hanhngo.homeps.databinding.ServiceItemBinding
import me.hanhngo.homeps.domain.OrderService

class OrderServiceAdapter :
    ListAdapter<OrderService, OrderServiceAdapter.OrderServiceViewHolder>(DiffCallBack) {

    companion object DiffCallBack : DiffUtil.ItemCallback<OrderService>() {
        override fun areItemsTheSame(oldItem: OrderService, newItem: OrderService): Boolean {
            return oldItem.service == newItem.service
        }

        override fun areContentsTheSame(oldItem: OrderService, newItem: OrderService): Boolean {
            return oldItem == newItem
        }
    }

    class OrderServiceViewHolder(private val binding: ServiceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(orderService: OrderService) {
            binding.setVariable(BR.orderService, orderService)
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderServiceViewHolder {
        return OrderServiceViewHolder(
            ServiceItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OrderServiceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun updateItems(orderServices: List<OrderService>) {
        this.submitList(orderServices)
        notifyDataSetChanged()
    }
}