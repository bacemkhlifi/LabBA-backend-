package springlab.controlleur;




import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springlab.dao.RoleRepository;
import springlab.dao.UtilisateursRepository;
import springlab.model.Role;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/wp-admin")
public class RoleControlleur {
	@Autowired
	public RoleRepository roleRep;
	@Autowired
	public UtilisateursRepository userRep;
	
	
	//update role  buliding ... waiting
		@PostMapping(value="update/role/{cin}")
		public Role addRole(@PathVariable(value="cin") int cin,@RequestBody Role role) {
			
			userRep.findById(cin).get().getRole().getId_r();
			
			return roleRep.save(role);
			}
	
		//api get  role by ID(cin)
	@GetMapping(value="/role/{cin}")
	public Optional<Role> getRole(@PathVariable(value="cin") int cin )
	{
		
		int ref= userRep.findById(cin).get().getRole().getId_r();
	
		return  roleRep.findById(ref);
		
		
	}
	
	


}
