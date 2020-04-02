
package pe.com.syscenterlife.echarts.twod.pie;

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
public class PieTag extends BodyTagSupport {
    protected static final Logger logger = Logger.getLogger(PieTag.class.getName());
    @Getter @Setter
    String idCharts; 
    @Getter @Setter
    private transient Object[][] dataValues;
    @Getter @Setter
    String chartTitle;
    @Getter @Setter
    String[] serieRadiusMinMax={"0%", "60%"};
    @Getter @Setter
    String[] serieCenterXY={"50%", "50%"};
    @Getter @Setter
    boolean roseType=false;
    @Getter @Setter
    String roseTypeValue="radius";/*radius, area*/
    @Getter @Setter
    public String height = "460px";
    @Getter @Setter
    public String width = "760px";
    

    
    private transient PageContext pageContextR;

    public PieTag() {
    }
    public PieTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        String theme;
        theme=(String)((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme");
        JSONArray serieRadiusMinMaxX=new JSONArray(serieRadiusMinMax);
        JSONArray serieCenterXYX=new JSONArray(serieCenterXY);
        try {       
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
            "    <div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
            "    <script>\n" +
            "    var mainEl = document.getElementById('" + idCharts + "');\n" +
            "    var chart = echarts.init(mainEl,'"+theme+"');\n" +
            "    var serieRadiusMinMaxX=" + serieRadiusMinMaxX + ";\n" +
            "    var serieCenterXYX=" + serieCenterXYX + ";\n" +
            "    /* var colorList = ['#c23531', '#2f4554', '#61a0a8','#d48265', '#91c7ae','#749f83','#ca8622', '#bda29a','#6e7074','#546570', '#c4ccd3'];*/       \n" +
            "    var data = [\n");
            
            for (int i = 0; i < dataValues.length; i++) {
            
            chartImage.append(""+         
            "        {value: " + dataValues[i][0] + ", name: '" + dataValues[i][1] + "'},            \n");
            
            }
            
            chartImage.append(""+ 
            "    ];\n" +
            "    var legendData = [];\n" +
            "    echarts.util.each(data, function (item, index) {\n" +
            "        /*item.itemStyle = {normal: {color: colorList[index]}};*/\n" +
            "        legendData.push(item.name);    }    );    \n" +
            "    chart.setOption({\n" +
            "        title : {\n" +
            "            text: '"+chartTitle+"',\n" +
            "            x:'center',\n" +
            "            y:'top'\n" +
            "        },                    \n" +
            "        legend: {\n" +
            "            right: 'center',\n" +
            "            bottom: 0,\n" +
            "            orient: 'horizontal',                        \n" +
            "            data: legendData,\n" +
            "            formatter: function (name) {\n" +
            "                return name.replace(/\\n/g, ' + ');}\n" +
            "        },\n" +
            "        toolbox: {\n" +
            "            orient: 'vertical',left: 'right',top: 'center',\n" +
            "            feature: {dataView: {},saveAsImage: {},restore: {}}},\n" +
            "        tooltip: {},\n" +
            "        series: [{\n" +
            "            name: '"+chartTitle+"',\n" +
            "            type: 'pie',\n" +
            "            radius: [serieRadiusMinMaxX[0], serieRadiusMinMaxX[1]],/*20*/\n" +
            "            center: [serieCenterXYX[0], serieCenterXYX[1]],\n");            
            if(roseType){
            chartImage.append(""+
            "            roseType: '"+roseTypeValue+"',  /*radius, area*/                      \n");
            }
            chartImage.append(""+        
            "            selectedMode: 'single',\n" +
            "            selectedOffset: 30,\n" +
            "            clockwise: true,\n" +
            "            itemStyle: {emphasis: {shadowBlur: 10,shadowOffsetX: 0,shadowColor: 'rgba(0, 0, 0, 0.5)'}},\n" +
            "            labelLine: {normal: {lineStyle: {color: '#333'}}},\n" +
            "            data: data\n" +
            "        }]}\n" +
            "    );\n" +
            "    var dragging;\n" +
            "    var draggingDataIndex;\n" +
            "    var dx;\n" +
            "    var dy;\n" +
            "    var zr = chart.getZr();\n" +
            "    chart.on('mousedown', function (params) {\n" +
            "        draggingDataIndex = getHoveredDataIndex(params);\n" +
            "        if (draggingDataIndex != null) {\n" +
            "            var srcSector = params.event.target;\n" +
            "            dragging = new echarts.graphic.Sector({\n" +
            "                shape: echarts.util.extend({}, srcSector.shape),\n" +
            "                style: {\n" +
            "                    fill: srcSector.style.fill,\n" +
            "                    opacity: 0.5\n" +
            "                },\n" +
            "                silent: true,\n" +
            "                z: 10000\n" +
            "            });\n" +
            "            dx = params.event.offsetX - srcSector.shape.cx;\n" +
            "            dy = params.event.offsetY - srcSector.shape.cy;\n" +
            "            zr.add(dragging);\n" +
            "        }});\n" +
            "    chart.on('mouseup', function (params) { if (dragging) {\n" +
            "            var targetDataIndex = getHoveredDataIndex(params);\n" +
            "            if (targetDataIndex != null\n" +
            "                && targetDataIndex !== draggingDataIndex\n" +
            "            ) {\n" +
            "                data[targetDataIndex].value += data[draggingDataIndex].value;\n" +
            "                data[targetDataIndex].name += '\\n' + data[draggingDataIndex].name;\n" +
            "                legendData[targetDataIndex] = data[targetDataIndex].name;\n" +
            "                data.splice(draggingDataIndex, 1);\n" +
            "                legendData.splice(draggingDataIndex, 1);\n" +
            "                chart.setOption({\n" +
            "                    legend: {data: legendData},\n" +
            "                    series: {data: data}\n" +
            "                });\n" +
            "            }\n" +
            "        }  });\n" +
            "    mainEl.addEventListener('mousemove', function (e) {\n" +
            "        var box = mainEl.getBoundingClientRect();\n" +
            "        var zrX = e.clientX - box.left;\n" +
            "        var zrY = e.clientY - box.top;  if (dragging) {\n" +
            "            dragging.setShape({\n" +
            "                cx: zrX - dx,\n" +
            "                cy: zrY - dy\n" +
            "            });\n" +
            "        }     }\n" +
            "    );\n" +
            "    document.addEventListener('mouseup', function (e) {\n" +
            "        if (dragging) {\n" +
            "            zr.remove(dragging);\n" +
            "            dragging = null;\n" +
            "        }\n" +
            "    });\n" +
            "    function getHoveredDataIndex(params) {\n" +
            "        return params.componentType === 'series'\n" +
            "            && params.componentSubType === 'pie'\n" +
            "            && params.dataIndex;\n" +
            "    }\n" +
            "    </script>");

            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.log(Level.INFO, "Error en generar grafico Pie: {0}", e.getMessage());        
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.INFO, "Error al ingresar datos de entrada en tipos arrays en los Taglibs Pie: {0}", e.getMessage());        
        }catch(NumberFormatException e){
            logger.log(Level.INFO, "Error al ingresar datos en uno de los attributos cuando se desea que sea numerico Pie: {0}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.log(Level.INFO, "Error al ingresar datos para generar grafico Echarts con Taglib Pie: {0}", e.getMessage());
        }catch (RuntimeException e){
            logger.log(Level.INFO, "Error en tiempo de ejecuci\u00f3n al usar Taglibs Pie: {0}", e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }   

    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }       
}
