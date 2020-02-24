/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calorieTracker;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASHITHA JOSEPH
 */
@Entity
@Table(name = "CONSUMPTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consumption.findAll", query = "SELECT c FROM Consumption c")
    , @NamedQuery(name = "Consumption.findByIndex", query = "SELECT c FROM Consumption c WHERE c.index = :index")
    , @NamedQuery(name = "Consumption.findByQuantityperservings", query = "SELECT c FROM Consumption c WHERE c.quantityperservings = :quantityperservings")
    , @NamedQuery(name = "Consumption.findByDate", query = "SELECT c FROM Consumption c WHERE c.date = :date")
    , @NamedQuery(name = "Consumption.findByUserId", query = "SELECT c FROM Consumption c WHERE c.userid.userid = :userid")
    , @NamedQuery(name = "Consumption.findByFoodId", query = "SELECT c FROM Consumption c WHERE c.foodid.foodid = :foodid")
    , @NamedQuery(name = "Consumption.findByLevelOfActivityAndQtyPerServings", query = "SELECT c from Consumption c where c.userid.levelofactivity = :levelofactivity and c.quantityperservings = :quantityperservings")})
public class Consumption implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INDEX")
    private Integer index;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITYPERSERVINGS")
    private int quantityperservings;
    @Size(max = 30)
    @Column(name = "DATE")
    private String date;
    @JoinColumn(name = "FOODID", referencedColumnName = "FOODID")
    @ManyToOne(optional = false)
    private Food foodid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Users userid;

    public Consumption() {
    }

    public Consumption(Integer index) {
        this.index = index;
    }

    public Consumption(Integer index, int quantityperservings) {
        this.index = index;
        this.quantityperservings = quantityperservings;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public int getQuantityperservings() {
        return quantityperservings;
    }

    public void setQuantityperservings(int quantityperservings) {
        this.quantityperservings = quantityperservings;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Food getFoodid() {
        return foodid;
    }

    public void setFoodid(Food foodid) {
        this.foodid = foodid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (index != null ? index.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consumption)) {
            return false;
        }
        Consumption other = (Consumption) object;
        if ((this.index == null && other.index != null) || (this.index != null && !this.index.equals(other.index))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "calorieTracker.Consumption[ index=" + index + " ]";
    }
    
}
