package proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserServiceProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglib方法调用前增强...");
        Object result = proxy.invokeSuper(obj, args); // 调用父类方法
        System.out.println("cglib方法调用后增强...");
        return result;
    }
}
