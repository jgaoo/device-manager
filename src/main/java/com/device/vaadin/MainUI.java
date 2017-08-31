package com.device.vaadin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.EventScope;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;
import org.vaadin.viritin.button.ConfirmButton;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.grid.MGrid;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.device.dao.DeviceDao;
import com.device.entity.Asset;
import com.device.entity.Device;

import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;


@Theme("valo")
@SpringUI
public class MainUI extends UI{

	private static final long serialVersionUID = 1L;
    
	DeviceDao deviceDao;
	AssetForm assetForm;
	EventBus.UIEventBus eventBus;
	List<Device> deviceList;
	
	private MGrid<Device> list=new MGrid<>(Device.class)
			.withProperties("inventoryNr","userName","producer","model","seriesNr","origin","dateOfPurchase","type","status")
			.withColumnHeaders("inventoryNumber","userName","producer","model","seriesNr","origin","dateOfPurchase","type","status")
			.withFullWidth();
	
	private MTextField filterByName=new MTextField()
			.withPlaceholder("Filter by name");
	
	private Button addNew = new MButton(VaadinIcons.PLUS,this::add);
    private Button edit = new MButton(VaadinIcons.PENCIL,this::edit);
    private Button delete = new ConfirmButton(VaadinIcons.TRASH,
    		"Are you sure you want to delete the entry?", this::remove);
			
    public MainUI(DeviceDao deviceDao, AssetForm assetForm, EventBus.UIEventBus b) {
    	this.deviceDao=deviceDao;
    	this.assetForm=assetForm;
        this.eventBus = b;
    }
	
	@Override
	protected void init(VaadinRequest request) {
		
	    setContent(
                new MVerticalLayout(
                        new MHorizontalLayout(filterByName, addNew, edit, delete),
                        list
                ).expand(list)
        );
	    
	    listEntities();
	    //List<Object> objList = (List<Object>) deviceDao.findByNameLikeIgnoreCase("Jie Gao");
	    List<Object> objList = (List<Object>) deviceDao.getAllAssetsInfo();
	    deviceList=new ArrayList<Device>();
	    deviceList=convertObject(objList);
  		list.setRows(deviceList);
          
          adjustActionButtonState();
	    
        list.asSingleSelect().addValueChangeListener(e -> adjustActionButtonState());
        filterByName.addValueChangeListener(e -> {
           
        });

   
        eventBus.subscribe(this);
	}
    

	private List<Device> convertObject(List<Object> listObjects){
		
		
  		Iterator<Object> itr=listObjects.iterator();
  		while(itr.hasNext())
  		{   
  			Object[] obj=(Object[])itr.next();
  			String inventoryNumber = String.valueOf(obj[0]); // don't know the type of column CLIENT assuming String
  			String userName = String.valueOf(obj[1]);
  			String producer=String.valueOf(obj[2]);
  			String model = String.valueOf(obj[3]);
  			String seriesNr=String.valueOf(obj[4]);
  			String origin = String.valueOf(obj[5]);
  			String dateOfPurchase=String.valueOf(obj[6]);
  			String type = String.valueOf(obj[7]);
  			String status=String.valueOf(obj[8]);
  			Device device=new Device();
  			device.setInventoryNr(inventoryNumber);
  			device.setUserName(userName);
  			device.setProducer(producer);
  			device.setModel(model);
  			device.setSeriesNr(seriesNr);
  			device.setOrigin(origin);
  			device.setDateOfPurchase(dateOfPurchase);
  			device.setType(type);
  			device.setStatus(status);
  			deviceList.add(device);			
  		}
  		
  		return deviceList;
	} 
	
	 
    private void listEntities() {
		
		  listEntities(filterByName.getValue());
	  }
  
    final int PAGESIZE=40;
      
    private void listEntities(String nameFilter){
    	  
    	

      }
      
	public void add(ClickEvent clickEvent) {
	       edit(new Asset());
	    }

	  public void edit(ClickEvent e) {
	        //edit(list.asSingleSelect().getValue());
	    }
	  public void remove() {
	        
	    }
      
	  protected void edit(final Asset assetEntry){
		  assetForm.setEntity(assetEntry);
		  assetForm.openInModalPopup();
 	  }
	  
	  @EventBusListenerMethod(scope = EventScope.UI)
	  public void onPersonModified(AssetModifiedEvent event) {
	        listEntities();
	        assetForm.closePopup();
	  }
	  
	  protected void adjustActionButtonState() {
		 boolean hasSelection = !list.getSelectedItems().isEmpty();
	        edit.setEnabled(hasSelection);
	        delete.setEnabled(hasSelection);
	}
	

}
