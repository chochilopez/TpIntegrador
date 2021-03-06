package com.dam2020.globe.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.dam2020.globe.R;
import com.dam2020.globe.entity.DestinoPunto;
import com.dam2020.globe.singleton.AppDatabase;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    private Spinner comboTipoMapa;
    private CameraPosition camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            LatLng destino=new LatLng(parametros.getDouble("latitud"), parametros.getDouble("longitud"));
            camera=new CameraPosition.Builder().target(destino).bearing(0).tilt(10).zoom(8).build();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
//        Boolean granted=false;
//        if (ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
//                ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
//            granted=true;
//        else {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 2);
//            granted=true;
//        }
//        if (granted){
            map = googleMap;
            //FIXME solucionar permisos ¿Los necesesito?
            //map.setMyLocationEnabled(true);
            LatLng utn=new LatLng(-31.616470, -60.675239);

            map.addMarker(new MarkerOptions().position(utn).title("Mi casa"));

            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.getUiSettings().setZoomControlsEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(true);
            map.getUiSettings().setCompassEnabled(true);

            if (camera==null)
                camera=new CameraPosition.Builder().target(utn).bearing(0).tilt(10).zoom(5).build();
            map.animateCamera(CameraUpdateFactory.newCameraPosition(camera), 5000, null);

            List<DestinoPunto> destinos=AppDatabase.getAppDatabase(this).destinoDao().getDestinosPuntos();
            for (DestinoPunto destino : destinos){
                map.addMarker(new MarkerOptions().position(new LatLng(destino.getPunto().getLatitud(),destino.getPunto().getLongitud())).
                        title(destino.getDestino().getNombre()).
                        snippet(destino.getDestino().getDescripcion()).
                        draggable(false).
                        icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_maps_xs)));
            }

            comboTipoMapa=findViewById(R.id.comboTipoMapa);
            comboTipoMapa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                            break;
                        case 1:
                            map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                            break;
                        case 2:
                            map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                            break;
                        case 3:
                            map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                            break;
                        }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
//        } else
//            finish();
    }
}