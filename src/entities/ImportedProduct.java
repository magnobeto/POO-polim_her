
package entities;
/**
 *
 * @author Roberto
 */
public final class ImportedProduct extends Product {
    
    private Double customsFee;
    
    public ImportedProduct(){
        super();
    }
    
    public ImportedProduct(String name, Double price, Double customsFee){
        super(name, price);
        this.customsFee = customsFee;
    }
    
    public void setCustomsFee(Double customsFee){
        this.customsFee = customsFee;
    }
    
    public Double getCustomsFee(){
        return customsFee;
    }
    
    public Double totalPrice(){
        return super.getPrice() + customsFee;
    }
    
    @Override
    public final String priceTag(){
        return super.getName() + " $ " 
                + String.format("%.2f",totalPrice())
                + " (Customs Fee: $ " 
                + String.format("%.2f", customsFee) + ")";
    }
   
}
