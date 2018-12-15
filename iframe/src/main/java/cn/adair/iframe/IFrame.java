package cn.adair.iframe;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;

public class IFrame {

    private static Context iCtx;

    public static void init(Context context) {
        IFrame.iCtx = context;
    }

    public static Context iCtx() {
        synchronized (IFrame.class) {
            if (IFrame.iCtx() == null) {
                throw new NullPointerException("Call IFrame.init(context) within your Application onCreate() method. Or extends IApplication");
            }
            return IFrame.iCtx().getApplicationContext();
        }
    }

    public static Resources iRes() {
        return IFrame.iCtx().getResources();
    }

    public static PackageInfo iPackageInfo() {
        PackageManager packageManager = IFrame.iCtx.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(iPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }

    public static String iPackageName() {
        return IFrame.iCtx.getPackageName();
    }

    public static String iVersionName() {
        return iPackageInfo().versionName;
    }

    public static int iVersionCode() {
        return iPackageInfo().versionCode;
    }

}
