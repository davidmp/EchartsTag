<%-- 
    Document   : Scatter
    Created on : Apr 6, 2020, 6:07:00 AM
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
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">Scatter Chart</a>
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
                    <button type="button" class="btn btn-secondary btn-lg btn-block">Scatter Chart elements or attributes</button>
                    
                    
                    <h5 class="card-title">idCharts</h5>
                    <p class="card-text">idCharts, not specified by default; it is of type string in Java, it must be used to refer to the ID of the Div tag where the graphic will be printed, and it must be unique on the same screen..</p>
                    <h5 class="card-title">height</h5>
                    <p class="card-text">height is the height of the chart; it can take a value in the following format: "500px".</p>
                    <h5 class="card-title">width</h5>
                    <p class="card-text">width is the width of the chart; it can take a value in the following format: "800px".</p>
                    <h5 class="card-title">dataValuesM</h5>
                    <p class="card-text">dataValuesM ​​is an attribute of type Vector Object; dataValues ​​must contain one or more decimal type vectors.</p>
                    <h5 class="card-title">chartLegendNames</h5>
                    <p class="card-text">chartLegendNames is a vector string type attribute, which stores the names of the labels.</p>
                    <h5 class="card-title">seriesSymbol</h5>
                    <p class="card-text">seriesSymbol, provides the symbols for the chart and can take the following values: 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow', 'none'</p>
                    <h5 class="card-title">seriesLabelColor</h5>
                    <p class="card-text">seriesLabelColor, is text color, can take for example the following value: back, red, etc.</p>
                    <h5 class="card-title">seriesItemStyleOpacy</h5>
                    <p class="card-text">seriesItemStyleOpacy is Opacity of the component. Supports value from 0 to 1, and the component will not be drawn when set to 0.</p>
                    <h5 class="card-title">seriesLabelShow</h5>
                    <p class="card-text">seriesLabelShow, allows showing the label if it is placed true.</p>


                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
        String idCharts="main";  
        public String height = "500px";
        public String width = "800px";
Object[][] dataValues1={
            {2.239,0.187,0.006},
            {0.367,2.66,1.364},
            {3.912,0.355,0.365},
            {4.737,3.113,0.866},
            {4.783,1.103,0.674},
            {0.188,2.602,0.392},
            {3.784,3.226,0.041},
            {3.293,4.566,0.72},
            {1.911,2.145,1.888},
            {2.784,2.161,1.512},
            {1.63,4.516,1.204},
            {4.141,1.011,1.523},
            {2.818,2.283,0.368},
            {3.274,0.706,0.109},
            {1.107,2.935,1.009},
            {4.877,3.676,1.338},
            {2.495,3.563,0.262},
            {0.06,0.408,0.882},
            {3.077,3.115,0.778},
            {1.655,0.123,0.025},
            {4.001,4.863,0.014},
            {2.626,3.053,0.673},
            {1.987,1.196,1.527},
            {1.578,4.331,0.153},
            {1.431,2.94,0.803},
            {3.178,0.896,1.212},
            {2.385,3.773,1.593},
            {4.342,0.761,1.573},
            {4.014,4.492,0.679},
            {1.225,3.773,1.11},
            {0.586,1.85,0.598},
            {2.437,3.175,0.449},
            {3.515,4.868,1.243},
            {2.601,0.224,1.214},
            {2.116,1.802,0.845},
            {1.903,1.953,0.578},
            {1.562,3.361,0.638},
            {1.406,2.171,0.746},
            {0.249,3.083,1.83},
            {2.539,2.63,1.355},
            {0.06,0.288,1.577},
            {4.626,1.507,1.441},
            {4.497,2.133,0.717},
            {4.157,4.74,1.382},
            {3.738,2.407,0.281},
            {3.622,1.62,0.826},
            {2.026,3.494,0.178},
            {1.145,3.91,1.981},
            {0.479,2.819,0.822},
            {4.998,2.716,0.125}	
            };
Object[][] dataValues2={
            {4.193,6.02,0.39},
            {0.5,7.031,1.013},
            {4.045,6.654,1.29},
            {2.363,5.768,1.175},
            {6.891,9.8,0.079},
            {3.854,5.031,1.23},
            {4.415,0.616,1.747},
            {6.719,6.149,1.42},
            {3.11,7.352,0.416},
            {9.098,6.961,0.338},
            {9.27,9.437,0.042},
            {0.288,2.266,1.915},
            {8.708,0.511,0.612},
            {9.973,6.068,0.659},
            {6.203,5.371,0.861},
            {1.569,1.911,1.943},
            {4.486,6.357,0.724},
            {7.554,1.34,1.187},
            {5.377,5.665,1.531},
            {6.442,5.63,1.451},
            {6.221,7.638,1.185},
            {6.765,0.639,0.669},
            {8.833,6.749,1.674},
            {9.478,7.652,1.847},
            {9.198,1.602,0.317},
            {0.504,3.881,1.39},
            {1.885,3.928,1.657},
            {7.8,7.11,1.355},
            {6.628,0.713,1.457},
            {1.84,6.453,1.226},
            {9.009,0.051,0.118},
            {2.534,4.667,0.19},
            {7.288,0.482,1.396},
            {3.615,2.165,1.774},
            {1.569,3.967,1.574},
            {7.707,0.803,1.26},
            {1.703,6.205,0.018},
            {9.436,0.405,1.661},
            {4.92,0.453,1.668},
            {7.684,5.678,1.028},
            {6.637,3.873,1.987},
            {7.687,2.154,0.94},
            {5.47,9.958,0.967},
            {4.661,8.326,0.24},
            {7.722,1.58,0.724},
            {6.345,6.132,1.486},
            {7.673,7.928,1.896},
            {9.07,5.811,0.722},
            {8.885,1.778,0.625},
            {2.138,2.229,1.084}	
            };

Object[][] dataValues3={
            {3.345,7.735,1.629},
            {10.08,4.406,0.885},
            {6.387,2.871,0.258},
            {12.407,4.023,0.486},
            {14.794,7.067,0.039},
            {11.816,6.526,0.013},
            {1.753,6.408,0.297},
            {9.376,9.56,1.297},
            {5.365,4.03,1.345},
            {13.693,9.021,1.98},
            {3.841,5.988,1.693},
            {14.944,2.869,1.179},
            {5.848,0.895,1.854},
            {9.435,9.878,0.29},
            {11.794,9.43,0.765},
            {5.248,0.779,0.578},
            {10.809,6.861,1.009},
            {9.674,9.03,1.006},
            {0.286,7.791,0.264},
            {1.66,1.335,0.068},
            {11.515,9.969,0.84},
            {14.161,4.125,1.767},
            {4.127,1.808,1.838},
            {11.945,8.18,1.979},
            {0.447,8.891,0.97},
            {1.759,3.748,0.575},
            {13.509,5.583,0.438},
            {10.012,0.192,1.372},
            {9.633,3.97,0.203},
            {4.906,3.8,0.99},
            {0.284,8.446,0.745},
            {8.675,6.975,1.076},
            {8.566,8.377,0.582},
            {5.109,2.879,1.114},
            {11.621,6.203,0.118},
            {13.909,0.064,1.851},
            {6.581,3.274,1.455},
            {6.787,2.97,1.045},
            {7.579,5.533,1.627},
            {0.253,7.1,1.946},
            {13.401,8.44,1.031},
            {11.001,6.52,0.77},
            {6.934,6.421,1.451},
            {5.861,5.936,1.273},
            {6.25,3.065,1.274},
            {5.243,1.564,1.563},
            {10.908,8.376,1.108},
            {6.444,6.662,1.863},
            {14.845,3.094,1.416},
            {3.484,2.867,0.918}	
            };

Object[] dataValuesM={dataValues1,dataValues2,dataValues3};
String[]  chartLegendNames=new String[dataValuesM.length];
chartLegendNames[0]="diamond, red, show inside label only on hover";
chartLegendNames[1]="green, show top label only on hover";
chartLegendNames[2]="indigo, show inside label on normal";

String[] seriesSymbol={"diamond","circle","circle"};//'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow', 'none'
String[] seriesLabelColor={"black","black","white"};
double[] seriesItemStyleOpacy={0.8,0.6,0.8};
boolean[] seriesLabelShow={false,false,true};
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
&lt;echar:echartScatter idCharts="main" chartLegendNames="&lt;%=chartLegendNames%&gt;" dataValuesM="&lt;%=dataValuesM%&gt;" /&gt;
&lt;/body&gt;
&lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result Scatter Chart</h5>
                      <img src="<%=request.getContextPath()%>/webdocument/scatter.png" class="card-img" alt="Bar Chart">
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