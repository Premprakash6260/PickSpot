package com.deepthought.pickspot;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepthought.pickspot.dto.PickRequest;
import com.deepthought.pickspot.dto.PickResponse;
import com.deepthought.pickspot.services.PickerService;


@SpringBootApplication
@RestController
// @RequestMapping("/")
public class PickSpotApp {
	public static void main(String[] args) {
		SpringApplication.run(PickSpotApp.class, args);
	}

	private final PickerService picker;
	public PickSpotApp(PickerService picker) {
			this.picker = picker;
	}

	@PostMapping("/pickSpot")
	public ResponseEntity<?> pick(@RequestBody PickRequest req) {
			return picker.chooseBestSlot(req.getContainer(), req.getYardMap())
							.<ResponseEntity<?>>map(slot -> ResponseEntity.ok(
											new PickResponse(req.getContainer().getId(), slot.getX(), slot.getY())
							))
							.orElseGet(() -> ResponseEntity.badRequest().body(Map.of("error", "no suitable slot")));
	}
}
