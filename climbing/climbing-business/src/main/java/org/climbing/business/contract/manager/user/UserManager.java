package org.climbing.business.contract.manager.user;

import org.climbing.model.beans.user.*;

import java.util.ArrayList;

public interface UserManager {


	//ajouter un utilisateur
	void createUser(User user);
	
	//retourne la liste des utilisateurs 
	ArrayList<User> getListAllUser();

	//modifier un utilisateur ou bien mettre à jour
	void updateUser(User user);
	
	//supprimer un utilisateur
	void deleteUser(User user);

}
