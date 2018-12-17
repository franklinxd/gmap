package com.fnk.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Franklin Ramos
 */
@ManagedBean
@ViewScoped
public class DraggableMarkersView {
    private MapModel draggableModel;
    private Marker marker;
    
    @PostConstruct
    public void init(){
        
    }
    
    public MapModel getDraggableModel(){
        return draggableModel;
    }
}
