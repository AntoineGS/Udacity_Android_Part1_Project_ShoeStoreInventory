package com.udacity.shoestore.screens.shoeDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.screens.shoeList.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false)

        val viewModel: ShoeDetailViewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.shoeDetailViewModel = viewModel

        val shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        // The spec is a bit odd here, since I would not expect the Details button to be an Add button
        viewModel.onSave.observe(viewLifecycleOwner, {isSaved ->
            if (isSaved) {
                shoeListViewModel.addShoe(viewModel.shoe.value!!)
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailDestinationToShoeListDestination())
            }
        })

        viewModel.onCancel.observe(viewLifecycleOwner, {isCanceled ->
            if (isCanceled) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailDestinationToShoeListDestination())
            }
        })

        return binding.root
    }
}