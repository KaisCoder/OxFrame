package cn.adair.frame.utils.printer;

import android.util.Log;

public class PrinterUtil {

    /**
     * Android一个日志条目不能超过4076字节，
     * 这里设置以4000字节来计算
     */
    private static final int CHUNK_SIZE = 4000;

    /**
     * 样式
     */
    private static final char TOP_LEFT_CORNER = '┏';
    private static final char BOTTOM_LEFT_CORNER = '┗';
    private static final char MIDDLE_CORNER = '┠';
    private static final char HORIZONTAL_DOUBLE_LINE = '┃';
    private static final String DOUBLE_DIVIDER = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
    private static final String SINGLE_DIVIDER = "──────────────────────────────────────────────";
    private static final String TOP_BORDER = TOP_LEFT_CORNER + DOUBLE_DIVIDER;
    private static final String BOTTOM_BORDER = BOTTOM_LEFT_CORNER + DOUBLE_DIVIDER;
    private static final String MIDDLE_BORDER = MIDDLE_CORNER + SINGLE_DIVIDER;

    public static StringBuilder iString = new StringBuilder();

    /**
     * 同步日志打印顺序
     */
    public static synchronized void log(int priority, String msg, Object... args) {
        if (!PrinterSet.isDebug) {
            return;
        }
        iString.delete(0, iString.length());
        String message = args.length == 0 ? msg : String.format(msg, args);
        logChunk(priority, TOP_BORDER);
        if (PrinterSet.isShowStack) {
            //打印线程
            logStackInfo(priority);
        }
        //得到系统的默认字符集的信息字节（UTF-8）
        byte[] bytes = message.getBytes();
        int length = bytes.length;
        if (length <= CHUNK_SIZE) {
            logContent(priority, message);
            logChunk(priority, BOTTOM_BORDER);
            return;
        }
        for (int i = 0; i < length; i += CHUNK_SIZE) {
            int count = Math.min(length - i, CHUNK_SIZE);
            //创建系统的默认字符集的一个新的字符串（UTF-8）
            logContent(priority, new String(bytes, i, count));
        }
        logChunk(priority, BOTTOM_BORDER);
    }

    /**
     * 打印堆栈信息.
     */
    private static void logStackInfo(int priority) {
        logChunk(priority, HORIZONTAL_DOUBLE_LINE + "[Thread] → " + Thread.currentThread().getName());
        logChunk(priority, MIDDLE_BORDER);
        String str = "";
        StackTraceElement[] traces = Thread.currentThread().getStackTrace();

        for (int i = 0; i < traces.length; i++) {
            StackTraceElement element = traces[i];
            StringBuilder perTrace = new StringBuilder(str);
            if (element.isNativeMethod()) {
                continue;
            }
            String className = element.getClassName();
            if (className.startsWith("android.") || className.contains("com.android") || className.contains("java.lang") || className.contains("com.youth.xframe")) {
                continue;
            }
            perTrace.append(element.getClassName())
                    .append('.')
                    .append(element.getMethodName())
                    .append("  (")
                    .append(element.getFileName())
                    .append(':')
                    .append(element.getLineNumber())
                    .append(")");
            str += "  ";
            logContent(priority, perTrace.toString());
        }
        logChunk(priority, MIDDLE_BORDER);
    }

    private static void logChunk(int priority, String chunk) {
        iString.append(PrinterSet.LINE_SEPARATOR);
        iString.append(chunk);
        switch (priority) {
            case Log.ERROR:
                Log.e(PrinterSet.TAG, chunk);
                break;
            case Log.INFO:
                Log.i(PrinterSet.TAG, chunk);
                break;
            case Log.VERBOSE:
                Log.v(PrinterSet.TAG, chunk);
                break;
            case Log.WARN:
                Log.w(PrinterSet.TAG, chunk);
                break;
            case Log.ASSERT:
                Log.wtf(PrinterSet.TAG, chunk);
                break;
            case Log.DEBUG:
            default:
                Log.d(PrinterSet.TAG, chunk);
                break;
        }
    }

    private static void logContent(int priority, String chunk) {
        String[] lines = chunk.split(PrinterSet.LINE_SEPARATOR);
        for (String line : lines) {
            logChunk(priority, HORIZONTAL_DOUBLE_LINE + " " + line);
        }
    }

}
