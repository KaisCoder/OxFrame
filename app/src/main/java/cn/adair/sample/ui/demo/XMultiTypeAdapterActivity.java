package cn.adair.sample.ui.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.List;
import java.util.Random;

import cn.adair.sample.BaseActivity;
import cn.adair.sample.R;
import cn.adair.sample.bean.News;
import cn.adair.sample.data.NewDataSource;
import cn.adair.sample.loder.GlideImageLoader;
import cn.adair.sample.ui.adapter.StickyHeaderAdapter;
import cn.adair.xframe.adapter.XRecyclerViewAdapter;
import cn.adair.xframe.adapter.XViewHolder;
import cn.adair.xframe.adapter.decoration.DividerDecoration;
import cn.adair.xframe.adapter.decoration.StickyHeaderDecoration;
import cn.adair.xframe.utils.imageload.XImage;

public class XMultiTypeAdapterActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_xrecycler_view_adapter;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
    }

    @Override
    public void initView() {
        SwipeRefreshLayout mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        mSwipeLayout.setEnabled(false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#f2f2f2"), 15));

        //解决NestedScrollView嵌套RecycleView的滑动冲突问题
//        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final MultiTypeAdapter adapter = new MultiTypeAdapter(recyclerView, NewDataSource.getNewsList());
        recyclerView.setAdapter(adapter);

        // StickyHeader
        StickyHeaderDecoration decoration = new StickyHeaderDecoration(new StickyHeaderAdapter(this));
        decoration.setIncludeHeader(false);
        recyclerView.addItemDecoration(decoration);

        adapter.setOnItemClickListener(new XRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //修改局部item的数据，点击那个修改哪个
                int random = new Random().nextInt(9);
                News news = NewDataSource.getNewsList().get(random);
                adapter.replace(position, news);
            }
        });
    }

    class MultiTypeAdapter extends XRecyclerViewAdapter<News> {

        public MultiTypeAdapter(@NonNull RecyclerView mRecyclerView, List<News> dataLists) {
            super(mRecyclerView, dataLists);
        }

        @Override
        public int getItemLayoutResId(News data, int position) {
            int layoutResId = -1;
            switch (data.getNewsType()) {
                case News.TYPE_NONE_PICTURE:
                    layoutResId = R.layout.dome_item;
                    break;
                case News.TYPE_SINGLE_PICTURE:
                    layoutResId = R.layout.dome_image_item;
                    break;
            }
            return layoutResId;
        }

        @Override
        public void bindData(XViewHolder holder, News data, int position) {
            switch (data.getNewsType()) {
                case News.TYPE_NONE_PICTURE:
                    holder.setText(R.id.text, data.getTitle());
                    break;
                case News.TYPE_SINGLE_PICTURE:
                    holder.setText(R.id.newTitle, data.getTitle())
                            .setText(R.id.newAuthor, data.getAuthor())
                            .setText(R.id.newTime, data.getTime());
                    //holder.setImageUrl(R.id.newImage,data.getImageUrl(),GlideImageLoader.circleTransform)
                    ImageView imageView = holder.getView(R.id.newImage);
                    XImage.getInstance().load(imageView,
                            data.getImageUrl(),
                            GlideImageLoader.circleTransform);

                    break;
            }
        }
    }
}
