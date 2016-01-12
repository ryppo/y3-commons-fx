package org.y3.commons.fx.environment;

/** 
 * <p>Title: org.y3.commons.fx - FxEnvironment</p>
 * <p>Description: </p>
 * <p>Copyright: 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
 * @param <T>
*/
public abstract class FxEnvironment<T> {
    
    private T t;
    
    public T get() {
        return this.t;
    }
    
    public void set(T _t) {
        this.t = _t;
    }

}
