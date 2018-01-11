package com.project.ndondot.konversisuhu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//created by Ananda Priatama
//165150200111043

public class MainActivity extends AppCompatActivity {

    Button reset, convert;
    TextView hasil;
    EditText input;
    Spinner suhuAwal, suhuAkhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input_suhu);
        hasil = (TextView) findViewById(R.id.output_suhu);
        suhuAwal = (Spinner) findViewById(R.id.input_spinner);
        suhuAkhir = (Spinner) findViewById(R.id.output_spinner);
        convert = (Button) findViewById(R.id.btnConvert);
        reset = (Button) findViewById(R.id.btnReset);
    }

    public void reset(View view){
        input.setText("");
        hasil.setText("");
        Toast.makeText(this, "Direset", Toast.LENGTH_SHORT).show();
    }

    public void run(View view) {
        if(TextUtils.isEmpty(input.getText())) {
            Toast.makeText(this, "Masukkan angka pada kolom input", Toast.LENGTH_SHORT).show();
            hasil.setText("");
        }
        else {
            double suhu = Double.parseDouble(input.getText().toString());
            int inIndex = suhuAwal.getSelectedItemPosition();
            int outIndex = suhuAkhir.getSelectedItemPosition();
            double hitung = 0;
            switch (inIndex) {
                case 0:
                    if (outIndex == 0)
                        hitung = suhu;
                    else if (outIndex == 1)
                        hitung = 1.25 * suhu;
                    else if (outIndex == 2)
                        hitung = (1.25 * suhu) + 273.15;
                    else if (outIndex == 3)
                        hitung = (2.25 * suhu) + 32;
                    break;
                case 1:
                    if (outIndex == 0)
                        hitung = 0.8 * suhu;
                    else if (outIndex == 1)
                        hitung = suhu;
                    else if (outIndex == 2)
                        hitung = suhu + 273.15;
                    else if (outIndex == 3)
                        hitung = (1.8 * suhu) + 32;
                    break;
                case 2:
                    if (outIndex == 0)
                        hitung = 0.8 * (suhu - 273.15);
                    else if (outIndex == 1)
                        hitung = (suhu - 273.15);
                    else if (outIndex == 2)
                        hitung = suhu;
                    else if (outIndex == 3)
                        hitung = (1.8 * (suhu - 273.15)) + 32;
                    break;
                case 3:
                    if (outIndex == 0)
                        hitung = 0.44 * (suhu - 32);
                    else if (outIndex == 1)
                        hitung = 0.56 * (suhu - 32);
                    else if (outIndex == 2)
                        hitung = (0.56 * (suhu - 32)) + 273.15;
                    else if (outIndex == 3)
                        hitung = suhu;
                    break;
                default:
                    hitung = 0;
                    break;
            }
            String sHitung = Double.toString(hitung);
            hasil.setText(sHitung);
        }
    }
}
