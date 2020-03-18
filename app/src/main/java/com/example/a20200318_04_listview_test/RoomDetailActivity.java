package com.example.a20200318_04_listview_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.a20200318_04_listview_test.databinding.ActivityRoomDetailBinding;
import com.example.a20200318_04_listview_test.datas.Room;

public class RoomDetailActivity extends BaseActivity {

    ActivityRoomDetailBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_detail);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

//        첨부된 방 데이터를 받아서 화면에 출력.
        Room room = (Room) getIntent().getSerializableExtra("room");

        binding.priceTxt.setText(room.getFormattedPrive());
        binding.floorTxt.setText(room.getFloorString());
        binding.descTxt.setText(room.getDescription());

    }
}