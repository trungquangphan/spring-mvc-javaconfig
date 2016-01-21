package standalone.annotation;

/**
 * Created by doomphantom on 06/11/2015.
 */
public class SimplePushNotificationImpl implements PushNotification {
    private OperatingSystem.OperatingSystems system;
    public SimplePushNotificationImpl(OperatingSystem.OperatingSystems system){
        this.system=system;
    }
    @Override
    public String pushNotification() {
        return "invoke SimplePushNotificationImpl - return: "+system.name();
    }
}
