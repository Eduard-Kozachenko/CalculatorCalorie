package com.eduard.caloriecounter.presentation.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.eduard.caloriecounter.R;
import com.eduard.caloriecounter.presentation.model.Note;
import com.eduard.caloriecounter.presentation.utils.NoteViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RecyclerView recyclerView = findViewById(R.id.rv_main);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//
//        NoteAdapter noteAdapter = new NoteAdapter();
//        recyclerView.setAdapter(noteAdapter);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                Toast.makeText(getApplicationContext(),"onChanged",Toast.LENGTH_SHORT).show();
//                noteAdapter.setNotes(notes);
            }
        });
    }
}