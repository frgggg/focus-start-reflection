package cft.study.tasks.target;

import cft.study.tasks.target.annotations.StudyMethodAnnotation;
import cft.study.tasks.target.annotations.StudyTypeAnnotation;
import cft.study.tasks.target.interfaces.StudyInterface;

@StudyTypeAnnotation(falseReturnComment = "Custom comment of StudyTypeAnnotation for false return.")
public class StudyClass implements StudyInterface<String> {
    private Integer privateInteger = StudyClassFields.PRIVATE_INTEGER;
    private final Integer privateFinalInteger = StudyClassFields.PRIVATE_FINAL_INTEGER;
    private static final Integer privateStaticFinalInteger = StudyClassFields.PRIVATE_STATIC_FINAL_INTEGER;
    private String genericField = StudyClassFields.STRING_GENERIC_FIELD;

    public StudyClass()
    {

    }

    public StudyClass(Integer privateInteger)
    {

    }

    private StudyClass(Integer privateInteger, String genericField)
    {

    }

    @Override
    public Integer getPrivateInteger() {
        return privateInteger;
    }

    @Override
    public Integer getPrivateFinalInteger() {
        return privateFinalInteger;
    }

    @Override
    public Integer getPrivateStaticFinalInteger() {
        return privateStaticFinalInteger;
    }

    @Override
    public String getGenericField() {
        return genericField;
    }

    @Override
    @StudyMethodAnnotation(returnFalseString = "Custom false String for return")
    public String getFalseGenericField() {
        return genericField;
    }

    public static Integer getSum(StudyClass studyClass)
    {
        return studyClass.privateInteger + studyClass.privateFinalInteger + StudyClass.privateStaticFinalInteger;
    }

    @Override
    public void setPrivateInteger(Integer privateInteger) {
        this.privateInteger = privateInteger;
    }

    @Override
    public void setGenericField(String genericField) {
        this.genericField = genericField;
    }
}
