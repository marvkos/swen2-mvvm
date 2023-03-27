package at.technikum.mvvm.viewmodel;

import at.technikum.mvvm.event.EventAggregator;
import at.technikum.mvvm.service.WordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WordListViewModelTest {

    EventAggregator eventAggregator;
    WordService wordService;

    WordListViewModel wordListViewModel;

    @Test
    public void initialWordListTest() {
        // Arrange
        eventAggregator = mock(EventAggregator.class);
        wordService = mock(WordService.class);

        List<String> words = new ArrayList<>();
        words.add("Hello World");

        when(wordService.findAll()).thenReturn(words);

        // Act
        wordListViewModel = new WordListViewModel(
                eventAggregator, wordService
        );

        // Assert
        assertEquals(1, wordListViewModel.getWords().size());
        assertEquals("Hello World", wordListViewModel.getWords().get(0));
    }
}