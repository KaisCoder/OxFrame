package cn.adair.frame.utils;

import android.widget.Toast;

import cn.adair.frame.OxFrame;

public class OxToast {

    public static void showShort(String message) {
        Toast.makeText(OxFrame.iCtx(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String message) {
        Toast.makeText(OxFrame.iCtx(), message, Toast.LENGTH_LONG).show();
    }


}
