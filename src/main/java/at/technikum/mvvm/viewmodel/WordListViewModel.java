package at.technikum.mvvm.viewmodel;

import at.technikum.mvvm.event.Event;
import at.technikum.mvvm.event.EventAggregator;
import at.technikum.mvvm.service.WordService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WordListViewModel {

    private final ObservableList<String> words = FXCollections.observableArrayList();

    private final EventAggregator eventAggregator;
    private final WordService wordService;

    public WordListViewModel(
            EventAggregator eventAggregator,
            WordService wordService
    ) {
        this.eventAggregator = eventAggregator;
        this.wordService = wordService;

        words.addAll(wordService.findAll());

        eventAggregator.addSubscriber(
                Event.NEW_WORD,
                this::onNewWord
        );
    }

    private void onNewWord() {
        words.clear();
        words.addAll(wordService.findAll());
    }

    public ObservableList<String> getWords() {
        return words;
    }
}
