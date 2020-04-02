
package pe.com.syscenterlife.echarts.twod.scatter;

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
public class ScatterTag extends BodyTagSupport{
    protected static final Logger logger = Logger.getLogger(ScatterTag.class.getName());
    @Getter @Setter
    String idCharts; 
    @Getter @Setter
    private transient Object[] dataValuesM;
    @Getter @Setter
    String[]  chartLegendNames;
    @Getter @Setter
    String[] seriesSymbol={"circle","rect","triangle"};//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow', 'none'
    @Getter @Setter
    String[] seriesLabelColor={"black","red","blue"};
    @Getter @Setter
    double[] seriesItemStyleOpacy={0.8,0.8,0.8};
    @Getter @Setter
    boolean[] seriesLabelShow={false,true,false};
    
    @Getter @Setter
    public String height = "460px";
    @Getter @Setter
    public String width = "800px";
    
    
 
    
    private transient PageContext pageContextR;

    public ScatterTag() {
    }
    public ScatterTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        String theme;
        theme=(String)((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme");

        JSONArray chartLegendNamesX=new JSONArray(chartLegendNames);
        JSONArray dataValuesMX= new JSONArray(dataValuesM);
        try {

            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "<div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
                    "<script>\n" +
                    "        var chart = echarts.init(document.getElementById('" + idCharts + "'),'"+theme+"');\n" +
                    "        var names = " + chartLegendNamesX + ";\n" +
                    "        var dataMX=" + dataValuesMX + ";\n" +
                    "        chart.setOption({\n" +
                    "            aria: {show: true},\n" +
                    "            legend: {data: names.slice()},\n" +
                    "            toolbox: {orient: 'vertical',left: 'left',top: 'center',\n" +
                    "                feature: {dataView: {},saveAsImage: {},dataZoom: {},restore: {show: true}}},\n" +
                    "            tooltip: {trigger: 'axis',axisPointer: {type: 'cross'}},\n" +
                    "            xAxis: {\n" +
                    "                type: 'value',\n" +
                    "                splitLine: {show: true}, min: 0, max: 15, splitNumber: 30 }, \n" +
                    "            yAxis: {\n" +
                    "                type: 'value',\n" +
                    "                splitLine: { show: true } },\n" +
                    "            dataZoom: [\n" +
                    "                        {id: 'sliderX',show: true,xAxisIndex: [0],start: 10,end: 70},\n" +
                    "                        {id: 'sliderY',show: true,yAxisIndex: [0],start: 0,end: 20},\n" +
                    "                        {type: 'inside',xAxisIndex: [0],start: 10,end: 70},\n" +
                    "                        {type: 'inside',yAxisIndex: [0],start: 0,end: 20} ],\n" +
                    "            series: [\n");
            
                    for (int i = 0; i < dataValuesM.length; i++) {
            
                    chartImage.append(""+
                    "            {\n" +
                    "                name: names[" + i + "],\n" +
                    "                type: 'scatter',\n" +
                    "                symbol: '" +seriesSymbol[i]+ "',\n" +
                    "                label: {emphasis: {show: true},color: '" +seriesLabelColor[i]+ "', show:" +seriesLabelShow[i]+ "},                        \n" +
                    "                symbolSize: function (val) {return val[2] * 40;},\n" +
                    "                itemStyle: {opacity:" +seriesItemStyleOpacy[i]+ "},                        \n" +
                    "                data: dataMX[" + i + "],\n" +
                    "                markLine: {data: [{name: 'Max',type: 'max'},{name: 'Minimum value',type: 'min'},{name: 'median',type: 'median'}]} }\n" +
                    "            ,\n");
                    
                    }
                    
                    chartImage.append(""+
                    "            ],\n" +
                    "            animationDelay: function (idx) {\n" +
                    "                return idx * 20; } , \n " +
                    "            animationDelayUpdate: function (idx) {\n" +
                    "                return idx * 20;\n" +
                    "            }\n" +
                    "        });\n" +
                    "        chart.on('click', function (params) {\n" +
                    "            console.log(params.data);\n" +
                    "        });\n" +
                    "</script>");

            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Scatter: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Scatter: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Scatter: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Scatter: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Scatter: {0}", e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }     
    
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }     
}
