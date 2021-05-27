package springlab.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springlab.dao.AnalyseRepository;
import springlab.dao.UtilisateursRepository;
import springlab.model.Analyse;
import springlab.model.Utilisateurs;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/v1")

public class AnalyseControlleur {
	
	@Autowired
	private AnalyseRepository  analyseRep;
	@Autowired

	
	//api get all analyses
	@RequestMapping(value="/analyses")
	public List<Analyse> getAnlyse() {
		
		return   analyseRep.findAll();
	}
	
	// api add analyse
	/**
	 * @param analyse
	 * @param user
	 * @return
	 */
	@PostMapping(value="/add/analyse/{user}")
	public Analyse createAnalyse(@RequestBody Analyse analyse ,
			@PathVariable(value="user")  Utilisateurs user) {
		Analyse analyse1 = new Analyse();
		analyse1.setUtilisateur(user);
		analyse1.setDate(analyse.getDate());
		analyse1.setDescription(analyse.getDescription());
		analyse1.setTitre(analyse.getTitre());
		
		return analyseRep.save(analyse1);
	}
}
