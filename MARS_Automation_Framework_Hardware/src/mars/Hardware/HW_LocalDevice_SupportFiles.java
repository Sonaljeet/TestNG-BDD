package mars.Hardware;
import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.npdu.ip.IpNetwork;
import com.serotonin.bacnet4j.transport.Transport;
import com.serotonin.bacnet4j.type.constructed.Address;

public class HW_LocalDevice_SupportFiles {

	public IpNetwork network = null;
	public Transport transport = null;
	public LocalDevice ld = null;
	public RemoteDevice rd = null;
	
	
	
	public static void getRemoteDevice(Address deviceAddress, int deviceId){
		
	}
}
