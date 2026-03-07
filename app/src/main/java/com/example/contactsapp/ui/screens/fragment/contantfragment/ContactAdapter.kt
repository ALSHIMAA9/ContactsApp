package com.example.contactsapp.ui.screens.fragment.contantfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.R
import com.example.contactsapp.database.entites.ContantDM
import com.example.contactsapp.databinding.ContactItemBinding

class ContactAdapter(var contactDM: List<ContantDM>,var deleteonclick:(ContantDM: ContantDM)->Unit,var refrash:()->Unit): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
   lateinit var binding: ContactItemBinding
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
       binding= ContactItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) {
       var list=contactDM[position]
        Glide.with(holder.itemView.context)
            .load(list.Imag)
            .into(holder.binding.mg)
        binding.phon.text=list.phoneNumber
        binding.name.text=list.UserName
        binding.gmail.text=list.Gmail
        binding.deletebut.setOnClickListener {
            deleteonclick(list)
            refrash()

        }
    }

    override fun getItemCount(): Int {
        return contactDM.size
    }



    class ContactViewHolder(val binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root)
}