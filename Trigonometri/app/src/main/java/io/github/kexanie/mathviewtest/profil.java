package io.github.kexanie.mathviewtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import io.github.kexanie.library.MathView;
import io.github.kexanie.musik.BackgroundSoundService;

public class profil extends AppCompatActivity {

    MathView tex_profil;
    String tex = "<p><strong>Penyusun</strong></p>" +
            "Nama: Haidir Ali<br />" +
            "NPM: 2120720059<br />" +
            "Alamat: Jl. Perancak, Ds. Airkuning, Kec. Negara – Bali<br />" +
            "Fakultas: Keguruan dan Ilmu Pendidikan<br />" +
            "Universitas: Universitas Islam Malang<br />" +
            "<p><strong>Pembimbing</strong></p>" +
            "<ol>" +
            "<li>" + // sunismi
            "Nama: Dr. Sunismi, M.Pd<br />" +
            "Tempat, tanggal lahir : Malang, 17 Januari 1966<br />" +
            "Alamat: Perum Bunul Asri A-55 Malang" +
            "</li>" +
            "<li>" + // etti
            "Nama: Dra. Ettie rukmigarsari, M.Kes<br />" +
            "Tempat, tanggal lahir : Yogyakarta, 29 april 1967<br />" +
            "Alamat: Perum Joyogrand H1-7 Malang" +
            "</li>" +
            "</ol>";
    Intent svc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Toolbar toolbarprofil = (Toolbar) findViewById(R.id.toolbarprofil);
       // toolbarprofil.setBackgroundColor(getResources().getColor(R.color.indigo_500));
        toolbarprofil.setLogo(R.drawable.ic_profil_putih);
        toolbarprofil.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbarprofil);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tex_profil = (MathView) findViewById(R.id.web_profil);
        tex_profil.setText(tex);
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
                Intent i = new Intent(profil.this, beranda.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
            case R.id.beranda:
                buttonmusic();
                Intent intentberanda = new Intent(profil.this, beranda.class);
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
        Intent back = new Intent(profil.this, beranda.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
