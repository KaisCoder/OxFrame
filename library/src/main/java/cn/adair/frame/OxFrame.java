package cn.adair.frame;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;

import cn.adair.frame.utils.printer.PrinterSet;

public class OxFrame {

    private static Context iCtx;

    public static void init(Context context) {
        OxFrame.iCtx = context;
    }

    public static Context iCtx() {
        synchronized (OxFrame.class) {
            if (OxFrame.iCtx() == null) {
                throw new NullPointerException("Call OxFrame.init(context) within your Application onCreate() method.");
            }
            return OxFrame.iCtx().getApplicationContext();
        }
    }

    public static void initPrinter(String tag, boolean isDebug, boolean isShowStack) {
        PrinterSet.instance().setTAG(tag).isDebug(isDebug).isShowStack(isShowStack);
    }

    public static Resources iRes() {
        return OxFrame.iCtx().getResources();
    }

    public static String iPackageName() {
        return OxFrame.iCtx.getPackageName();
    }

    public static String iVersionName() {
        return iPackageInfo().versionName;
    }

    public static int iVersionCode() {
        return iPackageInfo().versionCode;
    }

    public static PackageInfo iPackageInfo() {
        PackageManager packageManager = OxFrame.iCtx.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(iPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }

}
