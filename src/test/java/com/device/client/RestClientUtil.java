package com.device.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.device.entity.Device;

public class RestClientUtil {
	
	public void getDeviceByIdDemo() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/device/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Device> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Device.class,1);
		/*Device device = responseEntity.getBody();
		
		System.out.println("Id:" + device.getDeviceId() + ", InventoryNr:" + device.getInventoryNr() + ", user:"
				+ device.getUser() + ", producer:" + device.getProducer() + ", Model:" + device.getModel()
				+ ", seriesNr:" + device.getSeriesNr() + ", origin:" + device.getOrigin() + ", dateOfPurchase:"
				+ device.getDateOfPurchase() + ", type:" + device.getType() + ", status:" + device.getStatus());*/
	}

	public void getAllDevicesDemo() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/devices";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Device[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,Device[].class);
		
		/*Device[] Devices = responseEntity.getBody();	
		for (Device device : Devices) {
			System.out.println("Id:" + device.getDeviceId() + ", InventoryNr:" + device.getInventoryNr() + ", user: "
					+ device.getUser() + ", producer:" + device.getProducer() + ", Model:" + device.getModel()
					+ ", seriesNr:" + device.getSeriesNr() + ", origin:" + device.getOrigin() + ", dateOfPurchase:"
					+ device.getDateOfPurchase() + ", type:" + device.getType() + ", status:" + device.getStatus());
		}*/
	}

	public void addDeviceDemo() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/device";
		Device objDevice = new Device();
		objDevice.setInventoryNr("651007");
		objDevice.setProducer("Apple");
		objDevice.setModel("Mac Mini");
		objDevice.setSeriesNr("CO7G4476DJD0");
		objDevice.setOrigin("Adam");
		//objDevice.setDateOfPurchase("28.10.2011");
		objDevice.setType("PC");
		HttpEntity<Device> requestEntity = new HttpEntity<Device>(objDevice, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());
	}

	public void updateDeviceDemo() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/device";
		Device objDevice = new Device();
		
		/*objDevice.setDeviceId(1);
		objDevice.setInventoryNr("Update:Java Concurrency");
		objDevice.setUser("Java");*/
		
		HttpEntity<Device> requestEntity = new HttpEntity<Device>(objDevice, headers);
		restTemplate.put(url, requestEntity);
	}

	public void deleteDeviceDemo() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/device/{id}";
		HttpEntity<Device> requestEntity = new HttpEntity<Device>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
	}

	public static void main(String args[]) {
		
		RestClientUtil util = new RestClientUtil();
		//util.getDeviceByIdDemo();
		util.getAllDevicesDemo();
		//util.addDeviceDemo();
		// util.updateDeviceDemo();
		// util.deleteDeviceDemo();
	}
}
