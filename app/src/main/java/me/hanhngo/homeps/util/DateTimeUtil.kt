package me.hanhngo.homeps.util

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateTimeUtil {

    fun formatInstantStringToDate(time: String) : String {
        val timeInstant = Instant.parse(time)
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yy").withZone(ZoneId.of("Europe/London"))
        return formatter.format(timeInstant)
    }

    fun formatInstantStringToHour(time: String) : String {
        val timeInstant = Instant.parse(time)
        val formatter = DateTimeFormatter.ofPattern("hh:mm").withZone(ZoneId.of("Europe/London"))
        return formatter.format(timeInstant)
    }

}