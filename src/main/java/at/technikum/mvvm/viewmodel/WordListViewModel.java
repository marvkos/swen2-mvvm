package at.technikum.mvvm.viewmodel;

import at.technikum.mvvm.model.WordRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WordListViewModel {

    private final ObservableList<String> words = FXCollections.observableArrayList();

    private final WordRepository wordRepository;

    public WordListViewModel(WordRepository wordRepository) {
        this.wordRepository = wordRepository;

        words.addAll(wordRepository.findAll());

        wordRepository.addNewWordListener(this::addNewWord);
    }

    private void addNewWord(String word) {
        words.add(word);
    }

    public ObservableList<String> getWords() {
        return words;
    }
}
