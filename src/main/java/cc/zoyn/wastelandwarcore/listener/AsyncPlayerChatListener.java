package cc.zoyn.wastelandwarcore.listener;

import cc.zoyn.wastelandwarcore.api.CoreAPI;
import cc.zoyn.wastelandwarcore.module.common.chat.Channel;
import cc.zoyn.wastelandwarcore.module.common.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * @author Zoyn
 * @since 2017-12-16
 */
public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        // 获取 User 对象
        User user = CoreAPI.getUserManager().getUserByName(player.getName());
        Channel channel = user.getChannel();
        // 发送消息
        String message = channel.sendMessage(user, event.getMessage());

        // 给控制台发送频道信息, 防止出现无法进行信息跟踪
        Bukkit.getConsoleSender().sendMessage(message);
        event.setCancelled(true);
    }

}
