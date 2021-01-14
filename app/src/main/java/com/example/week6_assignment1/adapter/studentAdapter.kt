package com.example.week6_assignment1.adapter

import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week6_assignment1.Fragments.Students.StudentFragment
import com.example.week6_assignment1.Fragments.home.HomeFragment
import com.example.week6_assignment1.R
import com.example.week6_assignment1.model.Database
import com.example.week6_assignment1.model.Student
import de.hdodenhof.circleimageview.CircleImageView
import kotlin.reflect.typeOf

private var database = Database()
private var listStudents = database.returnStudent()
class studentAdapter(
        val context:Context):RecyclerView.Adapter<studentAdapter.StudentViewHolder>(){
    class StudentViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name:TextView
        val age: TextView
        val gender: TextView
        val address : TextView
        val userImage: CircleImageView
        val delButton : ImageButton


        init {
            name = view.findViewById(R.id.tvName)
            age = view.findViewById(R.id.tvAge)
            gender= view.findViewById(R.id.tvGender)
            address=view.findViewById(R.id.tvAddress)
            userImage=view.findViewById(R.id.imgProfile)
            delButton = view.findViewById(R.id.ibDelete)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var info = listStudents.asReversed()[position]
        holder.name.setText(info.name)
        holder.age.setText(info.age.toString())
        holder.gender.setText(info.gender)
        holder.address.setText(info.address)

        holder.delButton.setOnClickListener(View.OnClickListener {
            listStudents.remove(info)
            notifyItemRemoved(position)
            Toast.makeText(context, "Student Deleted", Toast.LENGTH_LONG).show()
        })

        Glide.with(context)
                .load(info?.imageURL)
                .into(holder.userImage)
    }

    override fun getItemCount(): Int {
        return listStudents.size
    }

}

