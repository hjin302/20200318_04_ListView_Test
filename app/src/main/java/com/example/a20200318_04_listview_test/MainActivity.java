package com.example.a20200318_04_listview_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.a20200318_04_listview_test.adapters.RoomAdapter;
import com.example.a20200318_04_listview_test.databinding.ActivityMainBinding;
import com.example.a20200318_04_listview_test.datas.Room;

import java.util.ArrayList;
import java.util.List;


// 20200318_04_ListView02
public class MainActivity extends BaseActivity {
    List<Room> roomDatas = new ArrayList<>();
    RoomAdapter roomAdapter = null;

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        roomAdapter = new RoomAdapter(mContext, R.layout.romm_list_item, roomDatas);
        binding.roomListView.setAdapter(roomAdapter);
        addRooms();
    }

    private void addRooms() {
        roomDatas.add(new Room(8000, "서울시 은평구", 4, "살기 좋은 방입니다."));
        roomDatas.add(new Room(25000, "서울시 노원구", 2, "노원구의 투룸."));
        roomDatas.add(new Room(18000, "서울시 종로구", 1, "종로구의 투룸."));
        roomDatas.add(new Room(6000, "경기도 부천시", 0, "부천시 원룸."));
        roomDatas.add(new Room(45000, "경기도 고양시", -1, "고양시 단독주택."));

        roomAdapter.notifyDataSetChanged();
    }


}
