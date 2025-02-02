package mr.mohammadi.videoplayer.ext

import android.app.Activity
import android.app.Dialog
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import mr.mohammadi.videoplayer.R
import mr.mohammadi.videoplayer.remote.ApiRepository

object DialogHelper {
    fun showSupportTicketDialog(activity: Activity) {
        val dialog = Dialog(activity)
        dialog.setContentView(R.layout.custom_dialog_send_ticket)
        dialog.setCancelable(false)

        // پیدا کردن imgExitCircleDialog بعد از setContentView
        val imgExitCircleDialog: ImageView = dialog.findViewById(R.id.img_exit_circle_dialog)
        val btnSendTextToTelegram: Button = dialog.findViewById(R.id.btnSendTextToTelegram)
        val edtTextTitle: TextView = dialog.findViewById(R.id.edtTextTitle)
        val edtTextDetail: TextView = dialog.findViewById(R.id.edtTextDetail)

        imgExitCircleDialog.setOnClickListener {
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()

        btnSendTextToTelegram.setOnClickListener {
            val txtTitle = edtTextTitle.text.toString()
            val txtDetail = edtTextDetail.text.toString()
            ApiRepository.instance.sendText(
                "oaF5gb31IZ6MWcVfSLuQJnIkvOUnYMvcRia8CIUS",
                "عنوان: $txtTitle \n متن مشکل : $txtDetail"
            )
            dialog.dismiss()
        }
    }
}
