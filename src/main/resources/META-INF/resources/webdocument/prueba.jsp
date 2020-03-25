<%@page import="pe.com.syscenterlife.echarts.util.EchartsUtilTag"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@taglib uri="http://www.syscenterlife.com/echarts" prefix="echar" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">

        <%
            String urlx = request.getContextPath();
        %>
        <meta charset="utf-8">
        <!-- CSS Stylesheet -->
        <link rel="stylesheet" type="text/css" href="<%=urlx%>/webjars/syscenterlife/echarts/1.1.0/css/style.css" />
        <!--[if lt IE 9]>
        <script async src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
        <![endif]-->
        <script src="<%=urlx%>/webjars/syscenterlife/echarts/1.1.0/js/echarts-es.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <style>
            h1 {
                line-height: 60px;
                height: 60px;
                background: #146402;
                text-align: center;
                font-weight: bold;
                color: #eee;
                font-size: 14px;
            }
            .chart {
                height: 600px;
            }
        </style>

    </head>
    <body>

        <table>
            <tr>
                <td><div id="main" style="height: 400px; width: 600px" ></div></td>
                <td><div id="lista">
                        <a href="<%=urlx%>/webdocument/prueba.jsp">Prueba real</a><br/>
                        <a href="prueba.jsp">Prueba X</a><br/>
                        <a href="ventas/prueba.jsp">Ventas</a><br/>
                        <a href="/EchartsDMP/DemoControl">Ventas Prueba 2</a><br/>
                        <a href="pruebaEchar.jsp">Chart</a><br/>
                    </div></td>
            </tr>
        </table>

        <%
            Object[] dataValuesEjeBasex = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio"};
            //Object[] dataValuesEjeBasex={"Car home DMP", "Todays headlines", "Baidu Post Bar", "Little Information", "WeChat", "Weibo", "Knowledge"};
            JSONArray dataValuesEjeBase = new JSONArray(dataValuesEjeBasex);
            Object[][] dataValues = {
                {300, -270, 340, 344, 300, 320, 10},
                {120, 102, 141, 174, 190, 250, 220},
                {-20.25, -32, -21, -34, -90, -130, -110},
                {-15, -32, -40, -34, -90, -130, -200},
                {100, 102, 141, 20, 190, 250, 220}
            };

            // Map<String,Object> hmx = new HashMap<>();
            LinkedHashMap<String, Object> hmx = new LinkedHashMap<>();
            hmx.put("cchar", dataValues[0]);
            hmx.put("php", dataValues[1]);
            hmx.put("java", dataValues[2]);
            hmx.put("python", dataValues[3]);
            hmx.put("r", dataValues[4]);
            JSONObject obj = new JSONObject(hmx);
            String[] elementNames = JSONObject.getNames(obj);

            Object[][] dataCategPropied = {{"cchar", "php", "java", "python", "r"},
            {"C##", "PHP", "Java", "Python", "R"},
            {"", "", "", "", ""},
            {"inside", "inside", "left", "inside", "inside"}};

            EchartsUtilTag objxs = new EchartsUtilTag();
            dataCategPropied = objxs.verifPositionData(elementNames, dataCategPropied);

            //Map<String,Object> element = new HashMap<>();
            LinkedHashMap<String, Object> element = new LinkedHashMap<>();
            element.put("id", new JSONArray(dataCategPropied[0]));
            element.put("Categoria", new JSONArray(dataCategPropied[1]));
            element.put("stack", new JSONArray(dataCategPropied[2]));
            element.put("position", new JSONArray(dataCategPropied[2]));

            JSONArray lisx;

            lisx = (JSONArray) element.get("Categoria");

            // System.out.println("json = " + lisx);
            //out.print(obj.get("LenguajeD"));
            //out.print(obj2.get("LenguajeD"));
        %>


        <script>

            var chart = echarts.init(document.getElementById('main'));
            chart.setOption({
            aria: {
            show: true,
                    series: {
                    multiple: {
                    prefix: '{seriesCount}La serie de gráficos compone el gráfico.'
                    }
                    }
            },
                    tooltip : {
                    trigger: 'axis',
                            axisPointer : {            // ??????????????
                            type : 'shadow'        // ??????????'line' | 'shadow'
                            }
                    },
                    legend: {
                    data:<%=lisx%>
                    },
                    grid: {
                    left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                    },
                    xAxis : [
                    {
                    type : 'value'
                    }
                    ],
                    yAxis : [
                    {
                    type : 'category',
                            axisTick : {show: false},
                            data : <%=dataValuesEjeBase%>
                    }
                    ],
                    series : [

            <%
                JSONArray lisxy = (JSONArray) element.get("stack");
                for (int i = 0, size = lisx.length(); i < size; i++) {
                    if (i == 0) {%>
                    {
                    name:'<%=lisx.get(i)%>',
                            type:'bar',
                            stack: '<%=lisxy.get(i)%>',
                            label: {
                            normal: {
                            show: true,
                                    position: 'inside'
                            }
                            },
                            data:<%=obj.get(elementNames[i])%>
                    }
            <%} else {%>
                    ,
                    {
                    name:'<%=lisx.get(i)%>',
                            type:'bar',
                            stack: '<%=lisxy.get(i)%>',
                            label: {
                            normal: {
                            show: true,
                                    position: 'inside'
                            }
                            },
                            data:<%=obj.get(elementNames[i])%>
                    }

            <% }
                }%>
                    ]
            });
            window.onresize = chart.resize;
        </script>
    </body>
</html>