package com.euriconfneto.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.euriconfneto.convidados.repository.GuestRepository

class GuestFormViewlModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    fun save(){

    }

}