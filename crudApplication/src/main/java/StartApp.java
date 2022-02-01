import connection.RunningScript;
import crud.Crud;
import model.Student;

public class StartApp {

    public static void main(String[] args) {

        new RunningScript().startScript(); //Строим таблицу с исходными данными из скрипта (simpleScript.sql)

        Crud crud = new Crud();

        crud.create(new Student(7, "Eugen", "Sapega", 18)); //Создаем нового студента в базе

        crud.update(7, 20); //Обновляем возраст

        System.out.println(crud.read(7)); //Выводим студента под указанным id

        crud.delete(7); //Удаляем студента под указанным id

    }

}
