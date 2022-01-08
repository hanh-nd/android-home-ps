package me.hanhngo.homeps.view.home.model

import androidx.annotation.LayoutRes

interface ItemViewModel {
    @get:LayoutRes
    val layoutId: Int
    val viewType: Int
        get() = 0
}