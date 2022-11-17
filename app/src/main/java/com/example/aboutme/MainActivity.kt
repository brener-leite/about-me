package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var setNickNameButton: Button
    private lateinit var editText: EditText
    private lateinit var nickNameTextView: TextView
    private lateinit var inputMethodManager: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        setNickNameButton = findViewById<Button>(R.id.done_button)
        editText = findViewById<EditText>(R.id.nickname_edit)
        nickNameTextView = findViewById<TextView>(R.id.nickname_text)

        setNickNameButton.setOnClickListener {
            addNickName(it)
        }

        nickNameTextView.setOnClickListener {
            updateNickName(it)
        }
    }

    private fun addNickName(view: View) {
        nickNameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nickNameTextView.visibility = View.VISIBLE

        // Hide keyboard
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickName (view: View) {
        editText.visibility = View.VISIBLE
        setNickNameButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()
        inputMethodManager.showSoftInput(editText, 0)
    }
}