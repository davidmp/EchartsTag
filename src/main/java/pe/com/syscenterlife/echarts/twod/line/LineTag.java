
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
 *
 * @author davidmp
 */
public class LineTag extends BodyTagSupport {
    protected static final Logger logger = Logger.getLogger(LineTag.class.getName());
    @Getter @Setter
    String idCharts; 
    @Getter @Setter
    private transient Object[] dataValues;
    @Getter @Setter
    String[] legendDataName;
    @Getter @Setter
    String[] chartAxisXYCategory;
    @Getter @Setter
    String echartsOriented="horizontal";/*vertical,horizontal*/
    @Getter @Setter
    boolean[] seriesMarkPointMinMax ={false,false,false,false,false};
    @Getter @Setter
    boolean[] seriesMarkLineMedia ={false,false,false,false,false};    
    @Getter @Setter
    String scriptAdd="";
    @Getter @Setter
    public String height = "540px";
    @Getter @Setter
    public String width = "800px";
    

    private transient PageContext pageContextR;

    public LineTag() {    
    }
    public LineTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        String theme;
        theme=(String)((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme");
        JSONArray legendDataNameX=new JSONArray(legendDataName);
        JSONArray chartAxisXYCategoryX=new JSONArray(chartAxisXYCategory);
        JSONArray dataValuesX=new JSONArray(dataValues);
        String x;
        String y;
        if(echartsOriented.equals("horizontal")){
        x="xAxis"; y="yAxis";
        }else{ x="yAxis"; y="xAxis"; }        
        
        try {     
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
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }      
}
