package cn.adair.frame.widget;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.adair.xframe.R;
import cn.adair.xframe.utils.XEmptyUtils;
import cn.adair.frame.utils.OxOutdatedUtil;

/**
 * 加载等待提示框
 */
public class OxLoading extends Dialog {

    private Context iContext;

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private static OxLoading dialog;

    private ProgressBar iProgressBar;
    private TextView iLoadingMessage;
    private LinearLayout iLoadingView;

    private OxDrawable drawable;

    private OxLoading(Context context) {
        super(context, R.style.Ox_Style_Loading);
        this.iContext = context;
        setContentView(R.layout.ox_loading);
        iLoadingMessage = findViewById(R.id.ox_loading_message);
        iProgressBar = findViewById(R.id.ox_loading_progressbar);

        iLoadingView = findViewById(R.id.ox_loading_view);
        iLoadingMessage.setPadding(15, 0, 0, 0);
        drawable = new OxDrawable();
        drawable.setColor(Color.WHITE);
        OxOutdatedUtil.setBackground(iLoadingView, drawable);
    }

    public static OxLoading with(Context context) {
        if (dialog == null) {
            dialog = new OxLoading(context);
        }
        return dialog;
    }

    public OxLoading setOrientation(int orientation) {
        iLoadingView.setOrientation(orientation);
        if (orientation == HORIZONTAL) {
            iLoadingMessage.setPadding(15, 0, 0, 0);
        } else {
            iLoadingMessage.setPadding(0, 15, 0, 0);
        }
        return dialog;
    }

    public OxLoading setBackgroundColor(@ColorInt int color) {
        drawable.setColor(color);
        OxOutdatedUtil.setBackground(iLoadingView, drawable);
        return dialog;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (dialog != null) {
            dialog = null;
        }
    }

    public OxLoading setCanceled(boolean cancel) {
        setCanceledOnTouchOutside(cancel);
        setCancelable(cancel);
        return dialog;
    }

    public OxLoading setMessage(String message) {
        if (!XEmptyUtils.isSpace(message)) {
            iLoadingMessage.setText(message);
        }
        return this;
    }

    public OxLoading setMessageColor(@ColorInt int color) {
        iLoadingMessage.setTextColor(color);
        return this;
    }

    public OxLoading setProgressBarColor(int colorId) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            Drawable wrapDrawable = DrawableCompat.wrap(iProgressBar.getIndeterminateDrawable());
            DrawableCompat.setTint(wrapDrawable, ContextCompat.getColor(iContext, colorId));
            iProgressBar.setIndeterminateDrawable(DrawableCompat.unwrap(wrapDrawable));
        } else {
            iProgressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(iContext, colorId), PorterDuff.Mode.SRC_IN);
        }
        return this;
    }

    public class OxDrawable extends Drawable {

        private Paint mPaint;
        private int color;
        private RectF rectF;

        OxDrawable() {
            mPaint = new Paint();
            // 是否抗锯齿
            mPaint.setAntiAlias(true);
        }

        public OxDrawable(int color) {
            this.color = color;
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
        }

        public void setColor(@ColorInt int color) {
            this.color = color;
        }

        @Override
        public void setBounds(int left, int top, int right, int bottom) {
            super.setBounds(left, top, right, bottom);
            rectF = new RectF(left, top, right, bottom);
        }

        @Override
        public void draw(@NonNull Canvas canvas) {
            mPaint.setColor(color);
            canvas.drawRoundRect(rectF, 20, 20, mPaint);
        }

        @Override
        public void setAlpha(int alpha) {
            mPaint.setAlpha(alpha);
        }

        @Override
        public void setColorFilter(ColorFilter colorFilter) {
            mPaint.setColorFilter(colorFilter);
        }

        @Override
        public int getOpacity() {
            return PixelFormat.TRANSLUCENT;
        }

    }


}
