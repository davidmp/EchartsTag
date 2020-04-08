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
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">Bar Chart</a>
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
                    <button type="button" class="btn btn-secondary btn-lg btn-block">Bar Chart elements or attributes</button>
                    
                    
                    <h5 class="card-title">idCharts</h5>
                    <p class="card-text">idCharts, not specified by default; it is of type string in Java, it must be used to refer to the ID of the Div tag where the graphic will be printed, and it must be unique on the same screen..</p>
                    <h5 class="card-title">chartTitle</h5>
                    <p class="card-text">chartTitle, requires a string value and is mandatory to define the chart title, if possible the title should not be very long.</p>
                    <h5 class="card-title">echartsOriented</h5>
                    <p class="card-text">echartsOriented puede tomar solo los siguientes valores: "vertical", "horizontal".</p>
                    <h5 class="card-title">height</h5>
                    <p class="card-text">height is the height of the chart; it can take a value in the following format: "500px".</p>
                    <h5 class="card-title">width</h5>
                    <p class="card-text">width is the width of the chart; it can take a value in the following format: "800px".</p>
                    <h5 class="card-title">dataValues</h5>
                    <p class="card-text">dataValues ​​is an attribute of type Vector Object; dataValues ​​must contain one or more decimal type vectors.</p>
                    <h5 class="card-title">legendDataName</h5>
                    <p class="card-text">legendDataName is an attribute of type vector string and is required.</p>
                    <h5 class="card-title">ejeDataX</h5>
                    <p class="card-text">ejeDataX is an attribute of type string vector; which stores the names of a series.</p>
                    <h5 class="card-title">ejeNameXY</h5>
                    <p class="card-text">ejeNameXY is an attribute of type string vector; which stores the names of both XY axes.</p>
                    <h5 class="card-title">seriesMarkPointMinMax</h5>
                    <p class="card-text">seriesMarkPointMinMax is an attribute of type boolean vector; It has the function of showing the maximum and minimum of a series of chart and can take the following values: true, false.</p>
                    <h5 class="card-title">seriesMarkLineMedia</h5>
                    <p class="card-text">seriesMarkLineMedia is an attribute of type boolean vector; It has the function of showing the average of a series of chart and can take the following values: true, false.</p>
                    <h5 class="card-title">seriesStackName</h5>
                    <p class="card-text">seriesStackName es el Name of stack. On the same category axis, the series with the same stack name would be put on top of each other.</p>                    

                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
        String idCharts="main1"; 
        public String height = "500px";
        public String width = "800px";
        String chartTitle="Soy un histograma";

        double[] dataValues1={1.33,4.94,4.48,2.44,3.37,1.61,2.58,1.99,0.57,4.89};
        double[] dataValues2={-0.08,-0.22,-0.82,-0.51,-0.18,-0.54,-0.62,-0.61,-0.44,-0.58};
        double[] dataValues3={1.12,1.44,1.2,0.53,1.48,0.61,0.68,0.9,0.7,1.34};
        double[] dataValues4={0.45,0.96,0.76,0.6,0.84,0.95,0.47,0.88,0.83,0.98};

        Object[] dataValues={dataValues1,dataValues2,dataValues3,dataValues4};
        String[] legendDataName=new String[dataValues.length];            
        legendDataName[0]="bar";
        legendDataName[1]="bar2"; 
        legendDataName[2]="bar3"; 
        legendDataName[3]="bar4"; 

        String[] ejeDataX={"Categoría0","Categoría1","Categoría2","Categoría3","Categoría4","Categoría5","Categoría6",
                            "Categoría7","Categoría8","Categoría9"};            
        String[] ejeNameXY={"Eje X","Eje Y"};           
        boolean[] seriesMarkPointMinMax ={false,false,false,false};
        boolean[] seriesMarkLineMedia ={false,false,false,false};             
        String[] seriesStackName ={"one","one","two","two"};            
        String echartsOriented="horizontal";/*vertical,horizontal*/
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
        &lt;echar:echartBarHistogram  chartTitle="&lt;%=chartTitle%&gt;" dataValues="&lt;%=dataValues%&gt;" ejeDataX="&lt;%=ejeDataX%&gt;"
                                          idCharts="main" legendDataName="&lt;%=legendDataName%&gt;"/&gt;        
        &lt;/body&gt;
        &lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result Bar Chart</h5>
                      <img src="<%=request.getContextPath()%>/webdocument/bar.png" class="card-img" alt="Bar Chart">
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