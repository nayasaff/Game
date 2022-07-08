package units;

import exceptions.MaxCapacityException;

public class Scout extends Unit {

	public Scout(int level, int maxSoldierConunt, double idleUpkeep, double marchingUpkeep, double siegeUpkeep) {
		super(level, maxSoldierConunt, idleUpkeep, marchingUpkeep, siegeUpkeep);
		
	}
	
	public void Hire(Army army)throws MaxCapacityException {
		//
		if(army.getUnits().size() == army.getMaxToHold())
			throw new MaxCapacityException("Full capacity");
		
		if(army.getCurrentStatus() == Status.MARCHING || army.getCurrentStatus() == Status.BESIEGING)
			return;




		
		if(army.getUnits().size() <= 0.5 * army.getMaxToHold()) {
			if(this.getLevel() == 1)
				army.getUnits().add(new Cavalry(1, 50, 0.5, 0.6, 0.7));
			else if(this.getLevel() == 2)
				army.getUnits().add(new Cavalry(2, 50, 0.5, 0.6, 0.7));
			else
				army.getUnits().add(new Cavalry(3, 60, 0.6, 0.7, 0.8));
		}
		else if(army.getUnits().size() >= 0.5 * army.getMaxToHold()) {
			if(this.getLevel() == 1)
				army.getUnits().add(new Archer(1, 60, 0.4, 0.5, 0.6));
			else if(this.getLevel() == 2)
				army.getUnits().add(new Archer(2, 60, 0.4, 0.5, 0.6));
			else
				army.getUnits().add(new Archer(3, 70, 0.5, 0.6, 0.7));
		} 
		
		
	
					
			
		
	}
	
	

}
