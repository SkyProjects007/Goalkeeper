package com.mxi.goalkeeper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mxi.goalkeeper.R;
import com.mxi.goalkeeper.activity.EditProfile;
import com.mxi.goalkeeper.activity.SignUp;
import com.mxi.goalkeeper.model.tuesday;
import com.mxi.goalkeeper.network.CommanClass;

import java.util.ArrayList;

/**
 * Created by sonali on 9/3/17.
 */
public class SignupTuesday extends RecyclerView.Adapter<SignupTuesday.CustomViewHolder> {

    private Context context;
    private ArrayList<tuesday> arrayList;
    CommanClass cc;

    public SignupTuesday(Context context, ArrayList<tuesday> list) {
        this.context = context;
        arrayList = ((ArrayList) list);

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.row_signup_child_time, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int i) {

        final tuesday list = arrayList.get(i);
        //  if (!arrayList.isEmpty()) {
        holder.tv_time.setText(list.getMin_time() + " " + "To" + " " + list.getMax_time());
        holder.iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!cc.loadPrefBoolean("islogin")) {
                    SignUp.tuesdaylist.remove(i);
                } else {
                    EditProfile.tuesdaylist.remove(i);
                }
                notifyDataSetChanged();

            }
        });
        Log.e("tue_adapter", holder.tv_time.getText().toString());
        //}

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView tv_time;
        protected ImageView iv_close;

        public CustomViewHolder(View convertView) {
            super(convertView);

            tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            iv_close = (ImageView) convertView.findViewById(R.id.iv_close);
            cc = new CommanClass(context);
        }
    }

}
