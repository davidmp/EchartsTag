
package pe.com.syscenterlife.echarts.twod.line;

import java.io.IOException;
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
public class LineAreaTag extends BodyTagSupport{
    protected static final Logger logger = Logger.getLogger(LineAreaTag.class.getName());
    @Getter @Setter
    String idCharts; 
    @Getter @Setter
    private transient Object[] dataValues;
    @Getter @Setter
    String chartTitle;
    @Getter @Setter
    private transient Object[] ejeDataX;
    @Getter @Setter
    String[] legendDataName;
    @Getter @Setter
    String[] legendNameUnit;
    @Getter @Setter
    String[] legendNameLocation;
    @Getter @Setter
    boolean[] legendNameInverse;
    @Getter @Setter
    int[] serieIndex;
    @Getter @Setter
    double[] serieAreaStyleOpacy={0.8, 0.8};    
    
    @Getter @Setter
    public String height = "500px";
    @Getter @Setter
    public String width = "760px";
    
 
    
    
    private transient PageContext pageContextR;

    public LineAreaTag() {    
    }
    public LineAreaTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        String theme;
        theme=(String)((HttpServletRequest)this.pageContextR.getRequest()).getSession().getAttribute("echartstheme");

        JSONArray ejeDataXX=new JSONArray(ejeDataX);
        JSONArray dataValuesX=new JSONArray(dataValues);
        JSONArray legendDataNameX=new JSONArray(legendDataName);
     
        
        try {     
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "        <div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
                    "        <script>\n" +
                    "        var chart = echarts.init(document.getElementById('" + idCharts + "'), '"+theme+"', {});\n" +
                    "        var sampling = 'none';\n" +
                    "        var ejeDataXX=" + ejeDataXX + ";\n" +
                    "        var dataValues=" + dataValuesX + ";\n" +
                    "        chart.setOption({\n" +
                    "            title : {text: '" + chartTitle + "',x: 'center'},\n" +
                    "            tooltip: {trigger: 'axis',axisPointer: {type: 'cross',animation: false,label: {backgroundColor: '#505765'}}},        \n" +
                    "            legend: { data:" + legendDataNameX + ",x: 'left'},\n" +
                    "            toolbox: {orient: 'vertical',left: 'right',top: 'center',\n" +
                    "                feature : {mark : {show: true},dataView : {show: true, readOnly: false},\n" +
                    "                    magicType : {show: true, type: ['line', 'bar']},restore : {show: true},\n" +
                    "                    saveAsImage : {show: true}}},\n" +
                    "            grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},                    \n" +
                    "            dataZoom: [\n" +
                    "                {show: true,realtime: true,start: 80,end: 100},\n" +
                    "                {type: 'inside',show: true,realtime: true,start: 80,end: 100}],\n" +
                    "            xAxis : [\n" +
                    "                {\n" +
                    "                    type : 'category',\n" +
                    "                    boundaryGap : false,\n" +
                    "                    axisLine: {onZero: false},\n" +
                    "                    data : ejeDataXX.map(function (str) {return str.replace(' ', '\\n');})\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            yAxis : [\n");
                    for (int i = 0; i < dataValues.length; i++) {
                    chartImage.append(""+
                    "            {name : '" + legendNameUnit[i] + "', nameLocation: '" + legendNameLocation[i] + "', type : 'value',inverse: " + legendNameInverse[i] + "},\n");
                    } 
                    chartImage.append(""+
                    "            ],\n" +
                    "            series : [\n");
                    for (int i = 0; i < dataValues.length; i++) {
                    chartImage.append(""+
                    "                {\n" +
                    "                    name:'" + legendDataName[i] + "',\n" +
                    "                    type:'line',\n" +
                    "                    yAxisIndex:" + serieIndex[i] + ",\n" +
                    "                    notShowSymbol: true,\n" +
                    "                    sampling: sampling,\n" +
                    "                    hoverAnimation: false,\n" +
                    "                    areaStyle: { opacity: " + serieAreaStyleOpacy[i] + "},\n" +
                    "                    data:dataValues[" + i + "]\n" +
                    "                },\n");
                    
                    }
                    chartImage.append(""+
                    "            ]\n" +
                    "        });\n" +
                    "        </script>");

            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.info("Error en generar grafico LineArea: "+e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }
    
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }     
}
