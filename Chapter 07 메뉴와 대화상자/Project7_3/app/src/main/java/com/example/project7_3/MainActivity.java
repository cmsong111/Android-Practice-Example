package com.example.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvName, tvEmail;
    Button button1;
    EditText dlgEditName, dlgEditEmail;
    TextView toastText;
    View dialowView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.text_name);
        tvEmail = findViewById(R.id.text_email);
        button1 = findViewById(R.id.btn_dialog);

        button1.setOnClickListener(view -> {
            dialowView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("사용자 정보 입력");
            dlg.setIcon(R.drawable.ic_menu_allfriends);
            dlg.setView(dialowView);
            dlg.setPositiveButton("확인", (dialogInterface, i) -> {
                dlgEditName = dialowView.findViewById(R.id.edit_name);
                dlgEditEmail = dialowView.findViewById(R.id.edit_email);
                tvName.setText(dlgEditName.getText().toString());
                tvEmail.setText(dlgEditEmail.getText().toString());
            });
            dlg.setNegativeButton( "취소", (dialogInterface, i) -> {
                toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                toastText = toastView.findViewById(R.id.toastText1);
                toastText.setText("취소했습니다.");
                Toast toast = new Toast(MainActivity.this);
                toast.setView(toastView);
                toast.show();
            });
            dlg.show();
        });
    }
}