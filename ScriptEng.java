// Script Engine v0.6 * By Samuel Rivera "SamCripp"
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
// Script Engine v0.6 - Original Author: Samuel Rivera "SamCripp"
//
// Thanks for following this simple rules.

package com.samcripp.fcm;

import android.util.Log;

public class ScriptEng {
	String SEVersion = new String("--Script Engine v0.6");
	String boot = new String();
	String system = new String();
	String os = new String();
	String romName = new String();
	String devName = new String();
	String device = new String();
	String formatType = new String();
	boolean SndInit = false;
	boolean NormalM = false;
	boolean AdvMode = false;
	boolean AppMode = false;
	boolean backupMode = false;
	String TheScript = new String();

	
public ScriptEng(String bootL, String sysL, String dev, String rom, String dOs, String dName, boolean Init, boolean adv, boolean app, boolean backup){
	boot = bootL;
	system = sysL;
	romName = rom;
	devName = dev;
	os = dOs;
	device = dName;
	SndInit = Init;
	AdvMode = adv;
	AppMode = app;
	backupMode = backup;
}

public void Make(){
	String action = new String("Creating Script | ");
	
	String formatS = new String();
	String mountS = new String();
	
	String sym = "\"";
	String beginCmd = "(";
	String endCmd = ") > ";
	String echo = "echo "+ sym;
	String and = " && ";
	String pend = ");" + sym;
	String prog = "show_progress(";
	String sprog = "set_progress(";
	String ui_print = "ui_print(\\" + sym;
	String ui_end = "\\" + sym + ");"+ sym;
	String warning = "--This script is generated automatically--";
	String line = "- - - - - - - - - - - - - - - - - - - - - - -";
	String pkgexb = "package_extract_file(\\" + sym + "/boot.img" + "\\" + sym + "," + "\\" + sym + boot + "\\" + sym + ");" + sym;
	String pkgexs = "package_extract_file(\\" + sym + "/system.img" + "\\" + sym + "," + "\\" + sym + system + "\\" + sym + ");" + sym;
	String fdlexs = "package_extract_dir(\\" + sym + "system" + "\\" + sym + "," + "\\" + sym + "/system" + "\\" + sym + ");" + sym;
	String fdlexaa = "package_extract_dir(\\" + sym + "apps" + "\\" + sym + "," + "\\" + sym + "/tmp/apps" + "\\" + sym + ");" + sym;
	String fdlexdd = "package_extract_dir(\\" + sym + "data" + "\\" + sym + "," + "\\" + sym + "/tmp/data" + "\\" + sym + ");" + sym;
	String fdlexa = "run_program(\\" + sym + "/system/xbin/busybox" + "\\" + sym + ", " + "\\" + sym + "cp -R" + "\\" + sym + ", " + "\\" + sym + "/tmp/apps" +", " + "\\" + sym +  "/data/app" + "\\" + sym + ");" + sym;
	String busymount = "run_program(\\" + sym + "/system/xbin/busybox" + "\\" + sym + ", " + "\\" + sym + "mount" + "\\" + sym + ", " + "\\" + sym + "/data" + "\\" + sym + ");" + sym;
	String busydata = "run_program(\\" + sym + "/system/xbin/busybox" + "\\" + sym + ", " + "\\" + sym + "cp -R" + "\\" + sym + ", " + "\\" + sym + "/tmp/data" +", " + "\\" + sym +  "/data" + "\\" + sym + ");" + sym;
	
	String umountS = "unmount(\\" + sym + "/system" + "\\" + sym + ");" + sym;
	
	if(formatType == "ext4"){
		formatS = "format(\\" + sym + "ext4" + "\\" + sym + "," + "\\" + sym + "EMMC" + "\\" + sym + "," + "\\" + sym + system + "\\" + sym + ");" + sym;
		mountS = "mount(\\" + sym + "ext4" + "\\" + sym + "," + "\\" + sym + "EMMC" + "\\" + sym + "," + "\\" + sym + system + "\\" + sym + "," + "\\" + sym + "/system" + "\\" + sym + ");" + sym;
	} else if(formatType == "yaffs"){
		formatS = "format(\\" + sym;
	}else{
		formatS = "format(\\" + sym + "ext3" + "\\" + sym + "," + "\\" + sym + "EMMC" + "\\" + sym + "," + "\\" + sym + system + "\\" + sym + ");" + sym;
		mountS = "mount(\\" + sym + "ext3" + "\\" + sym + "," + "\\" + sym + "EMMC" + "\\" + sym + "," + "\\" + sym + system + "\\" + sym + "," + "\\" + sym + "/system" + "\\" + sym + ");" + sym;
	}
	
	if(SndInit == true){
		NormalM = false;
	}else{
		NormalM = true;
	}

	if(NormalM == true && SndInit == false && AdvMode == false && AppMode == false){
		Log.v("Script Engine", action + "NM: " + NormalM + " SI: " + SndInit + " AdvM: " + AdvMode + " AppM: " + AppMode);
		// good old normal phone
		TheScript = beginCmd + echo + prog + "1.000000, 0" + pend + and + echo + ui_print + warning + ui_end 
				+ and + echo + ui_print + SEVersion + ui_end + and + echo + ui_print + "--Rom Name: "+ romName + ui_end
				+ and + echo + ui_print + "--Rom Developer: " + devName + ui_end + and + echo + ui_print
				+ "--Rom Base: " + os + ui_end + and + echo + ui_print + "--Device Name: " + device + ui_end
				+ and + echo + ui_print + line + ui_end + and + echo + ui_print + "--Installing Boot" + ui_end 
				+ and + echo + sprog + "0.300000" + pend + and + echo + pkgexb 
				+ and + echo + ui_print + "--Installing System" + ui_end 
				+ and + echo + sprog + "0.650000" + pend + and + echo + pkgexs + and + echo + ui_print + line 
				+ ui_end + and + echo + ui_print + "--Don't forget to format data and cache" + ui_end 
				+ and + echo + sprog + "1.000000" + pend + endCmd;

	} if(NormalM == false && SndInit == true && AdvMode == false && AppMode == false){
		Log.v("Script Engine", action + "NM: " + NormalM + " SI: " + SndInit + " AdvM: " + AdvMode + " AppM: " + AppMode);
		// normal second init
	TheScript = beginCmd + echo + prog + "1.000000, 0" + pend + and + echo + ui_print + warning + ui_end 
			+ and + echo + ui_print + SEVersion + ui_end + and + echo + ui_print + "--Rom Name: "+ romName + ui_end
			+ and + echo + ui_print + "--Rom Developer: " + devName + ui_end + and + echo + ui_print
			+ "--Rom Base: " + os + ui_end + and + echo + ui_print + "--Device Name: " + device + ui_end
			+ and + echo + ui_print + line + ui_end + and + echo + ui_print + "--Installing System" + ui_end 
			+ and + echo + sprog + "0.650000" + pend + and + echo + pkgexs + and + echo + ui_print + line 
			+ ui_end + and + echo + ui_print + "--Don't forget to format data and cache" + ui_end 
			+ and + echo + sprog + "1.000000" + pend + endCmd;
	} if(NormalM == true && SndInit == false && AdvMode == true && AppMode == false && backupMode == false){
		Log.v("Script Engine", action + "NM: " + NormalM + " SI: " + SndInit + " AdvM: " + AdvMode + " AppM: " + AppMode);
		// normal device with advance mode
		TheScript = beginCmd + echo + prog + "1.000000, 0" + pend + and + echo + ui_print + warning + ui_end 
				+ and + echo + ui_print + SEVersion + ui_end + and + echo + ui_print + "--Rom Name: "+ romName + ui_end
				+ and + echo + ui_print + "--Rom Developer: " + devName + ui_end + and + echo + ui_print
				+ "--Rom Base: " + os + ui_end + and + echo + ui_print + "--Device Name: " + device + ui_end
				+ and + echo + ui_print + line + ui_end + and + echo + ui_print + "--Installing Boot" + ui_end 
				+ and + echo + sprog + "0.300000" + pend + and + echo + pkgexb 
				+ and + echo + ui_print + "--Formating System" + ui_end 
				+ and + echo + sprog + "0.550000" + pend + and + echo + formatS
				+ and + echo + ui_print + "--Installing System" + ui_end
				+ and + echo + sprog + "0.600000" + pend + and + echo + pkgexs
				+ and + echo + ui_print + "--Mounting System" + ui_end 
				+ and + echo + sprog + "0.900000" + pend + and + echo + mountS
				+ and + echo + ui_print + "--Extracting System Mods" + ui_end 
				+ and + echo + sprog + "0.950000" + pend + and + echo + fdlexs 
				+ and + echo + ui_print + "--UnMounting System" + ui_end 
				+ and + echo + sprog + "0.990000" + pend + and + echo + umountS
				+ and + echo + ui_print + line 
				+ ui_end + and + echo + ui_print + "--Don't forget to format data and cache" + ui_end 
				+ and + echo + sprog + "1.000000" + pend + endCmd;
	} if(NormalM == false && SndInit == true && AdvMode == true && AppMode == false && backupMode == false){
		Log.v("Script Engine", action + "NM: " + NormalM + " SI: " + SndInit + " AdvM: " + AdvMode + " AppM: " + AppMode);
		// second init device with advance mode
		TheScript = beginCmd + echo + prog + "1.000000, 0" + pend + and + echo + ui_print + warning + ui_end 
				+ and + echo + ui_print + SEVersion + ui_end + and + echo + ui_print + "--Rom Name: "+ romName + ui_end
				+ and + echo + ui_print + "--Rom Developer: " + devName + ui_end + and + echo + ui_print
				+ "--Rom Base: " + os + ui_end + and + echo + ui_print + "--Device Name: " + device + ui_end
				+ and + echo + ui_print + line + ui_end + and + echo + ui_print + "--Formating System" + ui_end 
				+ and + echo + sprog + "0.550000" + pend + and + echo + formatS
				+ and + echo + ui_print + "--Installing System" + ui_end
				+ and + echo + sprog + "0.600000" + pend + and + echo + pkgexs
				+ and + echo + ui_print + "--Mounting System" + ui_end 
				+ and + echo + sprog + "0.900000" + pend + and + echo + mountS
				+ and + echo + ui_print + "--Extracting System Mods" + ui_end 
				+ and + echo + sprog + "0.950000" + pend + and + echo + fdlexs 
				+ and + echo + ui_print + "--UnMounting System" + ui_end 
				+ and + echo + sprog + "0.990000" + pend + and + echo + umountS
				+ and + echo + ui_print + line 
				+ ui_end + and + echo + ui_print + "--Don't forget to format data and cache" + ui_end 
				+ and + echo + sprog + "1.000000" + pend + endCmd;
	} if(NormalM == true && SndInit == false && AdvMode == false && AppMode == true && backupMode == false){
		Log.v("Script Engine", action + "NM: " + NormalM + " SI: " + SndInit + " AdvM: " + AdvMode + " AppM: " + AppMode);
		// normal device with apps mode
		TheScript = beginCmd + echo + prog + "1.000000, 0" + pend + and + echo + ui_print + warning + ui_end 
				+ and + echo + ui_print + SEVersion + ui_end + and + echo + ui_print + "--Rom Name: "+ romName + ui_end
				+ and + echo + ui_print + "--Rom Developer: " + devName + ui_end + and + echo + ui_print
				+ "--Rom Base: " + os + ui_end + and + echo + ui_print + "--Device Name: " + device + ui_end
				+ and + echo + ui_print + line + ui_end + and + echo + ui_print + "--Installing Boot" + ui_end 
				+ and + echo + sprog + "0.300000" + pend + and + echo + pkgexb 
				+ and + echo + ui_print + "--Formating System" + ui_end 
				+ and + echo + sprog + "0.550000" + pend + and + echo + formatS
				+ and + echo + ui_print + "--Installing System" + ui_end
				+ and + echo + sprog + "0.600000" + pend + and + echo + pkgexs
				+ and + echo + ui_print + "--Mounting System" + ui_end 
				+ and + echo + sprog + "0.900000" + pend + and + echo + mountS
				+ and + echo + ui_print + "--Extracting Apps" + ui_end 
				+ and + echo + sprog + "0.930000" + pend + and + echo + fdlexaa 
				+ and + echo + sprog + "0.950000" + pend + and + echo + fdlexa 
				+ and + echo + ui_print + "--UnMounting System" + ui_end 
				+ and + echo + sprog + "0.990000" + pend + and + echo + umountS
				+ and + echo + ui_print + line 
				+ ui_end + and + echo + ui_print + "--Don't forget to format data and cache" + ui_end 
				+ and + echo + sprog + "1.000000" + pend + endCmd;
	} if(NormalM == false && SndInit == true && AdvMode == false && AppMode == true && backupMode == false){
		Log.v("Script Engine", action + "NM: " + NormalM + " SI: " + SndInit + " AdvM: " + AdvMode + " AppM: " + AppMode);
		// second init device with apps mode
		TheScript = beginCmd + echo + prog + "1.000000, 0" + pend + and + echo + ui_print + warning + ui_end 
				+ and + echo + ui_print + SEVersion + ui_end + and + echo + ui_print + "--Rom Name: "+ romName + ui_end
				+ and + echo + ui_print + "--Rom Developer: " + devName + ui_end + and + echo + ui_print
				+ "--Rom Base: " + os + ui_end + and + echo + ui_print + "--Device Name: " + device + ui_end
				+ and + echo + ui_print + line + ui_end + and + echo + ui_print + "--Formating System" + ui_end 
				+ and + echo + sprog + "0.550000" + pend + and + echo + formatS
				+ and + echo + ui_print + "--Installing System" + ui_end
				+ and + echo + sprog + "0.600000" + pend + and + echo + pkgexs
				+ and + echo + ui_print + "--Mounting System" + ui_end 
				+ and + echo + sprog + "0.900000" + pend + and + echo + mountS
				+ and + echo + ui_print + "--Extracting Apps" + ui_end 
				+ and + echo + sprog + "0.930000" + pend + and + echo + fdlexaa 
				+ and + echo + sprog + "0.950000" + pend + and + echo + fdlexa 
				+ and + echo + ui_print + "--UnMounting System" + ui_end 
				+ and + echo + sprog + "0.990000" + pend + and + echo + umountS
				+ and + echo + ui_print + line 
				+ ui_end + and + echo + ui_print + "--Don't forget to format data and cache" + ui_end 
				+ and + echo + sprog + "1.000000" + pend + endCmd;
	} if(NormalM == true && SndInit == false && AdvMode == false && AppMode == false && backupMode == true){
		Log.v("Script Engine", action + "NM: " + NormalM + " SI: " + SndInit + " AdvM: " + AdvMode + " AppM: " + AppMode);
		// normal device with back up mode
		TheScript = beginCmd + echo + prog + "1.000000, 0" + pend + and + echo + ui_print + warning + ui_end
				+ and + echo + ui_print + SEVersion + ui_end + and + echo + ui_print + "--Rom Name: "+ romName + ui_end
				+ and + echo + ui_print + "--Rom Developer: " + devName + ui_end + and + echo + ui_print
				+ "--Rom Base: " + os + ui_end + and + echo + ui_print + "--Device Name: " + device + ui_end
				+ and + echo + ui_print + line + ui_end + and + echo + ui_print + "--Installing Boot" + ui_end
				+ and + echo + sprog + "0.300000" + pend + and + echo + pkgexb
				+ and + echo + ui_print + "--Formating System" + ui_end
				+ and + echo + sprog + "0.550000" + pend + and + echo + formatS
				+ and + echo + ui_print + "--Installing System" + ui_end
				+ and + echo + sprog + "0.600000" + pend + and + echo + pkgexs
				+ and + echo + ui_print + "--Mounting Data" + ui_end
				+ and + echo + sprog + "0.900000" + pend + and + echo + busymount
				+ and + echo + ui_print + "--Extracting Back Up" + ui_end
				+ and + echo + sprog + "0.930000" + pend + and + echo + fdlexdd 
				+ and + echo + sprog + "0.950000" + pend + and + echo + busydata
				+ and + echo + ui_print + line
				+ ui_end + and + echo + ui_print + "--Don't forget to format data and cache" + ui_end
				+ and + echo + sprog + "1.000000" + pend + endCmd;
	} if(NormalM == false && SndInit == true && AdvMode == false && AppMode == false && backupMode == true){
		Log.v("Script Engine", action + "NM: " + NormalM + " SI: " + SndInit + " AdvM: " + AdvMode + " AppM: " + AppMode);
		// second init device with apps mode
		TheScript = beginCmd + echo + prog + "1.000000, 0" + pend + and + echo + ui_print + warning + ui_end
				+ and + echo + ui_print + SEVersion + ui_end + and + echo + ui_print + "--Rom Name: "+ romName + ui_end
				+ and + echo + ui_print + "--Rom Developer: " + devName + ui_end + and + echo + ui_print
				+ "--Rom Base: " + os + ui_end + and + echo + ui_print + "--Device Name: " + device + ui_end
				+ and + echo + ui_print + line + ui_end + and + echo + ui_print + "--Formating System" + ui_end
				+ and + echo + sprog + "0.550000" + pend + and + echo + formatS
				+ and + echo + ui_print + "--Installing System" + ui_end
				+ and + echo + sprog + "0.600000" + pend + and + echo + pkgexs
				+ and + echo + ui_print + "--Mounting Data" + ui_end
				+ and + echo + sprog + "0.900000" + pend + and + echo + busymount
				+ and + echo + ui_print + "--Extracting Back Up" + ui_end
				+ and + echo + sprog + "0.930000" + pend + and + echo + fdlexdd 
				+ and + echo + sprog + "0.950000" + pend + and + echo + busydata
				+ and + echo + ui_print + line
				+ ui_end + and + echo + ui_print + "--Don't forget to format data and cache" + ui_end
				+ and + echo + sprog + "1.000000" + pend + endCmd;
	}
}
public String Script(){
	return TheScript;
}
}
