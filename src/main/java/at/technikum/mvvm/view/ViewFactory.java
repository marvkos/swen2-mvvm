package at.technikum.mvvm.view;

import at.technikum.mvvm.data.HibernateSessionFactory;
import at.technikum.mvvm.event.EventAggregator;
import at.technikum.mvvm.repository.WordRepository;
import at.technikum.mvvm.service.WordService;
import at.technikum.mvvm.viewmodel.ConnectorViewModel;
import at.technikum.mvvm.viewmodel.WordListViewModel;

public class ViewFactory {

    private static ViewFactory instance;

    private final EventAggregator eventAggregator;

    private final HibernateSessionFactory sessionFactory;

    private final WordRepository wordRepository;

    private final WordService wordService;
    private final ConnectorViewModel connectorViewModel;
    private final WordListViewModel wordListViewModel;

    private ViewFactory() {
        eventAggregator = new EventAggregator();
        sessionFactory = new HibernateSessionFactory();
        wordRepository = new WordRepository(sessionFactory, eventAggregator);
        wordService = new WordService(wordRepository);
        connectorViewModel = new ConnectorViewModel(wordService);
        wordListViewModel = new WordListViewModel(eventAggregator, wordService);
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
