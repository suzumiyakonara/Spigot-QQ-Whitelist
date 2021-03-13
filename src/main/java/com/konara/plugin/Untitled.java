package com.konara.plugin;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.events.BotEvent;
import net.mamoe.mirai.utils.BotConfiguration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Untitled extends JavaPlugin {
    private static final long QQNUM = 0000000000L;
    private static final String QQPWD = "your password";
    static Bot bot = BotFactory.INSTANCE.newBot(QQNUM, QQPWD, new BotConfiguration() {{
        // 配置，例如：
        fileBasedDeviceInfo();
    }});
    Thread thread=new Thread(new Runnable(){
        public void run(){
            EventChannel<BotEvent> channel = bot.getEventChannel();
            bot.login();
            channel.registerListenerHost(new EventHandlers());
        }});
    @Override
    public void onEnable() {
        // Plugin startup logic
        thread.start();
        getLogger().info("\u767d\u540d\u5355\u7ba1\u7406\u5df2\u542f\u52a8");
        getLogger().info("========================================");
        getLogger().info("|");
        getLogger().info("| \u4e3a\u4e86\u5b89\u5168\u8d77\u89c1");
        getLogger().info("| \u5efa\u8bae\u5728\u670d\u52a1\u7aef\u542f\u52a8\u53c2\u6570\u4e2d\u52a0 -Dmirai.slider.captcha.supported");
        getLogger().info("| \u4ee5\u4fdd\u8bc1\u6ed1\u5757\u9a8c\u8bc1\u7684\u8fdb\u884c");
        getLogger().info("|");
        getLogger().info("========================================");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("loginbot")) {
            getLogger().info("Logining.........");
            bot.login();
            return true;
        } //如果以上内容成功执行，则返回true
        // 如果执行失败，则返回false.
        return false;
    }
}
