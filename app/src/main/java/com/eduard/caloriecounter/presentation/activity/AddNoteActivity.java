package com.eduard.caloriecounter.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.eduard.caloriecounter.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE = "com.eduard.caltestmvvm.activity.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.eduard.caltestmvvm.activity.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.eduard.caltestmvvm.activity.EXTRA_PRIORITY";

    private EditText etTitle;
    private EditText etWeight;
    private EditText etHeight;
    private EditText etAge;
    private Button btnGenerate;
    private TextView tvResult;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.edit_title);
        etWeight = findViewById(R.id.et_weight);
        etHeight = findViewById(R.id.et_height);
        etAge = findViewById(R.id.et_age);
        btnGenerate = findViewById(R.id.btn_generate);
        tvResult = findViewById(R.id.tv_description);
        numberPickerPriority = findViewById(R.id.np_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        setTitle("Add Note");

        configView();

    }

    private void configView(){
        btnGenerate.setOnClickListener(v -> {
            String strUserW = etWeight.getText().toString();
            String strUserH = etHeight.getText().toString();
            String strUserA = etAge.getText().toString();

            if(TextUtils.isEmpty(strUserW) || TextUtils.isEmpty(strUserH) || TextUtils.isEmpty(strUserA) ) {
                Toast.makeText(getApplicationContext(),"Not all fields are filled correctly",Toast.LENGTH_SHORT).show();
                return;
            }else {
                //TODO
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String title = etTitle.getText().toString();
        String description = tvResult.getText().toString();
        int priority = numberPickerPriority.getValue();

        if(title.trim().isEmpty() ) {
            Toast.makeText(this,"Please insert title",Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, data);
        finish();
    }
}
