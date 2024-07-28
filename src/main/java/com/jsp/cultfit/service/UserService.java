package com.jsp.cultfit.service;

import java.io.File;

import java.time.LocalDateTime;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jsp.cultfit.dao.UserCrud;
import com.jsp.cultfit.dto.Register;
import com.jsp.cultfit.dto.UserClone;
import com.jsp.cultfit.entity.User;
import com.jsp.cultfit.exception.EmailNotFoundException;
import com.jsp.cultfit.exception.PasswordWrongException;
import com.jsp.cultfit.exception.UserNotFoundException;
import com.jsp.cultfit.repo.UserRepo;
import com.jsp.cultfit.util.ResponseStructure;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserService {

	@Autowired
	UserCrud crud;

	@Autowired
	ModelMapper mapper;

	@Autowired
	UserRepo repo;

	@Autowired
	JavaMailSender emailsender;

	public ResponseEntity<ResponseStructure<Register>> saveUser(Register register) throws MessagingException {

		User user = mapper.map(register, User.class);
		User db = crud.save(user);
		sendMailWithAttachment(user);
		ResponseStructure<Register> res = new ResponseStructure<Register>();
		res.setData(register);
		res.setMessage("Data Saved Succesfully");
		res.setStatus(HttpStatus.CREATED.value());
		res.setDate(LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<Register>>(res, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<UserClone>> loginUser(String email, String password) {

		User db = repo.findByEmail(email);
		if (db != null) {
			if (db.getPassword().equals(password)) {
				UserClone obj = mapper.map(db, UserClone.class);
				ResponseStructure<UserClone> res = new ResponseStructure<UserClone>();
				res.setData(obj);
				res.setMessage("Logged In Succesfully");
				res.setStatus(HttpStatus.OK.value());
				res.setDate(LocalDateTime.now());
				return new ResponseEntity<ResponseStructure<UserClone>>(res, HttpStatus.OK);

			} else {
				throw new PasswordWrongException();
			}
		} else {
			throw new EmailNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<UserClone>> fetchUser(int id) {

		User db = crud.fetch(id);
		if (db != null) {
			UserClone obj = mapper.map(db, UserClone.class);
			ResponseStructure<UserClone> res = new ResponseStructure<UserClone>();
			res.setData(obj);
			res.setMessage("Data Fetched Succesfully");
			res.setStatus(HttpStatus.FOUND.value());
			res.setDate(LocalDateTime.now());
			return new ResponseEntity<ResponseStructure<UserClone>>(res, HttpStatus.FOUND);
		} else {
			throw new UserNotFoundException();
		}

	}
	
	public ResponseEntity<ResponseStructure<UserClone>> deleteUser(int id) {

		User db = crud.delete(id);
		if (db != null) {
			UserClone obj = mapper.map(db, UserClone.class);
			ResponseStructure<UserClone> res = new ResponseStructure<UserClone>();
			res.setData(obj);
			res.setMessage("Data Deleted Succesfully");
			res.setStatus(HttpStatus.GONE.value());
			res.setDate(LocalDateTime.now());
			return new ResponseEntity<ResponseStructure<UserClone>>(res, HttpStatus.GONE);
		} else {
			throw new UserNotFoundException();
		}

	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {

		User db = crud.update(user);
		if (db != null) {
			ResponseStructure<User> res = new ResponseStructure<User>();
			res.setData(db);
			res.setMessage("Data Updated Succesfully");
			res.setStatus(HttpStatus.OK.value());
			res.setDate(LocalDateTime.now());
			return new ResponseEntity<ResponseStructure<User>>(res, HttpStatus.OK);
		} else {
			throw new UserNotFoundException();
		}

	}

	
	
	
	
	
	
	public void sendMsg(String email) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("madyalla18@gmail.com");
		message.setTo(email);
		message.setSubject("");
		message.setText("");

		emailsender.send(message);
	}

	public void sendOtp(String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("madyalla18@gmail.com");
		message.setTo(email);
		message.setSubject("Hlo Buddy....");
		Random random = new Random();
		int otp = random.nextInt(900000);
		message.setText("OTP verification \n" + "enter the otp as" + otp);
		emailsender.send(message);
	}

	public void sendMailWithAttachment(User user) throws MessagingException {

		// Creating a mime message

		MimeMessage mimeMessage = emailsender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		// Setting multipart as true for attachments to be send

		mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom("madyalla18@gmail.com");
		mimeMessageHelper.setTo(user.getEmail());
		mimeMessageHelper.setSubject("Revitalize Your Workout Routine: New Gym Offer Inside!");
		mimeMessageHelper.setText(
						
						 "Dear ["+user.getF_name()+"],\r\n"
						+ "\r\n"
						+ "Are you ready to take your fitness journey to the next level? Look no further! We're excited to introduce our exclusive gym content designed to help you achieve your fitness goals effectively and efficiently.\r\n"
						+ "\r\n"
						+ "Whether you're a beginner looking to kickstart your fitness journey or a seasoned gym-goer seeking fresh inspiration, our content has something for everyone. From expert workout routines tailored to target specific muscle groups to nutrition tips that fuel your body for optimal performance, we've got you covered.\r\n"
						+ "\r\n"
						+ "Here's a sneak peek at what you can expect from our gym content:\r\n"
						+ "\r\n"
						+ "1. *Workout Plans:* Access comprehensive workout plans curated by fitness experts to help you build strength, improve endurance, and sculpt your dream physique.\r\n"
						+ "2. *Exercise Demonstrations:* Learn proper form and technique with step-by-step exercise demonstrations for a variety of movements, ensuring you get the most out of every rep.\r\n"
						+ "3. *Nutrition Guidance:* Unlock the secrets to fueling your body for success with practical nutrition tips, meal plans, and healthy recipe ideas to support your fitness goals.\r\n"
						+ "4. *Motivational Content:* Stay inspired and motivated on your fitness journey with uplifting stories, success tips, and expert advice from seasoned athletes and trainers.\r\n"
						+ "5. *Exclusive Offers:* Enjoy exclusive discounts, promotions, and special offers on gym memberships, fitness gear, and supplements to enhance your training experience.\r\n"
						+ "\r\n"
						+ "Ready to elevate your fitness game? Sign up now to gain access to our premium gym content and start crushing your goals today!\r\n"
						+ "\r\n"
						+ "To your health and fitness success,\r\n"
						+ "\r\n"
						+ "[Your Gym Name:CultFit]\r\n");

		// Adding the attachment

		//FileSystemResource file = new FileSystemResource(new File(email.getAttachment()));
		FileSystemResource file = new FileSystemResource(
				new File("C:\\Users\\HP\\Downloads\\gym.jpg"));

		mimeMessageHelper.addAttachment(file.getFilename(), file);

		// Sending the mail

		emailsender.send(mimeMessage);

	}

}
