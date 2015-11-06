package standalone.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by doomphantom on 06/11/2015.
 */
@Target({ElementType.FIELD,
        ElementType.METHOD,
        ElementType.TYPE,
        ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperatingSystem {
    OperatingSystems name();

    enum OperatingSystems {
        IOS,
        ANDROID
    }
}
