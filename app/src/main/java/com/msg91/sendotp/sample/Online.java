package com.msg91.sendotp.sample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Online extends AppCompatActivity {
ImageView wapp,fapp,yapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        wapp=findViewById(R.id.wapp);
        fapp=findViewById(R.id.fapp);
        yapp=findViewById(R.id.yapp);



        fapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String facebookUrl = "https://www.facebook.com/techsayssoftwaresolutions/?modal=admin_todo_tour";
                String facebookID = "111754506931637";

                try {
                    int versionCode = getApplicationContext().getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;

                    if(!facebookID.isEmpty()) {
                        // open the Facebook app using facebookID (fb://profile/facebookID or fb://page/facebookID)
                        Uri uri = Uri.parse("fb://page/" + facebookID);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    } else if (versionCode >= 3002850 && !facebookUrl.isEmpty()) {
                        // open Facebook app using facebook url
                        Uri uri = Uri.parse("fb://facewebmodal/f?href=" + facebookUrl);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    } else {
                        // Facebook is not installed. Open the browser
                        Uri uri = Uri.parse(facebookUrl);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    // Facebook is not installed. Open the browser
                    Uri uri = Uri.parse(facebookUrl);
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
            }

        });

yapp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=J11rcoORHBU"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.google.android.youtube");
        startActivity(intent);
;
    }
});







        wapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentWhatsapp = new Intent(Intent.ACTION_VIEW);
                String url = "9847423836";
                intentWhatsapp.setData(Uri.parse(url));
                intentWhatsapp.setPackage("com.gbwhatsapp");
                startActivity(intentWhatsapp);
}

        });
    }
}