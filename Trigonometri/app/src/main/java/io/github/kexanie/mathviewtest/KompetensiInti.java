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

public class KompetensiInti extends AppCompatActivity {

    MathView tex_tujuan;
    String tex = "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\n" +
            "  <tr>\n" +
            "    <td width=\"13%\" valign=\"top\">1</td>\n" +
            "    <td width=\"2%\" valign=\"top\">:</td>\n" +
            "    <td width=\"85%\">Menghayati dan mengamalkan ajaran agama yang dianutnya.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">2</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Menghayati dan mengamalkan perilaku jujur, disiplin, tanggungjawab, peduli (gotong royong, kerjasama, toleran, damai), santun, responsif dan pro-aktif dan menunjukkan sikap sebagai bagian dari solusi atas berbagai permasalahan dalam berinteraksi secara efektif dengan lingkungan sosial dan alam serta dalam menempatkan diri sebagai cerminan bangsa dalam pergaulan dunia.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">3</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Memahami, menerapkan, dan menganalisis pengetahuan faktual, konseptual, prosedural, dan metakognitif berdasarkan rasa ingin tahunya tentang ilmu pengetahuan, teknologi, seni, budaya, dan humaniora dengan wawasan kemanusiaan, kebangsaan, kenegaraan, dan peradaban terkait penyebab fenomena dan kejadian, serta menerapkan pengetahuan prosedural pada bidang kajian yang spesifik sesuai dengan bakat dan minatnya untuk memecahkan masalah.</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td valign=\"top\">4</td>\n" +
            "    <td valign=\"top\">:</td>\n" +
            "    <td>Mengolah, menalar, dan menyaji dalam ranah konkret dan ranah abstrak terkait dengan pengembangan dari yang dipelajarinya di sekolah secara mandiri, bertindak secara efektif dan kreatif, serta mampu menggunakan metoda sesuai kaidah keilmuan.</td>\n" +
            "  </tr>\n" +
            "</table>";
    Intent svc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompetensi_inti);
        Toolbar toolbartujuan = (Toolbar) findViewById(R.id.toolbarkikd);
       // toolbartujuan.setBackgroundColor(getResources().getColor(R.color.indigo_500));
        toolbartujuan.setLogo(R.drawable.ic_tujuan_putih);
        toolbartujuan.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbartujuan);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tex_tujuan = (MathView) findViewById(R.id.web_kikd);
        tex_tujuan.setText(tex);
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
                Intent i = new Intent(KompetensiInti.this, pendahuluan.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
            case R.id.beranda:
                buttonmusic();
                Intent intenberanda = new Intent(KompetensiInti.this, beranda.class);
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
        Intent back = new Intent(KompetensiInti.this, pendahuluan.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
