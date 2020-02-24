/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import calorieTracker.Food;
import calorieTracker.Users;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ASHITHA JOSEPH
 */
@Stateless
@Path("calorietracker.users")
public class UsersFacadeREST extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "calorieTracker_29874866PU")
    
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Users entity) {
        try {
            super.create(entity);
        } catch(javax.validation.ConstraintViolationException cve){
            Set<ConstraintViolation<?>> cvs = cve.getConstraintViolations();
            String errMsg = "";
            for (ConstraintViolation<?> cv : cvs) {    
                System.out.println( cv.getMessage());
                System.out.println("Entity: " + cv.getRootBeanClass().getSimpleName());
          	// The violation occurred on a leaf bean (embeddable)
          	if (cv.getLeafBean() != null && cv.getRootBean() != cv.getLeafBean()) {
              System.out.println("Embeddable: " + 
                cv.getLeafBean().getClass().getSimpleName());
          }
          System.out.println("Attribute: " + cv.getPropertyPath());
          System.out.println("Invalid value: " + cv.getInvalidValue());
            }
        } 
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Users entity) {
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
    public Users find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("findByName/{firstName}")
    @Produces({"application/json"})
    public List<Users> findByName(@PathParam("firstName") String name) {
        Query query = em.createNamedQuery("Users.findByName");
        query.setParameter("name", name);
        return query.getResultList();
    }
    @GET
    @Path("findBySurname/{surname}")
    @Produces({"application/json"})
    public List<Users> findBySurname(@PathParam("surname") String surname) {
        Query query = em.createNamedQuery("Users.findBySurname");
        query.setParameter("surname", surname);
        return query.getResultList();
    }
    @GET
    @Path("findByEmail/{email}")
    @Produces({"application/json"})
    public List<Users> findByEmail(@PathParam("email") String email) {
        Query query = em.createNamedQuery("Users.findByEmail");
        query.setParameter("email", email);
        return query.getResultList();
    }
    @GET
    @Path("findByDob/{DoB}")
    @Produces({"application/json"})
    public List<Users> findByDob(@PathParam("DoB") String dob) {
        Query query = em.createNamedQuery("Users.findByDob");
        query.setParameter("dob", dob);
        return query.getResultList();
    }
    @GET
    @Path("findByHeight/{height}")
    @Produces({"application/json"})
    public List<Users> findByHeight(@PathParam("height") Integer height) {
        Query query = em.createNamedQuery("Users.findByHeight");
        query.setParameter("height", height);
        return query.getResultList();
    }
    @GET
    @Path("findByWeight/{weight}")
    @Produces({"application/json"})
    public List<Users> findByWeight(@PathParam("weight") Integer weight) {
        Query query = em.createNamedQuery("Users.findByWeight");
        query.setParameter("weight", weight);
        return query.getResultList();
    }
    @GET
    @Path("findByGender/{gender}")
    @Produces({"application/json"})
    public List<Users> findByGender(@PathParam("gender") String gender) {
        Query query = em.createNamedQuery("Users.findByGender");
        query.setParameter("gender", gender);
        return query.getResultList();
    }
    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List<Users> findByAddress(@PathParam("address") String address) {
        Query query = em.createNamedQuery("Users.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }
    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({"application/json"})
    public List<Users> findByPostcode(@PathParam("postcode") Integer postcode) {
        Query query = em.createNamedQuery("Users.findByPostcode");
        query.setParameter("postcode", postcode);
        return query.getResultList();
    }
    @GET
    @Path("findByLevelofactivity/{levelOfActivity}")
    @Produces({"application/json"})
    public List<Users> findByLevelofactivity(@PathParam("levelOfActivity") Integer levelofactivity) {
        Query query = em.createNamedQuery("Users.findByLevelofactivity");
        query.setParameter("levelofactivity", levelofactivity);
        return query.getResultList();
    }
    @GET
    @Path("findByStepspermile/{stepsPerMile}")
    @Produces({"application/json"})
    public List<Users> findByStepspermile(@PathParam("stepsPerMile") Integer stepspermile) {
        Query query = em.createNamedQuery("Users.findByStepspermile");
        query.setParameter("stepspermile", stepspermile);
        return query.getResultList();
    }
    
    
    
    @GET
    @Path("findCaloriesBurnedPerStep/{userId}")
    @Produces({"text/plain"})
    public Double findCaloriesBurnedPerStep(@PathParam("userId") Integer userid) {
        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.userid = :userid", Users.class);
        query.setParameter("userid", userid);
        List<Users> list= query.getResultList();
        Integer weight = 0,stepspermile = 0;
        Double caloriesBurnedPerStep = 0.0;
        for( Users u:list ){
         stepspermile = u.getStepspermile();
         weight = u.getWeight();
         weight = (int)(weight * 2.2);  //convert weight into pounds
         Double caloriesBurnedPerMile = weight * 0.49;
         caloriesBurnedPerStep = (caloriesBurnedPerMile/stepspermile);
        }
        BigDecimal calories_rounded = new BigDecimal(caloriesBurnedPerStep);
        calories_rounded = calories_rounded.setScale(3, RoundingMode.HALF_UP);
        return calories_rounded.doubleValue(); 
      }
    
    @GET
    @Path("findBMR/{userId}")
    @Produces({"text/plain"})
    public double findBMR(@PathParam("userId") Integer userid) throws ParseException {
        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.userid = :userid", Users.class);
        query.setParameter("userid", userid);
        List<Users> list= query.getResultList();
        Integer weight = 0,height = 0;
        String gender,dob;
        LocalDate date_dob = null,currentDate = LocalDate.now();
        DateTimeFormatter formatter = null;
        double BMR = 0.0;
        for( Users u:list ){
            weight = u.getWeight();
            height = u.getHeight();
            dob = u.getDob();
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date_dob = LocalDate.parse(dob, formatter);
            int age = Period.between(date_dob, currentDate).getYears();
            if(u.getGender()== "Male"){
                BMR = (13.75 * weight) + (5.003 * height) - (6.755 * age) + 66.5;
            }            
            else{
                BMR = (9.563 * weight) + (1.85 * height) - (4.676 * age) + 655.1;
            }
        
        }
        BigDecimal BMR_rounded = new BigDecimal(BMR);
        BMR_rounded = BMR_rounded.setScale(3, RoundingMode.HALF_UP);
        return BMR_rounded.doubleValue(); 
    }
    
    @GET
    @Path("findCaloriesBurnedAtRest/{userId}")
    @Produces({"text/plain"})
    
    public Double findCaloriesAtRest(@PathParam("userId") Integer userid) throws ParseException {
        Double BMR = findBMR(userid);     
        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.userid = :userid", Users.class);
        query.setParameter("userid", userid);
        List<Users> list= query.getResultList();
        Double caloriesBurnedAtRest = 0.0;
        for( Users u:list ){
         Integer levelOfActivity = u.getLevelofactivity();
         switch(levelOfActivity){
             case 1: caloriesBurnedAtRest = BMR * 1.2;
                    break;
             case 2: caloriesBurnedAtRest = BMR * 1.375;
                    break;
             case 3: caloriesBurnedAtRest = BMR *1.55;
                    break;
             case 4: caloriesBurnedAtRest = BMR *1.725;
                    break;
             case 5: caloriesBurnedAtRest = BMR * 1.9;
                    break;
         }
        }
        BigDecimal calories_rounded = new BigDecimal(caloriesBurnedAtRest);
        calories_rounded = calories_rounded.setScale(3, RoundingMode.HALF_UP);
        return calories_rounded.doubleValue();
       
      }

}   
