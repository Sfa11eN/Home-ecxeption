public class Main {
    private static final String Validation = "^[a-zA-Z0-9-_]+$";

    public static void main(String[] args) {
        System.out.println("Исключения");
        check("login","pass", "pass");
        check("loginloginloginloginlogin","pass", "pass");
        check("login","passpasspasspasspasspass", "pass");
        check("login","pass", "pass2");
        check("login%%%%%","pass", "pass");
        check("login","pass%%%%%", "pass");


    }

    private static void check(String login, String pass, String confirmPass) {
        try {
            checkLogin(login);
            checkPass(pass, confirmPass);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка с введенным логином: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка с введенным паролем" + e.getMessage());
        }

    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(Validation)) {
            throw new WrongLoginException("Логин должен содержать в себе только латинские буквы, цифры и знак подчеркивания.");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Логин не может быть длиннее 20 символов");
        }

    }

    private static void checkPass(String pass, String confirmPass) throws WrongLoginException, WrongPasswordException {
        if (!pass.matches(Validation)) {
            throw new WrongPasswordException("Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания.");
        }
        if (pass.length() > 20) {
            throw new WrongPasswordException("Пароль не может быть длиннее 20 символов");
        }
        if (!pass.equals(confirmPass)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }

    }
}

