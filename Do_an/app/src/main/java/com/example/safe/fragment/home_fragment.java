package com.example.safe.fragment;

import android.Manifest;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safe.MainActivity;
import com.example.safe.R;
import com.example.safe.hanh_dong.home_fragmet_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static androidx.core.content.ContextCompat.getSystemService;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class home_fragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public  Button btn_ok_check_isenable, btn_open_bluooth , btn_scanner_blutooth ;
    BluetoothAdapter bluetoothAdapter;
    com.example.safe.hanh_dong.home_fragmet_interface home_fragmet_interface;
    Dialog dialog;
    private ListView mlListView;




    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static home_fragment newInstance(String param1, String param2) {
        home_fragment fragment = new home_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_fragment, container, false);
        home_fragmet_interface =(home_fragmet_interface) getActivity();
        anh_xa(view);

        // Hiển thị thông báo check blutooth
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.check_isenable_blutooth_thongbao);
        dialog.getWindow().setBackgroundDrawable(getActivity().getDrawable(R.drawable.back_ground_check_isenable_blutooth_thongbao));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        btn_ok_check_isenable = dialog.findViewById(R.id.btn_ok_check_isenable);
        btn_open_bluooth = dialog.findViewById(R.id.btn_open_blutooth);

        // nhận thông điệp bật thông báo dialog show device blutooth
        Bundle bundle = getArguments();
        if(bundle != null){
           if(bundle.getString("chuabat").equals("batdi")){
               dialog.show();
           }
        }else{
            check_location(view);
        }

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        btn_scanner_blutooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetoothAdapter.isEnabled()){ // kiểm tra xem thiết bị thực sự bật bluetooth

                }else{
                    home_fragmet_interface.bat_blutooth(false);
                }
            }
        });

        // người dùng click nút ok -- dồng nghĩa việc chưa cho phép bật blutooth
        btn_ok_check_isenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        // người đung đồng ý cho phép safe có quyền bật blutooth
        btn_open_bluooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_fragmet_interface.bat_blutooth(true);
                dialog.dismiss();
            }
        });
        return  view;
    }



    // ánh xa các thành phần trong homeframelayout
    public void anh_xa(View v){
        btn_scanner_blutooth = (Button) v.findViewById(R.id.btn_scanner_blutooth);
        mlListView = v.findViewById(R.id.list_device);
    }

    // kiểm tra quyền truy cập thông tin vị trí khi dùng ble
    void check_location(View view){
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // kiểm tra trạng thái nếu thiết bị chưa được bật location
            Dialog dialog1 = new Dialog(getActivity());
            dialog1.setContentView(R.layout.check_isenable_location_thongbao);
            dialog1.getWindow().setBackgroundDrawable(getActivity().getDrawable(R.drawable.back_ground_check_isenable_blutooth_thongbao));
            dialog1.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog1.setCancelable(false);
            dialog1.getWindow().getAttributes().windowAnimations = R.style.animation;
            dialog1.show();
            Button btn_ok = dialog1.findViewById(R.id.btn_ok_location);
            Button btn_bat_location = dialog1.findViewById(R.id.btn_bat_location);

            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog1.dismiss();
                }
            });
            btn_bat_location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            MainActivity.REQUEST_ACCESS_COURSE_LOCATION);
                    dialog1.dismiss();
                }
            });
            // end
        } else {

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MainActivity.REQUEST_ACCESS_COURSE_LOCATION) {
            if (permissions[0].equals(Manifest.permission.ACCESS_FINE_LOCATION)
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity(), "Safe được cấp đủ quyền", Toast.LENGTH_SHORT).show();
            }
        }
    }
}