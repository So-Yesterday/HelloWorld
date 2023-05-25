package annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationUtils {

    public static List<String> headData(Class<?> aClass) {
        List<String> heads = new ArrayList<>();

        if (aClass == null) {
            return heads;
        }

        List<Class<?>> classList = new ArrayList<>();
        classList.add(aClass);
        if (aClass.getSuperclass() != null) {
            classList.add(aClass.getSuperclass());
        }

        for (Class<?> aClass1 : classList) {
            // 获取public+父类public aClass1.getFields();
            // 获取本类所有字段
            Field[] declaredFields = aClass1.getDeclaredFields();

            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                Header annotation = declaredField.getAnnotation(Header.class);
                if (annotation != null) {
                    heads.add(annotation.value());
                }
            }
        }
        return heads;
    }

}
