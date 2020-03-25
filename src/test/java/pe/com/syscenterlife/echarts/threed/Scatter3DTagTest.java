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


/**
 *
 * @author davidmp
 */
public class Scatter3DTagTest extends TestCase {
    
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(Scatter3DTagTest.class.getName());
    Scatter3DTag instance;    
    public Scatter3DTagTest() {
         instance = new Scatter3DTag(pageContext);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new Scatter3DTag(pageContext);
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
        
            Object[][] data={{0,0,0,4},
                {0,0,1,3.592148919875},
                {0,0,2,3.22448878222222},
                {0,0,3,2.9302638975},
                {0,0,4,2.71957367308642},
                {0,0,5,2.58100150462963},
                {0,0,6,2.49552672},
                {0,0,7,2.44485331475308},
                {0,0,8,2.41487397925926},
                {0,0,9,2.396393995},
                {0,0,10,2.38506172839506},
                {0,0,11,2.38158897609722},
                {0,0,12,2.392544384},
                {0,0,13,2.43097804474228},
                {0,0,14,2.51532580503703},
                {0,0,15,2.66445703125},
                {0,0,16,2.88771569988477},
                {0,0,17,3.17665011680144},
                {0,0,18,3.51140804266666},
                {0,0,19,3.86705150903137},
                {0,0,20,4.21575637860082},
                {0,0,21,4.53025310179166},
                {0,0,22,4.7869869935144},
                {0,0,23,4.96407019185082},
                {0,0,24,5.04477862399999},
                {0,0,25,5.0259490628215},
                {0,0,26,4.91983828990946},
                {0,0,27,4.75111999929166},
                {0,0,28,4.5503944443786},
                {0,0,29,4.34645502703755},
                {0,0,30,4.15473333333333},
                {0,0,31,3.98650942294547},
                {0,0,32,3.82529690495473},
                {0,0,33,3.67079788575},
                {0,0,34,3.51992773715226},
                {0,0,35,3.36809258937757},
                {0,0,36,3.21014203733333},
                {0,0,37,3.04143044062294},
                {0,0,38,2.85964473863374},
                {0,0,39,2.66806725904166},
                {0,0,40,2.47980082304526},
                {0,1,0,4},
                {0,1,1,3.59893215799999},
                {0,1,2,3.23754984374999},
                {0,1,3,2.94990555555555},
                {0,1,4,2.7499180478395},
                {0,1,5,2.62605704},
                {0,1,6,2.55676822018518},
                {0,1,7,2.52063848765432},
                {0,1,8,2.500676171875},
                {0,1,9,2.4856549305679},
                {0,1,10,2.47010246118672},
                {0,1,11,2.45430298},
                {0,1,12,2.44489401523919}
                };
        String idCharts="main"; 
        int[] grid3DBoxXYZ={100,100,100};
        String seriesTypeEchart="scatter3D";  /*line3D,surface,scatter3D*/
        JSONArray dataValues=new JSONArray(data);       
        
    instance.setIdCharts(idCharts);
    instance.setGrid3DBoxXYZ(grid3DBoxXYZ);
    instance.setSeriesTypeEchart(seriesTypeEchart);
    instance.setDataValues(dataValues);
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
