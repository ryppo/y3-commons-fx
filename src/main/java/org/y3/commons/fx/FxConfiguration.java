package org.y3.commons.fx;

import java.util.ResourceBundle;
import javafx.scene.image.Image;

/** 
 * <p>Title: org.y3.commons.fx - FxConfiguration</p>
 * <p>Description: </p>
 * <p>Copyright: 2015</p>
 * <p>Company: SE Bordnetze GmbH</p>
 * <p>Department: CIT SC GSD</p>
 * @author Christian.Rybotycky
 * @version $Id$
*/
public abstract class FxConfiguration {
    
    private ResourceBundle bundle;

    public abstract String getResourceBundlePath();
    public abstract String getImagesPath();
    public abstract String getStylesheetPath();
    
    public abstract String getResourceBundleName();
    public abstract String getStylesheetName();
    
    public String getStylesheet() {
        return getClass().getClassLoader().getResource(getStylesheetPath() + "/" + getStylesheetName()).toExternalForm();
    }
    
    public Image getFxImage(String filename) {
        String resourcePath = getImagesPath() + "/" + filename;
        System.out.println("resourcePath: " + resourcePath);
        return new Image(getClass().getClassLoader().getResourceAsStream(resourcePath));
    }
    
    public String getRbString(String rbKey) {
        if (bundle == null) {
            String resourceBundlePath = getResourceBundlePath() + "/" + getResourceBundleName();
            System.out.println("resourceBundlePath: " + resourceBundlePath);
            bundle = ResourceBundle.getBundle(resourceBundlePath);
        }
        return bundle.getString(rbKey);
    }
    
}
