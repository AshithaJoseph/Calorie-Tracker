/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import calorieTracker.Report;
import calorieTracker.ReportPK;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author ASHITHA JOSEPH
 */
@Stateless
@Path("calorietracker.report")
public class ReportFacadeREST extends AbstractFacade<Report> {

    @PersistenceContext(unitName = "calorieTracker_29874866PU")
    private EntityManager em;

    private ReportPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;userid=useridValue;date=dateValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        calorieTracker.ReportPK key = new calorieTracker.ReportPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> userid = map.get("userid");
        if (userid != null && !userid.isEmpty()) {
            key.setUserid(new java.lang.Integer(userid.get(0)));
        }
        java.util.List<String> date = map.get("date");
        if (date != null && !date.isEmpty()) {
            key.setDate(date.get(0));
        }
        return key;
    }

    public ReportFacadeREST() {
        super(Report.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Report entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Report entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        calorieTracker.ReportPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Report find(@PathParam("id") PathSegment id) {
        calorieTracker.ReportPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @GET
    @Path("findByUserid/{userid}")
    @Produces({"application/json"})
    public List<Report> findByUserid(@PathParam("userid") Integer userid) {
        Query query = em.createNamedQuery("Report.findByUserid");
        query.setParameter("userid", userid);
        return query.getResultList();
    }
    @GET
    @Path("findByDate/{date}")
    @Produces({"application/json"})
    public List<Report> findByDate(@PathParam("date") String date) {
        Query query = em.createNamedQuery("Report.findByDate");
        query.setParameter("date", date);
        return query.getResultList();
    }
    @GET
    @Path("findByTotalcaloriesconsumed/{totalCaloriesConsumed}")
    @Produces({"application/json"})
    public List<Report> findByTotalcaloriesconsumed(@PathParam("totalCaloriesConsumed") java.math.BigDecimal totalcaloriesconsumed) {
        Query query = em.createNamedQuery("Report.findByTotalcaloriesconsumed");
        query.setParameter("totalcaloriesconsumed", totalcaloriesconsumed);
        return query.getResultList();
    }
    @GET
    @Path("findByTotalcaloriesburned/{totalCaloriesBurned}")
    @Produces({"application/json"})
    public List<Report> findByTotalcaloriesburned(@PathParam("totalCaloriesBurned") java.math.BigDecimal totalcaloriesburned) {
        Query query = em.createNamedQuery("Report.findByTotalcaloriesburned");
        query.setParameter("totalcaloriesburned", totalcaloriesburned);
        return query.getResultList();
    }
    @GET
    @Path("findByTotalstepstaken/{totalStepsTaken}")
    @Produces({"application/json"})
    public List<Report> findByTotalstepstaken(@PathParam("totalStepsTaken") Integer totalstepstaken) {
        Query query = em.createNamedQuery("Report.findByTotalstepstaken");
        query.setParameter("totalstepstaken", totalstepstaken);
        return query.getResultList();
    }
    @GET
    @Path("findByCaloriegoal/{calorieGoal}")
    @Produces({"application/json"})
    public List<Report> findByCaloriegoal(@PathParam("calorieGoal") java.math.BigDecimal caloriegoal) {
        Query query = em.createNamedQuery("Report.findByCaloriegoal");
        query.setParameter("caloriegoal", caloriegoal);
        return query.getResultList();
    } 
    
    @GET
    @Path("remainingCalories/{userid}/{date}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object remainingCalories(@PathParam("userid") Integer userid,@PathParam("date") String date) {
         Query q = em.createQuery("SELECT r.totalcaloriesconsumed,r.totalcaloriesburned, r.caloriegoal FROM Report as r where r.reportPK.userid = :userid and r.reportPK.date = :date",
            Object[].class);
         q.setParameter("userid", userid);
         q.setParameter("date", date);
        List<Object[]> queryList = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Object[] row : queryList) {
        JsonObject calorieObject = Json.createObjectBuilder().
        add("totalCaloriesConsumed", (int)row[0])
        .add("totalCaloriesBurned", (int)row[1])
        .add("remainingCalories",(int)((int)row[0]-(int)row[1]-(int)row[2])).build();
        arrayBuilder.add(calorieObject);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }
    
    @GET
    @Path("caloriesInAPeriod/{userid}/{startDate}/{endDate}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object caloriesInAPeriod(@PathParam("userid") Integer userid,@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
         Query q = em.createQuery("SELECT r.totalcaloriesconsumed,r.totalcaloriesburned, r.totalstepstaken FROM Report as r "
                 + "where r.reportPK.userid = :userid and r.reportPK.date between :startDate AND :endDate",Object[].class);
         q.setParameter("userid", userid);
         q.setParameter("startDate", startDate);
         q.setParameter("endDate",endDate);
        List<Object[]> queryList = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        //int totalCaloriesConsumed =0,totalCaloriesBurned = 0,totalStepsTaken = 0;
        /*for (Object[] row : queryList) {
            totalCaloriesConsumed = (int)row[0] + totalCaloriesConsumed;
            totalCaloriesBurned = (int)row[1] + totalCaloriesBurned;
            totalStepsTaken = (int)row[2] + totalStepsTaken;
        }*/
        List<Integer> totalCaloriesConsumed= new ArrayList(); 
        List<Integer> totalCaloriesBurned=new ArrayList();
        List<Integer> totalStepsTaken= new ArrayList();
        for (Object[] row : queryList) {
            totalCaloriesConsumed.add((int)row[0]);
            totalCaloriesBurned.add((int)row[1]);
            totalStepsTaken.add((int)row[2]);
        }
        
        JsonObject calorieObject = Json.createObjectBuilder().
        add("totalCaloriesConsumed", totalCaloriesConsumed.toString())
        .add("totalCaloriesBurned", totalCaloriesBurned.toString())
        .add("totalStepsTaken",totalStepsTaken.toString()).build();
        arrayBuilder.add(calorieObject);
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }
}
