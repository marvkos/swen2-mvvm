package at.technikum.mvvm.viewmodel;

import at.technikum.mvvm.model.WordRepository;
import at.technikum.mvvm.service.WordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ConnectorViewModelTest {


    WordService wordService;

    ConnectorViewModel connectorViewModel;

    @Test
    public void inputStringClearTest() {
        // Arrange
        wordService = mock(WordService.class);
        connectorViewModel = new ConnectorViewModel(wordService);
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
        wordService = mock(WordService.class);
        connectorViewModel = new ConnectorViewModel(wordService);
        connectorViewModel.setString1("Hello");
        connectorViewModel.setString2("World");

        // Act
        connectorViewModel.connect();

        // Assert
        assertEquals("Hello World", connectorViewModel.getOutput());
    }
  
}