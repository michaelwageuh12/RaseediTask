package com.example.michael.raseedi.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.michael.raseedi.R;
import com.squareup.picasso.Picasso;

/**
 * It is an Activity to represent the details of a specific ad.
 */
public class DetailAdActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ad);

        setTitle("Details");

        TextView titleTV = findViewById(R.id.titleId);
        ImageView pictureIV = findViewById(R.id.adImageId);
        Button urlBtn = findViewById(R.id.urlId);

        Intent i = getIntent();
        String title = i.getStringExtra("title");
        String picture = i.getStringExtra("picture");
        final String url = i.getStringExtra("url");

        titleTV.setText(title);
        Glide.with(this).load(picture).into(pictureIV);

        urlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
