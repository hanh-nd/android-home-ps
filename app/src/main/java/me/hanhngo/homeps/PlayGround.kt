package me.hanhngo.homeps

import kotlinx.coroutines.runBlocking
import me.hanhngo.homeps.util.DateTimeUtil
import me.hanhngo.homeps.view.home.model.BillHeader
import me.hanhngo.homeps.view.home.model.ItemViewModel

fun main() {
    runBlocking {

    }
}

private fun compare(old: ItemViewModel, new: ItemViewModel): Boolean {
    return old.equals(new)
}