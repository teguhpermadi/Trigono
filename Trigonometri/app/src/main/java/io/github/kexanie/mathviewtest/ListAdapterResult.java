package io.github.kexanie.mathviewtest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.kexanie.quiz.ResultActivityBab;


/**
 * Created by Teguh Permadi on 24/06/2016.
 */
public class ListAdapterResult extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] soal;
    private final String[] jawab;
    private final Integer[] gambar;
    private final String[] kunci;

    public ListAdapterResult(Activity context, String[] soal, String[] jawab, Integer[] gambar, String[] kunci) {
        super(context, R.layout.row, soal);
        this.context = context;
        this.soal = soal;
        this.jawab = jawab;
        this.gambar = gambar;
        this.kunci = kunci;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row_result, null, true);

       // TextView txtBenarSalah = (TextView)rowView.findViewById(R.id.tvBenarSalah);
        TextView txtJawaban = (TextView)rowView.findViewById(R.id.tvJawaban);
        TextView txtSoal = (TextView)rowView.findViewById(R.id.tvSoal);
        ImageView imBenarSalah = (ImageView)rowView.findViewById(R.id.imgBenarSalah);
        TextView txtKunci = (TextView)rowView.findViewById(R.id.tvKunci);

       // txtBenarSalah.setText(soal[position]);
        txtJawaban.setText(soal[position]);
        txtSoal.setText(jawab[position]);
        imBenarSalah.setImageResource(gambar[position]);
        txtKunci.setText(kunci[position]);

        return rowView;
    };
}
