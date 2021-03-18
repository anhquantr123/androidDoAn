package com.example.safe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.safe.fragment.about_fragment;
import com.example.safe.fragment.home_fragment;
import com.example.safe.fragment.new_fragment;
import com.example.safe.hanh_dong.home_fragmet_interface;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements home_fragmet_interface {
    // khai báo các thành phần
    private BottomNavigationView bottomNavigationView;
    public static final int REQUEST_ACCESS_COURSE_LOCATION= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // kiem tra thiet bi co ho tro BLE
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(this, "Tự Động Chuyển Chế Độ", Toast.LENGTH_SHORT).show();
            finish();
        }
        // call method anhxa
        anhxa();
        bottomNavigationView.setSelectedItemId(R.id.home_fragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);


        // kiểm tra thiết bị đã được bật blutooth chưa
       kiem_tra_trang_thai_blutooth();

    }

    // hàm ánh xạ các thành phần
    private void anhxa() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);


    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()){
                case R.id.home_fragment:
                    fragment = new home_fragment();
                    break;
                case R.id.tien_ich_fragment:
                    fragment = new new_fragment();
                    break;
                case R.id.about_fragment:
                    fragment = new about_fragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home_screen, fragment).commit();
            return true;
        }
    };

    @Override
    public void bat_blutooth(boolean on) {
        if(on == true){
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 0);
        }else{
            Fragment fragment = new home_fragment();
            Bundle bundle = new Bundle();
            bundle.putString("chuabat" ,"batdi");
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home_screen, fragment).commit();
        }
    }



    public void kiem_tra_trang_thai_blutooth(){
        final BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
            BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            Fragment fragment = new home_fragment();
            Bundle bundle = new Bundle();
            bundle.putString("chuabat" ,"batdi");
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home_screen, fragment).commit();
        }else{
           // Toast.makeText(this, "Thiết bị đã bật blutooth", Toast.LENGTH_SHORT).show();
        }
    }

}