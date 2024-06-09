
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
 * La clase {@code RadarTag} proporciona una etiqueta personalizada para generar gráficos de radar utilizando
 * la biblioteca ECharts en páginas JSP.
 * Esta etiqueta permite configurar datos, leyendas, colores visuales, estilos de línea y otras propiedades
 * del gráfico de radar.
 *
 * Ejemplo de uso en JSP:
 * {@code
 * <custom:radarTag indicadorData="..." legendDataName="..." dataValues="..." areaStyleOpacy="..." idCharts="..." seriesName="..." lineStyleType="..." toolboxOrient="..." chartTitle="..." height="..." width="..." />
 * }
 *
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */
public class RadarTag extends BodyTagSupport {
    /**
     * Logger para registrar eventos y errores.
     */
    protected static final Logger logger = Logger.getLogger(RadarTag.class.getName());
    /**
     * Datos de los indicadores del gráfico de radar.
     */
    @Getter @Setter
    private transient Object[][] indicadorData;
    /**
     * Nombres de las leyendas del gráfico.
     */
    @Getter @Setter
    String[] legendDataName;
    /**
     * Valores de los datos del gráfico de radar.
     */
    @Getter @Setter
    private transient JSONArray dataValues;
    /**
     * Opacidad del área del gráfico de radar.
     */
    @Getter @Setter
    double areaStyleOpacy=0.1;  
    /**
     * Identificador del div que contendrá el gráfico.
     */
    @Getter @Setter
    String idCharts;  
    /**
     * Nombre de la serie del gráfico de radar.
     */
    @Getter @Setter
    String seriesName;
   /**
     * Tipo de estilo de línea para el gráfico de radar. 'solid','dashed','dotted'
     */
    @Getter @Setter
    String lineStyleType="solid";/*'solid','dashed','dotted'*/  
    /**
     * Orientación del toolbox del gráfico de radar. 'vertical', 'horizontal'
     */
    @Getter @Setter
    String toolboxOrient="vertical";/*'vertical', 'horizontal'*/    
    /**
     * Altura del contenedor del gráfico.
     */
    @Getter @Setter
    public String height = "400px";
    /**
     * Ancho del contenedor del gráfico.
     */
    @Getter @Setter
    public String width = "600px";
    /**
     * Contexto de la página JSP.
     */
    private transient PageContext pageContextR;
    /**
     * Constructor por defecto.
     */
    public RadarTag() {
    }
    /**
     * Constructor con contexto de página.
     *
     * @param pageContextxx el contexto de la página JSP.
     */
    public RadarTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico de radar en la página web.
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
        try {
            // Genera el código HTML y JavaScript para el gráfico de radar.
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "<div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
                    "<script>\n" +
                    "var chart = echarts.init(document.getElementById('" + idCharts + "'),'"+theme+"');\n" +
                    "var legendDataNameX=" + legendDataNameX + ";\n" +
                    "var dataValuesX=" + dataValues + ";\n" +
                    "chart.setOption({\n" +
                    "    aria: {\n" +
                    "        show: true}\n" +
                    "    ,\n" +
                    "    tooltip: {},\n" +
                    "    legend: {\n" +
                    "        data: legendDataNameX\n" +
                    "    },\n" +
                    "    radar: {\n" +
                    "        radius: [50, '70%'],\n" +
                    "        name: {\n" +
                    "            formatter:'[{value}]',\n" +
                    "            color:'#72ACD1'\n" +
                    "        },\n" +
                    "        triggerEvent: true,\n" +
                    "        indicator: [\n");
                        // Agrega las configuraciones de los indicadores del radar.
                    for(int i=0; i<indicadorData[0].length; i++) {
                    chartImage.append(""+
                    "            {text: '" + indicadorData[0][i] + "', max: " + indicadorData[1][i] + "},\n");
                    }
                    chartImage.append(""+
                    "        ]\n" +
                    "    },\n" +
                    "    toolbox: {feature: {dataView: {},saveAsImage: {},restore: {}}, orient: '" + toolboxOrient + "'},	\n" +
                    "    series: [{\n" +
                    "        name: '" + seriesName + "',\n" +
                    "        type: 'radar',\n" +
                    "        label: {\n" +
                    "            normal: {\n" +
                    "                show: true\n" +
                    "            }\n" +
                    "        },\n" +
                    "        lineStyle: {type:'" + lineStyleType + "'},/*'solid','dashed','dotted'*/\n" +
                    "        areaStyle: {opacity:" + areaStyleOpacy + "},\n" +
                    "        data : [\n");
                    
                    for(int i=0; i<legendDataName.length; i++) {
                    chartImage.append(""+
                    "            {\n" +
                    "                value : dataValuesX[" + i + "],\n" +
                    "                name : legendDataNameX[" + i + "]\n" +
                    "            },\n");
                    
                    }
                    chartImage.append(""+       
                    "        ]\n" +
                    "    }]\n" +
                    "});\n" +
                    "chart.on('click', function (params) {\n" +
                    "    console.log(params);\n" +
                    "});\n" +
                    "</script>");
                    // Añade el gráfico al contexto de la página.
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Radar: {0}", e.getMessage());        
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
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }     
}
