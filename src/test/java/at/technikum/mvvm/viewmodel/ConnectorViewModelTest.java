package at.technikum.mvvm.viewmodel;

import at.technikum.mvvm.model.WordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ConnectorViewModelTest {


    WordRepository wordRepository;

    ConnectorViewModel connectorViewModel;

    @Test
    public void inputStringClearTest() {
        // Arrange
        wordRepository = mock(WordRepository.class);
        connectorViewModel = new ConnectorViewModel(wordRepository);
        connectorViewModel.setString1("Hello");
        connectorViewModel.setString2("World");

        // Act
        connectorViewModel.connect();

        // Assert
        assertEquals("", connectorViewModel.getString1());
        assertEquals("", connectorViewModel.getString2());
    }

    @Test
    public void connectedStringTest() {
        // Arrange
        wordRepository = mock(WordRepository.class);
        connectorViewModel = new ConnectorViewModel(wordRepository);
        connectorViewModel.setString1("Hello");
        connectorViewModel.setString2("World");

        // Act
        connectorViewModel.connect();

        // Assert
        assertEquals("Hello World", connectorViewModel.getOutput());
    }
  
}