package springlab.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import springlab.model.Role;

public interface  RoleRepository extends JpaRepository<Role,Integer>  {

}
