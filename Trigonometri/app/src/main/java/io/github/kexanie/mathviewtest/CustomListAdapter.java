package io.github.kexanie.mathviewtest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Teguh Permadi on 30/05/2016.
 */
public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] menu_beranda;
    private final String[] des_menu;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context, String[] menu_beranda, String[] des_menu, Integer[] imgid) {
        super(context, R.layout.row, menu_beranda);
        this.context = context;
        this.menu_beranda = menu_beranda;
        this.des_menu = des_menu;
        this.imgid = imgid;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row, null, true);

        TextView txtTitle = (TextView)rowView.findViewById(R.id.txtTitle);
        ImageView imgView = (ImageView)rowView.findViewById(R.id.icon_menu);
        TextView txtDes = (TextView)rowView.findViewById(R.id.txtDeskripsi);

        txtTitle.setText(menu_beranda[position]);
        txtDes.setText(des_menu[position]);
        imgView.setImageResource(imgid[position]);

        return rowView;
    };
}