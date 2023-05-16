package sg.edu.rp.c346.id22038532.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText InputName;
    EditText InputMobileNo;
    EditText InputSizeGroup;
    DatePicker datePicker;
    TimePicker timePicker;
    Button SubmitBtn;
    Button ResetBtn;
    CheckBox SmokingCB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputName = findViewById(R.id.InputName);
        InputMobileNo = findViewById(R.id.InputMobileNo);
        InputSizeGroup = findViewById(R.id.InputSizeGroup);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        SmokingCB = findViewById(R.id.SmokingCB);
        SubmitBtn = findViewById(R.id.SubmitBtn);
        ResetBtn = findViewById(R.id.ResetBtn);

        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth()+1;
                int year = datePicker.getYear();
                int hour = timePicker.getCurrentHour();
                int minutes = timePicker.getCurrentMinute();
                String message = "";
                if (SmokingCB.isChecked())
                {
                    message = "Smoking Area";
                }
                else
                {
                    message = "Non-Smoking Area";
                }
                Toast.makeText(MainActivity.this, "Name: " + InputName.getText().toString() +'\n' + "Mobile Number: " + InputMobileNo.getText().toString() + '\n' + "Size Group: " + InputSizeGroup.getText().toString() + '\n'+ "Date: " + day+"/"+month+"/"+year +  '\n' + "Time: " + String.format(Locale.getDefault(), "%02d:%02d", hour,minutes)  + '\n' + "Dinning Area: "+ message, Toast.LENGTH_SHORT).show();
            }

        });


        ResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.updateDate(2020,05,01);
                timePicker.setCurrentHour(19);
                timePicker.setCurrentMinute(30);
                InputName.getText().clear();
                InputMobileNo.getText().clear();
                InputSizeGroup.getText().clear();
            }
        });


    }
}