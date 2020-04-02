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
 *
 * @author davidmp
 */
public class RadarMultiTag extends BodyTagSupport{
    protected static final Logger logger = Logger.getLogger(RadarMultiTag.class.getName());
    @Getter @Setter
    String idCharts; 
    @Getter @Setter
    private transient Object[] dataValuesM;
    @Getter @Setter
    private transient Object[][] indicadorPositionWH;
    @Getter @Setter
    double[] areaStyleOpacy;
    @Getter @Setter
    private transient Object[] indicadorDataM;
    @Getter @Setter
    String[] legendDataName;
    @Getter @Setter
    String chartTitle;
    @Getter @Setter
    public String height = "530px";
    @Getter @Setter
    public String width = "900px";

    private transient PageContext pageContextR;

    public RadarMultiTag() {
    }
    public RadarMultiTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        String theme;
        theme=(String)((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme");

        JSONArray legendDataNameX=new JSONArray(legendDataName);
        JSONArray dataValuesMX=new JSONArray(dataValuesM);
        try {

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
    
    @Override
    public int doStartTag() throws JspException {       
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }      
}
