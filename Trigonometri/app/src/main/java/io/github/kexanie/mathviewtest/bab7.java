package io.github.kexanie.mathviewtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import io.github.kexanie.library.MathView;
import io.github.kexanie.musik.BackgroundSoundService;
import io.github.kexanie.quiz.QuizBab6;

public class bab7 extends AppCompatActivity {
    MathView texbab7;
    // Menggambar grafik fungsi trigonometri
    String tex = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<head>\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
            "<title>Ukuran Derajat</title>\n" +
            "<style type=\"text/css\">\n" +
            ".ukuran-huruf {\n" +
            "\tfont-size: 12pt;\n" +
            "\tline-height: 24px;\n" +
            "}\n" +
            "</style>" +
            "</head>\n" +
            "\n" +
            "<body class=\"ukuran-huruf\">" +
            "<strong>Menggambar Grafik Fungsi Trigonometri</strong><p />\n" +
            "Menggambar grafik fungsi trigonometri dengan menentukan titik-titik (x,y) yang kemudian kita hubungkan dengan kurva sehingga dihasilkan grafik yang sesuai dengan fungsi. Karena fungsi trigonometri mengandung suatu sudut dan perbandingan trigonometri, maka x merupakan besar sudut sedangkan y merupakan nilai perbandingan trigonometri sudut. Sebagai alat bantu kita dapat membuat tabel yang menunjukkan hubungan antara x dan y. Agar nilai y mudah ditentukan, kita dapat menggunakan sudut-sudut istimewa sebagai nilai x. Setelah membuat tabel dan diperoleh titik-titik (x,y), selanjutnya kita dapat menggambar titik-titik tersebut ke dalam koordinat cartesius dan menarik garis yang menghubungkan titik-titik tersebut sebagai hasil akhir. Berikut disajikan ilustrasi pembuatan grafik fungsi trigonometri sinus dan cosinus. \n" +
            "Nilai maksimum dan minimum fungsi sinus cosinus dan tangen\n" +
            "<ol>" +
            "<li>(sin α°) maksimum = 1, untuk α = 90 + n x 360</li>\n" +
            "<li>(sin α°) minimum = -1, untuk α = 270 + n x 360, jadi -1 ≤ sin α°≥1</li>\n" +
            "<li>(cos α°) maksimum = 1, untuk α = n x 360</li>\n" +
            "<li>(cos α°) minimum = -1, untuk α = 180 + n x 360, jadi -1 ≤ sin α° ≥ 1 untuk tiap α ∈ R </li>\n" +
            "<li>tan α° tidak mempunyai nilai maksimum maupun nilai minimum</li>\n" +
            "</ol>" +

            "<strong>Gambarkanlah grafik fungsi f(x) = sin x°</strong>\n" +
            "Pembahasan Seperti yang telah dijelaskan di atas, kita dapat membuat tabel sebagai bantuan. Kita dapat gunakan interval 0 ≤ x ≤ 360 dan y = sin x. \n" +
            "Menggunakan sudut istimewa yang sudah dipelajari sebelumnya.<br />\n" +

			"<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"1\">\n" +
				"  <tr>\n" +
				"    <td>x</td>\n" +
				"    <td>y</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>0°</td>\n" +
				"    <td>0</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>30°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>45°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\sqrt{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>60°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\sqrt{3}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>90°</td>\n" +
				"    <td>1</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>120°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\sqrt{3}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>135°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\sqrt{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>150°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>180°</td>\n" +
				"    <td>0</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>210°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>225°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\sqrt{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>240°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\sqrt{3}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>270°</td>\n" +
				"    <td>-1</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>300°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\sqrt{3}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>315°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\sqrt{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>330°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>360°</td>\n" +
				"    <td>0</td>\n" +
				"  </tr>\n" +
				"</table>" +

            "Setelah dihubungkan, akan dihasilkan grafik sebagai berikut:<br />" +
			"<img src=\"file:///android_res/mipmap/g30.png\" style=\"width:100%; margin:10px\" /><br />" +
			"<strong>Gambarkanlah grafik fungsi f(x) = cos x°</strong><p />" +
            "Pembahasan" +
            "Gunakan 0° ≤ x ≤ 360° dan y = cos x°\n" +

			"<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"1\">\n" +
				"  <tr>\n" +
				"    <td>x</td>\n" +
				"    <td>y</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>0°</td>\n" +
				"    <td>1</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>30°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\sqrt{3}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>45°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\sqrt{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>60°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>90°</td>\n" +
				"    <td>0</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>120°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>135°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\sqrt{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>150°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\sqrt{3}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>180°</td>\n" +
				"    <td>-1</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>210°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\sqrt{3}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>225°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\sqrt{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>240°</td>\n" +
				"    <td>\\(-\\frac{1}{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>270°</td>\n" +
				"    <td>0</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>300°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>315°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\sqrt{2}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>330°</td>\n" +
				"    <td>\\(\\frac{1}{2}\\sqrt{3}\\)</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>360°</td>\n" +
				"    <td>1</td>\n" +
				"  </tr>\n" +
				"</table>" +

            "Setelah dihubungkan, akan dihasilkan grafik sebagai berikut:<br />" +
			"<img src=\"file:///android_res/mipmap/g31.png\" style=\"width:100%; margin:10px\" /><br />" +
			"<strong>Gambarkanlah grafik fungsi f(x) = tan x°</strong><p />" +
            "Pembahasan" +
            "Gunakan 0° ≤ x ≤ 360° dan y = tan x°\n" +

			"<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"1\">\n" +
				"  <tr>\n" +
				"    <td>x</td>\n" +
				"    <td>y</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>0°</td>\n" +
				"    <td>0</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>45°</td>\n" +
				"    <td>1</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>90°</td>\n" +
				"    <td>~</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>135°</td>\n" +
				"    <td>-1</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>180°</td>\n" +
				"    <td>0</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>225°</td>\n" +
				"    <td>1</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>270°</td>\n" +
				"    <td>~</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>315°</td>\n" +
				"    <td>-1</td>\n" +
				"  </tr>\n" +
				"  <tr>\n" +
				"    <td>360°</td>\n" +
				"    <td>0</td>\n" +
				"  </tr>\n" +
				"</table>" +
		
            "Setelah dihubungkan, akan dihasilkan grafik sebagai berikut:<br />" +
			"<img src=\"file:///android_res/mipmap/g32.png\" style=\"width:100%; margin:10px\" /><br />"+
            "</body>\n" +
            "</html>";
	Intent svc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab7);
        Toolbar toolbar7 = (Toolbar) findViewById(R.id.toolbar7);
		toolbar7.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar7);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		MediaPlayer instrumen = MediaPlayer.create(this, R.raw.instrumen);
		instrumen.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bab, menu);
        return true;
    }

	@Override
    protected void onResume() {
        super.onResume();
        texbab7 = (MathView) findViewById(R.id.tex_bab7);
        texbab7.setText(tex);
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item7){
        switch (item7.getItemId()){
            case R.id.kuis:
				buttonmusic();
                Intent intentkuisbab7 = new Intent(bab7.this, QuizBab6.class);
                startActivity(intentkuisbab7);
                return true;
			case android.R.id.home:
				buttonmusic();
				Intent i = new Intent(bab7.this, materi.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(i);
				return (true);
			case R.id.beranda:
				buttonmusic();
				Intent intentberanda = new Intent(bab7.this, beranda.class);
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
        return super.onOptionsItemSelected(item7);
    }

	@Override
	public void onBackPressed() {
		Intent back = new Intent(bab7.this, materi.class);
		back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(back);
	}

	private void buttonmusic() {
		MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
		mp.start();
	}

}
