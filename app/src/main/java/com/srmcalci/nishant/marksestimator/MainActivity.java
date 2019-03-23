package com.srmcalci.nishant.marksestimator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{   EditText ct1;
    EditText ct2;
    EditText stp;
    Spinner sp;
    public String ss;
    TextView tv;
    public int n4;
    Button button1;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ct1 = (EditText) findViewById(R.id.editText1);
        ct2 = (EditText) findViewById(R.id.editText2);
        stp = (EditText) findViewById(R.id.editText3);
        button1 = (Button) findViewById(R.id.button1);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.grades, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(this);



    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        ss = parent.getItemAtPosition(pos).toString();
        button1.setText("CALCULATE");



    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    public void CalculateMarks(View v) {
        button1.setText("CALCULATE");


        if (ss.equals("O"))
        {
            n4 = 10;
        }
        else if (ss.equals("A+"))
        {
            n4 = 9;
        }
        else if (ss.equals("A"))
        {
            n4 = 8;
        }
        else if (ss.equals("B+"))
        {
            n4 = 7;
        }
        else if (ss.equals("B"))
        {
            n4 = 6;
        }
        else if (ss.equals("C"))
        {
            n4 = 5;
        }
        else if (ss.equals("P"))
        {
            n4 = 4;
        }

        float marks = 0;
        String n6 = ct1.getText().toString();
        String n7 = ct2.getText().toString();
        String n8 = stp.getText().toString();
        //String n9 = gdp.getText().toString();
        if (n6.matches("") || n7.matches("") || n8.matches("")) {
            Toast.makeText(MainActivity.this, "Enter values first", Toast.LENGTH_SHORT).show();

        }
        else {

            float n1 = Float.parseFloat(ct1.getText().toString());
            float n2 = Float.parseFloat(ct2.getText().toString());
            float n3 = Float.parseFloat(stp.getText().toString());
            //int n4 = Integer.parseInt(gdp.getText().toString());
            if (n1 <= 15 && n2 <= 25 && n3 <= 10) {
                switch (n4) {
                    case 10:
                        marks = 95 - (n1 + n2 + n3);
                        break;
                    case 9:
                        marks = 90 - (n1 + n2 + n3);
                        break;
                    case 8:
                        marks = 85 - (n1 + n2 + n3);
                        break;
                    case 7:
                        marks = 75 - (n1 + n2 + n3);
                        break;
                    case 6:
                        marks = 65 - (n1 + n2 + n3);
                        break;
                    case 5:
                        marks = 55 - (n1 + n2 + n3);
                        break;
                    case 4:
                        marks = 50 - (n1 + n2 + n3);
                        break;
                    default:
                        marks = 51;
                }

                Toast.makeText(MainActivity.this,"Need "+2*marks+" marks in UNIV. EXAM", Toast.LENGTH_LONG).show();
                if (marks > 50)
                {
                    button1.setText("OUT OF RANGE");
                } else {
                    marks = marks * 2;
                    button1.setText(String.valueOf(marks)+" Marks" +
                            "");
                }

            }
            else
            {
                Toast.makeText(MainActivity.this,"Enter Points under range", Toast.LENGTH_SHORT).show();
            }

        }


    }
}


