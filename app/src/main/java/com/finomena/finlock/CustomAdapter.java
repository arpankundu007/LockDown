package com.finomena.finlock;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter implements OnClickListener {

	 private Activity activity;
     private ArrayList<?> data;
     private static LayoutInflater inflater=null;
     public Resources res;
     AppList tempValues=null;
     int i=0;
     
     //Constructor
     public CustomAdapter(Activity a, ArrayList<?> d,Resources resLocal) {
          activity = a;
          data = d;
          res = resLocal;
          inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       
  }
     
    
     
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(data.size()<=0)
            return 1;
        return data.size();
		
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	
	public static class ViewHolder{
		public TextView tv;
		public ImageView image;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		  View vi = convertView;
          ViewHolder holder;
           
          if(convertView==null){
               
              /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
              vi = inflater.inflate(R.layout.item, null);
               
              /****** View Holder Object to contain tabitem.xml file elements ******/

              holder = new ViewHolder();
              holder.tv = (TextView) vi.findViewById(R.id.text);
             
              holder.image=(ImageView)vi.findViewById(R.id.image);
               
             /************  Set holder with LayoutInflater ************/
              vi.setTag( holder );
          }
          else 
              holder=(ViewHolder)vi.getTag();
           
          if(data.size()<=0)
          {
              holder.tv.setText("No Data");
               
          }
          else
          {
              /***** Get each Model object from Arraylist ********/
              tempValues=null;
              tempValues = ( AppList ) data.get( position );
               
              /************  Set Model values in Holder elements ***********/

               holder.tv.setText( tempValues.getAppName() );
               holder.image.setImageDrawable(tempValues.getImage());
         
               vi.setOnClickListener(new OnItemClickListener( position ));
          }
          return vi;
		
		// TODO Auto-generated method stub
	
	}
	private class OnItemClickListener  implements OnClickListener{           
        private int mPosition;
         
        OnItemClickListener(int position){
             mPosition = position;
        }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		MainActivity sct = (MainActivity) activity;
        sct.onItemClick(mPosition);
		
	}
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	
}
	


