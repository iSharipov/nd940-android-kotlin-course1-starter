package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.Client

class LoginFragment : Fragment() {

    private companion object {
        const val SESSION: String = "SESSION"
        const val EMAIL: String = "EMAIL"
        const val PASSWORD: String = "PASSWORD"
        const val LOGGED: String = "LOGGED"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = this
        val sharedPreferences = activity?.getSharedPreferences(SESSION, Context.MODE_PRIVATE)
        val isLogged = sharedPreferences?.getBoolean(LOGGED, false) ?: false
        if (isLogged) {
            navigateToShoesScreen()
        }
        val clientViewModel: Client by activityViewModels()
        binding.handler = this
        binding.client = clientViewModel
        return binding.root
    }

    fun signIn(view: View, client: Client) {
        val sharedPreferences = activity?.getSharedPreferences(SESSION, Context.MODE_PRIVATE)
        sharedPreferences?.getString(EMAIL, "")?.let { email ->
            if (email == client.email.get()) {
                sharedPreferences.getString(PASSWORD, "")?.let { password ->
                    if (password == client.password.get()) {
                        navigateToWelcomeScreen(view)
                    }
                }
            }
        }
        Toast.makeText(context, "Wrong email or password", LENGTH_SHORT).show()
    }

    fun signUp(view: View, client: Client) {
        val sharedPreferences = activity?.getSharedPreferences(SESSION, Context.MODE_PRIVATE)
        sharedPreferences?.getString(EMAIL, "")?.let {
            if (it.isEmpty()) {
                sharedPreferences.edit().apply {
                    putString(EMAIL, client.email.get())
                    putString(PASSWORD, client.password.get())
                    putBoolean(LOGGED, true)
                }.apply()
            }
        }
        navigateToWelcomeScreen(view)
    }

    private fun navigateToWelcomeScreen(view: View) {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment()
        view.findNavController().navigate(action)
    }

    private fun navigateToShoesScreen() {
        val action = LoginFragmentDirections.actionLoginFragmentToShoesFragment()
        Navigation.findNavController(activity!!, R.id.nav_host_fragment).navigate(action)
    }
}