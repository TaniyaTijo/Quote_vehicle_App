package com.example.mainapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val f1 = MainFragment.newInstance("","")
        supportFragmentManager.beginTransaction().replace(R.id.FragmentContainer,f1,"@string/list_fragment_keyword").commit()
    }


}
