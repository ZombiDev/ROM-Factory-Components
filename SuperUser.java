// SamCripp's SuperUser Class v1.2 * By Samuel Rivera "SamCripp"
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
// SamCripp's SuperUser Class v1.2 - Original Author: Samuel Rivera "SamCripp"
//
// Thanks for following this simple rules.

package com.samcripp.fcm;

import java.io.DataOutputStream;
import java.io.IOException;
import android.content.Context;
import android.util.Log;

public class SuperUser {
	// variables and process
	Context context;
	Process user;
	// 
	// requesting root
	//
	public void requestSU(){ try { user = Runtime.getRuntime().exec("su\n"); Log.v("SU", "Resquesting SU"); }catch (IOException e){ Log.e("SU", e.getMessage()); }}
	//
	// send commands
	//
	public void cmdSU(String suCmd){
		DataOutputStream suShell = new DataOutputStream(user.getOutputStream());
		try{ 
			suShell.writeBytes(suCmd + "\n");
			Log.v("SU", "cmdSU: " + suCmd);
			suShell.writeBytes("wait\n");
			suShell.writeBytes("exit\n"); 
			suShell.flush();
			try { user.waitFor(); 
				if (user.exitValue() != 255) {  } else {  }
			} catch (InterruptedException e) { Log.e("SU", e.getMessage()); }
		} catch (IOException e) { Log.e("SU", e.getMessage()); }
	}
}
