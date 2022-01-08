package me.hanhngo.homeps.util

import java.text.DecimalFormat

object NumberUtil {

    fun moneyFormat(money: Int): String {
        val format = DecimalFormat("###,###,###")
        return format.format(money)
    }
}