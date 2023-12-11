import java.util.ArrayList;

public class Pengguna {
    private ArrayList<String> username = new ArrayList<String>();
    private ArrayList<String> password = new ArrayList<String>();

    public Pengguna() {
        this.username.add("user");
        this.password.add("user");
    }

    public boolean autentikasi(String username, String password) {
        int index = this.username.indexOf(username);
        if (index != -1) {
            String inputPassword = this.password.get(index);
            return inputPassword.equals(password);
        }
        return false;
    }

}
