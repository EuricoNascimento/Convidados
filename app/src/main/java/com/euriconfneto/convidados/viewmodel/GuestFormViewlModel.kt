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
    private val _saveGuest = MutableLiveData<String>()
    val saveGuest: LiveData<String> = _saveGuest

    fun save(guest: GuestModel) {
        if(guest.id == 0){
            if(repository.insert(guest)) {
                _saveGuest.value = "Inserção com sucesso"
            }
        } else {
            if(repository.update(guest)){
                _saveGuest.value = "Atualização com sucesso"
            }
        }
    }
    fun get(id: Int){
        guestModel.value = repository.get(id)
    }
}