package com.euriconfneto.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.euriconfneto.convidados.model.GuestModel
import com.euriconfneto.convidados.repository.GuestRepository

class GuestFormViewlModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)
    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    fun insert(guest: GuestModel) {
        repository.insert(guest)
    }

    fun get(id: Int){
        repository.get(id)
    }
}