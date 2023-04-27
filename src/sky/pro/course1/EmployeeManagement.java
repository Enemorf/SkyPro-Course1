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
}
