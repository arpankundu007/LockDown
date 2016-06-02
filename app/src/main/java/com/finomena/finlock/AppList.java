package com.finomena.finlock;

import android.graphics.drawable.Drawable;

public class AppList {
	
	   private  String AppName="";
       private  Drawable Image;
       private Boolean check;
       private String Package;
       
        
       /*********** Set Methods ******************/
        
       public void setAppName(String AppName)
       {
           this.AppName = AppName;
       }
        
       public void setImage(Drawable drawable)
       {
           this.Image = drawable;
       }
       public void setValue(Boolean val)
       {
    	   this.check = val;
       }
       public void setPackage(String Package)
       {
    	   this.Package = Package;
       }
   
        
       /*********** Get Methods ****************/
        
       public String getAppName()
       {
           return this.AppName;
       }
        
       public Drawable getImage()
       {
           return this.Image;
       }
       public Boolean getValue()
       {
    	   return this.check;
       }
       public String getPackage()
       {
		return Package;
    	   
       }

}
