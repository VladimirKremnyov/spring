package loggers;

import beans.Event;

import java.util.List;

/**
 * <p><strong>Executive Summary</strong><br>
 *
 * <p><strong>State Information</strong><br>
 *
 * <p><strong>Implementational Details</strong><br>
 *
 * <p><strong>Created</strong> on: Jul 26, 2018
 *
 * @author Vladimir Kremnyov (vkre@isddesign.com)
 */
public class CombinedEventLogger implements EventLogger {

    private List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {

        loggers.forEach(logger -> logEvent(event));
    }

}
