/**
 * 
 */
package com.dineshonjava.sbmdb.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dineshonjava.sbmdb.models.Booking;
import com.dineshonjava.sbmdb.models.BookingRepository;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
@RequestMapping("/api")
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepository;
	/**
	 * GET /create  --> Create a new booking and save it in the database.
	 */
	@PostMapping("/create")
	public Map<String, Object> create(Booking booking) {
		booking.setTravelDate("18-04-2019");
		booking = bookingRepository.save(booking);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking created successfully");
		dataMap.put("status", "1");
		dataMap.put("booking", booking);
	    return dataMap;
	}
	
	/**
	 * GET /read  --> Read a booking by booking id from the database.
	 */
	@GetMapping("/read")
	public Map<String, Object> read(@RequestParam String bookingId) {
		Booking booking = bookingRepository.findById(bookingId).get();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking found successfully");
		dataMap.put("status", "1");
		dataMap.put("booking", booking);
	    return dataMap;
	}
	
	/**
	 * GET /update  --> Update a booking record and save it in the database.
	 */
	@PutMapping("/update")
	public Map<String, Object> update(@RequestParam String bookingId, @RequestParam String psngrName) {
		Booking booking = bookingRepository.findById(bookingId).get();
		booking.setPsngrName(psngrName);
		booking = bookingRepository.save(booking);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking updated successfully");
		dataMap.put("status", "1");
		dataMap.put("booking", booking);
	    return dataMap;
	}
	
	/**
	 * GET /delete  --> Delete a booking from the database.
	 */
	@DeleteMapping("/delete")
	public Map<String, Object> delete(@RequestParam String bookingId) {
		bookingRepository.deleteById(bookingId);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking deleted successfully");
		dataMap.put("status", "1");
	    return dataMap;
	}
	
	/**
	 * GET /read  --> Read all booking from the database.
	 */
	@GetMapping("/read-all")
	public Map<String, Object> readAll() {
		List<Booking> bookings = bookingRepository.findAll();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Booking found successfully");
		dataMap.put("totalBooking", bookings.size());
		dataMap.put("status", "1");
		dataMap.put("bookings", bookings);
	    return dataMap;
	}
}
