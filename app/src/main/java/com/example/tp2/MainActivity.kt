package com.example.tp2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var btn :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn= findViewById(R.id.btn)
        registerForContextMenu(btn);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?,
                                     menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.color, menu)
// menu.setHeaderTitle("ContextMenu");
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
                R.id.pressme1 ->{
                    btn.setBackgroundColor(Color.RED)
                    return true
                }
                R.id.pressme2-> {
                    btn.setBackgroundColor(Color.BLUE)
                    return true
                }
            else -> super.onContextItemSelected(item)
        }
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id. menu_search -> {
                Toast.makeText(getApplicationContext(),"menu search selectionné" , Toast.LENGTH_LONG).show()
                true
            }
            R.id.menu_exit-> {
                Toast.makeText(getApplicationContext(),"menu exit selectionné" , Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    }



