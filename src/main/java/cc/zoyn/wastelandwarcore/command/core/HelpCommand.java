package cc.zoyn.wastelandwarcore.command.core;

import cc.zoyn.wastelandwarcore.util.SubCommand;
import org.bukkit.command.CommandSender;

/**
 * 帮助命令
 *
 * @author Zoyn
 * @since 2017-12-23
 */
public class HelpCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("§8§l§m===========§7 [§6WastelandWarCore§7] §8§l§m===========");
        sender.sendMessage(" §b/core help §7查看帮助");
        sender.sendMessage(" §b/core whois user [用户名] §7查询该用户信息");
        sender.sendMessage(" §b/core whois town [城镇名] §7查询该城镇信息");
        sender.sendMessage(" §b/core save §7保存所有数据");
        sender.sendMessage(" §b/core item [武器名] §7获取该武器");
        sender.sendMessage(" §b/core create alliance [盟主名]§7创建联盟");
        sender.sendMessage(" ");
        sender.sendMessage(" §c/core take [玩家] [数量] [名称] §4移除指定数量的指定物品");
        sender.sendMessage(" §c/core upgrade §4升级你手中的武器");
    }
}
