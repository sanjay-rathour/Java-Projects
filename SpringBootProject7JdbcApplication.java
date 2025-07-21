package in.sp.main;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

@SpringBootApplication
public class SpringBootProject7JdbcApplication implements CommandLineRunner {
	
	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject7JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// INSERTION..................................
		
		
		
//		User user1 = new User("sanjay","sanjay@mail.com","male","delhi");
//		
//	    boolean status = userDao.insertUser(user1);
//	    
//		if(status) {
//			System.out.println(" insertion successful");
//		}
//		else {
//			System.out.println("not inserted");
//		}
		
		
		
		
		// UPDATION.........................
		
		
//		
//		User user = new User("deepak", "deepak@mail.com", "male", "chndigr");
//		boolean status = userDao.updateUser(user);
//		
//		if(status) {
//			System.out.println("updation successful");
//		}else {
//			System.out.println("failed");
//		}
//		
//		
		
		// DELETION......................................
//		
//		User user = new User("deepak", "sanjayX@mail.com", "male", "chndigr");
//		boolean status = userDao.deleteUserByEmail(user);
//		
//		if(status) {
//			System.out.println("deletion success");
//		}else {
//			System.out.println("failed");
//		}
		
		
		
		// SELECT ONE USER.....................................
		
		
//		User user = userDao.getUserByEmail("sanjay@mail.com");
//		System.out.println("Name :"+user.getName());
//		System.out.println("Email :"+user.getEmail());
//		System.out.println("Gender :"+user.getGender());
//		System.out.println("City :"+user.getCity());
		
		
		// GET ALL USER.........................

		List<User> list =  userDao.getAllUsers();
		
		for(User user : list) {
		
			System.out.println("Name :"+user.getName());
			System.out.println("Email :"+user.getEmail());
			System.out.println("Gender :"+user.getGender());
			System.out.println("City :"+user.getCity());
			System.out.println(".........................................");
			
		}

	}

}
