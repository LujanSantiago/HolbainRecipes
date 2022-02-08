package com.example.holbainrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void cambiarinicio(View view){
        Intent intent=new Intent(getApplicationContext(),principal.class);
        startActivity(intent);

    }

    public void cambiarbusca(View view){
        Intent intent=new Intent(getApplicationContext(),buscador.class);
        startActivity(intent);

    }

    public void cambiarreceta1(View view){
        Intent intent=new Intent(getApplicationContext(),receta1.class);
        startActivity(intent);

    }

    public void cambiarreceta2(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }

    public void cambiarreceta3(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }

    public void cambiarperfil(View view){
        Intent intent=new Intent(getApplicationContext(),perfil.class);
        startActivity(intent);


    }
}
