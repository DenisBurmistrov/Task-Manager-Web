/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-11 15:21:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ru.burmistrov.TaskManager.entity.Project;
import java.util.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/css/home.css", Long.valueOf(1554900691362L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style>");
      out.write("@import \"https://fonts.googleapis.com/css?family=Montserrat:300,400,700\";\r\n");
      out.write("@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,600,700);\r\n");
      out.write("\r\n");
      out.write(".rwd-table {\r\n");
      out.write("  margin: 5em 20em;\r\n");
      out.write("  min-width: 300px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".rwd-table tr {\r\n");
      out.write("  border-top: 1px solid #ddd;\r\n");
      out.write("  border-bottom: 1px solid #ddd;\r\n");
      out.write("}\r\n");
      out.write(".rwd-table th {\r\n");
      out.write("  display: none;\r\n");
      out.write("}\r\n");
      out.write(".rwd-table td {\r\n");
      out.write("  display: block;\r\n");
      out.write("}\r\n");
      out.write(".rwd-table td:first-child {\r\n");
      out.write("  padding-top: .5em;\r\n");
      out.write("}\r\n");
      out.write(".rwd-table td:last-child {\r\n");
      out.write("  padding-bottom: .5em;\r\n");
      out.write("}\r\n");
      out.write(".rwd-table td:before {\r\n");
      out.write("  content: attr(data-th) \": \";\r\n");
      out.write("  font-weight: bold;\r\n");
      out.write("  width: 6.5em;\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("}\r\n");
      out.write("@media (min-width: 480px) {\r\n");
      out.write("  .rwd-table td:before {\r\n");
      out.write("    display: none;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write(".rwd-table th, .rwd-table td {\r\n");
      out.write("  text-align: left;\r\n");
      out.write("}\r\n");
      out.write("@media (min-width: 480px) {\r\n");
      out.write("  .rwd-table th, .rwd-table td {\r\n");
      out.write("    display: table-cell;\r\n");
      out.write("    padding: .25em .5em;\r\n");
      out.write("  }\r\n");
      out.write("  .rwd-table th:first-child, .rwd-table td:first-child {\r\n");
      out.write("    padding-left: 0;\r\n");
      out.write("  }\r\n");
      out.write("  .rwd-table th:last-child, .rwd-table td:last-child {\r\n");
      out.write("    padding-right: 0;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("  padding: 0 2em;\r\n");
      out.write("  font-family: Montserrat, sans-serif;\r\n");
      out.write("  -webkit-font-smoothing: antialiased;\r\n");
      out.write("  text-rendering: optimizeLegibility;\r\n");
      out.write("  color: #444;\r\n");
      out.write("  background: url(http://hq-wallpapers.ru/wallpapers/10/hq-wallpapers_ru_abstraction3d_49540_1920x1080.jpg);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1 {\r\n");
      out.write("  font-weight: normal;\r\n");
      out.write("  letter-spacing: -1px;\r\n");
      out.write("  color: #34495E;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".rwd-table {\r\n");
      out.write("  background: #34495E;\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  border-radius: .4em;\r\n");
      out.write("  overflow: hidden;\r\n");
      out.write("}\r\n");
      out.write(".rwd-table tr {\r\n");
      out.write("  border-color: #46637f;\r\n");
      out.write("}\r\n");
      out.write(".rwd-table th, .rwd-table td {\r\n");
      out.write("  margin: .5em 1em;\r\n");
      out.write("}\r\n");
      out.write("@media (min-width: 480px) {\r\n");
      out.write("  .rwd-table th, .rwd-table td {\r\n");
      out.write("    padding: 1em !important;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write(".rwd-table th, .rwd-table td:before {\r\n");
      out.write("  color: #efaf8c;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".rwd-table tr:hover {\r\n");
      out.write("   background-color: #464A52;\r\n");
      out.write("-webkit-box-shadow: 0 6px 6px -6px #0E1119;\r\n");
      out.write("\t   -moz-box-shadow: 0 6px 6px -6px #0E1119;\r\n");
      out.write("\t        box-shadow: 0 6px 6px -6px #0E1119;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".rwd-table td:hover {\r\n");
      out.write("  background-color: #987654;\r\n");
      out.write("  color: #403E10;\r\n");
      out.write("  font-weight: bold;\r\n");
      out.write("\r\n");
      out.write("  box-shadow: #654321 -1px 1px, #654321 -2px 2px, #654321 -3px 3px, #654321 -4px 4px, #654321 -5px 5px, #654321 -6px 6px;\r\n");
      out.write("    transform: translate3d(6px, -6px, 0);\r\n");
      out.write("\r\n");
      out.write("    transition-delay: 0s;\r\n");
      out.write("  \t  transition-duration: 0.4s;\r\n");
      out.write("  \t  transition-property: all;\r\n");
      out.write("    transition-timing-function: line;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write(".example_a {\r\n");
      out.write("color: #efaf8c !important;\r\n");
      out.write("text-transform: uppercase;\r\n");
      out.write("background: #34495E;\r\n");
      out.write("padding: 20px;\r\n");
      out.write("border-radius: 5px;\r\n");
      out.write("display: inline-block;\r\n");
      out.write("border: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".example_a:hover {\r\n");
      out.write("background: #434343;\r\n");
      out.write("letter-spacing: 1px;\r\n");
      out.write("-webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);\r\n");
      out.write("-moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);\r\n");
      out.write("box-shadow: 5px 40px -10px rgba(0,0,0,0.57);\r\n");
      out.write("transition: all 0.4s ease 0s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table class=\"rwd-table\">\r\n");
      out.write("<th>Number</th><th>ID</th><th>Name</th><th>Description</th><th>DateBegin</th><th>DateEnd</th><th>Edit</th><th>Remove</th><th>Tasks</th>\r\n");
 int index = 1; 
      out.write("\r\n");
      out.write("    ");
 for (Project project : (List<Project>) request.getAttribute("projects")) { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td align=\"center\"> ");
      out.print( index );
      out.write(" </td>\r\n");
      out.write("        <td align=\"left\" > ");
      out.print( project.getId() );
      out.write("  </td>\r\n");
      out.write("        <td align=\"left\" > ");
      out.print( project.getName() );
      out.write("  </td>\r\n");
      out.write("        <td align=\"left\" > ");
      out.print( project.getDescription() );
      out.write("  </td>\r\n");
      out.write("        <td align=\"left\" > ");
      out.print( project.getDateBegin() );
      out.write("  </td>\r\n");
      out.write("        <td align=\"left\" > ");
      out.print( project.getDateEnd() );
      out.write("  </td>\r\n");
      out.write("        <td>\r\n");
      out.write("                    <a href=\"project-update?id=");
      out.print(project.getId());
      out.write("\">\r\n");
      out.write("                        <i class=\"material-icons\" style=\"font-size:40px;color:#45D09E\" align = \"center\">border_color</i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <a href=\"project-remove?id=");
      out.print(project.getId());
      out.write("\">\r\n");
      out.write("                        <i class=\"material-icons\" style=\"font-size:40px;color:#E20338\" align = \"center\">delete_sweep</i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </td>\r\n");
      out.write("                 <td>\r\n");
      out.write("                                    <a href=\"tasks?id=");
      out.print(project.getId());
      out.write("\">\r\n");
      out.write("                                        <i class=\"material-icons\" style=\"font-size:40px;color:#808080\" align = \"center\">subject</i>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("\r\n");
      out.write("    ");
 index++; 
      out.write("\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    <div class=\"button_cont\" align=\"center\"><a class=\"example_a\" href=\"project-create\">Create Project</a></div>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
