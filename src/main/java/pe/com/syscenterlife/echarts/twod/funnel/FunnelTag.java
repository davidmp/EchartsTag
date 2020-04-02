
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
 *
 * @author davidmp
 */
public class FunnelTag extends BodyTagSupport {
    protected static final Logger logger = Logger.getLogger(FunnelTag.class.getName());
    @Getter @Setter
    String idCharts; 
    @Getter @Setter
    private transient Object[][] dataValues;
    @Getter @Setter
    String[] legendDataName;
    @Getter @Setter
    String chartTitle;
    @Getter @Setter
    String[] serieCategoryName;
    @Getter @Setter
    String[] serieLabelPosition={"outside", "inside"};
    @Getter @Setter
    double[] serieItemStyleOpacy={0.7, 0.5};
    @Getter @Setter
    String[] serieLabelFormatter={"{b}", "{c}%"};
    @Getter @Setter
    String[] serieSort={"descending", "descending"};/*ascending,descending*/
    
    @Getter @Setter
    public String height = "460px";
    @Getter @Setter
    public String width = "760px";
    
    
    
    
    
    private transient PageContext pageContextR;

    public FunnelTag() {    
    }
    public FunnelTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        String theme;
        theme=(String)((HttpServletRequest)this.pageContextR.getRequest()).getSession().getAttribute("echartstheme");
        JSONArray legendDataNameX=new JSONArray(legendDataName);
        try {            
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
                    "        tooltip: {trigger: 'item',formatter: \"{a} <br/>{b} : {c}%\"},\n" +
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

    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }    
}
