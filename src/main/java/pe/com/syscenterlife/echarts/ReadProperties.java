
package pe.com.syscenterlife.echarts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase {@code ReadProperties} se utiliza para cargar y gestionar propiedades 
 * desde un archivo de configuración. Ofrece métodos para obtener las propiedades 
 * predeterminadas y personalizadas.
 * <p>
 * Utiliza {@link Properties} para almacenar las configuraciones leídas y 
 * {@link Logger} para el registro de eventos.
 * </p>
 * <p>
 * Ejemplo de uso:
 * </p>
 * <pre>
 * {@code
 * ReadProperties readProperties = new ReadProperties("config.properties");
 * Properties props = readProperties.getPathFileCustom();
 * }
 * </pre>
 * 
 * @author davidmp et al.
 * @see Properties
 * @see Logger
 * @since 1.0
 */
public class ReadProperties {
    /**
     * Propiedades leídas desde el archivo de configuración.
     */
    private Properties propiedades;
    /**
     * Nombre del archivo de propiedades a leer.
     */      
    private final String archivo;
    /**
     * Logger para registrar información y errores.
     */ 
    @SuppressWarnings("NonConstantLogger")
    private final Logger logger;

     /**
     * Constructor que inicializa el objeto {@code ReadProperties} con el nombre 
     * del archivo de propiedades.
     *
     * @param archivo el nombre del archivo de propiedades.
     */  
    public ReadProperties(String archivo) {
        propiedades = new Properties();
        this.archivo = archivo;
        logger = Logger.getLogger(ReadProperties.class.getName());
    }


    /**
     * Carga y devuelve las propiedades desde el archivo predeterminado 
     * {@code syscenterlife.properties}.
     * <p>
     * El archivo se busca en el directorio de recursos del contexto de la aplicación.
     * </p>
     * 
     * @return las propiedades cargadas desde el archivo predeterminado.
     */
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
    /**
     * Carga y devuelve las propiedades desde el archivo personalizado especificado 
     * en el constructor.
     * <p>
     * El archivo se busca en el directorio de recursos del contexto de la aplicación.
     * </p>
     * 
     * @return las propiedades cargadas desde el archivo personalizado.
     */
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
