package model;

import java.util.List;

public class Person {

    protected String nic = "";
    protected String fName = "";
    protected String lName = "";
    protected String dob = "";
    protected String address = "";
    protected String city = "";
    protected String gender = "";
    protected String telHome = "";
    protected String telMobile = "";

    // Getter and setter methods
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFname() {
        return fName;
    }

    public void setFname(String fname) {
        this.fName = fname;
    }

    public String getLname() {
        return lName;
    }

    public void setLname(String lname) {
        this.lName = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelHome() {
        return telHome;
    }

    public void setTel_home(String telHome) {
        this.telHome = telHome;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTel_mobile(String telMobile) {
        this.telMobile = telMobile;
    }

    // 1. Multithreading: A method that retrieves details in a separate thread.
    public class PersonThread extends Thread {
        private Person person;

        public PersonThread(Person person) {
            this.person = person;
        }

        @Override
        public void run() {
            System.out.println("Person details: " + person.getFname() + " " + person.getLname());
        }
    }

    // 2. Generics in Java: Method that prints a list of any object type.
    public static <T> void printDetails(List<T> items) {
        for (T item : items) {
            System.out.println(item.toString());
        }
    }

    // 3. Exception Handling: Custom exception for errors.
    public class PersonException extends Exception {
        public PersonException(String message) {
            super(message);
        }
    }

    public void validatePerson() throws PersonException {
        if (this.nic.isEmpty() || this.fName.isEmpty() || this.lName.isEmpty()) {
            throw new PersonException("Missing mandatory fields for Person.");
        }
    }

    // 4. Mutability and Immutability: Immutable class for specific person details.
    public final class ImmutablePerson {
        private final String name;
        private final String address;

        public ImmutablePerson(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    }

    // 5. Synchronization: Synchronizing methods to handle concurrent access.
    private static final Object lock = new Object();

    public synchronized void updatePersonDetails(String newCity) {
        this.city = newCity;
        System.out.println("City updated to: " + newCity);
    }

    public void synchronizedUpdate(String newTelMobile) {
        synchronized (lock) {
            this.telMobile = newTelMobile;
            System.out.println("Phone number updated to: " + newTelMobile);
        }
    }

    // 6. Abstract Data Type: Abstract method to calculate age, as it's specific to different types of person objects.
    public abstract class AbstractPerson {
        public abstract int calculateAge();
    }

    public class Employee extends AbstractPerson {
        @Override
        public int calculateAge() {
            // Implement age calculation logic here (for simplicity, assume static age).
            return 30;
        }
    }

    // 7. Unit Testing: Unit test method (JUnit test example).
    // This method would be used in a separate test class to verify Person functionality.
    /*
    @Test
    public void testPersonDetails() {
        Person person = new Person();
        person.setFname("John");
        person.setLname("Doe");
        assertNotNull(person.getFname());
        assertEquals("Doe", person.getLname());
    }
    */

    // 8. Deadlock: Simulating deadlock scenario.
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (lock2) {
                System.out.println("Method 1 executing");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (lock1) {
                System.out.println("Method 2 executing");
            }
        }
    }

}
