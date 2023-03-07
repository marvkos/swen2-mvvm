package at.technikum.mvvm.viewmodel;

import at.technikum.mvvm.event.Event;
import at.technikum.mvvm.event.EventAggregator;
import at.technikum.mvvm.model.WordRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WordListViewModel {

    private final ObservableList<String> words = FXCollections.observableArrayList();

    private final EventAggregator eventAggregator;
    private final WordRepository wordRepository;

    public WordListViewModel(
            EventAggregator eventAggregator,
            WordRepository wordRepository
    ) {
        this.eventAggregator = eventAggregator;
        this.wordRepository = wordRepository;

        words.addAll(wordRepository.findAll());

        eventAggregator.addSubscriber(
                Event.NEW_WORD,
                this::onNewWord
        );
    }

    private void onNewWord() {
        words.clear();
        words.addAll(wordRepository.findAll());
    }

    public ObservableList<String> getWords() {
        return words;
    }
}
