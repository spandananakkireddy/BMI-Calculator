/* Assignment #2
 Filenmae - InClass02 (BMI Calculator)
Priyanka Manusanipally - 801017222
 * Spandana - 801023658 */

package com.example.manup.inclass02;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;
import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    TextView tvage;
    TextView tvweight;
    TextView tvheight;
    EditText etage;
    EditText etheight;
    EditText etweight;
    EditText etfeet;
    EditText etinches;
    TextView tvresult;
    int age;
    double mass;
    double feet;
    double height;
    double inches;
    double bmi;
    double bmi1;
    TextView tvcolor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etage = (EditText) findViewById(R.id.etage);
        etweight = (EditText) findViewById(R.id.etweight);
        etinches = (EditText) findViewById(R.id.etinches);
        etfeet = (EditText) findViewById(R.id.etfeet);
        tvresult = (TextView) findViewById(R.id.tvresult);
        Button btncalculate = (Button) findViewById(R.id.btncalculate);
        tvcolor = (TextView) findViewById(R.id.tvcolor);


        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etage.getText().equals("") || etfeet.getText().equals("") || etinches.getText().equals("") || etweight.getText().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter the input", Toast.LENGTH_SHORT).show();

                } else {
                    try {
                        age = Integer.parseInt(etage.getText().toString());
                        feet = Double.parseDouble(etfeet.getText().toString());
                        inches = Double.parseDouble(etinches.getText().toString());
                        mass = Double.parseDouble(etweight.getText().toString());
                        Log.d("demo" ,mass +"");

                        if (age < 18) {
                            Toast.makeText(getApplicationContext(), "Age should be 18 and above", Toast.LENGTH_SHORT).show();
                            tvresult.setVisibility(View.INVISIBLE);
                            tvcolor.setVisibility(View.INVISIBLE);

                        } else {
                            tvresult.setVisibility(View.VISIBLE);
                            tvcolor.setVisibility(View.VISIBLE);
                            Log.d("demo", age + "");
                        }

                        height = (feet * 12) + inches;
                        Log.d("bmi",height + "");
                        Log.d("bmi",mass + "");
                        bmi1= (mass) / (height * height);
                        Log.d("bmi",bmi1 + "");
                        bmi = 703 *  bmi1;
                        Log.d("bmi",bmi + "");
                        String str =String.format("%.2f",bmi);
                        if(bmi < 18.5)
                        {
                            double m;
                            m= (18.5 * (height * height))/703;
                            double m1;
                            m1 = m - mass;
                            String s = String.format("%.2f", m);
                            tvresult.setText(" Result" + "\n\n"+ "BMI = " + str + "\n\n"+
                                    "Normal BMI range: 18.5 - 25" + "\n\n"+
                                    "You will need to gain " + s +"lbs to"
                                     +"\n\n" + "to reach a BMI of 18.5");
                           tvcolor.setText("(Underweight)");
                           tvcolor.setTextColor(Color.CYAN);
                           //tvresult.setVisibility(View.VISIBLE);



                        }
                        else if((bmi >= 18.5) && (bmi < 25) )
                        {
                            tvresult.setText("Result" + "\n\n"+ "BMI = " + str + "\n\n"+ "Normal BMI range: 18.5 - 25" +"\n\n" + "Keep up the good work !!");
                            tvcolor.setText("(Normal)");
                            tvcolor.setTextColor(Color.GREEN);
                        }
                        else if((bmi >= 25) && (bmi <30)) {
                            double k;
                            k= (25 * (height * height))/703;
                            double k1;
                            k1 =  mass - k;
                            String s1 = String.format("%.2f", k);
                            tvcolor.setText("(Overweight)");
                            tvcolor.setTextColor(Color.BLUE);
                            //tvresult.setVisibility(View.VISIBLE);


                            tvresult.setText("Result " +"\n\n"+ "BMI = " + str + "\n\n"+
                                    "Normal BMI range: 18.5 - 25 " + "\n\n"+
                                    "You will need to lose " + s1 +"lbs "
                                    +"\n\n" + "to reach a BMI of 25");
                        }
                        else if((bmi >= 30))
                        {
                            double k;
                            k= (25 * (height * height))/703;
                            double k1;
                            k1 =  mass - k;
                            String s1 = String.format("%.2f", k);
                            tvcolor.setText("(Overweight)");
                            tvcolor.setTextColor(Color.BLUE);
                            //tvresult.setVisibility(View.VISIBLE);

                            tvresult.setText("Result" +"\n\n"+ "BMI = " + str + "\n\n"+
                                    "Normal BMI range: 18.5 - 25" + "\n\n"+
                                    "You will need to lose " + s1 +"lbs to"
                                    +"\n\n" + "to reach a BMI of 25");
                        }


                    } catch (NumberFormatException ex) {
                        Toast.makeText(getApplicationContext(), "Please enter the Data", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });
    }



}

