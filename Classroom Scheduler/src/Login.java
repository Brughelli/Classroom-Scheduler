
public class Login {
  public static boolean authenticate(String username, String password) {
    // TODO authenticate through database
    String testUsername = "root";
    String testPassword = "toor";
    if(username.equals(testUsername) && password.equals(testPassword)) {
      return true;
    }
    return false;
  }
}
