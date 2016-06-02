package com.finomena.finlock;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    CustomAdapter adapter;
    public MainActivity CustomListView = null;
    public ArrayList<AppList> CustomListViewValuesArr = new ArrayList<AppList>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Button refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });;
        Button unlock = (Button) findViewById(R.id.unlock);
        unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("Enter Passcode");
                final EditText input = new EditText(MainActivity.this);
                input.setHint("Default Key: 1234");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                alert.setView(input);
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String srt = input.getEditableText().toString();
                        String key = "9467735494";	//Default key
                        boolean match = key.equals(srt);
                        if(match == true)
                        {
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);

                        }
                        else
                            Toast.makeText(getApplicationContext(),"Wrong Passcode",Toast.LENGTH_LONG).show();

                    }
                });
                AlertDialog alertDialog = alert.create();
                alertDialog.show();
            }
        });




        CustomListView = this;
        try {
            setListData();
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Resources res =getResources();
        list = (ListView)findViewById(R.id.listView1);
        adapter=new CustomAdapter(CustomListView, CustomListViewValuesArr,res);
        list.setAdapter(adapter);

    }

    public void setListData() throws PackageManager.NameNotFoundException
    {
        final AppList sched5 = new AppList();
        PackageInfo p5 = getPackageManager().getPackageInfo("finatics.com.custommorphosample", 0);

        sched5.setAppName(p5.applicationInfo.loadLabel(getPackageManager()).toString());
        sched5.setImage(p5.applicationInfo.loadIcon(getPackageManager()));
        sched5.setPackage(p5.packageName);
        CustomListViewValuesArr.add(sched5);


        final AppList sched2 = new AppList();
        PackageInfo p2 = getPackageManager().getPackageInfo("com.vinil.the_game.collegechooser", 0);

        sched2.setAppName(p2.applicationInfo.loadLabel(getPackageManager()).toString());
        sched2.setImage(p2.applicationInfo.loadIcon(getPackageManager()));
        sched2.setPackage(p2.packageName);
        CustomListViewValuesArr.add(sched2);

        final AppList sched3 = new AppList();
        PackageInfo p3 = getPackageManager().getPackageInfo("jp.co.canon_elec.cotm", 0);

        sched3.setAppName(p3.applicationInfo.loadLabel(getPackageManager()).toString());
        sched3.setImage(p3.applicationInfo.loadIcon(getPackageManager()));
        sched3.setPackage(p3.packageName);
        CustomListViewValuesArr.add(sched3);

        final AppList sched4 = new AppList();
        PackageInfo p4 = getPackageManager().getPackageInfo("es.qrr.android.btoolkit", 0);

        sched4.setAppName(p4.applicationInfo.loadLabel(getPackageManager()).toString());
        sched4.setImage(p4.applicationInfo.loadIcon(getPackageManager()));
        sched4.setPackage(p4.packageName);
        CustomListViewValuesArr.add(sched4);



        final AppList sched6 = new AppList();
        PackageInfo p6 = getPackageManager().getPackageInfo("org.kman.WifiManager", 0);

        sched6.setAppName(p6.applicationInfo.loadLabel(getPackageManager()).toString());
        sched6.setImage(p6.applicationInfo.loadIcon(getPackageManager()));
        sched6.setPackage(p6.packageName);
        CustomListViewValuesArr.add(sched6);

        final AppList sched7 = new AppList();
        PackageInfo p7 = getPackageManager().getPackageInfo("com.google.android.gm", 0);

        sched7.setAppName(p7.applicationInfo.loadLabel(getPackageManager()).toString());
        sched7.setImage(p7.applicationInfo.loadIcon(getPackageManager()));
        sched7.setPackage(p7.packageName);
        CustomListViewValuesArr.add(sched7);


        final AppList sched9 = new AppList();
        PackageInfo p9 = getPackageManager().getPackageInfo("com.android.chrome", 0);

        sched9.setAppName(p9.applicationInfo.loadLabel(getPackageManager()).toString());
        sched9.setImage(p9.applicationInfo.loadIcon(getPackageManager()));
        sched9.setPackage(p9.packageName);
        CustomListViewValuesArr.add(sched9);

        final AppList sched10 = new AppList();
        PackageInfo p10 = getPackageManager().getPackageInfo("com.adobe.reader", 0);

        sched10.setAppName(p10.applicationInfo.loadLabel(getPackageManager()).toString());
        sched10.setImage(p10.applicationInfo.loadIcon(getPackageManager()));
        sched10.setPackage(p10.packageName);
        CustomListViewValuesArr.add(sched10);

        final AppList sched11 = new AppList();
        PackageInfo p11 = getPackageManager().getPackageInfo("org.mozilla.firefox_beta", 0);

        sched11.setAppName(p11.applicationInfo.loadLabel(getPackageManager()).toString());
        sched11.setImage(p11.applicationInfo.loadIcon(getPackageManager()));
        sched11.setPackage(p11.packageName);
        CustomListViewValuesArr.add(sched11);
    }

    public void onItemClick(int mPosition)
    {
        AppList tempValues = (AppList) CustomListViewValuesArr.get(mPosition);
        Intent LaunchApp = getPackageManager().getLaunchIntentForPackage(tempValues.getPackage());
        startActivity(LaunchApp);
        Toast.makeText(CustomListView,tempValues.getAppName(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed () {
        return;

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            return true ;
        }
        return super.onKeyDown(keyCode, event);

    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(!hasFocus) {
            Intent closeDialog = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
            sendBroadcast(closeDialog);
        }
    }


}
