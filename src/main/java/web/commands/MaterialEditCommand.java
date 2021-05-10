package web.commands;

import business.entities.Materials;
import business.exceptions.UserException;
import business.services.MaterialFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaterialEditCommand extends CommandProtectedPage{
MaterialFacade materialFacade;
    public MaterialEditCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        request.getServletContext().setAttribute("materialsPriceList", materialFacade.getAllMaterials());

        String deleteId = request.getParameter("delete");
        String editId = request.getParameter("edit");
        String update = request.getParameter("update");
        String materials_id = request.getParameter("materials_id");
        String price = request.getParameter("updatePrice");
        String description = request.getParameter("description");


        if (deleteId != null) {
            int rowsAffected = materialFacade.deleteMaterials(Integer.parseInt(deleteId));
            if (rowsAffected >0) {
                request.getServletContext().setAttribute("materialsPriceList", materialFacade.getAllMaterials());
            } else {
                request.setAttribute("error", "Du kan ik fjerne dette materiale");
            }
        } else if (editId != null) {
            Materials materials = materialFacade.getAllMaterialsById(Integer.parseInt(editId));
            request.setAttribute("materials", materials);
            return "managematerialpage"; // KIG HER!!!
        } else if (update != null) {

            int rowsInserted = materialFacade.updatePrice((materials_id),price);
            if (rowsInserted == 1) {
                request.getServletContext().setAttribute("materialsPriceList", materialFacade.getAllMaterials());
            }
            System.out.printf("nye pris " + price + " for materiale_id = " + materials_id );
        } else if (update!= null) {
            System.out.println(description);

        }

        return pageToShow;
    }
}
