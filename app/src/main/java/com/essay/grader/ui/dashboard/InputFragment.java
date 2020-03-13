package com.essay.grader.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.essay.grader.R;
import com.google.android.material.textfield.TextInputLayout;

public class InputFragment extends Fragment {

    private InputViewModel inputViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inputViewModel =
                ViewModelProviders.of(this).get(InputViewModel.class);
        View root = inflater.inflate(R.layout.fragment_input, container, false);
        final TextInputLayout text = root.findViewById(R.id.essay);
        final TextInputLayout topic = root.findViewById(R.id.topic);
        final Button submit = root.findViewById(R.id.submit);

        submit.setOnClickListener(v -> inputViewModel.processInput(text.getEditText().getText().toString(),
                topic.getEditText().getText().toString()));

        return root;
    }

}