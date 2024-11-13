public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //registrationAcc("rfe343_r");
        try {
            registrationAcc("jimmy_dve2", "wine_1", "wine_1");
        } catch (WrongLoginException | WrongPasswordException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("ok");
        }
    }

    public static void registrationAcc(String login, String password, String confirmPassword) {
        String regexLogin = "^[a-z0-9_]{1,20}$";
        String regexPassword = "^\\w{1,20}$";

        if (!login.matches(regexLogin)) {
            {
                throw new WrongLoginException("Некорректно набран логин");
            }
        }
        if (!password.matches(regexPassword) || !confirmPassword.matches(regexPassword)) {
            throw new WrongLoginException("Некорректно набран пароль");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongLoginException("Пароли отличаются друг от друга");
        }
    }
}