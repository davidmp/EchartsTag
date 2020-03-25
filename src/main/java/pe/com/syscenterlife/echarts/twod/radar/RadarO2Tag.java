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
public class RadarO2Tag extends BodyTagSupport{
    protected static final Logger logger = Logger.getLogger(RadarO2Tag.class.getName());
    @Getter @Setter
    String idCharts; 
    @Getter @Setter
    private transient Object[][] indicadorData;
    @Getter @Setter
    String[] legendDataName;
    @Getter @Setter
    String[] visualMapColors={"red", "yellow"};
    @Getter @Setter
    private transient JSONArray dataValues;
    @Getter @Setter
    String seriesName;
    @Getter @Setter
    String lineStyleType="dotted";/*'solid','dashed','dotted'*/
    @Getter @Setter
    String chartTitle;    
    @Getter @Setter
    public String height = "400px";
    @Getter @Setter
    public String width = "600px";
    
    private transient PageContext pageContextR;

    public RadarO2Tag() {
    }
    public RadarO2Tag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        String theme;
        theme=(String)((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme");

        JSONArray legendDataNameX=new JSONArray(legendDataName);
        JSONArray visualMapColorsX=new JSONArray(visualMapColors);
        try {
                
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

            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.info("Error en generar grafico RadarO2Tag: "+e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }    
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }      
}
