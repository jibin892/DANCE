package com.msg91.sendotp.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class Teachers_detailes_Admin extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] dance = { "Bharatanatyam", "Kuchipudi", "Mohiniyattam", "Kerala Natanam", "Odisi","Flok"};
    EditText dance_name, dance_ph, dance_email, dance_duration;
    Button dance_btn;
Spinner dance_techer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_detailes__admin);
        dance_name = findViewById(R.id.stnameee);
        dance_ph = findViewById(R.id.joindate);
        dance_email = findViewById(R.id.newph);
        dance_techer = findViewById(R.id.d_techer);
        dance_duration = findViewById(R.id.d_timeperiod);
        dance_btn = findViewById(R.id.d_btn);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,dance);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        dance_techer.setAdapter(aa);
        dance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dance_name.getText().toString().isEmpty()) {


                    dance_name.setError("Enter a Value");
                }
                else if (dance_ph.getText().toString().isEmpty()) {

                    dance_ph.setError("enter a value");
                }
                else if (dance_email.getText().toString().isEmpty()) {

                    dance_email.setError("enter a value");

                }
                else if(dance_duration.getText().toString().isEmpty()){
                    dance_duration.setError("enter a value");

                }
                else
                    {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Dance_App_JPM/Techer_detailes_dance.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    dance_name.getText().clear();
                                    dance_ph.getText().clear();
                                    dance_email.getText().clear();
                                    dance_duration.getText().clear();
                                    Toast.makeText(Teachers_detailes_Admin.this, response, Toast.LENGTH_LONG).show();

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

                            params.put("tname", dance_name.getText().toString());
                            params.put("tphone", dance_ph.getText().toString());
                            params.put("temail", dance_email.getText().toString());
                            params.put("tdance", dance_techer.getSelectedItem().toString().toLowerCase());
                            params.put("texperiance", dance_duration.getText().toString());
// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                            return params;
                        }

                    };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(Teachers_detailes_Admin.this);
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
        // TODO Auto-generated method stub
    }
}