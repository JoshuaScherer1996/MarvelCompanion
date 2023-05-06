package com.datphoenixstudios.marvel.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.datphoenixstudios.marvel.MainViewModel
import com.datphoenixstudios.marvel.R
import com.datphoenixstudios.marvel.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val viewModel: MainViewModel by activityViewModels()

     var comicId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            comicId = it.getInt("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            viewModel.comicList.observe(viewLifecycleOwner) { comics ->
                val currentComic = comics.find { it.id == comicId }

                if (currentComic != null) {
                    //Wir setzen die Elemente unseres Layouts auf die Daten unseres aktuellen Kurses.
                    binding.ivDetail.setImageResource(currentComic.cover)
                    binding.tvTitle.setText(currentComic.title)
                    binding.tvCreator.setText(currentComic.creator)
                    binding.tvYear.setText(currentComic.publishedYear)
                    binding.tvIssue.setText(currentComic.issue)
                    binding.tvDetail.setText(currentComic.detailText)
                }
            }
        }
    }

