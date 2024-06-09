
package pe.com.syscenterlife.echarts.twod.scatter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
/**
 * La clase {@code ScatterTag} proporciona una etiqueta personalizada para generar gráficos de dispersión
 * utilizando la biblioteca ECharts en páginas JSP.
 * Esta etiqueta permite configurar datos, leyendas, símbolos, estilos de etiquetas y otras propiedades del gráfico de dispersión.
 *
 * Ejemplo de uso en JSP:
 * {@code
 * <custom:scatterTag idCharts="scatterChart" dataValuesM="..." chartLegendNames="..." ... />
 * }
 *
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class ScatterTag extends BodyTagSupport{
    /**
     * Logger para registrar eventos y errores.
     */
    protected static final Logger logger = Logger.getLogger(ScatterTag.class.getName());
    /**
     * Identificador del div que contendrá el gráfico.
     */
    @Getter @Setter
    String idCharts; 
    /**
     * Datos para el gráfico de dispersión.
     */
    @Getter @Setter
    private transient Object[] dataValuesM;
    /**
     * Nombres de las leyendas del gráfico.
     */
    @Getter @Setter
    String[]  chartLegendNames;
    /**
     * Símbolos utilizados en el gráfico de dispersión. Ejem. 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow', 'none'.
     */
    @Getter @Setter
    String[] seriesSymbol={"circle","rect","triangle"};//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow', 'none'
    /**
     * Colores de las etiquetas del gráfico de dispersión. "black","red","blue"
     */
    @Getter @Setter
    String[] seriesLabelColor={"black","red","blue"};
    /**
     * Opacidad de los estilos de los elementos del gráfico de dispersión.
     */
    @Getter @Setter
    double[] seriesItemStyleOpacy={0.8,0.8,0.8};
    /**
     * Indica si se muestran las etiquetas en el gráfico de dispersión.
     */
    @Getter @Setter
    boolean[] seriesLabelShow={false,true,false};
    /**
     * Altura del contenedor del gráfico.
     */
    @Getter @Setter
    public String height = "460px";
    /**
     * Ancho del contenedor del gráfico.
     */
    @Getter @Setter
    public String width = "800px";
    
    /**
     * Contexto de la página JSP.
     */
    private transient PageContext pageContextR;
    /**
     * Constructor por defecto.
     */
    public ScatterTag() {
    }
    /**
     * Constructor con contexto de página.
     * 
     * @param pageContextxx el contexto de la página JSP.
     */
    public ScatterTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico de dispersión en la página web.
     * 
     * @return {@code SKIP_BODY} para indicar que el cuerpo de la etiqueta debe ser ignorado.
     * @throws JspException si ocurre un error durante la ejecución de la etiqueta.
     */
    @Override
    public int doEndTag() throws JspException {
        // Obtiene el tema de ECharts desde la sesión HTTP.
        String theme;
        theme=(String)((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme");
        // Convierte los nombres de las leyendas a formato JSON.
        JSONArray chartLegendNamesX=new JSONArray(chartLegendNames);
        // Convierte los datos del gráfico de dispersión a formato JSON.
        JSONArray dataValuesMX= new JSONArray(dataValuesM);
        try {
            // Genera el código HTML y JavaScript para el gráfico de dispersión.
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "<div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
                    "<script>\n" +
                    "        var chart = echarts.init(document.getElementById('" + idCharts + "'),'"+theme+"');\n" +
                    "        var names = " + chartLegendNamesX + ";\n" +
                    "        var dataMX=" + dataValuesMX + ";\n" +
                    "        chart.setOption({\n" +
                    "            aria: {show: true},\n" +
                    "            legend: {data: names.slice()},\n" +
                    "            toolbox: {orient: 'vertical',left: 'left',top: 'center',\n" +
                    "                feature: {dataView: {},saveAsImage: {},dataZoom: {},restore: {show: true}}},\n" +
                    "            tooltip: {trigger: 'axis',axisPointer: {type: 'cross'}},\n" +
                    "            xAxis: {\n" +
                    "                type: 'value',\n" +
                    "                splitLine: {show: true}, min: 0, max: 15, splitNumber: 30 }, \n" +
                    "            yAxis: {\n" +
                    "                type: 'value',\n" +
                    "                splitLine: { show: true } },\n" +
                    "            dataZoom: [\n" +
                    "                        {id: 'sliderX',show: true,xAxisIndex: [0],start: 10,end: 70},\n" +
                    "                        {id: 'sliderY',show: true,yAxisIndex: [0],start: 0,end: 20},\n" +
                    "                        {type: 'inside',xAxisIndex: [0],start: 10,end: 70},\n" +
                    "                        {type: 'inside',yAxisIndex: [0],start: 0,end: 20} ],\n" +
                    "            series: [\n");
                    // Agrega las series al gráfico.
                    for (int i = 0; i < dataValuesM.length; i++) {
            
                    chartImage.append(""+
                    "            {\n" +
                    "                name: names[" + i + "],\n" +
                    "                type: 'scatter',\n" +
                    "                symbol: '" +seriesSymbol[i]+ "',\n" +
                    "                label: {emphasis: {show: true},color: '" +seriesLabelColor[i]+ "', show:" +seriesLabelShow[i]+ "},                        \n" +
                    "                symbolSize: function (val) {return val[2] * 40;},\n" +
                    "                itemStyle: {opacity:" +seriesItemStyleOpacy[i]+ "},                        \n" +
                    "                data: dataMX[" + i + "],\n" +
                    "                markLine: {data: [{name: 'Max',type: 'max'},{name: 'Minimum value',type: 'min'},{name: 'median',type: 'median'}]} }\n" +
                    "            ,\n");
                    
                    }
                    
                    chartImage.append(""+
                    "            ],\n" +
                    "            animationDelay: function (idx) {\n" +
                    "                return idx * 20; } , \n " +
                    "            animationDelayUpdate: function (idx) {\n" +
                    "                return idx * 20;\n" +
                    "            }\n" +
                    "        });\n" +
                    "        chart.on('click', function (params) {\n" +
                    "            console.log(params.data);\n" +
                    "        });\n" +
                    "</script>");
                    // Añade el gráfico al contexto de la página.
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Scatter: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Scatter: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Scatter: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Scatter: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Scatter: {0}", e.getMessage());
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
