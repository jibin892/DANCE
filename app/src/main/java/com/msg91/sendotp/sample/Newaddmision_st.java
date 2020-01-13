package com.msg91.sendotp.sample;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

public class Newaddmision_st extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String[] danc = { "Bharatanatyam", "Kuchipudi", "Mohiniyattam", "Kerala Natanam", "Odisi","Flok"};
    private DatePicker datePicker;

    private TextView dateView;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;


EditText stn,stph,std;
Button stb;
Spinner stsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaddmision_st);
        stn=findViewById(R.id.stn);
        stph=findViewById(R.id.stph);
        std=findViewById(R.id.std);
        stsp=findViewById(R.id.stsp);
        stb=findViewById(R.id.stb);
        stsp.setOnItemSelectedListener(this);
        ArrayAdapter aas = new ArrayAdapter(this,android.R.layout.simple_spinner_item,danc);
        aas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        stsp.setAdapter(aas);


        std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(Newaddmision_st.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                std.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                 datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

stb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if (stn.getText().toString().isEmpty()){

            stn.setError("null");


        }


       else if (stph.getText().toString().isEmpty()){

            stph.setError("null");


        }


      else if (stn.getText().toString().isEmpty()){

            stn.setError("null");


        }


        if (std.getText().toString().isEmpty()){

            std.setError("null");


        }

       else{


            StringRequest stringRequest;
            stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Dance_App_JPM/New_dance_Addmisiion.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
//If we are getting success from server
                            stn.getText().clear();
                            stph.getText().clear();
                            std.getText().clear();

                            Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();

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

                    params.put("stn", stn.getText().toString());
                    params.put("stph", stph.getText().toString());
                    params.put("std", std.getText().toString());
                    params.put("stsp",stsp.getSelectedItem().toString().toLowerCase());
// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                    return params;
                }

            };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }







        }



    });


    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//        Toast.makeText(getApplicationContext(),dance[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
