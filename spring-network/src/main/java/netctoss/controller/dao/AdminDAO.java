package netctoss.controller.dao;

import org.springframework.stereotype.Repository;

import netctoss.controller.entity.Admin;

@Repository("adminDAO")
public interface AdminDAO {
  public Admin findByAdminCode(String adminCode);
	
	
}
