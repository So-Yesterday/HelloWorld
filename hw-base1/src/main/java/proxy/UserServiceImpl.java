package proxy;

public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(String username) {
        System.out.println("保存用户: " + username);
    }
}