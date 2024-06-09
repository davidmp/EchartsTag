package pe.com.syscenterlife.echarts.twod.radar;

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
 * La clase {@code RadarMultiTag} proporciona una etiqueta personalizada para generar gráficos de radar múltiples
 * utilizando la biblioteca ECharts en páginas JSP.
 * Esta etiqueta permite configurar datos, leyendas, estilos de área y otras propiedades del gráfico de radar múltiple.
 *
 * Ejemplo de uso en JSP:
 * {@code
 * <custom:radarMultiTag idCharts="radarChart" dataValuesM="..." indicadorPositionWH="..." indicadorDataM="..." ... />
 * }
 *
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class RadarMultiTag extends BodyTagSupport{
    /**
     * Logger para registrar eventos y errores.
     */
    protected static final Logger logger = Logger.getLogger(RadarMultiTag.class.getName());
    /**
     * Identificador del div que contendrá el gráfico.
     */
    @Getter @Setter
    String idCharts; 
    /**
     * Datos para el gráfico de radar múltiple.
     */
    @Getter @Setter
    private transient Object[] dataValuesM;
    /**
     * Posición y tamaño de los indicadores del gráfico.
     */
    @Getter @Setter
    private transient Object[][] indicadorPositionWH;

    /**
     * Opacidad del área del gráfico de radar.
     */
    @Getter @Setter
    double[] areaStyleOpacy;
    /**
     * Datos de los indicadores del gráfico de radar múltiple.
     */
    @Getter @Setter
    private transient Object[] indicadorDataM;
    /**
     * Nombres de las leyendas del gráfico.
     */
    @Getter @Setter
    String[] legendDataName;
    /**
     * Título del gráfico.
     */
    @Getter @Setter
    String chartTitle;
    /**
     * Altura del contenedor del gráfico.
     */
    @Getter @Setter
    public String height = "530px";
    /**
     * Ancho del contenedor del gráfico.
     */
    @Getter @Setter
    public String width = "900px";
    /**
     * Contexto de la página JSP.
     */
    private transient PageContext pageContextR;
    /**
     * Constructor por defecto.
     */
    public RadarMultiTag() {
    }
    /**
     * Constructor con contexto de página.
     *
     * @param pageContextxx el contexto de la página JSP.
     */
    public RadarMultiTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico de radar múltiple en la página web.
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
        // Convierte los datos del gráfico de radar múltiple a formato JSON.
        JSONArray dataValuesMX=new JSONArray(dataValuesM);
        try {
            // Genera el código HTML y JavaScript para el gráfico de radar múltiple.
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
            "<div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
            "<script>\n" +
            "        var chart = echarts.init(document.getElementById('" + idCharts + "'),'"+theme+"');\n" +
            "        var legendDataNameX=" + legendDataNameX + ";\n" +
            "        var dataValuesX=" + dataValuesMX + ";\n" +
            "        chart.setOption({\n" +
            "            title: {text: '" + chartTitle + "',x:'center'},\n" +
            "            tooltip: {trigger: 'axis'},\n" +
            "            legend: {\n" +
            "                x: 'center',\n" +
            "                y:'bottom',\n" +
            "                data:legendDataNameX\n" +
            "            },\n" +
            "            radar: [\n");
            // Agrega las configuraciones de radar.
            for (int i = 0; i < indicadorDataM.length; i++) {
            chartImage.append(""+
            "                {\n" +
            "                    indicator: [\n");
            
            Object[][] indicadorDataTemp=(Object[][])indicadorDataM[i];
            for (int j = 0; j < indicadorDataTemp[0].length; j++) { 
            chartImage.append(""+
            "                        {text: '" + indicadorDataTemp[0][j] + "', max: " + indicadorDataTemp[1][j] + "},\n");
            
            }
            chartImage.append(""+        
            "                    ],\n" +
            "                    center: ['" + indicadorPositionWH[0][i]+ "'," + indicadorPositionWH[1][i]+ "],\n" +
            "                    radius: 80,\n" +
            "                    startAngle: 90,\n" +
            "                    splitNumber: 8\n" +
            "                },\n");
            
            }
            chartImage.append(""+        
            "            ],\n" +
            "            toolbox: {orient: 'vertical',left: 'right',top: 'center',\n" +
            "            feature: {dataView: {},saveAsImage: {},restore: {}}},	\n" +
            "            series: [\n");
            
            int ldnTemp=0;
            for (int i = 0; i < dataValuesM.length; i++) {
                    
            chartImage.append(""+   
            "                {\n" +
            "                    type: 'radar',\n" +
            "                    radarIndex: " +i+ ",\n" +
            "                    tooltip: {trigger: 'item'},\n" +
            "                    areaStyle: {opacity:" +areaStyleOpacy[i]+ "},\n" +
            "                    data: [\n");
            
            Object[][] dataValuesTemp=(Object[][])dataValuesM[i];
            for (int j = 0; j < dataValuesTemp.length; j++) {
            chartImage.append(""+   
            "                        {\n" +
            "                            value : dataValuesX[" +i+ "][" +j+ "],\n" +
            "                            name: legendDataNameX[" +ldnTemp+ "]                                   \n" +
            "                        },\n");
            
            ldnTemp++;} 
            chartImage.append(""+   
            "                    ]\n" +
            "                },\n");
            
            }
            chartImage.append(""+   
            "            ]\n" +
            "        });\n" +
            "</script>");
            // Añade el gráfico al contexto de la página.
            pageContextR.getOut().append(chartImage);            

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico RadarMultiple: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs RadarMultiple: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico RadarMultiple: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib RadarMultiple: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs RadarMultiple: {0}", e.getMessage());
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
