/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts.twod.funnel;

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
public class FunnelTagTest extends TestCase{
    
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(FunnelTagTest.class.getName());
    FunnelTag instance;    
    public FunnelTagTest() {
         instance = new FunnelTag(pageContext);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new FunnelTag(pageContext);
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
                    {"Access",60,30},
                    {"Consultation",40,10},
                    {"Order",20,5},
                    {"Click",80,50},
                    {"Display",100,80},
                };

        String[] legendDataName=new String[dataValuesX.length];
        for (int i = 0; i < dataValuesX.length; i++) {
                legendDataName[i]=dataValuesX[i][0].toString();
            }

        String chartTitle="Grafico de embudo";
        String[] serieCategoryName={"Esperado", "Real"};
        String[] serieLabelPosition={"outside", "inside"};
        double[] serieItemStyleOpacy={0.7, 0.5};

        String[] serieLabelFormatter={"{b}", "{c}%"};
        String[] serieSort={"ascending", "ascending"};/*ascending,descending*/
        
            
       instance.setIdCharts("main");
       instance.setDataValues(dataValuesX);
       instance.setLegendDataName(legendDataName);
       instance.setChartTitle(chartTitle);
       instance.setSerieCategoryName(serieCategoryName);
       instance.setSerieLabelPosition(serieLabelPosition);
       instance.setSerieItemStyleOpacy(serieItemStyleOpacy);
       instance.setSerieLabelFormatter(serieLabelFormatter);
       instance.setSerieSort(serieSort);
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
