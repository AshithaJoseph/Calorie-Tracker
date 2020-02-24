/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import calorieTracker.Consumption;
import java.util.List;
import javax.ejb.Stateless;
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
import calorieTracker.Food;
import entities.ConsumptionFood;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.core.GenericEntity;

/**
 *
 * @author ASHITHA JOSEPH
 */
@Stateless
@Path("calorietracker.consumption")
public class ConsumptionFacadeREST extends AbstractFacade<Consumption> {

    @PersistenceContext(unitName = "calorieTracker_29874866PU")
    private EntityManager em;

    public ConsumptionFacadeREST() {
        super(Consumption.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Consumption entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Consumption entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Consumption find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("findByUserId/{userId}")
    @Produces({"application/json"})
    public List<Consumption> findByUserId(@PathParam("userId") Integer userid) {
        Query query = em.createNamedQuery("Consumption.findByUserId");
        query.setParameter("userid", userid);
        return query.getResultList();
    }
    @GET
    @Path("findByFoodId/{foodId}")
    @Produces({"application/json"})
    public List<Consumption> findByFoodId(@PathParam("foodId") Integer foodid) {
        Query query = em.createNamedQuery("Consumption.findByFoodId");
        query.setParameter("foodid", foodid);
        return query.getResultList();
    }
    @GET
    @Path("findByQuantityperservings/{quantityPerServings}")
    @Produces({"application/json"})
    public List<Consumption> findByQuantityperservings(@PathParam("quantityPerServings") java.math.BigDecimal quantityperservings) {
        Query query = em.createNamedQuery("Consumption.findByQuantityperservings");
        query.setParameter("quantityperservings", quantityperservings);
        return query.getResultList();
    }
    @GET
    @Path("findByDate/{date}")
    @Produces({"application/json"})
    public List<Consumption> findByDate(@PathParam("date") String date) {
        Query query = em.createNamedQuery("Consumption.findByDate");
        query.setParameter("date", date);
        return query.getResultList();
    }
    @GET
    @Path("findByUserIdAndFoodId/{userId}/{foodId}")
    @Produces({"application/json"})
    public List<Consumption> findByUserIdAndFoodId(@PathParam("userId") Integer userid,@PathParam("foodId") Integer foodid) {
        TypedQuery<Consumption> query = em.createQuery("SELECT c FROM Consumption c WHERE c.userid.userid = :userid AND c.foodid.foodid = :foodid", Consumption.class);
        query.setParameter("userid", userid);
        query.setParameter("foodid", foodid);
        return query.getResultList();
    }
    
    @GET
    @Path("findByGenderandFoodName/{gender}/{foodName}")
    @Produces({"application/json"})
    public List<Consumption> findByGenderandFoodName(@PathParam("gender") String gender,@PathParam("foodName") String foodname) {
        TypedQuery<Consumption> query = em.createQuery("SELECT c FROM Consumption c WHERE c.userid.gender = :gender AND c.foodid.foodname = :foodname", Consumption.class);
        query.setParameter("gender", gender);
        query.setParameter("foodname", foodname);
        return query.getResultList();
    }
    
    @GET
    @Path("Consumption.findByLevelOfActivityAndQtyPerServings/{LevelOfActivity}/{QuantityPerServings}")
    @Produces({"application/json"})
    public List<Consumption> findByLevelOfActivityAndQtyPerServings(@PathParam("LevelOfActivity") Integer levelofactivity,@PathParam("QuantityPerServings") Integer quantityperservings) {
        Query query = em.createNamedQuery("Consumption.findByLevelOfActivityAndQtyPerServings");
        query.setParameter("levelofactivity", levelofactivity);
        query.setParameter("quantityperservings", quantityperservings);
        return query.getResultList();
    }
    
    @GET
    @Path("totalCaloriesConsumed/{userid}/{date}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object totalCaloriesConsumed(@PathParam("userid") Integer userid,@PathParam("date") String date) {
         Query q = em.createQuery("SELECT c.foodid.calorieamount,c.quantityperservings FROM Consumption As c where c.userid.userid = :userid and c.date = :date",
            Object[].class);
         q.setParameter("userid", userid);
         q.setParameter("date", date);
        List<Object[]> queryList = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        int totalCaloriesConsumed = 0;
        for (Object[] row : queryList) {
            totalCaloriesConsumed = ((int)row[0] * (int)row[1]) + totalCaloriesConsumed;
        }
        JsonObject calorieObject = Json.createObjectBuilder().
            add("Total Calories Consumed", totalCaloriesConsumed)
            .build();
            arrayBuilder.add(calorieObject);
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }
     
}
