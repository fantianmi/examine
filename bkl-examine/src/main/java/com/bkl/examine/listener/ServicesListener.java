package com.bkl.examine.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bkl.examine.ExamineConfig;
import com.bkl.examine.service.ExtraService;
import com.bkl.examine.service.impl.ExtraServiceImpl;
import com.km.common.utils.CrontabRunner;

public class ServicesListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		try {
			if (ExamineConfig.isEnableCoinExtra()) {
				class CoinExtraAjustTask implements Runnable {
					public void run() {
						ExtraService serv = new ExtraServiceImpl();
						serv.adjustUserExtraCoin();
					}
				}
				;
				CrontabRunner crun = new CrontabRunner(
						ExamineConfig.getDefaultCoinExtraCronsExpression(),
						new CoinExtraAjustTask());
				crun.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
