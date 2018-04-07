package com.padcmyanmar.mmnews.kotlin.activities

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.padcmyanmar.mmnews.kotlin.MMNewsApp
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.adapters.NewsAdapter
import com.padcmyanmar.mmnews.kotlin.components.SmartScrollListener
import com.padcmyanmar.mmnews.kotlin.data.models.NewsAppModel
import com.padcmyanmar.mmnews.kotlin.data.vos.NewsVO
import com.padcmyanmar.mmnews.kotlin.delegates.NewsItemDelegate
import com.padcmyanmar.mmnews.kotlin.events.DataEvent
import com.padcmyanmar.mmnews.kotlin.events.ErrorEvent
import kotlinx.android.synthetic.main.activity_home.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : BaseActivity(), NewsItemDelegate {

    private var mNewsAdapter: NewsAdapter? = null
    private var mSmartScrollListener: SmartScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

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

            /*
            Snackbar.make(view, "degreesPresentable : $degreesPresentable", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                    */

            tryOutCollections()
        }

        var news: NewsVO = NewsVO()
        news.newsId = "PADC-12345"
        news.brief = "Handle action bar item clicks here."
        news.details = "The action bar will automatically handle clicks on the Home/Up button, " +
                "so long as you specify a parent activity in AndroidManifest.xml."
        news.postedDate = "2018-03-27"
        news.images = ArrayList<String>()

        rvNews.setEmptyView(vpEmptyNews)
        rvNews.layoutManager = LinearLayoutManager(applicationContext)

        mSmartScrollListener = SmartScrollListener(object : SmartScrollListener.OnSmartScrollListener {
            override fun onListEndReach() {
                Snackbar.make(rvNews, "Loading more data.", Snackbar.LENGTH_LONG).show()
                swipeRefreshLayout.isRefreshing = true
                NewsAppModel.getInstance().loadNews()
            }
        })
        rvNews.addOnScrollListener(mSmartScrollListener)

        mNewsAdapter = NewsAdapter(applicationContext, this)
        rvNews.adapter = mNewsAdapter

        swipeRefreshLayout.isRefreshing = true
        NewsAppModel.getInstance().loadNews()

        swipeRefreshLayout.setOnRefreshListener {
            val newsAdapterVal = mNewsAdapter
            newsAdapterVal!!.clearData()
            NewsAppModel.getInstance().forceLoadNews()
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
        if (dayOfMonth / 3 == 0 && isRestDate(date)) {
            return true
        }
        return false
    }

    /**
     * Get presentable comma separated degrees from the list.
     */
    private fun getDegreesPresentable(degrees: List<String>): String {
        var presentableDegrees: String = ""
        for (degree in degrees) {
            presentableDegrees = "$presentableDegrees, $degree"
        }
        return presentableDegrees
    }

    /**
     * Get presentable comma separated degrees from the list - with while loop.
     */
    private fun getDegreesPresentableWithWhile(degrees: List<String>): String {
        var presentableDegrees: String = ""
        var index = 0
        while (index < degrees.size) {
            presentableDegrees = "$presentableDegrees, $degrees[index]"
            index++
        }
        return presentableDegrees
    }

    /**
     * Check the date if it is to rest or not.
     */
    private fun isRestDate(dateToCheck: Date): Boolean {
        var calendar = Calendar.getInstance()
        calendar.time = dateToCheck
        when (calendar.get(Calendar.DAY_OF_WEEK)) {
            0 -> return true
            1 -> return true
            2 -> return false
            3 -> return false
            4 -> return true
            5 -> return true
            6 -> return false
            else -> return true
        }
    }

    /**
     * Find out if your age is to fool around.
     */
    private fun ageToFoolAround(age: Int): String {
        if (age in 19..24)
            return "Yes"
        else
            return "No"
    }

    /**
     * See how "step" works in a loop.
     */
    private fun howRangeAndStepWorks() {
        for (index in 1..15 step 2)
            Log.d(MMNewsApp.TAG, "1..15 step 2 : $index")

        for (index in 30 downTo 0 step 3)
            Log.d(MMNewsApp.TAG, "30 downTo 0 step 3 : $index")
    }

    private fun tryOutCollections() {
        val degrees = listOf("M.Med (Int.Med)(Nus, S'pore)",
                "M.Med.Sc (Int,Med)",
                "MA cad MED (UK)",
                "Fellowship in interventional Cardiology (Seoul, Korea)",
                "Consultant Heart & General Physician")

        /*
        val coolDegree = "M.Med.Sc (Int,Med)"
        if(coolDegree in degrees)
            Log.d(MMNewsApp.TAG, "Having $coolDegree is pretty awesome.")
            */

        degrees
                .filter { it.startsWith("M") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { Log.d(MMNewsApp.TAG, "Having $it is pretty awesome.") }
    }

    override fun onTapComment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapSendTo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapFavorite() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapStatistics() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapNews(news: NewsVO?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNewsLoadedEvent(newsLoadedEvent: DataEvent.NewsLoadedEvent) {
        swipeRefreshLayout.isRefreshing = false
        mNewsAdapter!!.appendNewData(newsLoadedEvent.loadedNews as MutableList<NewsVO>)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorNewsLoadedEvent(apiErrorEvent: ErrorEvent.ApiErrorEvent) {
        swipeRefreshLayout.isRefreshing = false
        Snackbar.make(rvNews, "ERROR : " + apiErrorEvent.getMsg(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEmptyNewsLoadedEvent(emptyDataLoadedEvent: DataEvent.EmptyDataLoadedEvent) {
        swipeRefreshLayout.isRefreshing = false
        Snackbar.make(rvNews, "ERROR : " + emptyDataLoadedEvent.errorMsg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }
}
