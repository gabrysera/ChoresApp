package com.example.all_chores.ui.main;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.function.Function;

import static androidx.lifecycle.Transformations.*;

public class PageViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    /*private LiveData<String> mText = (LiveData<String>) map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });*/

    public PageViewModel(android.app.Application application) {
        super(application);
    }


    public void setIndex(int index) {
        mIndex.setValue(index);
    }
/*
    public LiveData<String> getText() {
        return mText;
    }*/
}