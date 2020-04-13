package com.eduard.caloriecounter.di.module;

import android.app.Application;

import com.eduard.caloriecounter.data.dao.NoteDao;
import com.eduard.caloriecounter.data.database.NoteDatabase;
import com.eduard.caloriecounter.data.repository.NoteRepository;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    private final NoteDatabase database;

    public RoomModule(Application application) {
        this.database = Room.databaseBuilder(application, NoteDatabase.class, "note_database").build();
    }

    @Provides
    @Singleton
    NoteRepository provideNoteRepository(NoteDao listItemDao){
        return new NoteRepository((Application) listItemDao);
    }

    @Provides
    @Singleton
    NoteDao provideNoteDao(NoteDatabase database){
        return database.noteDao();
    }

    @Provides
    @Singleton
    NoteDatabase provideNoteDatabase(Application application){
        return database;
    }
}
