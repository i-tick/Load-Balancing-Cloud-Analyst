package cloudsim.ext.datacenter;

import java.util.Map;

/**
 * This class implements {@link VmLoadBalancer} with a Round Robin policy.
 * 
 * @author Bhathiya Wickremasinghe
 *
 */
public class DynamicLoadBalancer extends VmLoadBalancer {
	
	private Map<Integer, VirtualMachineState> vmStatesList;
	private int currVm = -1;

	public DynamicLoadBalancer(Map<Integer, VirtualMachineState> vmStatesList){
		super();
		
		this.vmStatesList = vmStatesList;
	}

	/* (non-Javadoc)
	 * @see cloudsim.ext.VMLoadBalancer#getVM()
	 */
	public int getNextAvailableVm(){
		currVm++;
		
		if (currVm >= vmStatesList.size()){
			currVm = 0;
		}
		
		allocatedVm(currVm);
		
		return currVm;
		
	}
}
