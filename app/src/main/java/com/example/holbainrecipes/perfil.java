package com.example.holbainrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void regresa(View view){
        Intent intent=new Intent(getApplicationContext(),principal.class);
        startActivity(intent);

    }
    public void cambiarcierra(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        this.finish();

    }
}
