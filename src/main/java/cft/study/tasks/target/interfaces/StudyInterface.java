package cft.study.tasks.target.interfaces;

public interface StudyInterface<E> {
    Integer getPrivateInteger();
    void setPrivateInteger(Integer privateInteger);

    Integer getPrivateFinalInteger();

    Integer getPrivateStaticFinalInteger();

    E getGenericField();
    void setGenericField(E genericField);

    E getFalseGenericField();
}