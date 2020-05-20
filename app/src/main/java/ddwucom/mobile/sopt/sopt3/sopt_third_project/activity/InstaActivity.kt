package ddwucom.mobile.sopt.sopt3.sopt_third_project.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import ddwucom.mobile.sopt.sopt3.sopt_third_project.MainPagerAdapter
import ddwucom.mobile.sopt.sopt3.sopt_third_project.R
import kotlinx.android.synthetic.main.activity_insta.*

class InstaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta)

        main_viewPager.adapter =
            MainPagerAdapter(
                supportFragmentManager
            )
        main_viewPager.offscreenPageLimit = 2
        main_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                //navigation 메뉴 아이템 체크
                bottomNavigationView.menu.getItem(position).isChecked = true
            }

        })


        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> main_viewPager.currentItem = 0
                R.id.menu_book -> main_viewPager.currentItem = 1
                R.id.menu_person -> main_viewPager.currentItem = 2
            }
            true
        }
    }
}