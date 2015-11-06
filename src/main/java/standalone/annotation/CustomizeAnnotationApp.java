package standalone.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by doomphantom on 06/11/2015.
 */
@Configuration
@ComponentScan
public class CustomizeAnnotationApp {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(CustomizeAnnotationApp.class);
    }

    @Autowired
    @Platform(name = Platform.OperatingSystems.ANDROID)
    private PushNotification androidPushNotification;

    @Autowired
    @Platform(name = Platform.OperatingSystems.IOS)
    private PushNotification iOsPushNotification;


    @PostConstruct
    public void checkResult() {
        System.out.println("androidPushNotification" + androidPushNotification.pushNotification());
        System.out.println("iOsPushNotification" + iOsPushNotification.pushNotification());
    }

}
