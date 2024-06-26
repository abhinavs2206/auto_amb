package com.example.final_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.example.final_project.databinding.ActivityMaps1Binding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.Mappls;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.services.account.MapplsAccountManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.mappls.demo.maps.R;
//import com.mappls.sdk.demo.java.utils.CheckInternet;
//import com.mappls.sdk.demo.java.utils.TransparentProgressDialog;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.api.distance.MapplsDistanceMatrix;
import com.mappls.sdk.services.api.distance.MapplsDistanceMatrixManager;
import com.mappls.sdk.services.api.distance.models.DistanceResponse;
import com.mappls.sdk.services.api.distance.models.DistanceResults;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class MapsActivity1 extends AppCompatActivity implements com.mappls.sdk.maps.OnMapReadyCallback {
    double ulat,ulon,dlat,dlon;
    private MapView mapView;
//    private ActivityMaps1Binding binding;
//    private TransparentProgressDialog transparentProgressDialog;
    private TextView tvDistance, tvDuration;
    private LinearLayout directionDetailsLayout;

    private FloatingActionButton floatingActionButton;
    private String mDestination="12.942117,77.575361"; //basavangudi blore
//    private String mSource ="12.9766637,77.57125559999997"; //majestic blore

//    private String mDestination="28.551087,77.257373";
    private String mSource ="28.582864,77.234230";
    private String waypoints;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapplsAccountManager.getInstance().setRestAPIKey("79932dd735ffc4d60beb793cede71d7f");
        MapplsAccountManager.getInstance().setMapSDKKey("79932dd735ffc4d60beb793cede71d7f");
        MapplsAccountManager.getInstance().setAtlasClientId("96dHZVzsAusmdNR_bHhIz2DA6Sg1B6aepjJYut7y6ZvAwGhxkFky_pYY_sQ7E4aT9dKpgJC6NBJneJKDI7UIGaYQ6Hm_7sAi");
        MapplsAccountManager.getInstance().setAtlasClientSecret("lrFxI-iSEg88LPa9PW4ei5x1gJWU6m5qGrfYNG_z66hLdqbyBDgKPGFHOCnklgXropcAnbHvzsnxYfXhA0j1AK1mS-RjghRsQaZ-UQ8Vn2E=");
        Mappls.getInstance(getApplicationContext());

        setContentView(R.layout.activity_maps1);
        mapView = findViewById(R.id.map_view);
        floatingActionButton = findViewById(R.id.edit_btn);
        directionDetailsLayout = findViewById(R.id.distance_details_layout);
        tvDistance = findViewById(R.id.tv_distance);
        tvDuration = findViewById(R.id.tv_duration);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

//        floatingActionButton.setOnClickListener(v -> {
//            Intent intent = new Intent(this,InputActivity.class);
//            intent.putExtra("origin", mSource);
//            intent.putExtra("destination", mDestination);
//            intent.putExtra("waypoints", waypoints);
//            startActivityForResult(intent,501);
//        });


//        binding = ActivityMaps1Binding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

//        String user=getIntent().getStringExtra("res_from_driver");
//        DatabaseReference d= FirebaseDatabase.getInstance("https://auto-amb-fd668-default-rtdb.firebaseio.com/").getReference();
//        assert user != null;
//        d.child("try1").child("user_reqs").child(user).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                user_req_obj rd = task.getResult().getValue(user_req_obj.class);
//                if(rd == null){
//                    Log.e("Msg","Null Object Reference");
//                    return;
//                }
//                ulon= Double.parseDouble(rd.ulon);
//                ulat= Double.parseDouble(rd.ulat);
//                dlon= Double.parseDouble(rd.dlon);
//                dlat= Double.parseDouble(rd.dlat);
//                Log.e("driver",rd.dlat);
//                Log.e("user",rd.ulat);
////                mapReady();
//            }
//        });



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }


//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//    }
//    public void mapReady() {
//
//        LatLng usermap = new LatLng(ulat, ulon);
//        mMap.addMarker(new MarkerOptions().position(usermap).title("Marker in User"));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(user));
//        LatLng drivermap = new LatLng(dlat, dlon);
//        mMap.addMarker(new MarkerOptions().position(drivermap).title("Marker in Driver"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(drivermap));
//    }

    @Override
    public void onMapReady(@NonNull MapplsMap mapplsMap) {
        mapplsMap.setCameraPosition(setCameraAndTilt());

        List<Point> coordinatesPoint = new ArrayList<Point>();
        coordinatesPoint.add(Point.fromLngLat(77.575361,  12.942117));
        coordinatesPoint.add(Point.fromLngLat(77.57125559999997,12.9766637));
//        coordinatesPoint.add(Point.fromLngLat(77.257373, 28.551087));
//        coordinatesPoint.add(Point.fromLngLat(77.234230, 28.582864));
//        List<String> mapplePins = new ArrayList<String>();
//        mapplePins.add("Basavangudi Blore");
//        mapplePins.add("Majestic Blore");
        calculateDistance(coordinatesPoint,null);
//        if (CheckInternet.isNetworkAvailable(MapsActivity1.this)) {
//
//        }
//        else {
//            Toast.makeText(this, getString(R.string.pleaseCheckInternetConnection), Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public void onMapError(int i, String s) {

    }
    private CameraPosition setCameraAndTilt() {
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(
                12.942117, 77.575361)).zoom(14).tilt(0).build();
        return cameraPosition;
    }

    private void calculateDistance(List<Point> pointList, List<String> mapplsPins) {
//        progressDialogShow();
        MapplsDistanceMatrix.Builder builder =   MapplsDistanceMatrix.builder();
        if (mSource!=null){
            if (!mSource.contains(",")){
                builder.coordinate(mSource);
            }else {
                Point point =Point.fromLngLat(Double.parseDouble(mSource.split(",")[1]),Double.parseDouble(mSource.split(",")[0]));
                builder.coordinate(point);
            }
        }

        if (mapplsPins!=null&&mapplsPins.size()>0){
            builder.coordinateList(mapplsPins);
        }
        if (pointList!=null&&pointList.size()>0){
            builder.coordinates(pointList);
        }
        if (mDestination!=null){
            if (!mDestination.contains(",")){
                builder.coordinate(mDestination);
            }else {
                Point point =Point.fromLngLat(Double.parseDouble(mDestination.split(",")[1]),Double.parseDouble(mDestination.split(",")[0]));
                builder.coordinate(point);
            }
        }
        builder.profile(DirectionsCriteria.PROFILE_DRIVING)
                .resource(DirectionsCriteria.RESOURCE_DISTANCE_ETA);
        MapplsDistanceMatrixManager.newInstance(builder.build()).call(new OnResponseCallback<DistanceResponse>() {
            @Override
            public void onSuccess(DistanceResponse distanceResponse) {
//                progressDialogHide();
                if (distanceResponse != null) {
                    DistanceResults distanceResults = distanceResponse.results();

                    if (distanceResults != null) {
                        updateData(distanceResults);
                    } else {
                        Toast.makeText(MapsActivity1.this, "Failed: " + distanceResponse.responseCode(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onError(int i, String s) {
//                progressDialogHide();
                Log.e("Mapples","Couldn't Calculate Distance");
                Toast.makeText(MapsActivity1.this, "Failed: " + s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateData(DistanceResults distanceResults) {

        directionDetailsLayout.setVisibility(View.VISIBLE);
        floatingActionButton.setVisibility(View.VISIBLE);
        tvDuration.setText("(" + getFormattedDuration(distanceResults.durations().get(0)[1]) + ")");
        tvDistance.setText(getFormattedDistance(distanceResults.distances().get(0)[1]));
    }

    private String getFormattedDistance(double distance) {

        if ((distance / 1000) < 1) {
            return distance + "mtr.";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(distance / 1000) + "Km.";
    }

    private String getFormattedDuration(double duration) {
        long min = (long) (duration % 3600 / 60);
        long hours = (long) (duration % 86400 / 3600);
        long days = (long) (duration / 86400);
        if (days > 0L) {
            return days + " " + (days > 1L ? "Days" : "Day") + " " + hours + " " + "hr" + (min > 0L ? " " + min + " " + "min." : "");
        } else {
            return hours > 0L ? hours + " " + "hr" + (min > 0L ? " " + min + " " + "min" : "") : min + " " + "min.";
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==501&&resultCode==RESULT_OK){

            List<String> mapplsPinList= new ArrayList<>();
            List<Point> points = new ArrayList<>();
            if (data.hasExtra("origin")){
                mSource = data.getStringExtra("origin");

            }
            if (data.hasExtra("waypoints")){
                String wayPoints=  data.getStringExtra("waypoints");
                if (!wayPoints.contains(";")){
                    if (!wayPoints.contains(",")){
                        mapplsPinList.add(wayPoints);
                    }else{
                        Point point = Point.fromLngLat(Double.parseDouble(wayPoints.split(",")[1]),Double.parseDouble(wayPoints.split(",")[0]));
                        points.add(point);
                    }
                }else {
                    String [] wayPointsArray = wayPoints.split(";");
                    for (String value :wayPointsArray){
                        if (!value.contains(",")){
                            mapplsPinList.add(value);
                        }else{
                            Point point = Point.fromLngLat(Double.parseDouble(value.split(",")[1]),Double.parseDouble(value.split(",")[0]));
                            points.add(point);
                        }
                    }
                }
                this.waypoints = wayPoints;
            }
            if (data.hasExtra("destination")){
                mDestination = data.getStringExtra("destination");
            }
            calculateDistance(points,mapplsPinList);
        }
    }

}
