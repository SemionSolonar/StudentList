package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentlist.model.Model;
import com.example.studentlist.model.Student;

import java.util.Timer;
import java.util.TimerTask;

public class AddNewStudentActivity extends AppCompatActivity {

    TextView errorMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        registerListeners();
    }

    private void registerListeners() {
        Button saveBtn = findViewById(R.id.new_student_save_btn);
        Button cancelBtn = findViewById(R.id.new_student_cancel_btn);
        errorMsg=findViewById(R.id.new_student_error_msg);
        saveBtn.setOnClickListener(v->{
            EditText nameEt = findViewById(R.id.new_student_name);
            EditText idEt = findViewById(R.id.new_student_id);
            EditText phoneEt = findViewById(R.id.new_student_phone);
            EditText addressEt = findViewById(R.id.new_student_address);
            CheckBox checkBox = findViewById(R.id.new_student_cb);

            String id = idEt.getText().toString();
            String name = nameEt.getText().toString();
            String phone = phoneEt.getText().toString();
            String address = addressEt.getText().toString();

            Student newStudent = new Student(name,id);
            newStudent.setPhoneNumber(phone);
            newStudent.setAddress(address);
            newStudent.setChecked(checkBox.isChecked());

            Model.model.addStudent(newStudent);
            finish();
        });

        cancelBtn.setOnClickListener(v->{
            finish();
        });

        errorMsg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TimerTask timerTask =new TimerTask() {
                    @Override
                    public void run() {
                        errorMsg.setText("");
                    }
                };
                Timer timer = new Timer();
                timer.schedule(timerTask,(1000*6));
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

}