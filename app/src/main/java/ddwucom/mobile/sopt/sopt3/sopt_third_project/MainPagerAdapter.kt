package ddwucom.mobile.sopt.sopt3.sopt_third_project

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ddwucom.mobile.sopt.sopt3.sopt_third_project.fragment.HomeFragment
import ddwucom.mobile.sopt.sopt3.sopt_third_project.fragment.LibraryFragment
import ddwucom.mobile.sopt.sopt3.sopt_third_project.fragment.MypageFragment

class MainPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> LibraryFragment()
            else -> MypageFragment()
        }
    }

    override fun getCount() = 3
}