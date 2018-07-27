package loggers;

import beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * <p><strong>Executive Summary</strong><br>
 *
 * <p><strong>State Information</strong><br>
 *
 * <p><strong>Implementational Details</strong><br>
 *
 * <p><strong>Created</strong> on: Jul 24, 2018
 *
 * @author Vladimir Kremnyov (vkre@isddesign.com)
 */
public class FileEventLogger implements EventLogger {

    private String filename;
    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void init() throws IOException {
        this.file = new File(filename);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + filename);
        } else if (!file.exists()) {
            file.createNewFile();
        } // cgheck if we can write to file (do we have access or if file is busy)
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(this.file, event.toString() + "\n", Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
