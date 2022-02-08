package com.example.holbainrecipes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity implements RepositoryObserver {
    private subject mUserDataRepository;
    private TextView mTextViewUserFullName;
    private TextView mTextViewUserAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        mTextViewUserAge = (TextView) findViewById(R.id.textView32);
        mTextViewUserFullName = (TextView) findViewById(R.id.nombre);

        mUserDataRepository = UserDataRepository.getInstance();
        mUserDataRepository.registerObserver(this);
    }

    @Override
    public void onUserDataChanged(String fullname, int age) {
        mTextViewUserFullName.setText(fullname);
        mTextViewUserAge.setText(age);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserDataRepository.removeObserver(this);
    }
}
