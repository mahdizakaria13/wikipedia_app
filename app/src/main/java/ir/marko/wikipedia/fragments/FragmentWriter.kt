package ir.marko.wikipedia.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import ir.marko.wikipedia.databinding.FragmentWriterBinding

class FragmentWriter : Fragment() {
    lateinit var binding: FragmentWriterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.v("test_debug" , "fragment writer view created")
        binding = FragmentWriterBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sendInfo()
    }
    private fun sendInfo(){
        val txtName = binding.txtInputNameWriter.text
        val email = binding.txtInputEmailWriter.text
        val age = binding.txtInputAgeWriter.text
        val password = binding.txtInputPasswordWriter.text
        val location = binding.txtInputLocationWriter.text
        var checked = false
        binding.radioMale.setOnCheckedChangeListener { _, isChecked ->
            checked = isChecked
        }
        binding.radioFemale.setOnCheckedChangeListener { _, isChecked ->
            checked = isChecked
        }
        binding.btnSendInfo.setOnClickListener {
            if (txtName!!.isNotEmpty() && email!!.isNotEmpty() && age!!.isNotEmpty() && password!!.isNotEmpty() && location!!.isNotEmpty() && checked){
                val dialog = SweetAlertDialog(context , SweetAlertDialog.SUCCESS_TYPE)
                dialog.titleText = "Alert"
                dialog.contentText = "Do you want to send info ?"
                dialog.cancelText = "Cancel"
                dialog.confirmText = "Confirm"
                dialog.setCancelClickListener{
                    dialog.dismiss()
                }
                dialog.setConfirmClickListener {
                    dialog.dismiss()
                    Toast.makeText(context, "Information sent , please wait for response", Toast.LENGTH_LONG).show()
                }
                dialog.show()
            }
            else{
                val dialog =  SweetAlertDialog(context , SweetAlertDialog.ERROR_TYPE)
                dialog.titleText = "Error occurred"
                dialog.contentText = "Please fill all inputs"
                dialog.setConfirmClickListener {
                    dialog.dismiss()
                }
                dialog.show()
            }
        }
    }
}