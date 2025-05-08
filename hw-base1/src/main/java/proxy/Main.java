package proxy;

import proxy.jdk.JdkProxy;

public class Main {

    public static void main(String[] args) {
        UserService target = new UserServiceImpl();

        UserService proxy = JdkProxy.getProxy(target);
        proxy.saveUser("xh");
    }

}
