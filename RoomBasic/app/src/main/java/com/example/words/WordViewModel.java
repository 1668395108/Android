package com.example.words;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    WordRepository wordRepository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
    }

    LiveData<List<Word>> getAllWordLife() {
        return wordRepository.getAllWordLife();
    }
    LiveData<List<Word>> findWordWithPatten(String patten){
        return  wordRepository.findWordWithPatten(patten);
    }

    void insertWord(Word... words) {
        wordRepository.insertWord(words);
    }

    void updateWord(Word... words) {
        wordRepository.updateWord(words);
    }

    void deleteWord(Word... words) {
        wordRepository.deleteWord(words);
    }

    void deleteallWord() {
        wordRepository.deleteallWord();
    }

}
