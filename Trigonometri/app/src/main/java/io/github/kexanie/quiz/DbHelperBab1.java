package io.github.kexanie.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelperBab1 extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 30;
	// Database Name
	private static final String DATABASE_NAME = "QuizBab1";
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
	public DbHelperBab1(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase dbbab1) {
		dbase = dbbab1;
		String sqlbab1 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT)";
		dbbab1.execSQL(sqlbab1);
		addQuestionBab1();
       // dbbab1.close();
	}

    private void addQuestionBab1() {
        Question q1 = new Question("1. 1/4 putaran = ...°","a. 45" , "b. 90" , "c. 135" , "d. 180", "b. 90");
        this.addQuestionBab1(q1);
        Question q2 = new Question("2. 1/2 putaran = ... radian","a. 1,57" , "b. 3,14" , "c. 6,28" , "d. 9,42", "b. 3,14");
        this.addQuestionBab1(q2);
        Question q3 = new Question("3. 2 putaran = ...°","a. 180" , "b. 360" , "c. 540" , "d. 720", "d. 720");
        this.addQuestionBab1(q3);
        Question q4 = new Question("4. 3 1/2 putaran = ... radian","a. 10,99" , "b. 17,27" , "c. 21,98" , "d. 25,12", "c. 21,98");
        this.addQuestionBab1(q4);
        Question q5 = new Question("5. 180° = ... putaran","a. 1/4" , "b. 1/2" , "c. 3/4" , "d. 1", "b. 1/2");
        this.addQuestionBab1(q5);
        Question q6 = new Question("6. 540° = ... putaran","a. 1 1/4" , "b. 1 1/3" , "c. 1 1/2" , "d. 1 3/4", "c. 1 1/2");
        this.addQuestionBab1(q6);
        Question q7 = new Question("7. 630° = ... radian","a. 10,47" , "b. 10,90" , "c. 10,99" , "d. 11,05", "c. 10,99");
        this.addQuestionBab1(q7);
        Question q8 = new Question("8. 60 radian = ... putaran","a. 9,46" , "b. 9,55" , "c. 9,65" , "d. 9,78", "b. 9,55");
        this.addQuestionBab1(q8);
        Question q9 = new Question("9. 20 radian = ... putaran","a. 3,14" , "b. 3,18" , "c. 6,28" , "d. 6,36", "b. 3,18");
        this.addQuestionBab1(q9);
        Question q10 = new Question("10. 100 radian = ...°","a. 5703,00" , "b. 5703,49" , "c. 5730,00" , "d. 5732,49", "d. 5732,49");
        this.addQuestionBab1(q10);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}
	// Adding new question

    public void addQuestionBab1(Question quest) {
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

    public List<Question> getAllQuestionsBab1() {
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
