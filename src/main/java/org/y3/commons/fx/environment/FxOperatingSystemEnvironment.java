package org.y3.commons.fx.environment;

/** 
 * <p>Title: org.y3.commons.fx.environment - FxOperatingSystemEnvironment</p>
 * <p>Description: </p>
 * <p>Copyright: 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class FxOperatingSystemEnvironment extends FxEnvironment {

    private String osArchitecture = System.getProperty("os.arch");
    private String osFileSeparator = System.getProperty("file.separator");
    private String osLineSeparator = System.getProperty("line.separator");
    private String osName = System.getProperty("os.name");
    private String osPathSeparator = System.getProperty("path.separator");
    private String osUserDir = System.getProperty("user.dir");
    private String osUserHome = System.getProperty("user.home");
    private String osUserName = System.getProperty("user.name");
    private String osVersion = System.getProperty("os.version");

    public String getOsArchitecture() {
        return osArchitecture;
    }

    public void setOsArchitecture(String osArchitecture) {
        this.osArchitecture = osArchitecture;
    }

    public String getOsFileSeparator() {
        return osFileSeparator;
    }

    public void setOsFileSeparator(String osFileSeparator) {
        this.osFileSeparator = osFileSeparator;
    }

    public String getOsLineSeparator() {
        return osLineSeparator;
    }

    public void setOsLineSeparator(String osLineSeparator) {
        this.osLineSeparator = osLineSeparator;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsPathSeparator() {
        return osPathSeparator;
    }

    public void setOsPathSeparator(String osPathSeparator) {
        this.osPathSeparator = osPathSeparator;
    }

    public String getOsUserDir() {
        return osUserDir;
    }

    public void setOsUserDir(String osUserDir) {
        this.osUserDir = osUserDir;
    }

    public String getOsUserHome() {
        return osUserHome;
    }

    public void setOsUserHome(String osUserHome) {
        this.osUserHome = osUserHome;
    }

    public String getOsUserName() {
        return osUserName;
    }

    public void setOsUserName(String osUserName) {
        this.osUserName = osUserName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
    
}
