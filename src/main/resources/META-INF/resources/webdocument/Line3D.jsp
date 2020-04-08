<%-- 
    Document   : Line3D
    Created on : Apr 6, 2020, 10:02:08 AM
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
                      <a class="nav-link active" href="#description" role="tab" aria-controls="description" aria-selected="true">Line3D Chart</a>
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
                    <button type="button" class="btn btn-secondary btn-lg btn-block">Line3D Chart elements or attributes</button>
                    
                    <h5 class="card-title">idCharts</h5>
                    <p class="card-text">idCharts, not specified by default; it is of type string in Java, it must be used to refer to the ID of the Div tag where the graphic will be printed, and it must be unique on the same screen..</p>
                    <h5 class="card-title">height</h5>
                    <p class="card-text">height is the height of the chart; it can take a value in the following format: "500px".</p>
                    <h5 class="card-title">width</h5>
                    <p class="card-text">width is the width of the chart; it can take a value in the following format: "800px".</p>
                    <h5 class="card-title">dataValues</h5>
                    <p class="card-text">dataValues ​​is an attribute of type JSONArray, which stores the data of the chart.</p>

                    <h5 class="card-title">seriesTypeEchart</h5>
                    <p class="card-text">seriesTypeEchart, is of type string and can take the following values: line3D,surface,scatter3D,bar3D</p>
                    <h5 class="card-title">seriaLineStyle</h5>
                    <p class="card-text">seriaLineStyle is The width of the line.</p>
                    <h5 class="card-title">visualMapMinMax</h5>
                    <p class="card-text">visualMapMinMax, can take a numerical value, which indicates the level of color intensity.</p>

                    </div>

                    <div class="tab-pane" id="example" role="tabpanel" aria-labelledby="history-tab">  
                      <h5 class="card-title">Code Java</h5>
        <div class="content">
        <pre class="prettyprint highlight"><code class="language-java" data-lang="java">
String idCharts="main";  
public String height = "500px";
public String width = "800px";
          
Object[][] data={{1.25,0,0},
{1.2492965798795,0.00124929699631186,0.150859414545484},
{1.2471902750993,0.00249438387604466,0.300876264947198},
{1.24369293012806,0.00373108998366085,0.44921272426349},
{1.23882421162163,0.00495532327490553,0.595040413322679},
{1.23261149767385,0.00616310884769529,0.737545058172095},
{1.22508972364236,0.00735062654958448,0.87593106822246},
{1.21630118541827,0.0085142473644225,1.00942600934759},
{1.20629530124838,0.00965056828965564,1.13728494679007},
{1.19512833345196,0.0107564454266624,1.25879463345539},
{1.18286307160047,0.0118290250194674,1.37327752004666},
{1.16956847894538,0.0128657721920636,1.48009556449315},
{1.1553193040865,0.0138644971512901,1.57865381925496},
{1.14019566006919,0.0148233786406379,1.66840377633451},
{1.12428257328202,0.0157409844503705,1.74884645118803},
{1.10766950469686,0.0166162888108075,1.81953518819819},
{1.09044984614903,0.0174486865183795,1.88007817193445},
{1.07272039449577,0.0182380036679658,1.93014063008197},
{1.05458080661586,0.0189845048899021,1.96944671565331},
{1.03613303832118,0.0196888970157315,1.99778105790059},
{1.01748077034131,0.0203523291230759,2.0149899732081},
{0.99872882461537,0.020976388936756,2.0209823291576},
{0.979982574179533,0.0215630955902942,2.01573005690783},
{0.961347349974705,0.0221148887790054,1.99926830900781},
{0.942927847916085,0.0226346143628333,1.97169526175638},
{0.9248275395647,0.0231255065037266,1.93317156321938},
{0.907148089720582,0.0235911664484924,1.88391943000773},
{0.889988784218055,0.0240355380935188,1.82422139789485},
{0.873445971146006,0.0244628804923541,1.75441873329774},
{0.857612518640151,0.0248777374906845,1.67490951455305},
{0.842577292300802,0.0252849046956,1.58614639377584},
{0.828424655178862,0.025689394007022,1.48863405188475},
{0.815233993145422,0.0260963959586234,1.38292636110229},
{0.803079268317168,0.0265112401333793,1.26962327088369},
{0.792028603051518,0.0269393539348899,1.14936743478283},
{0.782143896852998,0.0273862200097198,1.02284059722017},
{0.773480478346755,0.0278573326280762,0.890759760467656},
{0.766086794277362,0.0283581533401183,0.753873153401056},
{0.760004137282293,0.0288940662329705,0.612956024685085},
{0.755266413970811,0.0294703331190364,0.468806284043369},
{0.751899954611794,0.0300920489894303,0.32224001611973},
{0.74992336549945,0.0307640980672257,0.174086892153438},
{0.749347424825285,0.0314911107937471,0.0251855052656983},
{0.750175022639482,0.032277422077294,-0.123621344415943},
{0.752401145236335,0.0331270311275128,-0.271491388286501},
{0.756012904048026,0.0340435631901326,-0.417587624804048},
{0.760989608880226,0.0350302334860191,-0.561083025416862},
{0.767302885073127,0.0360898136455254,-0.701165184418801},
{0.774916833924036,0.0372246009140121,-0.837040886589709},
{0.783788235463941,0.038436390387258,-0.967940566939944},
{0.793866792441863,0.0397264505164001,-1.09312263748469},
{0.805095414138709,0.041095502101134,-1.21187765672139},
{0.817410538408037,0.0425437009673194,-1.32353231836795},
{0.83074249012588,0.0440706245010012,-1.42745323693557},
{0.845015874026796,0.0456752621853401,-1.52305050885239},
{0.860149999709728,0.0473560102602024,-1.60978102911597},
{0.876059336416249,0.0491106705963731,-1.68715154482717},
{0.892653995016198,0.0509364538477,-1.75472142843738},
{0.909840234482715,0.0528299869151459,-1.8121051551169},
{0.927520990000964,0.0547873247269141,-1.85897447031574},
{0.945596419733235,0.0568039663087179,-1.89506023533019},
{0.963964467158346,0.0588748750880856,-1.92015394049843},
{0.98252143581584,0.0609945033465447,-1.93410887751775},
{1.00116257321594,0.0631568207037994,-1.936840964292},
{1.01978266062503,0.0653553464888235,-1.92832921767168},
{1.03827660540353,0.0675831858243268,-1.90861587142888},
{1.05654003255934,0.0698330692235185,-1.87780613880363},
{1.07446987218465,0.0720973954716791,-1.83606762095682},
{1.09196493946755,0.074368277539946,-1.78362936465546},
{1.10892650401233,0.0766375912550974,-1.72078057448844},
{1.12525884526272,0.0788970264271562,-1.64786898685318},
{1.14086979090141,0.0811381401164858,-1.56529891485503},
{1.15567123519526,0.0833524117038653,-1.47352897511196},
{1.1695796343691,0.0855312994109509,-1.37306950924512},
{1.18251647622113,0.0876662979046692,-1.26447971455251},
{1.1944087213379,0.0897489966075704,-1.14836449999845},
{1.20518921342796,0.0917711383270743,-1.02537108519526},
{1.21479705646705,0.0937246778099629,-0.896185361499201},
{1.22317795653548,0.0956018398244679,-0.761528035679711},
{1.23028452642729,0.0973951763709159,-0.622150577843827},
{1.23607655132115,0.0990976226231619,-0.478830996397843},
{1.24052121402246,0.100702551206978,-0.332369463801037},
{1.2435932785141,0.102203824428161,-0.183583817705024},
{1.24527523078862,0.103595844072343,-0.0333049627729667},
{1.24555737617545,0.104873598410362,0.117627800968708},
{1.24443789262177,0.10603270605738,0.268371496980364},
{1.24192283963436,0.107069456350836,0.418084211729923},
{1.23802612283936,0.107980845931523,0.565929828237008},
{1.23276941436699,0.108764611233593,0.711082727026765},
{1.22618202951735,0.109419256612976,0.852732428062895}};
 
String seriesTypeEchart="scatter3D";  /*line3D,surface,scatter3D,bar3D*/
int[] visualMapMinMax={0,30};
int SeriaLineStyle=4;

JSONArray dataValues= new JSONArray(data);         
JSONArray visualMapMinMaxX= new JSONArray(visualMapMinMax); 
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
&lt;echar3D:echartLine3D idCharts="main" dataValues="&lt;%=dataValues%&gt;" seriesTypeEchart="scatter3D" width="800px" height="500px" /&gt;
&lt;/body&gt;
&lt;/html&gt;
        </code></pre>
        </div>                        
                      
                    </div>

                    <div class="tab-pane" id="result" role="tabpanel" aria-labelledby="deals-tab">
                      <h5 class="card-title">Result Line3D Chart</h5>
                      <img src="<%=request.getContextPath()%>/webdocument/line3d.png" class="card-img" alt="Bar Chart">
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
