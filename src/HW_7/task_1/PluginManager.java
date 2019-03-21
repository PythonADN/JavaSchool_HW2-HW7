package HW_7.task_1;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    /**
     *
     * @param pluginName - дериктория с плагином (без имени самого класса плагина)
     * @param pluginClassName - имя клааса плагина
     * @return объект плагина
     */
    public Plugin load(String pluginName, String pluginClassName) {
        try {
            URL url = new URL(pluginRootDirectory+"/"+pluginName+"/");
            ClassLoader loader = new URLClassLoader(new URL[]{url}, null);
            Class<?> cl =  loader.loadClass(pluginClassName);
            System.out.println(cl);
            return (Plugin) cl.newInstance();
//            return (Plugin) loader.loadClass(pluginClassName).newInstance();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Неправильная директория с плагином");
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Проблема с конструктором плагина");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Класс не найден по имени");
        }
    }
}
