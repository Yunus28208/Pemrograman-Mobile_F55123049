package com.example.f55123049;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtwidth, edtheight, edtlength;
    private Button btncalculate;
    private TextView tvresult;
    private  static final String STATE_RESULT = "state_result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Pastikan setiap ID sesuai dengan yang ada di file XML
        edtwidth = findViewById(R.id.edt_width);
        edtheight = findViewById(R.id.edt_height);
        edtlength = findViewById(R.id.edt_length);
        btncalculate = findViewById(R.id.btn_calculate);
        tvresult = findViewById(R.id.tv_result);

        btncalculate.setOnClickListener(this);
        if (savedInstanceState !=null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvresult.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT,tvresult.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputLength = edtlength.getText().toString().trim();
            String inputWidth = edtwidth.getText().toString().trim();
            String inputHeight = edtheight.getText().toString().trim();
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edtlength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edtwidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtheight.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields) {
                double volume = Double.parseDouble(inputLength) *
                        Double.parseDouble(inputWidth) *
                        Double.parseDouble(inputHeight);
                tvresult.setText(String.valueOf(volume));
            }
        }
    }
}