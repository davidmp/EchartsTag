/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts.threed;

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
import pe.com.syscenterlife.echarts.twod.pie.PieTag;
import pe.com.syscenterlife.echarts.twod.pie.PieTagTest;

/**
 *
 * @author davidmp
 */
public class Grid3DTagTest  extends TestCase{
    
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(Grid3DTagTest.class.getName());
    Grid3DTag instance;    
    public Grid3DTagTest() {
         instance = new Grid3DTag(pageContext);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new Grid3DTag(pageContext);
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
    Object[][] data={{0,0,5},{0,1,1},{0,2,0},{0,3,0},{0,4,0},{0,5,0},{0,6,0},{0,7,0},{0,8,0},{0,9,0},{0,10,0},{0,11,2},{0,12,4},{1,0,7},{1,1,0},{1,2,0},{1,3,0},{1,4,0},{1,5,0},{1,6,0},{1,7,0},{1,8,0},{1,9,0},{1,10,5},{1,11,2},{1,12,2},{2,0,1},{2,1,1},{2,2,0},{2,3,0},{2,4,0},{2,5,0},{2,6,0},{2,7,0},{2,8,0},{2,9,0},{2,10,3},{2,11,2},{2,12,1},{3,0,7},{3,1,3},{3,2,0},{3,3,0},{3,4,0},{3,5,0},{3,6,0},{3,7,0},{3,8,1},{3,9,0},{3,10,5},{3,11,4},{3,12,7}};
    String idCharts="main";    
    Object[] dataTagX={"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    Object[] dataTagY={"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    int[] z3DMinMax={0,60};
    String seriesTypeEchart="scatter3D";  /*bar3D,line3D,surface,scatter3D*/
            
    JSONArray dataValues= new JSONArray(data);
    instance.setIdCharts(idCharts);
    instance.setDataValues(dataValues);
    instance.setDataTagX(dataTagX);
    instance.setDataTagY(dataTagY);
    instance.setZ3DMinMax(z3DMinMax);
    instance.setSeriesTypeEchart(seriesTypeEchart);
    instance.setHeight("400px");
    instance.setWidth("600px");
    instance.setColor("red");
    
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
