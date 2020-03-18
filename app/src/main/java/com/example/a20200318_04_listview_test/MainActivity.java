package com.example.a20200318_04_listview_test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

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

        binding.roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                클릭 된 방의 정보를 목록에서 빼옴. position번째.
                Room clickedRoom = roomDatas.get(position);

//                방 상세 화면으로 이동.
                Intent intent = new Intent(mContext, RoomDetailActivity.class);
                intent.putExtra("room", clickedRoom);
                startActivity(intent);


            }
        });

        binding.roomListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

//                꾹 누르고 있으면, 해당 방의 설명을 Toast로 출력
//                Room data = roomDatas.get(position);
//                Toast.makeText(mContext, data.getDescription(), Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setTitle("방 삭제 확인");
                alert.setMessage("정말 이 방을 삭제하시겠습니까?");
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        roomDatas.remove(position);

                        roomAdapter.notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("취소", null);
                alert.show();



                return true; // true : 롱클릭만. false : 그냥클릭도 같이.
            }
        });


    }

    @Override
    public void setValues() {
        roomAdapter = new RoomAdapter(mContext, R.layout.romm_list_item, roomDatas);
        binding.roomListView.setAdapter(roomAdapter);

        addRooms();

    }

    private void addRooms() {
        roomDatas.add(new Room(8000, "서울시 은평구", 4, "살기 좋은 방입니다."));
        roomDatas.add(new Room(25000, "서울시 노원구", 2, "노원구의 투룸"));
        roomDatas.add(new Room(18000, "서울시 종로구", 1, "종로구의 투룸"));
        roomDatas.add(new Room(6000, "경기도 부천시", 0, "부천시 원룸"));
        roomDatas.add(new Room(45000, "경기도 고양시", -1, "고양시 단독주택"));

        roomAdapter.notifyDataSetChanged();

    }

}