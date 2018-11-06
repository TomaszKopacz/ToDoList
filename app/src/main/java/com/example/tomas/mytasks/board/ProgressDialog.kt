package com.example.tomas.mytasks.board

import android.app.AlertDialog
import android.content.Context
import android.widget.LinearLayout
import android.widget.SeekBar

class ProgressDialog(private val context: Context) {

    fun show(title: String, progress: Int, listener: ProgressDialogListener) {
        val builder = AlertDialog.Builder(context)
        val bar = SeekBar(context)
        val layout = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        bar.max = 6

        builder.setTitle(title)
        bar.progress = progress

        bar.layoutParams = layout
        builder.setView(bar)

        builder.setPositiveButton("SUBMIT") { dialog, _ ->
            listener.progressChanged(bar.progress)
            dialog.dismiss()
        }

        builder.setNegativeButton("CANCEL") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    interface ProgressDialogListener {
        fun progressChanged(progress: Int)
    }
}