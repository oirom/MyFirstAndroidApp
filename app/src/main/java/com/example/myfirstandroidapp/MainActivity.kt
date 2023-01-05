package com.example.myfirstandroidapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        var menu = mutableMapOf("name" to "Karage Teishoku", "price" to "$10")
        menuList.add(menu)
        menu = mutableMapOf("name" to "Sashimi Teishoku", "price" to "$20")
        menuList.add(menu)
        menu = mutableMapOf("name" to "Ramen Teishoku", "price" to "$30")
        menuList.add(menu)
        menu = mutableMapOf("name" to "Sukiyaki Teishoku", "price" to "$40")
        menuList.add(menu)
        menu = mutableMapOf("name" to "Steak Teishoku", "price" to "$50")
        menuList.add(menu)

        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter = SimpleAdapter(this@MainActivity, menuList, android.R.layout.simple_list_item_2, from, to)
        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>
            val menuName = item["name"]
            val menuPrice = item["price"]
            val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)

            intent2MenuThanks.putExtra("menuName", menuName)
            intent2MenuThanks.putExtra("menuPrice", menuPrice)

            startActivity(intent2MenuThanks)
        }
    }
}