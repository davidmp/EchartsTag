
package pe.com.syscenterlife.echarts.threed;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
/**
 * La clase {@code Bar3DStackTag} genera un gráfico 3D apilado en ECharts, configurado
 * mediante diversas opciones de estilo y control de la visualización. Extiende
 * {@link BodyTagSupport} y permite configurar atributos como el tipo de gráfico,
 * datos, dimensiones y opciones de rotación.
 * <p>
 * Ejemplo de uso en una página JSP:
 * </p>
 * <pre>
 * {@code
 * <custom:bar3DStackTag idCharts="chartStack" dataValues="..." ... />
 * }
 * </pre>
 * 
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */
public class Bar3DStackTag extends BodyTagSupport{
    /**
     * Logger para registrar eventos y errores.
     */    
    protected static final Logger logger = Logger.getLogger(Bar3DStackTag.class.getName());
    /**
     * Identificador del div que contendrá el gráfico.
     */    
    @Getter @Setter
    String idCharts="main";   
    /**
     * Tipo de serie en ECharts (e.g., bar3D,line3D,surface,scatter3D).
     */    
    @Getter @Setter
    String seriesTypeEchart="bar3D";  /*bar3D,line3D,surface,scatter3D*/
    /**
     * Valores de los datos para el gráfico.
     */    
    @Getter @Setter
    private transient JSONArray dataValues;
    /**
     * Estilo de normalidad y énfasis para los elementos gráficos.
     */    
    @Getter @Setter
    double[] styleNormalEmphasis={0.8,0.4};/*0.2, 0.4*/
    /**
     * Ancho y profundidad de la caja 3D.
     */    
    @Getter @Setter
    int[] grid3DboxWidthDepth={200,80};
    /**
     * Controla si la vista se rota automáticamente.
     */    
    @Getter @Setter
    boolean viewControlAutoRotate=false;
    /**
     * Intensidad de la luz en la escena 3D.
     */    
    @Getter @Setter
    double lightIntensity=0.8;    
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
    public Bar3DStackTag() {
    }
    /**
     * Constructor con contexto de página.
     * 
     * @param pageContextxx el contexto de la página JSP.
     */    
    public Bar3DStackTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico 3D apilado en la página web.
     * 
     * @return {@code SKIP_BODY} para indicar que el cuerpo de la etiqueta debe ser ignorado.
     * @throws JspException si ocurre un error durante la ejecución de la etiqueta.
     */
    @Override
    public int doEndTag() throws JspException {
        // Convierte los estilos y dimensiones a JSON para el script.
        JSONArray styleNormalEmphasisx= new JSONArray(styleNormalEmphasis); 
        JSONArray grid3DboxWidthDepthx= new JSONArray(grid3DboxWidthDepth); 
        try {   
            // Genera el código HTML y JavaScript para el gráfico
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""
                    + "      <div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 10px;\"></div>\n" +
                    "        <script>\n" +
                    "            var chart = echarts.init(document.getElementById('" + idCharts + "'));\n" +
                    "            var styleNormalEmphasis=" + styleNormalEmphasisx + ";\n" +
                    "            var grid3DboxWidthDepth=" + grid3DboxWidthDepthx + ";\n" +
                    "            var data=" + dataValues + "\n" +
                    "            var series = [];\n" +
                    "            for (var i = 0; i < 10; i++) {\n" +
                    "                series.push({\n" +
                    "                    type: '" + seriesTypeEchart + "', /*bar3D,line3D,surface,scatter3D*/\n" +
                    "                    data: data,\n" +
                    "                    stack: 'stack',\n" +
                    "                    shading: 'lambert',\n" +
                    "                    label: {\n" +
                    "                        normal: {textStyle: {fontSize: 16,borderWidth: 1,opacity: 1}},\n" +
                    "                        emphasis: {textStyle: {fontSize: 20,color: '#900',opacity: 1}},					\n" +
                    "                        formatter: function (param) {return param.value[2].toFixed(1);}\n" +
                    "                    },\n" +
                    "                    itemStyle: {normal: {opacity: styleNormalEmphasis[0]/*0.2*/},emphasis: {color: '#900',opacity: styleNormalEmphasis[1]}}					\n" +
                    "                });\n" +
                    "            }\n" +
                    "            chart.setOption({\n" +
                    "                tooltip: {},\n" +
                    "                xAxis3D: {type: 'value'},\n" +
                    "                yAxis3D: {type: 'value'},\n" +
                    "                zAxis3D: {type: 'value'},\n" +
                    "                grid3D: { boxWidth: grid3DboxWidthDepth[0], boxDepth: grid3DboxWidthDepth[1],\n" +
                    "                    viewControl: {autoRotate: " + viewControlAutoRotate + " },\n" +
                    "                    light: { main: {shadow: true},ambient: {intensity: " + lightIntensity + "/*0.8*/}}					\n" +
                    "                },                \n" +
                    "                toolbox: {show : true, feature : {mark : {show: true},dataView : {show: true, readOnly: false},saveAsImage : {show: true} } },				\n" +
                    "                series: series                			\n" +
                    "            });\n" +
                    "            window.onresize = chart.resize;\n" +
                    "        </script>");
            // Añade el gráfico al contexto de la página
            pageContextR.getOut().append(chartImage); 
        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Bar3dStack: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Bar3dStack: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Bar3dStack: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Bar3dStack: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Bar3dStack: {0}", e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }
    /**
     * Método que se llama al iniciar la etiqueta. Inicializa el contexto de la página JSP.
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
