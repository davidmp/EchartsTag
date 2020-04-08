<%-- 
    Document   : Bar3D
    Created on : Apr 6, 2020, 8:08:27 AM
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
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">Bar3D Chart</a>
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
                    <button type="button" class="btn btn-secondary btn-lg btn-block">Bar3D Chart elements or attributes</button>
                    
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
                    <h5 class="card-title">lightIntensity</h5>
                    <p class="card-text">lightIntensity, is the intensity of the ambient light.</p>                    
                    <h5 class="card-title">styleNormalEmphasis</h5>
                    <p class="card-text">styleNormalEmphasis en The opacity of the chart and can take values ​​between 0 to 1.</p>
                    
                    <h5 class="card-title">dataNameEjeX</h5>
                    <p class="card-text">dataNameEjeX takes the value of type Object, to store the values ​​of the X Axis.</p>
                    <h5 class="card-title">dataNameEjeY</h5>
                    <p class="card-text">dataNameEjeY takes the value of type Object, to store the values ​​of the Y Axis.</p>
                                        
                    <h5 class="card-title">echart3DColor</h5>
                    <p class="card-text">echart3DColor, contains the combination of 3 colors for the chart.</p>
                    <h5 class="card-title">dimen3DXY</h5>
                    <p class="card-text">dimen3DXY, contemplates the width and depth of the 3D Cartesian plane</p>
                    
                    <h5 class="card-title">typeAndIntervalEjesXYZ</h5>
                    <p class="card-text">typeAndIntervalEjesXYZ, es The type of the y axis can take the following values:
'value' The axis of the value. Suitable for continuous data.

'category' The category axis. Suitable for discrete category data. For this type, the category data must be established through the data.

'time' The timeline. Suitable for continuous timing data. The time axis has a time format compared to the value axis, and the calculation of the scale is also different. For example, the scale of the month, week, day, and time ranges can be determined according to the range of the interval.

'log' logarithmic axis. Suitable for logarithmic data.</p>
                    

                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
        String idCharts="main";  
        public String height = "500px";
        public String width = "800px";
        
        Object[] dataNameEjeX = {"12a", "1a", "2a", "3a", "4a", "5a", "6a","7a", "8a", "9a","10a","11a","12p", "1p", "2p", "3p", "4p", "5p","6p", "7p", "8p", "9p", "10p", "11p"};
        Object[] dataNameEjeY = {"Domingo", "Lunes", "Martes","Miercoles", "Jueves", "viernes","Sabado"};
        JSONArray dataValues;
        Object[] echart3DColor={"#d94e5d","#eac736","#50a3ba"};
        Object[][] typeAndIntervalEjesXYZ={{"category","category","value"},                 
                                                        {1,0,0}};
        Object[] dimen3DXY={200,80};

        double lightIntensity=0;//0.8
        String seriesTypeEchart="bar3D";  /*bar3D,line3D,surface,scatter3D*/                    
        double[] styleNormalEmphasis={1,1};/*0.4, 0.4*/

        String urlx = request.getContextPath();
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = null;
        String sURL = "jdbc:mysql://localhost:3306/echerts";
        con = DriverManager.getConnection(sURL,"root","");

        LinkedHashMap&lt;String, Object&gt; hmx = new LinkedHashMap&lt;&gt;();

        ArrayList&lt;Object&gt; arrayListG = new ArrayList&lt;&gt;();
        Object[] dataXYZ;  
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM data")) {
        ResultSet rs = stmt.executeQuery();           
        while (rs.next()){
        dataXYZ=new Object[3];            
        dataXYZ[0]=rs.getInt("hora");
        dataXYZ[1]=rs.getInt("dias");
        dataXYZ[2]=rs.getInt("cantidad");            
        arrayListG.add(dataXYZ);
        }

        } catch (SQLException sqle) { 
        System.out.println("Error en la ejecución:" 
        + sqle.getErrorCode() + " " + sqle.getMessage());    
        }
        dataValues = new JSONArray(arrayListG);
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
&lt;echar3D:echartBar3D dataNameEjeX="&lt;%=dataNameEjeX%&gt;" height="200" width="600" dataNameEjeY="&lt;%=dataNameEjeY%&gt;" 
dataValues="&lt;%=dataValues%&gt;" idCharts="main" dimen3DXY="&lt;%=dimen3DXY%&gt;" echart3DColor="&lt;%=echart3DColor%&gt;"
lightIntensity="&lt;%=lightIntensity%&gt;" seriesTypeEchart="&lt;%=seriesTypeEchart%&gt;"  styleNormalEmphasis="&lt;%=styleNormalEmphasis%&gt;"   
typeAndIntervalEjesXYZ="&lt;%=typeAndIntervalEjesXYZ%&gt;"/&gt; 
&lt;/body&gt;
&lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result Bar3D Chart</h5>
                      <img src="<%=request.getContextPath()%>/webdocument/bar3d.png" class="card-img" alt="Bar Chart">
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