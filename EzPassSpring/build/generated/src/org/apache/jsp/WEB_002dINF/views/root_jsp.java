package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class root_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <header>Ez Pass Web Application</header>\n");
      out.write("            <div id =\"content-wrapper\">\n");
      out.write("                <nav>\n");
      out.write("                    <div id = \"navtitle\">Website Directories</div>\n");
      out.write("                    <a href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/index\">Login</a>\n");
      out.write("                    <a href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/SignUp\">Sign Up</a>\n");
      out.write("                    <a href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/faq\">FAQ</a>\n");
      out.write("                </nav>\n");
      out.write("                <main> \n");
      out.write("                    <h1 align =\"center\">Welcome to My Ez Pass Application!</h1>\n");
      out.write("                    <div class=\"imgcontainer\">\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/images/ezpassonly.jpg\" alt=\"EzOnlyLogo\" class=\"imgoverlay\">\n");
      out.write("                        <div class=\"overlay\">Make your toll experience easier!</div>\n");
      out.write("                    </div>\n");
      out.write("                    <h2>How it works</h2>\n");
      out.write("                    <ol>\n");
      out.write("                        <li>Sign up for your account by clicking on the SignUp link in the side bar or <a href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/SignUp\">click here.</a></li>\n");
      out.write("                        <li><a href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/index\">Login</a> to your account and create your profile.</li>\n");
      out.write("                        <li>Add your Ez Tag and link a vehicle to that Ez Tag</li>\n");
      out.write("                        <li>You're all set! Now you can pay tolls using your Ez Pass. <br>\n");
      out.write("                            Note: Make sure you remember to recharge your account when the balance is low.</li>\n");
      out.write("                    </ol>\n");
      out.write("                    <h2>Keep in mind</h2>\n");
      out.write("                    <ul>\n");
      out.write("                        <li>A vehicle can only have one Ez Tag linked to it.</li>\n");
      out.write("                        <li>An Ez Tag can have multiple vehicles linked to it</li>\n");
      out.write("                        <li>An Ez Tag may not be removed if it has been used to pay tolls or is linked to a vehicle.</li>\n");
      out.write("                        <li>If you need assistance with changing your address or changing your Tag Code/Type, please contact help desk for support.</li>\n");
      out.write("                    </ul>\n");
      out.write("                    <div id = \"date\"> </div>\n");
      out.write("                </main>\n");
      out.write("            </div>\n");
      out.write("            <footer><small><em>\n");
      out.write("                        Copyright © 2020 EzPassWebApplication<br>\n");
      out.write("                        <a href = \"mailto:jchanunh@student.fdu.edu\">jchanunh@student.fdu.edu</a>\n");
      out.write("                    </em></small></footer>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            clock();\n");
      out.write("            setInterval(clock, 1000);\n");
      out.write("            function clock() {\n");
      out.write("                var d = new Date();\n");
      out.write("                var dateString = d.toLocaleDateString();\n");
      out.write("                var timeString = d.toLocaleTimeString();\n");
      out.write("                var clockString = \"Date and Time: \" + dateString + \" at \" + timeString;\n");
      out.write("                document.getElementById(\"date\").innerHTML = clockString;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body> \n");
      out.write("</html>");
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
