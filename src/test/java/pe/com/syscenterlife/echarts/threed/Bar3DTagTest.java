/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts.threed;

import java.util.ArrayList;
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
public class Bar3DTagTest extends TestCase {
    
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(Bar3DTagTest.class.getName());
    Bar3DTag instance;    
    public Bar3DTagTest() {
         instance = new Bar3DTag(pageContext);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new Bar3DTag(pageContext);
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
            Object[] dataNameEjeX = {"12a", "1a", "2a", "3a", "4a", "5a", "6a","7a", "8a", "9a","10a","11a","12p", "1p", "2p", "3p", "4p", "5p","6p", "7p", "8p", "9p", "10p", "11p"};
            Object[] dataNameEjeY = {"Domingo", "Lunes", "Martes","Miercoles", "Jueves", "viernes","Sabado"};
            JSONArray dataValues;
            Object[] echart3DColor={"#d94e5d","#eac736","#50a3ba"};
            Object[][] typeAndIntervalEjesXYZ={{"category","category","value"},                 
                                    {1,0,0}};
            Object[] dimen3DXY={200,80};
            String idCharts="main";
            
            double lightIntensity=0;//0.8
            String seriesTypeEchart="bar3D";  /*bar3D,line3D,surface,scatter3D*/                    
            double[] styleNormalEmphasis={1,1};/*0.4, 0.4*/
            
            ArrayList<Object> arrayListG = new ArrayList<>();
                 

            dataValues = new JSONArray(arrayListG);
           // out.print(dataValuesEjeBase); 
           
           instance.setDataNameEjeX(dataNameEjeX);
           instance.setDataNameEjeY(dataNameEjeY);
           instance.setDataValues(dataValues);
           instance.setEchart3DColor(echart3DColor);
           instance.setTypeAndIntervalEjesXYZ(typeAndIntervalEjesXYZ);
           instance.setDimen3DXY(dimen3DXY);
           instance.setLightIntensity(lightIntensity);
           instance.setSeriesTypeEchart(seriesTypeEchart);
           instance.setStyleNormalEmphasis(styleNormalEmphasis);
           instance.setIdCharts(idCharts);
           instance.setHeight("200px");
           instance.setWidth("200px");
           
        
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
