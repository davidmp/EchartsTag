<%-- 
    Document   : BarStack3D
    Created on : Apr 6, 2020, 8:56:59 AM
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
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">BarStack3D Chart</a>
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
                    <button type="button" class="btn btn-secondary btn-lg btn-block">BarStack3D Chart elements or attributes</button>
                    
                    <h5 class="card-title">idCharts</h5>
                    <p class="card-text">idCharts, not specified by default; it is of type string in Java, it must be used to refer to the ID of the Div tag where the graphic will be printed, and it must be unique on the same screen..</p>
                    <h5 class="card-title">height</h5>
                    <p class="card-text">height is the height of the chart; it can take a value in the following format: "500px".</p>
                    <h5 class="card-title">width</h5>
                    <p class="card-text">width is the width of the chart; it can take a value in the following format: "800px".</p>
                    <h5 class="card-title">dataValues</h5>
                    <p class="card-text">dataValues ​​is an attribute of type JSONArray, which stores the data of the chart.</p>
                    <h5 class="card-title">seriesTypeEchart</h5>
                    <p class="card-text">seriesTypeEchart, is of type string and can take the following values: bar3D,line3D,surface,scatter3D</p>
                    
                    <h5 class="card-title">styleNormalEmphasis</h5>
                    <p class="card-text">styleNormalEmphasis en The opacity of the chart and can take values ​​between 0 to 1.</p>
                    
                    <h5 class="card-title">grid3DboxWidthDepth</h5>
                    <p class="card-text">grid3DboxWidthDepth, contemplates the width and depth of the 3D Cartesian plane</p>
                    
                    <h5 class="card-title">viewControlAutoRotate</h5>
                    <p class="card-text">viewControlAutoRotate is to allow the viewing angle to automatically rotate around the object.</p>
                    <h5 class="card-title">lightIntensity</h5>
                    <p class="card-text">lightIntensity, is the intensity of the ambient light.</p>

                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
        String idCharts="main";    
        public String height = "500px";
        public String width = "800px";
        
        Object[][] data={{0,0,4},
        {0,1,3.57118459347656},
        {0,2,3.19292786},
        {0,3,2.90797322102855},
        {0,4,2.738862329683},
        {0,5,2.6820298414491},
        {0,6,2.72005047139306},
        {0,7,2.8331537018696},
        {0,8,3.00351308153476},
        {0,9,3.21589522954066},
        {0,10,3.45806390397772},
        {0,11,3.72224661257355},
        {0,12,4.0069734576422},
        {0,13,4.31669934626249},
        {0,14,4.65482136064823},
        {0,15,5.00560514550999},
        {0,16,5.32879796874588},
        {0,17,5.57711170105271},
        {0,18,5.70632100419466},
        {0,19,5.69155835323897},
        {0,20,5.53462530642411},
        {0,21,5.26350238197492},
        {0,22,4.934131695817},
        {0,23,4.62158567726095},
        {0,24,4.39436833597234},
        {0,25,4.29587363543124},
        {0,26,4.33472644786223},
        {0,27,4.48301883983358},
        {0,28,4.68282700711285},
        {0,29,4.86286884215472},
        {0,30,4.96731276808481},
        {0,31,4.96353228327126},
        {0,32,4.82121911138732},
        {0,33,4.53125717736886},
        {0,34,4.11709429838556},
        {0,35,3.63081356130541},
        {0,36,3.14005518868041},
        {0,37,2.71145076904924},
        {0,38,2.39580783112686},
        {0,39,2.21995807022463},
        {0,40,2.18980968832455},
        {0,41,2.29991504245282},
        {0,42,2.53160462474591},
        {0,43,2.85433200756905}};
        String seriesTypeEchart="bar3D";  /*bar3D,line3D,surface,scatter3D*/
        JSONArray dataValues= new JSONArray(data); 
        double[] styleNormalEmphasis={0.8,0.4};/*0.2, 0.4*/
        int[] grid3DboxWidthDepth={200,80};
        boolean viewControlAutoRotate=false;
        double lightIntensity=0.8;
        </code></pre>
        </div>


        <h5 class="card-title">Code JSP</h5>
        <div class="content">
        <pre class="prettyprint highlight">
        <code class="language-html" data-lang="html">
&lt;%@page contentType="text/html" pageEncoding="UTF-8"%&gt;
&lt;%@taglib uri="http://www.syscenterlife.com/echarts3D" prefix="echar3D" %&gt;
&lt;%@taglib uri="http://www.syscenterlife.com/echarts"  prefix="echar" %&gt;
&lt;!DOCTYPE html&gt;
&lt;html&gt;
&lt;head&gt;
&lt;meta http-equiv="Content-Type" content="text/html; charset=UTF-8"&gt;
&lt;title&gt;JSP Page&lt;/title&gt;
&lt;echar:echartHeaderScript  /&gt;
&lt;/head&gt;
&lt;body&gt;
&lt;% /*Here Java code*/ %&gt;
&lt;echar3D:echartBar3DStack  dataValues="&lt;%=dataValues%&gt;" idCharts="main" height="500px" width="800px" /&gt;
&lt;/body&gt;
&lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result BarStack3D Chart</h5>
                      <img src="<%=request.getContextPath()%>/webdocument/barstack3d.png" class="card-img" alt="Bar Chart">
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