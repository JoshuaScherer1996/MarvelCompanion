package com.datphoenixstudios.marvel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.datphoenixstudios.marvel.R
import com.datphoenixstudios.marvel.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvTimeline.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTimelineFragment())
        }

        binding.cvComics.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToComicFragment())
        }

        binding.cvCharacters.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCharacterFragment())
        }

        binding.cvCreators.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCreatorFragment())
        }

        binding.cvFavourite.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFavouriteFragment())
        }
    }
}