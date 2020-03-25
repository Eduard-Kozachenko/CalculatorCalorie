package com.eduard.caloriecounter.presentation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.eduard.caloriecounter.R;
import com.eduard.caloriecounter.presentation.model.Note;
import com.eduard.caloriecounter.presentation.presenter.CollectionContract;
import com.eduard.caloriecounter.presentation.presenter.CollectionPresenter;
import com.eduard.caloriecounter.presentation.utils.AppUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.eduard.caloriecounter.presentation.constants.AppConstants.INTENT_DELETE;
import static com.eduard.caloriecounter.presentation.constants.AppConstants.INTENT_DESC;
import static com.eduard.caloriecounter.presentation.constants.AppConstants.INTENT_TASK;
import static com.eduard.caloriecounter.presentation.constants.AppConstants.INTENT_TITLE;

public class AddNoteActivity extends AppCompatActivity implements CollectionContract.View, View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText editTitle;
    private TextView textTime, btnDone, toolbarTitle;
    private ImageView btnDelete;

    private Note note;

    private EditText etWeight;
    private EditText etHeight;
    private EditText etAge;
    private TextView tvInfo;
    private Button btnGenerate;
    private RadioButton rb_Male,rb_Female;
    private Spinner spinLevel;
    private CollectionContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        textTime = findViewById(R.id.text_time);
        toolbarTitle = findViewById(R.id.title);
        editTitle = findViewById(R.id.edit_title);
        tvInfo = findViewById(R.id.edit_desc);

        btnDelete = findViewById(R.id.btn_close);
        btnDelete.setOnClickListener(this);

        btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(this);

        presenter = new CollectionPresenter(this);

        etWeight = findViewById(R.id.et_weight);
        etHeight = findViewById(R.id.et_height);
        etAge = findViewById(R.id.et_age);
        btnGenerate = findViewById(R.id.btn_generate);
        rb_Male = findViewById(R.id.rb_Male);
        rb_Female = findViewById(R.id.rb_Female);

        spinLevel = findViewById(R.id.spin_level_activity);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.heading_level_activity,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLevel.setAdapter(adapter);
        spinLevel.setOnItemSelectedListener(this);

        btnGenerate.setOnClickListener(v -> {
            String strUserW = etWeight.getText().toString();
            String strUserH = etHeight.getText().toString();
            String strUserA = etAge.getText().toString();

            if(TextUtils.isEmpty(strUserW) || TextUtils.isEmpty(strUserH) || TextUtils.isEmpty(strUserA) ) {
                Toast.makeText(getApplicationContext(),"Not all fields are filled correctly", Toast.LENGTH_SHORT).show();
                return;
            }else if (rb_Male.isChecked() == true) {
                presenter.collectionInfoMale(Double.valueOf(strUserW),
                        Double.valueOf(strUserH),
                        Double.valueOf(strUserA),
                        Integer.valueOf(spinLevel.getSelectedItemPosition()));
            }else if(rb_Female.isChecked() == true) {
                presenter.collectionInfoFemale(Double.valueOf(strUserW),
                        Double.valueOf(strUserH),
                        Double.valueOf(strUserA),
                        Integer.valueOf(spinLevel.getSelectedItemPosition()));
            }
        });

        note = (Note) getIntent().getSerializableExtra(INTENT_TASK);
        if(note == null) {
            toolbarTitle.setText(getString(R.string.add_task_title));
            btnDelete.setImageResource(R.drawable.btn_done);
            btnDelete.setTag(R.drawable.btn_done);
            textTime.setText(AppUtils.getFormattedDateString(AppUtils.getCurrentDateTime()));

        } else {
            toolbarTitle.setText(getString(R.string.edit_task_title));
            btnDelete.setImageResource(R.drawable.ic_delete);
            btnDelete.setTag(R.drawable.ic_delete);
            if(note.getTitle() != null && !note.getTitle().isEmpty()) {
                editTitle.setText(note.getTitle());
                editTitle.setSelection(editTitle.getText().length());
            }
            if(note.getDescription() != null && !note.getDescription().isEmpty()) {
                tvInfo.setText(note.getDescription());
//                tvInfo.setSelection(tvInfo.getText().length());
            }
            if(note.getCreatedAt() != null) {
                textTime.setText(AppUtils.getFormattedDateString(note.getCreatedAt()));
            }
        }

        AppUtils.openKeyboard(getApplicationContext());
    }

    @Override
    public void onClick(View view) {
        AppUtils.hideKeyboard(this);
        if(view == btnDelete) {

            if((Integer)btnDelete.getTag() == R.drawable.btn_done) {
                setResult(Activity.RESULT_CANCELED);

            } else {
                Intent intent = getIntent();
                intent.putExtra(INTENT_DELETE, true);
                intent.putExtra(INTENT_TASK, note);
                setResult(Activity.RESULT_OK, intent);
            }

            finish();
            overridePendingTransition(R.anim.stay, R.anim.slide_down);

        } else if(view == btnDone) {
            Intent intent = getIntent();
            if(note != null) {
                note.setTitle(editTitle.getText().toString());
                note.setDescription(tvInfo.getText().toString());
                intent.putExtra(INTENT_TASK, note);

            } else {
                intent.putExtra(INTENT_TITLE, editTitle.getText().toString());
                intent.putExtra(INTENT_DESC, tvInfo.getText().toString());
            }
            setResult(Activity.RESULT_OK, intent);
            finish();
            overridePendingTransition(R.anim.stay, R.anim.slide_down);
        }
    }

    @Override
    public void setViewData(String data) {
        tvInfo.setText(data);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        if(i > 0) {
            Toast.makeText(getApplicationContext(), spinLevel.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
