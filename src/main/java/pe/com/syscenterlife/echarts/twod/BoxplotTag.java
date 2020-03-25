
package pe.com.syscenterlife.echarts.twod;

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
public class BoxplotTag extends BodyTagSupport {
    protected static final Logger logger = Logger.getLogger(BoxplotTag.class.getName());
    
    @Getter @Setter
    private transient Object[] dataValues;
    @Getter @Setter
    String idCharts; 
    @Getter @Setter
    String categoryName="Datos"; 
    @Getter @Setter
    String chartTitle="Grafico de Resultados"; 
    @Getter @Setter
    String boxPlotOrient="horizontal"; /*vertical,horizontal*/ 
    @Getter @Setter
    private transient JSONArray legendName;
    @Getter @Setter
    public String height = "460px";
    @Getter @Setter
    public String width = "700px";    
    
    
    
    boolean scriptDependency=false;
    private transient PageContext pageContextR;

    public BoxplotTag() {
    
    }
    public BoxplotTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }

    @Override
    public int doEndTag() throws JspException {
        String theme;
        theme=(String)((HttpServletRequest)pageContextR.getRequest()).getSession().getAttribute("echartstheme");
        
        JSONArray dataM=new JSONArray(dataValues);

        try {
            StringBuilder chartImage = new StringBuilder();
            chartImage.append(""+
                        "<div id=\"" + idCharts + "\" style=\"height: " + height + "; width: " + width + "; border: 1px solid #ccc; padding: 8px;\"></div>\n" +
                        "<script>          \n" +
                        "var chart = echarts.init(document.getElementById('" + idCharts + "'),'"+theme+"', { });\n" +
                        "function update(layout) {\n" +
                        "    var data = [];\n" +
                        "    var dataM= [];\n" +
                        "    var legendName= [];\n" +
                        "    legendName=" + legendName + ";\n" +
                        "    dataM =" + dataM + ";\n" +
                        "    for (var i = 0; i < dataM.length; i++) {\n" +
                        "        data.push(echarts.dataTool.prepareBoxplotData(dataM[i], {\n" +
                        "            layout: layout\n" +
                        "        }));        \n" +
                        "    }    \n" +
                        "   /* var data = echarts.dataTool.prepareBoxplotData( seriesData , {layout: layout});*/\n" +
                        "    var categoryAxis = {\n" +
                        "        type: 'category',\n" +
                        "        data: data[0].axisData,\n" +
                        "        boundaryGap: true,\n" +
                        "        nameGap: 30,\n" +
                        "        splitArea: {\n" +
                        "            show: true },\n" +
                        "        axisLabel: {\n" +
                        "            formatter: '" + categoryName + " {value}' },\n" +
                        "        splitLine: {\n" +
                        "            show: false\n" +
                        "        }\n" +
                        "    };\n" +
                        "    var valueAxis = {\n" +
                        "        type: 'value',\n" +
                        "        name: 'Value',\n" +
                        "        splitArea: {\n" +
                        "            show: false\n" +
                        "        }\n" +
                        "    };\n" +
                        "    chart.setOption({\n" +
                        "        title: [\n" +
                        "            {\n" +
                        "                text: '" + chartTitle + "',\n" +
                        "                left: 'center'\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        legend: {\n" +
                        "            top: '10%',\n" +
                        "            data: legendName }, \n" +
                        "        tooltip: {\n" +
                        "            trigger: 'axis',/*item,axis*/\n" +
                        "            axisPointer: {\n" +
                        "                type: 'shadow'\n" +
                        "            } },\n" +
                        "        grid: {\n" +
                        "            left: '10%',\n" +
                        "            top: '20%',\n" +
                        "            right: '10%',\n" +
                        "            bottom: '15%'\n" +
                        "        },\n" +
                        "        xAxis: layout === 'horizontal' ? categoryAxis : valueAxis,\n" +
                        "        yAxis: layout === 'vertical' ? categoryAxis : valueAxis,\n" +
                        "        dataZoom: [\n" +
                        "            {\n" +
                        "                type: 'inside',\n" +
                        "                start: 0,\n" +
                        "                end: 20\n" +
                        "            },{\n" +
                        "                show: true,\n" +
                        "                height: 20,\n" +
                        "                type: 'slider',\n" +
                        "                bottom: 50,\n" +
                        "                /*xAxisIndex: layout === 'horizontal' ? [0] : [],*/\n" +
                        "                /*yAxisIndex: layout === 'vertical' ? [] : [0],*/\n" +
                        "                start: 0,\n" +
                        "                end: 20\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        toolbox: {feature: {dataView: {},saveAsImage: {},restore: {}}},						\n" +
                        "        series: [\n");
            
                        for(int i = 0; i <dataValues.length; i++) {
                        chartImage.append(" "+
                        "               {\n" +
                        "                    name: legendName[" + i + "],\n" +
                        "                    type: 'boxplot',                \n" +
                        "                    data: data[" + i + "].boxData\n" +
                        "                },\n" +
                        "                {name: 'Outliers '+legendName[" + i + "],\n" +
                        "                type: 'scatter',\n" +
                        "                data: data[" + i + "].outliers},\n");
                        }
                        chartImage.append(" "+
                        "       ]\n" +
                        "    });}\n" +
                        "update('" + boxPlotOrient + "');/*vertical,horizontal*/\n" +
                        "</script>");

            pageContextR.getOut().append(chartImage); 

        } catch (IOException e) {
            logger.info("Error en generar grafico BoxplotTag: "+e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }  
    
    @Override
    public int doStartTag() throws JspException {        
        pageContextR=this.pageContext;        
        return SKIP_BODY; //PUEDE SER 0
    }     
}
