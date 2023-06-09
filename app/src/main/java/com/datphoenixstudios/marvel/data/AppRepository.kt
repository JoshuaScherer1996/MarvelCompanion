package com.datphoenixstudios.marvel.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.datphoenixstudios.marvel.R
import com.datphoenixstudios.marvel.data.datamodels.Comic

class AppRepository {

    private val _comicList = MutableLiveData<List<Comic>>()
    val comicList: LiveData<List<Comic>>
        get() = _comicList

    private val _sortedComicList = MutableLiveData<List<Comic>>()
    val sortedComicList: LiveData<List<Comic>>
        get() = _sortedComicList

    init {
        loadComics()
    }
    fun loadComics() {
        val comicList = listOf<Comic>(
            Comic(
              1,
                R.string.amazing_fantasy_title,
                R.drawable.amazing_fantasy,
                R.string.amazing_fantasy_issue,
                R.string.amazing_fantasy_creator,
                1962,
                R.string.amazing_fantasy_detail
            ),
            Comic(
                2,
                R.string.cap_title,
                R.drawable.captain_america,
                R.string.cap_issue,
                R.string.cap_creator,
                1941,
                R.string.cap_detail
            ),
            Comic(
                3,
                R.string.hulk_title,
                R.drawable.hulk,
                R.string.hulk_issue,
                R.string.hulk_creator,
                1962,
                R.string.hulk_detail
            ),
            Comic(
                4,
                R.string.ironman_title,
                R.drawable.ironman_comic,
                R.string.ironman_issue,
                R.string.ironman_creator,
                1968,
                R.string.ironman_detail
            ),
            Comic(
                5,
                R.string.avengers_title,
                R.drawable.avengers,
                R.string.avengers_issue,
                R.string.avengers_creator,
                1963,
                R.string.avengers_detail
            ),
            Comic(
                6,
                R.string.marvels_title,
                R.drawable.marvels,
                R.string.marvels_issue,
                R.string.marvels_creator,
                2018,
                R.string.marvels_detail
            )
        )
        _comicList.value = comicList

        // Sort the list of comics based on the 'publishedYear' field in ascending order
        val sortedComics = comicList.sortedBy { it.publishedYear }

        // Update the LiveData object with the sorted list
        _sortedComicList.value = sortedComics
    }
}