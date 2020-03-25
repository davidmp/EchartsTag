/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts;



import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.Test;


/**
 *
 * @author davidmp
 */
public class ReadPropertiesTest extends TestCase{

    protected static final Logger logger = Logger.getLogger(ReadPropertiesTest.class.getName());
    ReadProperties instance = null; 
    
    public ReadPropertiesTest() {        
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
	instance=new ReadProperties("syscenterlife.properties");
    }    
    
    
    @Test
    public void testGetPathFileDefault() {
        System.out.println("getPathFileDefault");        
        String expResult = "default";
        String  result = instance.getPathFileDefault().getProperty("echarts.theme.name");
        logger.log(Level.INFO, "DMPttt:{0}", result);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPathFileCustom() {
        System.out.println("getPathFileDefault");
        instance=new ReadProperties("syscenterlife.properties");
        String expResult = "es";
        String  result = instance.getPathFileCustom().getProperty("echarts.lang.name");
        assertEquals(expResult, result);
    }
    
}
