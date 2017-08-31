package com.device.vaadin;

import java.io.Serializable;

import com.device.entity.Asset;

public class AssetModifiedEvent implements Serializable{

	private static final long serialVersionUID = 1L;
    private final Asset asset;
    
    public AssetModifiedEvent(Asset asset){
    	this.asset=asset;
    }
    
    public Asset getAsset(){
    	return asset;
    }
	
}
