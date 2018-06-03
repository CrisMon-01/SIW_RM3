package repository;

import java.util.List;

import model.Customer;

public interface CustomerRepository {

	public Customer save(Customer customer);
	public Customer findByPrimaryKey(Long id);
	public List<Customer> findALl();
	public void update(Customer customer);
	public void delete(Customer customer);
	
}
