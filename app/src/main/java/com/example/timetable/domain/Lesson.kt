package com.example.timetable.domain

import java.sql.Time
import java.util.Date

class Lesson(
    val title: String,
    val date: Date,
    val time: Time,
    val lecturer: String,
    val auditorium: String
)