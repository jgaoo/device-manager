package com.device.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.device.dao.DeviceDao;

/*import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;*/


@Controller
@RequestMapping("user")
public class DeviceController {
	
	
	@Autowired
	private DeviceDao deviceDao;
	/*@Autowired
	private IDeviceService DeviceService;
	
	@GetMapping("device/{id}")
	public ResponseEntity<Device> getDeviceById(@PathVariable("id") Integer id) {	
		
		Device device = DeviceService.getDeviceById(id);
		return new ResponseEntity<Device>(device, HttpStatus.OK);
	}
	
	@GetMapping("asset/{id}")
	public ResponseEntity<Asset> getAssetById(@PathVariable("id") Integer id) {	
		
		Asset asset = DeviceService.getAssetById(id);
		return new ResponseEntity<Asset>(asset,HttpStatus.OK);
	}*/
	
	@GetMapping("devices")
    public ResponseEntity<List<Object>> getAllAssetsInfo() {
				
		List<Object> list = (List<Object>) deviceDao.getAllAssetsInfo();
		return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
	}
	/*@PostMapping("device")
	public ResponseEntity<Void> addDevice(@RequestBody Device Device, UriComponentsBuilder builder) {
		
        boolean flag = DeviceService.addDevice(Device);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/device/{id}").buildAndExpand(Device.getDeviceId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("device")
	public ResponseEntity<Device> updateDevice(@RequestBody Device Device) {
		DeviceService.updateDevice(Device);
		return new ResponseEntity<Device>(Device, HttpStatus.OK);
	}
	
	@DeleteMapping("device/{id}")
	public ResponseEntity<Void> deleteDevice(@PathVariable("id") Integer id) {
		DeviceService.deleteDevice(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	*/
} 