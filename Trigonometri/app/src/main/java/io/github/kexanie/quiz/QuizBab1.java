package io.github.kexanie.quiz;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import io.github.kexanie.mathviewtest.R;
import io.github.kexanie.mathviewtest.bab1;
import io.github.kexanie.mathviewtest.beranda;
import io.github.kexanie.musik.BackgroundSoundService;


public class QuizBab1 extends AppCompatActivity {

    List<Question> quesListBab1;
    ArrayList<String> soal,jawab,kunci;
    ArrayList<Integer> gambar;
    int score=0;
    int qid=0;
    Question currentQbab1;
    TextView soalbab1;

    RadioButton rda, rdb, rdc, rdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_bab1);

        Toolbar toolbarkuisbab1 = (Toolbar) findViewById(R.id.toolbarkuisbab1);
       // toolbarkuisbab1.setBackgroundColor(getResources().getColor(R.color.indigo_500));
        setSupportActionBar(toolbarkuisbab1);
        toolbarkuisbab1.setLogo(R.drawable.ic_evaluasi_putih);
        toolbarkuisbab1.setNavigationIcon(R.drawable.ic_back);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        DbHelperBab1 dbbab1 = new DbHelperBab1(this);
        quesListBab1 = dbbab1.getAllQuestionsBab1();
        currentQbab1 = quesListBab1.get(qid);

        soalbab1 = (TextView) findViewById(R.id.soalbab1);

        rda=(RadioButton)findViewById(R.id.radio0bab1);
        rdb=(RadioButton)findViewById(R.id.radio1bab1);
        rdc=(RadioButton)findViewById(R.id.radio2bab1);
        rdd=(RadioButton)findViewById(R.id.radio3bab1);

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
        soalbab1.setText(currentQbab1.getQUESTION());
        rda.setText(currentQbab1.getOPTA());
        rdb.setText(currentQbab1.getOPTB());
        rdc.setText(currentQbab1.getOPTC());
        rdd.setText(currentQbab1.getOPTD());
        qid++;
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
    public boolean onOptionsItemSelected(MenuItem item){
        final RadioGroup grp1 = (RadioGroup)findViewById(R.id.radioGroup1bab1);
        switch (item.getItemId()){
            case R.id.action_next:
                buttonmusic();
                if(grp1.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(),"Anda belum memilih",Toast.LENGTH_SHORT).show();
                }else{
                    RadioGroup grp = (RadioGroup)findViewById(R.id.radioGroup1bab1);
                    RadioButton answer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
                    Log.d("yourans", currentQbab1.getANSWER()+" "+answer.getText());

                    if (currentQbab1.getANSWER().equals(answer.getText())){
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab1.getText().toString());
                        gambar.add(R.drawable.ic_benar);
                        kunci.add("Kunci jawaban: " + currentQbab1.getANSWER().toString());
                       // jawab.add("Soal nomor: "+ String.valueOf(qid) + " Benar");
                    } else {
                        jawab.add("Jawaban anda: " + answer.getText().toString());
                        soal.add(soalbab1.getText().toString());
                        gambar.add(R.drawable.ic_salah);
                        kunci.add("Kunci jawaban: " + currentQbab1.getANSWER().toString());
                       // jawab.add("Soal nomor: "+ String.valueOf(qid) + " Benar");
                    };

                    if(currentQbab1.getANSWER().equals(answer.getText())){
                        score++;
                        Log.d("score", "Your score"+score);

                    } if(qid < 10){
                        currentQbab1 = quesListBab1.get(qid);
                        setQuestionView();
                        grp.clearCheck();

                    } else{
                        Intent intent = new Intent(QuizBab1.this, ResultActivityBab.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        b.putStringArrayList("soal",soal);
                        b.putStringArrayList("jawab",jawab);
                        b.putIntegerArrayList("gambar",gambar);
                        b.putStringArrayList("kunci",kunci);

                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        finish();
                    };

                }
                return true;
            case android.R.id.home:
                Intent i = new Intent(QuizBab1.this, bab1.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(QuizBab1.this, bab1.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }
}