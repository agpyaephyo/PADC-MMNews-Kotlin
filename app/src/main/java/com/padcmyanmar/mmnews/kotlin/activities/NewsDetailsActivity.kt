package com.padcmyanmar.mmnews.kotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.padcmyanmar.mmnews.kotlin.R
import com.padcmyanmar.mmnews.kotlin.adapters.NewsDetailsImagesAdapter
import com.padcmyanmar.mmnews.kotlin.data.models.NewsAppModel
import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : BaseActivity() {

    lateinit var mNewsDetailsImagesAdapter: NewsDetailsImagesAdapter

    companion object {
        const val IE_NEWS_ID = "IE_NEWS_ID"

        fun newIntent(context: Context, newsId: String): Intent {
            val intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra(IE_NEWS_ID, newsId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        mNewsDetailsImagesAdapter = NewsDetailsImagesAdapter()
        vpNewsDetailsImages.adapter = mNewsDetailsImagesAdapter

        val newsId = intent.getStringExtra(IE_NEWS_ID)
        val news = NewsAppModel.getInstance().getNewsById(newsId)
        if (news != null) {
            tvNewsDetails.text = news.details
            Glide.with(applicationContext)
                    .load(news.publication!!.logo)
                    .into(ivPublicationLogo)
            tvPublicationName.text = news.publication!!.title
            tvPublishedDate.text = news.postedDate

            mNewsDetailsImagesAdapter.setNewData(news.images)
        }
    }
}