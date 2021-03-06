package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeitemFragmentBinding
import com.udacity.shoestore.databinding.ShoelistFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: ShoelistFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoelist_fragment, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.shoeListViewModel = viewModel

        viewModel.onOpenDetail.observe(viewLifecycleOwner, { isOpen ->
            if (isOpen)
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListDestinationToShoeDetailFragment())
        })

        viewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->
            processShoeList(shoeList)
        })

        return binding.root
    }

    private fun processShoeList(shoeList: MutableList<Shoe>) {
        binding.shoelistContainer.removeAllViews()

        shoeList.forEach { shoe ->
            val shoeBinding: ShoeitemFragmentBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoeitem_fragment, binding.shoelistContainer, true)

            shoeBinding.apply {
                nameText.text = shoe.name
                companyText.text = shoe.company
                sizeText.text = shoe.size.toString()
            }
        }
    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        (activity as AppCompatActivity).setSupportActionBar()
//    }
}