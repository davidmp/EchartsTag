
package pe.com.syscenterlife.echarts.twod.bar;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * La clase {@code BarTag} proporciona una etiqueta personalizada para generar gráficos de barras utilizando la biblioteca ECharts en páginas JSP.
 * Esta etiqueta permite configurar datos, títulos, orientación del gráfico, dimensiones, y otras propiedades del gráfico.
 *
 * Ejemplo de uso en JSP:
 * {@code
 * <custom:barTag idCharts="barChart" dataLabel="..." dataValuesEjeBase="..." dataValues="..." ... />
 * }
 *
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class BarTag extends BodyTagSupport {
    /**
     * Etiquetas de datos.
     */
    @Getter
    @Setter
    private transient LinkedHashMap<String, Object> dataLabel;
    /**
     * Valores del eje base en formato array JSON.
     */
    @Getter
    @Setter
    private transient JSONArray dataValuesEjeBase;
    /**
     * Valores de los datos en formato JSON.
     */
    @Getter
    @Setter
    private transient JSONObject dataValues;
    /**
     * Identificador del div que contendrá el gráfico.
     */
    @Getter
    @Setter
    public String idCharts;
   /**
     * Clase CSS para el contenedor del gráfico.
     */
    @Getter
    @Setter
    public String classCharts;
    /**
     * Orientación del gráfico de barras (horizontal o vertical).
     */
    @Getter
    @Setter
    public String orientationChart = "horizontal";
    /**
     * Altura del contenedor del gráfico.
     */
    @Getter
    @Setter
    public String height = "400px";
    /**
     * Ancho del contenedor del gráfico.
     */    
    @Getter
    @Setter
    public String width = "400px";
   
    /**
     * Logger para registrar eventos y errores.
     */
    protected static final Logger logger = Logger.getLogger(BarTag.class.getName());
    /**
     * Contexto de la página JSP.
     */    
    private transient PageContext pageContextR;
    /**
     * Constructor por defecto.
     */    
    public BarTag(){     
    }
    /**
     * Constructor con contexto de página.
     * 
     * @param pageContextxx el contexto de la página JSP.
     */    
    public BarTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico de barras en la página web.
     * 
     * @return {@code SKIP_BODY} para indicar que el cuerpo de la etiqueta debe ser ignorado.
     * @throws JspException si ocurre un error durante la ejecución de la etiqueta.
     */
    @Override
    public int doEndTag() throws JspException {
        // Obtiene el tema de ECharts desde la sesión HTTP o usa uno predeterminado.
        String theme;
        theme=(String)(((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme")==null? "shine":((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme"));
        // Define los nombres de los ejes X e Y según la orientación del gráfico.
        JSONArray dataLabelx = (JSONArray) dataLabel.get("Categoria");
        JSONArray dataLabely = (JSONArray) dataLabel.get("stack");
        JSONArray dataLabelz = (JSONArray) dataLabel.get("position");
        String ejeA = "xAxis";
        String ejeB = "yAxis";

        if (orientationChart.equals("vertical")) {
            ejeA = "yAxis";
            ejeB = "xAxis";
        }

        try {
            // Genera el código HTML y JavaScript para el gráfico de barras.
            StringBuilder chartImage = new StringBuilder();
            String[] elementNames = JSONObject.getNames(dataValues);

            
            chartImage.append("        <div id=\"" + idCharts + "\" class=\"" + classCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 10px;\"></div>\n"
                    + "        <script>\n"
                    // + "                var chart = echarts.init(document.getElementById('" + idCharts + "'));\n"
                    + "               var chart = echarts.init(document.getElementById('" + idCharts + "'), '"+theme+"'); //light, dark, default\n"
                    + "\n"
                    + "                chart.setOption({\n"
                    + "                    aria: {\n"
                    + "                        show: true,\n"
                    + "                        series: {\n"
                    + "                            multiple: {\n"
                    + "                                prefix: '{seriesCount}La serie de gráficos compone el gráfico.'\n"
                    + "                            }}},\n"
                    + "                    tooltip : {\n"
                    + "                        trigger: 'axis',\n"
                    + "                        axisPointer : {            // \n"
                    + "                            type : 'shadow'        // 'line' | 'shadow'\n"
                            + "}},\n"+
                    "        toolbox: {\n" +
                    "            orient: 'vertical',\n" +
                    "            left: 'right',\n" +
                    "            top: 'center',\n" +
                    "            feature: {\n" +
                    "                magicType: {\n" +
                    "                    type: ['line', 'bar'] },\n" +
                    "                dataView: {},\n" +
                    "                saveAsImage: {\n" +
                    "                    pixelRatio: 2\n" +
                    "                },\n" +
                    "                restore: {}\n" +
                    "            },\n" +
                    "\n" +
                    "            iconStyle: {\n" +
                    "                emphasis: {\n" +
                    "                    textPosition: 'top'                                \n" +
                    "                } }\n" +
                    "        },\n" +                            
                            
                    "                    legend: {\n"
                    + "                        data:" + dataLabelx + "},\n"
                    + "                    grid: {\n"
                    + "                        left: '3%',\n"
                    + "                        right: '4%',\n"
                    + "                        bottom: '3%',\n"
                    + "                        containLabel: true\n"
                    + "                    },\n"
                    + "                    " + ejeA + " : [\n"
                    + "                        {\n"
                    + "                            type : 'value'}],\n"
                    + "                    " + ejeB + " : [\n"
                    + "                        {\n"
                    + "                            type : 'category',\n"
                    + "                            axisTick : {show: false},\n"
                    + "                            data : " + dataValuesEjeBase + " }\n"
                    + "                    ],\n"
                    + "                    series : [\n");

            for (int i = 0, size = dataLabelx.length(); i < size; i++) {
                if (i == 0) {
                    chartImage.append("{\n"
                            + "                            name:'" + dataLabelx.get(i) + "',\n"
                            + "                            type:'bar',\n"
                            + "                            stack: '" + dataLabely.get(i) + "',\n"
                            + "                            label: {\n"
                            + "                                normal: {\n"
                            + "                                    show: true,\n"
                            + "                                    position: '" + dataLabelz.get(i) + "'\n"
                            + "                                }\n"
                            + "                            },\n"
                            + "                            data:" + dataValues.get(elementNames[i]) + "\n"
                            + "                        } \n");
                } else {
                    chartImage.append(",{\n"
                            + "                            name:'" + dataLabelx.get(i) + "',\n"
                            + "                            type:'bar',\n"
                            + "                            stack: '" + dataLabely.get(i) + "',\n"
                            + "                            label: {\n"
                            + "                                normal: {\n"
                            + "                                    show: true,\n"
                            + "                                    position: '" + dataLabelz.get(i) + "'\n"
                            + "                                }\n"
                            + "                            },\n"
                            + "                            data:" + dataValues.get(elementNames[i]) + "\n"
                            + "                        }\n");
                }
            }

            chartImage.append("                    ]\n"
                    + "                });\n"
                    + "\n"
                    + "                window.onresize = chart.resize;\n"
                    + "        </script>");
            // Añade el gráfico al contexto de la página.
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Bar: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Bar: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Bar: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Bar: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Bar: {0}", e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }
    /**
     * Método que se llama al iniciar la etiqueta. Asigna el contexto de la página.
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
