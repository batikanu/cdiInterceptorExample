package de.jknowledge.cdi.interceptor.web.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import de.jknowledge.cdi.interceptor.TrackingInterceptor;
import de.jknowledge.cdi.interceptor.service.TrackingService;

@ManagedBean(name="trackingBean")
@RequestScoped
public class TrackingBean implements Serializable {

	@Inject
	private TrackingService trackingService;
	
	public String actionTrack() {
		trackingService.processTrackig();
		return "";
	}
	
	public int getMethodCalls() {
		return TrackingInterceptor.calls;
	}
	
	public long getLastProcessTime() {
		return TrackingInterceptor.lastProcessTime;
	}
	
}
