package com.eduard.caloriecounter.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.eduard.caloriecounter.R;
import com.eduard.caloriecounter.presentation.utils.CalculationViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class AddNoteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public static final String EXTRA_TITLE = "com.eduard.caltestmvvm.activity.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.eduard.caltestmvvm.activity.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.eduard.caltestmvvm.activity.EXTRA_PRIORITY";

    private EditText etTitle;
    private RadioButton rb_Male,rb_Female;
    private EditText etWeight;
    private EditText etHeight;
    private EditText etAge;
    private Spinner spinLevel;
    private Button btnGenerate;
    private TextView tvResult;
    private NumberPicker numberPickerPriority;

    private CalculationViewModel calculationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.et_title);
        rb_Male = findViewById(R.id.rb_Male);
        rb_Female = findViewById(R.id.rb_Female);
        etWeight = findViewById(R.id.et_weight);
        etHeight = findViewById(R.id.et_height);
        etAge = findViewById(R.id.et_age);
        spinLevel = findViewById(R.id.spin_level_activity);
        btnGenerate = findViewById(R.id.btn_generate);
        tvResult = findViewById(R.id.tv_result);
        numberPickerPriority = findViewById(R.id.np_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        setTitle("Add Note");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.heading_level_activity,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLevel.setAdapter(adapter);
        spinLevel.setOnItemSelectedListener(this);

        configView();
    }

    private void configView(){
        calculationViewModel = ViewModelProviders.of(this).get(CalculationViewModel.class);

        btnGenerate.setOnClickListener(v -> {
            String strUserW = etWeight.getText().toString();
            String strUserH = etHeight.getText().toString();
            String strUserA = etAge.getText().toString();

            if(TextUtils.isEmpty(strUserW) || TextUtils.isEmpty(strUserH) || TextUtils.isEmpty(strUserA) ) {
                Toast.makeText(getApplicationContext(),"Not all fields are filled correctly",Toast.LENGTH_SHORT).show();
                return;
            }else if (rb_Male.isChecked() == true) {
                calculationViewModel.collectionInfoMale(Double.valueOf(strUserW),
                        Double.valueOf(strUserH),
                        Double.valueOf(strUserA),
                        Integer.valueOf(spinLevel.getSelectedItemPosition()));
            }else if(rb_Female.isChecked() == true) {
                calculationViewModel.collectionInfoFemale(Double.valueOf(strUserW),
                        Double.valueOf(strUserH),
                        Double.valueOf(strUserA),
                        Integer.valueOf(spinLevel.getSelectedItemPosition()));
            }
        });

        calculationViewModel.getResult().observe(this, res -> tvResult.setText(res));
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position > 0) {
            Toast.makeText(getApplicationContext(), spinLevel.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
