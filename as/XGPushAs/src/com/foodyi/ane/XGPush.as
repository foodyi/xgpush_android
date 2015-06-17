package com.foodyi.ane
{
    import flash.events.EventDispatcher;
    import flash.events.StatusEvent;
    import flash.external.ExtensionContext;

    public class XGPush extends EventDispatcher
    {
        private static var _instance:XGPush;
        private var extCtx:ExtensionContext;
        
        public function XGPush( p:PrivateClass)
        {
            if( _instance == null ){
               
                _instance = this;
            }else
            {
                throw Error("This is a singleton,use getInstance,do not call the constructor directly");	
            }
        }
        
        public static function getInstance():XGPush{
            return _instance ? _instance : new XGPush(new PrivateClass());
        }
        
        /**
         *创建ane环境 
         * 
         */        
        public function create():void{
            extCtx = ExtensionContext.createExtensionContext("com.foodyi.ane.XGPush",null);
            if( extCtx )
            {
                extCtx.addEventListener( StatusEvent.STATUS,onStatus );
            }
        }
        
//        /**
//         * 当前ANE是否可以通信 
//         * @return 
//         * 
//         */        
//        public function isSupported():Boolean{
//            return extCtx.call("isSupported") as Boolean;
//        }
        
        /**
         * 初始化信鸽
         * @param appId - 通过前台申请的应用ID
         * @param appKey - 通过前台申请的appKey
         * @return none
         */
        public function registerPush():void{
            extCtx.call("RegisterPushFunction");
        }
        
        /**
         * 设置tag
         * @param tag - 需要设置的tag
         * @return none
         */
        public function setTag(tag:String):void{
            extCtx.call("SetTagFunction",tag);
        }
        
        /**
         * 删除tag
         * @param tag - 需要删除的tag
         * @return none
         */
        public function delTag(tag:String):void{
            extCtx.call("DeleteTagFunction",tag);
        }
        
        /**
         * 注销设备 
         * 
         */        
        public function unRegisterPush():void{
            extCtx.call("UnRegisterPushFunction");
        }
        
        public function addLocalNotification(title:String,content:String,date:String,hour:String,min:String):void{
            extCtx.call("AddLocalNotificationFunction",title,content,date,hour,min);
        }
        
        public function clearLocalNotification():void{
            extCtx.call("ClearLocalNotificationFunction");
        }
         
        private function onStatus(e:StatusEvent):void 
        {
            var event : XGPushEvent;
            var data:String = e.level;
            switch (e.code)
            {
                case "TOKEN_SUCCESS":
                    event = new XGPushEvent( XGPushEvent.PERMISSION_GIVEN_WITH_TOKEN_EVENT );
                    event.token = e.level;
                    trace("TOKEN_SUCCESS",event.token);
                    break;
                case "TOKEN_FAIL":
                    event = new XGPushEvent( XGPushEvent.PERMISSION_REFUSED_EVENT );
                    event.errorCode = "NativeCodeError";
                    event.errorMessage = e.level;
                    trace("TOKEN_FAIL",event.errorMessage);
                    break;
//                case "COMING_FROM_NOTIFICATION":
//                    event = new PushNotificationEvent( PushNotificationEvent.COMING_FROM_NOTIFICATION_EVENT );
//                    if (data != null)
//                    {
//                        try
//                        {
//                            event.parameters = JSON.parse(data);
//                        } catch (error:Error)
//                        {
//                            trace("[PushNotification Error]", "cannot parse the params string", data);
//                        }
//                    }
//                    break;
//                case "APP_STARTING_FROM_NOTIFICATION":
//                    event = new PushNotificationEvent( PushNotificationEvent.APP_STARTING_FROM_NOTIFICATION_EVENT );
//                    if (data != null)
//                    {
//                        try
//                        {
//                            event.parameters = JSON.parse(data);
//                        } catch (error:Error)
//                        {
//                            trace("[PushNotification Error]", "cannot parse the params string", data);
//                        }
//                    }
//                    break;
//                case "APP_BROUGHT_TO_FOREGROUND_FROM_NOTIFICATION":
//                    event = new PushNotificationEvent( PushNotificationEvent.APP_BROUGHT_TO_FOREGROUND_FROM_NOTIFICATION_EVENT );
//                    if (data != null)
//                    {
//                        try
//                        {
//                            event.parameters = JSON.parse(data);
//                        } catch (error:Error)
//                        {
//                            trace("[PushNotification Error]", "cannot parse the params string", data);
//                        }
//                    }
//                    break;
//                case "APP_STARTED_IN_BACKGROUND_FROM_NOTIFICATION": //app start in background
//                    event = new PushNotificationEvent( PushNotificationEvent.APP_STARTED_IN_BACKGROUND_FROM_NOTIFICATION_EVENT );
//                    if (data != null)
//                    {
//                        try
//                        {
//                            event.parameters = JSON.parse(data);
//                        } catch (error:Error)
//                        {
//                            trace("[PushNotification Error]", "cannot parse the params string", data);
//                        }
//                    }
//                    break;
//                case "NOTIFICATION_RECEIVED_WHEN_IN_FOREGROUND":
//                    event = new PushNotificationEvent( PushNotificationEvent.NOTIFICATION_RECEIVED_WHEN_IN_FOREGROUND_EVENT );
//                    if (data != null)
//                    {
//                        try
//                        {
//                            event.parameters = JSON.parse(data);
//                        } catch (error:Error)
//                        {
//                            trace("[PushNotification Error]", "cannot parse the params string", data);
//                        }
//                    }
//                    break;
//                case "LOGGING":
//                    trace(e, e.level);
//                    break;
            }
            
            if (event != null)
            {
                this.dispatchEvent( event );
            }				
        }
    }
}

internal class PrivateClass{
    
}