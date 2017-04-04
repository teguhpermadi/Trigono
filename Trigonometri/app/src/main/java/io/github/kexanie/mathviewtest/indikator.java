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

import io.github.kexanie.library.MathView;
import io.github.kexanie.musik.BackgroundSoundService;

public class indikator extends AppCompatActivity {

    MathView tex_indikator;
    String tex = "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\n" +
            "  <tr>\n" +
            "    <td width=\"16%\" valign=\"top\">3.15.1</td>\n" +
            "    <td width=\"3%\" valign=\"top\">:</td>\n" +
            "    <td width=\"81%\">Menentukan  besar suatu sudut, yang berhubungan dengan derajat dan radian.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.15.2</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menghitung  nilai derajat dan radian.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.15.3</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menemukan  konsep dasar sudut (sudut standar dan sudut koterminal).</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.15.4</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menentukan  nilai perbandingan trigonometri untuk sudut di berbagai kuadran.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.16.1</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menemukan konsep  perbandingan-perbandingan trigonometri pada segitiga siku-siku.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.16.2</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Merumuskan  perbandingan trigonometri dari suatu sudut pada sistem koordinat kartesius.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.17.1</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menentukan  nilai perbandingan trigonometri untuk sudut di berbagai kuadran.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.17.2</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menemukan  hubungan perbandingan trigonometri dari sudut-sudut di berbagai kuadran</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.17.3</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menentukan  strategi yang tepat dalam memanfaatkan perbandingan trigonometri untuk  menyelesaikan masalah.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.17.4</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menyelesaikan  permasalahan nyata yang berkaitan dengan perbandingan trigonometri dari sudut  di berbagai kuadran.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.18.1</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Membuktikan  sudut istimewa</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.18.2</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Membuktikan  identitas trigonometri sederhana.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">4.14.1</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Terampil  menerapkan konsep/prinsip dan strategi pemecahan masalah yang relevan yang  berkaitan dengan nilai fungsi diberbagai kuadran</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">4.15.1</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menentukan nilai maksimum, minimum dan amplitodo fungsi sinus, cosinus,  dan tangen</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">4.15.2</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menggambar grafik fungsi trigonometri f(x) = sin x dengan menggunakan sudut istimewa</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">4.15.3</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menggambar grafik fungsi trigonometri f(x) = cos x dengan menggunakan sudut istimewa</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">4.15.4</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menggambar grafik fungsi trigonometri f(x) = tan x dengan menggunakan sudut istimewa</td>\n" +
            "  </tr>\n" +
            "</table>";
    Intent svc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indikator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarindikator);
        toolbar.setLogo(R.drawable.ic_tujuan_putih);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tex_indikator = (MathView) findViewById(R.id.web_indikator);
        tex_indikator.setText(tex);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //  Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                buttonmusic();
                Intent i = new Intent(indikator.this, pendahuluan.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
            case R.id.beranda:
                buttonmusic();
                Intent intenberanda = new Intent(indikator.this, beranda.class);
                intenberanda.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intenberanda);
                return (true);
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
        Intent back = new Intent(indikator.this, pendahuluan.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
