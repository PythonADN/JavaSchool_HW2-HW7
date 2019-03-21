package HW_7.task_1.plugins.plugin_1;

import HW_7.task_1.Plugin;

public class PluginImpl implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("plugin_1");
        new InnerClass().methor();
    }
}
