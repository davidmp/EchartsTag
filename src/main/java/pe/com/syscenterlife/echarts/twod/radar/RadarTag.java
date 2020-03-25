
package pe.com.syscenterlife.echarts.twod.radar;

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
public class RadarTag extends BodyTagSupport {
    protected static final Logger logger = Logger.getLogger(RadarTag.class.getName());
    
    @Getter @Setter
    private transient Object[][] indicadorData;
    @Getter @Setter
    String[] legendDataName;
    @Getter @Setter
    private transient JSONArray dataValues;
    @Getter @Setter
    double areaStyleOpacy=0.1;  
    @Getter @Setter
    String idCharts;    
    @Getter @Setter
    String seriesName;
    @Getter @Setter
    String lineStyleType="solid";/*'solid','dashed','dotted'*/    
    @Getter @Setter
    String toolboxOrient="vertical";/*'vertical', 'horizontal'*/    
    @Getter @Setter
    public String height = "400px";
    @Getter @Setter
    public String width = "600px";
    
    
    
    
    private transient PageContext pageContextR;

    public RadarTag() {
    }
    public RadarTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        String theme;
        theme=(String)((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme");

        JSONArray legendDataNameX=new JSONArray(legendDataName);
        try {

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

            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.info("Error en generar grafico Radar: "+e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }   
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }     
}
