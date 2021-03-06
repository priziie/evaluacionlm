package com.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.bank.entity.BnkBenBeneficiary;

public interface BeneficiaryRepository extends CrudRepository<BnkBenBeneficiary, Integer> {
	public BnkBenBeneficiary findByBenUsrcodAndBenAccountAndBenStatus(String usr, String accid, String status);
	public boolean existsByBenUsrcodAndBenAccountAndBenStatus(String usr, String accid, String status);
	public boolean existsByBenUsrcodAndBenCodeAndBenStatus(String usr, Integer benid, String status);
	public BnkBenBeneficiary findByBenCodeAndBenUsrcodAndBenStatus(Integer benid, String usr, String status);
}
