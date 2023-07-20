package com.example.ejercicio16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Adapter.PaisCallBack {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter() {
        val adapter = Adapter()
        adapter.setData(PaisesLatam.paises)
        adapter.setPaisCallBack(this)
        binding.recyclerView.adapter = adapter

    }

    override fun showCountrie(s: String) {
      binding.textView.text = s
    }


}