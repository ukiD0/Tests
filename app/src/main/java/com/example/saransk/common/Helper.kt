package com.example.saransk.common

import android.app.AlertDialog
import android.content.Context

object Helper {

    fun ALert(requireContext: Context,title: String,message: String,possitiveBtn: String = "OK",negativeBtn: String ="Cancel"){
        AlertDialog.Builder(requireContext)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(possitiveBtn){_,_ ->}
            .setNegativeButton(negativeBtn){_,_ ->}
            .show()
    }

}