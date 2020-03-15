package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val shoesBinding = DataBindingUtil.inflate<FragmentShoesBinding>(inflater, R.layout.fragment_shoes, container, false)
        shoesBinding.handler = this
        val shoesLayout = shoesBinding.root.findViewById<LinearLayout>(R.id.shoes)
        val shoeViewModel: ShoeViewModel by activityViewModels()
        shoeViewModel.getShoes().observe(viewLifecycleOwner, Observer<MutableList<Shoe>> { shoes ->
            shoes.forEach { shoe ->
                val shoeItemBinding = DataBindingUtil.inflate<ShoeItemBinding>(inflater, R.layout.shoe_item, container, false)
                shoeItemBinding.shoe = shoe
                shoesLayout.addView(shoeItemBinding.root)
            }
        })
        return shoesBinding.root
    }

    fun addShoe(view: View) {
        navigate(view)
    }

    private fun navigate(view: View) {
        val action = ShoesFragmentDirections.actionShoesFragmentToShoeDetailFragment()
        view.findNavController().navigate(action)
    }
}