package com.foodyi.ane.xgpush;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

public class XGPushExtension implements FREExtension {

	public static final String TAG = "XGPushExtension";
	public static FREContext eContext;
	public static Context appContext;
	
	@Override
	public FREContext createContext(String arg0) {
		// TODO Auto-generated method stub
		eContext = new XGPushExtensionContext();
		return eContext;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		XGPushManager.unregisterPush(eContext.getActivity().getApplicationContext());
	}

	@Override
	public void initialize() {
		Log.d(TAG, "Extension initialized");
	}
	
}
