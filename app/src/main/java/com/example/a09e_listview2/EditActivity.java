package com.example.a09e_listview2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
    EditText editTitle, editDate, editPlace, editDetail;
    int iItem = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editTitle = findViewById(R.id.editTextName);
        editDate = findViewById(R.id.editTextDate);
        //editPlace = findViewById(R.id.editTextPlace);
        editDetail = findViewById(R.id.editTextDetail);

        Intent intentR = getIntent();
        iItem = intentR.getIntExtra("item", -1);
        if(iItem != -1) {
            editTitle.setText(intentR.getStringExtra("schedule"));
            editDate.setText(intentR.getStringExtra("date"));
            //editPlace.setText(intentR.getStringExtra("place"));
            editDetail.setText(intentR.getStringExtra("detail"));
        }

        Button btnSave = findViewById(R.id.buttonSave);
        Button btnCancel = findViewById(R.id.buttonCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName = editTitle.getText().toString().trim();
                String sDate = editDate.getText().toString().trim();
               // String sPlace = editPlace.getText().toString().trim();
                String sDetail = editDetail.getText().toString().trim();

                if(sName.isEmpty() || sDate.isEmpty() ) { //|| sPlace.isEmpty()
                    Toast.makeText(getApplicationContext(), "정확한 정보를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("item", iItem);
                intent.putExtra("schedule", sName);
                intent.putExtra("date", sDate);
                //intent.putExtra("place", sPlace);
                intent.putExtra("detail", sDetail);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}