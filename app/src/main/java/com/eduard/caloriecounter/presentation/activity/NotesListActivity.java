package com.eduard.caloriecounter.presentation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.eduard.caloriecounter.R;
import com.eduard.caloriecounter.data.repository.NoteRepository;
import com.eduard.caloriecounter.presentation.adapter.NotesListAdapter;
import com.eduard.caloriecounter.presentation.constants.AppConstants;
import com.eduard.caloriecounter.presentation.fragments.CollectionFragment;
import com.eduard.caloriecounter.presentation.model.Note;
import com.eduard.caloriecounter.presentation.utils.NavigatorUtils;
import com.eduard.caloriecounter.presentation.utils.RecyclerItemClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class NotesListActivity extends AppCompatActivity implements View.OnClickListener, RecyclerItemClickListener.OnRecyclerViewItemClickListener, AppConstants {

    private TextView emptyView;
    private RecyclerView recyclerView;
    private NotesListAdapter notesListAdapter;
    private FloatingActionButton floatingActionButton;

    private NoteRepository noteRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        noteRepository = new NoteRepository(getApplicationContext());

        recyclerView = findViewById(R.id.task_list);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, this));

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);

        emptyView = findViewById(R.id.empty_view);

        updateTaskList();
    }

    private void updateTaskList() {
        noteRepository.getTasks().observe(this, notes -> {
            if(notes.size() > 0) {
                emptyView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                if (notesListAdapter == null) {
                    notesListAdapter = new NotesListAdapter(notes);
                    recyclerView.setAdapter(notesListAdapter);

                } else notesListAdapter.addTasks(notes);
            } else updateEmptyView();
        });
    }

    private void updateEmptyView() {
        emptyView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(NotesListActivity.this, CollectionFragment.class);
        startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void onItemClick(View parentView, View childView, int position) {
        Note note = notesListAdapter.getItem(position);
        if(note.isEncrypt()) {
            //TODO
        } else {
            NavigatorUtils.redirectToEditTaskScreen(this, note);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            if(data.hasExtra(INTENT_TASK)) {
                if(data.hasExtra(INTENT_DELETE)) {
                    noteRepository.deleteTask((Note) data.getSerializableExtra(INTENT_TASK));
                } else {
                    noteRepository.updateTask((Note) data.getSerializableExtra(INTENT_TASK));
                }
            } else {
                String title = data.getStringExtra(INTENT_TITLE);
                String desc = data.getStringExtra(INTENT_DESC);
                boolean encrypt = data.getBooleanExtra(INTENT_ENCRYPT, false);
                noteRepository.insertTask(title, desc, encrypt);
            }
            updateTaskList();
        }
    }
}
