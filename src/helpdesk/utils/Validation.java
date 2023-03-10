package helpdesk.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    // Apsirašomi validacijos šablonai pagal kuriuos tikrinsime vartotojo įvestus duomenis
    public static final String USERNAME_REGEX_PATTERN = "^[a-zA-Z0-9]{5,13}$";
    public static final String PASSWORD_REGEX_PATTERN = "^[a-zA-Z0-9!@#$%]{5,13}$";

    /**
     * Funkcija tikrinanti ar vartotojo įvesti duomenys prisijungimo vardui atitinka validacijos šablona
     * @param username - Vartotojo įvestas prisijungimo vardas
     * @return true - Jeigu vartotojo įvestas vardas atitinka šablona, false - Priešingu atvėju
     */
    public static boolean isValidUsername(String username){
        // Pagal 7 eilutėje apsirašyta šabloną sukuriamos taisyklės (Naudojant biblioteka)
        Pattern pattern = Pattern.compile(USERNAME_REGEX_PATTERN);
        // Vartotojo įvestas prisijungimo vardas palyginamas su aukščiau sukurtom taisyklėm
        Matcher matcher = pattern.matcher(username);
        // true - Jeigu vartotojo įvestas vardas atitinka šablona, false - Priešingu atvėju
        return matcher.find();
    }

    public static boolean isValidPassword(String password){
        // Tas pats kaip isValidUsername funkcijoje
        Pattern pattern = Pattern.compile(PASSWORD_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }


}
