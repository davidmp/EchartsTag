/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts.twod;

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
import org.mockito.Mockito;

/**
 *
 * @author davidmp
 */
public class BoxplotTagTest extends TestCase{
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(BoxplotTagTest.class.getName());
    BoxplotTag instance;    
    public BoxplotTagTest() {
         instance = new BoxplotTag(pageContext);
    }
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new BoxplotTag(pageContext);
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
    Object[][] datax={
    {850, 740, 900, 1070, 930, 850, 950, 980, 980, 880, 1000, 980, 930, 650, 760, 810, 1000, 1000, 960, 960},
    {960, 940, 960, 940, 880, 800, 850, 880, 900, 840, 830, 790, 810, 880, 880, 830, 800, 790, 760, 800},
    {800, 600, 600, 600, 400, 400, 200, 200, 200, 200, 600, 200, 100, 100, 100, 100, 100, 100, 50, 1},
    {890, 810, 810, 820, 800, 770, 760, 740, 750, 760, 910, 920, 890, 860, 880, 720, 840, 850, 850, 780},
    {890, 840, 780, 810, 760, 810, 790, 810, 820, 850, 870, 870, 810, 740, 810, 940, 950, 800, 810, 20},
    {850, 740, 900, 1070, 930, 850, 950, 980, 980, 880, 1000, 980, 930, 650, 760, 810, 1000, 1000, 960, 960}                        
    };

    Object[] dataValues={datax,datax};

    String idCharts="main"; 
    String categoryName="Mes"; 
    String chartTitle="Ventas por Meses"; 
    String boxPlotOrient="horizontal"; /*vertical,horizontal*/

    String[] legendNameX=new String[dataValues.length]; 
    for(int i=0; i<legendNameX.length; i++){
       legendNameX[i]="Results "+(i+1)+"";
    }
    JSONArray legendName=new JSONArray(legendNameX);        
    instance.setDataValues(dataValues);
    instance.setIdCharts(idCharts);
    instance.setCategoryName(categoryName);
    instance.setChartTitle(chartTitle);
    instance.setBoxPlotOrient(boxPlotOrient);
    instance.setLegendName(legendName);
    instance.setHeight("460px");
    instance.setWidth("700px");
    
    
    
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
