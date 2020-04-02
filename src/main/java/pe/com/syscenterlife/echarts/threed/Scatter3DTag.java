
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
public class Scatter3DTag  extends BodyTagSupport{
    protected static final Logger logger = Logger.getLogger(Scatter3DTag.class.getName());
    @Getter @Setter
    String idCharts; 
    @Getter @Setter
    int[] grid3DBoxXYZ={100,100,100};
    @Getter @Setter
    String seriesTypeEchart="scatter3D";  /*line3D,surface,scatter3D*/    
    @Getter @Setter
    private transient JSONArray dataValues;    
    @Getter @Setter
    String height="400px";    
    @Getter @Setter
    String width="600px";     
    
    private transient PageContext pageContextR;

    public Scatter3DTag() {
    
    }   
    public Scatter3DTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }   
    
    @Override
    public int doEndTag() throws JspException {

        JSONArray grid3DBoxXYZx= new JSONArray(grid3DBoxXYZ);
        try {
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                    "<div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 5px;\"></div>\n" +
                    "<script>\n" +
                    "    var chart = echarts.init(document.getElementById('" + idCharts + "'));\n" +
                    "    var data = " + dataValues + ";           \n" +
                    "    var grid3DBoxXYZ = " + grid3DBoxXYZx + ";           \n" +
                    "    chart.setOption({\n" +
                    "        tooltip: {},\n" +
                    "        visualMap: {\n" +
                    "            show: true,\n" +
                    "            min: 2,\n" +
                    "            max: 6,\n" +
                    "            inRange: {\n" +
                    "                symbolSize: [0.5, 15],\n" +
                    "                color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026'],\n" +
                    "                colorAlpha: [0.2, 1]}\n" +
                    "        },\n" +
                    "        xAxis3D: {type: 'value'},\n" +
                    "        yAxis3D: {type: 'value'},\n" +
                    "        zAxis3D: {type: 'value'},\n" +
                    "        grid3D: {\n" +
                    "            boxWidth: grid3DBoxXYZ[0],\n" +
                    "            boxDepth: grid3DBoxXYZ[1],\n" +
                    "            boxHeight: grid3DBoxXYZ[2],\n" +
                    "            viewControl: {}\n" +
                    "        },\n" +
                    "        toolbox: {show : true,\n" +
                    "        feature : {mark : {show: true},dataView : {show: true, readOnly: false},saveAsImage : {show: true}}},				\n" +
                    "        series: [{ type: '" + seriesTypeEchart + "', /*line3D,surface,scatter3D*/data: data}]\n" +
                    "    });\n" +
                    "    window.onresize = chart.resize;\n" +
                    "</script>");
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Scatter3D: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Scatter3D: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Scatter3D: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Scatter3D: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Scatter3D: {0}", e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }   
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }    
}
