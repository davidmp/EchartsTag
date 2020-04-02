
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
public class Bar3DTag extends BodyTagSupport{
    @Getter @Setter
    private transient Object[] dataNameEjeX;
    @Getter @Setter   
    private transient Object[] dataNameEjeY;
    @Getter @Setter
    private transient JSONArray dataValues;
    @Getter @Setter
    private transient Object[] echart3DColor;
    @Getter @Setter
    private transient Object[][] typeAndIntervalEjesXYZ;
    @Getter @Setter
    private transient Object[] dimen3DXY;
    @Getter @Setter
    double lightIntensity;//0.8
    @Getter @Setter
    String seriesTypeEchart;  /*bar3D,line3D,surface,scatter3D*/
    @Getter @Setter
    double[] styleNormalEmphasis;/*0.4, 0.4*/
    @Getter @Setter
    String idCharts;    
    @Getter @Setter
    String height;    
    @Getter @Setter
    String width;    
    
    protected static final Logger logger = Logger.getLogger(Bar3DTag.class.getName());

    private transient PageContext pageContextR;
    

    public Bar3DTag() {    
    }
    public Bar3DTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        JSONArray typeEjesXYZ=new JSONArray(typeAndIntervalEjesXYZ);
        dimen3DXY=dimen3DXY==null? new Object[]{200,80}:dimen3DXY;
        JSONArray dimen3DXYt=new JSONArray(dimen3DXY);
        styleNormalEmphasis=styleNormalEmphasis==null? new double[]{1,1}:styleNormalEmphasis;
        JSONArray styleNormalEmphasist=new JSONArray(styleNormalEmphasis);
        JSONArray echart3DColort=new JSONArray(echart3DColor);
        JSONArray dataNameEjeXt=new JSONArray(dataNameEjeX);
        JSONArray dataNameEjeYt=new JSONArray(dataNameEjeY);     
        height=height==null || height.equals("")? "400px":height;
        width=width==null || width.equals("")? "600px":width;
        seriesTypeEchart=seriesTypeEchart==null || seriesTypeEchart.equals("")? "bar3D":seriesTypeEchart;
        
        try {
            StringBuilder chartImage = new StringBuilder();
            chartImage.append("      <div id=\"" + idCharts + "\"  class=\"main3d\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 10px; \"></div> \n" +
                            "        <script>\n" +
                            "          var chart = echarts.init(document.getElementById('" + idCharts + "'));\n" +
                            "          var data=" + dataValues + ";\n" +
                            "          var typeEjesXYZ="+typeEjesXYZ+";\n" +
                            "          var dimen3DXY="+dimen3DXYt+";\n" +
                            "          var styleNormalEmphasis="+styleNormalEmphasist+";\n" +
                            "            chart.setOption({\n" +
                            "                backgroundColor: '#fff',\n" +
                            "                tooltip: {},          \n" +
                            "                visualMap: {max: 20, color: "+echart3DColort+"},\n" +
                            "                xAxis3D: { type: typeEjesXYZ[0][0],data: "+dataNameEjeXt+", axisLabel: {interval: typeEjesXYZ[1][0]}, axisPointer: {lineStyle: {color: '#900'}}},\n" +
                            "                yAxis3D: {type: typeEjesXYZ[0][1], data: "+dataNameEjeYt+", axisLabel: {interval: typeEjesXYZ[1][1]}, axisPointer: { lineStyle: { color: '#090' } } },\n" +
                            "                zAxis3D: { type: typeEjesXYZ[0][2], axisPointer: { lineStyle: { color: '#009' } } },\n" +
                            "                grid3D: {\n" +
                            "                    boxWidth: dimen3DXY[0],\n" +
                            "                    boxDepth: dimen3DXY[1],                   \n" +
                            "                    viewControl: {/* projection: 'orthographic'*/},\n" +
                            "                    light: { main: {shadow: true}, ambient: {intensity: "+lightIntensity+"/*0.8*/ } }\n" +
                            "                },\n" +
                            "                toolbox: { show : true,feature : { mark : {show: true}, dataView : {show: true, readOnly: false}, saveAsImage : {show: true} } },					                \n" +
                            "                series: [{\n" +
                            "                    type: '"+seriesTypeEchart+"',\n" +
                            "                    data: data.map(function (item) { return {value: [item[0], item[1], item[2]], label: { show: item[2] != 0 } } }),\n" +
                            "                    shading: 'lambert',                   \n" +
                            "                    itemStyle: {normal: { opacity: styleNormalEmphasis[0]/*0.2*/}, emphasis: {color: '#900',opacity: styleNormalEmphasis[1]/*0.4*/} }\n" +
                            "                }]\n" +
                            "            });\n" +
                            "\n" +
                            "            window.addEventListener('resize', function () { chart.resize(); });\n" +
                            "        </script>");
            pageContextR.getOut().append(chartImage); 
        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Bar3D: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Bar3D: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Bar3D: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Bar3D: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Bar3D: {0}", e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }  
    
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }     
}
