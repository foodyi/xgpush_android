package com.foodyi.ane.functions;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.tencent.android.tpush.XGLocalMessage;
import com.tencent.android.tpush.XGPushManager;

public class AddLocalNotificationFunction implements FREFunction {
	
	public static String TAG = "AddLocalNotificationFunction";
	
	@Override
	public FREObject call(FREContext context, FREObject[] arg) {
		// TODO Auto-generated method stub
		XGLocalMessage msg = new XGLocalMessage();
		try {
			String title = arg[0].getAsString();
			String content = arg[1].getAsString();
			String date = arg[2].getAsString();
			String hour = arg[3].getAsString();
			String min = arg[4].getAsString();
			
			Log.e(TAG,"+++title+++"+title);
			Log.e(TAG,"+++content+++"+content);
			Log.e(TAG,"+++date+++"+date);
			Log.e(TAG,"+++hour+++"+hour);
			Log.e(TAG,"+++min+++"+min);

			msg.setTitle(title);
			msg.setContent(content);
			msg.setDate(date);
			msg.setHour(hour);
			msg.setMin(min);
			XGPushManager.addLocalNotification(context.getActivity().getApplicationContext(),msg);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
