package com.datphoenixstudios.marvel

import androidx.lifecycle.ViewModel
import com.datphoenixstudios.marvel.data.AppRepository

class MainViewModel : ViewModel() {

    private val repository = AppRepository()

    val comicList = repository.comicList

}