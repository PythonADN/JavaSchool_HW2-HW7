package HW_7.task_1;


import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) {
//        PluginManager pluginManager = new PluginManager("file://C:/Users/ADN/IdeaProjects/JavaSchool/src/HW_7/task_1/plugins");
//        Plugin plugin_1 = pluginManager.load("plugin_1", "HW_7.task_1.plugins.plugin_1.PluginImpl");
//        Plugin plugin_2 = pluginManager.load("plugin_2", "HW_7.task_1.plugins.plugin_2.PluginImpl.class");
//
//        plugin_1.doUsefull();
//        plugin_2.doUsefull();


        URL url = null;
        try {
            url = new URL("file://C:/Users/ADN/IdeaProjects/JavaSchool/src/HW_7/task_1/plugins/plugin_1/");
            ClassLoader loader = new URLClassLoader(new URL[]{url}, null);
            Class<?> cl =  loader.loadClass("HW_7.task_1.plugins.plugin_2.PluginImpl");
            System.out.println(cl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
