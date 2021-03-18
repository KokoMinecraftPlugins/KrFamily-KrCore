package me.kokored.krcore.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import me.kokored.krcore.KrCore;
import org.bukkit.plugin.Plugin;

public class MySQL {

    Plugin plugin = KrCore.getPlugin(KrCore.class);

    static Connection connection;

    static Boolean dbstats = false;

    static String sqlType;
    static String host, database, username, password, SSL, autoReconnect;
    static int port;

    public MySQL() {
        sqlType = plugin.getConfig().getString("SQL.Type");

        host = plugin.getConfig().getString("SQL.host");
        port = plugin.getConfig().getInt("SQL.port");
        database = plugin.getConfig().getString("SQL.database");
        username = plugin.getConfig().getString("SQL.username");
        password = plugin.getConfig().getString("SQL.password");
        SSL = plugin.getConfig().getString("SQL.useSSL");
        autoReconnect = plugin.getConfig().getString("SQL.autoReconnect");

        if (sqlType.equals("MySQL") || sqlType.equals("MariaDB")) {

            if (database.equals("") || username.equals("") || password.equals("")) {
                plugin.getLogger().info("Database didn't setup, setup at config.yml file.");
                return;
            }

            try {
                plugin.getLogger().info("Trying to connect MySQL...");
                openConnection();
            } catch (ClassNotFoundException | SQLException e) {
                plugin.getLogger().warning("Fail to connect MySQL!");
                e.printStackTrace();
            }

            return;
        }
        plugin.getLogger().warning("MySQL type was not support...");
    }

    public void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return;
        }

        if (sqlType.equals("MySQL")) {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database
                            + "?useSSL=" + SSL + "&autoReconnect=" + autoReconnect,
                    this.username, this.password);

        }
        if (sqlType.equals("MariaDB")) {

            Class.forName("org.mariadb.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mariadb://" + this.host + ":" + this.port + "/" + this.database
                            + "?useSSL=" + SSL + "&autoReconnect=" + autoReconnect,
                    this.username, this.password);

        }
        dbstats = true;
        plugin.getLogger().info("Successfully connected to MySQL.");
    }

    public void disconnect() {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
            dbstats = false;
            plugin.getLogger().info("Successfully disconnected to MySQL.");
        } catch (SQLException e) {
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Boolean getDbStats() {
        return dbstats;
    }

}
