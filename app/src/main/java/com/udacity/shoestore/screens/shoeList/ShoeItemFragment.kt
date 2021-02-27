package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeitemFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeItemFragment : Fragment() {

    private lateinit var binding: ShoeitemFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoelist_fragment, container, false)
        return binding.root
    }

    fun addShoe(shoe: Shoe) {

    }

}