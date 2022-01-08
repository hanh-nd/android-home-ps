package me.hanhngo.homeps

import kotlinx.coroutines.runBlocking
import me.hanhngo.homeps.view.home.BillProvider
import me.hanhngo.homeps.view.home.model.BillHeader
import me.hanhngo.homeps.view.home.model.ItemViewModel

fun main() {
    runBlocking {
        val result = compare(
            BillHeader("2021-12-24T14:30:43.106770Z"),
            BillHeader("2021-12-24T14:29:43.106770Z")
        )
        print(result)
    }
}

private fun compare(old: ItemViewModel, new: ItemViewModel): Boolean {
    return old.equals(new)
}