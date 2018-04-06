package com.padcmyanmar.mmnews.kotlin

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

            var addResult: Int = addTheseTwo(2410, 1876)
            var todayDate: Date? = null //Date()
            var isToRestToday = isRestDay(todayDate)
            var isToRestStr: String
            if (isToRestToday) {
                isToRestStr = "rest"
            } else {
                isToRestStr = "work"
            }

            var isTappingFAB: String
            if (fab is FloatingActionButton)
                isTappingFAB = "tapping FAB"
            else
                isTappingFAB = "not tapping FAB"

            var degrees = listOf("M.Med (Int.Med)(Nus, S'pore)",
                    "M.Med.Sc (Int,Med)",
                    "MA cad MED (UK)",
                    "Fellowship in interventional Cardiology (Seoul, Korea)",
                    "Consultant Heart & General Physician")

            var degreesPresentable = getDegreesPresentableWithWhile(degrees)

            /*
            Snackbar.make(view, "The result is $addResult and today is to $isToRestStr. " +
                    "Also you are $isTappingFAB", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                    */

            Snackbar.make(view, "degreesPresentable : $degreesPresentable", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Add two integer from parameter and return the result.
     */
    private fun addTheseTwo(varOne: Int, varTwo: Int): Int {
        return varOne + varTwo
    }

    /**
     * Find out if the date is to rest or not.
     */
    private fun isRestDay(date: Date?): Boolean {
        if (date == null)
            return true

        var calendar: Calendar = Calendar.getInstance()
        calendar.time = date
        var dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        if (dayOfMonth / 3 == 0) {
            return true
        }
        return false
    }

    private fun getDegreesPresentable(degrees: List<String>): String {
        var presentableDegrees: String = ""
        for (degree in degrees) {
            presentableDegrees = "$presentableDegrees, $degree"
        }
        return presentableDegrees
    }

    private fun getDegreesPresentableWithWhile(degrees: List<String>): String {
        var presentableDegrees : String = ""
        var index = 0
        while (index < degrees.size) {
            presentableDegrees = "$presentableDegrees, $degrees[index]"
            index++
        }
        return presentableDegrees
    }
}
