package helpdesk.model;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/helpdesk";

    public static void create(User user){

        String query = "INSERT INTO `users` (`username`, `password`, `email`) VALUES(?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());

            preparedStatement.executeUpdate();

            System.out.println("Įrašas sėkmingai pridėtas prie db!");

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException throwables){
            System.out.println("Ivyko klaida: " + throwables.getMessage());
        }
    }

//    public static void select(String knygosPavadinimas){
//
//        String query = "SELECT * FROM `knygos` WHERE pavadinimas LIKE'%"+knygosPavadinimas+"%'";
//
//        try{
//            Connection connection = DriverManager.getConnection(URL,"root","");
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            ResultSet resultSet = preparedStatement.executeQuery(query);
//
//            ArrayList<User> users = new ArrayList<>();
//
//            while(resultSet.next()){
//                String username = resultSet.getString("username");
//                String password = resultSet.getString("password");
//                String email = resultSet.getString("email");
//                users.add(new User(username,password,email));
//            }
//
//            if(users.isEmpty()){
//                System.out.println("Nepavyko rasti tokio įrašo");
//            }
//            else{
//                System.out.println("Pavyko gauti įraša iš db: ");
//                System.out.println(users);
//            }
//
//            preparedStatement.close();
//            connection.close();
//            resultSet.close();
//        }
//        catch(SQLException throwables){
//            System.out.println("Įvyko klaida: " + throwables.getMessage());
//        }
//
//    }
//
//    public static void update(User user){
//
//        String query = "UPDATE `users` SET `username` = ?, `password` = ?, `email` = ? WHERE `id` = ?";
//
//        try{
//            Connection connection = DriverManager.getConnection(URL,"root","");
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getEmail());
//            preparedStatement.setInt(4, user.getId());
//
//            preparedStatement.executeUpdate();
//            System.out.println("Pavyko atnaujinti įraša duomenų bazėje");
//            preparedStatement.close();
//            connection.close();
//        }
//        catch(SQLException throwables){
//            System.out.println("Ivyko klaida: " + throwables.getMessage());
//        }
//
//    }


    }



