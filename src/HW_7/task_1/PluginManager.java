package HW_7.task_1;

public class PluginManager {
    /**
     *
     * @param pluginName - путь к плагину
     * @return объект плагина
     */
    public Plugin load(String pluginName) {
        MyClassLoader loader = new MyClassLoader();
        try {
            Class clazz_1 = loader.findClass(pluginName);
            return (Plugin) clazz_1.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
