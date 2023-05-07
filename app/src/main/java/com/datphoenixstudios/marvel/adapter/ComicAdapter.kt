package com.datphoenixstudios.marvel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.datphoenixstudios.marvel.R
import com.datphoenixstudios.marvel.data.datamodels.Comic
import com.datphoenixstudios.marvel.databinding.ComicItemBinding
import com.datphoenixstudios.marvel.ui.ComicFragmentDirections
import com.datphoenixstudios.marvel.ui.TimelineFragmentDirections

class ComicAdapter (
    private val dataset: List<Comic>,
    private val navController: NavController
) : RecyclerView.Adapter<ComicAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ComicItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ComicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var comic = dataset[position]

        //Nutzen das aktuelle holder Objekt um in dessen Layout die Daten unseres aktuellen Kurses zu setzen.
        holder.binding.ivCover.setImageResource(comic.cover)
        holder.binding.tvTitle.setText(comic.title)
        holder.binding.tvIssue.setText(comic.issue)
        holder.binding.tvCreator.setText(comic.creator)

        //Nutzen den Holder, um an der entsprechenden Stelle die Navgation auszuführen.
        holder.binding.cvComic.setOnClickListener {
            /*val navController = holder.binding.cvComic.findNavController()
            navController.navigate(ComicFragmentDirections.actionComicFragmentToDetailFragment(comic.id))*/
            // Determine the current fragment that the adapter is being used in
            val currentFragment = navController.currentDestination?.id
            // Navigate to the DetailFragment based on the current fragment
            when (currentFragment) {
                R.id.comicFragment -> {
                    navController.navigate(ComicFragmentDirections.actionComicFragmentToDetailFragment(comic.id))
                }
                R.id.timelineFragment -> {
                    navController.navigate(TimelineFragmentDirections.actionTimelineFragmentToDetailFragment(comic.id))
                }
            }
        }
    }

}