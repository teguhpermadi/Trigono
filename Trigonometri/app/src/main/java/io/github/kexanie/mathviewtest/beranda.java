package io.github.kexanie.mathviewtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import io.github.kexanie.musik.BackgroundSoundService;
import io.github.kexanie.quiz.QuizActivity;

public class beranda extends AppCompatActivity {
    Intent svc;
    ListView list;
    String[] menu_beranda = {
            "Pengantar","Pendahuluan", "Materi", "Evaluasi", "Profil", "Bantuan"
    };
    String[] des_menu = {
            "Deskripsi tentang aplikasi ini",
            "Kompetensi Inti, Kompetensi Dasar, Indikator, Tujuan, dan Peta Konsep",
            "Materi yang dipelajari dalam aplikasi ini",
            "Ukur pemahamanmu setelah mempelajari materi ini",
            "Penyusun materi dalam aplikasi ini",
            "Dapatkan kemudahan mengoperasikan aplikasi ini"
    };

    Integer[] imgid = {
            R.drawable.ic_pengantar,
            R.drawable.ic_tujuan_red,
            R.drawable.ic_materi_cyan,
            R.drawable.ic_evaluasi_green,
            R.drawable.ic_profil_orange,
            R.drawable.ic_bantuan_purple
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setBackgroundColor(getResources().getColor(R.color.indigo_500));
        toolbar.setLogo(R.drawable.ic_icon);

        setSupportActionBar(toolbar);

        CustomListAdapter adapter = new CustomListAdapter(this, menu_beranda, des_menu, imgid);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu_beranda);

        list = (ListView) findViewById(R.id.listView2);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    buttonmusic();
                    Intent in_pengantar = new Intent(getApplicationContext(), pengantar.class);
                    in_pengantar.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(in_pengantar);
                } else if (position == 1) {
                    buttonmusic();
                    Intent in_pendahuluan = new Intent(getApplicationContext(), pendahuluan.class);
                    in_pendahuluan.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(in_pendahuluan);
                } else if (position == 2) {
                    buttonmusic();
                    Intent in_materi = new Intent(getApplicationContext(), materi.class);
                    in_materi.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(in_materi);
                } else if (position == 3) {
                    buttonmusic();
                    Intent in_evaluasi = new Intent(getApplicationContext(), QuizActivity.class);
                    in_evaluasi.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(in_evaluasi);
                } else if (position == 4) {
                    buttonmusic();
                    Intent in_profil = new Intent(getApplicationContext(), profil.class);
                    in_profil.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(in_profil);
                } else if (position == 5) {
                    buttonmusic();
                    Intent in_bantuan = new Intent(getApplicationContext(), bantuan.class);
                    in_bantuan.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(in_bantuan);
                }
            }
        });
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

    @Override
    public void onBackPressed() {
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
    }
}
