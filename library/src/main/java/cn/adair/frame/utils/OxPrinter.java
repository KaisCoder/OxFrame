package cn.adair.frame.utils;

import java.util.List;
import java.util.Map;

import cn.adair.frame.utils.printer.PrinterBiz;
import cn.adair.frame.utils.printer.PrinterImpl;

public class OxPrinter {

    private static final PrinterBiz printer = new PrinterImpl();

    public static String format() {
        return printer.format();
    }

    public static void debug(String message, Object... args) {
        printer.debug(message, args);
    }

    public static void error(String message, Object... args) {
        printer.error(null, message, args);
    }

    public static void error(Throwable throwable, String message, Object... args) {
        printer.error(throwable, message, args);
    }

    public static void info(String message, Object... args) {
        printer.info(message, args);
    }

    public static void warn(String message, Object... args) {
        printer.warn(message, args);
    }

    public static void json(String json) {
        printer.json(json);
    }

    public static void xml(String xml) {
        printer.xml(xml);
    }

    public static void map(Map map) {
        printer.map(map);
    }

    public static void list(List list) {
        printer.list(list);
    }
}
