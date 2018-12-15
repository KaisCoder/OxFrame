package cn.adair.sample.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import cn.adair.iframe.base.IBaseFragment;
import cn.adair.sample.R;
import cn.adair.sample.ui.demo.XCacheActivity;
import cn.adair.sample.ui.demo.XHttpActivity;
import cn.adair.sample.ui.demo.XLoadingDialogActivity;
import cn.adair.sample.ui.demo.XLoadingViewActivity;
import cn.adair.sample.ui.demo.XLogDemoActivity;
import cn.adair.sample.ui.demo.XPermissionDemoActivity;
import cn.adair.sample.ui.demo.XRecyclerViewAdapterActivity;
import cn.adair.sample.ui.demo.XToastActivity;
import cn.adair.xframe.widget.NoScrollListView;

public class DemoFragment extends IBaseFragment {

    NoScrollListView listView;
    String[] demo;

    @Override
    public int initLayout() {
        return R.layout.demo_fragment;
    }

    @Override
    public void initView() {
        listView = _mView.findViewById(R.id.demoList);
        listView.setOnItemClickListener(mOnItemListener);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        demo = getResources().getStringArray(R.array.demo_list);

    }

    AdapterView.OnItemClickListener mOnItemListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Intent intent = new Intent();
            switch (position) {
                case 0:
                    intent.setClass(_mContext, XLogDemoActivity.class);
                    break;
                case 1:
                    intent.setClass(_mContext, XPermissionDemoActivity.class);
                    break;
                case 2:
                    intent.setClass(_mContext, XRecyclerViewAdapterActivity.class);
                    break;
                case 3:
                    intent.setClass(_mContext, XLoadingDialogActivity.class);
                    break;
                case 4:
                    intent.setClass(_mContext, XToastActivity.class);
                    break;
                case 5:
                    intent.setClass(_mContext, XLoadingViewActivity.class);
                    break;
                case 6:
                    intent.setClass(_mContext, XCacheActivity.class);
                    break;
                case 7:
                    intent.setClass(_mContext, XHttpActivity.class);
            }
            intent.putExtra("title", demo[position]);
            startActivity(intent);
        }
    };

}
