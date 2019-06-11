package com.rachelleboyette.catquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.rachelleboyette.catquiz.viewmodels.CatFactViewModel;

public class MainActivity extends AppCompatActivity {

    private CatFactViewModel catFactViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catFactViewModel = ViewModelProviders.of(this).get(CatFactViewModel.class);
    }
}
