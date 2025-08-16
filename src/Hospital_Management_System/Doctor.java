package Hospital_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
    private Connection connection;

    public Doctor(Connection connection){
        this.connection=connection;

    }



    public void viewDoctors(){
        String query ="select * from doctors";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctors: ");
            System.out.println("+------------+-------------------------------+---------------------------------+");
            System.out.println("| Doctor ID  | Name                          |Specialization                   |");
            System.out.println("+------------+-------------------------------+---------------------------------+");
            while ((resultSet.next())){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("| %-10 | %-29 | %-31 |\n", id, name, specialization );
                System.out.println("+------------+-------------------------------+---------------------------------+");

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public boolean getDoctorById(int id){
        String query = "select * From doctors Where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return true;

            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
