package com.duongvh.restaurant.service.voucher;

import com.duongvh.restaurant.model.Voucher;
import com.duongvh.restaurant.service.IGeneralService;

public interface IVoucherService extends IGeneralService<Voucher> {
	
	Iterable<Voucher> findAllByVoucherValid();
	
	Iterable<Voucher> findAllByVoucherExpired();
	
	Iterable<Voucher> findAllByVoucherIsDeleted();

	Iterable<Voucher> findVouchersIsApply();
}
