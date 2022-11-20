package com.suhyunmin.family_letter_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.suhyunmin.family_letter_android.views.AlbumFragment
import com.suhyunmin.family_letter_android.views.HistoryFragment
import com.suhyunmin.family_letter_android.views.MainFragment
import com.suhyunmin.family_letter_android.views.SettingFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = MainFragment()
        val historyFragment = HistoryFragment()
        val albumFragment = AlbumFragment()
        val settingFragment = SettingFragment()

        replaceFragment(mainFragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.main -> replaceFragment(mainFragment)
                R.id.history -> replaceFragment(historyFragment)
                R.id.album -> replaceFragment(albumFragment)
                R.id.setting -> replaceFragment(settingFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        // 현 Activity 에 연결된 Fragment 관리하는 supportFragmentManager 를 통해 Fragment 전환
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
    }
}
