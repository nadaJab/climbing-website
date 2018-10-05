package org.climbing.business.contract.manager.user;

import org.climbing.model.beans.user.*;

import java.util.ArrayList;

public interface UserManager {
	
	//retourne la liste des utilisateurs 
	ArrayList<User> getListAllUser();
	
	//retourne l'utilisateur selon son account
	User returnUser(Account account);
	
	//ajouter un utilisateur
	void addUser(User user);
	
	//modifier un utilisateur ou bien mettre à jour
	void updateUser(User user);
	
	//supprimer un utilisateur
	void deleteUser(User user);

}
