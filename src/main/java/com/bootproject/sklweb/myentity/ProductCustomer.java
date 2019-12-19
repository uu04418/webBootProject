package com.bootproject.sklweb.myentity;

import com.bootproject.sklweb.entity.Product;

public class ProductCustomer  extends Product{
	
	// 类目名称
	private String categoryname ;
	
	// 类目上级名称
	private String fathername ;
	
	// 类目上级id
	private String fatherid ;
	
	
	//场合名称
	private String scenename ;
	
	

	public String getScenename() {
		return scenename;
	}

	public void setScenename(String scenename) {
		this.scenename = scenename;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getFatherid() {
		return fatherid;
	}

	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}
	
	
	
}
