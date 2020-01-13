package com.msg91.sendotp.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Chequeadapter extends RecyclerView.Adapter<Chequeadapter.ProductViewHolder> {

    private Context mCtx;
    private List<Cheque> productList;

    public Chequeadapter(Context mCtx, List<Cheque> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
      final   Cheque cheque;   cheque = productList.get(position);

        //loading the image
holder.blog.setText(cheque.getImage());
        holder.datem.setText(cheque.getUser());
holder.date.setText(cheque.getPrize());
holder.txtt.setText(cheque.getStatus());
      //  SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

        //Creating editor to store values to shared preferences


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView text,txtt,datem,date,blog;

        public ProductViewHolder(View itemView) {
            super(itemView);




            txtt=itemView.findViewById(R.id.pph2);
            date=itemView.findViewById(R.id.t_name1);
            datem=itemView.findViewById(R.id.pph1);
            blog=itemView.findViewById(R.id.t_discription1);

        }

    }



}