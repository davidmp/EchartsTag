<%-- 
    Document   : demo
    Created on : Mar 16, 2020, 4:48:47 PM
    Author     : davidmp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/webdocument/echarts/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/webdocument/echarts/css/navbar-top-fixed.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/webdocument/echarts/css/guide.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/webdocument/echarts/css/prettify.css" rel="stylesheet">

  </head>

  <body class="guide">

    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-light" style="background-color: #e3f2fd;">
      
	  <a class="navbar-brand" href="#" id="logo-focus" >
        <img alt="Spring" class="block" id="springlogo" src="<%=request.getContextPath()%>/webdocument/echarts/img/LogoEchartsTag2.png" />
      </a>
      
        <button class="navbar-toggler bg-secondary" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
	  
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="btn btn-outline-secondary my-2 my-sm-0" href="<%=request.getContextPath()%>/echartsdoc.jsp">Why EchartsTag </a>
          </li>
          <li class="nav-item">
            <a class="btn btn-outline-secondary my-2 my-sm-0" href="<%=request.getContextPath()%>/webdocument/indexLearn.jsp">Learn</a>
          </li>
          <li class="nav-item">
            <a class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/indexProjects.jsp">Projects</a>
          </li>
          <li class="nav-item">
            <a class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/indexSupport.jsp">Support</a>
          </li>		  
        </ul>
      </div>
    </nav>

    <main role="main" class="container">
   
        <div class="container">
          <div class="row">
            <div>
              <div class="card">
                <div class="card-header">
                  <ul class="nav nav-tabs card-header-tabs" id="bologna-list" role="tablist">
                    <li class="nav-item">
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">BarSim Chart</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link"  href="#example" role="tab" aria-controls="history" aria-selected="false">Example</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#result" role="tab" aria-controls="deals" aria-selected="false">Result</a>
                    </li>
                    
                  </ul>
                </div>
                <div class="card-body">
<!--                  <h4 class="card-title">Bologna</h4>
                  <h6 class="card-subtitle mb-2">Emilia-Romagna Region, Italy</h6>-->

                   <div class="tab-content mt-3">
                    <div class="tab-pane active" id="description" role="tabpanel">
                    <button type="button" class="btn btn-secondary btn-lg btn-block">BarSim Chart elements or attributes</button>
                    
                    
                    <h5 class="card-title">idCharts</h5>
                    <p class="card-text">idCharts, not specified by default; it is of type string in Java, it must be used to refer to the ID of the Div tag where the graphic will be printed, and it must be unique on the same screen..</p>
                    <h5 class="card-title">height</h5>
                    <p class="card-text">height is the height of the chart; it can take a value in the following format: "500px".</p>
                    <h5 class="card-title">width</h5>
                    <p class="card-text">width is the width of the chart; it can take a value in the following format: "800px".</p>                    
                    <h5 class="card-title">dataLabel</h5>
                    <p class="card-text">dataLabel, requiere un valor de tipo LinkedHashMap, es mostrar el nombre del gráfico gráfico.</p>                    
                    <h5 class="card-title">dataValuesEjeBase</h5>
                    <p class="card-text">dataValuesEjeBase, requires a value of type JSONArray, which includes data from one of the axes of the chart.</p>                    
                    <h5 class="card-title">dataValues</h5>
                    <p class="card-text">dataValues ​​is an attribute of type JSONObject; dataValues ​​contains the various data for the chart.</p>
                    
                    <h5 class="card-title">orientationChart</h5>
                    <p class="card-text">orientationChart puede tomar solo los siguientes valores: "vertical", "horizontal".</p>                    
                    <h5 class="card-title">classCharts</h5>
                    <p class="card-text">classCharts is an attribute of type string, the same that accepts a style of type class. for example (
                     &lt;style&gt;
                            .dmp {
                                background-color: chartreuse;
                            }
                        &lt;/style&gt;
                    ) ;
done should be placed like this classCharts = "dmp"</p>

                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
        String idCharts="main"; 
        public String height = "500px";
        public String width = "800px";

        Object[] dataValuesEjeBasex = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio"};            
        JSONArray dataValuesEjeBase = new JSONArray(dataValuesEjeBasex);
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
        JSONObject dataValuesX = new JSONObject(hmx);
        String[] elementNames = JSONObject.getNames(dataValuesX);

        Object[][] dataCategPropied = {{"cchar", "php", "java", "python", "r"},
        {"C##", "PHP", "Java", "Python", "R"},
        {"", "", "", "", ""},
        {"inside", "inside", "left", "inside", "inside"}};

        EchartsUtilTag objxs = new EchartsUtilTag();
        dataCategPropied = objxs.verifPositionData(elementNames, dataCategPropied);

        LinkedHashMap<String, Object> dataLabel = new LinkedHashMap<>();
        dataLabel.put("id", new JSONArray(dataCategPropied[0]));
        dataLabel.put("Categoria", new JSONArray(dataCategPropied[1]));
        dataLabel.put("stack", new JSONArray(dataCategPropied[2]));
        dataLabel.put("position", new JSONArray(dataCategPropied[2]));
        String orientationChart="vertical";
        </code></pre>
        </div>


        <h5 class="card-title">Code JSP</h5>
        <div class="content">
        <pre class="prettyprint highlight">
        <code class="language-html" data-lang="html">
	&lt;%@page contentType="text/html" pageEncoding="UTF-8"%&gt;
	&lt;%@taglib uri="http://www.syscenterlife.com/echarts" prefix="echar" %&gt;
	&lt;!DOCTYPE html&gt;
	&lt;html&gt;
				&lt;head&gt;
                                    &lt;meta http-equiv="Content-Type" content="text/html; charset=UTF-8"&gt;
                                    &lt;title&gt;JSP Page&lt;/title&gt;
                                    &lt;echar:echartHeaderScript/&gt; 
				&lt;/head&gt;
	&lt;body&gt;
	&lt;% /*Here Java code*/ %&gt;
	&lt;echar:echartBar dataValuesEjeBase="&lt;%=dataValuesEjeBase%&gt;"  dataLabel="&lt;%=dataLabel%&gt;" dataValues="&lt;%=dataValuesX%&gt;" orientationChart="&lt;%=orientationChart%&gt;" idCharts="main" height="500px" width="700px" /&gt;
	&lt;/body&gt;
	&lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result BarSimple Chart</h5>
                      <img src="<%=request.getContextPath()%>/webdocument/barsimple.png" class="card-img" alt="Bar Chart">
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>           
            

    </main>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/webdocument/echarts/js/jquery-3.2.1.slim.min.js" ></script>
    <script src="<%=request.getContextPath()%>/webdocument/echarts/js/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/webdocument/echarts/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/webdocument/echarts/js/run_prettify.js"></script>
    <script>
        $('#bologna-list a').on('click', function (e) {
          e.preventDefault()
          $(this).tab('show')
        })        
    </script>  

</body></html>