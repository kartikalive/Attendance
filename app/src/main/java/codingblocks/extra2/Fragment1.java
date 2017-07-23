package codingblocks.extra2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by kartik1 on 03-07-2016.
 */
public class Fragment1 extends Fragment {

    private TextView subName, lecAttended, lecMissed, currAtt, lecLeft, minLecReq, condition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);

        subName = (TextView) view.findViewById(R.id.sub_name);
        lecAttended = (TextView) view.findViewById(R.id.lec_attended);
        lecMissed = (TextView) view.findViewById(R.id.lec_missed);
        currAtt = (TextView) view.findViewById(R.id.curr_att);
        lecLeft = (TextView) view.findViewById(R.id.lec_left);
        minLecReq = (TextView) view.findViewById(R.id.min_lec_req); // or already sufficient
        condition = (TextView)view.findViewById(R.id.condition);

        return view;
    }

    public void showInfo(int Present, int Absent, int Cancelled, String subject, int num_weeks) {

        int Total = Present + Absent;
        int PseudoFull, ActualFull;
        int LecturesLeft;
        double MinimumCriteria, MaxAtt,CurrAtt;

        subName.setText(subject);

        if (subject == "DBMS Lab" || subject == "CSO Lab" || subject == "OS Lab") {
            PseudoFull = num_weeks;

        } else if (subject == "ECO") {
            PseudoFull = num_weeks * 3;
        } else {
            PseudoFull = num_weeks * 4;
        }

        ActualFull = PseudoFull - Cancelled;
        LecturesLeft = PseudoFull - Total - Cancelled;
        MinimumCriteria = Math.ceil(0.75 * ActualFull);
        CurrAtt = (Present*100.0)/Total;
        //When can't make it to 75%:
        MaxAtt = ((Present + LecturesLeft) / ActualFull) * 100.0;

        lecAttended.setText("Lectures Attended - " + Present + "/" + Total);
        lecMissed.setText("Lectures Missed - " + Absent + "/" + Total);
        currAtt.setText("Current Percentage - " + (new DecimalFormat("##.##").format(CurrAtt))+"%");
        lecLeft.setText("Lectures Left - " + LecturesLeft);


//1.) Can't Make it to 75%

        if ((Present + LecturesLeft) < MinimumCriteria) {
            minLecReq.setText("Only " + MaxAtt + "%" + "even if Attend all from now on.");
            condition.setText("");
        }
//2.) Already more than 75%

        else if (Present >= MinimumCriteria) {
              minLecReq.setText("Lectures needed to make 75% = none/"+LecturesLeft+"**");
              condition.setText("**Unless any more cancelled");
        }
//3.) Normal case - Can make it to 75%
        else{
            minLecReq.setText("Lectures needed to make 75% = "+(new DecimalFormat("##").format(MinimumCriteria-Present))+"/"+LecturesLeft+"**");
            condition.setText("**Unless any more cancelled");
        }
    }
}
