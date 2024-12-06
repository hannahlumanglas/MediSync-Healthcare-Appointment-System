package MediSync;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("==============================================================================================================");
            System.out.println("\t\t\t\t\t\t\t+");
            System.out.println("\t\t\t\t\tHealthcare Appointment System");
            System.out.println("==============================================================================================================");
            System.out.println("\t\t1. Schedule Appointment \t\t\t\t4. Cancel Appointment");
            System.out.println("\t\t2. Update Appointment \t\t\t\t\t5. Exit");
            System.out.println("\t\t3. View All Appointments");
            System.out.println("==============================================================================================================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    scheduleAppointment(scanner);
                    break;
                case 2:
                    updateAppointment(scanner);
                    break;
                case 3:
                    viewAllAppointments();
                    break;
                case 4:
                    cancelAppointment(scanner);
                    break;
                case 5:
                    System.out.println("\n---------------------------Thank you for Appointment... Always Take care of youself!--------------------------\n");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void scheduleAppointment(Scanner scanner) {
        Appointment newAppointment = collectAppointmentInfo(scanner);
        if (newAppointment != null) {
            appointments.add(newAppointment);
            System.out.println("\n\t\t\t--------------Appointment confirmed successfully!--------------\n");
        }
    }

    private static Appointment collectAppointmentInfo(Scanner scanner) {
        Doctor doctor = selectDoctorWithSchedule(scanner);

        System.out.print("\nEnter the Appointment Date (MM/DD/YYYY): ");
        String appointmentDate = scanner.nextLine();
        System.out.print("Enter the Appointment Time: ");
        String appointmentTime = scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Sex (Male/Female): ");
        String sex = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine();
        System.out.print("Enter Reason for Visit: ");
        String reasonForVisit = scanner.nextLine();

        return new Appointment(doctor.getName(), appointmentDate, appointmentTime, patientName, age, sex, address, contactNumber, email, reasonForVisit);
    }

    private static Doctor selectDoctorWithSchedule(Scanner scanner) {
        System.out.println("\nSelect Doctor and View Schedule:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-30s | %-25s | %-65s| \n", "No", "Specialty", "Doctor", "Schedule");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-30s | %-25s | %-65s|\n", "1", "Primary Care Physician", "Dr. Maria Santos", new PrimaryCareDoctor().getSchedule());
        System.out.printf("| %-3s | %-30s | %-25s | %-65s|\n", "2", "Dermatologist", "Dr. Juan de la Cruz", new Dermatologist().getSchedule());
        System.out.printf("| %-3s | %-30s | %-25s | %-65s|\n", "3", "Cardiologist", "Dr. Carlos Ramos", new Cardiologist().getSchedule());
        System.out.printf("| %-3s | %-30s | %-25s | %-65s|\n", "4", "Pediatrician", "Dr. Annabelle Garcia", new Pediatrician().getSchedule());
        System.out.printf("| %-3s | %-30s | %-25s | %-65s|\n", "5", "Gynecologist/Obstetrician", "Dr. Lara Reyes", new Gynecologist().getSchedule());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Enter your choice: ");
        int doctorChoice = scanner.nextInt();
        scanner.nextLine();

        switch (doctorChoice) {
            case 1:
                return new PrimaryCareDoctor();
            case 2:
                return new Dermatologist();
            case 3:
                return new Cardiologist();
            case 4:
                return new Pediatrician();
            case 5:
                return new Gynecologist();
            default:
                System.out.println("Invalid choice. Please try again.\n");
                return null;
        }
    }

    private static void viewAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("\nNo appointments available.");
            return;
        }
    
        System.out.println("\nAppointments:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-30s | %-20s | %-12s | %-6s | %-3s | %-6s | %-13s | %-30s | %-15s |\n",
                "No", "Patient Name", "Doctor Name", "Date", "Time", "Age", "Sex", "Contact", "Email", "Reason for Visit");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appt = appointments.get(i);
            System.out.printf("| %-3d | %-30s | %-20s | %-12s | %-6s | %-3d | %-6s | %-13s | %-30s | %-15s |\n",
                    i + 1, appt.getPatientName(), appt.getDoctorName(), appt.getAppointmentDate(), appt.getAppointmentTime(),
                    appt.getAge(), appt.getSex(), appt.getContactNumber(), appt.getEmail(), appt.getReasonForVisit());
        }
    
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }    

    private static void updateAppointment(Scanner scanner) {
        if (appointments.isEmpty()) {
            System.out.println("\nNo appointments to update.");
            return;
        }
    
        System.out.println("\nAppointments:");
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appt = appointments.get(i);
            System.out.printf("%d. %s with %s on %s at %s\n", 
                    i + 1, appt.getPatientName(), appt.getDoctorName(), appt.getAppointmentDate(), appt.getAppointmentTime());
        }
    
        System.out.print("\nEnter the appointment number to update: ");
        int apptIndex = scanner.nextInt() - 1;
        scanner.nextLine();
    
        if (apptIndex < 0 || apptIndex >= appointments.size()) {
            System.out.println("Invalid appointment number.\n");
            return;
        }
    
        Appointment apptToUpdate = appointments.get(apptIndex);

        System.out.println("\nWhat would you like to update?");
        System.out.println("1. Doctor");
        System.out.println("2. Appointment Date");
        System.out.println("3. Appointment Time");
        System.out.println("4. Patient Information");
        System.out.println("5. Reason for Visit");
        System.out.print("\nEnter your choice: ");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();
    
        switch (updateChoice) {
            case 1: {
                Doctor doctor = selectDoctorWithSchedule(scanner);
                apptToUpdate.setDoctorName(doctor.getName());
                break;
            }
            case 2: {
                System.out.print("\nEnter new Appointment Date (MM/DD/YYYY): ");
                String newDate = scanner.nextLine();
                apptToUpdate.setAppointmentDate(newDate);
                break;
            }
            case 3: {
                System.out.print("Enter new Appointment Time: ");
                String newTime = scanner.nextLine();
                apptToUpdate.setAppointmentTime(newTime);
                break;
            }
            case 4: {
                System.out.print("Enter new Patient Name: ");
                String newName = scanner.nextLine();
                apptToUpdate.setPatientName(newName);
                System.out.print("Enter new Age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                apptToUpdate.setAge(newAge);
                System.out.print("Enter new Sex (Male/Female): ");
                String newSex = scanner.nextLine();
                apptToUpdate.setSex(newSex);
                System.out.print("Enter new Address: ");
                String newAddress = scanner.nextLine();
                apptToUpdate.setAddress(newAddress);
                System.out.print("Enter new Contact Number: ");
                String newContact = scanner.nextLine();
                apptToUpdate.setContactNumber(newContact);
                System.out.print("Enter new Email: ");
                String newEmail = scanner.nextLine();
                apptToUpdate.setEmail(newEmail);
                break;
            }
            case 5: {
                System.out.print("Enter new Reason for Visit: ");
                String newReason = scanner.nextLine();
                apptToUpdate.setReasonForVisit(newReason);
                break;
            }
            default:
                System.out.println("Invalid choice.\n");
                break;
        }
        System.out.println("\n\t\t\t--------------Appointment confirmed successfully!--------------\n");
    }    

    private static void cancelAppointment(Scanner scanner) {
        viewAllAppointments();
        System.out.print("Enter the appointment number to cancel: ");
        int appointmentIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (appointmentIndex >= 0 && appointmentIndex < appointments.size()) {
            appointments.remove(appointmentIndex);
            System.out.println("\n\t\t\t--------------Appointment cancalled successfully!--------------\n");
        } else {
            System.out.println("Invalid appointment number.\n");
        }
    }
}