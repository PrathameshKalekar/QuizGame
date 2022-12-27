package com.example.android.navigation.loading

import androidx.appcompat.app.AlertDialog
import com.example.android.navigation.MainActivity
import com.example.android.navigation.R

class LoadingDailog(val mActivity : MainActivity){
    private lateinit var  isDailog : AlertDialog
    fun startLoading(){
        //View
        val inflater = mActivity.layoutInflater
        val dailogView = inflater.inflate( R.layout.loading_item,null)
        //
        val builder =AlertDialog.Builder(mActivity)
        builder.setView(dailogView)
        builder.setCancelable(false)
        isDailog = builder.create()
        isDailog.show()
    }
    fun isDismiss(){
        isDailog.dismiss()
    }
}