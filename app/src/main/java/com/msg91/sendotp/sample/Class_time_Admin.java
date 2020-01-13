package com.msg91.sendotp.sample;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Class_time_Admin extends AppCompatActivity {
EditText d_name,d_date,d_time,d_techer,d_timeperiod;
Button d_btn;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_time__admin);
        d_name=findViewById(R.id.stnameee);
        d_date=findViewById(R.id.joindate);
        d_time=findViewById(R.id.newph);
        d_techer=findViewById(R.id.d_techer);
        d_timeperiod=findViewById(R.id.d_timeperiod);
        d_btn=findViewById(R.id.d_btn);
   d_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(Class_time_Admin.this,

                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                d_date.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });


        d_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (d_name.getText().toString().isEmpty()){

                    d_name.setError("enter a valuel");

                }
                if (d_date.getText().toString().isEmpty()) {


                  d_date.setError("Enter a Value");
                }
                else if (d_time.getText().toString().isEmpty()) {

                   d_time.setError("enter a value");
                }
                else if (d_techer.getText().toString().isEmpty()) {

                    d_techer.setError("enter a value");
                }
                else if (d_timeperiod.getText().toString().isEmpty()) {
                    d_timeperiod.setError("enter a value");
                }

                else {
                    StringRequest stringRequest;
                    stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Dance_App_JPM/Dance_Detailes.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                   d_name.getText().clear();
                                   d_date.getText().clear();
                                   d_time.getText().clear();
                                    d_techer.getText().clear();
                                   d_timeperiod.getText().clear();
                                    Toast.makeText(Class_time_Admin.this,response,Toast.LENGTH_LONG).show();

                                    try {
                                        JSONArray jsonArray = new JSONArray(response);
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");


                                        }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


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

                            params.put("tname", d_name.getText().toString());
                            params.put("temail", d_date.getText().toString());
                            params.put("tphone", d_time.getText().toString());
                            params.put("tdance", d_techer.getText().toString());
                            params.put("texperiance", d_timeperiod.getText().toString());
// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                            return params;
                        }

                    };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(Class_time_Admin.this);
                    requestQueue.add(stringRequest);
                }
            }

        });
    }
}
