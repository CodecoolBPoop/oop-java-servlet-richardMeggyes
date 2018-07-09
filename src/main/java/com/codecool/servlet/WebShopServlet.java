package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "webShopServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("doGet");

        ItemStore itemStore = new ItemStore();

        itemStore.addItemToStore(0, "King Kong DVD", 500);

        itemStore.addItemToStore(1, "Hannah Montana DVD", 500);

        itemStore.addItemToStore(2, "Bag of Rice", 500);

        itemStore.addItemToStore(3, "Human Kidney", 500);

        PrintWriter out = response.getWriter();
        String title = "WebShop Items";

        int numberOfItems = itemStore.getItemsNumber();

        StringBuffer buffer = new StringBuffer();
        buffer.append("<div>");
        buffer.append("<table>");

        for (int i = 0; i < numberOfItems; i++) {
            ArrayList<String> itemDetails = itemStore.getItemDetailsById(i);

            buffer.append("<tr>");

            buffer.append("<td>");
            buffer.append(itemDetails.get(0));
            buffer.append("</td>");

            buffer.append("<td>");
            buffer.append(itemDetails.get(1));
            buffer.append("</td>");

            buffer.append("<td>");
            buffer.append(itemDetails.get(2));
            buffer.append("</td>");

            buffer.append("</tr>");
        }

        buffer.append("</table>");
        buffer.append("</div>");

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<div>" + buffer.toString() + "</div>" +
                        "<div>Visit another servlet: <a href=\"/another\">Visit the other servlet</a></div>" +
                        "</body></html>"
        );
    }
}
