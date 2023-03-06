package at.technikum.mvvm.view;

import at.technikum.mvvm.model.WordRepository;
import at.technikum.mvvm.viewmodel.ConnectorViewModel;
import at.technikum.mvvm.viewmodel.WordListViewModel;

public class ViewFactory {

    private static ViewFactory instance;

    private final WordRepository wordRepository;
    private final ConnectorViewModel connectorViewModel;
    private final WordListViewModel wordListViewModel;

    private ViewFactory() {
        wordRepository = new WordRepository();
        connectorViewModel = new ConnectorViewModel(wordRepository);
        wordListViewModel = new WordListViewModel(wordRepository);
    }

    public Object create(Class<?> viewClass) {
        if (viewClass == ConnectorView.class) {
            return new ConnectorView(connectorViewModel);
        }
        if (viewClass == WordListView.class) {
            return new WordListView(wordListViewModel);
        }
        if (viewClass == MainView.class) {
            return new MainView();
        }

        throw new IllegalArgumentException();
    }

    public static ViewFactory getInstance() {
        if (null == instance) {
            instance = new ViewFactory();
        }
        return instance;
    }
}
