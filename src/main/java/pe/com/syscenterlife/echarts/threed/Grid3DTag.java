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
 * La clase {@code Grid3DTag} genera un gráfico 3D en ECharts, permitiendo la
 * configuración de diversos atributos como datos, tipos de serie, dimensiones,
 * y colores. Extiende {@link BodyTagSupport} para su uso en páginas JSP.
 * <p>
 * Ejemplo de uso en JSP:
 * </p>
 * <pre>
 * {@code
 * <custom:grid3DTag idCharts="chart3D" dataValues="..." ... />
 * }
 * </pre>
 *
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class Grid3DTag extends BodyTagSupport {

    /**
     * Logger para registrar eventos y errores.
     */
    protected static final Logger logger = Logger.getLogger(Grid3DTag.class.getName());
    /**
     * Datos del gráfico en formato JSON.
     */
    @Getter
    @Setter
    private transient JSONArray dataValues;
    /**
     * Identificador del div que contendrá el gráfico.
     */
    @Getter
    @Setter
    String idCharts;
    /**
     * Etiquetas para el eje X.
     */
    @Getter
    @Setter
    private transient Object[] dataTagX;
    /**
     * Etiquetas para el eje Y.
     */
    @Getter
    @Setter
    private transient Object[] dataTagY;
    /**
     * Rango mínimo y máximo del eje Z.
     */
    @Getter
    @Setter
    int[] z3DMinMax = {0, 50};
    /**
     * Tipo de serie en ECharts (e.g., scatter3D, bar3D, line3D, surface).
     */
    @Getter
    @Setter
    String seriesTypeEchart = "scatter3D";
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
     * Color de la serie.
     */
    @Getter
    @Setter
    String color = "red";
    /**
     * Contexto de la página JSP.
     */
    private transient PageContext pageContextR;

    /**
     * Constructor por defecto.
     */
    public Grid3DTag() {

    }

    /**
     * Constructor con contexto de página.
     *
     * @param pageContextxx el contexto de la página JSP.
     */
    public Grid3DTag(PageContext pageContextxx) {
        pageContextR = pageContextxx;
    }

    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y
     * JavaScript necesario para renderizar el gráfico 3D en la página web.
     *
     * @return {@code SKIP_BODY} para indicar que el cuerpo de la etiqueta debe
     * ser ignorado.
     * @throws JspException si ocurre un error durante la ejecución de la
     * etiqueta.
     */
    @Override
    public int doEndTag() throws JspException {
        // Convierte dimensiones a enteros removiendo "px".
        int widthX = Integer.parseInt(width.substring(0, width.length() - 2));
        int heightX = Integer.parseInt(height.substring(0, height.length() - 2));
        // Convierte las configuraciones a JSON para el script.
        JSONArray dataTagXX = new JSONArray(dataTagX);
        JSONArray dataTagYX = new JSONArray(dataTagY);
        JSONArray zAxis3DMinMaxx = new JSONArray(z3DMinMax);

        try {
            // Genera el código HTML y JavaScript para el gráfico.
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""
                    + "<div id=\"" + idCharts + "\"  style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 10px;\"></div>\n"
                    + "        <script>\n"
                    + "            var chart = echarts.init(document.getElementById('" + idCharts + "'));\n"
                    + "            var datax = " + dataValues + ";\n"
                    + "            var zAxis3DMinMaxx=" + zAxis3DMinMaxx + ";\n"
                    + "            chart.setOption({\n"
                    + "                backgroundColor: '#fff',\n"
                    + "                xAxis3D: [{type: 'category',\n"
                    + "                    data: " + dataTagXX + "\n"
                    + "                }, {type: 'value',min: -1,max: 1,grid3DIndex: 1}],\n"
                    + "                yAxis3D: [{type: 'category',\n"
                    + "                    data: " + dataTagYX + "\n"
                    + "                }, {type: 'value',min: -1,max: 1,grid3DIndex: 1 }],            \n"
                    + "                zAxis3D: [{type: 'value',min: zAxis3DMinMaxx[0], max: zAxis3DMinMaxx[1]}, {type: 'value',min: -1,max: 1,grid3DIndex: 1}],   \n"
                    + "                \n"
                    + "                grid3D: [{top: -50,width: " + widthX + ",height: " + (heightX + 100) + ",temporalSuperSampling: {enable: true} }, \n"
                    + "                    {top: 100,left: 700,temporalSuperSampling: {enable: true}}],					\n"
                    + "                toolbox: {show : true,\n"
                    + "                feature : {mark : {show: true},dataView : {show: true, readOnly: false},saveAsImage : {show: true}}},				\n"
                    + "                series: [{\n"
                    + "                    type: '" + seriesTypeEchart + "', /*bar3D,line3D,surface,scatter3D*/\n"
                    + "                    symbolSize: 20,\n"
                    + "                    data: datax, color:'" + color + "'\n"
                    + "                }]\n"
                    + "            });\n"
                    + "            window.addEventListener('resize', function () {\n"
                    + "                chart.resize();\n"
                    + "            });\n"
                    + "\n"
                    + "        </script>");
            // Añade el gráfico al contexto de la página.
            pageContextR.getOut().append(chartImage);

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Grid3D: {0}", e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Grid3D: {0}", e.getMessage());
        } catch (NumberFormatException e) {
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Grid3D: {0}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Grid3D: {0}", e.getMessage());
        } catch (RuntimeException e) {
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Grid3D: {0}", e.getMessage());
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
        pageContextR = this.pageContext;
        return SKIP_BODY; //PUEDE SER 0
    }
}
