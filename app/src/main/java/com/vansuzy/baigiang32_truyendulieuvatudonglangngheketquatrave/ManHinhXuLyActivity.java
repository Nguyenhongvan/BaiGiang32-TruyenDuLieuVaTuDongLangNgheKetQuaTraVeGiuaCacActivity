package com.vansuzy.baigiang32_truyendulieuvatudonglangngheketquatrave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManHinhXuLyActivity extends AppCompatActivity {
    TextView txtNhan;
    Button btnTinhUSCLN;
    Intent intent;
    int a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_xu_ly);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTinhUSCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyTimUSCLN();
            }
        });
    }

    private void xuLyTimUSCLN() {
        int min = Math.min(a,b);
        int uscln = 1;
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                uscln = i;
                break;
            }
        }

        // Bước 3: Thay đổi thông tin và gán vào cho intent (nên sử dụng lại intent (không cần tạo mới))
        intent.putExtra("USCLN", uscln);

        // Bước 4: Đánh dấu kết quả trả về
        setResult(4, intent);

        // Bước 5: phải đóng màn hình này lại để màn hình MainActivity trở thành Foreground lifetime (vì nó chỉ tự động nhận được kết quả trả về ở trong Foreground lifetime)
        finish();
    }

    private void addControls() {
        txtNhan = (TextView) findViewById(R.id.txtNhan);
        btnTinhUSCLN = (Button) findViewById(R.id.btnTinhUSCLN);

        // Bước 2: lấy dữ liệu ra
        intent = getIntent();
        a = intent.getIntExtra("a", -1);
        b = intent.getIntExtra("b", -1);

        txtNhan.setText("a = " + a + "; b = " + b);
    }
}
