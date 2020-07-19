package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

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

ArrayList<String> ez_list = (ArrayList<String>) request.getAttribute("ez_list");
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
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-ui-1.12.1/jquery-ui.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-ui-1.12.1/external/jquery/jquery.js\"></script>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-ui-1.12.1/jquery-ui.min.js\"></script>\n");
      out.write("        <script type = \"text/javascript\">\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#tabs\").tabs();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <header>Ez Pass Web Application</header>\n");
      out.write("            <div id =\"content-wrapper\">\n");
      out.write("                <nav>\n");
      out.write("                    <div id = \"navtitle\">Website Directories</div>\n");
      out.write("                    <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Profile'>Profile</a>\n");
      out.write("                    <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Vehicle'>Vehicle</a>\n");
      out.write("                    <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/EzTag'id = \"active-link\">EzTags</a>\n");
      out.write("                    <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/PayTolls'>Pay Tolls</a>\n");
      out.write("                    <a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Transactions'>Transactions</a>\n");
      out.write("                </nav>               \n");
      out.write("                <main> \n");
      out.write("                    <h1 align =\"center\">Ez Tags</h1>\n");
      out.write("                    <div id =\"tabs\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"#tab-1\">Your EzTags</a></li>\n");
      out.write("                            <li><a href=\"#tab-2\">Add Tag</a></li>\n");
      out.write("                            <li><a href=\"#tab-3\">Remove Tag</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                        <div id = \"tab-1\">\n");
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
      out.write("                        <div id = \"tab-2\">\n");
      out.write("                            <form name=\"AddTag\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/AddTagControl\" method=\"post\">\n");
      out.write("                                <label for=\"CustomerID\">Customer ID:</label>\n");
      out.write("                                <input type=\"text\" name=\"CustomerID\" value=\"");
      out.print(session.getAttribute("CID"));
      out.write("\"readonly><br>\n");
      out.write("                                <label for=\"TagCode\">Tag Code:</label>\n");
      out.write("                                <input type=\"text\" name=\"TagCode\"><br>\n");
      out.write("                                <label for=\"TagType\">Tag Type:</label>\n");
      out.write("                                <select name=\"TagType\">\n");
      out.write("                                    <option value=\"\">Please pick an option</option>\n");
      out.write("                                    <option value=\"Normal\">Normal</option>\n");
      out.write("                                    <option value=\"Express\">Express</option>\n");
      out.write("                                    <option value=\"BancPass\">BancPass</option>\n");
      out.write("                                </select> <br>\n");
      out.write("                                <input type=\"button\" value=\"Add Tag\" onClick=\"checkAddTagInputs()\">\n");
      out.write("                                <input type=\"reset\" value=\"Reset\">\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <div id = \"tab-3\">\n");
      out.write("                            <form name=\"RemoveTag\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/RemoveTagControl\" method=\"post\">\n");
      out.write("                                <label for=\"CustomerID\">Customer ID:</label>\n");
      out.write("                                <input type=\"text\" name=\"CustomerID\" value=\"");
      out.print((String) session.getAttribute("CID"));
      out.write("\"readonly><br>\n");
      out.write("                                <label for=\"TagCode\">Tag Code:</label>\n");
      out.write("                                <input type=\"text\" name=\"TagCode\"><br>\n");
      out.write("                                <input type=\"button\" value=\"Remove Tag\" onClick=\"checkRemoveTagInputs()\">\n");
      out.write("                                <input type=\"reset\" value=\"Reset\">\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
 if (request.getAttribute("message") != null) {
      out.write("\n");
      out.write("                    <div id=\"message\">");
      out.print(request.getAttribute("message"));
      out.write("</div>    \n");
      out.write("                    ");
}
      out.write("  \n");
      out.write("                    <div id = \"date\"> </div>\n");
      out.write("                </main>\n");
      out.write("            </div>\n");
      out.write("            <footer><small><em>\n");
      out.write("                        Copyright © 2020 EzPassWebApplication<br>\n");
      out.write("                        <a href = \"mailto:jchanunh@student.fdu.edu\">jchanunh@student.fdu.edu</a>\n");
      out.write("                    </em></small></footer>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            var d = new Date();\n");
      out.write("            document.getElementById(\"date\").innerHTML = d;\n");
      out.write("            function checkAddTagInputs()\n");
      out.write("            {\n");
      out.write("                TagCode = document.AddTag.TagCode.value;\n");
      out.write("                TagType = document.AddTag.TagType.value;\n");
      out.write("                if (TagCode == \"\" || TagType == \"\") {\n");
      out.write("                    window.alert(\"One or more fields are empty! Please fill out all information!\");\n");
      out.write("                } else {\n");
      out.write("                    document.AddTag.submit();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function checkRemoveTagInputs()\n");
      out.write("            {\n");
      out.write("                TagCode = document.RemoveTag.TagCode.value;\n");
      out.write("                if (TagCode == \"\") {\n");
      out.write("                    window.alert(\"Please enter tag code you wish to remove!\");\n");
      out.write("                } else {\n");
      out.write("                    document.RemoveTag.submit();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>     \n");
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
