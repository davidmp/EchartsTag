
package pe.com.syscenterlife.echarts.twod.funnel;

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
 * La clase {@code FunnelTag} proporciona una etiqueta personalizada para generar gráficos de embudo utilizando la biblioteca ECharts en páginas JSP.
 * Esta etiqueta permite configurar datos, títulos, leyendas, estilos y otras propiedades del gráfico de embudo.
 *
 * Ejemplo de uso en JSP:
 * {@code
 * <custom:funnelTag idCharts="funnelChart" dataValues="..." legendDataName="..." chartTitle="..." ... />
 * }
 *
 * @author davidmp
 * @since 1.0
 * @see <a href="https://echarts.apache.org/">ECharts</a>
 * @see BodyTagSupport
 */

public class FunnelTag extends BodyTagSupport {
    /**
     * Logger para registrar eventos y errores.
     */    
    protected static final Logger logger = Logger.getLogger(FunnelTag.class.getName());
    /**
     * Identificador del div que contendrá el gráfico.
     */    
    @Getter @Setter
    String idCharts; 
    /**
     * Datos para el gráfico de embudo.
     */    
    @Getter @Setter
    private transient Object[][] dataValues;
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
     * Nombres de las categorías de series.
     */    
    @Getter @Setter
    String[] serieCategoryName;
    /**
     * Posiciones de las etiquetas de la serie. "outside", "inside"
     */    
    @Getter @Setter
    String[] serieLabelPosition={"outside", "inside"};
    /**
     * Opacidad de los elementos de la serie.
     */    
    @Getter @Setter
    double[] serieItemStyleOpacy={0.7, 0.5};
    /**
     * Formato de las etiquetas de la serie.
     */    
    @Getter @Setter
    String[] serieLabelFormatter={"{b}", "{c}"};
    /**
     * Orden de clasificación de las series. Ejem. ascending,descending
     */
    @Getter @Setter
    String[] serieSort={"descending", "descending"};/*ascending,descending*/
    /**
     * Altura del contenedor del gráfico.
     */    
    @Getter @Setter
    public String height = "460px";
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
    public FunnelTag() {    
    }
    /**
     * Constructor con contexto de página.
     * 
     * @param pageContextxx el contexto de la página JSP.
     */    
    public FunnelTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }
    /**
     * Método que se llama al finalizar la etiqueta. Genera el código HTML y JavaScript
     * necesario para renderizar el gráfico de embudo en la página web.
     * 
     * @return {@code SKIP_BODY} para indicar que el cuerpo de la etiqueta debe ser ignorado.
     * @throws JspException si ocurre un error durante la ejecución de la etiqueta.
     */
    @Override
    public int doEndTag() throws JspException {
        // Obtiene el tema de ECharts desde la sesión HTTP o usa uno predeterminado.
        String theme;
        theme=(String)((HttpServletRequest)this.pageContextR.getRequest()).getSession().getAttribute("echartstheme");
        // Convierte los nombres de leyendas a formato JSON.
        JSONArray legendDataNameX=new JSONArray(legendDataName);
        try {  
            // Genera el código HTML y JavaScript para el gráfico de embudo.
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "        <div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\" > </div>\n" +
                    "        <script>\n" +
                    "\n" +
                    "        var chart = echarts.init(document.getElementById('" + idCharts + "'), '"+theme+"', {});\n" +
                    "        chart.setOption({    \n" +
                    "        title: {\n" +
                    "        text: '" + chartTitle + "',\n" +
                    "        x:'center',\n" +
                    "        y:'top'\n" +
                    "        },\n" +
                    "        tooltip: {trigger: 'item',formatter: \"{a} <br/>{b} :{c} - {d}%\"}, \n" +
                    "        toolbox: {feature: {dataView: {readOnly: false},restore: {},saveAsImage: {}}},\n" +
                    "        legend: {right: 'center',bottom: 0, orient: 'horizontal', \n" +
                    "                data: " + legendDataNameX + "\n" +
                    "        },\n" +
                    "        series: [\n");
            
                    for (int i = 0; i < (dataValues[0].length)-1; i++) {
                    chartImage.append(""+ 
                    "                {\n" +
                    "                name: '" + serieCategoryName[i] + "',\n" +
                    "                type: 'funnel',\n" +
                    "                left: '10%',\n" +
                    "                width: '80%',\n" +
                    "                sort: '" + serieSort[i] + "',\n" +
                    "                label: {position:'" + serieLabelPosition[i] + "',formatter: '" + serieLabelFormatter[i] + "'},\n" +
                    "                itemStyle: {opacity: " + serieItemStyleOpacy[i] + "},\n" +
                    "                emphasis: {label: {position: 'inside'}},\n" +
                    "                data: [\n");
                    for (int j = 0; j < (dataValues.length); j++) {
                    chartImage.append(""+ 
                    "                        {value: " + dataValues[j][(i+1)] + ", name: '" + dataValues[j][0] + "'},\n");
                    
                    }
                    chartImage.append(""+ 
                    "                ]\n" +
                    "                },\n");
                    
                    }
                    chartImage.append(""+ 
                    "        ]\n" +
                    "        });\n" +
                    "        </script>");
                    // Añade el gráfico al contexto de la página.
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Funnel: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Funnel: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Funnel: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Funnel: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Funnel: {0}", e.getMessage());
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
