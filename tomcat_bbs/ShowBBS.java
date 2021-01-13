package tomcat_bbs;
import java.io.*;
import javax.servlet.http.*;

public class ShowBBS extends HttpServlet {
    private String escapeHTML(String src) {
        return src.replace("&", "&amp")
                .replace("<", "&lt")
                .replace(">", "&gt")
                .replace("\"", "&quot")
                .replace("'", "&#39");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>テスト掲示板</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>テスト掲示板</h1>");
        out.println("<form action='/testbbs/PostBBS' method='post'>");
        out.println("タイトル:<input type='text' name='title' size='60'>" + "<br/>");
        out.println("ハンドル名:<input type='text' name='handle'><br/>");
        out.println("<textarea name='message' rows='4' cols='60'>"+"</textarea><br/>");
        out.println("<input type='submit'/>");
        out.println("</form>");
        out.println("<hr/>");

        for (Message message : Message.messageList) {
            out.println("<p>『" + escapeHTML(message.title) + "』&nbsp;&nbsp;"
                    + escapeHTML(message.handle) + " さん&nbsp;&nbsp;"
                    + escapeHTML(message.date.toString()) + "</p>");
            out.println("<p>");
            out.println(escapeHTML(message.message).replace("\r\n", "<br/>"));
            out.println("</p><hr/>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
