package cn.adair.sample.loder;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import cn.adair.sample.view.GlideCircleTransform;
import cn.adair.xframe.utils.imageload.ImageLoader;


public class GlideImageLoader implements ImageLoader {

    private Context mContext;

    public static GlideCircleTransform circleTransform;

    public GlideImageLoader(Context context) {
        this.mContext = context;
        circleTransform = new GlideCircleTransform();
    }

    @Override
    public void load(ImageView imageView, Object imageUrl) {
        Glide.with(mContext)
                .load(imageUrl)
                .into(imageView);
    }

    @Override
    public void load(ImageView imageView, Object imageUrl, int defaultImage) {
        Glide.with(mContext)
                .load(imageUrl)
                .placeholder(defaultImage)
                .into(imageView);
    }

    @Override
    public void load(ImageView imageView, Object imageUrl, Object transformation) {
        Glide.with(mContext)
                .load(imageUrl)
                .transform((BitmapTransformation) transformation)
                .into(imageView);
    }
}
