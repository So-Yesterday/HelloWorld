package proxy.jdk;

import org.junit.jupiter.api.extension.InvocationInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private final Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法调用前增强...");
        Object result = method.invoke(target, args); // 调用目标方法
        System.out.println("方法调用后增强...");
        return result;
    }

    public static <T> T getProxy(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new JdkProxy(target));
    }
}
