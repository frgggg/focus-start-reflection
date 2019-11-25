package cft.study;

import cft.study.tasks.target.StudyClass;
import cft.study.tasks.task1.TaskOne;
import cft.study.tasks.task2.TaskTwo;
import cft.study.tasks.task3.TaskThree;

public class StudyApplication {
    public static void main(String[] args)
    {
        StudyClass studyClass = new StudyClass();

        TaskOne.doTaskOne(studyClass);
        TaskTwo.doTaskTwo(studyClass);
        TaskThree.doTaskThree(new String("123"), studyClass);
    }
}
