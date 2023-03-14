package helpdesk.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    // Apsirašomi validacijos šablonai pgal kuruos tikrinsime vartotojo įestus duomenis
    public static final String USERNAME_REGEX_PATTERN = "^[a-zA-Z0-9]{5,13}$";
    public static final String PASSWORD_REGEX_PATTERN = "^[a-zA-Z-0-9!@#$%]{5,13}$";
    public static final String USER_EMAIL_REGEX_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,50}$";

    /**
     * Funkcija tikrinanati ar varototjo įvesti duoemnys prisijungimo vardui atitinka validacijos šabloną
     * @param username vartotojo įvestas prisijungimo vardas
     * @return true - jeigu vartotojo įvestas vardas atitinka šabloną, false - priešingu atveju
     */
    public static boolean isValidUsername(String username) {
        // Pagal 7 eilutes apsirašytą šabloną sukuriamas sukuriamos taisyklės
        Pattern pattern = Pattern.compile(USERNAME_REGEX_PATTERN);
        // Vartotojo įvestas prisijungimo vardas palyginamas su aukščiau sukurtom taisyklėm
        Matcher matcher = pattern.matcher(username);
        // true - jeigu vartotojo įvestas vardas atitinka šabloną, false - priešingu atveju
        return matcher.find();
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile(USER_EMAIL_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
