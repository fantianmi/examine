package com.bkl.examine.service;

import java.util.List;

import com.bkl.examine.entity.ExtraRmbAdjust;

public interface ExtraService {
	void adjustUserExtraCoin();
	public double getTotalBtcExtraAmount();
	void adjustUserMoneyByExtraCoin(double totalRmb);
}
