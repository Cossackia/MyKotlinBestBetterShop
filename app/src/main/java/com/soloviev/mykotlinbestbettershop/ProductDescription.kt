package com.soloviev.mykotlinbestbettershop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.razorpay.Checkout

class ProductDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_description)

        Checkout.preload(applicationContext)
        val co = Checkout()
        // apart from setting it in AndroidManifest.xml, keyId can also be set
        // programmatically during runtime
        co.setKeyID("rzp_live_XXXXXXXXXXXXXX")

        val title: TextView = findViewById(R.id.item_with_list_title_one)
        val text: TextView = findViewById(R.id.item_with_list_text)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
    }
}