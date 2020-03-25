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
public class RadarTagTest  extends TestCase {
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(RadarTagTest.class.getName());
    RadarTag instance;    
    public RadarTagTest() {
         instance = new RadarTag(pageContext);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new RadarTag(pageContext);
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
                        {0,10000,28000,35000,50000,19000},
                        {50,14000,28000,31000,"-",21000},
                        {"-",8000,20000,20000,40000,10000}
                    };
            Object[][] dataValuesXY={
                        {0,10000,28000,35000,50000},
                        {50,14000,28000,31000,"-"},
                        {"-",8000,20000,20000,40000}
                    };
            
            Object[][] indicadorData={
            {"sales","Administration","Information Techology","Customer Support","Development","Marketing"},
            {100,16000,30000,38000,52000,25000}
            };
            Object[][] indicadorDataY={
            {"sales","Administration","Information Techology","Customer Support","Development"},
            {100,16000,30000,38000,52000}
            };
            
            String[] legendDataName=new String[dataValuesX.length];
            legendDataName[0]="Asignación de presupuesto";
            legendDataName[1]="El gasto real contiene datos";
            legendDataName[2]="El primer elemento es nulo";
            
            JSONArray dataValues=new JSONArray(dataValuesX);            
            JSONArray dataValuesY=new JSONArray(dataValuesXY);            
            String seriesName="Presupuesto vs gasto x";
            
            double areaStyleOpacy=0.1;/*0-1*/
            String lineStyleType="dotted";/*'solid','dashed','dotted'*/    
        instance.setIdCharts("main");
        instance.setIndicadorData(indicadorData);
        instance.setLegendDataName(legendDataName);
        instance.setDataValues(dataValues);
        instance.setAreaStyleOpacy(areaStyleOpacy);
        instance.setSeriesName(seriesName);
        instance.setLineStyleType(lineStyleType);
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
