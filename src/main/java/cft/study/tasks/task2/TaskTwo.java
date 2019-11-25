package cft.study.tasks.task2;

import cft.study.tasks.target.StudyClass;
import cft.study.tasks.target.StudyClassFields;
import cft.study.tasks.target.interfaces.StudyInterface;

import java.lang.reflect.Proxy;

public class TaskTwo {
    public static void doTaskTwo(StudyClass studyClass) {
        System.out.println("Task two:");
        Object proxy = Proxy.newProxyInstance(
                StudyClass.class.getClassLoader(),
                studyClass.getClass().getInterfaces(),
                new StudyClassHandler(studyClass)
                );

        ((StudyInterface<String>)proxy).setPrivateInteger(StudyClassFields.PRIVATE_INTEGER);
        String realGenericField = ((StudyInterface<String>)proxy).getGenericField();
        String falseGenericField = ((StudyInterface<String>)proxy).getFalseGenericField();

        System.out.println("");
        System.out.println("Real field  = " + realGenericField);
        System.out.println("False field = " + falseGenericField);
    }
}
