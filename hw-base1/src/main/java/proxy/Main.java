package proxy;

import org.springframework.cglib.proxy.Enhancer;
import proxy.cglib.UserServiceProxy;
import proxy.jdk.JdkProxy;

public class Main {

    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        UserService proxy = JdkProxy.getProxy(target);
        proxy.saveUser("xh");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class); // 设置父类
        enhancer.setCallback(new UserServiceProxy()); // 设置回调
        UserService cglib = (UserService) enhancer.create(); // 创建代理
        cglib.saveUser("李四"); // 调用代理方法

    }

}
