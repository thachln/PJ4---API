package com.mytech.api.models.bill;

import java.math.BigDecimal;
import java.util.Date;

import com.mytech.api.models.recurrence.RecurrenceDTO;
import com.mytech.api.models.user.UserDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillDTO {

	private int billId;

	private UserDTO user;

	private String billName;

	private BigDecimal amount;

	private Date dueDate;

	private RecurrenceDTO recurrence;

	public BillDTO(int billId, UserDTO user, String billName, BigDecimal amount, Date dueDate,
			RecurrenceDTO recurrence) {
		this.billId = billId;
		this.user = user;
		this.billName = billName;
		this.amount = amount;
		this.dueDate = dueDate;
		this.recurrence = recurrence;
	}
}