package me.hanhngo.homeps.util

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateTimeUtil {

    fun formatInstantStringWithPattern(time: String, pattern: String) : String {
        val timeInstant = Instant.parse(time)
        val formatter = DateTimeFormatter.ofPattern(pattern).withZone(ZoneId.of("Europe/London"))
        return formatter.format(timeInstant)
    }
}