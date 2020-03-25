
package pe.com.syscenterlife.echarts;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author davidmp
 */
public class ChartHeadTag extends TagSupport {

    @Getter
    @Setter
    String nivelFile = "0";
    @Getter
    @Setter    
    private transient Object[] depencyNames;
    String theme="default";
    String lang="es";
    private  static  final String NAMETHEME="echarts.theme.name";
    private  static  final String NAMELANG="echarts.lang.name";
    protected  static  final Logger logger = Logger.getLogger(ChartHeadTag.class.getName());
    private transient ReadProperties readProp;
    private transient PageContext pageContextR;
    public ChartHeadTag() {
        readProp = new ReadProperties("syscenterlife.properties");
    }
    public ChartHeadTag(PageContext pageContextxx) {
     pageContextR=pageContextxx;
    }    
    private void captureTheme(){
        try {
            if(!readProp.getPathFileDefault().getProperty(NAMETHEME).equals("") && readProp.getPathFileDefault().getProperty(NAMETHEME)!=null){
            theme=readProp.getPathFileDefault().getProperty(NAMETHEME);
            ((HttpServletRequest)pageContextR.getRequest()).getSession().setAttribute("echartstheme", theme);
            } 
        } catch (Exception e) {
            logger.info("No existe el nombre de variable de Properties "+e.getMessage());
        }
    }
    private void captureLang(){
        try {
            if(!readProp.getPathFileDefault().getProperty(NAMELANG).equals("") && readProp.getPathFileDefault().getProperty(NAMELANG)!=null){
            lang=readProp.getPathFileDefault().getProperty(NAMELANG);
            ((HttpServletRequest)pageContextR.getRequest()).getSession().setAttribute("echartslang", lang);
            } else if(readProp.getPathFileDefault().getProperty(NAMELANG).equals("")){
            lang="";
            }
        } catch (Exception e) {            
            logger.info("No existe el nombre de variable de Properties "+e.getMessage());
        }
    }
    
    
    @Override
    public int doStartTag() throws JspException {                
        captureTheme();   
        captureLang();
        StringBuilder sb = new StringBuilder();
        sb.append("<!--\n"
                + "Copyright (C) 2019 David Mamani Pari - SyscenterLife (Cel. 951782520 - \n"
                + "Email: mamanipari@gmail.com)\n"
                + "\n"
                + "Permission is hereby granted, under the license of Apache, Version 2.0 \n"
                + "(the \"License\"); You may not use this file, except in compliance with \n"
                + "the License. You can obtain a copy of the license at:\n"
                + "\n"
                + "  http://www.apache.org/licenses/LICENSE-2.0\n"
                + "\n"
                + "Unless required by applicable law or agreed to in writing,\n"
                + "software distributed under the License is distributed on an\n"
                + "\"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY\n"
                + "KIND, either express or implied.  See the License for the\n"
                + "specific language governing permissions and limitations\n"
                + "under the License.\n"
                + "\n"
                + "The above copyright notice and this permission notice will be included \n"
                + "in all copies or substantial portions of the Software.\n"
                + "\n"
                + "1.- Licensed to the Apache Software Foundation (ASF) under one\n"
                + "or more contributor license agreements.  See the NOTICE file\n"
                + "distributed with this work for additional information\n"
                + "regarding copyright ownership.  The ASF licenses this file\n"
                + "to you under the Apache License, Version 2.0 (the\n"
                + "\"License\"); you may not use this file except in compliance\n"
                + "with the License.  You may obtain a copy of the License at\n"
                + "\n"
                + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                + "\n"
                + "Unless required by applicable law or agreed to in writing,\n"
                + "software distributed under the License is distributed on an\n"
                + "\"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY\n"
                + "KIND, either express or implied.  See the License for the\n"
                + "specific language governing permissions and limitations\n"
                + "under the License.\n"
                + "\n"
                + "2.- Copyright (C) 2009-2015 The Project Lombok Authors.\n"
                + "\n"
                + "Permission is hereby granted, free of charge, to any person obtaining a copy\n"
                + "of this software and associated documentation files (the \"Software\"), to deal\n"
                + "in the Software without restriction, including without limitation the rights\n"
                + "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n"
                + "copies of the Software, and to permit persons to whom the Software is\n"
                + "furnished to do so, subject to the following conditions:\n"
                + "\n"
                + "The above copyright notice and this permission notice shall be included in\n"
                + "all copies or substantial portions of the Software.\n"
                + "\n"
                + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n"
                + "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n"
                + "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n"
                + "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n"
                + "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n"
                + "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN\n"
                + "THE SOFTWARE.\n"
                + "-->");
        try {

            String urlcontex = ((HttpServletRequest) pageContextR.getRequest()).getContextPath();
            pageContextR.getOut().append(sb); 
            

            if(lang.charAt(0)!='-'){
            lang="-"+lang;
            }
            
            StringBuilder scripts = new StringBuilder();
            scripts.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + urlcontex + "/webjars/syscenterlife/echarts/1.1.0/css/style.css\" />\n"
                    + "<!--[if lt IE 9]> \n"
                    + "<script async src=\"https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js\"></script>\n"
                    + "<![endif]-->                	\n"
                    + "<script  src=\"" + urlcontex + "/webjars/syscenterlife/echarts/1.1.0/js/echarts" + lang + ".min.js\"></script>\n"
                    + "<script src=\"" + urlcontex + "/webjars/syscenterlife/echarts/1.1.0/3d/js/echarts-gl.min.js\"></script>\n"
                    
                    + "<script   src=\"" + urlcontex + "/webjars/syscenterlife/echarts/1.1.0/themes/" + theme + ".js\"></script>\n"
                    
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />");
            
            pageContextR.getOut().append(scripts); 

            StringBuilder scriptsAditionals = new StringBuilder();
            if(depencyNames!=null){
                if(depencyNames.length>0){
                    for (Object depencyName : depencyNames) {
                        switch (depencyName.toString()) {
                            case "Boxplot": scriptsAditionals.append("<script src=\"" + urlcontex + "/webjars/syscenterlife/echarts/1.1.0/extension/dataTool.min.js\"></script>\n"); break;
                            default: scriptsAditionals.append(""); break;
                        }
                    }
                }
            }
            pageContextR.getOut().append(scriptsAditionals); 
            
        } catch (IOException e) {
            logger.info("Error en generar llamar librerias de JavaScript: "+e.getMessage());
        }
        return SKIP_BODY; //PUEDE SER 0
    }
}
