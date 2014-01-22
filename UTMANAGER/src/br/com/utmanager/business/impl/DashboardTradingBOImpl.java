package br.com.utmanager.business.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.DashboardTradingBO;
import br.com.utmanager.business.dto.BalancoCompraVendaSemanal;
import br.com.utmanager.view.utils.DataUtils;

@Service
public class DashboardTradingBOImpl extends GenericBO implements DashboardTradingBO{

	@Override
	public List<BalancoCompraVendaSemanal> balancoCompraVendaSemanal() {
		Date now = new Date();
		Date last7Days =  get7LastDays(now);
		
		
		return getDashboardTradingDao().balancoCompraVendaSemanal(now, last7Days);
		
	}

	private Date get7LastDays(Date now) {
		Calendar last7Days = DataUtils.dateToCalendar(now);
		last7Days.set(Calendar.DAY_OF_MONTH, (last7Days.get(Calendar.DAY_OF_MONTH)-7));
		return last7Days.getTime();
		
	}


}
