package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.handler = this
        binding.shoe = Shoe("", 0.0, "", "")
        return binding.root
    }

    fun cancel(view: View) {
        navigate(view)
    }

    fun save(view: View, shoe: Shoe) {
        navigate(view)
        val shoeViewModel: ShoeViewModel by activityViewModels()
        shoeViewModel.getShoes().value?.add(shoe)
    }

    private fun navigate(view: View) {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesFragment()
        view.findNavController().navigate(action)
    }
}
