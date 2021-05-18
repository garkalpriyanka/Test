package com.example.kotlin_app.UI

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import com.example.kotlin_app.MainActivity
import com.example.kotlin_app.activities.AnkoActivity
import org.jetbrains.anko.*

class AnkoActivityUI() : AnkoComponent<AnkoActivity> {
    override fun createView(ui: AnkoContext<AnkoActivity>) = with(ui){

        frameLayout{

            val textField = editText{
                hint = "text for anackers and toasters"

            }.lparams(width = matchParent){
                margin = dip(12)
            }
        }
    }

}