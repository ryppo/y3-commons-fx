package org.y3.commons.fx;

import java.util.HashMap;
import java.util.Map;
import org.y3.commons.fx.environment.FxEnvironment;
import org.y3.commons.fx.environment.FxJavaEnvironment;
import org.y3.commons.fx.environment.FxOperatingSystemEnvironment;

/** 
 * <p>Title: org.y3.commons.fx - FxContext</p>
 * <p>Description: </p>
 * <p>Copyright: 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class FxContext {
    
    private static final FxContext singleton = new FxContext();
    
    private final Map<Class, FxEnvironment> fxEnvironments;

    public FxContext() {
        fxEnvironments = new HashMap<>();
        fxEnvironments.put(FxJavaEnvironment.class, new FxJavaEnvironment());
        fxEnvironments.put(FxOperatingSystemEnvironment.class, new FxOperatingSystemEnvironment());
    }
    
    public static FxContext getInstance() {
        return singleton;
    }
    
    public Map<Class, FxEnvironment> getFxEnvironments() {
        return fxEnvironments;
    }
    
    public void addFxEnvironment(FxEnvironment _fxEnvironment) {
        fxEnvironments.put(_fxEnvironment.getClass(), _fxEnvironment);
    }
    
    public FxJavaEnvironment getFxJavaEnvironment() throws InstantiationException, IllegalAccessException {
        return getFxEnvironment(FxJavaEnvironment.class);
    }
    
    public FxOperatingSystemEnvironment getFxOperatingSystemEnvironment() throws InstantiationException, IllegalAccessException {
        return getFxEnvironment(FxOperatingSystemEnvironment.class);
    }

    public <T extends FxEnvironment> T getFxEnvironment(Class<T> classPlan) throws InstantiationException, IllegalAccessException {
        T fxEnvironment = (T) fxEnvironments.get(classPlan);
        if (fxEnvironment != null) {
            return fxEnvironment;
        } else {
            fxEnvironment = (T) classPlan.newInstance();
            fxEnvironments.put(classPlan, fxEnvironment);
            return fxEnvironment;
        }
    }
}
