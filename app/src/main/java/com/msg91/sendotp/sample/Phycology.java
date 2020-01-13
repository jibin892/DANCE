package com.msg91.sendotp.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.Map;

public class Phycology extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner doctorone;
TextView dname,dob,daddress,daddres;
    private ArrayList<Doctor> goodModelArrayList;

    private ArrayList<String> names = new ArrayList<String>();
    String a,b,c,d,e,f,g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phycology);
      doctorone=findViewById(R.id.p_spiner);
dname=findViewById(R.id.rdname);
dob=findViewById(R.id.dob);
daddress=findViewById(R.id.daddress);
daddres=findViewById(R.id.daddres);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Dance_App_JPM/TECHER_NAME_SPINER.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//If we are getting success from server
//                        Toast.makeText(Phycology.this, response, Toast.LENGTH_LONG).show();

                        goodModelArrayList = new ArrayList<>();


                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");

                                Doctor doctor=new Doctor();
                                doctor.setName(json_obj.getString("name"));
                                goodModelArrayList.add(doctor);
                            }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        for (int i = 0; i < goodModelArrayList.size(); i++){
                            names.add(goodModelArrayList.get(i).getName().toString());
                        }

                        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(Phycology.this, R.layout.support_simple_spinner_dropdown_item, names);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        doctorone.setAdapter(spinnerArrayAdapter);



                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
//Adding parameters to request



// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                return params;
            }

        };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(Phycology.this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, final int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void fetchhd(View v)
    {
//        Toast.makeText(Phycology.this,doctorone.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Dance_App_JPM/Techer_details_display.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//If we are getting success from server
                       Toast.makeText(Phycology.this,response,Toast.LENGTH_LONG).show();
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");
                                a=json_obj.getString("Techer_dancetype");
                                b=json_obj.getString("Techer_phone");
                                c=json_obj.getString("Techer_email");
                                d=json_obj.getString("Techer_experiance");
//                                e=json_obj.getString("address");
//                                f=json_obj.getString("gender");
//                                g=json_obj.getString("dob");

                               dname.setText(a);
                                dob.setText(b);
                                daddress.setText(c);
                                daddres.setText(d);
                            }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //   Toast.makeText(Signin.this, "success", Toast.LENGTH_LONG).show();

                    }



                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
//Adding parameters to request
                params.put("docname",doctorone.getSelectedItem().toString());

// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                return params;
            }

        };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(Phycology.this);
        requestQueue.add(stringRequest);
    }

}

