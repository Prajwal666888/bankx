
package com.suntech.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suntech.dao.RoleRepository;
import com.suntech.dao.UserRepository;
import com.suntech.domain.Account;
import com.suntech.domain.AccountType;
import com.suntech.domain.Bank;
import com.suntech.domain.Branches;
import com.suntech.domain.Card;
import com.suntech.domain.Customer;
import com.suntech.domain.CustomerQuery;
import com.suntech.domain.Employee;
import com.suntech.domain.Insurance;
import com.suntech.domain.Loans;
import com.suntech.model.AccountOpeningModel;

import com.suntech.request.LoginRequest;
import com.suntech.request.SignupRequest;
import com.suntech.response.JwtResponse;
import com.suntech.response.MessageResponse;

import com.suntech.service.AccountTypeService;
import com.suntech.service.BankService;
import com.suntech.service.BranchService;
import com.suntech.service.CardService;
import com.suntech.service.CustomerService;
import com.suntech.service.CustomerqueryService;
import com.suntech.service.EmployeeService;
import com.suntech.service.InsuranceService;
import com.suntech.service.LoanService;
import com.suntech.service.support.UserDetailsImpl;
import com.suntech.user.ERole;
import com.suntech.user.Role;
import com.suntech.user.User;
import com.suntech.utils.AccountUtils;
import com.suntech.utils.JwtUtils;
import com.suntech.utils.MailServiceUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author PRAJWAL.H R
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Component
public class BankxController {

	private static final String SUCCESS_MESSAGE = "Account has been successfully opened.";
	private static final String FAILURE_MESSAGE = "Failed to open account.";

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;

				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					break;

				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@Autowired
	private MailServiceUtils mailServiceUtils;

	@Autowired
	private BankService bankService;

	@Autowired
	private AccountUtils accountUtils;

	@Autowired
	private BranchService branchService;

	@Autowired
	private AccountTypeService accountTypeService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerqueryService customerqueryService;

	@Autowired
	private CardService cardService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private InsuranceService insuranceService;

	@Autowired
	private LoanService loanService;

	@JmsListener(destination = "${springjms.accountQueue}")
	public void receiveFromAccountQueue(String message) {
		String messageContent;
		String receiverEmail = "";
		try {
			Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
			AccountOpeningModel accountOpeningModel = gson.fromJson(message, AccountOpeningModel.class);

			Customer customer = accountOpeningModel.getCustomer();
			receiverEmail = customer.getEmail();
			customerService.createAndSave(customer);
			Account account = accountOpeningModel.getAccount();
			Long accountNumber = accountUtils.generateAccountNumber();
			account.setAccountNo(accountNumber);
			AccountType accountType = accountOpeningModel.getAccountType();

			messageContent = "Congratulation's you have successfully created your bank account."
					+ " and your accountNumber is " + accountNumber;
			accountType.setAccount(account);
			account.setCustomer(customer);
			account.setAccountType(accountType);
			accountTypeService.createAndSave(accountType);
			mailServiceUtils.sendmail(receiverEmail, messageContent, Boolean.TRUE, SUCCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			messageContent = "Sorry ,unable to create bank account ;(";
			if (StringUtils.hasText(receiverEmail)) {
				try {
					mailServiceUtils.sendmail(receiverEmail, messageContent, Boolean.FALSE, FAILURE_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	@JmsListener(destination = "${springjms.customerQueue}")
	public void receiveFromCustomerQueue(String message) {
		Gson gson = new Gson();
		CustomerQuery customerQuery = gson.fromJson(message, CustomerQuery.class);
		customerqueryService.createAndSaveCustomerquery(customerQuery);
	}

	@JmsListener(destination = "${springjms.loanQueue}")
	public void receiveFromLoanQueue(String message) {
		System.out.println("Message==>" + message);
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		Loans loans = gson.fromJson(message, Loans.class);
		loanService.createAndSaveLoans(loans);

	}

	@JmsListener(destination = "${springjms.cardQueue}")
	public void receiveFromcardQueue(String message) {
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		Card card = gson.fromJson(message, Card.class);
		cardService.addCard(card);

	}

	@ApiOperation(value = "Add a bank", response = Bank.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/bank")
	@PreAuthorize("hasRole('ADMIN')")
	public Bank insertBank(@RequestBody() Bank bank) {
		bankService.createAndSaveBank(bank);
		return bank;
	}

	@ApiOperation(value = "Add a Branch", response = Branches.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/branch")
	@PreAuthorize("hasRole('ADMIN')")
	public Branches insertBranches(@RequestBody() Branches branches) {
		branchService.createAndSaveBranch(branches);
		return branches;
	}

	@ApiOperation(value = "Add a card", response = Card.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/card")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public Card addCard(@RequestBody() Card card) {
		return cardService.addCard(card);
	}

	@ApiOperation(value = "Add a Employee", response = Employee.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/employee")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee insertEmployee(@RequestBody() Employee employee) {
		employeeService.createandSave(employee);
		return employee;
	}

	@ApiOperation(value = "Add a Insurance", response = Insurance.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/insurance")
	@PreAuthorize("hasRole('ADMIN')")
	public Insurance insertInsurance(@RequestBody() Insurance insurance) {
		insuranceService.createAndSaveInsurance(insurance);
		return insurance;
	}

	@ApiOperation(value = "List of Insurance", response = Insurance.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/insurance")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Insurance> getInsurance() {
		return insuranceService.findAll();

	}

	@GetMapping("/insurance/{id}")
	public Insurance getInsurances(@PathVariable() Integer id) {
		return insuranceService.find(id);
	}

}