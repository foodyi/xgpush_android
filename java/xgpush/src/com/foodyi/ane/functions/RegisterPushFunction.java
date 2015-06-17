package com.foodyi.ane.functions;

//import android.content.pm.ApplicationInfo;
//import android.content.pm.PackageManager;
//import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.foodyi.ane.xgpush.XGPushExtension;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;

public class RegisterPushFunction implements FREFunction {

	public static final String TAG = "RegisterPushFunction";
	
	@Override
	public FREObject call(FREContext context, FREObject[] arg1) {
		XGPushManager.registerPush(context.getActivity().getApplicationContext(), new XGIOperateCallback() {
			
			@Override
			public void onSuccess(Object arg0, int arg1) {
				// TODO Auto-generated method stub
				Log.e(TAG, "=====================register push success token:  "+arg0);
				if( XGPushExtension.eContext != null){
					Log.e(TAG,"we get eContext in asncfunction");
				}
				XGPushExtension.eContext.dispatchStatusEventAsync("TOKEN_SUCCESS", (String)arg0);
			}
			
			@Override
			public void onFail(Object data, int errCode, String msg) {
				Log.e(TAG,
						"+++ register push fail. token:" + data
								+ ", errCode:" + errCode + ",msg:"
								+ msg);
			}
		});
		return null;
	}

}
