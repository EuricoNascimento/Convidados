package com.euriconfneto.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.euriconfneto.convidados.R
import com.euriconfneto.convidados.constants.DataBaseConstants
import com.euriconfneto.convidados.databinding.ActivityGuestFormBinding
import com.euriconfneto.convidados.model.GuestModel
import com.euriconfneto.convidados.viewmodel.GuestFormViewlModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewlModel
    private var guestId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewlModel::class.java)

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true

        observer()
        loadData()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save){
            val name = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked
            viewModel.save(GuestModel().apply {
                this.id = guestId
                this.name = name
                this.presence = presence
            })
            finish()
        }
    }

    private fun loadData(){
        val bundle = intent.extras

        if (bundle != null){
            val guestId = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewModel.get(guestId)
        }
    }

    private fun observer(){
        viewModel.guest.observe( this, Observer {
            guestId = it.id
            binding.editName.setText(it.name)
            if (it.presence){
                binding.radioPresent.isChecked = true
            } else {

                binding.radioAbsent.isChecked = true
            }
        })

        viewModel.saveGuest.observe(this, Observer {
            if (it != "") {
                Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }
}