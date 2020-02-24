/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASHITHA JOSEPH
 */
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ConsumptionFood {
    int quantityPerServings;
    int calorieAmount, userid;

    public int getCalorieAmount() {
    return calorieAmount;
    }
    public void setCalorieAmount(int calorieAmount) {
    this.calorieAmount = calorieAmount;
    }
    /*public int getUserid(){
    return userid;
    }
    public void setUserId(){
    this.userid = userid;
    }*/
    public int getQuantityPerServings() {
    return quantityPerServings;
    }
    public void setQuantityPerServings(int quantityPerServings) {
    this.quantityPerServings = quantityPerServings;
    }
    public ConsumptionFood() {
    }
    
    public ConsumptionFood(int calorieAmount, int quantityPerServings) {
    this.calorieAmount = calorieAmount;
    this.quantityPerServings = quantityPerServings;
    }

}
