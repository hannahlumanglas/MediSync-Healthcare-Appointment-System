package MediSync;

abstract class Doctor {
    protected String name;
    protected String specialty;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public abstract String getSchedule();  
    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }
}

class PrimaryCareDoctor extends Doctor {
    public PrimaryCareDoctor() {
        super("Dr. Maria Santos", "Primary Care Physician");
    }

    public String getSchedule() {
        return "Mon-Fri 9:00 AM - 5:00 PM, Sat 9:00 AM - 12:00 PM";
    }
}

class Dermatologist extends Doctor {
    public Dermatologist() {
        super("Dr. Juan de la Cruz", "Dermatologist");
    }

    public String getSchedule() {
        return "Mon, Wed, Fri 10:00 AM - 6:00 PM, Sat 9:00 AM - 1:00 PM";
    }
}
 
class Cardiologist extends Doctor {
    public Cardiologist() {
        super("Dr. Carlos Ramos", "Cardiologist");
    }

    public String getSchedule() {
        return "Mon, Thu 8:00 AM - 4:00 PM, Tue, Fri 9:00 AM - 3:00 PM";
    }
}

class Pediatrician extends Doctor {
    public Pediatrician() {
        super("Dr. Annabelle Garcia", "Pediatrician");
    }

    public String getSchedule() {
        return "Mon-Fri 8:30 AM - 5:00 PM";
    }
}

class Gynecologist extends Doctor {
    public Gynecologist() {
        super("Dr. Lara Reyes", "Gynecologist/Obstetrician");
    }

    public String getSchedule() {
        return "Mon, Wed, Fri 9:00 AM - 4:30 PM, Tue, Thu 10:00 AM - 6:00 PM";
    }
}