<%-- 
    Document   : RadarOpc2
    Created on : Apr 6, 2020, 4:54:48 AM
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
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">RadarSim Chart</a>
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
                    <button type="button" class="btn btn-secondary btn-lg btn-block">RadarSim Chart elements or attributes</button>
                    
                    
                    <h5 class="card-title">idCharts</h5>
                    <p class="card-text">idCharts, not specified by default; it is of type string in Java, it must be used to refer to the ID of the Div tag where the graphic will be printed, and it must be unique on the same screen..</p>
                    <h5 class="card-title">height</h5>
                    <p class="card-text">height is the height of the chart; it can take a value in the following format: "500px".</p>
                    <h5 class="card-title">width</h5>
                    <p class="card-text">width is the width of the chart; it can take a value in the following format: "800px".</p>
                    <h5 class="card-title">chartTitle</h5>
                    <p class="card-text">chartTitle, requires a string value and is mandatory to define the chart title, if possible the title should not be very long.</p>                    
                    <h5 class="card-title">lineStyleType</h5>
                    <p class="card-text">lineStyleType is of type string and can take the following values: solid, dashed, dotted.</p>
                    <h5 class="card-title">seriesName</h5>
                    <p class="card-text">seriesName is of type string to store the title of the data report.</p>
                    <h5 class="card-title">legendDataName</h5>
                    <p class="card-text">legendDataName is an attribute of type string vector, which stores the names of the labels.</p>                                        
                    <h5 class="card-title">dataValues</h5>
                    <p class="card-text">dataValues is an attribute of type JSONArray; dataValues must contain an Array of type Object.</p>                                        
                    <h5 class="card-title">indicadorData</h5>
                    <p class="card-text">indicadorData is an attribute of type Array Object, which stores the data of one of the main Axes.</p>                                        
                    <h5 class="card-title">visualMapColors</h5>
                    <p class="card-text">visualMapColors is a type of component for color visualization, the same that can be: red, yellow, etc.</p>


                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
        String idCharts="main";  
        public String height = "500px";
        public String width = "800px";
	Object[][] dataValuesX={
				{390,208,15,9,0.5},
				{380,204,20,18,2},
				{370,200,25,27,4.5},
				{360,196,30,36,8},
				{350,192,35,45,12.5},
				{340,188,40,54,18},
				{330,184,45,63,24.5},
				{320,180,50,72,32},
				{310,176,55,81,40.5},
				{300,172,60,90,50},
				{290,168,65,99,60.5},
				{280,164,70,108,72},
				{270,160,75,117,84.5},
				{260,156,80,126,98},
				{250,152,85,135,112.5},
				{240,148,90,144,128},
				{230,144,95,153,144.5},
				{220,140,100,162,162},
				{210,136,105,171,180.5},
				{200,132,110,180,200},
				{190,128,115,189,220.5},
				{180,124,120,198,242},
				{170,120,125,207,264.5},
				{160,116,130,216,288},
				{150,112,135,225,312.5},
				{140,108,140,234,338},
				{130,104,145,243,364.5},
				{120,100,150,252,392}
			};
	
	Object[][] indicadorData={
					{"IE8-","IE9+","Safari","Firefox","Chrome"},
					{400,400,400,400,400,400}
					};
	
	String[] legendDataName=new String[dataValuesX.length];
	for (int i = 0; i &lt; legendDataName.length; i++) {
			legendDataName[i]=""+(2001+i);
		}
	String[] visualMapColors={"#3333FF", "yellow"};
	JSONArray dataValues=new JSONArray(dataValuesX);

	String seriesName="Presupuesto vs gasto x";
	String lineStyleType="dotted";/*'solid','dashed','dotted'*/
	String chartTitle="Cambio de uso compartido del navegador";
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
&lt;echar:echartRadarO2 idCharts="main" dataValues="&lt;%=dataValues%&gt;" indicadorData="&lt;%=indicadorData%&gt;"
legendDataName="&lt;%=legendDataName%&gt;" seriesName="&lt;%=seriesName%&gt;" lineStyleType="&lt;%=lineStyleType%&gt;"
					 chartTitle="&lt;%=chartTitle%&gt;"  width="700px"   /&gt;
&lt;/body&gt;
&lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result RadarSimp Chart</h5>
                      <img src="<%=request.getContextPath()%>/webdocument/radaropc2.png" class="card-img" alt="Bar Chart">
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
