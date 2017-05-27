package com.vansuzy.baigiang32_truyendulieuvatudonglangngheketquatrave;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtA, txtB;
    Button btnXuLy;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLayUSCLN();
            }
        });
    }

    private void xuLyLayUSCLN() {
        Intent intent = new Intent(MainActivity.this, ManHinhXuLyActivity.class);

        intent.putExtra("a", Integer.parseInt(txtA.getText().toString()));
        intent.putExtra("b", Integer.parseInt(txtB.getText().toString()));

        // Bước 1: Bạn phải gọi startActivityForResult
        startActivityForResult(intent, 20);
    }

    // Bước 6: Nhận kết quả trong onActivityResult (chỉ nhận trong vòng đời Foreground lifetime)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 20 && resultCode == 4) {
            int uscln = data.getIntExtra("USCLN", 1);
            txtKetQua.setText("USCLN = " + uscln);
        }
    }

    private void addControls() {
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        btnXuLy = (Button) findViewById(R.id.btnXuLy);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);
    }
}
