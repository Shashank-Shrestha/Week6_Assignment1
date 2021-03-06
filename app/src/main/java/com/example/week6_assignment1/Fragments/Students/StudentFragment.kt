package com.example.week6_assignment1.Fragments.Students

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.week6_assignment1.R
import com.example.week6_assignment1.model.Database
import com.example.week6_assignment1.model.Student
import java.lang.Integer.TYPE

class StudentFragment : Fragment() {

  private lateinit var name: EditText
  private lateinit var age: EditText
  private lateinit var gender: RadioGroup
  private lateinit var rdoMale: RadioButton
  private lateinit var rdoFemale: RadioButton
  private lateinit var rdoOther: RadioButton
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
    rdoMale=root.findViewById(R.id.rbMale)
    rdoFemale=root.findViewById(R.id.rbFemale)
    rdoOther=root.findViewById(R.id.rbOther)
    address = root.findViewById(R.id.etAddress)
    imageURL = root.findViewById(R.id.etImageURL)
    save =root.findViewById(R.id.btnSave)

    save.setOnClickListener {
      if (isValid()){
        val database = Database()

        val checkID = gender.checkedRadioButtonId
        val checkedrb: RadioButton = root.findViewById(checkID)
        val gender = checkedrb.text.toString();
        database.appendStudent(
                Student(name.text.toString(),
                        age.text.toString().toInt(),
                        gender,
                        address.text.toString(),
                        imageURL.text.toString())
        )
        Toast.makeText(activity?.applicationContext,"Student Added",Toast.LENGTH_LONG).show()
        clearFields()
      }

    }

    return root
  }

  private fun clearFields() {
    name.setText("")
    age.setText("")
    gender.clearCheck()
    address.setText("")
    imageURL.setText("")
  }

  private fun isValid(): Boolean {
    var flag = true
    if (TextUtils.isEmpty(name.text)) {
      name.error = "Please enter Username"
      name.requestFocus()
      flag = false
    } else if (TextUtils.isEmpty(age.text)){
      age.error="Please enter age"
      age.requestFocus()
      flag = false
    } else if (TextUtils.isEmpty(address.text)){
      address.error="Please enter address"
      address.requestFocus()
      flag = false
    }else if (TextUtils.isEmpty(imageURL.text)){
      imageURL.error="Please enter image URL"
      imageURL.requestFocus()
      flag = false
    }
    return flag
  }

  fun onExit(selectionValue: String){
    val intent = Intent()
    intent.putExtra("selection",selectionValue)
    targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
  }


}



