package org.y3.commons.fx.environment;

/** 
 * <p>Title: org.y3.commons.fx - FxJavaEnvironment</p>
 * <p>Description: </p>
 * <p>Copyright: 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class FxJavaEnvironment extends FxEnvironment {
    
    private String javaClassPath = System.getProperty("java.class.path");
    private String javaLocation = System.getProperty("java.home");
    private String javaTempDir = System.getProperty("java.io.tmpdir");
    private String javaVendor = System.getProperty("java.vendor");
    private String javaVendorUrl = System.getProperty("java.vendor.url");
    private String javaVersion = System.getProperty("java.version");

    public String getJavaClassPath() {
        return javaClassPath;
    }

    public void setJavaClassPath(String javaClassPath) {
        this.javaClassPath = javaClassPath;
    }

    public String getJavaLocation() {
        return javaLocation;
    }

    public void setJavaLocation(String javaLocation) {
        this.javaLocation = javaLocation;
    }

    public String getJavaTempDir() {
        return javaTempDir;
    }

    public void setJavaTempDir(String javaTempDir) {
        this.javaTempDir = javaTempDir;
    }

    public String getJavaVendor() {
        return javaVendor;
    }

    public void setJavaVendor(String javaVendor) {
        this.javaVendor = javaVendor;
    }

    public String getJavaVendorUrl() {
        return javaVendorUrl;
    }

    public void setJavaVendorUrl(String javaVendorUrl) {
        this.javaVendorUrl = javaVendorUrl;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

}
