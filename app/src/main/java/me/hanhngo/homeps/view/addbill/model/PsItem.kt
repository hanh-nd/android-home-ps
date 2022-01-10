package me.hanhngo.homeps.view.addbill.model

import me.hanhngo.homeps.domain.PlayStation

data class PsItem(
    val ps: PlayStation,
    val onItemClick: (PlayStation) -> Unit
) {
    fun onClick() {
        onItemClick(this.ps)
    }
}