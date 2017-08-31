package com.device.vaadin;

import org.vaadin.spring.events.EventBus;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.device.dao.DeviceDao;
import com.device.entity.Asset;
import com.vaadin.data.converter.LocalDateToDateConverter;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;

@UIScope
@SpringComponent
public class AssetForm extends AbstractForm<Asset> {

	private static final long serialVersionUID = 1L;
    
	EventBus.UIEventBus eventBus;
	DeviceDao deviceDao;
	
	TextField userId=new MTextField("userID");
	TextField typeId=new MTextField("typeID");
	TextField statusId=new MTextField("statusID");
	TextField hostName=new MTextField("HostName");
	TextField inventoryNr=new MTextField("InventoryName");
	TextField producer=new MTextField("Producer");
	TextField model=new MTextField("Model");
	TextField serialNumber=new MTextField("SerialNumber");
	TextField origin=new MTextField("Origin");
	DateField purchaseDate=new DateField("PurchaseDate");
	DateField expireDate=new DateField("ExpireDate");
	
	public AssetForm(DeviceDao deviceDao,EventBus.UIEventBus eventBus) {
		
		super(Asset.class);
		this.deviceDao=deviceDao;
		this.eventBus=eventBus;		
		
		setSavedHandler(asset->{
	        deviceDao.save(asset);
	        eventBus.publish(this, new AssetModifiedEvent(asset));
		});
		
		setResetHandler(a->eventBus.publish(this,new AssetModifiedEvent(a)));
		setSizeUndefined();		
	}
    
	protected void bind(){
		
		getBinder().forMemberField(purchaseDate)
		           .withConverter(new LocalDateToDateConverter());
		
		getBinder().forMemberField(expireDate)
		           .withConverter(new LocalDateToDateConverter());
		
		super.bind();
	}
	
	
	@Override
	protected Component createContent() {
		
		return new MVerticalLayout(
				new MFormLayout(
						userId,
						typeId,
						statusId,
						hostName,
						inventoryNr,
						producer,
						model,
						serialNumber,
						origin,
						purchaseDate,
						expireDate
						).withWidth(""),getToolbar()								
				).withWidth("");
	}

	
}
