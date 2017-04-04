package io.github.kexanie.quiz;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 30;
	// Database Name
	private static final String DATABASE_NAME = "Quiz";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c
	private static final String KEY_OPTD= "optd"; //option d

    private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase = db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT)";
		db.execSQL(sql);
		addQuestions();
		//db.close();
	}

    private void addQuestions()
	{
        Question q1=new Question("1. Berapa radian sudut terkecil yang dibentuk jarum jam pada pukul 16.00?","a. 0,69", "b. 2,09", "c. 2,90", "d. 4,18","b. 2,09");
        this.addQuestion(q1);
        Question q2=new Question("2. Berapa radian sudut terbesar yang dibentuk jarum jam pada pukul 07.00?", "a. 0,87", "b. 1,22", "c. 2,61", "d. 3,66","d. 3,66");
        this.addQuestion(q2);
        Question q3=new Question("3. Jika suatu pemancar berputar 50 kali dalam 1 detik, maka tentukan banyak putaran dalam 1 menit?","a. 50", "b. 300","c. 500", "d. 3000", "d. 3000" );
        this.addQuestion(q3);
        Question q4=new Question("4. 40 radian = ... °", "a. 292,00", "b. 2292,99", "c. 2229,00","d. 2229,99","b. 2292,99");
        this.addQuestion(q4);
        Question q5=new Question("5. 90° = ... radian","a. 0,52","b. 1,05","c. 1,57","d. 2,09","c. 1,57");
        this.addQuestion(q5);
		Question q6=new Question("6. 550° berada dalam kuadran ...","a. I","b. II","c. III","d. IV","c. III");
        this.addQuestion(q6);
        Question q7=new Question("7. -280° berada dalam kuadran ...","a. I","b. II","c. III","d. IV","a. I");
        this.addQuestion(q7);
        Question q8=new Question("8. 750° berada dalam kuadran ... ","a. I","b. II","c. III","d. IV","a. I");
        this.addQuestion(q8);
        Question q9=new Question("9. Gambar yang benar dari sudut -30° adalah ...","a. Gambar 1","b. Gambar 2","c. Gambar 3","d. Gambar 4","a. Gambar 1");
        this.addQuestion(q9);
        Question q10=new Question("10. Gambar yang benar dari sudut 500° adalah ...","a. Gambar 1","b. Gambar 2","c. Gambar 3","d. Gambar 4","c. Gambar 3");
        this.addQuestion(q10);
        Question q11=new Question("11. Nilai sin A adalah ...","a. 3/5","b. 4/5","c. 5/3","d. 5/4","b. 4/5");
        this.addQuestion(q11);
        Question q12=new Question("12. Nilai sin B adalah ...","a. 3/5","b. 4/5","c. 5/3","d. 5/4","a. 3/5");
        this.addQuestion(q12);
        Question q13=new Question("13. Seorang siswa dengan tinggi badan 150cm berdiri di dekat tiang bendera. Jika bayangan siswa dan bendera tersebut berturut-turut 50cm dan 450cm, maka tinggi tiang bendera adalah ... cm","a. 150","b. 450","c. 900","d. 1350","d. 1350");
        this.addQuestion(q13);
        Question q14=new Question("14. Sebuah laser yang berada di tanah menyinari bagian atas gedung dengan sudut antara laser dan tanah 60°. Jika jarak antara gedung dan laser adalah 10 meter, maka tinggi gedung tersebut adalah ... meter","a. 20","b. 10√3","c. 20√3","d. 10","b. 10√3");
        this.addQuestion(q14);
        Question q15=new Question("15. Pada segitiga ABC dengan siku-siku di C, cos A = 12/13. Nilai sin B adalah ...","a. 12/13","b. 5/13","c. 13/5","d. 12/5","a. 12/13");
        this.addQuestion(q15);
        Question q16=new Question("16. Titik B(-6,8), nilai sin B adalah ...","a. -(8/10)","b. -(6/10)","c. 8/10","d. 6/10","c. 8/10");
        this.addQuestion(q16);
        Question q17=new Question("17. Titik E(0,5), nilai cot E adalah ...","a. Tidak ada","b. 0","c. 5","d. ~","b. 0");
        this.addQuestion(q17);
        Question q18=new Question("18. Titik P berada di kuadran IV dan sin P = -4/5, nilai cos P adalah ...","a. 3/4","b. 4/3","c. 3/5","d. 5/3","c. 3/5");
        this.addQuestion(q18);
        Question q19=new Question("19. Titik S berada di kuadran II dan sec S = -5/3, nilai cot S adalah ...","a. -(4/3)","b. -(3/5)","c. -(4/5)","d. -(3/4)","d. -(3/4)");
        this.addQuestion(q19);
        Question q20=new Question("20. Titik A (5,12), nilai tan A adalah ...","a. -12/5","b. -5/12","c. 5/12","d. 12/5","c. 5/12");
        this.addQuestion(q20);
        Question q21=new Question("21. Jika cos C = 11/12, maka nilai dari cot C adalah ...","a. 12/√23","b. √23/11","c. 11/√23","d. √23/11","b. √23/11");
        this.addQuestion(q21);
        Question q22=new Question("22. Jika csc E = 17/13, maka nilai dari sec E adalah ...","a. 17/√102","b. 15/√120","c. 13/√120","d. 17/√120","d. 17/√120");
        this.addQuestion(q22);
        Question q23=new Question("23. Jika cot D = 0, maka nilai dari D adalah ...°","a. 90","b. 60","c. 30","d. 0","a. 90");
        this.addQuestion(q23);
        Question q24=new Question("24. Jika sec F = 1, maka nilai dari F adalah ...°","a. 0","b. 30","c. 60","d. 90","d. 90");
        this.addQuestion(q24);
        Question q25=new Question("25. Nilai dari tan 570° adalah ...","a. 1/3","b. 1/2","c. 1/√3","d. 0","c. 1/√3");
        this.addQuestion(q25);
        Question q26=new Question("26. Grafik fungsi dari gambar di bawah ini adalah ...","a. y = sin x + cos x","b. y = sin^2 x - cos^2 x","c. y = sin^2 x","d. y = cos^2 x","b. y = sin^2 x - cos^2 x");
        this.addQuestion(q26);
        Question q27=new Question("27. Gambar dari grafik fungsi y = csc x adalah ...","a. Gambar 1","b. Gambar 2","c. Gambar 3","d. Gambar 4","b. Gambar 2");
        this.addQuestion(q27);
        Question q28=new Question("28. Gambar dari grafik fungsi y = √(sin x)adalah ...","a. Gambar 1","b. Gambar 2","c. Gambar 3","d. Gambar 4","c. Gambar 3");
        this.addQuestion(q28);
        Question q29=new Question("29. Grafik fungsi dari gambar di bawah ini adalah ...","a. y = (sin x)/x","b. y = (cos x)/x","c. y = x cos x","d. y = x sin x","c. y = x cos x");
        this.addQuestion(q29);
        Question q30=new Question("30. Gambar dari grafik fungsi y = x tan x adalah ...","a. Gambar 1","b. Gambar 2","c. Gambar 3","d. Gambar 4","b. Gambar 2");
        this.addQuestion(q30);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		values.put(KEY_OPTD, quest.getOPTD());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);
	}

	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quest.setOPTD(cursor.getString(6));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}

	public int rowcount(){
		int row;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}

}
