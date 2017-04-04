package io.github.kexanie.quiz;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import io.github.kexanie.mathviewtest.R;
import io.github.kexanie.mathviewtest.beranda;
import io.github.kexanie.mathviewtest.materi;
import io.github.kexanie.musik.BackgroundSoundService;

public class QuizActivity extends AppCompatActivity {

	List<Question> quesList;
    ArrayList<String> Arrsoal,Arrjawab,kunci;
    ArrayList<Integer> gambar;
	int score=0;
	int qid=0;
	Question currentQ;
    TextView soal;
    ImageView gambar1, gambar2, gambar3, gambar4;
	RadioButton rda, rdb, rdc, rdd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kuis);

		Toolbar toolbarkuis = (Toolbar) findViewById(R.id.toolbarkuis);
       // toolbarkuis.setBackgroundColor(getResources().getColor(R.color.indigo_500));
		setSupportActionBar(toolbarkuis);
        toolbarkuis.setLogo(R.drawable.ic_evaluasi_putih);
        toolbarkuis.setNavigationIcon(R.drawable.ic_back);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		DbHelper db = new DbHelper(this);
		quesList = db.getAllQuestions();
		currentQ = quesList.get(qid);
        gambar1 = (ImageView) findViewById(R.id.gambar1);
        gambar2 = (ImageView) findViewById(R.id.gambar2);
        gambar3 = (ImageView) findViewById(R.id.gambar3);
        gambar4 = (ImageView) findViewById(R.id.gambar4);
        soal = (TextView) findViewById(R.id.soal);
		rda=(RadioButton)findViewById(R.id.radio0);
		rdb=(RadioButton)findViewById(R.id.radio1);
		rdc=(RadioButton)findViewById(R.id.radio2);
		rdd=(RadioButton)findViewById(R.id.radio3);

        Arrsoal = new ArrayList<String>();
        Arrjawab = new ArrayList<String>();
        gambar = new ArrayList<Integer>();
        kunci = new ArrayList<String>();
    }

    public void resizeImageView(int width, int height) {
        final ImageView picture1 = (ImageView)findViewById(R.id.gambar1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
        picture1.setLayoutParams(layoutParams);

        final ImageView picture2 = (ImageView)findViewById(R.id.gambar2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(width, height);
        picture2.setLayoutParams(layoutParams2);

        final ImageView picture3 = (ImageView)findViewById(R.id.gambar3);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(width, height);
        picture3.setLayoutParams(layoutParams3);

        final ImageView picture4 = (ImageView)findViewById(R.id.gambar4);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(width, height);
        picture4.setLayoutParams(layoutParams4);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_kuis, menu);
		return true;
	}
	private void setQuestionView()
	{
        soal.setText(currentQ.getQUESTION());
		rda.setText(currentQ.getOPTA());
		rdb.setText(currentQ.getOPTB());
		rdc.setText(currentQ.getOPTC());
		rdd.setText(currentQ.getOPTD());
		qid++;
        if (qid == 9){
            gambar1.setImageResource(R.mipmap.soal9a);
            gambar1.setVisibility(View.VISIBLE);

            gambar2.setImageResource(R.mipmap.soal9b);
            gambar2.setVisibility(View.VISIBLE);
            gambar3.setImageResource(R.mipmap.soal9c);
            gambar3.setVisibility(View.VISIBLE);
            gambar4.setImageResource(R.mipmap.soal9d);
            gambar4.setVisibility(View.VISIBLE);
        } else if (qid == 10){
            gambar1.setImageResource(R.mipmap.soal10a);
            gambar1.setVisibility(View.VISIBLE);
            gambar2.setImageResource(R.mipmap.soal10b);
            gambar2.setVisibility(View.VISIBLE);
            gambar3.setImageResource(R.mipmap.soal10c);
            gambar3.setVisibility(View.VISIBLE);
            gambar4.setImageResource(R.mipmap.soal10d);
            gambar4.setVisibility(View.VISIBLE);
        } else if(qid == 11){
            gambar1.setImageResource(R.mipmap.soal11_12);
            gambar1.setVisibility(View.VISIBLE);
            gambar2.setVisibility(View.GONE);
            gambar3.setVisibility(View.GONE);
            gambar4.setVisibility(View.GONE);
        } else if(qid == 12){
            gambar1.setImageResource(R.mipmap.soal11_12);
            gambar1.setVisibility(View.VISIBLE);
            gambar2.setVisibility(View.GONE);
            gambar3.setVisibility(View.GONE);
            gambar4.setVisibility(View.GONE);
        } else if(qid == 26){
            gambar1.setImageResource(R.mipmap.soal26);
            gambar1.setVisibility(View.VISIBLE);
            gambar2.setVisibility(View.GONE);
            gambar3.setVisibility(View.GONE);
            gambar4.setVisibility(View.GONE);
        } else if (qid == 27){
            gambar1.setImageResource(R.mipmap.soal27a);
            gambar1.setVisibility(View.VISIBLE);
            gambar2.setImageResource(R.mipmap.soal27b);
            gambar2.setVisibility(View.VISIBLE);
            gambar3.setImageResource(R.mipmap.soal27c);
            gambar3.setVisibility(View.VISIBLE);
            gambar4.setImageResource(R.mipmap.soal27d);
            gambar4.setVisibility(View.VISIBLE);
        } else if (qid == 28){
            gambar1.setImageResource(R.mipmap.soal28a);
            gambar1.setVisibility(View.VISIBLE);
            gambar2.setImageResource(R.mipmap.soal28b);
            gambar2.setVisibility(View.VISIBLE);
            gambar3.setImageResource(R.mipmap.soal28c);
            gambar3.setVisibility(View.VISIBLE);
            gambar4.setImageResource(R.mipmap.soal28d);
            gambar4.setVisibility(View.VISIBLE);
        } else if(qid == 29){
            gambar1.setImageResource(R.mipmap.soal29);
            gambar1.setVisibility(View.VISIBLE);
            gambar2.setVisibility(View.GONE);
            gambar3.setVisibility(View.GONE);
            gambar4.setVisibility(View.GONE);
        } else if (qid == 30){
            gambar1.setImageResource(R.mipmap.soal30a);
            gambar1.setVisibility(View.VISIBLE);
            gambar2.setImageResource(R.mipmap.soal30b);
            gambar2.setVisibility(View.VISIBLE);
            gambar3.setImageResource(R.mipmap.soal30c);
            gambar3.setVisibility(View.VISIBLE);
            gambar4.setImageResource(R.mipmap.soal30d);
            gambar4.setVisibility(View.VISIBLE);
        }else{
            gambar1.setVisibility(View.GONE);
            gambar2.setVisibility(View.GONE);
            gambar3.setVisibility(View.GONE);
            gambar4.setVisibility(View.GONE);
        }
	}

    @Override
    protected void onResume(){
        setQuestionView();
        super.onResume();
    }

    private void buttonmusic() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        mp.start();
    }
    Intent svc;
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        final RadioGroup grp_ = (RadioGroup)findViewById(R.id.radioGroup1);
        switch (item.getItemId()){
            case R.id.action_next:
                buttonmusic();
                if(grp_.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(),"Anda belum memilih",Toast.LENGTH_SHORT).show();
                }else{
                    RadioGroup grp = (RadioGroup)findViewById(R.id.radioGroup1);
                    RadioButton answer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
                    Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());

                    if (currentQ.getANSWER().equals(answer.getText())){
                        Arrjawab.add("Jawaban anda: " + answer.getText().toString());
                        Arrsoal.add(soal.getText().toString());
                        gambar.add(R.drawable.ic_benar);
                        kunci.add("Kunci jawaban: " + currentQ.getANSWER().toString());
                       // Arrjawab.add("Soal nomor: "+ String.valueOf(qid) + " Benar");
                    } else {
                        Arrjawab.add("Jawaban anda: " + answer.getText().toString());
                        Arrsoal.add(soal.getText().toString());
                        gambar.add(R.drawable.ic_salah);
                        kunci.add("Kunci jawaban: " + currentQ.getANSWER().toString());
                       // Arrjawab.add("Soal nomor: "+ String.valueOf(qid) + " Salah");
                    };

                    if(currentQ.getANSWER().equals(answer.getText())){
                        score++;
                        Log.d("score", "Your score"+score);
                    } if(qid < 30){
                        currentQ=quesList.get(qid);
                        setQuestionView();
                        grp.clearCheck();
                    } else{
                        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        b.putStringArrayList("soal",Arrsoal);
                        b.putStringArrayList("jawab",Arrjawab);
                        b.putIntegerArrayList("gambar",gambar);
                        b.putStringArrayList("kunci",kunci);

                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        finish();
                    }
                }
                return true;
            case android.R.id.home:
                Intent i = new Intent(QuizActivity.this, beranda.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                this.finish();
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(QuizActivity.this, beranda.class);
        back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(back);
    }
}
