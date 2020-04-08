<%-- 
    Document   : Funnel
    Created on : Apr 5, 2020, 8:32:27 PM
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
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">Funnel Chart</a>
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
                    <button type="button" class="btn btn-secondary btn-lg btn-block">Funnel Chart elements or attributes</button>
                                        
                    <h5 class="card-title">idCharts</h5>
                    <p class="card-text">idCharts, not specified by default; it is of type string in Java, it must be used to refer to the ID of the Div tag where the graphic will be printed, and it must be unique on the same screen..</p>
                    <h5 class="card-title">height</h5>
                    <p class="card-text">height is the height of the chart; it can take a value in the following format: "500px".</p>
                    <h5 class="card-title">width</h5>
                    <p class="card-text">width is the width of the chart; it can take a value in the following format: "800px".</p>                    
                    <h5 class="card-title">chartTitle</h5>
                    <p class="card-text">chartTitle, requires a string value and is mandatory to define the chart title, if possible the title should not be very long.</p>                                        
                    <h5 class="card-title">dataValues</h5>
                    <p class="card-text">dataValues ​​is an attribute of type Array Object; dataValues ​​must contain data for the chart.</p>                                        
                    <h5 class="card-title">legendDataName</h5>
                    <p class="card-text">legendDataName is an attribute of type vector string, which contains the legend of the data.</p>                    
                    <h5 class="card-title">serieCategoryName</h5>
                    <p class="card-text">serieCategoryName is an attribute of type string, to represent the data of the main axis.</p>
                    <h5 class="card-title">serieLabelPosition</h5>
                    <p class="card-text">stringLabelPosition is a vector string type attribute, to show the position of the legend name and can take the following values: outside, inside, left,right, insideRight, insideLeft, leftTop, leftBottom, rightTop, rightBottom, inner, center.</p>
                    <h5 class="card-title">serieItemStyleOpacy</h5>
                    <p class="card-text">serieItemStyleOpacy, is an element or attribute of type string vector. Supports values ​​from 0 to 1, and the element will not be drawn when set to 0.</p>
                    <h5 class="card-title">serieLabelFormatter</h5>
                    <p class="card-text">serieLabelFormatter, is Data label formatter, which supports string template and callback function. In either form, \n is supported to represent a new line.

String template

Model variation includes:

{a}: series name.
{b}: the name of a data item.
{c}: the value of a data item.
{d}: the percent.
{@xxx}: the value of a dimension named'xxx', for example,{@product}refers the value of'product'` dimension.
{@[n]}: the value of a dimension at the index ofn, for example,{@[3]}` refers the value at dimensions[3].</p>
                    <h5 class="card-title">serieSort</h5>
                    <p class="card-text">serieSort, is a Data sorting, which can be whether 'ascending', 'descending', 'none'(in data order) or a function, which is the same as Array.prototype.sort(function (a, b) { ... });</p>
                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
        String idCharts="main";  
        public String height = "500px";
        public String width = "800px";
        
        Object[][] dataValuesX={
                {"Access",60,30},
                {"Consultation",40,10},
                {"Order",20,5},
                {"Click",80,50},
                {"Display",100,80},
        };

        String[] legendDataName=new String[dataValuesX.length];
        for (int i = 0; i &lt; dataValuesX.length; i++) {
        legendDataName[i]=dataValuesX[i][0].toString();
        }

        String chartTitle="Grafico de embudo";
        String[] serieCategoryName={"Esperado", "Real"};
        String[] serieLabelPosition={"outside", "inside"};
        double[] serieItemStyleOpacy={0.7, 0.5};

        String[] serieLabelFormatter={"{b}", "{c}%"};
        String[] serieSort={"ascending", "ascending"};/*ascending,descending*/
        String[] serieSortX={"ascending", "descending"};/*ascending,descending*/
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
&lt;echar:echartFunnel idCharts="main1" dataValues="&lt;%=dataValuesX%&gt;" chartTitle="&lt;%=chartTitle%&gt;"
        legendDataName="&lt;%=legendDataName%&gt;" serieCategoryName="&lt;%=serieCategoryName%&gt;" serieSort="&lt;%=serieSort%&gt;" /&gt;
&lt;/body&gt;
&lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result Funnel Chart</h5>
                      <img src="<%=request.getContextPath()%>/webdocument/funnel.png" class="card-img" alt="Bar Chart">
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
