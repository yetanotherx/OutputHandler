package yetanotherx.bukkitplugin.OutputHandler;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

class OutputHandlerFilter implements Filter {

    public OutputHandlerFilter() {
        boolean it = true;
    }

    public boolean isLoggable(LogRecord lr) {

        if (lr.getMessage().matches("Time ran backwards!")) {
            OutputHandler.too_fast_log.warning(lr.getMessage());
            return false;
        }
        else if (lr.getMessage().matches("Can't keep up!")) {
            OutputHandler.too_slow_log.warning(lr.getMessage());
            return false;
        }
        else {
            return true;
        }
    }
}
