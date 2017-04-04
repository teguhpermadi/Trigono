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
import io.github.kexanie.quiz.QuizBab5;

public class bab6 extends AppCompatActivity {
    MathView texbab6;
    //Perbandingan Trigonometri Sudut-sudut Istimewa
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
            "<p><strong>Perbandingan Trigonometri Sudut-sudut Istimewa</strong></p>" +
			"Jenis sudut yang merupakan sudut-sudut istimewa adalah sudut 0°,30°,45°,60° dan 90°. Mengapa sudut-sudut tersebut dikatakan sebagai sudut istimewa? marilah kita buktikan dengan contoh berikut:<br />" +
            "1. Menentukan perbandingan trigonometri sudut 0° dan 90°<br />" +
            "Perhatikan gambar berikut:<br />\n" +
			"<img src=\"file:///android_res/mipmap/g27.png\" style=\"width:50%; margin:10px\" /><br />" +
			"<strong>Ingat</strong><br />\n" +
            "sin α =\\(\\frac{y}{r}\\)<br />\n" +
            "cos α =\\(\\frac{x}{r}\\)<br />\n" +
            "tan α =\\(\\frac{y}{x}\\)<br />\n" +
            "cosec α=\\(\\frac{r}{y}\\)<br />\n" +
            "secan α=\\(\\frac{r}{x}\\)<br />\n" +
            "cotan α=\\(\\frac{x}{y}\\)<br />\n" + 
			
			"<p>untuk α = 0°, maka titik P diputar searah jarum jam sehingga OP berimpit dengan sumbu x+. dengan  demikian y = 0 dan x = r jadi:<br />\n" +
            "sin 0°=\\(\\frac{y}{r}\\)=\\(\\frac{0}{r}\\)=0°<br />\n" +
            "cos α=\\(\\frac{x}{r}\\)=\\(\\frac{r}{r}\\)=1<br />\n" +
            "tan α=\\(\\frac{y}{x}\\)=\\(\\frac{0}{x}\\)=0<br />\n" +
            "cosec α=\\(\\frac{r}{y}\\)=\\(\\frac{r}{0}\\)=~<br />\n" +
            "secan α=\\(\\frac{r}{x}\\)=\\(\\frac{r}{r}\\)=1<br />\n" +
            "cotan α=\\(\\frac{x}{y}\\)=\\(\\frac{x}{0}\\)=~<br /></p>\n" +

            "<p>untuk α = 90°, maka titik P diputar berlawanan arah jarum jam sehingga OP berimpit dengan sumbu y+. dengan  demikian x = 0 dan y = r jadi:<br />\n" +
            "sin 0°=\\(\\frac{y}{r}\\)=\\(\\frac{r}{r}\\)=1<br />\n" +
            "cos α=\\(\\frac{x}{r}\\)=\\(\\frac{0}{r}\\)=0<br />\n" +
            "tan α=\\(\\frac{y}{x}\\)=\\(\\frac{r}{0}\\)=~<br />\n" +
            "cosec α=\\(\\frac{r}{y}\\)=\\(\\frac{r}{r}\\)=1<br />\n" +
            "secan α=\\(\\frac{r}{x}\\)=\\(\\frac{r}{0}\\)=~<br />\n" +
            "cotan α=\\(\\frac{x}{y}\\)=\\(\\frac{0}{r}\\)=0<br /></p>\n" +

            //Menentukan perbandingan trigonometri sudut Untuk sudut 30°
            "<p>Menentukan perbandingan trigonometri sudut Untuk sudut 30°<br />" +
            "Perhatikan gambar dibawah ini<br /></p>" +
			"<img src=\"file:///android_res/mipmap/g28.png\" style=\"width:50%; margin:10px\" /><br />" +
			"Dari gambar kita bisa memperoleh nilai sinus 30°, cos 30° dan tan 30°.<br />\n" +
            "sin 30°=\\(\\frac{y}{r}\\)=\\(\\frac{1}{2}\\)<br />\n" +
            "cos 30°=\\(\\frac{x}{r}\\)=\\(\\sqrt{\\frac{3}{2}}=\\sqrt{3}\\)<br />\n" +
            "tan 30°=\\(\\frac{y}{x}\\)=\\(\\frac{1}{\\sqrt{3}}\\)=\\(\\frac{1}{3} \\sqrt{3}\\)<br />\n" +
            "secan 30°=\\(\\frac{r}{x}\\)=\\(\\frac{2}{\\sqrt{3}}\\)=\\(\\frac{2}{3} \\sqrt{3}\\)<br />\n" +
            "cosec 30°=\\(\\frac{r}{y}\\)=\\(\\frac{2}{1}\\)=2<br />\n" +
            "cotan 30°=\\(\\frac{x}{y}\\)=\\(\\frac{\\sqrt{3}}{1}=\\sqrt{3}\\)<br />\n" +

            //Menentukan perbandingan trigonometri sudut Untuk sudut 45°
            "Menentukan perbandingan trigonometri sudut Untuk sudut 45°<br />" +
            "Perhatikan gambar dibawah ini<br />" +
			"<img src=\"file:///android_res/mipmap/g29.png\" style=\"width:50%; margin:10px\" /><br />" +
			"Dari gambar kita bisa memperoleh nilai sinus 45°, cos 45° dan tan 45°.<br />" +
            "sin 45°=\\(\\frac{y}{r}\\)=\\(\\frac{1}{\\sqrt{2}}\\)=\\(\\frac{1}{2}\\sqrt{2}\\)<br />\n" +
            "cos 45°=\\(\\frac{x}{r}\\)=\\(\\frac{1}{\\sqrt{2}}\\)=\\(\\frac{1}{2}\\sqrt{2}\\)<br />\n" +
            "tan 45°=\\(\\frac{y}{x}\\)=\\(\\frac{1}{1}\\)=1<br />\n" +
            "secan 45°=\\(\\frac{r}{x}\\)=\\(\\frac{\\sqrt{2}}{1}=\\sqrt{2}\\)<br />\n" +
            "cosec 45°=\\(\\frac{r}{y}\\)=\\(\\frac{\\sqrt{2}}{1}=\\sqrt{2}\\)<br />\n" +
            "cotan 45°=\\(\\frac{x}{y}\\)=\\(\\frac{1}{1}\\)=1<br />\n" +

            //Menentukan perbandingan trigonometri sudut Untuk sudut 60°
            "Menentukan perbandingan trigonometri sudut Untuk sudut 60°<br />" +
			"<img src=\"file:///android_res/mipmap/g33.png\" style=\"width:50%; margin:10px\" /><br />" +
            "Dengan memakai rumus pythagoras kita bisa memperoleh tinggi segitiga, yaitu:<br />" +
            "$$\\sqrt{2^2-1^2}=\\sqrt{4-1}=\\sqrt{3}$$\n" +
            "Dari segitiga siku-siku sebelah kiri, kita bisa menentukan sin 60o, cos 60o, dan tan 60° yaitu :\n" +
            "sin 60°=\\(\\frac{y}{r}\\)=\\(\\frac{\\sqrt{3}}{2}=\\frac{1}{2} \\sqrt{3}\\)<br />\n" +
            "cos 60°=\\(\\frac{x}{r}\\)=\\(\\frac{1}{2}\\)<br />\n" +
            "tan 60°=\\(\\frac{y}{x}\\)=\\(\\frac{\\sqrt{3}}{1} =\\sqrt{3}\\)<br />\n" +
            "secan 60°=\\(\\frac{r}{x}\\)=\\(\\frac{2}{1}=2\\)<br />\n" +
            "cosec 60°=\\(\\frac{r}{y}\\)=\\(\\frac{2}{\\sqrt{3}}=\\frac{1}{2} \\sqrt{3}\\)<br />\n" +
            "cotan 60°=\\(\\frac{x}{y}\\)=\\(\\frac{1}{2}\\)<br />\n" +
            //Perbandingan trigonometri sudut istimewa 0°,30°,45°,60° dan 90°
            "Perbandingan trigonometri sudut istimewa 0°,30°,45°,60° dan 90°<p />" +
            "<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"1\">\n" +
            "  <tr>\n" +
            "    <td>Sudut</td>\n" +
            "    <td>0°</td>\n" +
            "    <td>30°</td>\n" +
            "    <td>45°</td>\n" +
            "    <td>60°</td>\n" +
            "    <td>90°</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>sin</td>\n" +
            "    <td>0</td>\n" +
            "    <td>\\(\\frac{1}{2}\\)</td>\n" +
            "    <td>\\(\\frac{1}{2} \\sqrt{2}\\)</td>\n" +
            "    <td>\\(\\frac{1}{2} \\sqrt{3}\\)</td>\n" +
            "    <td>1</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>cos</td>\n" +
            "    <td>1</td>\n" +
            "    <td>\\(\\frac{1}{2} \\sqrt{3}\\)</td>\n" +
            "    <td>\\(\\frac{1}{2} \\sqrt{2}\\)</td>\n" +
            "    <td>\\(\\frac{1}{2}\\)</td>\n" +
            "    <td>0</td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>tan</td>\n" +
            "    <td>0</td>\n" +
            "    <td>\\(\\frac{1}{3} \\sqrt{3}\\)</td>\n" +
            "    <td>1</td>\n" +
            "    <td>\\(\\sqrt{3}\\)</td>\n" +
            "    <td>-</td>\n" +
            "  </tr>\n" +
            "</table>" +
            //contoh
            "Contoh Soal:\n" +
            "Tentukan nilai dari:\n" +
            "<ol>" +
            "<li>sin 30 + cos 45°</li>\n" +
            "<li>sin 60°. cos 60°</li>\n" +
            "<li>sin 45°. tan 60° + cos 45° . cot 60°</li>\n" +
            "</ol>" +
            "Jawab:\n" +
            "<ol>" +
            "<li>sin 30° + cos 45°=\\(\\frac{1}{2}+\\frac{1}{2}\\sqrt{2}\\)=\\(\\frac{1+\\sqrt{2}}{2}\\)</li>\n" +
            "<li>sin 60° . cos 60°=\\(\\frac{1}{2}\\sqrt{3}\\cdotp\\sqrt{3}\\)=\\(\\frac{1}{2}\\sqrt{9}\\)</li>\n" +
            "<li>sin 45° . tan 60° + cos 45° . cot 60°=<br />" +
            "\\(\\frac{1}{2}\\sqrt{2}\\cdotp\\sqrt{3}+\\frac{1}{2}\\sqrt{2}\\cdotp\\frac{1}{3}\\sqrt{3}\\)<br />\n" +
            "\\(=\\frac{1}{2}\\sqrt{6}+\\frac{1}{6}\\sqrt{6}\\)<br />\n" +
            "\\(=\\frac{4}{6}\\sqrt{6}=\\frac{2}{3}\\sqrt{6}\\)<br /></li>\n" +
            "</ol>" +
            "</body>\n" +
            "</html>";
    Intent svc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab6);
        Toolbar toolbar6 = (Toolbar) findViewById(R.id.toolbar6);
        toolbar6.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar6);
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
        texbab6 = (MathView) findViewById(R.id.tex_bab6);
        texbab6.setText(tex);
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item6){
        switch (item6.getItemId()){
            case R.id.kuis:
                buttonmusic();
                Intent intentkuisbab5 = new Intent(bab6.this, QuizBab5.class);
                startActivity(intentkuisbab5);
                return true;
            case android.R.id.home:
                buttonmusic();
                Intent i = new Intent(bab6.this, materi.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);

            case R.id.beranda:
                buttonmusic();
                Intent intentberanda = new Intent(bab6.this, beranda.class);
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
        return super.onOptionsItemSelected(item6);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(bab6.this, materi.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }

}
