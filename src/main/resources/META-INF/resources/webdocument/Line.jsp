<%-- 
    Document   : Line
    Created on : Apr 5, 2020, 8:48:59 PM
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
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">Line Chart</a>
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
                    <button type="button" class="btn btn-secondary btn-lg btn-block">Line Chart elements or attributes</button>
                    
                    <h5 class="card-title">idCharts</h5>
                    <p class="card-text">idCharts, not specified by default; it is of type string in Java, it must be used to refer to the ID of the Div tag where the graphic will be printed, and it must be unique on the same screen..</p>
                    <h5 class="card-title">height</h5>
                    <p class="card-text">height is the height of the chart; it can take a value in the following format: "500px".</p>
                    <h5 class="card-title">width</h5>
                    <p class="card-text">width is the width of the chart; it can take a value in the following format: "800px".</p>                    
                    <h5 class="card-title">echartsOriented</h5>
                    <p class="card-text">echartsOriented puede tomar solo los siguientes valores: "vertical", "horizontal".</p>                                                            
                    <h5 class="card-title">dataValues</h5>
                    <p class="card-text">dataValues ​​is an attribute of type Vector Object; dataValues ​​must contain data for the chart.</p>                                                            
                    <h5 class="card-title">legendDataName</h5>
                    <p class="card-text">legendDataName is an attribute of type vector string, which contains the legend of the data.</p>                                        
                    <h5 class="card-title">chartAxisXYCategory</h5>
                    <p class="card-text">chartAxisXYCategory is a string vector type attribute, to represent the data of one of the main axes.</p>
                    <h5 class="card-title">seriesMarkPointMinMax</h5>
                    <p class="card-text">seriesMarkPointMinMax is an attribute of type boolean vector; It has the function of showing the maximum and minimum of a series of chart and can take the following values: true, false.</p>
                    <h5 class="card-title">seriesMarkLineMedia</h5>
                    <p class="card-text">seriesMarkLineMedia is an attribute of type boolean vector; It has the function of showing the average of a series of chart and can take the following values: true, false.</p>                    
                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
        String idCharts="main";  
        public String height = "500px";
        public String width = "800px";
        
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
&lt;echar:echartLine idCharts="main3" dataValues="&lt;%=dataValues%&gt;"
chartAxisXYCategory="&lt;%=chartAxisXYCategory%&gt;"  legendDataName="&lt;%=legendDataName%&gt;" scriptAdd="&lt;%=scriptAdd%&gt;"
seriesMarkLineMedia="&lt;%=seriesMarkLineMedia%&gt;" seriesMarkPointMinMax="&lt;%=seriesMarkPointMinMax%&gt;"/&gt;
&lt;/body&gt;
&lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result Line Chart</h5>
                      <img src="<%=request.getContextPath()%>/webdocument/line.png" class="card-img" alt="Bar Chart">
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