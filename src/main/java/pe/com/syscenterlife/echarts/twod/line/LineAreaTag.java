
package pe.com.syscenterlife.echarts.twod.line;

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
 * La clase {@code LineAreaTag} proporciona una etiqueta personalizada para generar gráficos de líneas o áreas utilizando la biblioteca ECharts en páginas JSP.
 * Esta etiqueta permite configurar datos, títulos, leyendas, estilos y otras propiedades del gráfico de líneas o áreas.
 *
 * Ejemplo de uso en JSP:
 * {@code
 * <custom:lineAreaTag idCharts="lineAreaChart" dataValues="..." chartTitle="..." ... />
 * }
 *
 * @author davidmp
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class LineAreaTag extends BodyTagSupport{
    /**
     * Logger para registrar eventos y errores.
     */    
    protected static final Logger logger = Logger.getLogger(LineAreaTag.class.getName());
    /**
     * Identificador del div que contendrá el gráfico.
     */    
    @Getter @Setter
    String idCharts; 
    /**
     * Datos para el gráfico de líneas o áreas.
     */    
    @Getter @Setter
    private transient Object[] dataValues;
    /**
     * Título del gráfico.
     */    
    @Getter @Setter
    String chartTitle;
    /**
     * Datos para el eje X del gráfico.
     */    
    @Getter @Setter
    private transient Object[] ejeDataX;
    /**
     * Nombres de las leyendas del gráfico.
     */    
    @Getter @Setter
    String[] legendDataName;
    /**
     * Nombres de las unidades de las leyendas.
     */    
    @Getter @Setter
    String[] legendNameUnit;
    /**
     * Posiciones de las leyendas en el gráfico.
     */    
    @Getter @Setter
    String[] legendNameLocation;
    /**
     * Indica si las leyendas deben mostrarse en orden inverso.
     */    
    @Getter @Setter
    boolean[] legendNameInverse;
    /**
     * Índices de las series en el gráfico.
     */    
    @Getter @Setter
    int[] serieIndex;
    /**
     * Opacidad del área de las series.
     */    
    @Getter @Setter
    double[] serieAreaStyleOpacy={0.8, 0.8};    

    /**
     * Altura del contenedor del gráfico.
     */    
    @Getter @Setter
    public String height = "500px";
    /**
     * Ancho del contenedor del gráfico.
     */    
    @Getter @Setter
    public String width = "760px";
    
    /**
     * Contexto de la página JSP.
     */
    private transient PageContext pageContextR;
    /**
     * Constructor por defecto.
     */
    public LineAreaTag() {    
    }
    /**
     * Constructor con contexto de página.
     * 
     * @param pageContextxx el contexto de la página JSP.
     */    
    public LineAreaTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico de líneas o áreas en la página web.
     * 
     * @return {@code SKIP_BODY} para indicar que el cuerpo de la etiqueta debe ser ignorado.
     * @throws JspException si ocurre un error durante la ejecución de la etiqueta.
     */
    @Override
    public int doEndTag() throws JspException {
        // Obtiene el tema de ECharts desde la sesión HTTP.
        String theme;
        theme=(String)((HttpServletRequest)this.pageContextR.getRequest()).getSession().getAttribute("echartstheme");
        // Convierte los datos del eje X a formato JSON.
        JSONArray ejeDataXX=new JSONArray(ejeDataX);
        // Convierte los valores de datos a formato JSON.
        JSONArray dataValuesX=new JSONArray(dataValues);
        // Convierte los nombres de las leyendas a formato JSON.
        JSONArray legendDataNameX=new JSONArray(legendDataName);
     
        
        try {   
             // Genera el código HTML y JavaScript para el gráfico de líneas o áreas.
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "        <div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
                    "        <script>\n" +
                    "        var chart = echarts.init(document.getElementById('" + idCharts + "'), '"+theme+"', {});\n" +
                    "        var sampling = 'none';\n" +
                    "        var ejeDataXX=" + ejeDataXX + ";\n" +
                    "        var dataValues=" + dataValuesX + ";\n" +
                    "        chart.setOption({\n" +
                    "            title : {text: '" + chartTitle + "',x: 'center'},\n" +
                    "            tooltip: {trigger: 'axis',axisPointer: {type: 'cross',animation: false,label: {backgroundColor: '#505765'}}},        \n" +
                    "            legend: { data:" + legendDataNameX + ",x: 'left'},\n" +
                    "            toolbox: {orient: 'vertical',left: 'right',top: 'center',\n" +
                    "                feature : {mark : {show: true},dataView : {show: true, readOnly: false},\n" +
                    "                    magicType : {show: true, type: ['line', 'bar']},restore : {show: true},\n" +
                    "                    saveAsImage : {show: true}}},\n" +
                    "            grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},                    \n" +
                    "            dataZoom: [\n" +
                    "                {show: true,realtime: true,start: 80,end: 100},\n" +
                    "                {type: 'inside',show: true,realtime: true,start: 80,end: 100}],\n" +
                    "            xAxis : [\n" +
                    "                {\n" +
                    "                    type : 'category',\n" +
                    "                    boundaryGap : false,\n" +
                    "                    axisLine: {onZero: false},\n" +
                    "                    data : ejeDataXX.map(function (str) {return str.replace(' ', '\\n');})\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            yAxis : [\n");
                    for (int i = 0; i < dataValues.length; i++) {
                    chartImage.append(""+
                    "            {name : '" + legendNameUnit[i] + "', nameLocation: '" + legendNameLocation[i] + "', type : 'value',inverse: " + legendNameInverse[i] + "},\n");
                    } 
                    chartImage.append(""+
                    "            ],\n" +
                    "            series : [\n");
                    for (int i = 0; i < dataValues.length; i++) {
                    chartImage.append(""+
                    "                {\n" +
                    "                    name:'" + legendDataName[i] + "',\n" +
                    "                    type:'line',\n" +
                    "                    yAxisIndex:" + serieIndex[i] + ",\n" +
                    "                    notShowSymbol: true,\n" +
                    "                    sampling: sampling,\n" +
                    "                    hoverAnimation: false,\n" +
                    "                    areaStyle: { opacity: " + serieAreaStyleOpacy[i] + "},\n" +
                    "                    data:dataValues[" + i + "]\n" +
                    "                },\n");
                    
                    }
                    chartImage.append(""+
                    "            ]\n" +
                    "        });\n" +
                    "        </script>");
                    // Añade el gráfico al contexto de la página.
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico LineArea: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs LineArea: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico LineArea: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib LineArea: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs LineArea: {0}", e.getMessage());
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
