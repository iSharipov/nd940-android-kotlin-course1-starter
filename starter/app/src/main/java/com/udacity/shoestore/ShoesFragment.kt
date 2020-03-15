package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_shoes, container, false)
        val shoesLayout = root.findViewById<LinearLayout>(R.id.shoes)
        val shoeViewModel: ShoeViewModel by activityViewModels()
        shoeViewModel.getShoes().value?.add(Shoe(company = "123", size = 1.1, name = "nike", description = "best"))
        shoeViewModel.getShoes().value?.forEach { shoe ->
            val binding = DataBindingUtil.inflate<ShoeItemBinding>(inflater, R.layout.shoe_item, container, false)
            binding.shoe = shoe
            shoesLayout.addView(binding.root)
        }
        return root
    }

    private fun navigate(view: View) {
        //        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment()
        //        view.findNavController().navigate(action)
    }
}
