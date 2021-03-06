package net.bhl.matsim.uam.listeners;

import org.matsim.core.controler.events.ShutdownEvent;
import org.matsim.core.controler.listener.ShutdownListener;

import java.io.Closeable;
import java.io.IOException;

/**
 * A parallel least cost path calculator shutdown listener for shutdown
 * notification in the end of a simulation.
 *
 * @author balacmi (Milos Balac), RRothfeld (Raoul Rothfeld)
 */
public class ParallelLeastCostPathCalculatorShutdownListener implements ShutdownListener {
	final private Closeable resource;

	public ParallelLeastCostPathCalculatorShutdownListener(Closeable resource) {
		this.resource = resource;
	}

	@Override
	public void notifyShutdown(ShutdownEvent event) {
		try {
			resource.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
