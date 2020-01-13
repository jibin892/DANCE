package com.msg91.sendotp.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Phycologist_detailes extends AppCompatActivity {
EditText pname,pph,pwhatsapp,pho;
Button p_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phycologist_detailes);
        p_btn=findViewById(R.id.p_btn);
        pname=findViewById(R.id.pname);
        pph=findViewById(R.id.pph);
        pwhatsapp=findViewById(R.id.pwhatsapp);

      pho=findViewById(R.id.pho);



        p_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pname.getText().toString().isEmpty()){
                    pname.setError("enter a valid data");

                }
                else{

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Drug_Addicts_Counseling/Phycologist_Drug.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(Phycologist_detailes.this,response,Toast.LENGTH_LONG).show();
                                    pname.getText().clear();
                                   pph.getText().clear();
                                    pwhatsapp.getText().clear();
                                    pho.getText().clear();
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


                            params.put("tname",pname.getText().toString());
                            params.put("tdiscription",pph.getText().toString());
                            params.put("tyoutube",pwhatsapp.getText().toString());
                          params.put("hospital",pho.getText().toString() );
//                            params.put("phone",phone.getText().toString() );
// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                            return params;
                        }

                    };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(Phycologist_detailes.this);
                    requestQueue.add(stringRequest);
                }



                }

        });
    }
}
