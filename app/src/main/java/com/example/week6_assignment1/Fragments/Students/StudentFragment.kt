package com.example.week6_assignment1.Fragments.Students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.week6_assignment1.R
import com.example.week6_assignment1.model.Database
import com.example.week6_assignment1.model.Student

class StudentFragment : Fragment() {

  private lateinit var name: EditText
  private lateinit var age: EditText
  private lateinit var gender: RadioGroup
  private lateinit var address: EditText
  private lateinit var imageURL: EditText
  private lateinit var save: Button

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.fragment_studentform, container, false)

    name = root.findViewById(R.id.etStudentName)
    age = root.findViewById(R.id.etAge)
    gender = root.findViewById(R.id.rgGender)
    address = root.findViewById(R.id.etAddress)
    imageURL = root.findViewById(R.id.etImageURL)
    save =root.findViewById(R.id.btnSave)

    save.setOnClickListener {
      val database = Database()

      Database().appendStudent(
        Student(
          name.text.toString(),

        )
      )
    }




    return root

  }
}

