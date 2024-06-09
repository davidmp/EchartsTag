package pe.com.syscenterlife.echarts.util;

/**
 * La clase {@code EchartsUtilTag} proporciona utilidades para manejar datos de
 * gráficos ECharts. Actualmente, incluye un método para verificar y reordenar
 * los datos de posiciones basados en un conjunto de nombres de elementos.
 * <p>
 * Ejemplo de uso:
 * </p>
 * <pre>
 * {@code
 * EchartsUtilTag util = new EchartsUtilTag();
 * Object[] elementNames = {"A", "B", "C"};
 * Object[][] dataCategPropied = {
 *     {"A", "B", "C"},
 *     {1, 2, 3},
 *     {4, 5, 6}
 * };
 * Object[][] reorderedData = util.verifPositionData(elementNames, dataCategPropied);
 * }
 * </pre>
 *
 * @author davidmp et al.
 * @since 1.0
 */
public class EchartsUtilTag {
    /**
     * Constructor por defecto.
     */
    public EchartsUtilTag(){
    }
    
    /**
     * Verifica y ajusta la posición de los datos en función de los nombres de
     * los elementos proporcionados.
     * <p>
     * Reorganiza las columnas de la matriz de datos {@code dataCategPropied}
     * para que coincidan con el orden de los elementos en {@code elementNames}.
     * </p>
     *
     * @param elementNames los nombres de los elementos en el orden deseado.
     * @param dataCategPropied la matriz de datos que contiene categorías y
     * propiedades. La primera fila debe contener los nombres de las categorías.
     * @return una nueva matriz de datos con las columnas reorganizadas según el
     * orden especificado en {@code elementNames}.
     */
    public Object[][] verifPositionData(Object[] elementNames, Object[][] dataCategPropied) {
        Object[][] dataCategPropiedT;
        dataCategPropiedT = dataCategPropied;
        Object[][] dataCategPropiedTX = new Object[dataCategPropied.length][1];
        for (int i = 0; i < elementNames.length; i++) {
            for (int j = i; j < dataCategPropied[0].length; j++) {
                if (elementNames[i].equals(dataCategPropiedT[0][j])) {
                    for (int k = 0; k < dataCategPropiedT.length; k++) {
                        dataCategPropiedTX[k][0] = dataCategPropiedT[k][i];
                        dataCategPropiedT[k][i] = dataCategPropiedT[k][j];
                        dataCategPropiedT[k][j] = dataCategPropiedTX[k][0];
                    }
                }
            }
        }
        return dataCategPropiedT;
    }
}
