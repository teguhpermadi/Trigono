package io.github.kexanie.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.kexanie.mathviewtest.ListAdapterResult;
import io.github.kexanie.mathviewtest.R;
import io.github.kexanie.mathviewtest.materi;


public class ResultActivityBab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Toolbar toolbarresult = (Toolbar) findViewById(R.id.toolbarresult);
       // toolbarresult.setBackgroundColor(getResources().getColor(R.color.indigo_500));
        setSupportActionBar(toolbarresult);
        toolbarresult.setLogo(R.drawable.ic_bintang);
        toolbarresult.setNavigationIcon(R.drawable.ic_back);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //get text view
        TextView t = (TextView) findViewById(R.id.textResult);
        TextView tvbenar = (TextView) findViewById(R.id.textViewBenar);
        TextView tvsalah = (TextView) findViewById(R.id.textViewSalah);
        TextView tvTotalNilai = (TextView) findViewById(R.id.tvTotalNilai);
        ImageView imgResult = (ImageView) findViewById(R.id.imgResult);

        //get score
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        int salah = 10 - b.getInt("score");
        int totalnilai = b.getInt("score") * 10;

        ArrayList<String> soal = b.getStringArrayList("soal");
        ArrayList<String> jawab = b.getStringArrayList("jawab");
        ArrayList<Integer> gambar = b.getIntegerArrayList("gambar");
        ArrayList<String> kunci = b.getStringArrayList("kunci");

        String[] stringsoal = new String[soal.size()];
        stringsoal = soal.toArray(stringsoal);

        String[] stringjawab = new String[jawab.size()];
        stringjawab = jawab.toArray(stringjawab);

        Integer[] img = new Integer[gambar.size()];
        img = gambar.toArray(img);

        String[] stringkunci = new String[kunci.size()];
        stringkunci = kunci.toArray(stringkunci);

        ListView ambilsoal = (ListView) findViewById(R.id.listsoal);
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stringjawab);
        ListAdapterResult adapter = new ListAdapterResult(this, stringjawab, stringsoal, img, stringkunci);
        ambilsoal.setAdapter(adapter);

        //display score
        if(score >= 7.5){
            t.setText("Selamat anda telah LULUS tes ini, silakan lanjutkan ke sub bab berikutnya.");
            imgResult.setImageResource(R.drawable.bintang4);
        }else if(score >= 5){
            t.setText("Maaf anda TIDAK LULUS tes ini, silahkan ulangi lagi.");
            imgResult.setImageResource(R.drawable.bintang3);
        }else if(score >= 2.5){
            t.setText("Maaf anda TIDAK LULUS tes ini, silahkan ulangi lagi.");
            imgResult.setImageResource(R.drawable.bintang2);
        } else {
            t.setText("Maaf anda TIDAK LULUS tes ini, silahkan ulangi lagi.");
            imgResult.setImageResource(R.drawable.bintang1);
        }

         tvTotalNilai.setText("Nilai Anda: " + totalnilai);
         tvbenar.setText("Benar: " + score);
         tvsalah.setText("Salah: " + salah);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent i = new Intent(ResultActivityBab.this, materi.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }
}