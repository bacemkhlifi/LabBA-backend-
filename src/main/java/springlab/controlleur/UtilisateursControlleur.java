package springlab.controlleur;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import springlab.dao.AnalyseRepository;
import springlab.dao.RoleRepository;
import springlab.dao.UtilisateursRepository;

import springlab.model.Role;
import springlab.model.Utilisateurs;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1")
public class UtilisateursControlleur {
	
	
	@Autowired
	public RoleRepository roleRep;
	@Autowired
	public UtilisateursRepository userRep;
	@Autowired
	public AnalyseRepository analyseRep;
	//api get users 
	@GetMapping(value="/users")
	public List<Utilisateurs> getAllUsers() {
		return userRep.findAll();
	}
	//api get users 
	/*	@GetMapping(value="/users/medcins")
		public List<Utilisateurs> getAllUsersM() {
		Role rolee =	roleRep.findAll().get(0).getRole("medecin");
		}
	*/
	//api delete user
	@DeleteMapping(value="/user/delete/{cin}")
	public String deleteUser(@PathVariable(value="cin") int cin) {
		userRep.deleteById(cin);
		return "deleted";
	}
	
	//api add user (patient par defaut)
	@PostMapping(value="/add/user")
	public Utilisateurs createUser(@RequestBody Utilisateurs user) {
		Role role = new Role();
		role.setRole("patient");
		roleRep.save(role);
		user.setRole(role);
		return userRep.save(user);
	}
	//get all patient
	@GetMapping(value="/users/patients")
	public List<Role> getUsers(){
		int i =0;
		List <Role> roles= new ArrayList<>();
		
		while( i < roleRep.findAll().size()) {
		
		if((roleRep.findAll().get(i).getRole()).contains("patient")) {
			roles.add(roleRep.findAll().get(i));
			i+=1;
			
			}
		else{
			i+=1;
		}
		
	}
		return roles;
	
	
		
	}
	
	//get all medecin
		@GetMapping(value="/users/medecins")
		public List<Role> getMedecins(){
			int i =0;
			List <Role> roles= new ArrayList<>();
			
			while( i < roleRep.findAll().size()) {
			
			if((roleRep.findAll().get(i).getRole()).contains("medecin")) {
				roles.add(roleRep.findAll().get(i));
				i+=1;
				
				}
			else{
				i+=1;
			}
			
		}
			return roles;
		
		
			
		}
		
		//get all secretaires
		@GetMapping(value="/users/secretaires")
		public List<Role> getSecretaires(){
			int i =0;
			List <Role> roles= new ArrayList<>();
			
			while( i < roleRep.findAll().size()) {
			
			if((roleRep.findAll().get(i).getRole()).contains("secretaires")) {
				roles.add(roleRep.findAll().get(i));
				i+=1;
				
				}
			else{
				i+=1;
			}
			
		}
			return roles;
		
		
			
		}
	
	//get  user by id(cin)
		@GetMapping(value="/user/{cin}")
		public Optional<Utilisateurs> getUserId(@PathVariable(value="cin") int cin){
			return  userRep.findById(cin);
			
		}
	
	
		
		
	
}
