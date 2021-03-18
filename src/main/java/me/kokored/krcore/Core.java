package me.kokored.krcore;

import java.sql.Connection;
import me.clip.placeholderapi.PlaceholderAPI;
import me.kokored.krcore.api.MySQL;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Core {

    private static final Plugin plugin = KrCore.getPlugin(KrCore.class);

    //PlaceholderAPI
    //Depend plugins: [ PlaceholderAPI ]
    public static String getPlaceholderText(Player player, String msg) {
        return PlaceholderAPI.setPlaceholders(player, msg);
    }

    //MySQL
    public static Boolean getSqlStatus() {
        return MySQL.getDbStats();
    }
    public static Connection getSqlConnection() {
        return MySQL.getConnection();
    }
    public static String getSqlDbName() {
        return plugin.getConfig().getString("SQL.database");
    }

}
