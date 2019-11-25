package cft.study.tasks.task2;

import cft.study.tasks.target.annotations.StudyMethodAnnotation;
import cft.study.tasks.target.annotations.StudyTypeAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.stream.Stream;

public class StudyClassHandler implements InvocationHandler {
    Object target;

    public StudyClassHandler(Object target)
    {
        this.target = target;
    }

    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        try {
            System.out.println("");
            String methodName = method.getName();
            System.out.println("Method name = " + methodName);

            Class<?>[] argsTypes = null;
            if(args != null) {
                if(args.length != 0) {
                    argsTypes = Stream.of(args).map(Object::getClass).toArray(Class[]::new);
                }
            }
            Method currentMethod = target.getClass().getMethod(methodName, argsTypes);

            Parameter[] currentArgs = currentMethod.getParameters();
            System.out.print("Arguments:");
            if(currentArgs.length > 0) {
                System.out.print("\n");
                for (int i = 0; i < currentArgs.length; i++) {
                    System.out.println("    argument[" + i + "]:");
                    System.out.println("        name = " + currentArgs[i].getName());
                    System.out.println("        type = " + currentArgs[i].getType());
                }
            }
            else
                System.out.print(" no argument.");
            System.out.println("");

            if(currentMethod.getReturnType().equals(String.class)) {
                StudyMethodAnnotation studyMethodAnnotation = currentMethod.getAnnotation(StudyMethodAnnotation.class);
                if (studyMethodAnnotation != null) {
                    StudyTypeAnnotation studyTypeAnnotation = target.getClass().getAnnotation(StudyTypeAnnotation.class);
                    if (studyTypeAnnotation != null) {
                        System.out.println("Comment for false return from type = " + studyTypeAnnotation.falseReturnComment());
                    }
                    return studyMethodAnnotation.returnFalseString();
                }
            }

        }
        catch ( NoSuchMethodException e)
        {
           return method.invoke(target, args);
        }
        return method.invoke(target, args);
    }
}
