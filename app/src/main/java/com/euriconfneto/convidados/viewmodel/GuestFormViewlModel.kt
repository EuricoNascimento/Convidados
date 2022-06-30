package com.euriconfneto.convidados.viewmodel

import androidx.lifecycle.ViewModel
import com.euriconfneto.convidados.repository.GuestRepository

class GuestFormViewlModel : ViewModel() {

    private val repository = GuestRepository

    fun abc(){
        GuestRepository.getInstance()
    }
}