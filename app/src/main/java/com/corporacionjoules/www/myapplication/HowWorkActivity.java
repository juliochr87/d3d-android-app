package com.corporacionjoules.www.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by David M on 11/04/2017.
 */

public class HowWorkActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_does_it_works);


        ViewPager vp =(ViewPager)findViewById(R.id.viewpager);
        int[] fotos ={R.drawable.s0, R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5};
        CustomSwipeAdapter csa= new CustomSwipeAdapter(HowWorkActivity.this,fotos);
        vp.setAdapter(csa);

    }



    }

