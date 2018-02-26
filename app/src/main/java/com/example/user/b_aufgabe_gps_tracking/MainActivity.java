package com.example.user.b_aufgabe_gps_tracking;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener {
    LocationManager locMan;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locMan = (LocationManager) getSystemService(LOCATION_SERVICE);
        db = new Database(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location == null){
            return;
        }else{
            saveLocation(location);
        }
    }


    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        //ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 5, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        locMan.removeUpdates(this);
    }


    private void saveLocation(Location loc) {
        MyLocation myLoc = new MyLocation(loc.getLongitude(), loc.getLatitude(), loc.getTime());
        TextView tv1 = findViewById(R.id.textView1);
        TextView tv2 = findViewById(R.id.textView2);
        TextView tv3 = findViewById(R.id.textView3);
        TextView tv4 = findViewById(R.id.textView4);
        tv1.setText(""+myLoc.getLongitude());
        tv2.setText(""+myLoc.getLatitude());
        tv3.setText(""+myLoc.getDate().getFormatted_date());
        tv4.setText(""+myLoc.getDate().getFormatted_time());
        String s = ""+ myLoc.toString();
        db.addEntry(s);
    }

    public void buttonClicked(View source){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
