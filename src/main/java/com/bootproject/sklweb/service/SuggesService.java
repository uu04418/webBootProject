package com.bootproject.sklweb.service;

import java.util.List;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.entity.Sugges;

public interface SuggesService {

	APIResponse addSugges(Sugges sugges);

	Integer suggeslistCount();

	List<Sugges> suggeslist();

}
