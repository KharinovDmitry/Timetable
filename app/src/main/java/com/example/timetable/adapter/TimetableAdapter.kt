package com.example.timetable.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetable.databinding.ItemTimetableBinding
import com.example.timetable.domain.Lesson

class TimetableAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data = listOf<Lesson>()

    fun setValue(list: List<Lesson>) : Boolean {
        data = list
        notifyDataSetChanged()
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ItemTimetableBinding.inflate(view, parent, false)

        return TimetableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      if (holder is TimetableViewHolder) {
          holder.bind(data[position])
      }
    }

    override fun getItemCount(): Int = data.size

    inner class TimetableViewHolder(private val binding: ItemTimetableBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(lesson: Lesson) {
            binding.classTitle.text = lesson.title
            binding.classDate.text = lesson.date.toString()
            binding.classTime.text = lesson.time.toString()
            binding.classLecturer.text = lesson.lecturer
            binding.classAuditorium.text = lesson.auditorium
        }
    }
}
