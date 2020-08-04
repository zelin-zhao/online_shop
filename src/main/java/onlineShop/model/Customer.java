package onlineShop.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "customer")
@Getter
@Builder
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 2652327633296064143L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String customerPhone;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(unique = true)
	private ShippingAddress shippingAddress;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(unique = true)
	private BillingAddress billingAddress;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(unique = true)
	private User user;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(unique = true)
	private Cart cart;
}