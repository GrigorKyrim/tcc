package com.example.nop_had.animalanatomyalpha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class timeline_adapter extends ArrayAdapter<timeline>{

        private final Context context;
        private final ArrayList<timeline> elementos;

        public timeline_adapter(Context context, ArrayList<timeline> elementos){

            super(context, R.layout.timeline, elementos);
            this.context = context;
            this.elementos = elementos;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.timeline, parent, false);

            TextView titleTimeline = (TextView) rowView.findViewById(R.id.txttitle);
            TextView userTimeline = (TextView) rowView.findViewById(R.id.txtuser);
            TextView descTimeline = (TextView) rowView.findViewById(R.id.txtudesc);
            ImageView image = (ImageView) rowView.findViewById(R.id.iconanonimo);
            ImageView btninteresse = (ImageView) rowView.findViewById(R.id.btninteresse);
            ImageView btncomments = (ImageView) rowView.findViewById(R.id.btncomments);
            ImageView btnshare = (ImageView) rowView.findViewById(R.id.btnshare);

            titleTimeline.setText(elementos.get(position).getTitle());
            userTimeline.setText(elementos.get(position).getUser());
            descTimeline.setText(elementos.get(position).getDesc());
            image.setImageResource(elementos.get(position).getImage());
            btninteresse.setImageResource(elementos.get(position).getBtninteresse());
            btncomments.setImageResource(elementos.get(position).getBtncomments());
            btnshare.setImageResource(elementos.get(position).getBtnshare());

            return  rowView;

        }

}
