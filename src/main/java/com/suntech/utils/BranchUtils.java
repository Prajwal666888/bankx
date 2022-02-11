package com.suntech.utils;

import com.suntech.domain.Branches;

public class BranchUtils {
	
	public static Branches createBranch() {
		Branches branch = new Branches();
		branch.setType("Local");
		branch.setLocation("Davangere");
		return branch;
	}

	public static Branches changeBranch(Branches branch) {
		branch.setType("LCorporate");
		branch.setLocation("Harihar");
		return branch;
	}

}
