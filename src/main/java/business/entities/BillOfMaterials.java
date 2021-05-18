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


    public double totalPrice(){
        double price = 0;

        for (CarportItems carportitem : billOfMaterialsItemList) {

            price = price + carportitem.getPrice();

        }

        return price;
    }

    @Override
    public String toString() {
        return "BillOfMaterials{" +
                "billOfMaterialsItemList=" + billOfMaterialsItemList +
                '}';
    }
}
