import java.net.URL;
import java.net.URLClassLoader;

public class MyLoader extends ClassLoader {

    @Override
    public synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class result = findClass(name);
        if (resolve)
            resolveClass(result);
        return result;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        final URL jarFileURL = Main.class.getClassLoader().getResource("animals.jar"); //находим ссылку на файл в памяти ресурса
        URLClassLoader pluginLoader = new URLClassLoader(new URL[]{jarFileURL});
        Class<?> cl = pluginLoader.loadClass(name);
        Class<? extends Animal> isClass = cl.asSubclass(Animal.class); //Animal является сабклассом нашего класса Cat Dog Duck

        return isClass;
    }

}