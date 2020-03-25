package com.eduard.caloriecounter.presentation.utils;

import android.app.Activity;
import android.content.Intent;

import com.eduard.caloriecounter.presentation.activity.AddNoteActivity;
import com.eduard.caloriecounter.presentation.model.Note;

import static com.eduard.caloriecounter.presentation.constants.AppConstants.ACTIVITY_REQUEST_CODE;
import static com.eduard.caloriecounter.presentation.constants.AppConstants.INTENT_TASK;

public class NavigatorUtils {
    public static void redirectToEditTaskScreen(Activity activity, Note note) {
        Intent intent = new Intent(activity, AddNoteActivity.class);
        intent.putExtra(INTENT_TASK, note);
        activity.startActivityForResult(intent, ACTIVITY_REQUEST_CODE);
    }

}
