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
 * La clase {@code RadarO2Tag} proporciona una etiqueta personalizada para generar gráficos de radar O2
 * utilizando la biblioteca ECharts en páginas JSP.
 * Esta etiqueta permite configurar datos, leyendas, colores visuales, estilos de línea y otras propiedades
 * del gráfico de radar O2.
 *
 * Ejemplo de uso en JSP:
 * {@code
 * <custom:radarO2Tag idCharts="radarChart" indicadorData="..." legendDataName="..." visualMapColors="..." dataValues="..." seriesName="..." lineStyleType="..." chartTitle="..." height="..." width="..." />
 * }
 *
 * @author davidmp et al.
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class RadarO2Tag extends BodyTagSupport{
    /**
     * Logger para registrar eventos y errores.
     */
    protected static final Logger logger = Logger.getLogger(RadarO2Tag.class.getName());
    /**
     * Identificador del div que contendrá el gráfico.
     */
    @Getter @Setter
    String idCharts; 
    /**
     * Datos de los indicadores del gráfico de radar O2.
     */
    @Getter @Setter
    private transient Object[][] indicadorData;
    /**
     * Nombres de las leyendas del gráfico.
     */
    @Getter @Setter
    String[] legendDataName;
    /**
     * Colores visuales para el visual map del gráfico de radar O2.
     */
    @Getter @Setter
    String[] visualMapColors={"red", "yellow"};
    /**
     * Valores de los datos del gráfico de radar O2.
     */
    @Getter @Setter
    private transient JSONArray dataValues;
    /**
     * Nombre de la serie del gráfico de radar O2.
     */
    @Getter @Setter
    String seriesName;
    /**
     * Tipo de estilo de línea para el gráfico de radar O2. 'solid','dashed','dotted'
     */
    @Getter @Setter
    String lineStyleType="dotted";/*'solid','dashed','dotted'*/
    /**
     * Título del gráfico de radar O2.
     */
    @Getter @Setter
    String chartTitle;   
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
    public RadarO2Tag() {
    }
    /**
     * Constructor con contexto de página.
     *
     * @param pageContextxx el contexto de la página JSP.
     */
    public RadarO2Tag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico de radar O2 en la página web.
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
        // Convierte los colores visuales a formato JSON.
        JSONArray visualMapColorsX=new JSONArray(visualMapColors);
        try {
                // Genera el código HTML y JavaScript para el gráfico de radar O2. 
            StringBuilder chartImage = new StringBuilder();
            
            chartImage.append(""+
            "    <div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
            "    <script>\n" +
            "    var legendDataNameX=" + legendDataNameX + ";\n" +
            "    var dataValuesX=" + dataValues + ";\n" +
            "    var chart = echarts.init(document.getElementById('" + idCharts + "'),'"+theme+"');\n" +
            "\n" +
            "    chart.setOption({\n" +
            "        title : {\n" +
            "            text: '" + chartTitle + "',\n" +
            "            subtext: 'Pura ficcion',\n" +
            "            x:'center',\n" +
            "            y:'bottom'}, \n" +
            "        tooltip : {\n" +
            "            trigger: 'item',\n" +
            "            backgroundColor : 'rgba(0,0,250,0.2)' },\n" +
            "        legend: {\n" +
            "            data: legendDataNameX },\n" +
            "        visualMap: {\n" +
            "            color: " + visualMapColorsX + " }, \n" +
            "        radar: {\n" +
            "           indicator : [\n");
              // Agrega las configuraciones de los indicadores del radar.      
            for(int i=0; i<indicadorData[0].length; i++) {
            chartImage.append(""+
            "            {text: '" + indicadorData[0][i] + "', max: " + indicadorData[1][i] + "},\n");
                    
            }
            chartImage.append(""+        
            "            ] },\n" +
            "        toolbox: {orient: 'vertical',left: 'right',top: 'center',\n" +
            "            feature: {dataView: {},saveAsImage: {},restore: {}}},\n" +
            "        \n" +
            "        series : [{\n" +
            "        name: '" + seriesName + "',\n" +
            "        type: 'radar',\n" +
            "        symbol: 'none',\n" +
            "        label: {\n" +
            "            normal: {\n" +
            "                show: true\n" +
            "            } }\n" +
            "        ,\n" +
            "        itemStyle: {normal: {lineStyle: {width:1}}},\n" +
            "        lineStyle: {type:'" + lineStyleType + "'},/*'solid','dashed','dotted'*/        \n" +
            "        emphasis: {areaStyle: {color:'rgba(0,250,0,0.3)'}},\n" +
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
            "    });\n" +
            "    </script>");
            // Añade el gráfico al contexto de la página.
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico RadarO2Tag: {0}", e.getMessage()); 
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs RadarO2Tag: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico RadarO2Tag: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib RadarO2Tag: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs RadarO2Tag: {0}", e.getMessage());
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
