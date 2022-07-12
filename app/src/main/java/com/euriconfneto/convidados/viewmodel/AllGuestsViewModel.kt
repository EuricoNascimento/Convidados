package com.euriconfneto.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.euriconfneto.convidados.model.GuestModel
import com.euriconfneto.convidados.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    val repository = GuestRepository.getInstance(application.applicationContext)
    private val listAllGuest = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = listAllGuest

    fun getAll(){
        listAllGuest.value = repository.getAll()
    }
}