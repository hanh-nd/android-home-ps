package me.hanhngo.homeps

import kotlinx.coroutines.runBlocking
import me.hanhngo.homeps.util.DateTimeUtil
import me.hanhngo.homeps.view.home.model.BillHeader
import me.hanhngo.homeps.view.home.model.ItemViewModel

fun main() {
    runBlocking {
        val data = BillHeader("2021-12-24T14:30:43.106770Z")
        print(DateTimeUtil.formatInstantStringToHour(data.time))
    }
}

private fun compare(old: ItemViewModel, new: ItemViewModel): Boolean {
    return old.equals(new)
}