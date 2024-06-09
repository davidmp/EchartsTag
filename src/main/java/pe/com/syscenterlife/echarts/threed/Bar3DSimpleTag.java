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
 * La clase {@code Bar3DSimpleTag} genera un gráfico 3D en ECharts con diversas
 * configuraciones visuales y de interacción. Esta clase extiende
 * {@link BodyTagSupport} y permite configurar diferentes atributos relacionados
 * con el gráfico 3D, como las dimensiones, rotación automática y los valores de
 * los datos.
 * <p>
 * Ejemplo de uso en una página JSP:
 * </p>
 * <pre>
 * {@code
 * <custom:bar3DSimpleTag idCharts="myChart" visualMapMinMax="2,6" ... />
 * }
 * </pre>
 *
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */
public class Bar3DSimpleTag extends BodyTagSupport {

    /**
     * Logger para registrar eventos y errores.
     */
    protected static final Logger logger = Logger.getLogger(Bar3DSimpleTag.class.getName());
    /**
     * Identificador del div que contendrá el gráfico.
     */
    @Getter
    @Setter
    String idCharts;
    /**
     * Rango mínimo y máximo del mapa visual.
     */    
    @Getter
    @Setter
    int[] visualMapMinMax = {2, 6};
    /**
     * Rango mínimo y máximo para el eje Z en 3D.
     */
    @Getter
    @Setter
    int[] z3DMinMax = {0, 10};
    /**
     * Ancho y profundidad de la caja 3D.
     */    
    @Getter
    @Setter
    int[] grid3DboxWidthDepth = {200, 80};
    /**
     * Controla si la vista se rota automáticamente.
     */    
    @Getter
    @Setter
    boolean viewControlAutoRotate = false;
    /**
     * Intensidad de la luz en la escena 3D.
     */    
    @Getter
    @Setter
    double lightIntensity = 0.2;
    /**
     * Tipo de serie en ECharts (e.g., bar3D,line3D,surface,scatter3D).
     */    
    @Getter
    @Setter
    String seriesTypeEchart = "bar3D";
    /**
     * Valores de los datos para el gráfico. 
     */
    @Getter
    @Setter
    private transient JSONArray dataValues;
    /**
     * Estilo de normalidad y énfasis para los elementos gráficos.
     */    
    /*0.4, 0.4*/
    @Getter
    @Setter
    double[] styleNormalEmphasis = {1, 1};
    /**
     * Altura del contenedor del gráfico. 
     */    
    @Getter
    @Setter
    String height = "400px";
    /**
     * Ancho del contenedor del gráfico. 
     */    
    @Getter
    @Setter
    String width = "600px";
    /**
     * Contexto de la página JSP.
     */
    private transient PageContext pageContextR;
    /**
     * Constructor por defecto.
     */
    public Bar3DSimpleTag() {
    }
     /**
     * Constructor con contexto de página.
     * 
     * @param pageContextxx el contexto de la página JSP.
     */
    public Bar3DSimpleTag(PageContext pageContextxx) {
        pageContextR = pageContextxx;
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
        JSONArray typeEjesXYZx = new JSONArray(visualMapMinMax);
        JSONArray zAxis3DMinMaxx = new JSONArray(z3DMinMax);
        JSONArray grid3DboxWidthDepthx = new JSONArray(grid3DboxWidthDepth);
        JSONArray styleNormalEmphasisx = new JSONArray(styleNormalEmphasis);

        try {
            // Genera el código HTML y JavaScript para el gráfico
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""
                    + "<div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 10px;\"></div>\n"
                    + "        <script>\n"
                    + "            var chart = echarts.init(document.getElementById('" + idCharts + "'));\n"
                    + "            \n"
                    + "            var visualMapMinMax=" + typeEjesXYZx + ";\n"
                    + "            var zAxis3DMinMax=" + zAxis3DMinMaxx + ";\n"
                    + "            var grid3DboxWidthDepth=" + grid3DboxWidthDepthx + ";\n"
                    + "            var styleNormalEmphasis=" + styleNormalEmphasisx + ";\n"
                    + "            \n"
                    + "            chart.setOption({\n"
                    + "                visualMap: {\n"
                    + "                    show: false, min: visualMapMinMax[0], max: visualMapMinMax[1],\n"
                    + "                    inRange: {\n"
                    + "                        color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']\n"
                    + "                    }\n"
                    + "                },\n"
                    + "                xAxis3D: {type: 'value'},\n"
                    + "                yAxis3D: {type: 'value'},\n"
                    + "                zAxis3D: {type: 'value', min: zAxis3DMinMax[0], max: zAxis3DMinMax[1],  axisPointer: { lineStyle: { color: '#009' } } },\n"
                    + "                grid3D: {boxWidth: grid3DboxWidthDepth[0],boxDepth: grid3DboxWidthDepth[1],                \n"
                    + "                    viewControl: { autoRotate: " + viewControlAutoRotate + "},                                       \n"
                    + "                    light: { main: {shadow: true, quality: 'ultra', intensity: " + lightIntensity + " /*1.5*/} }\n"
                    + "                },\n"
                    + "                toolbox: {show : true, \n"
                    + "                        feature : {mark : {show: true},dataView : {show: true, readOnly: false}, saveAsImage : {show: true} }\n"
                    + "                },				\n"
                    + "                series: [{\n"
                    + "                    type: '" + seriesTypeEchart + "',/*bar3D,line3D,surface,scatter3D*/\n"
                    + "                    data: " + dataValues + ",\n"
                    + "                    shading: 'lambert',\n"
                    + "                    label: {\n"
                    + "                        formatter: function (param) { return param.value[2].toFixed(1); }\n"
                    + "                    },\n"
                    + "                    itemStyle: {normal: { opacity: styleNormalEmphasis[0]/*0.2*/}, emphasis: {color: '#900',opacity: styleNormalEmphasis[1]/*0.4*/} }\n"
                    + "                }]\n"
                    + "            });\n"
                    + "            window.onresize = chart.resize;\n"
                    + "        </script>");

            pageContextR.getOut().append(chartImage);
        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Bar3DSimple: {0}", e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Bar3DSimple: {0}", e.getMessage());
        } catch (NumberFormatException e) {
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Bar3DSimple: {0}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Bar3DSimple: {0}", e.getMessage());
        } catch (RuntimeException e) {
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Bar3DSimple: {0}", e.getMessage());
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
        pageContextR = this.pageContext;
        return SKIP_BODY; //PUEDE SER 0
    }

}
