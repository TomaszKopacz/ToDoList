package com.example.tomas.mytasks.board

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.example.tomas.mytasks.R

class ModifierDialog(private val context: Context) {

    private var dialog: AlertDialog.Builder? = null

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.dialog_modifier, null)

        dialog = AlertDialog.Builder(context)
        dialog?.setView(view)
    }

    fun show(){
        dialog?.show()
    }
}