package io.github.kexanie.mathviewtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.github.kexanie.musik.BackgroundSoundService;

public class pendahuluan extends AppCompatActivity {

    ListView tujuan;

    String[] isitujuan = {
            "Kompetensi Inti",
            "Kompetensi Dasar",
            "Indikator",
            "Tujuan",
            "Peta Konsep"
    };
    Intent svc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendahuluan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbartujuan);
        toolbar.setLogo(R.drawable.ic_tujuan_putih);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);

        ListAdapterMateri adapter = new ListAdapterMateri(this, isitujuan);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,isimateri);
        tujuan = (ListView) findViewById(R.id.lvtujuan);
        tujuan.setAdapter(adapter);

        tujuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    buttonmusic();
                    Intent intent1 = new Intent(getApplicationContext(),KompetensiInti.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent1);
                }else if(position == 1){
                    buttonmusic();
                    Intent intent2 = new Intent(getApplicationContext(),KompetensiDasar.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent2);
                }else if(position == 2){
                    buttonmusic();
                    Intent intent3 = new Intent(getApplicationContext(),indikator.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent3);
                }else if(position == 3){
                    buttonmusic();
                    Intent intent4 = new Intent(getApplicationContext(),tujuanpembelajaran.class);
                    intent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent4);
                }else if(position == 4){
                    buttonmusic();
                    Intent intent5 = new Intent(getApplicationContext(),petakonsep.class);
                    intent5.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent5);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                buttonmusic();
                Intent i = new Intent(pendahuluan.this, beranda.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
            case R.id.beranda:
                buttonmusic();
                Intent intentberanda = new Intent(pendahuluan.this, beranda.class);
                intentberanda.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentberanda);
                return true;
            case R.id.keluar:
                buttonmusic();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Apakah anda yakin untuk keluar?")
                        .setCancelable(false)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(pendahuluan.this, beranda.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
