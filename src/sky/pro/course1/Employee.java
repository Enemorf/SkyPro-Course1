package sky.pro.course1;

public class Employee
{
    static int globalID = 0;

    private final int employeeID;
    private String fullName;
    private int department;
    private double salary;
    public Employee ()
    {
        this.employeeID = globalID++;
        this.fullName = "Default Employee";
        this.department = -1;
        this.salary = 0d;
    }
    public Employee (String fullName, int department, double salary)
    {
        this.employeeID = globalID++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }
    public String getFullName() {
        return fullName;
    }
    public int getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return employeeID + " " +
                fullName + " " +
                department + " " +
                salary;
    }
    public String printWithoutDepart()
    {
        return employeeID + " " +
                fullName + " " +
                salary;
    }
    public int getEmployeeID() {
        return employeeID;
    }
}
