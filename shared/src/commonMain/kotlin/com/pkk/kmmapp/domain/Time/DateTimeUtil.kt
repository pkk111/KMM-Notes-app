package com.pkk.kmmapp.domain.Time

import kotlinx.datetime.*

object DateTimeUtil {

    fun now(): LocalDateTime {
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    }

    fun toEpocMillies(datetime: LocalDateTime): Long {
        return datetime.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()
    }

    fun formatNoteDate(datetime: LocalDateTime): String {
        val month = datetime.month.name.lowercase().take(3).replaceFirstChar { it.uppercase() }
        val date = if (datetime.dayOfMonth < 10) "0${datetime.dayOfMonth}" else datetime.dayOfMonth
        val year = datetime.year
        val hour = if (datetime.hour < 10) "0${datetime.hour}" else datetime.hour
        var min = if (datetime.minute < 10) "0${datetime.minute}" else datetime.minute

        return buildString {
            append(month)
            append(" ")
            append(date)
            append(" ")
            append(year)
            append(", ")
            append(hour)
            append(":")
            append(min)
        }
    }
}