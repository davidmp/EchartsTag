
package pe.com.syscenterlife.echarts.threed;

import java.io.IOException;
import java.util.logging.Level;
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
public class Bar3DSimpleTag extends BodyTagSupport{
    protected static final Logger logger = Logger.getLogger(Bar3DSimpleTag.class.getName());
    @Getter @Setter
    String idCharts;                       
    @Getter @Setter
    int[] visualMapMinMax={2,6};
    @Getter @Setter
    int[] z3DMinMax={0,10};
    @Getter @Setter
    int[] grid3DboxWidthDepth={200,80};
    @Getter @Setter
    boolean viewControlAutoRotate=false;
    @Getter @Setter
    double lightIntensity=0.2;
    @Getter @Setter
    String seriesTypeEchart="bar3D";  /*bar3D,line3D,surface,scatter3D*/
    @Getter @Setter
    private transient JSONArray dataValues;                   
    @Getter @Setter
    double[] styleNormalEmphasis={1,1};/*0.4, 0.4*/   
    @Getter @Setter
    String height="400px";    
    @Getter @Setter
    String width="600px";      
    
    private transient PageContext pageContextR;
    
    public Bar3DSimpleTag() {
    }
    public Bar3DSimpleTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        JSONArray typeEjesXYZx=new JSONArray(visualMapMinMax);
        JSONArray zAxis3DMinMaxx=new JSONArray(z3DMinMax);
        JSONArray grid3DboxWidthDepthx=new JSONArray(grid3DboxWidthDepth);
        JSONArray styleNormalEmphasisx=new JSONArray(styleNormalEmphasis);
        
        
        try {   
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "<div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 10px;\"></div>\n" +
                    "        <script>\n" +
                    "            var chart = echarts.init(document.getElementById('" + idCharts + "'));\n" +
                    "            \n" +
                    "            var visualMapMinMax=" + typeEjesXYZx + ";\n" +
                    "            var zAxis3DMinMax=" + zAxis3DMinMaxx + ";\n" +
                    "            var grid3DboxWidthDepth=" + grid3DboxWidthDepthx + ";\n" +
                    "            var styleNormalEmphasis=" + styleNormalEmphasisx + ";\n" +
                    "            \n" +
                    "            chart.setOption({\n" +
                    "                visualMap: {\n" +
                    "                    show: false, min: visualMapMinMax[0], max: visualMapMinMax[1],\n" +
                    "                    inRange: {\n" +
                    "                        color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']\n" +
                    "                    }\n" +
                    "                },\n" +
                    "                xAxis3D: {type: 'value'},\n" +
                    "                yAxis3D: {type: 'value'},\n" +
                    "                zAxis3D: {type: 'value', min: zAxis3DMinMax[0], max: zAxis3DMinMax[1],  axisPointer: { lineStyle: { color: '#009' } } },\n" +
                    "                grid3D: {boxWidth: grid3DboxWidthDepth[0],boxDepth: grid3DboxWidthDepth[1],                \n" +
                    "                    viewControl: { autoRotate: " + viewControlAutoRotate + "},                                       \n" +
                    "                    light: { main: {shadow: true, quality: 'ultra', intensity: " + lightIntensity + " /*1.5*/} }\n" +
                    "                },\n" +
                    "                toolbox: {show : true, \n" +
                    "                        feature : {mark : {show: true},dataView : {show: true, readOnly: false}, saveAsImage : {show: true} }\n" +
                    "                },				\n" +
                    "                series: [{\n" +
                    "                    type: '" + seriesTypeEchart + "',/*bar3D,line3D,surface,scatter3D*/\n" +
                    "                    data: " + dataValues + ",\n" +
                    "                    shading: 'lambert',\n" +
                    "                    label: {\n" +
                    "                        formatter: function (param) { return param.value[2].toFixed(1); }\n" +
                    "                    },\n" +
                    "                    itemStyle: {normal: { opacity: styleNormalEmphasis[0]/*0.2*/}, emphasis: {color: '#900',opacity: styleNormalEmphasis[1]/*0.4*/} }\n" +
                    "                }]\n" +
                    "            });\n" +
                    "            window.onresize = chart.resize;\n" +
                    "        </script>");
            
            pageContextR.getOut().append(chartImage); 
        } catch (IOException e) {            
            logger.log(Level.INFO, "Error en generar grafico Bar3DSimple: {0}", e.getMessage()); 
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Bar3DSimple: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Bar3DSimple: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Bar3DSimple: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Bar3DSimple: {0}", e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }
    
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }    
    
}
