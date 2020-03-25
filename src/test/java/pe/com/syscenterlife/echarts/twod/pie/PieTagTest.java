/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts.twod.pie;

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
public class PieTagTest extends TestCase {
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(PieTagTest.class.getName());
    PieTag instance;    
    public PieTagTest() {
         instance = new PieTag(pageContext);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new PieTag(pageContext);
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
            {335,"Direct access"},
            {310,"Email Marketing"},
            {234,"Affiliate Advertising"},
            {135,"Video ad"},
            {1548,"Search engine"},
            };

    String chartTitle="Un usuario del sitio visita la fuente";
    String[] serieRadiusMinMax={"20%", "70%"};
    String[] serieCenterXY={"50%", "50%"};
    boolean roseType=false;

    String roseTypeValue="radius";/*radius, area*/      
        
    instance.setIdCharts("main");
    instance.setDataValues(dataValuesX);
    instance.setChartTitle(chartTitle);
    instance.setSerieRadiusMinMax(serieRadiusMinMax);
    instance.setSerieCenterXY(serieCenterXY);
    instance.setRoseType(roseType);
    instance.setRoseTypeValue(roseTypeValue);
    instance.setHeight("460px");
    instance.setWidth("760px");
    
    
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
