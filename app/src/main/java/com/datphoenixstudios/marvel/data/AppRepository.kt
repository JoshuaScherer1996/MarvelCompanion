package com.datphoenixstudios.marvel.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.datphoenixstudios.marvel.R
import com.datphoenixstudios.marvel.data.datamodels.Comic

class AppRepository {

    private val _comicList = MutableLiveData<List<Comic>>()
    val comicList: LiveData<List<Comic>>
        get() = _comicList

    init {
        loadComics()
    }
    fun loadComics() {
        val comicList = listOf<Comic>(
            Comic(
              1,
                R.string.amazing_fantasy_title,
                R.drawable.amazing_fantasy,
                15,
                R.string.amazing_fantasy_creator,
                1962,
                R.string.amazing_fantasy_detail
            ),
            Comic(
                2,
                R.string.cap_title,
                R.drawable.captain_america,
                1,
                R.string.cap_creator,
                1941,
                R.string.cap_detail
            ),
            Comic(
                3,
                R.string.hulk_title,
                R.drawable.hulk,
                1,
                R.string.hulk_creator,
                1962,
                R.string.hulk_detail
            ),
            Comic(
                4,
                R.string.ironman_title,
                R.drawable.ironman_comic,
                1,
                R.string.ironman_creator,
                1968,
                R.string.ironman_detail
            ),
            Comic(
                5,
                R.string.avengers_title,
                R.drawable.avengers,
                1,
                R.string.avengers_creator,
                1963,
                R.string.avengers_detail
            ),
            Comic(
                1,
                R.string.marvels_title,
                R.drawable.marvels,
                1,
                R.string.marvels_creator,
                2018,
                R.string.marvels_detail
            )
        )
        _comicList.value = comicList
    }
}