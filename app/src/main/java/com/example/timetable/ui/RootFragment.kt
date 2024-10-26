package com.example.timetable.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timetable.R
import com.example.timetable.adapter.TimetableAdapter
import com.example.timetable.client.getTodayLessons
import com.example.timetable.client.getWeekLessons
import com.example.timetable.databinding.RootFragmentBinding

class RootFragment : Fragment(R.layout.root_fragment) {
    private lateinit var binding: RootFragmentBinding

    private val timetableAdapter = TimetableAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RootFragmentBinding.inflate(inflater, container, false)
        setupBottomNavigation()
        return binding.root
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_today -> timetableAdapter.setValue(getTodayLessons())
                else -> timetableAdapter.setValue(getWeekLessons())
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.lessons) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = timetableAdapter
        }

        timetableAdapter.setValue(getWeekLessons())
    }
}
