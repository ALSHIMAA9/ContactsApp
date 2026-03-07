package com.example.contactsapp.ui.screens.fragment.contantfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.contactsapp.R
import com.example.contactsapp.database.MyDataBase
import com.example.contactsapp.database.entites.ContantDM
import com.example.contactsapp.databinding.FragmentContantBinding
import com.example.contactsapp.ui.screens.bottomsheet.BottomSheet


class ContantFragment : Fragment() {


    lateinit var binding: FragmentContantBinding
    var ContactAdapter= ContactAdapter(emptyList(),{
        MyDataBase.getDataBase().getContantDoe().deleteUser(it)
    },{refrash()})
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentContantBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initlestner()
        refrash()


    }

     fun refrash() {
        var list = MyDataBase.getDataBase().getContantDoe().getAllUser()
         if(!list.isEmpty())
         {
             binding.fabdelete.visibility= View.VISIBLE
             binding.noContact.visibility= View.GONE
         }
         else{
             binding.fabdelete.visibility= View.GONE
             binding.noContact.visibility= View.VISIBLE
         }
         if(list.size>=6)
         {
             binding.fabadd.visibility= View.GONE
         }
         else{
             binding.fabadd.visibility= View.VISIBLE
         }
        ContactAdapter.contactDM = list
        binding.RecycleView.adapter = ContactAdapter
        ContactAdapter.notifyDataSetChanged()


     }

    private fun initlestner() {
      binding.fabadd.setOnClickListener {
          var bottomsheet= BottomSheet(
              {
                  refrash()
              }
          )
          bottomsheet.show(parentFragmentManager,null)
      }
        binding.fabdelete.setOnClickListener {
            var lastItemAdded= MyDataBase.getDataBase().getContantDoe().getMaxId()
            MyDataBase.getDataBase().getContantDoe().deleteUser(lastItemAdded)
            refrash()
        }


    }
}