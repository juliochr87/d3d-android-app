package com.corporacionjoules.www.myapplication;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //TODO:Validar si ya fue visto por el usuario
        drawer.openDrawer(Gravity.LEFT,false);
        showTutorial();
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        super.unregisterReceiver(receiver);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_como_funciona){
            Intent i = new Intent(MainActivity.this, HowWorkActivity.class);
            startActivity(i);
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showTutorial() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int alto = metrics.heightPixels;
        //float ancho = metrics.widthPixels;

        Rect r1, r2, r3, r4, r5, r6, r7, r8, r9;

        //diferentes resoluciones de pantalla para que el tutorial salga bien

        if(alto >= 870 && alto <= 970){

            alto = 960;
        }

        //pantalla 1280x720
        if (alto == 1280) {

            r1 = new Rect(105, 850, 0, 0);
            r2 = new Rect(105, 1070, 0, 0);
            r3 = new Rect(105, 1260, 0, 0);
            r4 = new Rect(105, 1450, 0, 0);
            r5 = new Rect(105, 1620, 0, 0);
            r6 = new Rect(105, 1810, 0, 0);
            r7 = new Rect(105, 2020, 0, 0);
            r8 = new Rect(105, 2230, 0, 0);
            r9 = new Rect(105, 2420, 0, 0);

            //pantalla 1920x1080
        } else if (alto == 1920) {

            r1 = new Rect(158, 1275, 0, 0);
            r2 = new Rect(158, 1605, 0, 0);
            r3 = new Rect(158, 1890, 0, 0);
            r4 = new Rect(158, 2175, 0, 0);
            r5 = new Rect(158, 2430, 0, 0);
            r6 = new Rect(158, 2715, 0, 0);
            r7 = new Rect(158, 3030, 0, 0);
            r8 = new Rect(158, 3345, 0, 0);
            r9 = new Rect(158, 3630, 0, 0);

            //800x480
        }else if(alto == 800){
            r1= new Rect(66,638,0,0);
            r2= new Rect(66,670,0,0);
            r3= new Rect(66,787,0,0);
            r4= new Rect(66,906,0,0);
            r5= new Rect(66,1013,0,0);
            r6= new Rect(66,1132,0,0);
            r7= new Rect(66,1263,0,0);
            r8= new Rect(66,1394,0,0);
            r9= new Rect(66,1513,0,0);

            //1024x768
        }else if(alto == 1024){
            r1= new Rect(35,680,0,0);
            r2= new Rect(35,856,0,0);
            r3= new Rect(35,1008,0,0);
            r4= new Rect(35,1160,0,0);
            r5= new Rect(35,1296,0,0);
            r6= new Rect(35,1448,0,0);
            r7= new Rect(35,1616,0,0);
            r8= new Rect(35,1784,0,0);
            r9= new Rect(35,1936,0,0);

            //pantalla de 960 x 540
        }else if(alto == 960){
            r1 = new Rect(79, 638, 0, 0);
            r2 = new Rect(79, 803, 0, 0);
            r3 = new Rect(79, 945, 0, 0);
            r4 = new Rect(79, 1088, 0, 0);
            r5 = new Rect(79, 1215, 0, 0);
            r6 = new Rect(79, 1358, 0, 0);
            r7 = new Rect(79, 1515, 0, 0);
            r8 = new Rect(79, 1673, 0, 0);
            r9 = new Rect(79, 1815, 0, 0);

            //por defecto pantalla de 1920x1080
        }else{
            r1 = new Rect(158, 1275, 0, 0);
            r2 = new Rect(158, 1605, 0, 0);
            r3 = new Rect(158, 1890, 0, 0);
            r4 = new Rect(158, 2175, 0, 0);
            r5 = new Rect(158, 2430, 0, 0);
            r6 = new Rect(158, 2715, 0, 0);
            r7 = new Rect(158, 3030, 0, 0);
            r8 = new Rect(158, 3345, 0, 0);
            r9 = new Rect(158, 3630, 0, 0);

        }


        //si nunca ha visto el tutorial se iguala a 0
        //if (controller.obtener_tutorial()==0){
        if (true)
            new TapTargetSequence(this)
                    .targets(
                            TapTarget.forBounds(r1, "Perfil","Entra y mira tu perfil")
                                    .dimColor(android.R.color.holo_red_dark)
                                    .transparentTarget(true)
                                    .targetRadius(30)
                                    .targetCircleColor(R.color.azul_facebook)
                                    .cancelable(false)
                                    .textColor(android.R.color.black),

                            TapTarget.forBounds(r2, "Mapas", "Localiza a otros usuarios usando el mapa")
                                    .dimColor(android.R.color.holo_red_dark)
                                    .transparentTarget(true)
                                    .cancelable(false)
                                    .targetRadius(30)
                                    .targetCircleColor(R.color.azul_facebook)
                                    .textColor(android.R.color.black),

                            TapTarget.forBounds(r3,"Buscar profesionales", "Puedes buscar a otros profesionales según su email")
                                    .dimColor(android.R.color.holo_red_dark)
                                    .transparentTarget(true)
                                    .targetRadius(30)
                                    .targetCircleColor(R.color.azul_facebook)
                                    .cancelable(false)
                                    .textColor(android.R.color.black),

                            TapTarget.forBounds(r4,"Publicar Proyecto","Publica tus proyectos profesionales")
                                    .dimColor(android.R.color.holo_red_dark)
                                    .transparentTarget(true)
                                    .cancelable(false)
                                    .targetRadius(30)
                                    .targetCircleColor(R.color.azul_facebook)
                                    .textColor(android.R.color.black),

                            TapTarget.forBounds(r5, "Proyectos Publicados", "Mira los proyectos de los demás usuarios")
                                    .transparentTarget(true)
                                    .cancelable(false)
                                    .targetRadius(30)
                                    .targetCircleColor(R.color.azul_facebook)
                                    .textColor(android.R.color.black),

                            TapTarget.forBounds(r6,"Mis Proyectos", "Mira tus proyectos")
                                    .dimColor(android.R.color.holo_red_dark)
                                    .transparentTarget(true)
                                    .cancelable(false)
                                    .targetRadius(30)
                                    .targetCircleColor(R.color.azul_facebook)
                                    .textColor(android.R.color.black),

                            TapTarget.forBounds(r7, "Evaluación", "Aquí encontraras las estadisticas de tus proyectos")
                                    .dimColor(android.R.color.holo_red_dark)
                                    .transparentTarget(true)
                                    .cancelable(false)
                                    .targetRadius(30)
                                    .targetCircleColor(R.color.azul_facebook)
                                    .textColor(android.R.color.black),

                            TapTarget.forBounds(r8, "Mensajes", "Envia y recibe mensajes de otros usuarios")
                                    .dimColor(android.R.color.holo_red_dark)
                                    .transparentTarget(true)
                                    .cancelable(false)
                                    .targetRadius(30)
                                    .targetCircleColor(R.color.azul_facebook)
                                    .textColor(android.R.color.black),

                            TapTarget.forBounds(r9, "Chat", "Habla con otros usuarios en tiempo real")
                                    .dimColor(android.R.color.holo_red_dark)
                                    .transparentTarget(true)
                                    .cancelable(false)
                                    .targetRadius(30)
                                    .targetCircleColor(R.color.azul_facebook)
                                    .textColor(android.R.color.black)

                           /* TapTarget.forBounds(r10, "Cerrar Sesión", "Cierra la sesión actual")
                                    .dimColor(android.R.color.holo_red_dark)
                                    .transparentTarget(true)
                                    .cancelable(false)
                                    .targetRadius(30)
                                    .targetCircleColor(R.color.azul_facebook)
                                    .textColor(android.R.color.black)*/)

                    .listener(new TapTargetSequence.Listener() {

                        @Override
                        public void onSequenceFinish() {
                            //cuando termine la secuencia del tutorial, se iguala a 1 para que no vuelva a salir
                           // controller.actualizar_tutorial(1);
                        }

                        @Override
                        public void onSequenceStep(TapTarget ultimo, boolean algo) {

                        }

                        @Override
                        public void onSequenceCanceled(TapTarget lastTarget) {

                        }
                    }).start();

    }
}
