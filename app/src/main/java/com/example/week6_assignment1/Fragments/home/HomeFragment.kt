package com.example.week6_assignment1.Fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6_assignment1.MainActivity
import com.example.week6_assignment1.R
import com.example.week6_assignment1.adapter.studentAdapter
import com.example.week6_assignment1.model.Database
import com.example.week6_assignment1.model.Student

class HomeFragment : Fragment() {
  private var layoutManager: RecyclerView.LayoutManager? = null
  private var adapter: RecyclerView.Adapter<studentAdapter.StudentViewHolder>? = null
  private lateinit var details: RecyclerView
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.fragment_home, container, false)
    details = root.findViewById(R.id.rvDetails)



    return root
  }
  override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
    super.onViewCreated(itemView, savedInstanceState)
    details.apply {
      layoutManager = LinearLayoutManager(activity)
      adapter = studentAdapter(context)
    }
  }

}

