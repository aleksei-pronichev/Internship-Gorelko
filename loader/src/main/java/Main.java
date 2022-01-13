import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        MyLoader myLoader = new MyLoader(); //Создал свой classloader который забирает jar файлы (из папка resources) и ищет там классы находяшиеся в папке р
        Class<?> classCat = myLoader.loadClass("Cat", true); //Ищем необходимый класс в animals.jar
        Class<?> classDog = myLoader.loadClass("Dog", true);
        Class<?> classDuck = myLoader.loadClass("Duck", true);

        Animal catClassWithSab = (Animal) classCat.newInstance();//Создаем экземпляр загруженного класса (используя контрукттор без аргументов)
        Animal dogClassWithSab = (Animal) classDog.newInstance();
        Animal duckClassWithSab = (Animal) classDuck.newInstance();

        catClassWithSab.say();
        dogClassWithSab.say();
        duckClassWithSab.say();

    }
}
