
package pe.com.syscenterlife.echarts.twod;

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
 * La clase {@code BoxplotTag} genera un gráfico de caja (boxplot) utilizando ECharts en una página JSP.
 * Esta clase permite la configuración de datos, nombre de categorías, título del gráfico, orientación del boxplot,
 * y otras propiedades del gráfico.
 * <p>
 * Ejemplo de uso en JSP:
 * </p>
 * <pre>
 * {@code
 * <custom:boxplotTag idCharts="boxplotChart" dataValues="..." ... />
 * }
 * </pre>
 * 
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class BoxplotTag extends BodyTagSupport {
    /**
     * Logger para registrar eventos y errores.
     */    
    protected static final Logger logger = Logger.getLogger(BoxplotTag.class.getName());
    /**
     * Datos del gráfico en formato array de objetos.
     */    
    @Getter @Setter
    private transient Object[] dataValues;
    /**
     * Identificador del div que contendrá el gráfico.
     */    
    @Getter @Setter
    String idCharts; 
    /**
     * Nombre de la categoría de datos.
     */    
    @Getter @Setter
    String categoryName="Datos"; 
    /**
     * Título del gráfico.
     */    
    @Getter @Setter
    String chartTitle="Grafico de Resultados"; 
    /**
     * Orientación del gráfico de caja (horizontal o vertical).
     */    
    @Getter @Setter
    String boxPlotOrient="horizontal"; /*vertical,horizontal*/ 
    /**
     * Nombres de las leyendas en formato JSON.
     */    
    @Getter @Setter
    private transient JSONArray legendName;
    /**
     * Altura del contenedor del gráfico.
     */    
    @Getter @Setter
    public String height = "460px";
    /**
     * Ancho del contenedor del gráfico.
     */    
    @Getter @Setter
    public String width = "700px";    
    /**
     * Indicador de dependencia del script.
     */        
    boolean scriptDependency=false;
    /**
     * Contexto de la página JSP.
     */    
    private transient PageContext pageContextR;
    /**
     * Constructor por defecto.
     */
    public BoxplotTag() {
    
    }
    /**
     * Constructor con contexto de página.
     * 
     * @param pageContextxx el contexto de la página JSP.
     */    
    public BoxplotTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico de caja en la página web.
     * 
     * @return {@code SKIP_BODY} para indicar que el cuerpo de la etiqueta debe ser ignorado.
     * @throws JspException si ocurre un error durante la ejecución de la etiqueta.
     */
    @Override
    public int doEndTag() throws JspException {
        // Obtiene el tema de ECharts desde la sesión HTTP.
        String theme;
        theme=(String)((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme");
        // Convierte los datos a formato JSON.
        JSONArray dataM=new JSONArray(dataValues);

        try {
            // Genera el código HTML y JavaScript para el gráfico.
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                        "<div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
                        "<script>          \n" +
                        "var chart = echarts.init(document.getElementById('" + idCharts + "'),'"+theme+"', { });\n" +
                        "function update(layout) {\n" +
                        "    var data = [];\n" +
                        "    var dataM= [];\n" +
                        "    var legendName= [];\n" +
                        "    legendName=" + legendName + ";\n" +
                        "    dataM =" + dataM + ";\n" +
                        "    for (var i = 0; i < dataM.length; i++) {\n" +
                        "        data.push(echarts.dataTool.prepareBoxplotData(dataM[i], {\n" +
                        "            layout: layout\n" +
                        "        }));        \n" +
                        "    }    \n" +
                        "   /* var data = echarts.dataTool.prepareBoxplotData( seriesData , {layout: layout});*/\n" +
                        "    var categoryAxis = {\n" +
                        "        type: 'category',\n" +
                        "        data: data[0].axisData,\n" +
                        "        boundaryGap: true,\n" +
                        "        nameGap: 30,\n" +
                        "        splitArea: {\n" +
                        "            show: true },\n" +
                        "        axisLabel: {\n" +
                        "            formatter: '" + categoryName + " {value}' },\n" +
                        "        splitLine: {\n" +
                        "            show: false\n" +
                        "        }\n" +
                        "    };\n" +
                        "    var valueAxis = {\n" +
                        "        type: 'value',\n" +
                        "        name: 'Value',\n" +
                        "        splitArea: {\n" +
                        "            show: false\n" +
                        "        }\n" +
                        "    };\n" +
                        "    chart.setOption({\n" +
                        "        title: [\n" +
                        "            {\n" +
                        "                text: '" + chartTitle + "',\n" +
                        "                left: 'center'\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        legend: {\n" +
                        "            top: '10%',\n" +
                        "            data: legendName }, \n" +
                        "        tooltip: {\n" +
                        "            trigger: 'axis',/*item,axis*/\n" +
                        "            axisPointer: {\n" +
                        "                type: 'shadow'\n" +
                        "            } },\n" +
                        "        grid: {\n" +
                        "            left: '10%',\n" +
                        "            top: '20%',\n" +
                        "            right: '10%',\n" +
                        "            bottom: '15%'\n" +
                        "        },\n" +
                        "        xAxis: layout === 'horizontal' ? categoryAxis : valueAxis,\n" +
                        "        yAxis: layout === 'vertical' ? categoryAxis : valueAxis,\n" +
                        "        dataZoom: [\n" +
                        "            {\n" +
                        "                type: 'inside',\n" +
                        "                start: 0,\n" +
                        "                end: 20\n" +
                        "            },{\n" +
                        "                show: true,\n" +
                        "                height: 20,\n" +
                        "                type: 'slider',\n" +
                        "                bottom: 50,\n" +
                        "                /*xAxisIndex: layout === 'horizontal' ? [0] : [],*/\n" +
                        "                /*yAxisIndex: layout === 'vertical' ? [] : [0],*/\n" +
                        "                start: 0,\n" +
                        "                end: 20\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        toolbox: {feature: {dataView: {},saveAsImage: {},restore: {}}},						\n" +
                        "        series: [\n");
            
                        for(int i = 0; i <dataValues.length; i++) {
                        chartImage.append(" "+
                        "               {\n" +
                        "                    name: legendName[" + i + "],\n" +
                        "                    type: 'boxplot',                \n" +
                        "                    data: data[" + i + "].boxData\n" +
                        "                },\n" +
                        "                {name: 'Outliers '+legendName[" + i + "],\n" +
                        "                type: 'scatter',\n" +
                        "                data: data[" + i + "].outliers},\n");
                        }
                        chartImage.append(" "+
                        "       ]\n" +
                        "    });}\n" +
                        "update('" + boxPlotOrient + "');/*vertical,horizontal*/\n" +
                        "</script>");
                        // Añade el gráfico al contexto de la página.
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico BoxplotTag: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs BoxplotTag: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico BoxplotTag: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib BoxplotTag: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs BoxplotTag: {0}", e.getMessage());
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
