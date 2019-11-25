package cft.study.tasks.task3;

import cft.study.tasks.target.StudyClass;
import cft.study.tasks.target.StudyClassFields;

import java.lang.reflect.Field;

public class TaskThree {
    private static final Integer AFTER_REFLECTION_DEV = 100;
    private static void partOneUtil(Class currentClass)
    {
        System.out.println("    Class name = " + currentClass.getName());
        Class[] interfaces = currentClass.getInterfaces();
        System.out.print("      Interfaces:");
        if(interfaces.length > 0) {
            System.out.println("");
            for (int i = 0; i < interfaces.length; i++)
                System.out.println("        " + interfaces[i].getName());
        }
        else
            System.out.print("no interfaces.");
        System.out.println("");
        if(currentClass.getSuperclass() != null)
            partOneUtil(currentClass.getSuperclass());

    }
    private static void partOne(Object o)
    {
        System.out.println("  Part 1:");
        partOneUtil(o.getClass());
    }

    private static void partTwo(StudyClass studyClass)
    {
        System.out.println("  Part 2:");
        try
        {
            Field privateField = studyClass.getClass().getDeclaredField("privateInteger");
            privateField.setAccessible(true);
            System.out.println("    Private Integer before reflection = " + studyClass.getPrivateInteger());
            privateField.set(studyClass, StudyClassFields.PRIVATE_INTEGER + AFTER_REFLECTION_DEV);
            System.out.println("    Private Integer after reflection = " + studyClass.getPrivateInteger());

            Field privateFinalField = studyClass.getClass().getDeclaredField("privateFinalInteger");
            privateFinalField.setAccessible(true);
            System.out.println("    Private final Integer before reflection = " + studyClass.getPrivateFinalInteger());
            privateFinalField.set(studyClass, StudyClassFields.PRIVATE_FINAL_INTEGER + AFTER_REFLECTION_DEV);
            System.out.println("    Private final Integer after reflection = " + studyClass.getPrivateFinalInteger());

            Field privateStaticFinalInteger = studyClass.getClass().getDeclaredField("privateStaticFinalInteger");
            privateStaticFinalInteger.setAccessible(true);
            System.out.println("    Private static final Integer before reflection = " + studyClass.getPrivateStaticFinalInteger());
            privateStaticFinalInteger.set(studyClass, studyClass.getPrivateStaticFinalInteger() + AFTER_REFLECTION_DEV);
            System.out.println("    Private static final Integer after reflection = " + studyClass.getPrivateStaticFinalInteger());
        }
        catch (Exception e)
        {
            System.out.println("Throw in Task 3.2: " + e.getMessage());
        }
    }

    public static void doTaskThree(Object studyObject, StudyClass studyClassForPartTwo)
    {
        System.out.println("Task 3:");
        partOne(studyObject);
        partTwo(studyClassForPartTwo);
    }
}
