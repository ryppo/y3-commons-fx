package org.y3.commons.fx;

import java.util.ResourceBundle;
import javafx.scene.image.Image;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;

/** 
 * <p>Title: org.y3.commons.fx - FxConfiguration</p>
 * <p>Description: </p>
 * <p>Copyright: 2015 - 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
@Log4j2
public abstract class FxConfiguration {
    
    private ResourceBundle bundle;

    public abstract String getResourceBundlePath();
    public abstract String getImagesPath();
    public abstract String getStylesheetPath();
    
    public abstract String getResourceBundleName();
    public abstract String getStylesheetName();
    
    public abstract Logger getLogger();
    
    public String getStylesheet() {
        return getClass().getClassLoader().getResource(getStylesheetPath() + "/" + getStylesheetName()).toExternalForm();
    }
    
    public Image getFxImage(String filename) {
        String resourcePath = getImagesPath() + "/" + filename;
        getLogger().debug("resourcePath: " + resourcePath);
        return new Image(getClass().getClassLoader().getResourceAsStream(resourcePath));
    }
    
    public String getRbString(String rbKey) {
        if (bundle == null) {
            String resourceBundlePath = getResourceBundlePath() + "/" + getResourceBundleName();
            getLogger().debug("resourceBundlePath: " + resourceBundlePath);
            bundle = ResourceBundle.getBundle(resourceBundlePath);
        }
        return bundle.getString(rbKey);
    }
    
}
