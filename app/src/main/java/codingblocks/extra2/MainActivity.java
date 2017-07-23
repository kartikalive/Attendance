package codingblocks.extra2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    ListView mylist;
    Date presentDate, nextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle mainData = getIntent().getExtras();
        final String startDate = mainData.getString("startDate");
        final int no_weeks = mainData.getInt("weeks");

        Integer[] weeks = new Integer[no_weeks];
        for(int i=0;i<no_weeks;i++)
        {
            weeks[i]=i;
        }

        String[] stringPresentDate = new String[no_weeks];
        String[] stringNextDate = new String[no_weeks];

        stringPresentDate[0]=startDate;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM");

        try {
            presentDate = sdf.parse(stringPresentDate[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(presentDate);

        cal.add(Calendar.DATE, 4);

        nextDate = cal.getTime();
        stringNextDate[0] = sdf.format(nextDate);

        for(int i= 0;i<no_weeks-1;i++) {
            try {
                presentDate = sdf.parse(stringPresentDate[i]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            cal = GregorianCalendar.getInstance();
            cal.setTime(presentDate);

            cal.add(Calendar.DATE, 7);

            stringPresentDate[i+1] = sdf.format(cal.getTime());
        }

        for(int i= 0;i<no_weeks-1;i++) {
            try {
                nextDate = sdf.parse(stringNextDate[i]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            cal = GregorianCalendar.getInstance();
            cal.setTime(nextDate);

            cal.add(Calendar.DATE, 7);

            stringNextDate[i+1] = sdf.format(cal.getTime());
        }


        ListAdapter myAdapter = new CustomAdapter(this, weeks, no_weeks,stringPresentDate,stringNextDate);
        mylist = (ListView)findViewById(R.id.my_list1);
        mylist.setAdapter(myAdapter);
    }
}
