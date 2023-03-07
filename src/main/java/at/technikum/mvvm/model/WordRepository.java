package at.technikum.mvvm.model;

import at.technikum.mvvm.event.Event;
import at.technikum.mvvm.event.EventAggregator;

import java.util.ArrayList;
import java.util.List;

public class WordRepository {

    private final List<String> words;

    private final EventAggregator eventAggregator;

    public WordRepository(EventAggregator eventAggregator) {
        this.eventAggregator = eventAggregator;
        words = new ArrayList<>();
    }


    public void save(String word) {
        words.add(word);

        eventAggregator.publish(Event.NEW_WORD);
    }

    public List<String> findAll() {
        return words;
    }
}
