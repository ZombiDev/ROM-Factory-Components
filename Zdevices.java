// Zdevices v1.11 * By Samuel Rivera "SamCripp"
//
// This code is constantly evolving. So if you use this on your project please keep an eye on the repository the code came from.
// 
// http://zombidev.com * http://fcm.zombidev.com * http://repo.zombidev.com
//
// This code is the intellectual property of Samuel Rivera, 2011-2012. I, Samuel Rivera, grant you the following rights.
// 1. You may modify and redistribute this code. 2. You may compile and redistribute this code. 3. You may use this code in personal or educational projects.
// 
// With that said, here is a list of rights revoked.
// 1. You may not use this code on commercial projects. 2. You may not use this code on corporate environment. 
// 3. You may not use the code in any malicious way. 4. You may not use it for profit.
//
// Conditions:
// 1. Any project utilizing this code, whether close or open source, must always provide the latest version of this code, including all modifications. 
// 2. Any project utilizing this code, must provide a link back to http://fcm.zombidev.com and http://repo.zombidev.com.
// 3. Any project utilizing this code, must provide credit to Samuel Rivera as original author of code. ie:
// Zdevices v1.11 - Original Author: Samuel Rivera "SamCripp"
//
// Thanks for following this simple rules.

package com.samcripp.fcm;

import android.os.Build;
import android.os.Environment;
import android.util.Log;

public class Zdevices {
	String Phone = Build.DEVICE;
	String OS = Build.VERSION.RELEASE;
	String DataPart;
	String BootPart;
	String SysPart;
	String zStorage;
	boolean appRun;
	boolean secondInit;
	
public void SetIt(){
	
	secondInit = false;

		
    if(Phone.contentEquals("olympus")) //moto atrix
    {
    	if(OS.contentEquals("2.3.4"))
    	{
    	zStorage = "/sdcard-ext";
    	} else if(OS.contentEquals("2.3.5")) {
        zStorage = "/sdcard-ext";
    	} else if(OS.contentEquals("2.3.6")) {
        zStorage = "/sdcard-ext";
    	}  else {
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	}
    	appRun = true;
    	DataPart = "/dev/block/mmcblk0p07";
    	BootPart = "/dev/block/mmcblk0p11";
		SysPart = "/dev/block/mmcblk0p12";
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
	} 
    else if(Phone.contentEquals("sunfire")) //moto photon 4g
    {
    	appRun = true;
    	DataPart = "";
    	BootPart = "/dev/block/mmcblk0p11";
		SysPart = "/dev/block/mmcblk0p12";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    } 
    else if(Phone.contentEquals("triumph")) //moto triumph
    {
    	appRun = true;
    	BootPart = "dev/block/mmcblk0p5";
		SysPart = "/dev/block/mmcblk0p7";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    } 
    else if(Phone.contentEquals("WX435")) //moto triumph WX435
    {
    	appRun = true;
    	BootPart = "dev/block/mmcblk0p5";
		SysPart = "/dev/block/mmcblk0p7";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    } 
    else if(Phone.contentEquals("fb0")) //moto triumph fb0
    {
    	appRun = true;
    	BootPart = "dev/block/mmcblk0p5";
		SysPart = "/dev/block/mmcblk0p7";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    } 
    else if(Phone.contentEquals("umts_jordan")) //motorola defy
    {
    	secondInit = true;
    	appRun = true;
    	BootPart = "Not Supported";
    	SysPart = "/dev/block/mmcblk1p21";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: Currently disabled" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("cdma_droid2we")) //motorola droid 2 global
    {
    	secondInit = true;
    	appRun = true;
    	BootPart = "2ndInit";
    	SysPart = "/dev/block/mmcblk1p21";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: Currently disabled" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("cdma_solana")) //motorola droid 3
    {
    	secondInit = true;
    	appRun = true;
    	BootPart = "Not Supported";
    	SysPart = "/dev/block/mmcblk1p21";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: Currently disabled" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("p999")) //lg g2x
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p5";
    	SysPart = "/dev/block/mmcblk0p1";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("p990")) //lg o2x
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p5";
    	SysPart = "/dev/block/mmcblk0p1";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("p970")) //lg optimus black
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p3";
    	SysPart = "/dev/block/mmcblk0p8";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("ace")) //htc desire hd
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p22";
    	SysPart = "/dev/block/mmcblk0p25";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("pyramid")) //htc sensation
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p20";
    	SysPart = "/dev/block/mmcblk0p22";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("shooteru")) //htc evo 3d
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p20";
    	SysPart = "/dev/block/mmcblk0p22";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("ruby")) //htc amaze 4g
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p20";
    	SysPart = "/dev/block/mmcblk0p29";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("glacier")) //htc myTouch 4g
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p22";
    	SysPart = "/dev/block/mmcblk0p25";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("doubleshot")) //htc myTouch 4g slide
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p20";
    	SysPart = "/dev/block/mmcblk0p22";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("vivow")) //htc droid incredible 2 
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p22";
    	SysPart = "/dev/block/mmcblk0p25";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("galaxys2")) //samsung s2
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p5";
    	SysPart = "/dev/block/mmcblk0p9";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("GT-I9100")) //samsung s2 (910 variant)
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p5";
    	SysPart = "/dev/block/mmcblk0p9";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("GT-I9100M")) //samsung s2 (910m variant)
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p5";
    	SysPart = "/dev/block/mmcblk0p9";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("GT-I9100T")) //samsung s2 (910t variant)
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p5";
    	SysPart = "/dev/block/mmcblk0p9";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("SGH-I777")) //att samsung s2
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p5";
    	SysPart = "/dev/block/mmcblk0p9";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("galaxys2att")) //att samsung s2
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p5";
    	SysPart = "/dev/block/mmcblk0p9";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("SGH-I727")) //att samsung s2 skyrocket
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p08";
    	SysPart = "/dev/block/mmcblk0p24";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("SGH-T989")) //tmo samsung s2
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p08";
    	SysPart = "/dev/block/mmcblk0p24";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("hercules")) //tmo samsung s2
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p08";
    	SysPart = "/dev/block/mmcblk0p24";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("crespo")) //tmo samsung nexus s
    {
    	appRun = true;
    	BootPart = "/dev/block/platform/s3c-sdhci.0/by-name/boot";
    	SysPart = "/dev/block/platform/s3c-sdhci.0/by-name/system";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("crespo4g")) //sprint samsung nexus s
    {
    	appRun = true;
    	BootPart = "/dev/block/platform/s3c-sdhci.0/by-name/boot";
    	SysPart = "/dev/block/platform/s3c-sdhci.0/by-name/system";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("toro")) //samsung cdma galaxy nexus
    {
    	appRun = true;
    	BootPart = "/dev/block/platform/omap/omap_hsmmc.0/by-name/boot";
    	SysPart = "/dev/block/platform/omap/omap_hsmmc.0/by-name/system";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("maguro")) //samsung gsm galaxy nexus
    {
    	appRun = true;
    	BootPart = "/dev/block/platform/omap/omap_hsmmc.0/by-name/boot";
    	SysPart = "/dev/block/platform/omap/omap_hsmmc.0/by-name/system";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    } 
    // tablets
    else if(Phone.contentEquals("wingray")) // moto xoom	
    {
    	appRun = true;
    	BootPart = "/dev/block/platform/sdhci-tegra.3/by-name/boot";
    	SysPart = "/dev/block/platform/sdhci-tegra.3/by-name/system";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("stingray")) // moto xoom
    {
    	appRun = true;
    	BootPart = "/dev/block/platform/sdhci-tegra.3/by-name/boot";
    	SysPart = "/dev/block/platform/sdhci-tegra.3/by-name/system";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("p4wifi")) // samsung galaxy tab 10.1 wifi
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p3";
    	SysPart = "/dev/block/mmcblk0p4";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else if(Phone.contentEquals("p7510")) // samsung galaxy tab 10.1v 
    {
    	appRun = true;
    	BootPart = "/dev/block/mmcblk0p3";
    	SysPart = "/dev/block/mmcblk0p4";
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: true" + " " + BootPart + " " + SysPart);
    }
    else {
    	appRun = false;
    	zStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    	Log.v("FCM", "SetIt: false"); 
    	}
}
public boolean secondInit(){
	
	return secondInit;
}
public String Storage(){
	String Store = zStorage;
	return Store;
}
public String Boot(){
	String Boot = BootPart;
	return Boot;
}
public String System(){
	String System = SysPart;
	return System;
}
public boolean Run(){
	boolean Run = appRun;
	return Run;
}
public String Phone(){

	return Phone;
}
public String OS(){

	return OS;
}
}
