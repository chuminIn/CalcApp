package jp.techacademy.bunta.tsurumi.calcapp

import android.R.attr.resource
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        if (editTextText1.length() == 0 || editTextText2.length()==0){
            Log.d("UI","sddddd")
            val snack = Snackbar.make(v,"空白があります。",Snackbar.LENGTH_LONG)
            snack.show()

        }else {

            var text1 = editTextText1.text.toString().toDouble()
            var text2 = editTextText2.text.toString().toDouble()
            var total = ""

            when (v.id) {
                R.id.button1 -> {
                    total = (text1 + text2).toString()
                    Log.d("UI","$total")
                }
                R.id.button2 -> {
                    total = (text1 - text2).toString()
                    Log.d("UI","$total")
                }
                R.id.button3 -> {
                    total = (text1 * text2).toString()
                    Log.d("UI","$total")
                }
                R.id.button4 -> {
                    total = (text1 / text2).toString()
                    Log.d("UI","$total")
                }
                else -> {}
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("VALUE1", total)
            startActivity(intent)
        }
    }
}


