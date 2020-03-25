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
import org.mockito.Mockito;

/**
 *
 * @author davidmp
 */
public class Bar3DSimpleTagTest extends TestCase {
    
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(Bar3DSimpleTagTest.class.getName());
    Bar3DSimpleTag instance;    
    public Bar3DSimpleTagTest() {
         instance = new Bar3DSimpleTag(pageContext);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new Bar3DSimpleTag(pageContext);
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
        Object[][] data={{0,0,4},
        {0,1,3.57118459347656},
        {0,2,3.19292786},
        {0,3,2.90797322102855},
        {0,4,2.738862329683},
        {0,5,2.6820298414491},
        {0,6,2.72005047139306},
        {0,7,2.8331537018696},
        {0,8,3.00351308153476},
        {0,9,3.21589522954066},
        {0,10,3.45806390397772},
        {0,11,3.72224661257355},
        {0,12,4.0069734576422},
        {0,13,4.31669934626249},
        {0,14,4.65482136064823},
        {0,15,5.00560514550999},
        {0,16,5.32879796874588},
        {0,17,5.57711170105271},
        {0,18,5.70632100419466},
        {0,19,5.69155835323897},
        {0,20,5.53462530642411},
        {0,21,5.26350238197492},
        {0,22,4.934131695817},
        {0,23,4.62158567726095},
        {0,24,4.39436833597234},
        {0,25,4.29587363543124},
        {0,26,4.33472644786223},
        {0,27,4.48301883983358},
        {0,28,4.68282700711285},
        {0,29,4.86286884215472},
        {0,30,4.96731276808481},
        {0,31,4.96353228327126},
        {0,32,4.82121911138732},
        {0,33,4.53125717736886},
        {0,34,4.11709429838556},
        {0,35,3.63081356130541},
        {0,36,3.14005518868041},
        {0,37,2.71145076904924},
        {0,38,2.39580783112686},
        {0,39,2.21995807022463},
        {0,40,2.18980968832455},
        {0,41,2.29991504245282},
        {0,42,2.53160462474591},
        {0,43,2.85433200756905}};
            String idCharts="main";                       
            int[] visualMapMinMax={2,6};
            int[] z3DMinMax={0,10};
            int[] grid3DboxWidthDepth={200,80};
            boolean viewControlAutoRotate=false;
            double lightIntensity=0.2;
            String seriesTypeEchart="scatter3D";  /*bar3D,line3D,surface,scatter3D*/
            JSONArray dataValues= new JSONArray(data);                   
            double[] styleNormalEmphasis={1,1};/*0.4, 0.4*/        
        instance.setIdCharts(idCharts);
        instance.setVisualMapMinMax(visualMapMinMax);
        instance.setZ3DMinMax(z3DMinMax);
        instance.setGrid3DboxWidthDepth(grid3DboxWidthDepth);
        instance.setViewControlAutoRotate(viewControlAutoRotate);
        instance.setLightIntensity(lightIntensity);
        instance.setSeriesTypeEchart(seriesTypeEchart);
        instance.setDataValues(dataValues);
        instance.setStyleNormalEmphasis(styleNormalEmphasis);
        instance.setHeight(idCharts);
        instance.setHeight(idCharts);

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
