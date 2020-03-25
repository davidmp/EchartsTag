/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts.twod.bar;

import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import pe.com.syscenterlife.echarts.util.EchartsUtilTag;

/**
 *
 * @author davidmp
 */
public class BarTagTest extends TestCase{
    
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(BarTagTest.class.getName());
    BarTag instance;    
    public BarTagTest() {
         instance = new BarTag(pageContext);
    }
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new BarTag(pageContext);
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
        
        Object[] dataValuesEjeBasex = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio"};
        JSONArray dataValuesEjeBase = new JSONArray(dataValuesEjeBasex);//mandar dataValuesEjeBase

        Object[][] dataValues = {
            {300, -270, 340, 344, 300, 320, 10},
            {120, 102, 141, 174, 190, 250, 220},
            {-20.25, -32, -21, -34, -90, -130, -110},
            {-15, -32, -40, -34, -90, -130, -200},
            {100, 102, 141, 20, 190, 250, 220}
        };

        LinkedHashMap<String, Object> hmx = new LinkedHashMap<>();
        hmx.put("cchar", dataValues[0]);
        hmx.put("php", dataValues[1]);
        hmx.put("java", dataValues[2]);
        hmx.put("python", dataValues[3]);
        hmx.put("r", dataValues[4]);
        JSONObject obj = new JSONObject(hmx); //Mandar   obj
        String[] elementNames = JSONObject.getNames(obj);

        Object[][] dataCategPropied = {{"cchar", "php", "java", "python", "r"},
        {"C##", "PHP", "Java", "Python", "R"},
        {"", "", "", "", ""},
        {"inside", "inside", "left", "inside", "inside"}};

        EchartsUtilTag objxs = new EchartsUtilTag();
        dataCategPropied = objxs.verifPositionData(elementNames, dataCategPropied);

        LinkedHashMap<String, Object> element = new LinkedHashMap<>();
        element.put("id", new JSONArray(dataCategPropied[0]));
        element.put("Categoria", new JSONArray(dataCategPropied[1]));
        element.put("stack", new JSONArray(dataCategPropied[2]));
        element.put("position", new JSONArray(dataCategPropied[3])); //Mandar element         
        
        instance.setIdCharts("mainx");
        instance.setDataLabel(element);
        instance.setDataValuesEjeBase(dataValuesEjeBase);
        instance.setDataValues(obj);
        instance.setClassCharts("mainx");
        instance.setOrientationChart("horizontal");
        instance.setHeight("400px");
        instance.setWidth("400px");        
        

        System.out.println("DMP:"+instance.doEndTag());
        int result= instance.doEndTag();
        assertEquals(0, result);        

    }

    @Test
    public void testDoStartTag() throws JspException {
        int result= instance.doStartTag();
        logger.log(Level.INFO, "DMPttt:{0}", result);
        System.out.println("DMP:"+instance.doStartTag());
        assertEquals(0, result); 

    }   
    
}
