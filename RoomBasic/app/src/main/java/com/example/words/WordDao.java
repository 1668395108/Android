package com.example.words;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insertWord(Word... words);

    @Update
    void updateWord(Word... words);

    @Delete
    void deleteWord(Word... words);

    @Query("DELETE FROM WORD")
    void deleteallWord();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
   // List<Word> getAllWord();
    LiveData<List<Word>> getAllWordLive();
    @Query("SELECT * FROM WORD WHERE english_word LIKE :patten ORDER BY ID DESC")
    LiveData<List<Word>> findWordWithPatten(String patten);

}
