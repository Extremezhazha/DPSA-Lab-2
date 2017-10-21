package dpsa.lab.dbforlogging;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.util.ArrayList;
import java.util.List;

// test helper for checking log results
// https://stackoverflow.com/questions/1827677/how-to-do-a-junit-assert-on-a-message-in-a-logger
public class TestAppender extends AppenderSkeleton {
    private final List<LoggingEvent> loggingEvents = new ArrayList<>();

    @Override
    protected void append(LoggingEvent loggingEvent) {
        loggingEvents.add(loggingEvent);
    }

    @Override
    public void close() {}

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public List<LoggingEvent> getLoggingEvents() {
        return loggingEvents;
    }
}
