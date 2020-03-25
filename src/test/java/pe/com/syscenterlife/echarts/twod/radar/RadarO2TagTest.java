/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts.twod.radar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import org.json.JSONArray;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;


/**
 *
 * @author davidmp
 */
public class RadarO2TagTest extends TestCase {
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(RadarO2TagTest.class.getName());
    RadarO2Tag instance;    
    public RadarO2TagTest() {
         instance = new RadarO2Tag(pageContext);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new RadarO2Tag(pageContext);
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
        
            Object[][] dataValuesX={
                        {390,208,15,9,0.5},
                        {380,204,20,18,2},
                        {370,200,25,27,4.5},
                        {360,196,30,36,8},
                        {350,192,35,45,12.5},
                        {340,188,40,54,18},
                        {330,184,45,63,24.5},
                        {320,180,50,72,32},
                        {310,176,55,81,40.5},
                        {300,172,60,90,50},
                        {290,168,65,99,60.5},
                        {280,164,70,108,72},
                        {270,160,75,117,84.5},
                        {260,156,80,126,98},
                        {250,152,85,135,112.5},
                        {240,148,90,144,128},
                        {230,144,95,153,144.5},
                        {220,140,100,162,162},
                        {210,136,105,171,180.5},
                        {200,132,110,180,200},
                        {190,128,115,189,220.5},
                        {180,124,120,198,242},
                        {170,120,125,207,264.5},
                        {160,116,130,216,288},
                        {150,112,135,225,312.5},
                        {140,108,140,234,338},
                        {130,104,145,243,364.5},
                        {120,100,150,252,392}
                    };
            
            Object[][] indicadorData={
                            {"IE8-","IE9+","Safari","Firefox","Chrome"},
                            {400,400,400,400,400,400}
                            };
            
            String[] legendDataName=new String[dataValuesX.length];
            for (int i = 0; i < legendDataName.length; i++) {
                    legendDataName[i]=""+(2001+i);
                }
            String[] visualMapColors={"#3333FF", "yellow"};
            JSONArray dataValues=new JSONArray(dataValuesX);

            String seriesName="Presupuesto vs gasto x";
            String lineStyleType="dotted";/*'solid','dashed','dotted'*/
            String chartTitle="Cambio de uso compartido del navegador";        
        instance.setIdCharts("main");
        instance.setIndicadorData(indicadorData);
        instance.setLegendDataName(legendDataName);
        instance.setVisualMapColors(visualMapColors);
        instance.setDataValues(dataValues);
        instance.setSeriesName(seriesName);
        instance.setLineStyleType(lineStyleType);
        instance.setChartTitle(chartTitle);
        instance.setHeight("400px");
        instance.setWidth("600px");
        
            
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
