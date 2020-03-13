package com.essay.grader.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InputViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InputViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public void processInput(String text, String topic) {
        //save to database
        //pass to classificator
    }

    public LiveData<String> getText() {
        return mText;
    }
}