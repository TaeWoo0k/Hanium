package com.uhwaw.hanium;

/*
전화는 가능, 119는 ACTION_CALL이 안되고 ACTION_DIAL로 됨
 지도에 마크찍고 범위 벗어나면 알림가게

 */
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;

import androidx.core.app.ActivityCompat;

import androidx.core.content.ContextCompat;

import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
//
//import com.jjoe64.graphview.GraphView;
//import com.jjoe64.graphview.series.DataPoint;
//import com.jjoe64.graphview.series.LineGraphSeries;

public class Person0 extends AppCompatActivity {

    ImageButton  btntel, btngps, btnnine;
    Uri number;
    static final int SMS_SEND_PERMISSON = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person0);
        int permissonCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (permissonCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "SMS 수신권한 있음", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "SMS 수신권한 없음", Toast.LENGTH_SHORT).show();

            //권한설정 dialog에서 거부를 누르면
            //ActivityCompat.shouldShowRequestPermissionRationale 메소드의 반환값이 true가 된다.
            //단, 사용자가 "Don't ask again"을 체크한 경우
            //거부하더라도 false를 반환하여, 직접 사용자가 권한을 부여하지 않는 이상, 권한을 요청할 수 없게 된다.
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
                //이곳에 권한이 왜 필요한지 설명하는 Toast나 dialog를 띄워준 후, 다시 권한을 요청한다.
                Toast.makeText(getApplicationContext(), "SMS권한이 필요합니다", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SMS_SEND_PERMISSON);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SMS_SEND_PERMISSON);
            }
        }

// 그래프 띄우기
//        final GraphView graph = (GraphView) findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6),
//        });
//        graph.addSeries(series);
//        graph.setTitle("이번달");

        btnnine = (ImageButton) findViewById(R.id.nine);
        btngps = (ImageButton) findViewById(R.id.gps);

        btntel = (ImageButton) findViewById(R.id.tel);


      /*  Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        String gender = intent.getStringExtra("gender");
        String phone = intent.getStringExtra("phone");
        String gps = intent.getStringExtra("gps");
        final int ycount = intent.getIntExtra("ycount", 161616);
        final int mcount = intent.getIntExtra("mcount", 151515);
        final int wcount = intent.getIntExtra("wcount", 141414);
        final int picture = intent.getIntExtra("picture", 131313);
        final Double tem = intent.getDoubleExtra("tem", 0);
        */
        String name = "김태욱";
        String gender = "남자";
        String age = "13";
        int picture = 0x000000;

//        btncount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String count = "올해 " + Integer.toString(ycount) + "번\n이번 달 " + Integer.toString(mcount) + "번\n이번 주 " + Integer.toString(wcount) + "번 ";
//                graph.setVisibility(View.VISIBLE);
//                tvresult.setText(count);
//                tvresult.setVisibility(View.VISIBLE);
//            }
//        });

        btngps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GPS_EX.class);
                startActivity(intent);
            }
        });
//        btntem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imtem.setVisibility(View.VISIBLE);
//                if (tem <= 35.5) {
//                    imtem.setBackgroundResource(R.drawable.t27);
//                    tvresult.setText("체온: " + tem.toString() + " 도\n저체온 \n증상은 @@ ");
//                } else if (tem < 37.0) {
//                    imtem.setBackgroundResource(R.drawable.t32);    //정상
//                    tvresult.setText("체온: " + tem.toString() + " 도\n정상체온\n증상은 @@ ");
//                } else if (tem >= 37.0) {
//                    imtem.setBackgroundResource(R.drawable.t38);
//                    tvresult.setText("체온: " + tem.toString() + " 도\n고온\n증상은 @@ ");
//                } else if (tem >= 38.0) {
//                    imtem.setBackgroundResource(R.drawable.t40);
//                    tvresult.setText("체온: " + tem.toString() + " 도\n 심한 고온\n 증상은 @@ ");
//                } else if (tem >= 39.0) {
//                    imtem.setBackgroundResource(R.drawable.t42);
//                    tvresult.setText("체온: " + tem.toString() + " 도\n 초고온\n 증상은 @@ ");
//                }
//                tvresult.setVisibility(View.VISIBLE);
//            }
//        });




        btntel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Uri.parse("tel:010-9401-5487");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    /**
                     * * 사용자 단말기의 권한 중 "전화걸기" 권한이 허용되어 있는지 확인한다. * Android는 C언어 기반으로 만들어졌기 때문에 Boolean 타입보다 Int 타입을 사용한다. */

                    int permissionResult = checkSelfPermission(Manifest.permission.CALL_PHONE);

                    /** * 패키지는 안드로이드 어플리케이션의 아이디이다. * 현재 어플리케이션이 CALL_PHONE에 대해 거부되어있는지 확인한다. */

                    if (permissionResult == PackageManager.PERMISSION_DENIED) {

                        /** * 사용자가 CALL_PHONE 권한을 거부한 적이 있는지 확인한다. * 거부한적이 있으면 True를 리턴하고 * 거부한적이 없으면 False를 리턴한다. */

                        if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
                            dialog.setTitle("권한이 필요합니다.")
                                    .setMessage("이 기능을 사용하기 위해서는 단말기의 \"전화걸기\" 권한이 필요합니다. 계속 하시겠습니까?")
                                    .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            /** * 새로운 인스턴스(onClickListener)를 생성했기 때문에 * 버전체크를 다시 해준다. */
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                                                // CALL_PHONE 권한을 Android OS에 요청한다.
                                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                                            }
                                        }
                                    }).setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "기능을 취소했습니다", Toast.LENGTH_SHORT).show();
                                }
                            }).create().show();
                        }
                        // 최초로 권한을 요청할 때
                        else {
                            // CALL_PHONE 권한을 Android OS에 요청한다.
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                        }
                    }
                    // CALL_PHONE의 권한이 있을 때
                    else { // 즉시 실행
                        Intent intent = new Intent(Intent.ACTION_CALL, number);
                        startActivity(intent);
                    }
                }
                // 마시멜로우 미만의 버전일 때
                else { // 즉시 실행
                    Intent intent = new Intent(Intent.ACTION_CALL, number);
                    startActivity(intent);
                }
            }
        });
        //보호대상자에게 전화

        btnnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 사용자의 OS 버전이 마시멜로우 이상인지 체크한다.
                number = Uri.parse("tel: 119");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    /**
                     * * 사용자 단말기의 권한 중 "전화걸기" 권한이 허용되어 있는지 확인한다. * Android는 C언어 기반으로 만들어졌기 때문에 Boolean 타입보다 Int 타입을 사용한다. */

                    int permissionResult = checkSelfPermission(Manifest.permission.CALL_PHONE);

                    /** * 패키지는 안드로이드 어플리케이션의 아이디이다. * 현재 어플리케이션이 CALL_PHONE에 대해 거부되어있는지 확인한다. */

                    if (permissionResult == PackageManager.PERMISSION_DENIED) {

                        /** * 사용자가 CALL_PHONE 권한을 거부한 적이 있는지 확인한다. * 거부한적이 있으면 True를 리턴하고 * 거부한적이 없으면 False를 리턴한다. */

                        if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
                            dialog.setTitle("권한이 필요합니다.")
                                    .setMessage("이 기능을 사용하기 위해서는 단말기의 \"전화걸기\" 권한이 필요합니다. 계속 하시겠습니까?")
                                    .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            /** * 새로운 인스턴스(onClickListener)를 생성했기 때문에 * 버전체크를 다시 해준다. */
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                                                // CALL_PHONE 권한을 Android OS에 요청한다.
                                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                                            }
                                        }
                                    }).setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "기능을 취소했습니다", Toast.LENGTH_SHORT).show();
                                }
                            }).create().show();
                        }
                        // 최초로 권한을 요청할 때
                        else {
                            // CALL_PHONE 권한을 Android OS에 요청한다.
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                        }
                    }
                    // CALL_PHONE의 권한이 있을 때
                    else { // 즉시 실행
                        Intent intent = new Intent(Intent.ACTION_CALL, number);
                        startActivity(intent);
                    }
                }
                // 마시멜로우 미만의 버전일 때
                else { // 즉시 실행
                    Intent intent = new Intent(Intent.ACTION_CALL, number);
                    startActivity(intent);
                }
            }
        });
        //119에 전화
    }

    /**
     * 권한 요청에 대한 응답을 이곳에서 가져온다. * *
     *
     * @param requestCode  요청코드 *
     * @param permissions  사용자가 요청한 권한들 *
     * @param grantResults 권한에 대한 응답들(인덱스별로 매칭)
     */
    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1000) { // 요청한 권한을 사용자가 "허용" 했다면...
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_CALL, number);
                // Add Check Permission
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);
                }
            } else {
                Toast.makeText(getApplicationContext(), "권한요청을 거부했습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    // 전화 권한 확인
}
