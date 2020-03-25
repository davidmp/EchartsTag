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
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;


/**
 *
 * @author davidmp
 */
public class RadarMultiTagTest  extends TestCase {
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(RadarMultiTagTest.class.getName());
    RadarMultiTag instance;    
    public RadarMultiTagTest() {
         instance = new RadarMultiTag(pageContext);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new RadarMultiTag(pageContext);
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
    Object[][] dataValues1={{60,73,85,40}};
    Object[][] dataValues2={{85,90,90,95,95},{95,80,95,90,93}};
    Object[][] dataValues3={
        {2.6,5.9,9,26.4,28.7,70.7,75.6,82.2,48.7,18.8,6,2.3},
        {2,4.9,7,23.2,25.6,76.7,35.6,62.2,32.6,20,6.4,3.3}};

    Object[] dataValuesM={dataValues1,dataValues2,dataValues3};/*SI*/

    Object[][] indicadorPositionWH=new Object[2][dataValuesM.length]; /*SI*/
    indicadorPositionWH[0][0]="25%"; indicadorPositionWH[1][0]=200;
    indicadorPositionWH[0][1]="50%"; indicadorPositionWH[1][1]=300;
    indicadorPositionWH[0][2]="75%"; indicadorPositionWH[1][2]=200;

    double[] areaStyleOpacy= new double[dataValuesM.length]; /*SI*/
    areaStyleOpacy[0]=0.8;
    areaStyleOpacy[1]=0;
    areaStyleOpacy[2]=0.8;



    Object[][] indicadorData1={
    {"Brand","Content","Availability","function"},
    {100,100,100,100}
    };
    Object[][] indicadorData2={
    {"Appearance","take a picture","System","performance","screen"},
    {100,100,100,100,100}
    };
    Object[][] indicadorData3=new Object[2][dataValues3[0].length];
    for (int i = 0; i < 12; i++) {
        indicadorData3[0][i]=(i+1)+"month";
        indicadorData3[1][i]=100;
    }
    Object[] indicadorDataM={indicadorData1,indicadorData2,indicadorData3}; /*SI*/

    String[] legendDataName=new String[dataValues1.length+dataValues2.length+dataValues3.length]; /*SI*/
    legendDataName[0]="Some software";
    legendDataName[1]="A staple food phone";
    legendDataName[2]="A fruit phone";
    legendDataName[3]="Precipitation";
    legendDataName[4]="Evaporation";

    String chartTitle="Grafico de radar multiple";        
    instance.setIdCharts("main");
    instance.setDataValuesM(dataValuesM);
    instance.setIndicadorDataM(indicadorDataM);
    instance.setIndicadorPositionWH(indicadorPositionWH);
    instance.setAreaStyleOpacy(areaStyleOpacy);
    instance.setIndicadorDataM(indicadorDataM);
    instance.setLegendDataName(legendDataName);
    instance.setChartTitle(chartTitle);
    instance.setHeight("530px");
    instance.setWidth("900px");
    
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
