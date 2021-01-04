package Modoki02;
import java.io.*;
import java.util.*;
import java.text.*;

 class Util {
     static String readline(InputStream input) throws Exception {
         int ch;
         StringBuilder ret = new StringBuilder();

         while ((ch = input.read()) != -1) {
             if (ch == '\r') {

             } else if (ch == '\n') {
                 break;
             } else {
                 ret.append((char) ch);
             }
         }

         if (ch == -1) {
             return null;
         } else {
             return ret.toString();
         }
     }

     static void writeLine(OutputStream output, String str) throws Exception {
         for (char ch : str.toCharArray()) {
             output.write((int)ch);
         }
         output.write((int)'\r');
         output.write((int)'\n');
     }

     static String getDateStringUtc() {
         Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
         DateFormat df = new SimpleDateFormat("EEE dd MMM yyyy HH:mm:ss", Locale.US);
         df.setTimeZone(cal.getTimeZone());
         return df.format(cal.getTime()) + "GMT";
     }

     static final HashMap<String, String> contentTypeMap = new HashMap<String, String>() {
         private static final long serialVersionUID = 1L;
         {
         put("html", "text/html");
         put("htm", "text/html");
         put("txt", "text/plain");
         put("css", "text/css");
         put("png", "image/png");
         put("jpg", "image/jpg");
         put("jpeg", "image/jpeg");
         put("gif", "image/gif");
         }
     };

     static String getContentType(String ext) {
         String ret = contentTypeMap.get(ext.toLowerCase());
         return Objects.requireNonNullElse(ret, "application/octet-stream");
     }
}
