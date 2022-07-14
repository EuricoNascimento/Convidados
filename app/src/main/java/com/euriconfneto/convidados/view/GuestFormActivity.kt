package com.euriconfneto.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.euriconfneto.convidados.R
import com.euriconfneto.convidados.constants.DataBaseConstants
import com.euriconfneto.convidados.databinding.ActivityGuestFormBinding
import com.euriconfneto.convidados.model.GuestModel
import com.euriconfneto.convidados.viewmodel.GuestFormViewlModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewlModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewlModel::class.java)

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true

        loadData()

        //viewModel.guest.observe()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save){
            val name = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked
            viewModel.insert(GuestModel(0, name, presence))
        }
    }

    private fun loadData(){
        val bundle = intent.extras

        if (bundle != null){
            val guestId = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewModel.get(guestId)
        }
    }
}