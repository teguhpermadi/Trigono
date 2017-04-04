package io.github.kexanie.mathviewtest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Teguh Permadi on 29/06/2016.
 */
public class ListAdapterMateri extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] isimateri;
    public ListAdapterMateri(Activity context, String[] isimateri) {
        super(context, R.layout.row_materi, isimateri);
        this.context = context;
        this.isimateri = isimateri;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row_materi, null, true);
        TextView txtMateri = (TextView)rowView.findViewById(R.id.tvMateri);
        txtMateri.setText(isimateri[position]);
        return rowView;
    };
}
