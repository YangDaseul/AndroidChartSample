package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity3 : AppCompatActivity() {
    private lateinit var tv1: TextView
    private lateinit var tv2: TextView
    private lateinit var tv3: TextView

    private lateinit var btnList: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        tv3 = findViewById(R.id.tv3)

        tv1.setOnClickListener(onClickListener)
        tv2.setOnClickListener(onClickListener)
        tv3.setOnClickListener(onClickListener)

        btnList = arrayOf(tv1.id, tv2.id, tv3.id)
    }

    private val onClickListener =
        View.OnClickListener { view -> onClickCommon(view) }

    private fun onClickCommon(view: View) {
        when (view.id) {
            R.id.tv1, R.id.tv2, R.id.tv3 -> {
                setBtnColor(view.id)
            }
        }
    }

    private fun setBtnColor(viewId: Int) {
        var index = 0
        when (viewId) {
            R.id.tv1 -> {
                index = 0
                if (btnList.contains(viewId)) {
                    tv1.setBackgroundColor(Color.parseColor("#ffffff"))
                    tv1.setTextColor(Color.parseColor("#757575"))

                } else {
                    tv1.setBackgroundColor(Color.parseColor("#996449"))
                    tv1.setTextColor(Color.parseColor("#ffffff"))

                }
            }
            R.id.tv2 -> {
                index = 1
                if (btnList.contains(viewId)) {
                    tv2.setBackgroundColor(Color.parseColor("#ffffff"))
                    tv2.setTextColor(Color.parseColor("#757575"))
                } else {
                    tv2.setBackgroundColor(Color.parseColor("#996449"))
                    tv2.setTextColor(Color.parseColor("#ffffff"))

                }
            }
            R.id.tv3 -> {
                index = 2
                if (btnList.contains(viewId)) { // true
                    tv3.setBackgroundColor(Color.parseColor("#ffffff"))
                    tv3.setTextColor(Color.parseColor("#757575"))
                } else { // false
                    tv3.setBackgroundColor(Color.parseColor("#996449"))
                    tv3.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        }
        if (btnList.contains(viewId)) {
            for (i in index until btnList.size - 1) {
                btnList[i] = btnList[i+1]
            }
        } else {
            btnList[index] = viewId
        }
    }
}