package com.example.timetable.client

import com.example.timetable.domain.Lesson
import java.sql.Time
import java.time.LocalDate
import java.util.Date

fun getWeekLessons(): List<Lesson> {
    return listOf(
        Lesson("kotlin", Date(2024, 10, 21), Time(15, 0, 0), "Верегин", "132"),
        Lesson("kotlin", Date(2024, 10, 22), Time(15, 0, 0), "Верегин", "132"),
        Lesson("kotlin", Date(2024, 10, 23), Time(15, 0, 0), "Верегин", "132"),
        Lesson("kotlin", Date(2024, 10, 24), Time(15, 0, 0), "Верегин", "132"),
        Lesson("kotlin", Date(2024, 10, 25), Time(15, 0, 0), "Верегин", "132"),
    )
}

fun getTodayLessons(): List<Lesson> {
    return listOf(
        Lesson("kotlin", Date(LocalDate.now().year, LocalDate.now().monthValue, LocalDate.now().dayOfMonth), Time(15, 0, 0), "Верегин", "132"),
    )
}