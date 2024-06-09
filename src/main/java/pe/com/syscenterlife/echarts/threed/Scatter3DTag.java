
package pe.com.syscenterlife.echarts.threed;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
/**
 * La clase {@code Scatter3DTag} genera un gráfico 3D utilizando ECharts en una página JSP.
 * Esta clase permite la configuración de datos, tipo de serie, dimensiones de la caja 3D,
 * y otras propiedades del gráfico.
 * <p>
 * Ejemplo de uso en JSP:
 * </p>
 * <pre>
 * {@code
 * <custom:scatter3DTag idCharts="scatter3DChart" dataValues="..." ... />
 * }
 * </pre>
 * 
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class Scatter3DTag  extends BodyTagSupport{
    /**
     * Logger para registrar eventos y errores.
     */    
    protected static final Logger logger = Logger.getLogger(Scatter3DTag.class.getName());
    /**
     * Identificador del div que contendrá el gráfico.
     */
    @Getter @Setter
    String idCharts; 
    /**
     * Dimensiones de la caja 3D en el gráfico (ancho, profundidad, altura).
     */    
    @Getter @Setter
    int[] grid3DBoxXYZ={100,100,100};
    /**
     * Tipo de serie en ECharts (e.g., scatter3D, line3D, surface).
     */    
    @Getter @Setter
    String seriesTypeEchart="scatter3D";  /*line3D,surface,scatter3D*/ 
    /**
     * Datos del gráfico en formato JSON.
     */    
    @Getter @Setter
    private transient JSONArray dataValues;   
    /**
     * Altura del contenedor del gráfico.
     */    
    @Getter @Setter
    String height="400px";  
    /**
     * Ancho del contenedor del gráfico.
     */    
    @Getter @Setter
    String width="600px";     
    /**
     * Contexto de la página JSP.
     */    
    private transient PageContext pageContextR;
    /**
     * Constructor por defecto.
     */
    public Scatter3DTag() {
    
    }   
    /**
     * Constructor con contexto de página.
     * 
     * @param pageContextxx el contexto de la página JSP.
     */    
    public Scatter3DTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }   
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico 3D en la página web.
     * 
     * @return {@code SKIP_BODY} para indicar que el cuerpo de la etiqueta debe ser ignorado.
     * @throws JspException si ocurre un error durante la ejecución de la etiqueta.
     */    
    @Override
    public int doEndTag() throws JspException {
        // Convierte las dimensiones de la caja 3D a JSON para el script.
        JSONArray grid3DBoxXYZx= new JSONArray(grid3DBoxXYZ);
        try {
             // Genera el código HTML y JavaScript para el gráfico.
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "<div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 5px;\"></div>\n" +
                    "<script>\n" +
                    "    var chart = echarts.init(document.getElementById('" + idCharts + "'));\n" +
                    "    var data = " + dataValues + ";           \n" +
                    "    var grid3DBoxXYZ = " + grid3DBoxXYZx + ";           \n" +
                    "    chart.setOption({\n" +
                    "        tooltip: {},\n" +
                    "        visualMap: {\n" +
                    "            show: true,\n" +
                    "            min: 2,\n" +
                    "            max: 6,\n" +
                    "            inRange: {\n" +
                    "                symbolSize: [0.5, 15],\n" +
                    "                color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026'],\n" +
                    "                colorAlpha: [0.2, 1]}\n" +
                    "        },\n" +
                    "        xAxis3D: {type: 'value'},\n" +
                    "        yAxis3D: {type: 'value'},\n" +
                    "        zAxis3D: {type: 'value'},\n" +
                    "        grid3D: {\n" +
                    "            boxWidth: grid3DBoxXYZ[0],\n" +
                    "            boxDepth: grid3DBoxXYZ[1],\n" +
                    "            boxHeight: grid3DBoxXYZ[2],\n" +
                    "            viewControl: {}\n" +
                    "        },\n" +
                    "        toolbox: {show : true,\n" +
                    "        feature : {mark : {show: true},dataView : {show: true, readOnly: false},saveAsImage : {show: true}}},				\n" +
                    "        series: [{ type: '" + seriesTypeEchart + "', /*line3D,surface,scatter3D*/data: data}]\n" +
                    "    });\n" +
                    "    window.onresize = chart.resize;\n" +
                    "</script>");
             // Añade el gráfico al contexto de la página.
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Scatter3D: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Scatter3D: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Scatter3D: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Scatter3D: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Scatter3D: {0}", e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }  
    /**
     * Método que se llama al inicio de la etiqueta.
     * Inicializa el contexto de la página JSP.
     * 
     * @return {@code SKIP_BODY} para indicar que el cuerpo de la etiqueta debe ser ignorado.
     * @throws JspException si ocurre un error durante la ejecución de la etiqueta.
     */    
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }    
}
