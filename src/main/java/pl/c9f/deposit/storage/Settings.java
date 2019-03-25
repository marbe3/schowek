package pl.c9f.deposit.storage;

import pl.c9f.deposit.Main;

public class Settings {

    private final Main plugin;
    private String mysqlHost;
    private int mysqlPort;
    private String mysqlUser;
    private String mysqlBase;
    private String mysqlPassword;
    private String guiName;
    private String koxName;
    private String gAppleName;
    private String pearlName;
    private String arrowName;
    private String limitLore;
    private String numberLore;
    private int koxLimit;
    private int gAppleLimit;
    private int pearlLimit;
    private int arrowLimit;

    public Settings(Main plugin) {
        this.plugin = plugin;
    }

    public void load() {
        this.plugin.saveDefaultConfig();
        this.mysqlHost = this.plugin.getConfig().getString("mysql.host");
        this.mysqlPort = this.plugin.getConfig().getInt("mysql.port");
        this.mysqlUser = this.plugin.getConfig().getString("mysql.user");
        this.mysqlBase = this.plugin.getConfig().getString("mysql.base");
        this.mysqlPassword = this.plugin.getConfig().getString("mysql.password");
        this.guiName = this.plugin.getConfig().getString("gui-name");
        this.koxName = this.plugin.getConfig().getString("kox-name");
        this.gAppleName = this.plugin.getConfig().getString("gApple-name");
        this.pearlName = this.plugin.getConfig().getString("pearl-name");
        this.arrowName = this.plugin.getConfig().getString("arrow-name");
        this.limitLore = this.plugin.getConfig().getString("limit-lore");
        this.numberLore = this.plugin.getConfig().getString("amount-lore");
        this.koxLimit = this.plugin.getConfig().getInt("kox-limit");
        this.gAppleLimit = this.plugin.getConfig().getInt("gApple-limit");
        this.pearlLimit = this.plugin.getConfig().getInt("pearl-limit");
        this.arrowLimit = this.plugin.getConfig().getInt("arrow-limit");
    }

    public String getMysqlHost() {
        return this.mysqlHost;
    }

    public int getMysqlPort() {
        return this.mysqlPort;
    }

    public String getMysqlUser() {
        return this.mysqlUser;
    }

    public String getMysqlBase() {
        return this.mysqlBase;
    }

    public String getMysqlPassword() {
        return this.mysqlPassword;
    }

    public String getGuiName() {
        return this.guiName;
    }

    public String getKoxName() {
        return this.koxName;
    }

    public String getGAppleName() {
        return this.gAppleName;
    }

    public String getPearlName() {
        return this.pearlName;
    }

    public String getArrowName() {
        return this.arrowName;
    }

    public String getLimitLore() {
        return this.limitLore;
    }

    public String getNumberLore() {
        return this.numberLore;
    }

    public int getKoxLimit() {
        return this.koxLimit;
    }

    public int getGAppleLimit() {
        return this.gAppleLimit;
    }

    public int getPearlLimit() {
        return this.pearlLimit;
    }

    public int getArrowLimit() {
        return this.arrowLimit;
    }
}
