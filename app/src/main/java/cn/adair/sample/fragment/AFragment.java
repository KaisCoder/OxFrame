package cn.adair.sample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import cn.adair.sample.R;

/**
 * cn.adair.sample.fragment
 * Created by WangChangYun on 2019/10/22 14:25
 * slight negligence may lead to great disaster~
 */
public class AFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, null);
        return view;
    }

}
