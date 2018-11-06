package com.example.tomas.mytasks.board

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText
import android.widget.LinearLayout

class TextDialog(private val context: Context) {

    var text: String = ""

    fun show(title: String, content: String, listener: TextDialogListener) {
        val builder = AlertDialog.Builder(context)
        val editText = EditText(context)
        val layout = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        builder.setTitle(title)
        editText.setText(content)

        editText.layoutParams = layout
        builder.setView(editText)

        builder.setPositiveButton("SUBMIT") { dialog, _ ->
            listener.textChanged(editText.text.toString())
            dialog.dismiss()
        }

        builder.setNegativeButton("CANCEL") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    interface TextDialogListener {
        fun textChanged(text: String)
    }
}