package com.example.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var number1: EditText
    lateinit var number2: EditText
    lateinit var btnTopla: Button
    lateinit var btnCikar: Button
    lateinit var btnCarp: Button
    lateinit var btnBol: Button
    lateinit var txtSonuc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        btnTopla = findViewById(R.id.btnTopla)
        btnCikar = findViewById(R.id.btnCikar)
        btnCarp = findViewById(R.id.btnCarp)
        btnBol = findViewById(R.id.btnBol)
        txtSonuc = findViewById(R.id.txtSonuc)

        btnTopla.setOnClickListener { hesapla("+") }
        btnCikar.setOnClickListener { hesapla("-") }
        btnCarp.setOnClickListener { hesapla("*") }
        btnBol.setOnClickListener { hesapla("/") }
    }

    private fun hesapla(islem: String) {
        val s1 = number1.text.toString()
        val s2 = number2.text.toString()

        if (s1.isEmpty() || s2.isEmpty()) {
            txtSonuc.text = "Lütfen iki sayı girin."
            return
        }

        val sayi1 = s1.toDouble()
        val sayi2 = s2.toDouble()
        val sonuc = when (islem) {
            "+" -> sayi1 + sayi2
            "-" -> sayi1 - sayi2
            "*" -> sayi1 * sayi2
            "/" -> {
                if (sayi2 != 0.0) sayi1 / sayi2 else {
                    txtSonuc.text = "Sıfıra bölünemez!"
                    return
                }
            }
            else -> 0.0
        }

        txtSonuc.text = "Sonuç: $sonuc"
    }
}
