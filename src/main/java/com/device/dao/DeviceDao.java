package com.device.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.device.entity.Asset;

public interface DeviceDao extends JpaRepository<Asset, Integer>{
	
	
	@Query("SELECT asse.inventoryNumber,concat(us.name,' ',us.lastName) AS userName,asse.producer,asse.model,asse.serialNumber,asse.origin,asse.purchaseDate,ty.type,st.status"
			+ " FROM Asset asse "
			+ " LEFT JOIN asse.user us"
			+ " LEFT JOIN asse.type ty"
			+ " LEFT JOIN asse.status st")
	List<Object> getAllAssetsInfo();
		
	@Query("SELECT asse.inventoryNumber,concat(us.name,' ',us.lastName) AS userName,asse.producer,asse.model,asse.serialNumber,asse.origin,asse.purchaseDate,ty.type,st.status"
			+ " FROM Asset AS asse,User AS us,Type AS ty,Status AS st WHERE concat(us.name,' ',us.lastName)=?1")
	List<Object> findByNameLikeIgnoreCase(String nameFilter);
}
