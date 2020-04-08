<%-- 
    Document   : Radar
    Created on : Apr 6, 2020, 4:36:15 AM
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
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">Radar Chart</a>
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
                    <button type="button" class="btn btn-secondary btn-lg btn-block">Radar Chart elements or attributes</button>
                    
                    
                    <h5 class="card-title">idCharts</h5>
                    <p class="card-text">idCharts, not specified by default; it is of type string in Java, it must be used to refer to the ID of the Div tag where the graphic will be printed, and it must be unique on the same screen..</p>
                    <h5 class="card-title">height</h5>
                    <p class="card-text">height is the height of the chart; it can take a value in the following format: "500px".</p>
                    <h5 class="card-title">width</h5>
                    <p class="card-text">width is the width of the chart; it can take a value in the following format: "800px".</p>
                    <h5 class="card-title">dataValues</h5>
                    <p class="card-text">dataValues is an attribute of type JSONArray; dataValues must contain an Array of type Object.</p>                    
                    
                    <h5 class="card-title">legendDataName</h5>
                    <p class="card-text">legendDataName is an attribute of type string vector, which stores the names of the labels.</p>                    
                    <h5 class="card-title">indicadorData</h5>
                    <p class="card-text">indicatorData is an attribute of type Array Object, which stores the data of one of the main Axes.</p>                    
                    
                    <h5 class="card-title">areaStyleOpacy</h5>
                    <p class="card-text">areaStyleOpacy is the Opacity of the component. Supports value from 0 to 1, and the component will not be drawn when set to 0.</p>
                    <h5 class="card-title">seriesName</h5>
                    <p class="card-text">seriesName is of type string to store the title of the data report.</p>
                    <h5 class="card-title">lineStyleType</h5>
                    <p class="card-text">lineStyleType is of type string and can take the following values: solid, dashed, dotted.</p>
                    <h5 class="card-title">toolboxOrient</h5>
                    <p class="card-text">toolboxOrient is of type string and can take the following values: vertical, horizontal.</p>
                    

                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
        String idCharts="main";  
        public String height = "500px";
        public String width = "800px";
        Object[][] dataValuesX={
                    {0,10000,28000,35000,50000,19000},
                    {50,14000,28000,31000,"-",21000},
                    {"-",8000,20000,20000,40000,10000}
                };
        Object[][] dataValuesXY={
                    {0,10000,28000,35000,50000},
                    {50,14000,28000,31000,"-"},
                    {"-",8000,20000,20000,40000}
                };

        Object[][] indicadorData={
        {"sales","Administration","Information Techology","Customer Support","Development","Marketing"},
        {100,16000,30000,38000,52000,25000}
        };
        Object[][] indicadorDataY={
        {"sales","Administration","Information Techology","Customer Support","Development"},
        {100,16000,30000,38000,52000}
        };

        String[] legendDataName=new String[dataValuesX.length];
        legendDataName[0]="Asignación de presupuesto";
        legendDataName[1]="El gasto real contiene datos";
        legendDataName[2]="El primer elemento es nulo";

        JSONArray dataValues=new JSONArray(dataValuesX);            
        JSONArray dataValuesY=new JSONArray(dataValuesXY);            
        String seriesName="Presupuesto vs gasto x";

        double areaStyleOpacy=0.1;/*0-1*/
        String lineStyleType="dotted";/*'solid','dashed','dotted'*/ 
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
&lt;echar:echartHeaderScript  /&gt;
&lt;/head&gt;
&lt;body&gt;
&lt;% /*Here Java code*/ %&gt;
&lt;echar:echartRadar idCharts="main1" dataValues="&lt;%=dataValuesY%&gt;" indicadorData="&lt;%=indicadorDataY%&gt;"
legendDataName="&lt;%=legendDataName%&gt;" seriesName="&lt;%=seriesName%&gt;" lineStyleType="&lt;%=lineStyleType%&gt;"
				   width="700px"   /&gt;
&lt;/body&gt;
&lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result Radar Chart</h5>
                      <img src="radar.png" class="card-img" alt="Bar Chart">
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
          e.preventDefault();
          $(this).tab('show');
        });
    </script>  

</body></html>