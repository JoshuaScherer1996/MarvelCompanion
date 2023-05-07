package com.datphoenixstudios.marvel.ui

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.datphoenixstudios.marvel.MainViewModel
import com.datphoenixstudios.marvel.R
import com.datphoenixstudios.marvel.adapter.ComicAdapter
import com.datphoenixstudios.marvel.databinding.FragmentComicBinding
import com.datphoenixstudios.marvel.databinding.FragmentTimelineBinding

class TimelineFragment : Fragment() {
    private lateinit var binding: FragmentTimelineBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_timeline, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.sortedComicList.observe(viewLifecycleOwner) { comics ->
            binding.rvComics.adapter = ComicAdapter(comics, findNavController())
        }

        binding.fbtnHome.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.white), PorterDuff.Mode.SRC_IN)

        binding.fbtnHome.setOnClickListener {
            findNavController().navigate(TimelineFragmentDirections.actionTimelineFragmentToHomeFragment())
        }
    }

}