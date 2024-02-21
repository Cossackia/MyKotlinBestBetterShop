package com.soloviev.mykotlinbestbettershop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Tools : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools)

        val productList : RecyclerView = findViewById(R.id.productList)
        val allTools = arrayListOf<Items>()

        allTools.add(Items(1,"ak","Ak-47","7,62-мм автомат Калашникова","автомат, принятый на вооружение в СССР в 1949 году.",10999))
        allTools.add(Items(2,"awp","L96","снайперская винтовка ","Accuracy International L96A1 / Arctic Warfare — снайперская винтовка британского производства, разработанная в компании Accuracy International. В 1982 году винтовка была принята на вооружение Британской армии под обозначением L96.",259990))
        allTools.add(Items(3,"cannon","Пушка","Артиллерийское оружие","Пу́шка — тип артиллерийского орудия, основным назначением которого является стрельба по настильной траектории, а также по воздушным и отдалённым целям.",159800))

        productList.layoutManager = LinearLayoutManager(this)
        productList.adapter = AdapterWithTools(allTools, this)
    }
}