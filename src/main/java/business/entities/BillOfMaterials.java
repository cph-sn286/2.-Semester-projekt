package business.entities;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {



    private List<CarportItems> billOfMaterialsItemList = new ArrayList<>();

    public BillOfMaterials(){


    }

    public List<CarportItems> getBillOfMaterialsItemList(){

        return billOfMaterialsItemList;

    }

    public  void addToBillOfMaterials(CarportItems carportItems){
        billOfMaterialsItemList.add(carportItems);

    }

    public void removeFromBillOfMaterials(int carportItemsIndex){

        billOfMaterialsItemList.remove(carportItemsIndex);

    }
}
