package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author FRANCIS MCH
 */
public class PropertiesConf {

    String dataBase = null;
    String hostName = null;
    String port = null;
    String user = null;
    String password = null;
    String encrypting = null;
    String loginTimeOut = null;

    @Override
    public String toString() {
        return "PropertiesConf{" + "dataBase=" + dataBase + ", hostName=" + hostName + ", pot=" + port + ", user=" + user + ", password=" + password + ", encrypting=" + encrypting + ", loginTimeOut=" + loginTimeOut + '}';
    }

    public PropertiesConf() {
        try {


            Properties proper = new Properties();
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("Config/properties.properties");
            proper.load(inputStream);
            
            this.dataBase = proper.getProperty("dataBase");
            this.hostName = proper.getProperty("host");
            this.port = proper.getProperty("port");
            this.user = proper.getProperty("user");
            this.password = proper.getProperty("password");
            this.encrypting = proper.getProperty("encrypting");
            this.loginTimeOut = proper.getProperty("loginTimeout");

        } catch (IOException e) {
            System.err.println("" + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String pot) {
        this.port = pot;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncrypting() {
        return encrypting;
    }

    public void setEncrypting(String encrypting) {
        this.encrypting = encrypting;
    }

    public String getLoginTimeOut() {
        return loginTimeOut;
    }

    public void setLoginTimeOut(String loginTimeOut) {
        this.loginTimeOut = loginTimeOut;
    }

}
