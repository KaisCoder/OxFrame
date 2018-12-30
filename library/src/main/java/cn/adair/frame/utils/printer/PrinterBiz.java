package cn.adair.frame.utils.printer;

import java.util.List;
import java.util.Map;

public interface PrinterBiz {

    void debug(String message, Object... args);

    void error(String message, Object... args);

    void error(Throwable throwable, String message, Object... args);

    void warn(String message, Object... args);

    void info(String message, Object... args);

    void json(String json);

    void xml(String xml);

    void map(Map map);

    void list(List list);

    String format();

}
