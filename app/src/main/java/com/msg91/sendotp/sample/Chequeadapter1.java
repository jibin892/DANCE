package com.msg91.sendotp.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Chequeadapter1 extends RecyclerView.Adapter<Chequeadapter1.ProductViewHolder> {

    private Context mCtx;
    private List<Cheque1> productList;

    public Chequeadapter1(Context mCtx, List<Cheque1> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_event, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
      final   Cheque1 cheque;   cheque = productList.get(position);

        //loading the image
holder.blog.setText(cheque.getImage());
        holder.datem.setText(cheque.getUser());
holder.date.setText(cheque.getPrize());
holder.txtt.setText(cheque.getStatus());
holder.place.setText(cheque.getDes());
      //  SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

        //Creating editor to store values to shared preferences


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView text,txtt,datem,date,blog,place;

        public ProductViewHolder(View itemView) {
            super(itemView);




            txtt=itemView.findViewById(R.id.eventdate);
            date=itemView.findViewById(R.id.eventdis);
            datem=itemView.findViewById(R.id.eventname);
            blog=itemView.findViewById(R.id.eventtime);
            place=itemView.findViewById(R.id.eventplace);

        }

    }



}