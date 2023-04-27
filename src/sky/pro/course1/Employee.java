package sky.pro.course1;

public class Employee
{
    static int localID = 0;

    private int employeeID;
    private String name;
    private int department;
    private double salary;


    public Employee()
    {
        this.employeeID = getLocalID();
        this.name = "Default Employee";
        this.department = -1;
        this.salary = 0;
    }

    public Employee(String name, int department, double salary) {
        this.employeeID = getLocalID();
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    private static int getLocalID()
    {
        return localID++;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
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
        return "Employee{" +
                "employeeID=" + employeeID +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
