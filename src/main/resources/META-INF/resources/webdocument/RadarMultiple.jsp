<%-- 
    Document   : RadarMultiple
    Created on : Apr 6, 2020, 6:00:36 AM
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
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">RadarMulti Chart</a>
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
                    <button type="button" class="btn btn-secondary btn-lg btn-block">RadarMulti Chart elements or attributes</button>
                    
                    
                    <h5 class="card-title">idCharts</h5>
                    <p class="card-text">idCharts, not specified by default; it is of type string in Java, it must be used to refer to the ID of the Div tag where the graphic will be printed, and it must be unique on the same screen..</p>
                    <h5 class="card-title">height</h5>
                    <p class="card-text">height is the height of the chart; it can take a value in the following format: "500px".</p>
                    <h5 class="card-title">width</h5>
                    <p class="card-text">width is the width of the chart; it can take a value in the following format: "800px".</p>
                    <h5 class="card-title">chartTitle</h5>
                    <p class="card-text">chartTitle, requires a string value and is mandatory to define the chart title, if possible the title should not be very long.</p>                    
                    
                    <h5 class="card-title">legendDataName</h5>
                    <p class="card-text">legendDataName is an attribute of type string vector, which stores the names of the labels.</p>                                        
                    <h5 class="card-title">dataValuesM</h5>
                    <p class="card-text">dataValuesM is an attribute of type Object vector; dataValues ​​must contain the data of the chart.</p>                                        
                    <h5 class="card-title">areaStyleOpacy</h5>
                    <p class="card-text">areaStyleOpacy is the opacity of the component. Supports values from 0 to 1, and the component will not be drawn when set to 0.</p>
                    <h5 class="card-title">indicadorDataM</h5>
                    <p class="card-text">indicadorDataM is the opacity of the component. Supports values from 0 to 1, and the component will not be drawn when set to 0.</p>
                    <h5 class="card-title">indicatorPositionWH</h5>
                    <p class="card-text">indicatorPositionWH is the center vertical position and the second is the horizontal position; it can take a value similar to "50%" and the second similar to 400.</p>                    
                    
                    
                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
        String idCharts="main";  
        public String height = "500px";
        public String width = "800px";
        Object[][] dataValues1={{60,73,85,40}};
        Object[][] dataValues2={{85,90,90,95,95},{95,80,95,90,93}};
        Object[][] dataValues3={
            {2.6,5.9,9,26.4,28.7,70.7,75.6,82.2,48.7,18.8,6,2.3},
            {2,4.9,7,23.2,25.6,76.7,35.6,62.2,32.6,20,6.4,3.3}};

        Object[] dataValuesM={dataValues1,dataValues2,dataValues3};/*SI*/

        Object[][] indicadorPositionWH=new Object[2][dataValuesM.length]; /*SI*/
        indicadorPositionWH[0][0]="25%"; indicadorPositionWH[1][0]=200;
        indicadorPositionWH[0][1]="50%"; indicadorPositionWH[1][1]=300;
        indicadorPositionWH[0][2]="75%"; indicadorPositionWH[1][2]=200;

        double[] areaStyleOpacy= new double[dataValuesM.length]; /*SI*/
        areaStyleOpacy[0]=0.8;
        areaStyleOpacy[1]=0;
        areaStyleOpacy[2]=0.8;



        Object[][] indicadorData1={
        {"Brand","Content","Availability","function"},
        {100,100,100,100}
        };
        Object[][] indicadorData2={
        {"Appearance","take a picture","System","performance","screen"},
        {100,100,100,100,100}
        };
        Object[][] indicadorData3=new Object[2][dataValues3[0].length];
        for (int i = 0; i &lt; 12; i++) {
            indicadorData3[0][i]=(i+1)+"month";
            indicadorData3[1][i]=100;
        }
        Object[] indicadorDataM={indicadorData1,indicadorData2,indicadorData3}; /*SI*/

        String[] legendDataName=new String[dataValues1.length+dataValues2.length+dataValues3.length]; /*SI*/
        legendDataName[0]="Some software";
        legendDataName[1]="A staple food phone";
        legendDataName[2]="A fruit phone";
        legendDataName[3]="Precipitation";
        legendDataName[4]="Evaporation";

        String chartTitle="Grafico de radar multiple";
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
&lt;echar:echartRadarMultip idCharts="main" chartTitle="&lt;%=chartTitle%&gt;" areaStyleOpacy="&lt;%=areaStyleOpacy%&gt;"
indicadorDataM="&lt;%=indicadorDataM%&gt;" legendDataName="&lt;%=legendDataName%&gt;" indicadorPositionWH="&lt;%=indicadorPositionWH%&gt;"
                         dataValuesM="&lt;%=dataValuesM%&gt;"/&gt; 
&lt;/body&gt;
&lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result RadarMultiple Chart</h5>
                      <img src="<%=request.getContextPath()%>/webdocument/radarmultiple.png" class="card-img" alt="Bar Chart">
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