package codingblocks.extra2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class SubjectAdapter extends ArrayAdapter<String> {

    LayoutInflater myInflator;

    public SubjectAdapter(Context context, String[] subjects) {
        super(context, R.layout.subject_adapter, subjects);
        myInflator = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        // System.out.println("getView " + position + " " + convertView);
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = myInflator.inflate(R.layout.subject_adapter,null);
            holder.subjectName = (TextView)convertView.findViewById(R.id.subject_name);
            convertView.setTag(holder);
        }

        else{
            holder = (ViewHolder)convertView.getTag();
        }

        String singlesubject = getItem(position);
        holder.subjectName.setText(singlesubject);

        return convertView;
    }
    static class ViewHolder{
        TextView subjectName;
    }
}

