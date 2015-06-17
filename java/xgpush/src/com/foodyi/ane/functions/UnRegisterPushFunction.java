package com.foodyi.ane.functions;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;

public class UnRegisterPushFunction implements FREFunction {

	public static String TAG = "UnRegisterPushFunction";
	
	@Override
	public FREObject call(FREContext context, FREObject[] object) {
		
		XGPushManager.unregisterPush(context.getActivity().getApplicationContext(),new XGIOperateCallback(){

			@Override
			public void onFail(Object data, int errCode, String msg) {
				// TODO Auto-generated method stub
				//context.dispatchStatusEventAsync(arg0, arg1);
				Log.e(TAG,
						"+++ unregisterPush push fail. token:" + data
								+ ", errCode:" + errCode + ",msg:"
								+ msg);
			}

			@Override
			public void onSuccess(Object data, int flag) {
				// TODO Auto-generated method stub
				Log.e(TAG, "+++ unregisterPush success");
			}
			
		});
		return null;
	}

}
