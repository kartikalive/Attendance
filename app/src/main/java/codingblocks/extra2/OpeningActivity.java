package codingblocks.extra2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class OpeningActivity extends AppCompatActivity {

    Button getStarted;
    EditText ETweeks, ETstartDate;
    Integer weeks;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        getStarted = (Button) findViewById(R.id.get_started);
        ETweeks = (EditText) findViewById(R.id.et_weeks);
        ETstartDate = (EditText) findViewById(R.id.et_start_date);

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                date = ETstartDate.getText().toString();
                if (!date.isEmpty()) {

                    if (ETweeks.getText().length()!=0) {
                        weeks = Integer.parseInt(ETweeks.getText().toString());

                        Intent i = new Intent(OpeningActivity.this,MainActivity.class);
                        i.putExtra("startDate",date);
                        i.putExtra("weeks",weeks);

                        startActivity(i);
                    }
                    else{
                        Toast.makeText(OpeningActivity.this, "Please enter number of weeks.", Toast.LENGTH_SHORT).show();
                    }
                }

                else{
                    if(ETweeks.getText().length()!=0){
                        Toast.makeText(OpeningActivity.this, "Please enter a date.", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        weeks = 7;
                        date="1-Aug";

                        Intent i = new Intent(OpeningActivity.this,MainActivity.class);
                        i.putExtra("startDate",date);
                        i.putExtra("weeks",weeks);

                        startActivity(i);
                    }
                }
            }
        });

    }
}