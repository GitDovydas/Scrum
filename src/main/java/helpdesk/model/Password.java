package helpdesk.model;

public class Password {

    private static int workLoad = 12;

    /**
     * Funkcija užšifruojanti vartotojo įvestą slaptažodį
     * @param passwordPlainText - Vartotojo įvestas slaptažodis
     * @return - Gražina užšifruota slaptažodį (su druska)
     */

    public static String hashPasswWord(String passwordPlainText){
        // Papildoma druksa prie slaptazodzio
        String salt = BCrypt.gensalt(workLoad);
        String hashedPassword = BCrypt.hashpw(passwordPlainText, salt);
        return hashedPassword;
    }

    /**
     * Funkcija patikrinanti ar vartotojo įvestas slaptažodis atitinka užšifruota slaptažodį
     * @param passwordPlainText - Vartotojo įvestas slaptažodis
     * @param storedHash - Užkuoduotas slaptažodis
     * @return true - jeigu atitinka, false - priešingu atvėju
     */
    public static boolean checkPassword(String passwordPlainText, String storedHash){
        boolean passwordVerified = false;
        if (storedHash == null || !storedHash.startsWith("$2a$")){
            throw new java.lang.IllegalArgumentException("Neteisingas BCrypt koduotė palyginimui");
        }
        passwordVerified = BCrypt.checkpw(passwordPlainText, storedHash);

        return passwordVerified;
    }

}
