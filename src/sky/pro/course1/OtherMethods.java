package sky.pro.course1;

import java.util.Random;

public class OtherMethods
{
    public static String getRandomFullName(boolean isMale)
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
