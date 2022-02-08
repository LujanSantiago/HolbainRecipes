package com.example.holbainrecipes;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class singleton {
    private static singleton instancia;
    private RequestQueue request;

    private static Context ctx;

    private singleton(Context context) {
        ctx = context;
        request = getRequestQueue();


    }

    public static synchronized singleton getInstance(Context context) {
        if (instancia == null) {
            instancia = new singleton(context);
        }
        return instancia;
    }

    public RequestQueue getRequestQueue() {
        if (request == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            request = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return request;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}

