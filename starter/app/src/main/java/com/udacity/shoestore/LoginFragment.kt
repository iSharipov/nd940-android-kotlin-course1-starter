package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class LoginFragment : Fragment() {

    private lateinit var signInButton: Button
    private lateinit var signUpButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_login, container, false)
        return inflater.inflate(R.layout.fragment_login, container, false).apply {
            signInButton = findViewById(R.id.button_sign_in)
            signUpButton = findViewById(R.id.button_sign_up)

            signInButton.setOnClickListener {
                navigate(it)
            }
            signUpButton.setOnClickListener {
                navigate(it)
            }
        }
    }

    private fun navigate(view: View) {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment()
        view.findNavController().navigate(action)
    }
}