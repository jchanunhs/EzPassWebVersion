package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CreateProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Ez Pass Web Application</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/styles/content.css\">\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/images/favicon.ico\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta name=\"author\" content=\"Jason Chan\">\r\n");
      out.write("        <meta name=\"description\" content=\"Web implementation of the EzPassApplication\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("            <header>Ez Pass Web Application</header>\r\n");
      out.write("            <div id =\"content-wrapper\">\r\n");
      out.write("                <nav>\r\n");
      out.write("                    <div id = \"navtitle\">Website Directories</div>\r\n");
      out.write("                </nav>\r\n");
      out.write("                <main> \r\n");
      out.write("                    <h1 align =\"center\">Customer Profile</h1>\r\n");
      out.write("                    <form name=\"CreateProfile\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CreateProfileControl\" method=\"post\">\r\n");
      out.write("                        <label for=\"Name\">Customer Name:</label>\r\n");
      out.write("                        <input type=\"text\" name=\"Name\" value=\"");
      out.print((String) session.getAttribute("Name"));
      out.write("\"readonly><br>\r\n");
      out.write("                        <label for=\"Street\">Street:</label>\r\n");
      out.write("                        <input type=\"text\" name=\"Street\"><br>\r\n");
      out.write("                        <label for=\"City\">City:</label>\r\n");
      out.write("                        <input type=\"text\" name=\"City\"><br>\r\n");
      out.write("                        <label for=\"State\">State:</label>\r\n");
      out.write("                        <input type=\"text\" name=\"State\"><br>                                  \r\n");
      out.write("                        <label for=\"Zip\">Zip:</label>\r\n");
      out.write("                        <input type=\"text\" name=\"Zip\"><br>\r\n");
      out.write("                        <label for=\"Phone\">Phone:</label>\r\n");
      out.write("                        <input type=\"text\" name=\"Phone\"><br>\r\n");
      out.write("                        <label for=\"Email\">Email:</label>\r\n");
      out.write("                        <input type=\"text\" name=\"Email\"><br> \r\n");
      out.write("                        <input type=\"button\" value=\"Create Profile\" onClick=\"checkInputs()\">\r\n");
      out.write("                        <input type=\"reset\" value=\"Reset\">\r\n");
      out.write("                    </form>                              \r\n");
      out.write("                    <div id = \"date\"> </div>\r\n");
      out.write("                </main>\r\n");
      out.write("            </div>\r\n");
      out.write("            <footer><small><em>\r\n");
      out.write("                        Copyright © 2020 EzPassWebApplication<br>\r\n");
      out.write("                        <a href = \"mailto:jchanunh@student.fdu.edu\">jchanunh@student.fdu.edu</a>\r\n");
      out.write("                    </em></small></footer>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script language=\"JavaScript\">\r\n");
      out.write("\r\n");
      out.write("            function checkInputs()\r\n");
      out.write("            {\r\n");
      out.write("                Name = document.CreateProfile.Name.value;\r\n");
      out.write("                Street = document.CreateProfile.Street.value;\r\n");
      out.write("                City = document.CreateProfile.City.value;\r\n");
      out.write("                State = document.CreateProfile.State.value;\r\n");
      out.write("                Zip = document.CreateProfile.Zip.value;\r\n");
      out.write("                Phone = document.CreateProfile.Phone.value;\r\n");
      out.write("                Email = document.CreateProfile.Email.value;\r\n");
      out.write("                if (Name == \"\" || Street == \"\" || City == \"\" || State == \"\" || Zip == \"\" || Phone == \"\" || Email == \"\") {\r\n");
      out.write("                    window.alert(\"One or more fields are empty! Please fill out all information!\");\r\n");
      out.write("                } else {\r\n");
      out.write("                    document.CreateProfile.submit();\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("        <script>\r\n");
      out.write("            var d = new Date();\r\n");
      out.write("            document.getElementById(\"date\").innerHTML = d;\r\n");
      out.write("        </script>\r\n");
      out.write("    </body> \r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
