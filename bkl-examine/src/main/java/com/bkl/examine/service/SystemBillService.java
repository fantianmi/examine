package com.bkl.examine.service;

import com.bkl.examine.entity.Cash;
import com.bkl.examine.entity.Deal;
import com.bkl.examine.entity.Subscribe;
import com.bkl.examine.entity.Trade;
import com.bkl.examine.entity.Transfer;
import com.bkl.examine.entity.User;

public interface SystemBillService {

	public long doRecharge(Cash cash,User user);
	
	public long saveWithdraw(Cash cash,User user);
	public long doWithdraw(Cash cash,User user);
	public long cancelWithdraw(Cash cash,User user);
	
	public long doBtcRengou(Subscribe subscribe, User user);
	public long doBtcTransferIn(Transfer transfer,User user);
	
	public long saveBtcTransferOut(Transfer transfer,User user);
	public long doBtcTransferOut(Transfer transfer,User user);
	public long cancelBtcTransferOut(Transfer transfer,User user);
	
	public long buyBtc(Trade trade,User user);
	public long sellBtc(Trade trade,User user);
	
	
	/**
	 * 交易处理过程，买btc用户的系统流水
	 * @param buyTrade
	 * @param buyUser
	 * @param deal
	 * @return
	 */
	public long dealBuyBtc(Trade buyTrade,User buyUser,Deal deal, double buyDealPrice);
	
	/**
	 * 交易处理过程，卖btc用户的系统流水
	 * @param buyTrade
	 * @param buyUser
	 * @param deal
	 * @return
	 */
	public long dealSellBtc(Trade sellTrade,User sellUser,Deal deal, double sellDealPrice);
	
	public long cancelBuyBtcTrade(Trade trade,User buyUser);
	
	public long cancelSellBtcTrade(Trade trade,User sellUser);
	
	public long returnRmbOnBtcBuyTradeComplete(Trade trade,User buyUser);
	
	long doRecommendPaid(User paidUser, double btcAmount);
	
	void adjustUserMoneyByExtraCoin(double totalBtcExtra, double totalRmb);
	
}
