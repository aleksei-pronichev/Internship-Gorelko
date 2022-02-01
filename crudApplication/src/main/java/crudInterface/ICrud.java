package crudInterface;

import model.Student;

public interface ICrud {

    void create(Student student);

    Student read(int id);

    void update(int id, int age);

    void delete(int id);

}
