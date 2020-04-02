
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
public class Grid3DTag extends BodyTagSupport{
    
    protected static final Logger logger = Logger.getLogger(Grid3DTag.class.getName());
     
    @Getter @Setter
    private transient JSONArray dataValues;
    @Getter @Setter
    String idCharts;
    @Getter @Setter    
    private transient Object[] dataTagX;
    @Getter @Setter
    private transient Object[] dataTagY;
    
    @Getter @Setter
    int[] z3DMinMax={0,50};
    @Getter @Setter
    String seriesTypeEchart="scatter3D";   
    @Getter @Setter
    String height="400px";    
    @Getter @Setter
    String width="600px"; 
    @Getter @Setter
    String color="red"; 
    
    private transient PageContext pageContextR;

    public Grid3DTag() {
    
    } 
    public Grid3DTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    } 
    
    @Override
    public int doEndTag() throws JspException {

        int widthX=Integer.parseInt(width.substring(0,width.length()-2));
        int heightX=Integer.parseInt(height.substring(0,height.length()-2));
        JSONArray dataTagXX= new JSONArray(dataTagX); 
        JSONArray dataTagYX= new JSONArray(dataTagY); 
        JSONArray zAxis3DMinMaxx= new JSONArray(z3DMinMax); 
            
        try {
            StringBuilder chartImage = new StringBuilder();
        chartImage.append(""+ 
                        "<div id=\"" + idCharts + "\"  style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 10px;\"></div>\n" +
                        "        <script>\n" +
                        "            var chart = echarts.init(document.getElementById('" + idCharts + "'));\n" +
                        "            var datax = " + dataValues + ";\n" +
                        "            var zAxis3DMinMaxx=" + zAxis3DMinMaxx + ";\n" +
                        "            chart.setOption({\n" +
                        "                backgroundColor: '#fff',\n" +
                        "                xAxis3D: [{type: 'category',\n" +
                        "                    data: " + dataTagXX + "\n" +
                        "                }, {type: 'value',min: -1,max: 1,grid3DIndex: 1}],\n" +
                        "                yAxis3D: [{type: 'category',\n" +
                        "                    data: " + dataTagYX + "\n" +
                        "                }, {type: 'value',min: -1,max: 1,grid3DIndex: 1 }],            \n" +
                        "                zAxis3D: [{type: 'value',min: zAxis3DMinMaxx[0], max: zAxis3DMinMaxx[1]}, {type: 'value',min: -1,max: 1,grid3DIndex: 1}],   \n" +
                        "                \n" +
                        "                grid3D: [{top: -50,width: " + widthX + ",height: " + (heightX+100) + ",temporalSuperSampling: {enable: true} }, \n" +
                        "                    {top: 100,left: 700,temporalSuperSampling: {enable: true}}],					\n" +
                        "                toolbox: {show : true,\n" +
                        "                feature : {mark : {show: true},dataView : {show: true, readOnly: false},saveAsImage : {show: true}}},				\n" +
                        "                series: [{\n" +
                        "                    type: '" + seriesTypeEchart + "', /*bar3D,line3D,surface,scatter3D*/\n" +
                        "                    symbolSize: 20,\n" +
                        "                    data: datax, color:'" + color + "'\n" +
                        "                }]\n" +
                        "            });\n" +
                        "            window.addEventListener('resize', function () {\n" +
                        "                chart.resize();\n" +
                        "            });\n" +
                        "\n" +
                        "        </script>");
            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Grid3D: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Grid3D: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Grid3D: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Grid3D: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Grid3D: {0}", e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }

    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }
}
