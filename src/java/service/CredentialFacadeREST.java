/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import calorieTracker.Credential;
import calorieTracker.Users;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
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
@Path("calorietracker.credential")
public class CredentialFacadeREST extends AbstractFacade<Credential> {

    @PersistenceContext(unitName = "calorieTracker_29874866PU")
    private EntityManager em;

    public CredentialFacadeREST() {
        super(Credential.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Credential entity) {
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
    public void fetchUserID(Users userid){
    
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Credential entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Credential find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credential> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credential> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public List<Credential> findByUserId(@PathParam("userId") Integer userid) {
        Query query = em.createNamedQuery("Credential.findByUserId");
        query.setParameter("userid", userid);
        return query.getResultList();
    }
    @GET
    @Path("findByPassword/{password}")
    @Produces({"application/json"})
    public List<Credential> findByPassword(@PathParam("password") String password) {
        Query query = em.createNamedQuery("Credential.findByPassword");
        query.setParameter("password", password);
        return query.getResultList();
    }
    @GET
    @Path("findBySignupdate/{SignupDate}")
    @Produces({"application/json"})
    public List<Credential> findBySignupdate(@PathParam("SignupDate") String signupdate) {
        Query query = em.createNamedQuery("Credential.findBySignupdate");
        query.setParameter("signupdate", signupdate);
        return query.getResultList();
    }
    
}
