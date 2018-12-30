package cn.adair.frame.utils.printer;

public class PrinterSet {

    static String TAG = "OxFrame";
    static boolean isDebug = true;
    static boolean isShowStack = true;

    static String LINE_SEPARATOR = System.getProperty("line.separator");

    private static PrinterSet instance = null;

    public static PrinterSet instance() {
        if (null == instance) {
            synchronized (PrinterSet.class) {
                if (null == instance) {
                    instance = new PrinterSet();
                }
            }
        }
        return instance;
    }

    public PrinterSet setTAG(String tag) {
        TAG = tag;
        return this;
    }

    public PrinterSet isDebug(boolean debug) {
        isDebug = debug;
        return this;
    }

    public PrinterSet isShowStack(boolean show) {
        isShowStack = show;
        return this;
    }

}
