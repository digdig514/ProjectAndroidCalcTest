package com.example.digdig.projectgridview.model;

import android.content.Context;
import android.graphics.Color;


import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digdig.projectgridview.R;

import java.util.ArrayList;

/**
 * Created by digdig on 17-05-18.
 */

public class CustomNumberAdapter extends BaseAdapter
{

    private Context context;
    private ArrayList<String> listOfOperation;
    public CustomNumberAdapter(Context context, ArrayList<String> listOfOperation) {
        this.context = context;
        this.listOfOperation = listOfOperation;
    }


        @Override
    public int getCount() {
        return listOfOperation.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfOperation.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        textView = (TextView) View.inflate(context, R.layout.one_element,null);
        int collumNumber = (position % 6) + 1;
        int rowNumber = (position / 6) + 1;
if (collumNumber!=6)
{
    textView.setText((listOfOperation.get(position)));
    textView.setTextSize(30);

    //textView.setLayoutParams(new GridView.LayoutParams(130,130));
    textView.setGravity(Gravity.CENTER);
    textView.setLayoutParams(new GridView.LayoutParams((int)context.getResources().getDimension(R.dimen.gridview),(int)context.getResources().getDimension(R.dimen.gridview)));
    return textView;
}
else

{
    ImageView imageView = new ImageView(context);


   if (listOfOperation.get(position).equals("ok")) {
        imageView.setImageResource(R.drawable.ok);
    }
   else if (listOfOperation.get(position).equals("bad")) {
        imageView.setImageResource(R.drawable.bad);
    } else
    {
          imageView.setImageResource(R.drawable.empty);
    }

    //imageView.setLayoutParams(new GridView.LayoutParams(130,130));
  imageView.setLayoutParams(new GridView.LayoutParams((int)context.getResources().getDimension(R.dimen.gridview),(int)context.getResources().getDimension(R.dimen.gridview)));

    return imageView;

}

    }
}
