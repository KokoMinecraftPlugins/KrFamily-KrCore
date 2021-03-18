package me.kokored.krcore;

import me.kokored.krcore.api.MySQL;
import org.bukkit.plugin.java.JavaPlugin;

public final class KrCore extends JavaPlugin {

    MySQL mySQL;

    @Override
    public void onEnable() {

        getLogger().info(getLogo());
        getLogger().info("\n" +
                " {}===================================[ Enabled KrCore ]==================================={} " + "\n" +
                " ||                                                                                        || " + "\n" +
                " ||  Plugin  : KrCore                                                                      || " + "\n" +
                " ||  Author  : Koko_red                                                                    || " + "\n" +
                " ||  Website : https://kokominecraftplugins.github.io/threads/plugins/krcore.2103100.html  || " + "\n" +
                " ||                                                                                        || " + "\n" +
                " {}===================================[ Enabled KrCore ]==================================={} ");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        setupAPI();

    }

    private void setupAPI() {

        mySQL = new MySQL();

    }

    @Override
    public void onDisable() {

        getLogger().info(getLogo());
        getLogger().info("\n" +
                " {}===================================[ Disabled KrCore ]==================================={} " + "\n" +
                " ||                                                                                         || " + "\n" +
                " ||  Plugin  : KrCore                                                                       || " + "\n" +
                " ||  Author  : Koko_red                                                                     || " + "\n" +
                " ||  Website : https://kokominecraftplugins.github.io/threads/plugins/krcore.2103100.html   || " + "\n" +
                " ||                                                                                         || " + "\n" +
                " {}===================================[ Disabled KrCore ]==================================={} ");

        mySQL.disconnect();

    }

    private String getLogo() {
        String logo = "\n" +
                "      ||||    ||||                   ||||||||||||                                                      " + "\n" +
                "      ||||   ||||                  ||||        |||                                                     " + "\n" +
                "      ||||  ||||     ||||    |||   ||||                ||||||||||     ||||    |||                      " + "\n" +
                "      |||||||||      ||||  ||||    ||||              |||        |||   ||||  ||||       ||||||||        " + "\n" +
                "      |||||||||      ||||||||      ||||              |||        |||   ||||||||       |||      |||      " + "\n" +
                "      ||||  ||||     |||||         ||||         ||   |||        |||   |||||          ||||||||||        " + "\n" +
                "      ||||   ||||    ||||          ||||       ||||   |||        |||   ||||           |||       ||      " + "\n" +
                "      ||||    ||||   ||||            |||||||||||       ||||||||||     ||||             |||||||||       ";
        return logo;
    }

}
