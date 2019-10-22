package cn.adair.sample.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import cn.adair.frame.utils.OxPrinter;

/**
 * cn.adair.sample.adapter
 * Created by WangChangYun on 2019/10/22 14:29
 * slight negligence may lead to great disaster~
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    private int mBehavior;
    private FragmentManager mFragmentManager;

    public FragmentAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
        this(fm, BEHAVIOR_SET_USER_VISIBLE_HINT);
        this.mFragmentList = list;
    }

    private FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        mFragmentManager = fm;
        mBehavior = behavior;
        OxPrinter.error("------->" + behavior);
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Fragment fragment = (Fragment) object;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
