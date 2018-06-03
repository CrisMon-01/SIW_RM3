package repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Customer;
import repository.CustomerRepository;
public class CustomerJPARepository implements CustomerRepository{
	private EntityManager em;
	EntityTransaction tx;
	public CustomerJPARepository(EntityManager em){	//mi passano em per fare multi op con ! E.M.
		this.em=em;
		tx = em.getTransaction();
	}
	@Override
	public Customer save(Customer customer) {
		if(customer.getId()!=null) {	//uso Long invece di long
		Customer customerdb = findByPrimaryKey(customer.getId());
		if(customerdb==null)
			em.persist(customer);
		else
			em.merge(customer);
		}
		else
			em.persist(customer);
		return customer;
	}
	@Override
	public Customer findByPrimaryKey(Long id) {		
		return em.find(Customer.class, id);
	}
	@Override
	public List<Customer> findALl() {
		List<Customer> customers = em.createNamedQuery("findAllCustomers",Customer.class).getResultList();
		return customers;
	}
	@Override
	public void update(Customer customer) {
		em.merge(customer);
	}
	@Override
	public void delete(Customer customer) {	
		em.remove(customer);
	}
}
