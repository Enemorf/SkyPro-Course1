package sky.pro.course1;

import java.util.Scanner;

public class Main
{
    static int department = -1;
    static EmployeeBook exampleBook;

    public static void main(String[] args)
    {
        exampleBook = new EmployeeBook();
        start();
    }

    static void start()
    {
        System.out.println("--ДОБРО ПОЖАЛОВАТЬ В ПРИЛОЖЕНИЕ \"КНИГА СОТРУДНИКОВ\"--\n" +
                "-Выберите действие:\n" +
                "1 - Действия с БД сотрудников\n" +
                "2 - Действия с сотрудниками\n" +
                "3 - Действия с отделами\n" +
                "0 - Выход из приложения");
        Scanner input = new Scanner(System.in);
        int res = input.nextInt();

        switch (res)
        {
            case 1:
            {
                actionToDB();
                break;
            }
            case 2:
            {
                actionToEmployee();
                break;
            }
            case 3:
            {
                actionToDepartments();
                break;
            }
            case 0:
            {
                appExit();
            }
            default:
            {
                System.out.println("!!! Направильно выбрано действие!!!\n");
                start();
                break;
            }
        }
    }
    static void appExit()
    {
        System.out.println("Выход из приложения.\nХорошего дня!");
        System.exit(0);
    }

    static void actionToDB()
    {
        System.out.println("--ДЕЙСТВИЯ С БД СОТРУДНИКОВ--");
        System.out.println("Текущая БД может вмещать "+ exampleBook.getDBLength() + " сотрудников.\n" +
                "Свободно ячеек в БД: "+ exampleBook.getNullCell()+ "\n");
        System.out.println("-Выберите действие:\n" +
                "1 - Добавить сотрудника\n" +
                "2 - Удалить сотрудника\n" +
                "3 - Заполнить БД рандомами\n" +
                "4 - В главное меню\n" +
                "0 - Выход из приложения");

        Scanner input = new Scanner(System.in);
        int res = input.nextInt();
        switch (res)
        {
            case 1:
            {
                exampleBook.createNewEmployee();
                actionToDB();
                break;
            }
            case 2:
            {
                exampleBook.deleteEmployee();
                actionToDB();
                break;
            }
            case 3:
            {
                exampleBook.fillDataBase();
                actionToDB();
                break;
            }
            case 4:
            {
                start();
                return;
            }
            case 0:
            {
                appExit();
            }
            default:
            {
                System.out.println("!!! Направильно выбрано действие!!!\n");
                start();
                break;
            }
        }
    }
    static void actionToEmployee()
    {
        System.out.println("--ДЕЙСТВИЯ НАД СОТРУДНИКАМИ--");
        System.out.println("-Выберите действие:\n" +
                "1 - Вывести всех сотрудников\n" +
                "2 - Вывести сумму ЗП\n" +
                "3 - Вывести среднюю ЗП\n" +
                "4 - Найти сотрудника с минимальной ЗП\n" +
                "5 - Найти сотрудника с максимальной ЗП\n" +
                "6 - Изменить сотруднику отдел\n" +
                "7 - Изменить сотруднику ЗП\n" +
                "8 - Проиндексировать ЗП сотрудникам\n" +
                "9 - Вывести сотрудников с ЗП меньше заданной\n" +
                "10 - Вывести сотрудников с ЗП больше заданной\n" +
                "11 - В главное меню\n" +
                "0 - Выйти из приложения");
        Scanner input = new Scanner(System.in);
        int res = input.nextInt();
        switch (res)
        {
            case 0:
            {
                appExit();
            }
            case 1:
            {
                exampleBook.printAllEmployee(-1);
                actionToEmployee();
                break;
            }
            case 2:
            {
                exampleBook.printSalarySum(-1);
                actionToEmployee();
                break;
            }
            case 3:
            {
                exampleBook.printAVGSalary(-1);
                actionToEmployee();
                break;
            }
            case 4:
            {
                exampleBook.printEmployeeWithMinMaxSalary(-1,true);
                actionToEmployee();
                break;
            }
            case 5:
            {
                exampleBook.printEmployeeWithMinMaxSalary(-1,false);
                actionToEmployee();
                break;
            }
            case 6:
            {
                exampleBook.changeEmployeeParam(false);
                actionToEmployee();
                break;
            }
            case 7:
            {
                exampleBook.changeEmployeeParam(true);
                actionToEmployee();
                break;
            }
            case 8:
            {
                System.out.println("-Введите, на какой процент проиндексировать ЗП:");
                int percent = input.nextInt();
                exampleBook.getSalaryIndex(-1, percent);
                actionToEmployee();
                break;
            }
            case 9:
            {
                System.out.println("-Введите ЗП:");
                double salary = input.nextDouble();
                exampleBook.findEmployeeWithMinMaxSalary(salary,true);
                actionToEmployee();
                break;
            }
            case 10:
            {
                System.out.println("-Введите ЗП:");
                double salary = input.nextDouble();
                exampleBook.findEmployeeWithMinMaxSalary(salary,false);
                actionToEmployee();
                break;
            }
            case 11:
            {
                start();
                break;
            }
            default:
            {
                System.out.println("!!! Направильно выбрано действие!!!\n");
                start();
                break;
            }
        }
    }
    static void actionToDepartments()
    {
        System.out.println("--ДЕЙСТВИЯ НАД ОТДЕЛАМИ--");
        Scanner input = new Scanner(System.in);

        if(department == -1)
        {
            System.out.println("-Введите номер отдела (0..5):");
            department = input.nextInt();

            if((department < 0) && (department > 5))
            {
                System.out.println("!!! ВВЕДЕН НЕВЕРНЫЙ НОМЕР ОТДЕЛА!!!");
                department = -1;
                actionToDepartments();
                return;
            }
        }
        System.out.println("-ВЫБРАННЫЙ ОТДЕЛ: " + department);
        System.out.println("-Выберите действие:\n" +
                "1 - Поменять отдел\n" +
                "2 - Вывести всех сотрудников по отделам\n" +
                "3 - Вывести сумму ЗП сотрудников отдела " + department + "\n" +
                "4 - Вывести среднюю ЗП сотрудников отдела " + department + "\n" +
                "5 - Проиндексировать ЗП сотрудникам отдела " + department + "\n" +
                "6 - Вывести сотрудника отдела " + department + " с минимальной ЗП\n" +
                "7 - Вывести сотрудника отдела " +department + " с максимальной ЗП\n" +
                "8 - В главное меню\n" +
                "0 - Выйти из приложения");
        int res = input.nextInt();

        switch (res)
        {
            case 0:
            {
                appExit();
                break;
            }
            case 1:
            {
                department = -1;
                actionToDepartments();
                break;
            }
            case 2:
            {
                exampleBook.printAllEmployeeByDepartments();
                actionToDepartments();
                break;
            }
            case 3:
            {
                exampleBook.printSalarySum(department);
                actionToDepartments();
                break;
            }
            case 4:
            {
                exampleBook.printAVGSalary(department);
                actionToDepartments();
                break;
            }
            case 5:
            {
                System.out.println("-Введите, на какой процент проиндексировать ЗП:");
                int percent = input.nextInt();
                exampleBook.getSalaryIndex(department, percent);
                actionToDepartments();
                break;
            }
            case 6:
            {
                exampleBook.printEmployeeWithMinMaxSalary(department, true);
                actionToDepartments();
                break;
            }
            case 7:
            {
                exampleBook.printEmployeeWithMinMaxSalary(department, false);
                actionToDepartments();
                break;
            }
            case 8:
            {
                start();
                break;
            }
        }
    }

}
