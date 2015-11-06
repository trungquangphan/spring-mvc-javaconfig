package standalone.annotation;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by doomphantom on 06/11/2015.
 */
public class PushNotificatoinAnnotationProcessor implements SmartInitializingSingleton, ApplicationContextAware {

    private ConfigurableApplicationContext applicationContext;
    private final Set<Class<?>> nonAnnotatedClasses =
            Collections.newSetFromMap(new ConcurrentHashMap<Class<?>, Boolean>(64));

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Assert.isTrue(applicationContext instanceof ConfigurableApplicationContext, "This applicationContext doesn't support ConfigurableApplicationContext");
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    @Override
    public void afterSingletonsInstantiated() {
        String[] allBeanNames = this.applicationContext.getBeanNamesForType(Object.class);
        for (String beanName : allBeanNames) {
            if (!ScopedProxyUtils.isScopedTarget(beanName)) {
                Class<?> type = this.applicationContext.getType(beanName);
                try {
                    processBean(beanName, type);
                } catch (Throwable ex) {
                    throw new BeanInitializationException("Failed to process @OperatingSystem " +
                            "annotation on bean with name '" + beanName + "'", ex);
                }
            }
        }
    }

    private void processBean(String beanName, Class<?> targetType) {
        if (this.nonAnnotatedClasses.contains(targetType)) {
            return;
        }
        final Set<Field> annotatedFields = new LinkedHashSet<Field>(1);
        Field[] fields = targetType.getFields();
        for (Field field : fields) {
            OperatingSystem operatingSystemAnnotation = field.getAnnotation(OperatingSystem.class);
            if (operatingSystemAnnotation == null){
                continue;
            }
            operatingSystemAnnotation.name();
        }
    }
}
