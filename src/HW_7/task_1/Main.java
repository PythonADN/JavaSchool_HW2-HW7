package HW_7.task_1;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        PluginManager pluginManager = new PluginManager();

        Plugin plugin_1 = pluginManager.load("HW_7.task_1.plugins.plugin_1.PluginImpl");
        plugin_1.doUsefull();

        Plugin plugin_2 = pluginManager.load("HW_7.task_1.plugins.plugin_2.PluginImpl");
        plugin_2.doUsefull();

        /**
         * пример без обёртки в ПлагинМенеджер
         */
//        MyClassLoader loader = new MyClassLoader();
//        Class clazz_1 = loader.findClass("HW_7.task_1.plugins.plugin_1.PluginImpl");
//        Plugin plugin_1 = (Plugin) clazz_1.newInstance();
//        plugin_1.doUsefull();
//
//        Class clazz_2 = loader.findClass("HW_7.task_1.plugins.plugin_2.PluginImpl");
//        Plugin plugin_2 = (Plugin) clazz_2.newInstance();
//        plugin_2.doUsefull();
    }
}
