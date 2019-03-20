package HW_7.task_1;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) {
//        Plugin p1 = new HW_7.task_1.plugins.plugin_1.PluginImpl();
//        Plugin p2 = new HW_7.task_1.plugins.plugin_2.PluginImpl();
//        p1.doUsefull();
//        p2.doUsefull();

        try {
            URL url = new URL("file://C:/Users/ADN/IdeaProjects/JavaSchool/src/HW_7/task_1/plugins/plugin_1/"); // путь на дерикторию первого плагина
            URLClassLoader loader = new URLClassLoader(new URL[]{url});
            Plugin p1 = (Plugin) loader.loadClass("HW_7.task_1.plugins.plugin_1.PluginImpl").newInstance();
            p1.doUsefull();
//            Plugin p2 = (Plugin) loader.loadClass("HW_7.task_1.plugins.plugin_1.PluginImpl").newInstance();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }




}
