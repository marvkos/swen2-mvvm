package at.technikum.mvvm.model;

import at.technikum.mvvm.event.NewWordEvent;

import java.util.ArrayList;
import java.util.List;

public class WordRepository {

    private final List<String> words;

    private final List<NewWordEvent> newWordEvents;

    public WordRepository() {
        words = new ArrayList<>();
        newWordEvents = new ArrayList<>();
    }

    private void notifyNewWordListeners(String word) {
        for (NewWordEvent nwe: newWordEvents) {
            nwe.newWord(word);
        }
    }

    public void addNewWordListener(NewWordEvent newWordEvent) {
        newWordEvents.add(newWordEvent);
    }

    public void save(String word) {
        words.add(word);

        notifyNewWordListeners(word);
    }

    public List<String> findAll() {
        return words;
    }
}
