/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts.twod.line;

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
public class LineTagTest extends TestCase{
    
    private static final String CURRENT_CONTEXT = "mainx";
    private final PageContext pageContext = Mockito.mock(PageContext.class);
    private final ServletContext servletContext = Mockito.mock(ServletContext.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final JspWriter jspWriter = Mockito.mock(JspWriter.class);   
    private final HttpSession httpSession = Mockito.mock(HttpSession.class);   
    protected static final Logger logger = Logger.getLogger(LineTagTest.class.getName());
    LineTag instance;    
    public LineTagTest() {
         instance = new LineTag(pageContext);
    }
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new LineTag(pageContext);
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
            Object[] dataValues1={120,132,101,134,-90,230,210};
            Object[] dataValues2={220,182,191,234,290,330,310};
            Object[] dataValues3={150,232,201,154,190,330,410};
            Object[] dataValues4={320,332,301,334,390,330,320};
            Object[] dataValues5={820,932,901,934,1290,1330,1320};

            Object[] dataValues={dataValues1,dataValues2,dataValues3,dataValues4,dataValues5};
            String[] legendDataName=new String[dataValues.length];
            legendDataName[0]="Email marketing";
            legendDataName[1]="Publicidad afiliada";
            legendDataName[2]="Publicidad de video";
            legendDataName[3]="Acceso directo";
            legendDataName[4]="Motor de busqueda";
            String[] chartAxisXYCategory={"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};        
            String echartsOriented="vertical";/*vertical,horizontal*/
            boolean[] seriesMarkPointMinMax ={true,false,false,false,true};
            boolean[] seriesMarkLineMedia ={true,false,false,false,true};
 
            String scriptAdd="go = {exchangeXYdmp: function () {var option = myChart.getOption();var temp; temp = option.xAxis;option.xAxis = option.yAxis;option.yAxis = temp; myChart.setOption(option);}};";
        instance.setIdCharts("main");
        instance.setDataValues(dataValues);
        instance.setLegendDataName(legendDataName);
        instance.setChartAxisXYCategory(chartAxisXYCategory);
        instance.setEchartsOriented(echartsOriented);
        instance.setSeriesMarkPointMinMax(seriesMarkPointMinMax);
        instance.setSeriesMarkLineMedia(seriesMarkLineMedia);
        instance.setScriptAdd(scriptAdd);
        instance.setHeight("540px");
        instance.setWidth("800px");
            
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
