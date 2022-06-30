package com.euriconfneto.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.euriconfneto.convidados.R
import com.euriconfneto.convidados.databinding.ActivityGuestFormBinding
import com.euriconfneto.convidados.viewmodel.GuestFormViewlModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewlModel: GuestFormViewlModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewlModel = ViewModelProvider(this).get(GuestFormViewlModel::class.java)

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save){

        }
    }
}