package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentWelcomeScreenBinding>(inflater, R.layout.fragment_welcome_screen, container, false)
        binding.handler = this
        return binding.root
    }

    fun navigate(view: View) {
        val action = WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionFragment()
        view.findNavController().navigate(action)
    }
}
