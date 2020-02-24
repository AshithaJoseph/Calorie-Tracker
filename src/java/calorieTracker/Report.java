/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calorieTracker;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASHITHA JOSEPH
 */
@Entity
@Table(name = "REPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r")
    , @NamedQuery(name = "Report.findByUserid", query = "SELECT r FROM Report r WHERE r.reportPK.userid = :userid")
    , @NamedQuery(name = "Report.findByDate", query = "SELECT r FROM Report r WHERE r.reportPK.date = :date")
    , @NamedQuery(name = "Report.findByTotalcaloriesconsumed", query = "SELECT r FROM Report r WHERE r.totalcaloriesconsumed = :totalcaloriesconsumed")
    , @NamedQuery(name = "Report.findByTotalcaloriesburned", query = "SELECT r FROM Report r WHERE r.totalcaloriesburned = :totalcaloriesburned")
    , @NamedQuery(name = "Report.findByTotalstepstaken", query = "SELECT r FROM Report r WHERE r.totalstepstaken = :totalstepstaken")
    , @NamedQuery(name = "Report.findByCaloriegoal", query = "SELECT r FROM Report r WHERE r.caloriegoal = :caloriegoal")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReportPK reportPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALCALORIESCONSUMED")
    private int totalcaloriesconsumed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALCALORIESBURNED")
    private int totalcaloriesburned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALSTEPSTAKEN")
    private int totalstepstaken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALORIEGOAL")
    private int caloriegoal;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Report() {
    }

    public Report(ReportPK reportPK) {
        this.reportPK = reportPK;
    }

    public Report(ReportPK reportPK, int totalcaloriesconsumed, int totalcaloriesburned, int totalstepstaken, int caloriegoal) {
        this.reportPK = reportPK;
        this.totalcaloriesconsumed = totalcaloriesconsumed;
        this.totalcaloriesburned = totalcaloriesburned;
        this.totalstepstaken = totalstepstaken;
        this.caloriegoal = caloriegoal;
    }

    public Report(int userid, String date) {
        this.reportPK = new ReportPK(userid, date);
    }

    public ReportPK getReportPK() {
        return reportPK;
    }

    public void setReportPK(ReportPK reportPK) {
        this.reportPK = reportPK;
    }

    public int getTotalcaloriesconsumed() {
        return totalcaloriesconsumed;
    }

    public void setTotalcaloriesconsumed(int totalcaloriesconsumed) {
        this.totalcaloriesconsumed = totalcaloriesconsumed;
    }

    public int getTotalcaloriesburned() {
        return totalcaloriesburned;
    }

    public void setTotalcaloriesburned(int totalcaloriesburned) {
        this.totalcaloriesburned = totalcaloriesburned;
    }

    public int getTotalstepstaken() {
        return totalstepstaken;
    }

    public void setTotalstepstaken(int totalstepstaken) {
        this.totalstepstaken = totalstepstaken;
    }

    public int getCaloriegoal() {
        return caloriegoal;
    }

    public void setCaloriegoal(int caloriegoal) {
        this.caloriegoal = caloriegoal;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportPK != null ? reportPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.reportPK == null && other.reportPK != null) || (this.reportPK != null && !this.reportPK.equals(other.reportPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "calorieTracker.Report[ reportPK=" + reportPK + " ]";
    }
    
}
