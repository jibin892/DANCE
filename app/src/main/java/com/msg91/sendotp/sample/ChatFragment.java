package com.msg91.sendotp.sample;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {
    private DatePicker datePicker;

    private TextView dateView;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
 EditText dname,dphone,demail,dexp;
 Button exp_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View root= inflater.inflate(R.layout.fragment_chat, container, false);
         dname=root.findViewById(R.id.rdname);
        dphone=root.findViewById(R.id.docyou1);
        demail=root.findViewById(R.id.dw);
        dexp=root.findViewById(R.id.dexp);
//        dblog=root.findViewById(R.id.dblog);
        demail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                demail.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                 datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
        exp_btn=root.findViewById(R.id.exp_btn);

        exp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dname.getText().toString().isEmpty()){

                    dname.setError("field is empty");
                }
                else if (dphone.getText().toString().isEmpty()){
                    dphone.setError("field is empty");

                }
                else if (demail.getText().toString().isEmpty()){
                    demail.setError("field is empty");
                }
                else  if (dexp.getText().toString().isEmpty()){

                    dexp.setError("field is empty");
                }

                else{


                    StringRequest stringRequest;
                    stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Dance_App_JPM/Review_Dance.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                                    dname.getText().clear();
                                    dphone.getText().clear();
                                    demail.getText().clear();
                                    dexp.getText().clear();
//                                    dblog.getText().clear();

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

                            params.put("tname", dname.getText().toString());
                            params.put("tphone", dphone.getText().toString());
                            params.put("temail", demail.getText().toString());
                            params.put("tdance", dexp.getText().toString());
//                            params.put("texperiance", dblog.getText().toString());
// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                            return params;
                        }

                    };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                    requestQueue.add(stringRequest);
                }



                }

        });






        return root;






    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {


        inflater.inflate(R.menu.menu_main,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();



        if (id==R.id.techersde){

            Intent i=new Intent(getActivity(),Therapy.class);
            startActivity(i);
//            Toast.makeText(getActivity(),"Techers",Toast.LENGTH_LONG).show();


        }
        if (id==R.id.classtime){
            Intent ii=new Intent(getActivity(),Phycology.class);
            startActivity(ii);

//            Toast.makeText(getActivity(),"class",Toast.LENGTH_LONG).show();


        }
        if (id==R.id.onlinesupport){
            Intent iii=new Intent(getActivity(),Online.class);
            startActivity(iii);

//            Toast.makeText(getActivity(),"class",Toast.LENGTH_LONG).show();


        }
        if (id==R.id.newdance){


            Intent iiii=new Intent(getActivity(), Newaddmision_st.class);
            startActivity(iiii);


        }

        if (id==R.id.event){


            Intent iiiii=new Intent(getActivity(), Eventok.class);
            startActivity(iiiii);


        }



        return super.onOptionsItemSelected(item);
    }



}

