package entities.interfaces;

import entities.airplanes.interfaces.FlyingMachine;

public interface Trip
	{
		String getId();

		String getSource();

		String getDestination();

		boolean isCompleted();

		FlyingMachine getFlyingMachine();

		void complete();
	}
