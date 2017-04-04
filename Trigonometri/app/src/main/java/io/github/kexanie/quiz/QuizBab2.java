package io.github.kexanie.quiz;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.kexanie.mathviewtest.R;
import io.github.kexanie.mathviewtest.bab1;
import io.github.kexanie.mathviewtest.bab2;
import io.github.kexanie.mathviewtest.beranda;
import io.github.kexanie.musik.BackgroundSoundService;

public class QuizBab2 extends AppCompatActivity {

    List<Question> quesListBab2;
    ArrayList<String> soal,jawab, kunci;
    ArrayList<Integer> gambar;
    int score=0;
    int qid=0;
    Question currentQbab2;
    ImageView img1, img2, img3, img4;
    TextView soalbab2;

    RadioButton rda, rdb, rdc, rdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_bab2);

        Toolbar toolbarkuisbab2 = (Toolbar) findViewById(R.id.toolbarkuisbab2);
       // toolbarkuisbab2.setBackgroundColor(getResources().getColor(R.color.indigo_500));
        setSupportActionBar(toolbarkuisbab2);
        toolbarkuisbab2.setLogo(R.drawable.ic_evaluasi_putih);
        toolbarkuisbab2.setNavigationIcon(R.drawable.ic_back);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        DbHelperBab2 dbbab2 = new DbHelperBab2(this);

        quesListBab2 = dbbab2.getAllQuestionsBab2();
        currentQbab2 = quesListBab2.get(qid);

        soalbab2 = (TextView) findViewById(R.id.soalbab2);

        rda=(RadioButton)findViewById(R.id.radio0bab2);
        rdb=(RadioButton)findViewById(R.id.radio1bab2);
        rdc=(RadioButton)findViewById(R.id.radio2bab2);
        rdd=(RadioButton)findViewById(R.id.radio3bab2);

        img1 = (ImageView)findViewById(R.id.img1bab2);
        img2 = (ImageView)findViewById(R.id.img2bab2);
        img3 = (ImageView)findViewById(R.id.img3bab2);
        img4 = (ImageView)findViewById(R.id.img4bab2);

        soal = new ArrayList<String>();
        jawab = new ArrayList<String>();
        gambar = new ArrayList<Integer>();
        kunci = new ArrayList<String>();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kuis, menu);
        return true;
    }
    private void setQuestionView()
    {
        soalbab2.setText(currentQbab2.getQUESTION());
        rda.setText(currentQbab2.getOPTA());
        rdb.setText(currentQbab2.getOPTB());
        rdc.setText(currentQbab2.getOPTC());
        rdd.setText(currentQbab2.getOPTD());
        qid++;

        if(qid == 10){
            img1.setImageResource(R.mipmap.soal10a);
            img2.setImageResource(R.mipmap.soal10b);
            img3.setImageResource(R.mipmap.soal10c);
            img4.setImageResource(R.mipmap.soal10d);
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.VISIBLE);
            img4.setVisibility(View.VISIBLE);
        } else {
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.GONE);
            img4.setVisibility(View.GONE);
        }
    }



    @Override
    protected void onResume(){
        setQuestionView();
        super.onResume();
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.instrumen);
        mp.start();
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }
    Intent svc;
    public boolean onOptionsItemSelected(MenuItem item2){
        final RadioGroup grp2 = (RadioGroup)findViewById(R.id.radioGroup1bab2);
        switch (item2.getItemId()){
            case R.id.action_next:
                buttonmusic();
                if(grp2.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(),"Anda belum memilih",Toast.LENGTH_SHORT).show();
                }else{
                    RadioGroup grp_2 = (RadioGroup)findViewById(R.id.radioGroup1bab2);
                    RadioButton answer = (RadioButton)findViewById(grp_2.getCheckedRadioButtonId());
                    Log.d("yourans", currentQbab2.getANSWER()+" "+answer.getText());

                    if (currentQbab2.getANSWER().equals(answer.getText())){
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab2.getText().toString());
                        gambar.add(R.drawable.ic_benar);
                        kunci.add("Kunci jawaban: " + currentQbab2.getANSWER().toString());
                    } else {
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab2.getText().toString());
                        gambar.add(R.drawable.ic_salah);
                        kunci.add("Kunci jawaban: " + currentQbab2.getANSWER().toString());
                    };

                    if(currentQbab2.getANSWER().equals(answer.getText())){
                        score++;
                        Log.d("score", "Your score"+score);

                    } if(qid < 10){
                        currentQbab2 = quesListBab2.get(qid);
                        setQuestionView();
                        grp_2.clearCheck();

                    } else{
                        Intent intent = new Intent(QuizBab2.this, ResultActivityBab.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        b.putStringArrayList("soal",soal);
                        b.putStringArrayList("jawab",jawab);
                        b.putIntegerArrayList("gambar",gambar);
                        b.putStringArrayList("kunci",kunci);
                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        finish();
                    }
                }
                return true;
            case android.R.id.home:
                Intent i = new Intent(QuizBab2.this, bab2.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
        }
        return super.onOptionsItemSelected(item2);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(QuizBab2.this, bab2.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }
}
