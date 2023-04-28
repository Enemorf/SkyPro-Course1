package sky.pro.course1;

import java.text.DecimalFormat;
import java.util.Arrays;

public class EmployeeManagement {
    static void printAllEmployee(Employee[] array)
    {
        for(int i = 0; i < array.length; i++)
            System.out.println(array[i].toString());
    }
    static void printAllEmployeeName(Employee[] array)
    {

        for(int i = 0; i < array.length; i++)
            System.out.println(array[i].getName().toString());
    }
    static void printSalarySum(Employee[] array)
    {
        System.out.println("Сумма зарплат всех сотрудников: " +
                new DecimalFormat("###,###.##").format(calculateAllSalary(array)));
    }
    static void printEmployeeWithMinSalary(Employee[] array)
    {
        System.out.println("Сотрудник с минимальной зарплатой: "+
                array[calculateMinMaxSalary(array, true)].toString());
    }
    static void printEmployeeWithMaxSalary(Employee[] array)
    {
        System.out.println("Сотрудник с максимальной зарплатой: "+
                array[calculateMinMaxSalary(array, false)].toString());
    }
    static void avgSalary(Employee[] array)
    {
        System.out.println("Средняя зарплата всех сотрудников: " +
                new DecimalFormat("###,###.##").format(calculateAllSalary(array) / array.length));
    }
    static double calculateAllSalary(Employee[] array)
    {
        double result = 0;
        for(int i = 0; i < array.length; i++)
            result = result + array[i].getSalary();
        return result;
    }
    static int calculateMinMaxSalary(Employee[] array,boolean isMin)
    {
        int res = 0;
        for (int i = 1; i < array.length; i++)
        {
            if(isMin)
            {
                if(array[i].getSalary() < array[res].getSalary())
                    res = i;
            }
            else
            {
                if(array[i].getSalary() > array[res].getSalary())
                    res = i;
            }
        }
        return res;
    }

    static double changeSalary(double salary, int percent)
    {
        return (salary + salary*((double)percent/100));
    }


    static void getMinSalaryInDepartment(int department, Employee[] array)
    {
        calculateMinMaxSalaryInDepartment(department, array, true);
    }

    static void getMaxSalaryInDepartment(int department, Employee[] array)
    {
        calculateMinMaxSalaryInDepartment(department, array, false);
    }

    static void calculateMinMaxSalaryInDepartment(int department, Employee[] array, boolean isMin)
    {
        int res = -1;
        double salary;

        if(isMin)
            salary = Double.MAX_VALUE;
        else
            salary = Double.MIN_VALUE;

        for(int i = 0;i < array.length; i++)
        {
            if(array[i].getDepartment() != department)
                continue;
            if((array[i].getSalary() < salary && isMin) || (array[i].getSalary() > salary && !isMin))
            {
                res = i;
                salary = array[i].getSalary();
            }
        }

        if(res == -1)
        {
            System.out.println("Сотрудник не найден или такого отдела нет!");
            return;
        }
        System.out.println(array[res].toString());
    }

    static void getSumSalaryInDepartment(int department, Employee[] array)
    {
        double sum = 0;

        for(int i = 0;i < array.length; i++)
        {
            if(array[i].getDepartment() != department)
                continue;
            sum += array[i].getSalary();
        }

        System.out.println("Сумма ЗП по отделу: " + sum);

    }

    static void getAVGSalaryInDepartment(int department, Employee[] array)
    {
        double sum = 0;
        int employeeInDepartment = 0;

        for(int i = 0;i < array.length; i++)
        {
            if(array[i].getDepartment() != department)
                continue;
            sum += array[i].getSalary();
            employeeInDepartment ++;
        }
        sum = sum / employeeInDepartment;
        System.out.println("Средняя ЗП по отделу: " + sum);
    }

    static void changeSalaryInDepartment(int department, Employee[] array, int percent)
    {
        for(var empl: array)
        {
            if(empl.getDepartment() != department)
                continue;
            empl.setSalary(empl.getSalary() + empl.getSalary()*((double)percent/100));
        }
    }

    static void printAllEmployeeInDepartment(int department, Employee[] array)
    {
        for(var empl: array)
        {
            if(empl.getDepartment() != department)
                continue;
            System.out.println(empl.getEmployeeID() + " " + empl.getName() + " " + empl.getSalary());
        }
    }

    static void getAllEmployeeLessSalary(double salary, Employee[] array)
    {
        for(var empl : array)
        {
            if(empl.getSalary() < salary)
                System.out.println(empl.getEmployeeID() + " " + empl.getName() + " " + empl.getSalary());
        }
    }

    static void getAllEmployeeMoreSalary(double salary, Employee[] array)
    {
        for(var empl : array)
        {
            if(empl.getSalary() > salary)
                System.out.println(empl.getEmployeeID() + " " + empl.getName() + " " + empl.getSalary());
        }
    }




}
