public class Main {
    private static final String Validation = "^[a-zA-Z0-9-_]+$";

    public static void main(String[] args) {
        System.out.println("Исключения");

    }

    private static void check(String login, String pass, String confirmPass) {
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(Validation)) {
            throw new WrongLoginException("Логин должен содержать в себе только латинские буквы, цифры и знак подчеркивания.");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Логин не может быть длиннее 20 букв");
        }

    }
}

