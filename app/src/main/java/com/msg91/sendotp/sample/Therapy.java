package com.msg91.sendotp.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class Therapy extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner doctor,dancename;
    Button th_btn;
    private ArrayList<Doctor> goodModelArrayList;
    TextView dname,dphno,dw;
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
String a,b,c,d,e,f,g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapy);
        doctor = findViewById(R.id.t_spiner);
        dancename=findViewById(R.id.t_spiner2);
        dname = findViewById(R.id.rdname);
        dphno = findViewById(R.id.rdocyou);
        dw = findViewById(R.id.dw);
        th_btn = findViewById(R.id.th_btn);
        doctor.setOnItemSelectedListener(Therapy.this);




        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Dance_App_JPM/class_time_dance_spiner.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//If we are getting success from server
//                        Toast.makeText(Therapy.this, response, Toast.LENGTH_LONG).show();

                            goodModelArrayList = new ArrayList<>();


                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");

                                       Doctor doctor=new Doctor();
                                        doctor.setName(json_obj.getString("name"));
doctor.setType(json_obj.getString("type"));
                                    goodModelArrayList.add(doctor);
                                }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            for (int i = 0; i < goodModelArrayList.size(); i++){
                                names.add(goodModelArrayList.get(i).getName().toString());
                                name.add(goodModelArrayList.get(i).getType());
                            }

                            ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(Therapy.this, R.layout.support_simple_spinner_dropdown_item, names);
                            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                            doctor.setAdapter(spinnerArrayAdapter);
                        ArrayAdapter spinnerArrayAdapte = new ArrayAdapter(Therapy.this, R.layout.support_simple_spinner_dropdown_item, name);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        dancename.setAdapter(spinnerArrayAdapte);
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
        RequestQueue requestQueue = Volley.newRequestQueue(Therapy.this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, final int i, long l) {





//Toast.makeText(Therapy.this,doctor.getSelectedItem().toString(),Toast.LENGTH_LONG).show();

       // Toast.makeText(Therapy.this,doctor.getItemAtPosition(i).toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

public void fetch(View v)
{
//    Toast.makeText(Therapy.this,doctor.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Dance_App_JPM/spine_value%20_re.php",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
//If we are getting success from server
                  // Toast.makeText(Therapy.this,response,Toast.LENGTH_LONG).show();
                    if(!response.contains("success"))
                    {
                        dname.setText("No Classes On This Date!");
                        dphno.setText("No Classes On This Date!");
                        dw.setText("No Classes On This Date!");
                    }
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");
                            a=json_obj.getString("time");
                              b=json_obj.getString("dancename");
                              c=json_obj.getString("techername");
//                                d=json_obj.getString("email_id");
//                                e=json_obj.getString("address");
//                                f=json_obj.getString("gender");
//                                g=json_obj.getString("dob");

                            dname.setText(a);
                            dphno.setText(b);
                            dw.setText(c);
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
            params.put("docname",doctor.getSelectedItem().toString());
            params.put("type",dancename.getSelectedItem().toString());

// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
            return params;
        }

    };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
    RequestQueue requestQueue = Volley.newRequestQueue(Therapy.this);
    requestQueue.add(stringRequest);
}

}


