package edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.Role;
import edu.sabanciuniv.AliErtekinElkocaEnvironmentListener.domain.User;

@Stateless
public class EnvironmentListenerUserBusinessService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public User getUserWithRole(String email, String password) {
	
		List<User> users = entityManager.createQuery("select u from User u where u.email=:email and u.password=:pass",User.class)
							.setParameter("email", email)
							.setParameter("pass",password)
							.getResultList();
				
				if(users.size()==1)
				{
					if(users.get(0).getPassword().equals(password)) {
						
						Role role = entityManager.find(Role.class, users.get(0).getId());
						users.get(0).setRoleName(role.getRoleName());
						return users.get(0);
						
					}
					
				}
				return null;
		}	
		
		public List<User> getUnauthorizedUsers() {
		
		
		List<User> unauthorizedUsers = entityManager.createQuery("select u from User u where u.status=:pending",User.class)
				.setParameter("pending","pending")
				.getResultList();
				

			
			return unauthorizedUsers;
		}	
		
		public List<User> getauthorizedUsers() {
			
			
			List<User> authorizedUsers = entityManager.createQuery("select u from User u where u.status=:approved",User.class)
					.setParameter("approved","approved")
					.getResultList();
					

				
				return authorizedUsers;
			}
		
		public String getauthorizedUsersMails() {
			
			
			List<User> userMail = entityManager.createQuery("select u from User u where u.status=:approved",User.class)
					.setParameter("approved","approved")
					.getResultList();
					
			StringBuilder append = new StringBuilder();
			
			
			
			for(int i=0 ; i<userMail.size();i++) {
				
				append.append(userMail.get(i).getEmail()+",");
			}
				return append.toString();
			}
		
		
	
		public User login(String email, String pass) {
			
			return entityManager.createQuery("select u from User u where u.email=:email and u.password=:pass", User.class)
					.setParameter("email", email).setParameter("pass", pass).getSingleResult();
			
		}
	
	
	
		
		public String userRegistration(User user) {
			
			List<User> users = entityManager.createQuery("select u from User u where u.email=:email",User.class)
					.setParameter("email", user.getEmail())
					.getResultList();
		
		if(users.size()==1)
		{
			
			return "register";
			
		}
		else {
			
			entityManager.persist(user);
			return "login";
		}
		
		}
		
		
		public void roleRegistration(Role role,int userId) {
			
			User user = entityManager.find(User.class, userId);
			
			if(user!=null) {
				
				entityManager.persist(role);
				user.setRoleName(role.getRoleName());
			}
			
			
			
		}
		
		public void userApproval(User user) {
			
			User userFound = entityManager.find(User.class, user.getId());
			
			userFound.setStatus("approved");
			
		}
		
		public void userDeactivation(User user) {
			
			User userFound = entityManager.find(User.class, user.getId());
			
			userFound.setStatus("pending");
			
		}
		
		public void userRejection(User user) {
			
			User userFound = entityManager.find(User.class, user.getId());
			Role roleFound = entityManager.find(Role.class, user.getId());
			
			entityManager.remove(userFound);
			entityManager.remove(roleFound);
			
			
		}
		
		public void userRoleChanger(User user) {
			
			User userFound = entityManager.find(User.class, user.getId());
			Role roleFound = entityManager.find(Role.class, user.getId());
			
			if(user.getRoleName().equals("admin"))
			{
				userFound.setRoleName("user");
				roleFound.setRoleName("user");
				
			}
			else if(user.getRoleName().equals("user")) {
				
				userFound.setRoleName("admin");
				roleFound.setRoleName("admin");
				
			}
			
			
			
	}
	

}
