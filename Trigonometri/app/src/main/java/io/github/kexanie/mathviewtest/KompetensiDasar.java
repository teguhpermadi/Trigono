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
import io.github.kexanie.quiz.QuizBab1;

public class KompetensiDasar extends AppCompatActivity {
    Intent svc;
    MathView tex_kompdas;
    String tex = "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\n" +
            "  <tr>\n" +
            "    <td width=\"16%\" valign=\"top\">3.15</td>\n" +
            "    <td width=\"3%\" valign=\"top\">:</td>\n" +
            "    <td width=\"81%\">Memahami konsep perbandingan trigonometri pada segitiga siku-siku melalui penyelidikan dan diskusi tentang hubungan perbandingan sisi-sisi yang bersesuaian dalam beberapa segitiga siku- siku sebangun.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.16</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menemukan sifat-sifat dan hubungan antar perbandingan trigonometri dalam segitiga siku- siku.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.17</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Mendeskripsikan dan menentukan hubungan perbandingan Trigonometri dari sudut di setiap kuadran, memilih dan menerapkan dalam penyelesaian masalah nyata dan matematika.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3.18</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Memahami konsep fungsi trigonometri dan menganalisis grafik fungsinya serta menentukan hubungan nilai fungsi trigonometri dari sudut- sudut istimewa.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">4.14</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menerapkan perbandingan trigonometri dalam menyelesaikan masalah.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">4.15</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menyajikan grafik fungsi trigonometri</td>\n" +
            "  </tr>\n" +
            "</table>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompetensi_dasar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_tujuan_putih);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);
    }
    @Override
    protected void onResume() {
        super.onResume();
        tex_kompdas = (MathView) findViewById(R.id.web_kd);
        tex_kompdas.setText(tex);
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
                Intent i = new Intent(KompetensiDasar.this, pendahuluan.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;
            case R.id.beranda:
                buttonmusic();
                Intent intenberanda = new Intent(KompetensiDasar.this, beranda.class);
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
        Intent back = new Intent(KompetensiDasar.this, pendahuluan.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
