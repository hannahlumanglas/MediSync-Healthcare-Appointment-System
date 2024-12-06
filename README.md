# MediSync-Healthcare-Appointment-System

## I. Project Overview

**MediSync** is a healthcare appointment scheduling system designed to streamline the process of managing patient appointments. Patients can schedule, update, view, and cancel appointments with specialists, including:

- Primary Care Physicians  
- Dermatologists  
- Cardiologists  
- Pediatricians  
- Gynecologists  

The system provides a structured approach to appointment management, allowing patients to select convenient times while providing doctors with essential patient details (personal and contact information, and the reason for the visit). MediSync ensures secure data management, enhancing the efficiency of healthcare services and contributing to an improved healthcare experience.

---

## II. Application of OOP Principles

### 1. Encapsulation
Encapsulation is implemented through classes like `Appointment` and `Doctor`, where sensitive details (e.g., patient information, schedules) are private fields, accessible and modifiable only via getter and setter methods. This ensures data security and integrity.

### 2. Inheritance
The system leverages inheritance by using an abstract `Doctor` class as a parent class. It defines shared properties like `name` and `specialties` and enforces the implementation of the `getSchedule()` method. Specific doctor types (e.g., `PrimaryCareDoctor`, `Dermatologist`) extend this class, reusing and expanding its functionality.

### 3. Polymorphism
Polymorphism allows treating various doctor types (`PrimaryCareDoctor`, `Dermatologist`, etc.) as generic `Doctor` objects. For instance, the `selectDoctorWithSchedule()` method operates on `Doctor` references but dynamically invokes the specific implementation of `getSchedule()` depending on the doctor type.

### 4. Abstraction
The `Doctor` class abstracts common functionalities, acting as a blueprint for specific doctor types. This ensures uniform interaction across different doctor types while hiding unnecessary implementation details.

---

## III. Integration with SDG 3 (Good Health and Well-being)

MediSync aligns with **Sustainable Development Goal (SDG) 3** by:

- **Enhancing Access to Healthcare:** Simplifying the appointment process reduces wait times and facilitates timely access to medical care.
- **Improving Efficiency:** Automating scheduling, updates, and cancellations streamlines administrative workflows.
- **Ensuring Data Security:** Protecting patient data adheres to privacy standards.
- **Supporting Scalability:** The console-based design can evolve into a web or mobile application, broadening accessibility and scalability.

---

## IV. Instructions for Running the Program

1. **Main Menu Options:**  
   - Schedule Appointment  
   - Update Appointment  
   - View All Appointments  
   - Cancel Appointment  
   - Exit  

2. **Scheduling an Appointment:**  
   - Select "Schedule Appointment" from the main menu.  
   - Choose a doctor from the displayed list, which includes names, specialties, and available schedules.  
   - Enter appointment details:
     - Appointment date and time  
     - Patient name, age, sex, address, contact number, email, and reason for the visit  
   - The system confirms the appointment and adds it to the schedule.

3. **Updating an Appointment:**  
   - Select "Update Appointment" from the main menu.  
   - View and choose the appointment to update.  
   - Modify specific fields (e.g., doctor, date, time, patient details) as needed.  
   - Save changes to see the updated information.

4. **Viewing All Appointments:**  
   - Select "View All Appointments" to see a tabular display of all scheduled appointments.  
   - Details include:
     - Patient name, age, sex, contact information  
     - Doctor name, appointment date, time  
     - Reason for the visit  

5. **Canceling an Appointment:**  
   - Select "Cancel Appointment."  
   - Choose the appointment to delete from the list.  
   - Confirm cancellation to remove it from the system.

6. **Exiting the System:**  
   - Select "Exit" to terminate the program.  
   - A farewell message encourages users to prioritize their health.

---

## Example Usage Scenario

- A patient selects "Schedule Appointment" and chooses **Dr. Maria Santos**, a Primary Care Physician available Monday-Friday, 9:00 AM - 5:00 PM.  
- The patient enters details: **Name: Mark De Torres**, **Date: 12/01/2024**, **Time: 10:30 AM**, and **Reason: Skin check-up**.  
- The system confirms the appointment and lists it for reference.

---

MediSync simplifies healthcare access, supports efficient scheduling, and ensures patients receive timely care while aligning with global health goals.
