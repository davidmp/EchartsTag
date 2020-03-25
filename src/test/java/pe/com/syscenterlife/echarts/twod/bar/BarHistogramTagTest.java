/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts.twod.bar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;


/**
 *
 * @author davidmp
 */
public class BarHistogramTagTest extends TestCase{
    
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(BarHistogramTagTest.class.getName());
    BarHistogramTag instance;    
    public BarHistogramTagTest() {
         instance = new BarHistogramTag(pageContext);
    }
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new BarHistogramTag(pageContext);
        // set our tag to produce a mock ServletContext
        instance.setPageContext(pageContext);
        Mockito.when(pageContext.getServletContext()).thenReturn(servletContext);
        Mockito.when(pageContext.getRequest()).thenReturn(httpServletRequest);
        Mockito.when(httpServletRequest.getSession()).thenReturn(httpSession);
        // give us a current context path
        Mockito.when(httpServletRequest.getContextPath()).thenReturn(CURRENT_CONTEXT);
        // set our mock JspWriter
        Mockito.when(pageContext.getOut()).thenReturn(jspWriter);
    } 

    @Test
    public void testDoEndTag() throws Exception {
        
        String chartTitle="Soy un histograma";

        double[] dataValues1={1.33,4.94,4.48,2.44,3.37,1.61,2.58,1.99,0.57,4.89};
        double[] dataValues2={-0.08,-0.22,-0.82,-0.51,-0.18,-0.54,-0.62,-0.61,-0.44,-0.58};
        double[] dataValues3={1.12,1.44,1.2,0.53,1.48,0.61,0.68,0.9,0.7,1.34};
        double[] dataValues4={0.45,0.96,0.76,0.6,0.84,0.95,0.47,0.88,0.83,0.98};

        Object[] dataValues={dataValues1,dataValues2,dataValues3,dataValues4};
        String[] legendDataName=new String[dataValues.length];            
        legendDataName[0]="bar";
        legendDataName[1]="bar2"; 
        legendDataName[2]="bar3"; 
        legendDataName[3]="bar4"; 

        String[] ejeDataX={"Categoría0","Categoría1","Categoría2","Categoría3","Categoría4","Categoría5","Categoría6",
                            "Categoría7","Categoría8","Categoría9"};            
        String[] ejeNameXY={"Eje X","Eje Y"};           
        boolean[] seriesMarkPointMinMax ={true,false,false,true};
        boolean[] seriesMarkLineMedia ={true,false,false,true};            
        String[] seriesStackName ={"one","one","two","two"};            
        String echartsOriented="horizontal";/*vertical,horizontal*/
        String x,y;
        if(echartsOriented.equals("horizontal")){
        x="xAxis"; y="yAxis";
        }else{ x="yAxis"; y="xAxis"; }          
        
        instance.setIdCharts("mainx");
        instance.setDataValues(dataValues);
        instance.setChartTitle(chartTitle);
        instance.setLegendDataName(legendDataName);
        instance.setEjeDataX(ejeDataX);
        instance.setEjeNameXY(ejeNameXY);
        instance.setSeriesMarkPointMinMax(seriesMarkPointMinMax);
        instance.setSeriesMarkLineMedia(seriesMarkLineMedia);
        instance.setSeriesStackName(seriesStackName);
        instance.setEchartsOriented(echartsOriented);
        instance.setHeight("500px");
        instance.setWidth("800px");
        
        int result= instance.doEndTag();
        assertEquals(0, result); 
    }

    @Test
    public void testDoStartTag() throws Exception {
        int result= instance.doStartTag();
        logger.log(Level.INFO, "DMPttt:{0}", result);
        System.out.println("DMP:"+instance.doStartTag());
        assertEquals(0, result); 

    }

}
