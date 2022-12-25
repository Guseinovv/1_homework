package com.example.a1_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a1_homework.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        val desc = intent.getStringExtra(MainActivity.KEYFORINTENT)
        binding.et.setText(desc)

        binding.btn.setOnClickListener {
            val data = binding.et.text.toString()

            if (binding.et.text.isEmpty()) {
                Toast.makeText(this, "пустоту передать невозможно", Toast.LENGTH_SHORT).show()
            } else {
                Intent(this@SecondActivity, MainActivity::class.java).apply {
                    putExtra(KEYFORDATA, data)
                    setResult(RESULT_OK, this)
                    finish()
                }
            }
        }
    }

    companion object {
        const val KEYFORDATA = "key"
    }
}