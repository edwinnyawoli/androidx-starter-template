package com.edwinnyawoli.templateapplication.ui;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.edwinnyawoli.templateapplication.R;

public class EmptyActivity extends AppCompatActivity {

    public static final String ARG_EXTRA = "arg_extra";
    public static final String FIRST_RUN_EXTRA = "first_run_extra";

    public static Intent intentFor(Context context, String args) {
        Intent intent = new Intent(context, EmptyActivity.class);
        intent.putExtra(ARG_EXTRA, args);
        intent.putExtra(FIRST_RUN_EXTRA, true);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        EditText editText = findViewById(R.id.edit_text);

        EmptyViewModel viewModel = ViewModelProviders.of(this).get(EmptyViewModel.class);

        Intent intent = getIntent();
        if (intent != null) {
            boolean firstRun = intent.getBooleanExtra(FIRST_RUN_EXTRA, false);
            String arg = intent.getStringExtra(ARG_EXTRA);
            viewModel.arg = arg;

        }

        editText.setText(viewModel.arg);
    }

    @Override
    public void onUserInteraction() {
        Toast.makeText(this, "Interaction", Toast.LENGTH_SHORT).show();
        super.onUserInteraction();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public static class EmptyViewModel extends ViewModel {
        public String arg;
    }
}
