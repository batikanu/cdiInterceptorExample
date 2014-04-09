package de.jknowledge.cdi.interceptor.service;

import de.jknowledge.cdi.interceptor.Tracked;

public class TrackingServiceImpl implements TrackingService {

	@Tracked
	public void processTrackig() {
		try {
			int sleepTime =  (int) (Math.random() * (1000 - 100) + 100);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
