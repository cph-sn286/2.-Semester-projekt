package business.entities;

public class User
{

    public User(int id, String email, String password, String role, String adresse, int postnr, int telefonnr) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.adresse = adresse;
        this.postnr = postnr;
        this.telefonnr = telefonnr;
    }

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private String adresse;
    private int postnr;
    private int telefonnr;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
