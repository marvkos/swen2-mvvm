package at.technikum.mvvm.view;

import at.technikum.mvvm.viewmodel.WordListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class WordListView {

    @FXML
    private ListView<String> words;

    private final WordListViewModel wordListViewModel;

    public WordListView(WordListViewModel wordListViewModel) {
        this.wordListViewModel = wordListViewModel;
    }

    @FXML
    void initialize() {
        words.setItems(wordListViewModel.getWords());
    }
}
