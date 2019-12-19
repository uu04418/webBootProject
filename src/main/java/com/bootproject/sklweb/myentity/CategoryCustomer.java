package com.bootproject.sklweb.myentity;

import java.util.List;

import com.bootproject.sklweb.entity.Category;

public class CategoryCustomer extends Category {
	private List<Category> sonlist ;

	public List<Category> getSonlist() {
		return sonlist;
	}

	public void setSonlist(List<Category> sonlist) {
		this.sonlist = sonlist;
	}
	
	
}
