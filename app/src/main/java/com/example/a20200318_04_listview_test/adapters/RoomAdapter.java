package com.example.a20200318_04_listview_test.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import com.example.a20200318_04_listview_test.R;
import com.example.a20200318_04_listview_test.datas.Room;

public class RoomAdapter extends ArrayAdapter<Room> {

    Context mContext;
    List<Room> mList;
    LayoutInflater inf;

    public RoomAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);

        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.romm_list_item, null);
        }

        Room data = mList.get(position);

        TextView priceTxt = row.findViewById(R.id.priceTxt);
        TextView addressAndFloorTxt = row.findViewById(R.id.addressAndFloorTxt);
        TextView descTxt = row.findViewById(R.id.descTxt);

//        가격 설정 => setText에는 int값 넣지 말자!

        if(data.getPrice() >= 10000){
            int uk = data.getPrice() / 10000;
            int thousand = data.getPrice() % 10000;

            priceTxt.setText(String.format("%d억 %,d", data.getPrice()));
        }else{
            priceTxt.setText(String.format("%,d", data.getPrice()));
        }


        return row;
    }
}