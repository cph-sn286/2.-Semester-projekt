package business.entities;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {



    private List<Materials> billOfMaterialsItemList = new ArrayList<>();

    public BillOfMaterials(){


    }

    public List<Materials> getBillOfMaterialsItemList(){

        return billOfMaterialsItemList;

    }

    public  void addToBillOfMaterials(Materials materials){
        billOfMaterialsItemList.add(materials);

    }
}
