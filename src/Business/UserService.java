package Business;

import Core.GoogleUserInfoService;
import Entity.User;

import java.util.List;

public interface UserService {

    public void add(User user);

    public void delete(User user);

    public void update(User user);

    public void registerWithGoogle(GoogleUserInfoService info);

    public void login();

    public User getUser(int id);

    public void getAll();

}
