package com.mytech.api.services.bill;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mytech.api.models.bill.Bill;
import com.mytech.api.models.recurrence.Recurrence;
import com.mytech.api.repositories.bill.BillRepository;
import com.mytech.api.services.recurrence.RecurrenceService;

@Service
public class BillServiceImpl implements BillService{
	
	private final BillRepository billRepository;
	private final RecurrenceService recurrenceService;
	
	public BillServiceImpl(BillRepository billRepository, RecurrenceService recurrenceService) {
		this.billRepository = billRepository;
		this.recurrenceService = recurrenceService;
	}

	@Override
	public List<Bill> findAllBill() {
		return billRepository.findAll();
	}

	@Override
	public List<Bill> findAllBillByUserId(int userId) {
		return billRepository.findAllBillByUserId(userId);
	}

	@Override
	public Bill findBillById(int billId) {
		return billRepository.findById(billId).orElse(null);
	}

	@Override
	public Bill addNewBill(Bill bill) {
		if (bill.getRecurrence() != null && bill.getRecurrence().getRecurrenceId() > 0) {
	        Recurrence recurrence = recurrenceService.findRecurrenceById(bill.getRecurrence().getRecurrenceId());
	        if (recurrence == null) {
	            throw new IllegalArgumentException("Recurrence with ID " + bill.getRecurrence().getRecurrenceId() + " does not exist.");
	        }
	        bill.setRecurrence(recurrence);
	    }
		return billRepository.save(bill);
	}

	@Override
	public void deleteBill(int billId) {
		billRepository.deleteById(billId);
	}

}
