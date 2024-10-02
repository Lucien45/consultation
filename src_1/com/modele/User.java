package com.modele;

public class User extends AbstractUserModel {
	
	
	
	public User(int id, int age, int type_compte, String nom, String prenom, String sexe, String poste, String photo, String email, String password) {
		super(id, age, type_compte, nom, prenom, sexe, poste, photo, email, password);
	}

	@Override
	public void create_user() {
		// TODO Auto-generated method stub

	}

	@Override
	public void login() {
		// TODO Auto-generated method stub

	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
