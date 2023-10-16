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
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var btnpop: Button
    lateinit var bg: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        btnpop = findViewById(R.id.pop)
        bg = findViewById(R.id.layout)
        registerForContextMenu(btn);
        btnpop.setOnClickListener() {
            showPopupMenu(btnpop)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?, v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.color, menu)
// menu.setHeaderTitle("ContextMenu");
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.pressme1 -> {
                btn.setBackgroundColor(Color.RED)
                return true
            }

            R.id.pressme2 -> {
                btn.setBackgroundColor(Color.BLUE)
                return true
            }

            else -> super.onContextItemSelected(item)
        }
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_search -> {
                Toast.makeText(
                    getApplicationContext(),
                    "menu search selectionné",
                    Toast.LENGTH_LONG
                ).show()
                true
            }

            R.id.menu_exit -> {
                Toast.makeText(getApplicationContext(), "menu exit selectionné", Toast.LENGTH_LONG)
                    .show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun showPopupMenu(btn: Button) {
        val popupMenu = PopupMenu(this, btn)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.popmenu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_rouge -> {
                    bg.setBackgroundColor(Color.parseColor("#FFA2A2"))
                    btn.setBackgroundColor(Color.RED)
                    true
                }

                R.id.menu_bleu -> {
                    bg.setBackgroundColor(Color.parseColor("#A2D2FF"))
                    btn.setBackgroundColor(Color.BLUE)
                    true
                }

                else -> false
            }
        }

        popupMenu.show()
    }
}













