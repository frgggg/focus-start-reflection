package cft.study.tasks.task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class TaskOne {
    private static final int START_DEV_LEVEL = 1;
    private static final String BASE_DEV = "    ";
    private static String getDev(int devLevel)
    {
        String ret = "";
        for(int i = 0; i < devLevel; i++)
            ret = ret + BASE_DEV;
        return ret;
    }

    private static void printFieldInfo(Field field, int devLevel)
    {
        String dev = getDev(devLevel);
        System.out.println(dev + "Mod = " + Modifier.toString(field.getModifiers()));
        System.out.println(dev + "Type = " + field.getType());
        System.out.println(dev + "Name = " + field.getName());
        System.out.println("");
    }

    private static void printArgumentInfo(Parameter parameter, int devLevel)
    {
        String dev = getDev(devLevel);
        System.out.println(dev + "Name = " + parameter.getName());
        System.out.println(dev + "Type = " + parameter.getType());
        System.out.println("");
    }

    private static void printMethodInfo(Method method, int devLevel)
    {
        String dev = getDev(devLevel);
        System.out.println(dev + "Mod = " + Modifier.toString(method.getModifiers()));
        System.out.println(dev + "Return type = " + method.getReturnType());
        System.out.println(dev + "Name = " + method.getName());
        System.out.print(dev + "Arguments: ");
        Parameter[] parameters = method.getParameters();
        if(parameters.length > 0) {
            System.out.print("\n");
            for (int i = 0; i < parameters.length; i++)
                printArgumentInfo(parameters[i], devLevel + 1);
        }
        else
            System.out.println("no args");
        System.out.println("");
    }

    private static void printConstructorInfo(Constructor constructor, int devLevel)
    {
        String dev = getDev(devLevel);
        System.out.println(dev + "Mod = " + Modifier.toString(constructor.getModifiers()));
        System.out.println(dev + "Name = " + constructor.getName());
        System.out.print(dev + "Arguments: ");
        Parameter[] parameters = constructor.getParameters();
        if(parameters.length > 0) {
            System.out.print("\n");
            for (int i = 0; i < parameters.length; i++)
                printArgumentInfo(parameters[i], devLevel + 1);
        }
        else
            System.out.println("no args");
        System.out.println("");
    }

    public static void doTaskOne(Object o)
    {
        System.out.println("Task one:");
        Class classOfArgObject = o.getClass();
        System.out.println("Name of class = " + classOfArgObject.getName());

        int i = 0;

        System.out.println("Fields:");
        Field[] fields = classOfArgObject.getDeclaredFields();
        for(i = 0; i < fields.length; i++)
            printFieldInfo(fields[i], START_DEV_LEVEL);

        System.out.println("Methods:");
        Method[] methods = classOfArgObject.getMethods();
        for(i = 0; i < methods.length; i++)
            printMethodInfo(methods[i], START_DEV_LEVEL);

        System.out.println("Constructors:");
        Constructor[] constructors = classOfArgObject.getConstructors();
        for(i = 0; i < constructors.length; i++)
            printConstructorInfo(constructors[i], START_DEV_LEVEL);

        constructors = classOfArgObject.getDeclaredConstructors();
        for(i = 0; i < constructors.length; i++)
            printConstructorInfo(constructors[i], START_DEV_LEVEL);

    }
}
