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

        <div class="content">
            
            <div class="list-group">
              <a href="#" class="list-group-item list-group-item-info">
                EchartsTag de 2 Dimensiones
              </a>
                    <a type="button" class="btn btn-outline-warning btn-lg btn-block" id="2DBar" href="Bar.jsp" >Bar Chart</a>
                    <a type="button" class="btn btn-outline-warning btn-lg btn-block" id="2DBarSimple" href="BarSimple.jsp" >BarSim Chart</a>
                    <a type="button" class="btn btn-outline-info btn-lg btn-block" id="2DBoxplot" href="Boxplot.jsp" >Boxplot Chart</a>
                    <a type="button" class="btn btn-outline-warning btn-lg btn-block" id="2DFunnel" href="Funnel.jsp" >Funnel Chart</a>
                    <a type="button" class="btn btn-outline-info btn-lg btn-block" id="2DLine" href="Line.jsp" >Line</a>
                    <a type="button" class="btn btn-outline-info btn-lg btn-block" id="2DLineArea" href="LineArea.jsp" >Area Chart</a>
                    <a type="button" class="btn btn-outline-warning btn-lg btn-block" id="2DPie" href="Pie.jsp" >Pie Chart</a>
                    <a type="button" class="btn btn-outline-info btn-lg btn-block" id="2DRadar" href="Radar.jsp" >Radar Chart</a>
                    <a type="button" class="btn btn-outline-info btn-lg btn-block" id="2DRadarSimple" href="RadarOpc2.jsp" >RadarSim Chart</a>
                    <a type="button" class="btn btn-outline-info btn-lg btn-block" id="2DRadarMultiple" href="RadarMultiple.jsp" >RadarMul Chart</a>
                    <a type="button" class="btn btn-outline-warning btn-lg btn-block" id="2DScatter" href="Scatter.jsp" >Scatter Chart</a>
            </div>  
           
            
            
            
            <div class="list-group">
              <a href="#" class="list-group-item list-group-item-info">
                EchartsTag de 3 Dimensiones
              </a>
                    <a type="button" class="btn btn-outline-warning btn-lg btn-block" id="3DBar" href="Bar3D.jsp" >Bar Chart</a>
                    <a type="button" class="btn btn-outline-warning btn-lg btn-block" id="3DBarStack" href="BarStack3D.jsp" >Bar Stack Chart</a>
                    <a type="button" class="btn btn-outline-warning btn-lg btn-block" id="3DBarSimple" href="BarSimple3D.jsp" >BarSim Chart</a>

                    <a type="button" class="btn btn-outline-info btn-lg btn-block" id="3DGrid" href="Grid3D.jsp" >Grid Chart</a>
                    <a type="button" class="btn btn-outline-warning btn-lg btn-block" id="3DLine" href="Line3D.jsp" >Line Chart</a>
                    <a type="button" class="btn btn-outline-info btn-lg btn-block" id="3DScatter" href="Scatter3D.jsp" >Scatter Chart</a>        
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
  

</body></html>