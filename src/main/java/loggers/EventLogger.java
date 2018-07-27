package loggers;

import beans.Event;

/**
 * <p><strong>Executive Summary</strong><br>
 *
 * <p><strong>State Information</strong><br>
 *
 * <p><strong>Implementational Details</strong><br>
 *
 * <p><strong>Created</strong> on: Jul 19, 2018
 *
 * @author Vladimir Kremnyov (vkre@isddesign.com)
 */
public interface EventLogger {

    void logEvent(Event event);

}
