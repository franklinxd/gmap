package com.fnk.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Franklin Ramos
 */
@ManagedBean
@ViewScoped
public class DraggableMarkersView implements Serializable {
    private MapModel draggableModel;
    private Marker marker;
    
    @PostConstruct
    public void init(){
        draggableModel = new DefaultMapModel();
        
        // Shared coordinates
        LatLng coord1 = new LatLng(13.700209, -89.201089);
        LatLng coord2 = new LatLng(13.704726, -89.200275);
        LatLng coord3 = new LatLng(13.702325, -89.197355);
        LatLng coord4 = new LatLng(13.702763, -89.203031);
        
        // Draggable
        draggableModel.addOverlay(new Marker(coord1, "South"));
        draggableModel.addOverlay(new Marker(coord2, "North"));
        draggableModel.addOverlay(new Marker(coord3, "East"));
        draggableModel.addOverlay(new Marker(coord4, "West"));
        
        for(Marker premarker : draggableModel.getMarkers()){
            premarker.setDraggable(true);
        }
        
        LatLng coord0 = new LatLng(13.702487, -89.200882);
        draggableModel.addOverlay(new Marker(coord0, "Center"));
    }
    
    public MapModel getDraggableModel(){
        return draggableModel;
    }
    
    public void onMarkerDrag(MarkerDragEvent event){
        marker = event.getMarker();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marcador Arrastrado", "Lat: " + marker.getLatlng().getLat() + ", Lng: " + marker.getLatlng().getLng()));
    }
}
