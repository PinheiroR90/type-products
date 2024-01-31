package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{

    public  static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Date manufactureProduct;

    public UsedProduct(){
        super();
    }

    public UsedProduct(String name, Double price, Date manufactureProduct) {
        super(name, price);
        this.manufactureProduct = manufactureProduct;
    }

    public Date getManufactureProduct() {
        return manufactureProduct;
    }

    public void setManufactureProduct(Date manufactureProduct) {
        this.manufactureProduct = manufactureProduct;
    }

    @Override
    public String priceTag()  {
        return getName() + " (used) $ "+String.format("%.2f", getPrice())+" (Manufacture date: "+dateFormat.format(manufactureProduct)+")";
    }
}
