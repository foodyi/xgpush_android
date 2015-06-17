package com.foodyi.ane.xgpush;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.foodyi.ane.functions.AddLocalNotificationFunction;
import com.foodyi.ane.functions.ClearLocalNotificationFunction;
import com.foodyi.ane.functions.DeleteTagFunction;
import com.foodyi.ane.functions.RegisterPushFunction;
import com.foodyi.ane.functions.SetTagFunction;
import com.foodyi.ane.functions.UnRegisterPushFunction;

public class XGPushExtensionContext extends FREContext {
	
	public static final String TAG = "XGPushExtensionContext";

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String,FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put(RegisterPushFunction.TAG, new RegisterPushFunction());
		functions.put(UnRegisterPushFunction.TAG, new UnRegisterPushFunction());
		functions.put(DeleteTagFunction.TAG, new DeleteTagFunction());
		functions.put(SetTagFunction.TAG, new SetTagFunction());
		functions.put(AddLocalNotificationFunction.TAG,new AddLocalNotificationFunction());
		functions.put(ClearLocalNotificationFunction.TAG,new ClearLocalNotificationFunction());
		return functions;
	}
	
}
