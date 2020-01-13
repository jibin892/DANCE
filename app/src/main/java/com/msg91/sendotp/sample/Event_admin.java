package com.msg91.sendotp.sample;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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

public class Event_admin extends AppCompatActivity {
EditText ename,edate,eplace,etime,edis;
Button ebtn;

    private DatePicker datePicker;

    private TextView dateView;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_admin);

        ename=findViewById(R.id.ename);
        edate=findViewById(R.id.edate);
        eplace=findViewById(R.id.eplace);
        etime=findViewById(R.id.etime);
        edis=findViewById(R.id.edis);
        ebtn=findViewById(R.id.ebtn);


        edate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(Event_admin.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                edate.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });


ebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if (ename.getText().toString().isEmpty()){

            ename.setError("null");


        }


        else if (edate.getText().toString().isEmpty()){

            edate.setError("null");


        }


        else if (eplace.getText().toString().isEmpty()){

            eplace.setError("null");


        }


        else if (etime.getText().toString().isEmpty()){

            etime.setError("null");


        }
        else if (edis.getText().toString().isEmpty()){

            edis.setError("null");


        }


        else{


            StringRequest stringRequest;
            stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Dance_App_JPM/Event_admin_update.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
//If we are getting success from server
                            ename.getText().clear();
                            edate.getText().clear();
                            eplace.getText().clear();
                            etime.getText().clear();
                            edis.getText().clear();

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

                    params.put("stn", ename.getText().toString());
                    params.put("stph", edate.getText().toString());
                    params.put("std", eplace.getText().toString());
                    params.put("stsp", etime.getText().toString());
                    params.put("stspp", edis.getText().toString());


//                    params.put("stsp",stsp.getSelectedItem().toString().toLowerCase());
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
}
