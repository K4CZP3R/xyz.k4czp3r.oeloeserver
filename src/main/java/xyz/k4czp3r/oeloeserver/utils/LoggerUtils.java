package xyz.k4czp3r.oeloeserver.utils;

import java.util.logging.Logger;

public class LoggerUtils {
    private Logger logger;
    public LoggerUtils(Logger logger)
    {
        this.logger = logger;
    }

    public void out(String content)
    {
        this.logger.info(content);
    }
}
