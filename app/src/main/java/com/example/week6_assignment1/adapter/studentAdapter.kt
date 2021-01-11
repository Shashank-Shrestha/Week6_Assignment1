package com.example.week6_assignment1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week6_assignment1.R
import com.example.week6_assignment1.model.Student
import de.hdodenhof.circleimageview.CircleImageView

class studentAdapter (
    val listStudents:MutableList<Student>,
    val context:Context
):RecyclerView.Adapter<studentAdapter.StudentViewHolder>(){
    class StudentViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name:TextView
        val age: TextView
        val gender: TextView
        val address : TextView
        val userImage: CircleImageView

        init {
            name = view.findViewById(R.id.tvName)
            age = view.findViewById(R.id.tvAge)
            gender= view.findViewById(R.id.tvGender)
            address=view.findViewById(R.id.tvAddress)
            userImage=view.findViewById(R.id.imgProfile)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var info = listStudents[position]
        holder.name.setText(info.name)
        holder.age.setText(info.age.toString())
        holder.gender.setText(info.gender)
        holder.address.setText(info.address)

        Glide.with(context)
                .load(info?.imageURL)
                .into(holder.userImage)
    }

    override fun getItemCount(): Int {
        return listStudents.size
    }
}

