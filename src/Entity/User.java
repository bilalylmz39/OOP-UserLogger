package Entity;

public class User implements UserEntity{
    private int id;
    private String fullName;
    private String mail;
    private String password;

    public User() {

    }

    public User(int id,String fullName, String mail, String password) {
        this.id = id;
        this.fullName = fullName;
        this.mail = mail;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
