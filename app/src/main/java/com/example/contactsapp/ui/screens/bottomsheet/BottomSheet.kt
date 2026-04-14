package com.example.contactsapp.ui.screens.bottomsheet

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.LifecycleOwner
import com.bumptech.glide.Glide
import com.example.contactsapp.R
import com.example.contactsapp.database.MyDataBase
import com.example.contactsapp.database.entites.ContantDM
import com.example.contactsapp.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheet() : BottomSheetDialogFragment() {
   var  selectedImage: Uri? =null
    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {

            selectedImage=uri
            Glide.with(this)
                .load(uri)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(binding.imag)


        }
    }
    lateinit var binding: FragmentBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentBottomSheetBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

           initLisetner()

    }



    fun initLisetner() {

        binding.name.editText!!.doOnTextChanged { text, start, before, count ->
            binding.userName.text=text.toString()
        }
        binding.gm.editText!!.doOnTextChanged { text, start, before, count ->
            binding.gmail.text=text.toString()
        }
        binding.ph.editText!!.doOnTextChanged { text, start, before, count ->
            binding.phoneNumber.text=text.toString()
        }


      binding.but.setOnClickListener {
          while(!isvalid())return@setOnClickListener
              MyDataBase.getDataBase().getContantDoe().addUser(ContantDM(UserName = binding.name.editText!!.text.toString(),
                 Gmail =  binding.gm.editText!!.text.toString(), phoneNumber = binding.ph.editText!!.text.toString(),
                  Imag =selectedImage.toString() ))

        //  onclick()
          parentFragmentManager.setFragmentResult("content", Bundle())

          dismiss()


      }
        binding.imag.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

    }
    var flag=true
    fun isvalid(): Boolean{
        if(binding.name.editText!!.text.isEmpty())
        {
            binding.name.error="Please Enter User Name"
            flag=false
        }else
        {
            binding.name.error=null
            flag=true
        }

        if(binding.gm.editText!!.text.isEmpty())
        {
            binding.gm.error="Please Enter User Gmail"
            flag=false
        }else
        {

            binding.gm.error=null
            flag=true
        }
        if(binding.ph.editText!!.text.isEmpty())
        {
            binding.ph.error="Please Enter User Phone Number"
            flag=false
        }else
        {
            binding.ph.error=null
            flag=true
        }
        if(selectedImage==null)
        {
            Toast.makeText(activity,"Please Enter Your Image", Toast.LENGTH_LONG).show()
           flag=false
        }

        return flag

    }
}