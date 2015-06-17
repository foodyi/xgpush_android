package com.foodyi.ane.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.tencent.android.tpush.XGPushManager;

public class ClearLocalNotificationFunction implements FREFunction {

	public static String TAG = "ClearLocalNotificationFunction";
	
	@Override
	public FREObject call(FREContext context, FREObject[] arg) {
		// TODO Auto-generated method stub
		XGPushManager.clearLocalNotifications(context.getActivity().getApplicationContext());
		return null;
	}

}
