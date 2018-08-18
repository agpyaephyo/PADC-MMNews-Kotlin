package com.padcmyanmar.mmnews.kotlin.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.padcmyanmar.mmnews.kotlin.fragments.BaseFragment

class AccountControlAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private var mFragments: ArrayList<BaseFragment> = ArrayList()
    private var mFragmentTitles: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitles[position]
    }

    fun addTab(fragment : BaseFragment, screenTitle : String) {
        mFragments.add(fragment)
        mFragmentTitles.add(screenTitle)
        notifyDataSetChanged()
    }
}