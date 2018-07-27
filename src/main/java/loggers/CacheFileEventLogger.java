package loggers;

import beans.Event;

import java.util.ArrayList;
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
public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }

    public void destroy() {
        if(!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }

    public void logEvent(Event event) {

        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {

        cache.stream().forEach(super::logEvent);
    }

}
