package web.commands;

import business.exceptions.UserException;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSVGCommand extends CommandUnprotectedPage
{

    public ShowSVGCommand(String pageToShow)
    {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
       SVG svg = new SVG(0, 0, "0 0 800 600", 100, 50 );

       for (int x = 0; x < 14; x++)
        {
            svg.addRect(100 + 50 * x, 0, 600.0, 4.5);
      }

       svg.addRect(100, 40, 4.5, 655.0);
       svg.addRect(100, 560,4.5,655.0);
       svg.addRect(100,40,520.0,4.5);
       svg.addRect(750,40,520.0,4.5);

        for (int x = 0; x < 10; x++) {
            svg.addRect(225 + 200 * x ,38,8,8);
        }

        for (int x = 0; x < 10; x++) {
            svg.addRect(225 + 200 * x,558,8,8);

        }


        request.setAttribute("svgdrawing", svg.toString());
        return pageToShow;
    }
}