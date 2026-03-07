package com.example.contactsapp.ui.screens.fragment.splashfragment

import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactsapp.R
import com.example.contactsapp.databinding.FragmentSplashBinding
import com.example.contactsapp.ui.screens.fragment.contantfragment.ContantFragment
import com.google.android.material.transition.Hold
import kotlinx.coroutines.Runnable
import java.util.logging.Handler


class SplashFragment : Fragment() {

    lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding= FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     android.os.Handler(Looper.getMainLooper()).postDelayed(Runnable {
         parentFragmentManager.beginTransaction().replace(R.id.contanerfragment, ContantFragment()).addToBackStack(null)
             .commit()

     },1000)
    }


}