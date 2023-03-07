package at.technikum.mvvm.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventAggregator {

    private final Map<Event, List<Subscriber>> eventListMap;

    public EventAggregator() {
        eventListMap = new HashMap<>();
    }

    public void publish(Event event) {
        List<Subscriber> subscribers = eventListMap.get(event);

        if (null == subscribers) {
            return;
        }

        // update subscribers
        for (Subscriber s: subscribers) {
            s.update();
        }
    }

    public void addSubscriber(Event event, Subscriber subscriber) {
        List<Subscriber> subscribers = eventListMap.get(event);

        if (null == subscribers) {
            subscribers = new ArrayList<>();
            eventListMap.put(event, subscribers);
        }

        if (subscribers.contains(subscriber)) {
            return;
        }

        subscribers.add(subscriber);
    }
}
