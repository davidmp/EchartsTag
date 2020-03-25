
package pe.com.syscenterlife.echarts.util;

/**
 *
 * @author davidmp
 */
public class EchartsUtilTag {
    
public Object[][] verifPositionData(Object[] elementNames, Object[][] dataCategPropied){
        Object[][] dataCategPropiedT;
        dataCategPropiedT=dataCategPropied;
        Object[][] dataCategPropiedTX=new Object[dataCategPropied.length][1];
        for(int i=0; i<elementNames.length; i++) {
            for(int j=i; j<dataCategPropied[0].length; j++){                        
            if(elementNames[i].equals(dataCategPropiedT[0][j])){    
                for (int k = 0; k < dataCategPropiedT.length; k++) {
                    dataCategPropiedTX[k][0]=dataCategPropiedT[k][i];
                    dataCategPropiedT[k][i]=dataCategPropiedT[k][j];  
                    dataCategPropiedT[k][j]=dataCategPropiedTX[k][0];
                }
                }
            }
        }
        return dataCategPropiedT;
    }    
}
