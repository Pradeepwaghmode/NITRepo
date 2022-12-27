package com.nt.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.documnets.StockDetail;

@Service
public class StockMgntService implements IStockMgntService {

	@Autowired
	private MongoTemplate template;

	@Override
	public String registorStockDetails(StockDetail dtl) {
		// int result=template.save(dtl).getId();//inserting rcord in db save document
		// by class name
		// int result=template.insert(dtl,"stock").getId();//inserting rcord in db and
		// save document name stock
		int result = template.insert(dtl).getId();// inserting rcord in db save document by class name
		return "Record Registored with id : " + result;
	}

	@Override
	public String registerStockDetailBatch(List<StockDetail> list) {
		List<StockDetail> result = (List<StockDetail>) template.insertAll(list);
		return result.size() + " Record saved succesfully !!";
	}

	@Override
	public List<StockDetail> searchByexcechangeName(String name) {

		Query query = new Query();

		query.addCriteria(Criteria.where("excechangeName").is(name));

		return template.find(query, StockDetail.class);
	}

	@Override
	public List<StockDetail> serchByStockPriceInRange(int min, int max) {
		Query query = new Query();
		query.addCriteria(Criteria.where("stockPrice").gt(min).lt(max));

		return template.find(query, StockDetail.class);
	}

	@Override
	public StockDetail featchStockDtailsByStokID(int stockId) {
		// TODO Auto-generated method stub
		return template.findById(stockId, StockDetail.class);
	}

	@Override
	public String findAndUpdateById(int stockId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(stockId));

		Update update = new Update();
		update.set("stockPrice", 2000);
		update.set("excechangeName", "INSTEX");

		StockDetail stock = template.findAndModify(query, update, StockDetail.class);

		return stock == null ? "Record not found for Update, thank you !!"
				: "Record updated succsefully , Thank you !! ";
	}

	@Override
	public String modifingExchnageByStockPriceRange(double startRange, Double endRange, String newExchangeName) {
		Query query = new Query();
		query.addCriteria(
				Criteria.where("stockPrice").gte(startRange).andOperator(Criteria.where("stockPrice").lte(endRange)));

		Update update = new Update();

		update.set("excechangeName", newExchangeName);
		UpdateResult result = template.updateMulti(query, update, StockDetail.class);
		long noOfAffected = result.getModifiedCount();
		return noOfAffected == 0 ? "Record not found for Update, thank you !!"
				: noOfAffected + " Record's updated succsefully , Thank you !! ";
	}

	@Override
	public String RegisterOrUpdateByStockName(String stockname, double newPrice, String newStockName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("sname").is(stockname));
		Update update = new Update();
		update.set("excechangeName", newStockName);
		update.set("stockPrice", newPrice);
		update.setOnInsert("id", new Random().nextInt(1000));
		update.setOnInsert("sname", stockname);

		UpdateResult result = template.upsert(query, update, StockDetail.class);
		long noOfAffected = result.getModifiedCount();
		return noOfAffected == 0 ? "Record inserted sucussefully by id : " + result.getUpsertedId()
				: noOfAffected + " Record's updated succsefully , Thank you !! ";
	}

	@Override
	public String featchAndRemoveTheDocumentByStockName(String stockName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("sname").is(stockName));

		StockDetail stock = template.findAndRemove(query, StockDetail.class);

		return stock == null ? "stock not found "
				: "stock id : " + stock.getId() + " and name : " + stock.getSname() + " are deleted succusefully !!";
	}

	@Override
	public String FeatchAndRemoveAllByStockName(String stockName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("sname").is(stockName));

		List<StockDetail> stock = template.findAllAndRemove(query, StockDetail.class);

		return stock == null ? "stock not found " : stock.size() + "  are deleted succusefully !!";
	}

}
