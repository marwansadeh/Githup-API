package common;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

public final class PropertyReader {

    private static String environment;
    private static String  DEFAULT_PROPERTIES_FILE;
    private Properties defaultProps = new Properties();
    private Hashtable listeners = null;
    private static Object lock = new Object();
    private static PropertyReader instance  = null;

    public PropertyReader() {
    }

    public static PropertyReader shared(){
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new PropertyReader();
                    instance.loadProperties();
                }
            }
        }
        return (instance);

    }

    private void loadProperties() {
        // create and load default properties
        FileInputStream in = null;
        try {
            in = new FileInputStream(getPropertyPath());

            defaultProps.load(in);
            in.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void storeProperties() throws IOException {
        FileOutputStream out = new FileOutputStream(getPropertyPath());
        defaultProps.store(out, "---Default properties---");
        out.close();
    }

    public String getProperty(String key) {
        String val = null;
        if (key != null) {
            if (val == null) {
                val = defaultProps.getProperty(key);
            }
        }
        return (val);
    }

    /**
     * Sets Application/User String properties; default property values cannot be set.
     */
    public void setProperty(String key, String val) {

        ArrayList list  = null;
        Object oldValue = null;
        oldValue = getProperty(key);

        if (listeners.containsKey(key)) {
            list = (ArrayList)listeners.get(key);
            int len = list.size();
            if (len > 0) {
                PropertyChangeEvent evt = new PropertyChangeEvent(this, key, oldValue, val);
                for (int i=0; i < len; i++) {
                    if (list.get(i) instanceof PropertyChangeListener)
                        ((PropertyChangeListener)list.get(i)).propertyChange(evt);
                }
            }
        }
    }

    private String getPropertyPath(){
        environment = (System.getProperty(Constant.ENVIRONMENT) != null) ? System.getProperty(Constant.ENVIRONMENT) : "TestEnvironment";
        DEFAULT_PROPERTIES_FILE = "src"+File.separator+"main"+File.separator+"resources"+File.separator+environment+".properties";
        return DEFAULT_PROPERTIES_FILE;
    }
}
