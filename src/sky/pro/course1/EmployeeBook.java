package sky.pro.course1;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static sky.pro.course1.OtherMethods.getRandomFullName;


public class EmployeeBook
{
    private Employee[] dataBase;

    public EmployeeBook()
    {
        this.dataBase = new Employee[10];
    }

//    public EmployeeBook(int count)
//    {
//        this.dataBase = new Employee[count];
//    }
    public int getDBLength()
    {
        return dataBase.length;
    }
    public int getNullCell()
    {
        int res = 0;
        for(int i = 0; i < dataBase.length; i++)
        {
            if(dataBase[i] == null)
                res++;
        }
        return res;
    }


    //Методы для работы с БД сотрудников
    public void createNewEmployee()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("--СОЗДАНИЕ НОВОГО СОТРУДНИКА--");

        for(int i = 0; i < dataBase.length; i++)
        {
            if(dataBase[i] == null)
            {
                System.out.println("-Введите Ф.И.О. сотрудника: ");
                String fullName = input.nextLine();
                System.out.println("-Введите отдел сотрудника (0..5): ");
                int department = input.nextInt();
                System.out.println("-Введите ЗП сотрудника (копейки считаются через запятую): ");
                double salary = input.nextDouble();

                dataBase[i] = new Employee(fullName,department,salary);
                System.out.println("--СОТРУДНИК ВВЕДЕН!\n");
                return;
            }
        }
        System.out.println("!!! СОЗДАНИЕ ЗАПРЕЩЕНО: в массиве нет места.\n");
    }
    public void deleteEmployee()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("--УДАЛЕНИЕ СОТРУДНИКА--");
        System.out.println("-Как ищем сотрудника? (0 - по ФИО, 1 - по id): ");
        int find = input.nextInt();
        String fullName = input.nextLine();
        int id = -1;
        if(find == 0)
        {
            System.out.println("-Введите ФИО сотрудника: ");
            fullName = input.nextLine();
        }
        else
        {
            System.out.println("-Введите id сотрудника: ");
            id = input.nextInt();
        }

        for(int i = 0; i < dataBase.length; i++)
        {
            if(dataBase[i] == null)
                continue;
            if(dataBase[i].getFullName().equals(fullName) || dataBase[i].getEmployeeID() == id)
            {
                dataBase[i] = null;
                System.out.println("--СОТРУДНИК УДАЛЁН!\n");
                return;
            }
        }
        System.out.println("--СОТРУДНИК НЕ НАЙДЕН!\n");
    }
    public void fillDataBase()
    {
        Random rand = new Random();
        System.out.println("--ЗАПОЛНЕНИЕ БАЗЫ ДАННЫХ РАНДОМАМИ--");
        int count = 0;
        for(int i = 0; i < dataBase.length; i++)
        {
            if(dataBase[i] != null)
                continue;
            dataBase[i] = new Employee(getRandomFullName(rand.nextBoolean()), rand.nextInt(6),
                    rand.nextInt(150_000));
            count++;
        }

        if(count == 0)
            System.out.println("!!!ЗАПОЛНЕНИЕ НЕ ПОЛУЧИЛОСЬ: все ячейки были заняты.\n");
        else
            System.out.println("!!!МАССИВ ПОЛНОСТЬЮ ЗАПОЛНЕН. Новых сотрудников: "+count+"\n");
    }
    public void changeEmployeeParam(boolean isSalary)
    {
        Scanner input = new Scanner(System.in);

        if(isSalary)
            System.out.println("--СМЕНА ЗП СОТРУДНИКА--");
        else
            System.out.println("--СМЕНА ОТДЕЛА СОТРУДНИКА--");
        System.out.println("-Введите ФИО сотрудника: ");
        String fullName = input.nextLine();

        for(int i = 0; i < dataBase.length; i++)
        {
            if(dataBase[i] == null)
                continue;

            if(dataBase[i].getFullName().equals(fullName))
            {
                if(isSalary)
                {
                    System.out.println("-Введите новую ЗП: ");
                    dataBase[i].setSalary(input.nextDouble());
                    System.out.println("--ЗП УСПЕШНО ИЗМЕНЕНА!\n");
                }
                else
                {
                    System.out.println("-Введите новый отдел: ");
                    dataBase[i].setDepartment(input.nextInt());
                    System.out.println("--ОТДЕЛ УСПЕШНО ИЗМЕНЕН!\n");
                }
                return;
            }
        }
        System.out.println("!!!СОТРУДНИК НЕ НАЙДЕН\n");
    }
    public void printAllEmployeeByDepartments()
    {
        System.out.println("-- СПИСОК СОТРУДНИКОВ ПО ОТДЕЛАМ --");
        for(int i = 0; i < 6;i++)
        {
            System.out.println("-- ОТДЕЛ "+i + " --");
            for(var cell: dataBase)
            {
                if(cell == null)
                    continue;
                if(cell.getDepartment() != i)
                    continue;
                System.out.println(cell.getFullName());
            }
            System.out.println("\n");
        }
    }

    //Методы для работы с сотрудниками
    public void printAllEmployee(int department)
    {
        System.out.println("--ВЫВОД " +((department ==-1)?"ВСЕЙ БАЗЫ ДАННЫХ--":"БАЗЫ ДАННЫХ ОТДЕЛА "+department +
                " --"));

        for(var cell : dataBase)
        {
            if(cell == null)
                continue;
            if(department != -1 && department == cell.getDepartment())
                System.out.println(cell.printWithoutDepart());
            else if(department == -1)
                System.out.println(cell.toString());
        }
        System.out.println("\n");
    }
    public void printSalarySum(int department)
    {
        System.out.println("--ВЫВОД " +((department ==-1)?"ВСЕЙ СУММЫ ЗП--":"СУММЫ ЗП ОТДЕЛА "+department +
                " --"));

        double sum = calculateSalary(department);

        System.out.println("-СУММА ЗП "+((department ==-1)?"ВСЕХ СОТРУДНИКОВ РАВНА:":"СОТРУДНИКОВ ОТДЕЛА "+ department+
                " РАВНА: ") + new DecimalFormat("###,###.##").format(sum));
        System.out.println("\n");
    }
    public void printAVGSalary(int department)
    {
        System.out.println("--ВЫВОД СРЕДНЕЙ ЗП " +((department ==-1)?"ВСЕХ СОТРУДНИКОВ--":"СОТРУДНИКОВ ОТДЕЛА "+
                department +" --"));

        double sum = calculateSalary(department);
        int quantity;
        if(department == -1)
            quantity = dataBase.length;
        else
            quantity = calculateQuantityInDepartment(department);
        sum = sum / quantity;

        System.out.println("-СРЕДНЯЯ ЗП "+((department ==-1)?"ВСЕХ СОТРУДНИКОВ--":"СОТРУДНИКОВ ОТДЕЛА "+
                department) + " СОСТАВЛЯЕТ: "+ new DecimalFormat("###,###.##").format(sum) + "\n");

    }
    double calculateSalary(int department)
    {
        double res = 0;
        for(var cell : dataBase)
        {
            if(cell == null)
                continue;
            if(department == -1 || department == cell.getDepartment())
                res += cell.getSalary();
        }
        return res;
    }
    int calculateQuantityInDepartment(int department)
    {
        int res = 0;
        for (var cell : dataBase)
        {
            if(cell == null)
                continue;
            if(cell.getDepartment() == department)
                res++;
        }
        return res;
    }

    public void printEmployeeWithMinMaxSalary (int department, boolean isMin)
    {
        System.out.println("--ВЫВОД СОТРУДНИКА " + ((department ==-1)?"":"ОТДЕЛА "+ department) + " С " +
                ((isMin)?"МИНИМАЛЬНОЙ":"МАКСИМАЛЬНОЙ") + " ЗП--");
        double sum;
        if(isMin)
            sum = Double.MAX_VALUE;
        else
            sum = Double.MIN_VALUE;
        Employee key = null;
        for(var cell: dataBase)
        {
            if(cell == null)
                continue;

            if((isMin && sum > cell.getSalary() || !isMin && sum < cell.getSalary()) &&
                    (department != -1 && department == cell.getDepartment()) ||
                    (department == -1 && (isMin && sum > cell.getSalary() || !isMin && sum < cell.getSalary())))
            {
                key = cell;
                sum = key.getSalary();
            }
        }
        if(key == null)
        {
            System.out.println("!!!ЧТО-ТО ПОШЛО НЕ ТАК!!!");
            return;
        }

        System.out.println("-СОТРУДНИК С "+
                ((isMin)?"МИНИМАЛЬНОЙ":"МАКСИМАЛЬНОЙ") + " ЗП " +((department ==-1)?"":"ОТДЕЛА"+ department)+": " +
                key.getFullName());
        System.out.println("ЗАРАБОТНАЯ ПЛАТА СОСТАВЛЯЕТ: "+ new DecimalFormat("###,###.##").format(sum) + "\n");
    }
    public void getSalaryIndex(int department, int percent)
    {
        System.out.println("--ИНДЕКСАЦИЯ ЗП" + ((department ==-1)?"":" В ОТДЕЛЕ " + department)
                +" НА "+ percent +"% --");

        for (int i = 0; i < dataBase.length; i++)
        {
            if(dataBase[i] == null)
                continue;
            if(department == -1 || dataBase[i].getDepartment() == department)
            {
                dataBase[i].setSalary(dataBase[i].getSalary() + dataBase[i].getSalary()*((double) percent / 100));
            }
        }
        System.out.println("-ЗП ПРОИНДЕКСИРОВА НА "+percent +"%" +
                ((department ==-1)?"":" В ОТДЕЛЕ " + department) + "\n");
    }

    public void findEmployeeWithMinMaxSalary (double salary, boolean isMin)
    {
        System.out.println("--ВЫВОД ВСЕХ СОТРУДНИКОВ С ЗП "+ ((isMin)?"МЕНЬШЕ":"БОЛЬШЕ")+ " ЗНАЧЕНИЯ "
                + new DecimalFormat("###.##").format(salary)+" --");

        for(var cell : dataBase)
        {
            if(cell == null)
                continue;
            if((cell.getSalary() > salary && !isMin) || (cell.getSalary() < salary && isMin))
                System.out.println(cell.printWithoutDepart());
        }
        System.out.println("-ВЫВОД ОКОНЧЕН-");
        System.out.println("\n");
    }
}
