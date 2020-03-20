package com.eduard.caloriecounter.data.dao;

import com.eduard.caloriecounter.presentation.model.Note;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DaoAccess {

    @Insert
    Long insertTask(Note note);

    @Query("SELECT * FROM Note ORDER BY created_at desc")
    LiveData<List<Note>> fetchAllTasks();

    @Query("SELECT * FROM Note WHERE id =:taskId")
    LiveData<Note> getTask(int taskId);

    @Update
    void updateTask(Note note);

    @Delete
    void deleteTask(Note note);
}
