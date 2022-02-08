package com.example.holbainrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registro extends AppCompatActivity {

    EditText user,contra,ema,confir,ema2;
    Button btnregistro;
    String usu,pase,usu2;
    String url="https://fireless-tasks.000webhostapp.com/recetas/registro_a.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);
        ema=findViewById(R.id.email);
        confir=findViewById(R.id.confirma);
        user=findViewById(R.id.usuario);
        contra=findViewById(R.id.contraseña);
        btnregistro=findViewById(R.id.registra);
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
            usu2=ema.getText().toString().trim();
            usu=user.getText().toString().trim();
            pase=contra.getText().toString().trim();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                //StringRequest request= new StringRequest(DownloadManager.Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response){
                    progressDialog.dismiss();
                    if(response.equalsIgnoreCase("Ingreso Exitoso")) {
                        user.setText("");
                        ema.setText("");
                        contra.setText("");
                        startActivity(new Intent(getApplicationContext(), principal.class));
                        Toast.makeText(registro.this, response, Toast.LENGTH_SHORT).show();
                        registro.this.finish();
                    }else{
                        Toast.makeText(registro.this,response, Toast.LENGTH_SHORT).show();
                    }
                }
            },new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    progressDialog.dismiss();
                    Toast.makeText(registro.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("d1",usu2);
                    params.put("d2",usu);
                    params.put("d3",pase);
                    return params;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue(registro.this);
            requestQueue.add(request);
        }
    }
    public void cambiarinicio(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }
}
