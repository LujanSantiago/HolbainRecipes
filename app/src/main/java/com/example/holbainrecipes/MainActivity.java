package com.example.holbainrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText user,contra;
    Button btnlogin;
    String ema,pase;
    String url="https://fireless-tasks.000webhostapp.com/recetas/login_a.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.usuario);
        contra=findViewById(R.id.contraseña);
        btnlogin=findViewById(R.id.iniciar);
    }
    public void cambio(View view){
        if(user.getText().toString().equals("")){
            Toast.makeText(this, "Ingrese Usuario", Toast.LENGTH_SHORT).show();
        }
        else if(contra.getText().toString().equals("")) {
            Toast.makeText(this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
        }
        else{
            final ProgressDialog progressDialog =new ProgressDialog(this);
            progressDialog.setMessage("validando datos");
            progressDialog.show();
            ema=user.getText().toString().trim();
            pase=contra.getText().toString().trim();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                //StringRequest request= new StringRequest(DownloadManager.Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response){
                    progressDialog.dismiss();
                    if(response.equalsIgnoreCase("Ingreso Exitoso")) {
                        user.setText("");
                        contra.setText("");
                        startActivity(new Intent(getApplicationContext(), principal.class));
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        MainActivity.this.finish();
                    }else{
                        Toast.makeText(MainActivity.this,response, Toast.LENGTH_SHORT).show();
                    }
                }
            },new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("name",ema);
                    params.put("contra",pase);
                    return params;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(request);
        }
    }

    public void cambiarregistro(View view){
        Intent intent=new Intent(getApplicationContext(),registro.class);
        startActivity(intent);

    }
}
