package DataAccess;

import Entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoWithInformations implements UserDao{

    List<User> userList = new ArrayList<User>();
    @Override
    public void add(User user) {
        System.out.println("Kullanıcı kaydedildi : " + user.getFullName());
        userList.add(user);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {

        return userList;
    }

}
