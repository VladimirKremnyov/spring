package beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p><strong>Executive Summary</strong><br>
 *
 * <p><strong>State Information</strong><br>
 *
 * <p><strong>Implementational Details</strong><br>
 *
 * <p><strong>Created</strong> on: Jul 23, 2018
 *
 * @author Vladimir Kremnyov (vkre@isddesign.com)
 */
public class Event {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private int id;
    private String msg;
    private Date date;

    private DateFormat df;

    public Event(Date date, DateFormat df) {

        this.date = date;
        this.df = df;
    }

    public void setDate(Date date) {

        this.id = AUTO_ID.getAndIncrement();
        this.date = date;
    }

    public int getId() {

        return id;
    }

    public String getMsg() {

        return msg;
    }

    public Date getDate() {

        return date;
    }

    public void setMsg(String msg) {

        this.msg = msg;
    }

    @Override
    public String toString() {

        return "beans.Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
