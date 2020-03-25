
package pe.com.syscenterlife.echarts.threed;

import java.io.IOException;
import java.util.logging.Logger;
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
public class Line3DTag extends BodyTagSupport{
    protected static final Logger logger = Logger.getLogger(Line3DTag.class.getName());
    @Getter @Setter
    String idCharts;  
    @Getter @Setter
    String seriesTypeEchart="scatter3D";  /*line3D,surface,scatter3D,bar3D*/
    @Getter @Setter
    int[] visualMapMinMax={0,30};
    @Getter @Setter
    int seriaLineStyle=4;  
    @Getter @Setter
    private transient JSONArray dataValues;    
    @Getter @Setter
    String height="400px";    
    @Getter @Setter
    String width="600px"; 
    
    private transient PageContext pageContextR;

    public Line3DTag() {
    
    }   
    public Line3DTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }   
    
    @Override
    public int doEndTag() throws JspException {

        JSONArray visualMapMinMaxX= new JSONArray(visualMapMinMax);
        try {
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "        <div id=\"" + idCharts + "\"  style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 10px;\"></div>\n" +
                    "        <script>\n" +
                    "            var chart = echarts.init(document.getElementById('" + idCharts + "'));\n" +
                    "            var data = " + dataValues + ";\n" +
                    "            var visualMapMinMaxX=" + visualMapMinMaxX + ";       \n" +
                    "            chart.setOption({\n" +
                    "                tooltip: {},\n" +
                    "                backgroundColor: '#fff',\n" +
                    "                visualMap: {show: true,dimension: 2,min: visualMapMinMaxX[0],max: visualMapMinMaxX[1],\n" +
                    "                    inRange: {color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']}\n" +
                    "                },\n" +
                    "                xAxis3D: {type: 'value'},\n" +
                    "                yAxis3D: {type: 'value'},\n" +
                    "                zAxis3D: {type: 'value'},\n" +
                    "                grid3D: {viewControl: {}},\n" +
                    "                toolbox: {show : true,\n" +
                    "                feature : {mark : {show: true},dataView : {show: true, readOnly: false},saveAsImage : {show: true}}},					\n" +
                    "                series: [{\n" +
                    "                    type: '" + seriesTypeEchart + "',/*bar3D,line3D,surface,scatter3D*/\n" +
                    "                    data: data,\n" +
                    "                    lineStyle: {width: " + seriaLineStyle + "}\n" +
                    "                }]\n" +
                    "            });\n" +
                    "            window.addEventListener('resize', function () {\n" +
                    "                chart.resize();\n" +
                    "            });\n" +
                    "        </script>");
            
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.info("Error en generar grafico Line3D: "+e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    } 
    
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }    
}
