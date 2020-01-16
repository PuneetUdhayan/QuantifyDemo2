package com.example.quantifydemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PreviousTestAdapter extends ArrayAdapter<MarksAndAnswers> {

    private static final String TAG = "CustomListAdapter";
    private Context mContext;
    private int mResource;

    public PreviousTestAdapter(Context context, int resource, ArrayList<MarksAndAnswers> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    //@NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.results_card, parent, false);

        TextView subject = convertView.findViewById(R.id.results_test_name);
        TextView techer = convertView.findViewById(R.id.results_teacher_name);
        TextView oMarks=convertView.findViewById(R.id.previous_marks);
        TextView tMarks=convertView.findViewById(R.id.previous_total);
        subject.setText(getItem(position).getTestName());
        techer.setText(getItem(position).getTeacherName());
        oMarks.setText(getItem(position).getMarksObtained()+"");
        tMarks.setText(getItem(position).getTotalmarks()+"");

        return convertView;
    }
}




