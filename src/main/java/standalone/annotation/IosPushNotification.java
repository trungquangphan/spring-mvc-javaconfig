package standalone.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by doomphantom on 06/11/2015.
 */
@Service
@Platform(name = Platform.OperatingSystems.IOS)
public class IosPushNotification implements PushNotification {
    @Override
    public String pushNotification() {
        return "IOS pushed a notification";
    }
}
