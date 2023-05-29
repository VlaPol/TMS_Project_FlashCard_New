package by.tms.project_flashcard_new.utils;

import com.zaxxer.hikari.HikariConfig;

public class DBConnection {

    private static final HikariConfig CONFIG = new HikariConfig();

    static {
        CONFIG.setJdbcUrl(System.getenv("PG_CONNECTION"));
        CONFIG.setUsername(System.getenv("PG_USER"));
        CONFIG.setPassword(System.getenv("PG_PASSWORD"));
        CONFIG.setDriverClassName("org.postgresql.Driver");
    }

    private DBConnection(){}

    public static HikariConfig getHikariConfig(){
        return CONFIG;
    }


}
