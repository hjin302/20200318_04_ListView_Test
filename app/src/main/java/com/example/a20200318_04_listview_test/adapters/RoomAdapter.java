package com.example.a20200318_04_listview_test.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.a20200318_04_listview_test.datas.Room;

import java.util.List;

import androidx.annotation.NonNull;

public class RoomAdapter extends ArrayAdapter<Room> {

    Context mContext;


    public RoomAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);

        mContext = context;

    }

}
