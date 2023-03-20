package at.technikum.mvvm.service;

import at.technikum.mvvm.model.WordRepository;

import java.util.List;

public class WordService {

    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public void save(String word) {
        wordRepository.save(word);
    }

    public List<String> findAll() {
        return wordRepository.findAll();
    }
}
