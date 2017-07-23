package codingblocks.extra2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.Color;

import static android.support.v4.app.ActivityCompat.startActivity;


public class CustomAdapter extends ArrayAdapter<Integer> {

    private int num_weeks;
    private String[] presentDate;
    private String[] nextDate;
    LayoutInflater myInflater;

    private Context ctx;
    static int[] Present = new int[9];
    static int[] Absent= new int[9];
    static int[] Cancelled=new int[9];
    //DbmsCount=0 , CsoCount=0 , OsdCount=0 , AdaCount=0 , SeCount=0 , EcoCount=0, DbmsLabCount=0, OsdLabCount=0, CsoLabCount=0,
    //Count = Number of classes Attended
    //IMPORTANT NOTE :-  Total = Num
    // DbmsTotal=0 , CsoTotal=0 , OsdTotal=0 , AdaTotal=0 , SeTotal=0 , EcoTotal=0, DbmsLabTotal=0, OsdLabTotal=0, CsoLabTotal=0;

    static int DbmsFlag1 = 0,DbmsFlag2 = 0,DbmsFlag3 = 0,DbmsFlag4 = 0, CsoFlag1 = 0,CsoFlag2 = 0,CsoFlag3 = 0,CsoFlag4 = 0,
               OsdFlag1=0, OsdFlag2=0,OsdFlag3=0,OsdFlag4=0, AdaFlag1 = 0,AdaFlag2 = 0,AdaFlag3 = 0,AdaFlag4 = 0,
               SeFlag1 = 0,SeFlag2 = 0,SeFlag3 = 0,SeFlag4 = 0,EcoFlag1 = 0,EcoFlag2 = 0,EcoFlag3 = 0,
               DbmsLabFlag= 0, OsdLabFlag = 0, CsoLabFlag = 0;

    public CustomAdapter(Context context, Integer[] weeks, int num_weeks, String[] presentDate, String[] nextDate) {
        super(context, R.layout.custom_row, weeks );
        this.num_weeks = num_weeks;
        this.presentDate = presentDate;
        this.nextDate = nextDate;
        ctx = context;

        myInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //ShoeDetailsMethod :

    public void transferCounts(Context c, int[] present, int absent[], int cancelled[], int no_weeks){

        Intent i = new Intent(c, DisplayDetails.class);
        i.putExtra("Present",present);
        i.putExtra("Absent",absent);
        i.putExtra("Cancelled",cancelled);
        i.putExtra("WeekPos",no_weeks);

        c.startActivity(i);
    }

    //getView :    containing all textview declarations also

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if (convertView == null) {

            Log.d("TAG2","Inside if: ");
            holder = new ViewHolder();
            convertView = myInflater.inflate(R.layout.custom_row, null);

            holder.textViews[0] = (TextView)convertView.findViewById(R.id.dbms1);
            holder.textViews[1] = (TextView)convertView.findViewById(R.id.dbms2);
            holder.textViews[2] = (TextView)convertView.findViewById(R.id.dbms3);
            holder.textViews[3] = (TextView)convertView.findViewById(R.id.dbms4);

            holder.textViews[4] = (TextView)convertView.findViewById(R.id.cso1);
            holder.textViews[5] = (TextView)convertView.findViewById(R.id.cso2);
            holder.textViews[6] = (TextView)convertView.findViewById(R.id.cso3);
            holder.textViews[7] = (TextView)convertView.findViewById(R.id.cso4);

            holder.textViews[8] = (TextView)convertView.findViewById(R.id.osd1);
            holder.textViews[9] = (TextView)convertView.findViewById(R.id.osd2);
            holder.textViews[10] = (TextView)convertView.findViewById(R.id.osd3);
            holder.textViews[11] = (TextView)convertView.findViewById(R.id.osd4);

            holder.textViews[12] = (TextView)convertView.findViewById(R.id.ada1);
            holder.textViews[13] = (TextView)convertView.findViewById(R.id.ada2);
            holder.textViews[14] = (TextView)convertView.findViewById(R.id.ada3);
            holder.textViews[15] = (TextView)convertView.findViewById(R.id.ada4);

            holder.textViews[16] = (TextView)convertView.findViewById(R.id.se1);
            holder.textViews[17] = (TextView)convertView.findViewById(R.id.se2);
            holder.textViews[18] = (TextView)convertView.findViewById(R.id.se3);
            holder.textViews[19] = (TextView)convertView.findViewById(R.id.se4);

            holder.textViews[20] = (TextView)convertView.findViewById(R.id.eco1);
            holder.textViews[21] = (TextView)convertView.findViewById(R.id.eco2);
            holder.textViews[22] = (TextView)convertView.findViewById(R.id.eco3);

            holder.textViews[23] = (TextView)convertView.findViewById(R.id.dbms_lab);
            holder.textViews[24] = (TextView)convertView.findViewById(R.id.os_lab);
            holder.textViews[25] = (TextView)convertView.findViewById(R.id.cso_lab);

            holder.Details = (TextView)convertView.findViewById(R.id.details);

            holder.weekNo = (TextView)convertView.findViewById(R.id.week_no);

            convertView.setTag(holder);


        }

        else{
               holder = (ViewHolder) convertView.getTag();
               for(int i=0;i<=25;i++) {
                   holder.textViews[i].setBackgroundColor(Color.parseColor("#d5f4fa"));

                   Log.d("TAG2", "Inside else: ");
                }

        }

        DbmsFlag1 = 0;DbmsFlag2 = 0;DbmsFlag3 = 0;DbmsFlag4 = 0; CsoFlag1 = 0;CsoFlag2 = 0;CsoFlag3 = 0;CsoFlag4 = 0;
        OsdFlag1=0; OsdFlag2=0;OsdFlag3=0;OsdFlag4=0; AdaFlag1 = 0;AdaFlag2 = 0;AdaFlag3 = 0;AdaFlag4 = 0;
        SeFlag1 = 0;SeFlag2 = 0;SeFlag3 = 0;SeFlag4 = 0;EcoFlag1 = 0;EcoFlag2 = 0;EcoFlag3 = 0;
        DbmsLabFlag= 0; OsdLabFlag = 0;CsoLabFlag = 0;
        Log.d("TAG2","Outside Both: ");

//        int singleweek = weeks[position];
        holder.weekNo.setText(presentDate[position]+" to "+ nextDate[position]);



        //OnClickListeners
        //For Show Details :

        holder.Details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent i = new Intent(v.getContext(), DisplayDetails.class);


                //startActivity(i);
                transferCounts(ctx, Present, Absent, Cancelled, num_weeks);
            }
        });



        //Each subject onClickListener:

//-----------------------------DBMS----------------------------------------------------------

        holder.textViews[0].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.d("TAG1", "Dbms present before start= " + Present[0]);
                Log.d("TAG1", "Dbms absent before start= " + Absent[0]);
                Log.d("TAG1", "Dbms cancel before start= " + Cancelled[0]);

                if (DbmsFlag1 == 0) {  //if Transparent
                    Present[0]++;
                    holder.textViews[0].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    DbmsFlag1 = 1;

                    Log.d("TAG1", "Dbms present in green = " + Present[0]);
                    Log.d("TAG1", "Dbms absent in green = " + Absent[0]);
                    Log.d("TAG1", "Dbms cancel in green = " + Cancelled[0]);

                }

                else if (DbmsFlag1 == 1){  //if Green
                    Present[0]--;
                    Absent[0]++;
                holder.textViews[0].setBackgroundColor(Color.parseColor("#FFF27777"));  //Make Absent i.e. Red
                    DbmsFlag1 = 2;
                    Log.d("TAG1", "Dbms present in red = " + Present[0]);
                    Log.d("TAG1", "Dbms absent in red = " + Absent[0]);
                    Log.d("TAG1", "Dbms cancel in red = " + Cancelled[0]);


                }
                else if(DbmsFlag1 == 2){   //if Red
                    Absent[0]--;
                    Cancelled[0]++;
                    holder.textViews[0].setBackgroundResource(R.drawable.cross2); //Make Class Cancelled i.e. Cross
                    DbmsFlag1 = 3;
                    Log.d("TAG1", "Dbms present in cross = " + Present[0]);
                    Log.d("TAG1", "Dbms absent in cross = " + Absent[0]);
                    Log.d("TAG1", "Dbms cancel in cross = " + Cancelled[0]);

                }

                else if (DbmsFlag1 ==3) //if Cross
                {
                    Cancelled[0]--;
                    holder.textViews[0].setBackgroundColor(Color.TRANSPARENT); //Make Nothing i.e. Transparent
                    DbmsFlag1 = 0;
                    Log.d("TAG1", "Dbms present at end = " + Present[0]);
                    Log.d("TAG1", "Dbms absent at end = " + Absent[0]);
                    Log.d("TAG1", "Dbms cancel at end= " + Cancelled[0]);

                }

            }
        });

        holder.textViews[1].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (DbmsFlag2 == 0) {
                    Present[0]++;
                    holder.textViews[1].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    DbmsFlag2 = 1;
                } else if (DbmsFlag2 == 1) {
                    Present[0]--;
                    Absent[0]++;
                    holder.textViews[1].setBackgroundColor(Color.parseColor("#FFF27777"));
                    DbmsFlag2 = 2;
                } else if (DbmsFlag2 == 2) {
                    Absent[0]--;
                    Cancelled[0]++;
                    holder.textViews[1].setBackgroundResource(R.drawable.cross2);
                    DbmsFlag2 = 3;
                } else if (DbmsFlag2 == 3) {
                    Cancelled[0]--;
                    holder.textViews[1].setBackgroundColor(Color.TRANSPARENT);
                    DbmsFlag2 = 0;
                }
            }
        });

        holder.textViews[2].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (DbmsFlag3 == 0) {
                    Present[0]++;
                    holder.textViews[2].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    DbmsFlag3 = 1;
                } else if (DbmsFlag3 == 1) {
                    Present[0]--;
                    Absent[0]++;
                    holder.textViews[2].setBackgroundColor(Color.parseColor("#FFF27777"));
                    DbmsFlag3 = 2;
                } else if (DbmsFlag3 == 2) {
                    Absent[0]--;
                    Cancelled[0]++;
                    holder.textViews[2].setBackgroundResource(R.drawable.cross2);
                    DbmsFlag3 = 3;
                } else if (DbmsFlag3 == 3) {
                    Cancelled[0]--;
                    holder.textViews[2].setBackgroundColor(Color.TRANSPARENT);
                    DbmsFlag3 = 0;
                }
            }
        });

        holder.textViews[3].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (DbmsFlag4 == 0) {
                    Present[0]++;
                    holder.textViews[3].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    DbmsFlag4 = 1;
                } else if (DbmsFlag4 == 1) {
                    Present[0]--;
                    Absent[0]++;
                    holder.textViews[3].setBackgroundColor(Color.parseColor("#FFF27777"));
                    DbmsFlag4 = 2;
                } else if (DbmsFlag4 == 2) {
                    Absent[0]--;
                    Cancelled[0]++;
                    holder.textViews[3].setBackgroundResource(R.drawable.cross2);
                    DbmsFlag4 = 3;
                } else if (DbmsFlag4 == 3) {
                    Cancelled[0]--;
                    holder.textViews[3].setBackgroundColor(Color.TRANSPARENT);
                    DbmsFlag4 = 0;
                }
            }
        });

//------------------------------------------------DBMS---------------------------------------------
//------------------------------------------------CSO-----------------------------------------------

        holder.textViews[4].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CsoFlag1 == 0) {
                    Present[1]++;
                    holder.textViews[4].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    CsoFlag1 = 1;
                } else if (CsoFlag1 == 1) {
                    Present[1]--;
                    Absent[1]++;
                    holder.textViews[4].setBackgroundColor(Color.parseColor("#FFF27777"));
                    CsoFlag1 = 2;
                } else if (CsoFlag1 == 2) {
                    Absent[1]--;
                    Cancelled[1]++;
                    holder.textViews[4].setBackgroundResource(R.drawable.cross2);
                    CsoFlag1 = 3;
                } else if (CsoFlag1 == 3) {
                    Cancelled[1]--;
                    holder.textViews[4].setBackgroundColor(Color.TRANSPARENT);
                    CsoFlag1 = 0;
                }
            }
        });

        holder.textViews[5].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CsoFlag2 == 0) {
                    Present[1]++;
                    holder.textViews[5].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    CsoFlag2 = 1;
                } else if (CsoFlag2 == 1) {
                    Present[1]--;
                    Absent[1]++;
                    holder.textViews[5].setBackgroundColor(Color.parseColor("#FFF27777"));
                    CsoFlag2 = 2;
                } else if (CsoFlag2 == 2) {
                    Absent[1]--;
                    Cancelled[1]++;
                    holder.textViews[5].setBackgroundResource(R.drawable.cross2);
                    CsoFlag2 = 3;
                } else if (CsoFlag2 == 3) {
                    Cancelled[1]--;
                    holder.textViews[5].setBackgroundColor(Color.TRANSPARENT);
                    CsoFlag2 = 0;
                }
            }
        });

        holder.textViews[6].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CsoFlag3 == 0) {
                    Present[1]++;
                    holder.textViews[6].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    CsoFlag3 = 1;
                } else if (CsoFlag3 == 1) {
                    Present[1]--;
                    Absent[1]++;
                    holder.textViews[6].setBackgroundColor(Color.parseColor("#FFF27777"));
                    CsoFlag3 = 2;
                } else if (CsoFlag3 == 2) {
                    Absent[1]--;
                    Cancelled[1]++;
                    holder.textViews[6].setBackgroundResource(R.drawable.cross2);
                    CsoFlag3 = 3;
                } else if (CsoFlag3 == 3) {
                    Cancelled[1]--;
                    holder.textViews[6].setBackgroundColor(Color.TRANSPARENT);
                    CsoFlag3 = 0;
                }
            }
        });

        holder.textViews[7].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CsoFlag4 == 0) {
                    Present[1]++;
                    holder.textViews[7].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    CsoFlag4 = 1;
                } else if (CsoFlag4 == 1) {
                    Present[1]--;
                    Absent[1]++;
                    holder.textViews[7].setBackgroundColor(Color.parseColor("#FFF27777"));
                    CsoFlag4 = 2;
                } else if (CsoFlag4 == 2) {
                    Absent[1]--;
                    Cancelled[1]++;
                    holder.textViews[7].setBackgroundResource(R.drawable.cross2);
                    CsoFlag4 = 3;
                } else if (CsoFlag4 == 3) {
                    Cancelled[1]--;
                    holder.textViews[7].setBackgroundColor(Color.TRANSPARENT);
                    CsoFlag4 = 0;
                }
            }
        });
        //--------------------------CSO------------------------------
        //--------------------------OSD------------------------------

        holder.textViews[8].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (OsdFlag1 == 0) {
                    Present[2]++;
                    holder.textViews[8].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    OsdFlag1 = 1;
                } else if (OsdFlag1 == 1) {
                    Present[2]--;
                    Absent[2]++;
                    holder.textViews[8].setBackgroundColor(Color.parseColor("#FFF27777"));
                    OsdFlag1 = 2;
                } else if (OsdFlag1 == 2) {
                    Absent[2]--;
                    Cancelled[2]++;
                    holder.textViews[8].setBackgroundResource(R.drawable.cross2);
                    OsdFlag1 = 3;
                } else if (OsdFlag1 == 3) {
                    Cancelled[2]--;
                    holder.textViews[8].setBackgroundColor(Color.TRANSPARENT);
                    OsdFlag1 = 0;
                }
            }
        });

        holder.textViews[9].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (OsdFlag2 == 0) {
                    Present[2]++;
                    holder.textViews[9].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    OsdFlag2 = 1;
                } else if (OsdFlag2 == 1) {
                    Present[2]--;
                    Absent[2]++;
                    holder.textViews[9].setBackgroundColor(Color.parseColor("#FFF27777"));
                    OsdFlag2 = 2;
                } else if (OsdFlag2 == 2) {
                    Absent[2]--;
                    Cancelled[2]++;
                    holder.textViews[9].setBackgroundResource(R.drawable.cross2);
                    OsdFlag2 = 3;
                } else if (OsdFlag2 == 3) {
                    Cancelled[2]--;
                    holder.textViews[9].setBackgroundColor(Color.TRANSPARENT);
                    OsdFlag2 = 0;
                }
            }
        });

        holder.textViews[10].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (OsdFlag3 == 0) {
                    Present[2]++;
                    holder.textViews[10].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    OsdFlag3 = 1;
                } else if (OsdFlag3 == 1) {
                    Present[2]--;
                    Absent[2]++;
                    holder.textViews[10].setBackgroundColor(Color.parseColor("#FFF27777"));
                    OsdFlag3 = 2;
                } else if (OsdFlag3 == 2) {
                    Absent[2]--;
                    Cancelled[2]++;
                    holder.textViews[10].setBackgroundResource(R.drawable.cross2);
                    OsdFlag3 = 3;
                } else if (OsdFlag3 == 3) {
                    Cancelled[2]--;
                    holder.textViews[10].setBackgroundColor(Color.TRANSPARENT);
                    OsdFlag3 = 0;
                }
            }
        });

        holder.textViews[11].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (OsdFlag4 == 0) {
                    Present[2]++;
                    holder.textViews[11].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    OsdFlag4 = 1;
                } else if (OsdFlag4 == 1) {
                    Present[2]--;
                    Absent[2]++;
                    holder.textViews[11].setBackgroundColor(Color.parseColor("#FFF27777"));
                    OsdFlag4 = 2;
                } else if (OsdFlag4 == 2) {
                    Absent[2]--;
                    Cancelled[2]++;
                    holder.textViews[11].setBackgroundResource(R.drawable.cross2);
                    OsdFlag4 = 3;
                } else if (OsdFlag4 == 3) {
                    Cancelled[2]--;
                    holder.textViews[11].setBackgroundColor(Color.TRANSPARENT);
                    OsdFlag4 = 0;
                }
            }
        });

        //------------------------------OSD--------------------------------
        //------------------------------ADA--------------------------------

        holder.textViews[12].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (AdaFlag1 == 0) {
                    Present[3]++;
                    holder.textViews[12].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    AdaFlag1 = 1;
                } else if (AdaFlag1 == 1) {
                    Present[3]--;
                    Absent[3]++;
                    holder.textViews[12].setBackgroundColor(Color.parseColor("#FFF27777"));
                    AdaFlag1 = 2;
                } else if (AdaFlag1 == 2) {
                    Absent[3]--;
                    Cancelled[3]++;
                    holder.textViews[12].setBackgroundResource(R.drawable.cross2);
                    AdaFlag1 = 3;
                } else if (AdaFlag1 == 3) {
                    Cancelled[3]--;
                    holder.textViews[12].setBackgroundColor(Color.TRANSPARENT);
                    AdaFlag1 = 0;
                }
            }
        });

        holder.textViews[13].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (AdaFlag2 == 0) {
                    Present[3]++;
                    holder.textViews[13].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    AdaFlag2 = 1;
                } else if (AdaFlag2 == 1) {
                    Present[3]--;
                    Absent[3]++;
                    holder.textViews[13].setBackgroundColor(Color.parseColor("#FFF27777"));
                    AdaFlag2 = 2;
                } else if (AdaFlag2 == 2) {
                    Absent[3]--;
                    Cancelled[3]++;
                    holder.textViews[13].setBackgroundResource(R.drawable.cross2);
                    AdaFlag2 = 3;
                } else if (AdaFlag2 == 3) {
                    Cancelled[3]--;
                    holder.textViews[13].setBackgroundColor(Color.TRANSPARENT);
                    AdaFlag2 = 0;
                }
            }
        });

        holder.textViews[14].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (AdaFlag3 == 0) {
                    Present[3]++;
                    holder.textViews[14].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    AdaFlag3 = 1;
                } else if (AdaFlag3 == 1) {
                    Present[3]--;
                    Absent[3]++;
                    holder.textViews[14].setBackgroundColor(Color.parseColor("#FFF27777"));
                    AdaFlag3 = 2;
                } else if (AdaFlag3 == 2) {
                    Absent[3]--;
                    Cancelled[3]++;
                    holder.textViews[14].setBackgroundResource(R.drawable.cross2);
                    AdaFlag3 = 3;
                } else if (AdaFlag3 == 3) {
                    Cancelled[3]--;
                    holder.textViews[14].setBackgroundColor(Color.TRANSPARENT);
                    AdaFlag3 = 0;
                }
            }
        });

        holder.textViews[15].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (AdaFlag4 == 0) {
                    Present[3]++;
                    holder.textViews[15].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    AdaFlag4 = 1;
                } else if (AdaFlag4 == 1) {
                    Present[3]--;
                    Absent[3]++;
                    holder.textViews[15].setBackgroundColor(Color.parseColor("#FFF27777"));
                    AdaFlag4 = 2;
                } else if (AdaFlag4 == 2) {
                    Absent[3]--;
                    Cancelled[3]++;
                    holder.textViews[15].setBackgroundResource(R.drawable.cross2);
                    AdaFlag4 = 3;
                } else if (AdaFlag4 == 3) {
                    Cancelled[3]--;
                    holder.textViews[15].setBackgroundColor(Color.TRANSPARENT);
                    AdaFlag4 = 0;
                }
            }
        });

        //----------------------------------ADA---------------------------------
        //----------------------------------SE----------------------------------

        holder.textViews[16].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (SeFlag1 == 0) {
                    Present[4]++;
                    holder.textViews[16].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    SeFlag1 = 1;
                } else if (SeFlag1 == 1) {
                    Present[4]--;
                    Absent[4]++;
                    holder.textViews[16].setBackgroundColor(Color.parseColor("#FFF27777"));
                    SeFlag1 = 2;
                } else if (SeFlag1 == 2) {
                    Absent[4]--;
                    Cancelled[4]++;
                    holder.textViews[16].setBackgroundResource(R.drawable.cross2);
                    SeFlag1 = 3;
                } else if (SeFlag1 == 3) {
                    Cancelled[4]--;
                    holder.textViews[16].setBackgroundColor(Color.TRANSPARENT);
                    SeFlag1 = 0;
                }
            }
        });

        holder.textViews[17].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (SeFlag2 == 0) {
                    Present[4]++;
                    holder.textViews[17].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    SeFlag2 = 1;
                } else if (SeFlag2 == 1) {
                    Present[4]--;
                    Absent[4]++;
                    holder.textViews[17].setBackgroundColor(Color.parseColor("#FFF27777"));
                    SeFlag2 = 2;
                } else if (SeFlag2 == 2) {
                    Absent[4]--;
                    Cancelled[4]++;
                    holder.textViews[17].setBackgroundResource(R.drawable.cross2);
                    SeFlag2 = 3;
                } else if (SeFlag2 == 3) {
                    Cancelled[4]--;
                    holder.textViews[17].setBackgroundColor(Color.TRANSPARENT);
                    SeFlag2 = 0;
                }
            }
        });

        holder.textViews[18].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (SeFlag3 == 0) {
                    Present[4]++;
                    holder.textViews[18].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    SeFlag3 = 1;
                } else if (SeFlag3 == 1) {
                    Present[4]--;
                    Absent[4]++;
                    holder.textViews[18].setBackgroundColor(Color.parseColor("#FFF27777"));
                    SeFlag3 = 2;
                } else if (SeFlag3 == 2) {
                    Absent[4]--;
                    Cancelled[4]++;
                    holder.textViews[18].setBackgroundResource(R.drawable.cross2);
                    SeFlag3 = 3;
                } else if (SeFlag3 == 3) {
                    Cancelled[4]--;
                    holder.textViews[18].setBackgroundColor(Color.TRANSPARENT);
                    SeFlag3 = 0;
                }
            }
        });

        holder.textViews[19].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (SeFlag4 == 0) {
                    Present[4]++;
                    holder.textViews[19].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    SeFlag4 = 1;
                } else if (SeFlag4 == 1) {
                    Present[4]--;
                    Absent[4]++;
                    holder.textViews[19].setBackgroundColor(Color.parseColor("#FFF27777"));
                    SeFlag4 = 2;
                } else if (SeFlag4 == 2) {
                    Absent[4]--;
                    Cancelled[4]++;
                    holder.textViews[19].setBackgroundResource(R.drawable.cross2);
                    SeFlag4 = 3;
                } else if (SeFlag4 == 3) {
                    Cancelled[4]--;
                    holder.textViews[19].setBackgroundColor(Color.TRANSPARENT);
                    SeFlag4 = 0;
                }
            }
        });

        //------------------------------------SE----------------------------------
        //------------------------------------ECO---------------------------------

        holder.textViews[20].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (EcoFlag1 == 0) {
                    Present[5]++;
                    holder.textViews[20].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    EcoFlag1 = 1;
                } else if (EcoFlag1 == 1) {
                    Present[5]--;
                    Absent[5]++;
                    holder.textViews[20].setBackgroundColor(Color.parseColor("#FFF27777"));
                    EcoFlag1 = 2;
                } else if (EcoFlag1 == 2) {
                    Absent[5]--;
                    Cancelled[5]++;
                    holder.textViews[20].setBackgroundResource(R.drawable.cross2);
                    EcoFlag1 = 3;
                } else if (EcoFlag1 == 3) {
                    Cancelled[5]--;
                    holder.textViews[20].setBackgroundColor(Color.TRANSPARENT);
                    EcoFlag1 = 0;
                }
            }
        });

        holder.textViews[21].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (EcoFlag2 == 0) {
                    Present[5]++;
                    holder.textViews[21].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    EcoFlag2 = 1;
                } else if (EcoFlag2 == 1) {
                    Present[5]--;
                    Absent[5]++;
                    holder.textViews[21].setBackgroundColor(Color.parseColor("#FFF27777"));
                    EcoFlag2 = 2;
                } else if (EcoFlag2 == 2) {
                    Absent[5]--;
                    Cancelled[5]++;
                    holder.textViews[21].setBackgroundResource(R.drawable.cross2);
                    EcoFlag2 = 3;
                } else if (EcoFlag2 == 3) {
                    Cancelled[5]--;
                    holder.textViews[21].setBackgroundColor(Color.TRANSPARENT);
                    EcoFlag2 = 0;
                }
            }
        });

        holder.textViews[22].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (EcoFlag3 == 0) {
                    Present[5]++;
                    holder.textViews[22].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    EcoFlag3 = 1;
                } else if (EcoFlag3 == 1) {
                    Present[5]--;
                    Absent[5]++;
                    holder.textViews[22].setBackgroundColor(Color.parseColor("#FFF27777"));
                    EcoFlag3 = 2;
                } else if (EcoFlag3 == 2) {
                    Absent[5]--;
                    Cancelled[5]++;
                    holder.textViews[22].setBackgroundResource(R.drawable.cross2);
                    EcoFlag3 = 3;
                } else if (EcoFlag3 == 3) {
                    Cancelled[5]--;
                    holder.textViews[22].setBackgroundColor(Color.TRANSPARENT);
                    EcoFlag3 = 0;
                }
            }
        });

        //-------------------------------ECO-----------------------------
        //-------------------------------LABS----------------------------

        holder.textViews[23].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (DbmsLabFlag == 0) {
                    Present[6]++;
                    holder.textViews[23].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    DbmsLabFlag = 1;
                } else if (DbmsLabFlag == 1) {
                    Present[6]--;
                    Absent[6]++;
                    holder.textViews[23].setBackgroundColor(Color.parseColor("#FFF27777"));
                    DbmsLabFlag = 2;
                } else if (DbmsLabFlag == 2) {
                    Absent[6]--;
                    Cancelled[6]++;
                    holder.textViews[23].setBackgroundResource(R.drawable.cross2);
                    DbmsLabFlag = 3;
                } else if (DbmsLabFlag == 3) {
                    Cancelled[6]--;
                    holder.textViews[23].setBackgroundColor(Color.TRANSPARENT);
                    DbmsLabFlag = 0;
                }
            }
        });

        holder.textViews[24].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (OsdLabFlag == 0) {
                    Present[7]++;
                    holder.textViews[24].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    OsdLabFlag = 1;
                } else if (OsdLabFlag == 1) {
                    Present[7]--;
                    Absent[7]++;
                    holder.textViews[24].setBackgroundColor(Color.parseColor("#FFF27777"));
                    OsdLabFlag = 2;
                } else if (OsdLabFlag == 2) {
                    Absent[7]--;
                    Cancelled[7]++;
                    holder.textViews[24].setBackgroundResource(R.drawable.cross2);
                    OsdLabFlag = 3;
                } else if (OsdLabFlag == 3) {
                    Cancelled[7]--;
                    holder.textViews[24].setBackgroundColor(Color.TRANSPARENT);
                    OsdLabFlag = 0;
                }
            }
        });


        holder.textViews[25].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CsoLabFlag == 0) {
                    Present[8]++;
                    holder.textViews[25].setBackgroundColor(Color.parseColor("#b3f489"));  //Make Present i.e. Green
                    CsoLabFlag = 1;
                } else if (CsoLabFlag == 1) {
                    Present[8]--;
                    Absent[8]++;
                    holder.textViews[25].setBackgroundColor(Color.parseColor("#FFF27777"));
                    CsoLabFlag = 2;
                } else if (CsoLabFlag == 2) {
                    Absent[8]--;
                    Cancelled[8]++;
                    holder.textViews[25].setBackgroundResource(R.drawable.cross2);
                    CsoLabFlag = 3;
                } else if (CsoLabFlag == 3) {
                    Cancelled[8]--;
                    holder.textViews[25].setBackgroundColor(Color.TRANSPARENT);
                    CsoLabFlag = 0;
                }
            }
        });

        //Show Details

        return convertView;

    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//
//    }

    static class ViewHolder{
        TextView[] textViews = new TextView[26];
        TextView weekNo, Details;
    }
}