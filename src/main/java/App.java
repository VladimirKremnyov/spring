import beans.Client;
import beans.Event;
import beans.EventType;
import loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

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
public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App)context.getBean("app");

        Client client = context.getBean(Client.class);

        System.out.println("Client says: " + client.getGreeting());

        Event event = context.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "some event for 1");

        event = context.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "some event for 2");

        event = context.getBean(Event.class);
        app.logEvent(null, event, "some event for 3");

        context.close();
    }

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {

        this.client = client;
        this.loggers = loggers;
        this.defaultLogger = defaultLogger;
    }

    private void logEvent(EventType eventType, Event event, String msg) {

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }

        logger.logEvent(event);
    }

}
