package com.corporacionjoules.www.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by David M on 11/04/2017.
 */

public class HowWorkActivity extends AppCompatActivity {
    private CustomSwipeAdapter csa;
    private ViewPager vp;

    //array de imagenes
    private int[] fotos ={R.drawable.s0, R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_does_it_works);


        vp =(ViewPager)findViewById(R.id.viewpager);
        csa= new CustomSwipeAdapter(HowWorkActivity.this,fotos);
        vp.setAdapter(csa);


    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }

        startActivity(new Intent(this,MainActivity.class));
    }

    //metodo para que la flecha de la toolbar vaya hacia atras cuando se pulse
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();//llama a este metodo
        return true;
    }


}
