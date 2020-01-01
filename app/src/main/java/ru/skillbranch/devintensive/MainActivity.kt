package ru.skillbranch.devintensive

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.models.Bender

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var benderImage: ImageView
    lateinit var textTxt: TextView
    lateinit var messageEt: EditText
    lateinit var sendImage: ImageView

    lateinit var benderObj: Bender

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        benderImage = main_iv_bender
        textTxt = main_tv_text
        messageEt = main_et_message
        sendImage = main_iv_send

        val status = savedInstanceState?.getString("STATUS") ?: Bender.Status.NORMAL.name
        val question = savedInstanceState?.getString("QUESTION") ?: Bender.Question.NAME.name

        benderObj = Bender(Bender.Status.valueOf(status), Bender.Question.valueOf(question))

        Log.d("HAPPY_MainActivity","onCreate() $status. $question")

        val (r, g, b) = benderObj.status.color
        benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)

        textTxt.text = benderObj.askQuestion()

        sendImage.setOnClickListener(this)

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("HAPPY_MainActivity","onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.d("HAPPY_MainActivity","onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HAPPY_MainActivity","onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HAPPY_MainActivity","onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("HAPPY_MainActivity","onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HAPPY_MainActivity","onDestroy()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("STATUS", benderObj.status.name)
        outState.putString("QUESTION", benderObj.question.name)
        Log.d("HAPPY_MainActivity","onSaveInstanceState ${benderObj.status.name} ${benderObj.question.name}")

    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.main_iv_send) {
            val (phrase, color) = benderObj.listenAnswer(messageEt.text.toString().toLowerCase())
            messageEt.setText("")
            val (r, g, b) = color
            benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)
            textTxt.text = phrase
        }
    }

}
