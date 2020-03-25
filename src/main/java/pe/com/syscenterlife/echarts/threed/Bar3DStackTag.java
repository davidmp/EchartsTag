
package pe.com.syscenterlife.echarts.threed;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

/**
 *
 * @author davidmp
 */
public class Bar3DStackTag extends BodyTagSupport{
    protected static final Logger logger = Logger.getLogger(Bar3DStackTag.class.getName());
    @Getter @Setter
    String idCharts="main";   
    @Getter @Setter
    String seriesTypeEchart="bar3D";  /*bar3D,line3D,surface,scatter3D*/
    @Getter @Setter
    private transient JSONArray dataValues;
    @Getter @Setter
    double[] styleNormalEmphasis={0.8,0.4};/*0.2, 0.4*/
    @Getter @Setter
    int[] grid3DboxWidthDepth={200,80};
    @Getter @Setter
    boolean viewControlAutoRotate=false;
    @Getter @Setter
    double lightIntensity=0.8;    

    @Getter @Setter
    String height="400px";    
    @Getter @Setter
    String width="600px";  
    
    private transient PageContext pageContextR;

    public Bar3DStackTag() {
    }
    public Bar3DStackTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        
        JSONArray styleNormalEmphasisx= new JSONArray(styleNormalEmphasis); 
        JSONArray grid3DboxWidthDepthx= new JSONArray(grid3DboxWidthDepth); 
        try {        
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""
                    + "      <div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 10px;\"></div>\n" +
                    "        <script>\n" +
                    "            var chart = echarts.init(document.getElementById('" + idCharts + "'));\n" +
                    "            var styleNormalEmphasis=" + styleNormalEmphasisx + ";\n" +
                    "            var grid3DboxWidthDepth=" + grid3DboxWidthDepthx + ";\n" +
                    "            var data=" + dataValues + "\n" +
                    "            var series = [];\n" +
                    "            for (var i = 0; i < 10; i++) {\n" +
                    "                series.push({\n" +
                    "                    type: '" + seriesTypeEchart + "', /*bar3D,line3D,surface,scatter3D*/\n" +
                    "                    data: data,\n" +
                    "                    stack: 'stack',\n" +
                    "                    shading: 'lambert',\n" +
                    "                    label: {\n" +
                    "                        normal: {textStyle: {fontSize: 16,borderWidth: 1,opacity: 1}},\n" +
                    "                        emphasis: {textStyle: {fontSize: 20,color: '#900',opacity: 1}},					\n" +
                    "                        formatter: function (param) {return param.value[2].toFixed(1);}\n" +
                    "                    },\n" +
                    "                    itemStyle: {normal: {opacity: styleNormalEmphasis[0]/*0.2*/},emphasis: {color: '#900',opacity: styleNormalEmphasis[1]}}					\n" +
                    "                });\n" +
                    "            }\n" +
                    "            chart.setOption({\n" +
                    "                tooltip: {},\n" +
                    "                xAxis3D: {type: 'value'},\n" +
                    "                yAxis3D: {type: 'value'},\n" +
                    "                zAxis3D: {type: 'value'},\n" +
                    "                grid3D: { boxWidth: grid3DboxWidthDepth[0], boxDepth: grid3DboxWidthDepth[1],\n" +
                    "                    viewControl: {autoRotate: " + viewControlAutoRotate + " },\n" +
                    "                    light: { main: {shadow: true},ambient: {intensity: " + lightIntensity + "/*0.8*/}}					\n" +
                    "                },                \n" +
                    "                toolbox: {show : true, feature : {mark : {show: true},dataView : {show: true, readOnly: false},saveAsImage : {show: true} } },				\n" +
                    "                series: series                			\n" +
                    "            });\n" +
                    "            window.onresize = chart.resize;\n" +
                    "        </script>");
            pageContextR.getOut().append(chartImage); 
        } catch (IOException e) {
            logger.info("Error en generar grafico Bar3dStack: "+e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }
    
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }    
        
}
