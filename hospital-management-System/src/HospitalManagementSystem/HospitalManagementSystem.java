package HospitalManagementSystem;
import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;
public class HospitalManagementSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "1234nitesh@#$";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            patient patient = new patient(connection, scanner);
            Doctors doctors = new Doctors(connection);
            while (true) {
                System.out.println("Hospital Management System");
                System.out.println("1. Add Patients ");
                System.out.println("2. View Patients ");
                System.out.println("3. View Doctors ");
                System.out.println("4. Book Appointment ");
                System.out.println("5. Exit ");
                System.out.println("Enter your Choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        // Add patient
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        // View Patient
                        patient.viewPatient();
                        System.out.println();
                        break;
                    case 3:
                        // View Doctors
                        doctors.viewDoctors();
                        System.out.println();
                        break;
                    case 4:
                        // BooK Appointment
                        BookAppointment(patient, doctors, connection, scanner);
                        System.out.println();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Enter valid choice");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean BookAppointment(patient patient, Doctors doctors, Connection connection, Scanner scanner) {
        System.out.println("Enter Patient Id");
        int PatientId = scanner.nextInt();
        System.out.println("Enter Patient Id: ");
        System.out.println("Enter Doctor Id: ");
        int doctorsId = scanner.nextInt();
        System.out.println("Enter Appointment Date(YY-MM-DD): ");
        String appointmentDate = scanner.next();
        int patientId = 0;
        if(patient.getPatientId(patientId) && doctors.getDoctorsId(doctorsId)){
            if(checkDoctorsAvailability( doctorsId, appointmentDate , connection)){
                String appointmentQuery= "INSESRT INTO appointments (patient_id, doctor_id, appointment_date) VALUES(?,?,?)";
                try{
                    PreparedStatement preparedStatement = connection.prepareStatement(appointmentQuery);
                    preparedStatement.setInt(1,patientId);
                    preparedStatement.setInt(2,doctorsId);
                    preparedStatement.setString(3,appointmentDate);
                    int rowsAffected= preparedStatement.executeUpdate();
                    if(rowsAffected>0){
                        System.out.println("Appointment Booked");
                    }else{
                        System.out.println("Failed to Book Apppointment");
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("Doctor not available on this date");
            }
        }else{
            System.out.println("Either doctor or patient doesn't exist!");
        }
        return false;
    }

    private static boolean checkDoctorsAvailability(int doctorsId, String appointmentDate,Connection connection) {
        String query ="SELECT COUNT (*) FROM appointment WHERE doctor_id ? AND appointment_date= ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, doctorsId);
            preparedStatement.setString(2,appointmentDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int count= resultSet.getInt(1);
                if(count==0){
                    return true;
                }else{
                    return false;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}