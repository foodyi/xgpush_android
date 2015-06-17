package
{
    import com.bit101.components.PushButton;
    import com.foodyi.ane.XGPush;
    import com.foodyi.ane.XGPushEvent;
    
    import flash.display.Sprite;
    import flash.events.Event;
    import flash.events.MouseEvent;
    import flash.utils.setTimeout;

    public class XGPushAndroidDemo extends Sprite
    {
        public function XGPushAndroidDemo()
        {
            super();
            var btn:PushButton = new PushButton(this,100,100,"register",onRegisterHandler);
            var setTagBtn:PushButton = new PushButton(this,100,200,"setTag",onSetTagHandler);
            var delTagBtn:PushButton = new PushButton(this,100,300,"delTag",onDelTagHandler);
            var addBtn:PushButton = new PushButton(this,100,400,"delTag",addLocalHandler);

        }
        
        private function onRegisterHandler(evt:MouseEvent):void{
            XGPush.getInstance().create();
            XGPush.getInstance().registerPush();
            //XGPush.getInstance().registerPush();
        }
        
        private function onSetTagHandler(e:MouseEvent):void{
            XGPush.getInstance().setTag("test");
        }
        
        
        private function onDelTagHandler(e:MouseEvent):void{
            XGPush.getInstance().delTag("test");
        }
        
        private function addLocalHandler(e:MouseEvent):void{
//            var now:Date = new Date();
            XGPush.getInstance().addLocalNotification("本地通知","测试一下","20150617","15","18");
        }
        
        
        
    }
}