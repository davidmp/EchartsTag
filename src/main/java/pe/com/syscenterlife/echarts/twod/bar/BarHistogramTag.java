
package pe.com.syscenterlife.echarts.twod.bar;

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
 * La clase {@code BarHistogramTag} proporciona una etiqueta personalizada para generar gráficos de histograma de barras utilizando la biblioteca ECharts en páginas JSP.
 * Esta etiqueta permite configurar datos, título del gráfico, leyendas, ejes, opciones de estilo y otras propiedades del gráfico.
 *
 * Ejemplo de uso en JSP:
 * {@code
 * <custom:barHistogramTag idCharts="barHistogramChart" dataValues="..." ... />
 * }
 *
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class BarHistogramTag extends BodyTagSupport  {
    /**
     * Logger para registrar eventos y errores.
     */    
    protected static final Logger logger = Logger.getLogger(BarHistogramTag.class.getName());
    /**
     * Identificador del div que contendrá el gráfico.
     */    
    @Getter @Setter
    String idCharts; 
    /**
     * Datos del gráfico en formato array de objetos.
     */    
    @Getter @Setter
    private transient Object[] dataValues;
    /**
     * Título del gráfico.
     */    
    @Getter @Setter
    String chartTitle;
    /**
     * Nombres de las leyendas.
     */    
    @Getter @Setter
    String[] legendDataName;
    /**
     * Datos del eje X.
     */    
    @Getter @Setter
    String[] ejeDataX;
    /**
     * Nombres de los ejes X y Y.
     */    
    @Getter @Setter
    String[] ejeNameXY={"Eje X","Eje Y"}; 
    /**
     * Marcadores de punto mínimo y máximo en las series.
     */    
    @Getter @Setter
    boolean[] seriesMarkPointMinMax ={false,false,false,false};
    /**
     * Marcadores de línea de promedio en las series.
     */    
    @Getter @Setter
    boolean[] seriesMarkLineMedia ={false,false,false,false}; 
    /**
     * Nombres de las series para agrupación.
     */    
    @Getter @Setter
    String[] seriesStackName ={"one","one","two","two"}; 
    /**
     * Orientación del gráfico de histograma. Puede ser "horizontal" o "vertical"
     */
    @Getter @Setter
    String echartsOriented="horizontal";
    /**
     * Altura del contenedor del gráfico.
     */    
    @Getter @Setter
    public String height = "500px";
    /**
     * Ancho del contenedor del gráfico.
     */    
    @Getter @Setter
    public String width = "800px";
    
    /**
     * Contexto de la página JSP.
     */
    private transient PageContext pageContextF;
    
    /**
     * Constructor por defecto.
     */
    public BarHistogramTag() {    
    }    
    /**
     * Constructor con contexto de página.
     * 
     * @param pageContextxx el contexto de la página JSP.
     */    
    public BarHistogramTag(PageContext pageContextxx) {
     pageContextF=pageContextxx;
    }    
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico de histograma de barras en la página web.
     * 
     * @return {@code SKIP_BODY} para indicar que el cuerpo de la etiqueta debe ser ignorado.
     * @throws JspException si ocurre un error durante la ejecución de la etiqueta.
     */
    @Override
    public int doEndTag() throws JspException {
        // Obtiene el tema de ECharts desde la sesión HTTP.
        String theme;
        theme=(String)((HttpServletRequest)this.pageContext.getRequest()).getSession().getAttribute("echartstheme");
        // Convierte los datos a formato JSON.
        JSONArray ejeDataXX=new JSONArray(ejeDataX);
        JSONArray dataValuesX=new JSONArray(dataValues);
        JSONArray legendDataNameX=new JSONArray(legendDataName);
         // Define los nombres de los ejes X e Y según la orientación del gráfico.
        String x;
        String y;
        if(echartsOriented.equals("horizontal")){
        x="xAxis"; y="yAxis";
        }else{ x="yAxis"; y="xAxis"; }        
        
        try {
            // Genera el código HTML y JavaScript para el gráfico de histograma de barras.
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "    <div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
                    "    <script>\n" +
                    "    var chart = echarts.init(document.getElementById('" + idCharts + "'),'"+theme+"');\n" +
                    "    var xAxisData = " + ejeDataXX + ";\n" +
                    "    var dataValuesX = " + dataValuesX + ";   \n" +
                    "    var itemStyle = {\n" +
                    "        normal: {\n" +
                    "            barBorderRadius: 5,\n" +
                    "            label: {\n" +
                    "                show: true,\n" +
                    "                position: 'outside' }},\n" +
                    "        emphasis: {\n" +
                    "            label: {\n" +
                    "                position: 'outside'\n" +
                    "            },\n" +
                    "            barBorderColor: '#fff',\n" +
                    "            barBorderWidth: 1,\n" +
                    "            shadowBlur: 10,\n" +
                    "            shadowOffsetX: 0,\n" +
                    "            shadowOffsetY: 0,\n" +
                    "            shadowColor: 'rgba(0,0,0,0.5)'\n" +
                    "        }\n" +
                    "    };\n" +
                    "    chart.setOption({\n" +
                    "        backgroundColor: '#eee',\n" +
                    "        title: {text: '" + chartTitle + "',padding: 30,textAlign:'auto'},\n" +
                    "        legend: {\n" +
                    "            left: 150,\n" +
                    "            inactiveColor: '#abc',\n" +
                    "            borderWidth: 1,\n" +
                    "            data: " + legendDataNameX + ",\n" +
                    "            selected: {},\n" +
                    "            align: 'left',\n" +
                    "            tooltip: { show: true}},\n" +
                    "        brush: {xAxisIndex: 0},\n" +
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
                    "                brush: {\n" +
                    "                    type: ['rect', 'polygon', 'lineX', 'lineY', 'keep', 'clear']\n" +
                    "                },\n" +
                    "                restore: {},\n" +
                    "                dataZoom: {}\n" +
                    "            },\n" +
                    "\n" +
                    "            iconStyle: {\n" +
                    "                emphasis: {\n" +
                    "                    textPosition: 'top'                                \n" +
                    "                } }\n" +
                    "        },\n" +
                    "        tooltip: {},\n" +
                    "        grid: {top: 80},\n" +
                    "        " + x + ": {\n" +
                    "            data: xAxisData,\n" +
                    "            name:'" + ejeNameXY[0] + "',\n" +
                    "            silent: false,\n" +
                    "            axisTick: {alignWithLabel: true},\n" +
                    "            axisLine: {onZero: true},\n" +
                    "            splitLine: {show: true},\n" +
                    "            splitArea: {show: true}  },\n" +
                    "        " + y + ": {\n" +
                    "            name: '" + ejeNameXY[1] + "',\n" +
                    "            inverse: false,\n" +
                    "            axisTick: {show: false},\n" +
                    "            splitArea: {show: false}},\n" +
                    "        dataZoom: [{show: true, start: 0,end: 100},\n" +
                    "            {type: 'inside',start: 94,end: 100},\n" +
                    "            {show: true,yAxisIndex: 0,filterMode: 'empty',\n" +
                    "            width: 30,height: '80%',showDataShadow: false,left: '93%'}],                    \n" +
                    "        series: [\n");
            
                    for (int i = 0; i < dataValues.length; i++) { 
                    chartImage.append(""+
                    "        {\n" +
                    "            name: '" + legendDataName[i] + "',\n" +
                    "            type: 'bar',\n" +
                    "            stack: '" +seriesStackName[i]+ "',\n" +
                    "            itemStyle: itemStyle,\n" +
                    "            data: dataValuesX[" +i+ "],\n");
                    if(seriesMarkPointMinMax[i]){
                    chartImage.append(""+        
                    "            markPoint: {data: [{type: 'max', name: 'Maximo'},{type: 'min', name: 'Minimo'}]},\n");
                    }
                    if(seriesMarkLineMedia[i]){
                    chartImage.append(""+        
                    "            markLine: {data: [{type: 'average', name: 'Promedio'}]} \n");
                    }
                    chartImage.append(""+        
                    "        }, \n");
                            
                    }
                    chartImage.append(""+       
                    "        \n" +
                    "    ]\n" +
                    "    });\n" +
                    "    chart.on('click', function (params) {\n" +
                    "        console.log(params);});\n" +
                    "    chart.on('legendselectchanged', function (params) {\n" +
                    "        chart.setOption({\n" +
                    "            graphic: [{\n" +
                    "                type: 'circle',\n" +
                    "                shape: {\n" +
                    "                    cx: 100,\n" +
                    "                    cy: 100,\n" +
                    "                    r: 20\n" +
                    "                }\n" +
                    "            }]\n" +
                    "        });\n" +
                    "    });\n" +
                    "    window.onresize = chart.resize;\n" +
                    "    </script>");
                    // Añade el gráfico al contexto de la página.
             pageContextF.getOut().append(chartImage);

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico BarHistogram: {0}", e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs: {0}", e.getMessage());
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
        pageContextF=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }    
}
