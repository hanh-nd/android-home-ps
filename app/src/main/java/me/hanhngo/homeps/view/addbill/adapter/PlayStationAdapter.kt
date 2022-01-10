package me.hanhngo.homeps.view.addbill.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.hanhngo.homeps.BR
import me.hanhngo.homeps.databinding.PsItemBinding
import me.hanhngo.homeps.view.addbill.model.PsItem

class PlayStationAdapter :
    ListAdapter<PsItem, PlayStationAdapter.PlayStationViewHolder>(DiffCallBack) {

    class PlayStationViewHolder(private val binding: PsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PsItem) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<PsItem>() {
        override fun areItemsTheSame(oldItem: PsItem, newItem: PsItem): Boolean {
            return oldItem.ps.id == newItem.ps.id
        }

        override fun areContentsTheSame(oldItem: PsItem, newItem: PsItem): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayStationViewHolder {
        val binding: PsItemBinding = PsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlayStationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayStationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun updateItems(playStation: List<PsItem>?) {
        val list = playStation ?: emptyList()
        this.submitList(list)
        notifyDataSetChanged()
    }
}