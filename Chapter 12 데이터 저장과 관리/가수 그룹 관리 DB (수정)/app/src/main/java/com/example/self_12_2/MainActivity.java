package com.example.self_12_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

import com.example.self_12_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myHelper = new myDBHelper(this);

        // 초기화 버튼
        binding.btnInit.setOnClickListener(v -> {
            sqlDB = myHelper.getWritableDatabase();
            myHelper.onUpgrade(sqlDB, 1, 2);
            sqlDB.close();
        });

        // 입력 버튼
        binding.btnInsert.setOnClickListener(v -> {
            sqlDB = myHelper.getWritableDatabase();
            sqlDB.execSQL("INSERT INTO groupTBL VALUES ('" + binding.edtName.getText().toString() + "', " + binding.edtNumber.getText().toString() + ");");
            sqlDB.close();
            binding.edtName.setText("");
            binding.edtNumber.setText("");
            Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
        });

        // 수정 버튼
        binding.btnUpdate.setOnClickListener(v -> {
            sqlDB = myHelper.getWritableDatabase();
            sqlDB.execSQL("UPDATE groupTBL SET gNumber = " + binding.edtNumber.getText().toString() + " WHERE gName = '" + binding.edtName.getText().toString() + "';");
            sqlDB.close();
            binding.edtName.setText("");
            binding.edtNumber.setText("");
            Toast.makeText(getApplicationContext(), "수정됨", Toast.LENGTH_SHORT).show();
        });

        // 삭제 버튼
        binding.btnDelete.setOnClickListener(v -> {
            sqlDB = myHelper.getWritableDatabase();
            sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '" + binding.edtName.getText().toString() + "';");
            sqlDB.close();
            binding.edtName.setText("");
            binding.edtNumber.setText("");
            Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();
        });

        // 조회 버튼
        binding.btnSelect.setOnClickListener(v -> {
            sqlDB = myHelper.getReadableDatabase();
            String str = "";
            Cursor cursor;
            cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

            StringBuilder strNames = new StringBuilder("그룹이름" + "\r\n" + "--------" + "\r\n");
            StringBuilder strNumbers = new StringBuilder("인원" + "\r\n" + "--------" + "\r\n");


            while (cursor.moveToNext()) {
                strNames.append(cursor.getString(0)).append("\r\n");
                strNumbers.append(cursor.getInt(1)).append("\r\n");
            }

            binding.edtNameResult.setText(strNames.toString());
            binding.edtNumberResult.setText(strNumbers.toString());

            cursor.close();
            sqlDB.close();
        });


    }


    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE  groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }
}