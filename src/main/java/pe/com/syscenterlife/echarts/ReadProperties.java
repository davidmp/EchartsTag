
package pe.com.syscenterlife.echarts;

/**
 *
 * @author davidmp
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadProperties {

    private Properties propiedades;
    private final String archivo;

    @SuppressWarnings("NonConstantLogger")
    private final Logger logger;

    
    public ReadProperties(String archivo) {
        propiedades = new Properties();
        this.archivo = archivo;
        logger = Logger.getLogger(ReadProperties.class.getName());
    }



    public Properties getPathFileDefault() {
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String path = classLoader.getResource("").getPath();
        String fullPath;
        propiedades = new Properties();
        try {
            fullPath = URLDecoder.decode(path, "UTF-8");
            propiedades.load(new BufferedReader(new FileReader(fullPath + "/syscenterlife.properties")));
        } catch (IOException e) {
            logger.log(Level.INFO, "Error al Leer el archivo Properties....: {0}", e.getMessage());
        }
        return propiedades;
    }

    public Properties getPathFileCustom() {        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = classLoader.getResource("").getPath();
        String fullPath;
        propiedades = new Properties();
        try {
            fullPath = URLDecoder.decode(path, "UTF-8");
            propiedades.load(new BufferedReader(new FileReader(fullPath + "/" + archivo)));
        } catch (IOException e) {
            logger.log(Level.INFO, "Error al Leer el archivo Properties....: {0}", e.getMessage());
        }
        return propiedades;
    }
}
