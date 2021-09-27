package com.hrms.hrms.core.utilities.business;

import com.hrms.hrms.core.utilities.results.Result;

public class BusinessRules {
	public static Result Run(Result... rules) {
		for (Result rule : rules) {
			if (!rule.isSuccess()) {
				return rule;
			}
		}
		return null;
	}
}
