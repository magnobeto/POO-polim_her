
package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Roberto
 */

        
public final class UsedProduct extends Product{
    
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date manufactureDate;
    
    public UsedProduct(){
        super();
    }
    
    public UsedProduct(String name, Double price, Date manufactureDate){
        super(name, price);
        this.manufactureDate = manufactureDate;
    }
    
    public void setManufactureDate(Date manufatureDate){
        this.manufactureDate = manufactureDate;
    }
    
    public Date getManufactureDate(){
        return manufactureDate;
    }
    
    @Override
    public final String priceTag(){
        return super.getName() + " (used) $ "
                + String.format("%.2f", super.getPrice())
                + " (Manufacture date: " 
                + sdf.format(manufactureDate) + ")";
    }
    
}
