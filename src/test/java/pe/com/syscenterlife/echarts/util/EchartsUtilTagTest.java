/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.echarts.util;

import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author davidmp
 */
public class EchartsUtilTagTest {
    
    protected static final Logger logger = Logger.getLogger(EchartsUtilTagTest.class.getName());
    
    public EchartsUtilTagTest() {
    }

    EchartsUtilTag instance=new EchartsUtilTag();
    
    @Test
    public void testVerifPositionData() {
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
        
        
        Object[][] result = instance.verifPositionData(elementNames, dataCategPropied);
        logger.log(Level.INFO, "DMPttt:{0}", result.length);
        assertEquals(4, result.length);
    }
    
}
