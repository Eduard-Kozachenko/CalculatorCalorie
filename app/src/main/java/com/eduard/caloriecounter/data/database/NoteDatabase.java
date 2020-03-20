package com.eduard.caloriecounter.data.database;

import com.eduard.caloriecounter.data.dao.DaoAccess;
import com.eduard.caloriecounter.presentation.model.Note;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
