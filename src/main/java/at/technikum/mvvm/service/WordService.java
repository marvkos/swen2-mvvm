package at.technikum.mvvm.service;

import at.technikum.mvvm.model.Word;
import at.technikum.mvvm.repository.WordRepository;

import java.util.List;
import java.util.stream.Collectors;

public class WordService {

    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public void save(String word) {
        wordRepository.save(new Word(word));
    }

    public List<String> findAll() {
        return wordRepository.findAll()
                .stream()
                .map(Word::getValue)
                .collect(Collectors.toList());
    }
}
