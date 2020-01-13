package com.msg91.sendotp.sample;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Eventok extends AppCompatActivity {
    List<Cheque1> productList;
    SwipeRefreshLayout s;
    //the recyclerview
    RecyclerView recyclerView;
    SwipeRefreshLayout swipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eve);
        recyclerView = findViewById(R.id.recylcerViewcc);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipe=findViewById(R.id.swiperefreshcc);
loadProducts();
        //initializing the productlist
        productList = new ArrayList<>();
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                productList.clear();
                loadProducts();
            }
        });

    }

    private void loadProducts() {

        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         * */
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Dance_App_JPM/event.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        swipe.setRefreshing(false);
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = array.length()-1; i >=0; i--) {


                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);
                                //adding the product to product list
                                productList.add(new Cheque1(
                                        product.getString("event_name"),
                                        product.getString("event_date"),
                                        product.getString("eventplace"),
                                        product.getString("event_time"),
                                        product.getString("event_discription")


                                ));
                            }


                            Chequeadapter1 adapter = new Chequeadapter1(Eventok.this, productList);
                            adapter.notifyDataSetChanged();
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }


                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request


                //returning parameter
                return params;
            }

        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(Eventok.this);
        requestQueue.add(stringRequest);
    }
    }

