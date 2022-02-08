package com.example.holbainrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class receta1 extends AppCompatActivity {
    private RequestQueue request1;
    TextView txNombre,ingrediente1,ingrediente2,ingrediente3,ingrediente4,ingrediente5,ingrediente6,ingrediente7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta1);
        //request1 = Volley.newRequestQueue(this);

        txNombre=findViewById(R.id.textView20);
        ingrediente1 =findViewById(R.id.textView23);
        ingrediente2 =findViewById(R.id.textView28);
        ingrediente3 =findViewById(R.id.textView26);
        ingrediente4 =findViewById(R.id.textView24);
        ingrediente5 =findViewById(R.id.textView22);
        ingrediente6 =findViewById(R.id.textView29);
        ingrediente7 =findViewById(R.id.textView25);
        jsonParse();
    }
    private void jsonParse() {
        String url = "https://fireless-tasks.000webhostapp.com/recetas/jsonrecetas.php?id=1";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("local");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject receta = jsonArray.getJSONObject(i);
                                String Name = receta.getString("nombre");
                                String ing1 = receta.getString("ingrediente1");
                                String ing2 = receta.getString("ingrediente2");
                                String ing3 = receta.getString("ingrediente3");
                                String ing4 = receta.getString("ingrediente4");
                                String ing5 = receta.getString("ingrediente5");
                                String ing6 = receta.getString("ingrediente6");
                                String ing7 = receta.getString("ingrediente7");
                                txNombre.append(Name);
                                ingrediente1.append(ing1);
                                ingrediente2.append(ing2);
                                ingrediente3.append(ing3);
                                ingrediente4.append(ing4);
                                ingrediente5.append(ing5);
                                ingrediente6.append(ing6);
                                ingrediente7.append(ing7);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        singleton.getInstance(getApplicationContext()).addToRequestQueue(request);
        //request1.add(request);

    }
    public void cambiarinicio(View view){
        Intent intent=new Intent(getApplicationContext(),principal.class);
        startActivity(intent);

    }
    public void regresa(View view){
        Intent intent=new Intent(getApplicationContext(),principal.class);
        startActivity(intent);

    }
    public void cambiarbusca(View view){
        Intent intent=new Intent(getApplicationContext(),buscador.class);
        startActivity(intent);

    }

    public void cambiarperfil(View view){
        Intent intent=new Intent(getApplicationContext(),perfil.class);
        startActivity(intent);


    }
}
