package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.Client

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        binding.handler = this
        binding.client = Client()
        return binding.root
    }

    fun signIn(view: View, client: Client) {
        navigate(view)
    }

    fun signUp(view: View, client: Client) {
        navigate(view)
    }

    private fun navigate(view: View) {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment()
        view.findNavController().navigate(action)
    }
}