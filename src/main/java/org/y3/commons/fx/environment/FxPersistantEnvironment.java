package org.y3.commons.fx.environment;

import java.math.BigDecimal;
import java.util.prefs.Preferences;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.validator.routines.BigDecimalValidator;
import org.apache.logging.log4j.Logger;

/** 
 * <p>Title: org.y3.commons.fx.environment - FxPersistantEnvironment</p>
 * <p>Description: </p>
 * <p>Copyright: 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
@Log4j2
public abstract class FxPersistantEnvironment extends FxEnvironment {
    
    public static enum PERSISTANCE_CONTEXT {OPERATING_SYSTEM, USER};
    
    private Preferences storage = null;
    
    public abstract PERSISTANCE_CONTEXT getPersistanceContext();
    
    public abstract Logger getLogger();
    
    public FxPersistantEnvironment() {
        if (getPersistanceContext().equals(PERSISTANCE_CONTEXT.OPERATING_SYSTEM)) {
            storage = Preferences.systemNodeForPackage(getClass());
        } else if (getPersistanceContext().equals(PERSISTANCE_CONTEXT.USER)) {
            storage = Preferences.userNodeForPackage(getClass());
        } else {
            getLogger().error("Persistant environment not instantiated. No valid PERSISTANCE_CONTEXT defined.");
        }
    }
    
    public void setStringAndEncrypt(String key, String value) {
        storage.putByteArray(key, value.getBytes());
    }
    
    public String getStringAndDecrypt(String key, String defaultValue) {
        byte[] byteArray = storage.getByteArray(key, defaultValue != null ? defaultValue.getBytes() : null);
        return byteArray != null ? new String(byteArray) : null;
    }
    
    public String getString(String key) {
        return getString(key, null);
    }
    
    public String getString(String key, Object defaultValue) {
        return storage.get(key, defaultValue != null ? defaultValue.toString() : null);
    }
    
    public void setString(String key, String value) {
        if (value == null) {
            storage.remove(key);
        } else {
            storage.put(key, value);
        }
    }
    
    public int get(String key, int defaultValue) {
        return storage.getInt(key, defaultValue);
    }
    
    public void set(String key, int value) {
        storage.putInt(key, value);
    }
    
    public Integer getInteger(String key) {
        return getInteger(key, null);
    }
    
    public Integer getInteger(String key, Integer defaultValue) {
        String value = getString(key);
        if (value == null) {
            return defaultValue;
        }
        return NumberUtils.isNumber(value) ? Integer.parseInt(value) : null;
    }
    
    public void setInteger(String key, Integer value) {
        setString(key, value == null ? null : Integer.toString(value));
    }
    
    public void set(String key, boolean value) {
        storage.putBoolean(key, value);
    }
    
    public Boolean getBoolean(String key) {
        return getBoolean(key, null);
    }
    
    public Boolean getBoolean(String key, Boolean defaultValue) {
        String value = getString(key);
        if (value == null) {
            return defaultValue;
        }
        return BooleanUtils.toBooleanObject(value);
    }
    
    public void setBoolean(String key, Boolean value) {
        setString(key, value == null ? null : Boolean.toString(value));
    }
    
    public double get(String key, double defaultValue) {
        return storage.getDouble(key, defaultValue);
    }
    
    public void set(String key, double value) {
        storage.putDouble(key, value);
    }
    
    public Double getDouble(String key) {
        return getDouble(key, null);
    }
    
    public Double getDouble(String key, Double defaultValue) {
        String value = getString(key);
        if (value == null) {
            return defaultValue;
        }
        return NumberUtils.isNumber(value) ? Double.parseDouble(value) : null;
    }
    
    public void setDouble(String key, Double value) {
        setString(key, value == null ? null : Double.toString(value));
    }
    
    public long get(String key, long defaultValue) {
        return storage.getLong(key, defaultValue);
    }
    
    public void set(String key, long value) {
        storage.putLong(key, value);
    }
    
    public Long getLong(String key) {
        return getLong(key, null);
    }
    
    public Long getLong(String key, Long defaultValue) {
        String value = getString(key);
        if (value == null) {
            return defaultValue;
        }
        return NumberUtils.isNumber(value) ? Long.parseLong(value) : null;
    }
    
    public void setLong(String key, Long value) {
        setString(key, value == null ? null : Long.toString(value));
    }
    
    public float get(String key, float defaultValue) {
        return storage.getFloat(key, defaultValue);
    }
    
    public void set(String key, float value) {
        storage.putFloat(key, value);
    }
    
    public Float getFloat(String key) {
        return getFloat(key, null);
    }
    
    public Float getFloat(String key, Float defaultValue) {
        String value = getString(key);
        if (value == null) {
            return defaultValue;
        }
        return NumberUtils.isNumber(value) ? Float.parseFloat(value) : null;
    }
    
    public void setFloat(String key, Float value) {
        setString(key, value == null ? null : Float.toString(value));
    }
    
    public BigDecimal getBigDecimal(String key) {
        return getBigDecimal(key, null);
    }
    
    public BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
        String value = getString(key);
        if (value == null) {
            return defaultValue;
        }
        return BigDecimalValidator.getInstance().validate(value);
    }
    
    public void setBigDecimal(String key, BigDecimal value) {
        setString(key, value == null ? null : value.toString());
    }

}
