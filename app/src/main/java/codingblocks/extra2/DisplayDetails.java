package codingblocks.extra2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DisplayDetails extends AppCompatActivity {

    private ListView subList;
    int[] Present,Absent,Cancelled;
    int num_weeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);

       // Intent received = getIntent();
        Bundle mainData = getIntent().getExtras();

        Present = mainData.getIntArray("Present");
        Absent = mainData.getIntArray("Absent");
        Cancelled = mainData.getIntArray("Cancelled");
        num_weeks = mainData.getInt("WeekPos",0);

        //List-Adapter
        final String[] subjects = {"DBMS", "CSO", "OSD","ADA","SE","ECO","DBMS Lab","OS Lab", "CSO Lab"};
        ListAdapter myAdapter = new SubjectAdapter(this, subjects);
        subList = (ListView) findViewById(R.id.sub_list);
        subList.setAdapter(myAdapter);

        //Fragments

        subList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment1 fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment);
                fragment1.showInfo(Present[position],Absent[position],Cancelled[position],subjects[position],num_weeks);
            }
        });
    }
}
