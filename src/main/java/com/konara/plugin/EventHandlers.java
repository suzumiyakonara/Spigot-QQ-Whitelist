package com.konara.plugin;

import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MessageEvent;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class EventHandlers extends SimpleListenerHost {
    String keyword="whitelist";
    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception){
        // 处理事件处理时抛出的异常
    }
    @EventHandler
    public void onMessage(@NotNull MessageEvent event) throws Exception { // 抛出任何异常, 将在 handleException 处理
        long sender=event.getSender().getId();
		//以下或运算中为有权限的QQ号
        if(sender==2803530123L||sender==2803530124L||sender==2803530125L)
        {
            //event.getSender().sendMessage(event.getMessage().contentToString().substring(0,keyword.length()));
            if(event.getMessage().contentToString().length()>=keyword.length()+1)
                if((event.getMessage().contentToString().substring(0, keyword.length())).equals(keyword))
                {
                    String playername=event.getMessage().contentToString().substring(keyword.length()+1);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "whitelist add " + playername);
                    event.getSender().sendMessage("Added "+ playername +" to the whitelist.");
                }
             if((event.getMessage().contentToString().substring(0,1)).equals("/"))
             {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),event.getMessage().contentToString().substring(1));
                    event.getSender().sendMessage("The command is executed. ");
             }
         }
    }
}
