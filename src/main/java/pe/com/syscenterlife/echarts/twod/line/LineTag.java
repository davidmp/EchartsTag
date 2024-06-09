
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
 * La clase {@code LineTag} proporciona una etiqueta personalizada para generar gráficos de líneas utilizando la biblioteca ECharts en páginas JSP.
 * Esta etiqueta permite configurar datos, títulos, leyendas, estilos y otras propiedades del gráfico de líneas.
 *
 * Ejemplo de uso en JSP:
 * {@code
 * <custom:lineTag idCharts="lineChart" dataValues="..." legendDataName="..." chartAxisXYCategory="..." ... />
 * }
 *
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class LineTag extends BodyTagSupport {
    /**
     * Logger para registrar eventos y errores.
     */    
    protected static final Logger logger = Logger.getLogger(LineTag.class.getName());
    /**
     * Identificador del div que contendrá el gráfico.
     */    
    @Getter @Setter
    String idCharts; 
    /**
     * Datos para el gráfico de líneas.
     */    
    @Getter @Setter
    private transient Object[] dataValues;
    /**
     * Nombres de las leyendas del gráfico.
     */    
    @Getter @Setter
    String[] legendDataName;
    /**
     * Categorías de los ejes X y Y del gráfico.
     */    
    @Getter @Setter
    String[] chartAxisXYCategory;
    /**
     * Orientación del gráfico (vertical u horizontal).
     */    
    @Getter @Setter
    String echartsOriented="horizontal";/*vertical,horizontal*/
    /**
     * Indica si se debe mostrar el valor máximo y mínimo como puntos de marca en las series del gráfico.
     */    
    @Getter @Setter
    boolean[] seriesMarkPointMinMax ={false,false,false,false,false};
    /**
     * Indica si se debe mostrar el valor medio como línea de marca en las series del gráfico.
     */    
    @Getter @Setter
    boolean[] seriesMarkLineMedia ={false,false,false,false,false};   
    /**
     * Script adicional a añadir al gráfico.
     */    
    @Getter @Setter
    String scriptAdd="";
    /**
     * Altura del contenedor del gráfico.
     */    
    @Getter @Setter
    public String height = "540px";
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
    public LineTag() {    
    }
    /**
     * Constructor con contexto de página.
     * 
     * @param pageContextxx el contexto de la página JSP.
     */    
    public LineTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico de líneas en la página web.
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
        JSONArray legendDataNameX=new JSONArray(legendDataName);
        // Convierte las categorías de los ejes X y Y a formato JSON.
        JSONArray chartAxisXYCategoryX=new JSONArray(chartAxisXYCategory);
        // Convierte los datos de las series a formato JSON.
        JSONArray dataValuesX=new JSONArray(dataValues);
        // Determina la orientación de los ejes X y Y.
        String x;
        String y;
        if(echartsOriented.equals("horizontal")){
        x="xAxis"; y="yAxis";
        }else{ x="yAxis"; y="xAxis"; }        
        
        try {   
             // Genera el código HTML y JavaScript para el gráfico de líneas.
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "        <div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
                    "        <script>\n" +
                    "        var legendDataName=" + legendDataNameX + ";\n" +
                    "        var chartAxisXYCategory=" + chartAxisXYCategoryX + ";\n" +
                    "        var dataValues=" + dataValuesX + ";\n" +
                    "        var chart;\n" +
                    "        var myChart;\n" +
                    "        var go;\n" +
                    "        chart = myChart = echarts.init(document.getElementById('" + idCharts + "'), '"+theme+"', {});\n" +
                    "            option = {\n" +
                    "                toolbox: {orient: 'vertical',left: 'right',top: 'center',\n" +
                    "                    feature: {magicType: {type: ['line', 'bar']\n" +
                    "                        },dataView: {},saveAsImage: {},restore: {},dataZoom: {}}},\n" +
                    "                dataZoom: [\n" +
                    "                    {type: 'inside',\n" +
                    "                    startValue: 11,\n" +
                    "                    endValue: 85\n" +
                    "                }, {type: 'slider',\n" +
                    "                    startValue: 11,\n" +
                    "                    endValue: 85\n" +
                    "                }],\n" +
                    "                legend: {\n" +
                    "                    data:legendDataName\n" +
                    "                },\n" +
                    "                tooltip: {trigger: 'axis',axisPointer: {type: 'line'}},\n" +
                    "                " + x + ": [{type : 'category',boundaryGap : false,\n" +
                    "                        data : chartAxisXYCategory}],\n" +
                    "                " + y + " : [{type : 'value'}],\n" +
                    "                series : [\n");
                    // Agrega las configuraciones de cada serie.
                    for (int i = 0; i < dataValues.length; i++) {
                    chartImage.append(""+
                    "                    {\n" +
                    "                        name:legendDataName[" + i + "],\n" +
                    "                        type:'line',\n" +
                    "                        data:dataValues[" + i + "],\n");
                    
                    if(seriesMarkPointMinMax[i]){
                            
                    chartImage.append(""+
                    "                        markPoint: {data: [{type: 'max', name: 'Maximo'},{type: 'min', name: 'Minimo'}]},\n");
                    }
                            
                    if(seriesMarkLineMedia[i]){
                    chartImage.append(""+
                    "                        markLine: {data: [{type: 'average', name: 'Promedio'}]} \n");
                    
                    }
                    chartImage.append(""+
                    "                    },\n");
                    
                    }
                    chartImage.append(""+
                    "                ]\n" +
                    "            };\n" +                    
                    "            " + scriptAdd + "\n" +                    
                    "            chart.setOption(option);\n" +
                    "        </script>");
                    // Añade el gráfico al contexto de la página.
           pageContextR.getOut().append(chartImage);

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Line: {0}", e.getMessage()); 
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Line: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Line: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Line: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Line: {0}", e.getMessage());
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
