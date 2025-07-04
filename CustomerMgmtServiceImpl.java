package in.abc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.abc.bo.CustomerBO;
import in.abc.dao.ICustomerDAO;
import in.abc.dto.CustomerDTO;

@Service(value = "service")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerDAO dao;

	static {
		System.out.println("CustomerMgmtServiceImpl.class file is loading...");
	}

	public CustomerMgmtServiceImpl(ICustomerDAO dao) {
		System.out.println("CustomerMgmtServiceImpl :: one param constructor...");
		this.dao = dao;
	}

	@Override
	public String calculateSimpleInterest(CustomerDTO dto) {

		float intrAmt = 0.0f;

		intrAmt = (dto.getPamt() * dto.getTime() * dto.getRate()) / 100.0f;

		CustomerBO bo = new CustomerBO();

		bo.setCustomerAddress(dto.getCustomerAddress());
		bo.setCustomerName(dto.getCustomerName());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setInterestAmt(intrAmt);

		int count = dao.insert(bo);
		// process the result
		if (count == 0)
			return "Customer Registration failed :: " + dto.getPamt() + " Interest :: " + intrAmt;
		else
			return "Customer Registration Successfull :: " + dto.getPamt() + " Interest :: " + intrAmt;

	}

}
