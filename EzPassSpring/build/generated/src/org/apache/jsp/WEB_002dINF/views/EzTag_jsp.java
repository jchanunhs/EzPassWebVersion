package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.EzTag;

public final class EzTag_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

EzTag ez = new EzTag((String) session.getAttribute("CID"));
    ArrayList<String> ez_list = ez.getTags();
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <title>Ez Pass Web Application</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/styles/content.css\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/images/favicon.ico\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"author\" content=\"Jason Chan\">\n");
      out.write("        <meta name=\"description\" content=\"Web implementation of the EzPassApplication\">\n");
      out.write("        <link href=\"jquery-ui-1.12.1/jquery-ui.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"jquery-ui-1.12.1/external/jquery/jquery.js\"></script>\n");
      out.write("        <script src=\"jquery-ui-1.12.1/jquery-ui.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#tabs\").tabs();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("            <header>Ez Pass Web Application</header>\n");
      out.write("\n");
      out.write("            <div class = \"flexHorizontal\">\n");
      out.write("\n");
      out.write("                <aside>\n");
      out.write("                    <div class = \"flexVertical\">\n");
      out.write("                        <div class = \"links\">Website Directories</div>\n");
      out.write("                        <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Main'>Profile</a>\n");
      out.write("                        <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Vehicle'>Vehicle</a>\n");
      out.write("                        <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/EzTag'class = \"active-link\">EzTags</a>\n");
      out.write("                        <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/PayTolls'>Pay Tolls</a>\n");
      out.write("                        <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Transactions'>Transactions</a>\n");
      out.write("                    </div>\n");
      out.write("                </aside>               \n");
      out.write("\n");
      out.write("                <main> \n");
      out.write("                    <h1 align =\"center\">Ez Tags</h1>\n");
      out.write("\n");
      out.write("                    <div id = \"tabs\">\n");
      out.write("                        <ul>\n");
      out.write("                            <l1><a href =\"#tabs-1\">Your Ez Tags</a></l1>\n");
      out.write("                            <l1><a href =\"#tabs-2\">Add Tags</a></l1>\n");
      out.write("                            <l1><a href =\"#tabs-3\">Remove Tags</a></l1>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                        <div id=\"tabs-1\">\n");
      out.write("                            <table>\n");
      out.write("                                <tr><th>Your Ez Tags</th></tr>\n");
      out.write("                                        ");
for (int i = 0; i < ez_list.size(); i++) {
                                        
      out.write("\n");
      out.write("                                <tr><td>");
      out.print(ez_list.get(i));
      out.write("</td></tr>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div align=\"center\">    \n");
      out.write("                        <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/AddTag'>Add EzTags</a>\n");
      out.write("                        <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/RemoveTag'>Remove EzTags</a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div id = \"date\"> </div>\n");
      out.write("\n");
      out.write("                </main>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <footer><small><em>\n");
      out.write("                        Copyright © 2020 EzPassWebApplication<br>\n");
      out.write("                        <a href = \"mailto:jchanunh@student.fdu.edu\">jchanunh@student.fdu.edu</a>\n");
      out.write("                    </em></small></footer>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            var d = new Date();\n");
      out.write("            document.getElementById(\"date\").innerHTML = d;\n");
      out.write("        </script>  \n");
      out.write("\n");
      out.write("    </body> \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
