
package com.nt.service;


import java.util.List;

import com.nt.documnets.StockDetail;


public interface IStockMgntService {

	public String registorStockDetails(StockDetail dtl);
	public String registerStockDetailBatch(List<StockDetail> list);
	public List<StockDetail> searchByexcechangeName(String name);
	public List<StockDetail> serchByStockPriceInRange(int min,int max);
	public StockDetail featchStockDtailsByStokID(int stockId);
	
	public String findAndUpdateById(int stockId);
	public String modifingExchnageByStockPriceRange(double startRange,Double endRange,String newExchangeName);
	public String RegisterOrUpdateByStockName(String stockname,double newPrice,String newStockName);
	public String featchAndRemoveTheDocumentByStockName(String stockName);
	public String FeatchAndRemoveAllByStockName(String stockName);
}
