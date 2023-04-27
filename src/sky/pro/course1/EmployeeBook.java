package sky.pro.course1;

import java.util.Random;

public class EmployeeBook
{
    //Точка входа в программу "книга сотрудников"
    public static void main(String[] args)
    {
        Employee[] dataBase = fillArray(new Employee[10]);


        EmployeeManagement.printAllEmployee(dataBase);
        EmployeeManagement.printAllEmployeeName(dataBase);
        EmployeeManagement.printSalarySum(dataBase);
        EmployeeManagement.avgSalary(dataBase);
        EmployeeManagement.printEmployeeWithMaxSalary(dataBase);
        EmployeeManagement.printEmployeeWithMinSalary(dataBase);

    }

    static Employee[] fillArray(Employee[] array)
    {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++)
        {
            array[i] = new Employee(getNameEmployee(rand.nextBoolean()), rand.nextInt(6),
                    rand.nextInt(100_000) + rand.nextInt(50_000));
        }
        return array;
    }

    static String getNameEmployee(boolean isMale)
    {
        String[] maleName = new String[] {"Анатолий","Борис","Виктор","Григорий","Дмитрий"};
        String[] femaleName = new String[] {"Елена","Жанна","Зинаида","Ирина","Катерина"};

        String[] maleLastName = new String[] {"Лимонов","Мартынов","Нечаев","Ольхов","Петров"};
        String[] femaleLastName = new String[] {"Родионова","Смирнова","Токаева","Ухова","Филипова"};

        String[] maleSecondName = new String[] {"Янович","Юрьевич","Эдуардович","Тимурович","Степанович"};
        String[] femaleSecondName = new String[] {"Ринатовна","Павловна","Олеговна","Максимовна","Леонидовна"};

        Random rand = new Random();
        if(isMale)
            return maleLastName[rand.nextInt(maleLastName.length)]+" "+
                    maleName[rand.nextInt(maleName.length)]+ " "+
                    maleSecondName[rand.nextInt(maleSecondName.length)];
        else
            return femaleLastName[rand.nextInt(femaleLastName.length)]+" "+
                    femaleName[rand.nextInt(femaleName.length)]+ " "+
                    femaleSecondName[rand.nextInt(femaleSecondName.length)];

    }
}
