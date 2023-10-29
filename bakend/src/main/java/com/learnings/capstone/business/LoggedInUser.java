package com.learnings.capstone.business;


import com.learnings.capstone.entity.Users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoggedInUser {
    private Users loggedUser;

	public Users getLoggedInUser() {
		return loggedUser;
	}

	public void setLoggedInUser(Users loggedUser) {
		this.loggedUser = loggedUser;
	}

	}
