package com.finish.payanterm.aslijava;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.finish.payanterm.R;
import com.finish.payanterm.databases.DatabaseHelper;

import java.util.List;

    class MyListAdapter extends BaseAdapter {

        private Context context;
        private List<bus> buss;

        MyListAdapter(Context context, List<bus> buss){
            this.context = context;
            this.buss = buss;
        }

        @Override
        public int getCount() {
            return buss.size();
        }

        @Override
        public Object getItem(int i) {
            return buss.get(i);
        }

        @Override
        public long getItemId(int i) {
            return Long.parseLong(buss.get(i).getPLAQUE());
        }

        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {

            View rowView = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
            TextView txtpalque = (TextView) rowView.findViewById(R.id.textPlaque);
            //TextView tedadsandali = (TextView) rowView.findViewById(R.id.tedadsandali);
            //TextView saltolid = (TextView) rowView.findViewById(R.id.saltolid);
            //TextView txtmodel = (TextView) rowView.findViewById(R.id.modell);
            Button btnEdit = (Button) rowView.findViewById(R.id.btn_edit);
            Button btnDelete = (Button) rowView.findViewById(R.id.btn_delete);

            txtpalque.setText(buss.get(position).getPLAQUE());
//            tedadsandali.setText(buss.get(position).getNUMBER_OF_SEATS());
//            txtmodel.setText(buss.get(position).getMODEL());
//            saltolid.setText(buss.get(position).getPRODUCTION_YEAR());

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((bus) context).editEmployee(buss.get(position));
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new DatabaseHelper(context).deleteBus(buss.get(position));
                    buss.remove(position);
                    notifyDataSetChanged();
                }
            });

            return rowView;
        }
    }

