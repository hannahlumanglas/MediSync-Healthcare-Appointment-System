package MediSync;

public class Appointment {
    private String doctorName;
    private String appointmentDate;
    private String appointmentTime;
    private String patientName;
    private int age;
    private String sex;
    private String address;
    private String contactNumber;
    private String email;
    private String reasonForVisit;

    public Appointment(String doctorName, String appointmentDate, String appointmentTime, String patientName,
                       int age, String sex, String address, String contactNumber, String email, String reasonForVisit) {
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.patientName = patientName;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
        this.reasonForVisit = reasonForVisit;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }
}