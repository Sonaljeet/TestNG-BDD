package mars.Hardware;
import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.npdu.ip.IpNetwork;
import com.serotonin.bacnet4j.npdu.ip.IpNetworkUtils;
import com.serotonin.bacnet4j.transport.DefaultTransport;
import com.serotonin.bacnet4j.transport.Transport;
import com.serotonin.bacnet4j.type.constructed.Address;


public class hardwareDeviceSetupFactory {

	private LocalDevice localDevice = null;
	private RemoteDevice remoteDevice = null;

	private IpNetwork network = null;
	private Transport transport = null;

	private String BroadCastIP = null;
	private int port = 0;

	public hardwareDeviceSetupFactory(String BroadCastIP, int port) {
		this.BroadCastIP = BroadCastIP;
		this.port = port;
	}

	public RemoteDevice getDevice(String deviceIP, int deviceInstanceID) {
		network = new IpNetwork(BroadCastIP);
		transport = new DefaultTransport(network);
		localDevice = new LocalDevice(1234, transport);

		try {
			localDevice.initialize();
			remoteDevice = localDevice.findRemoteDevice(new Address(IpNetworkUtils.toOctetString(deviceIP, port)),
					deviceInstanceID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return remoteDevice;
	}
	
	public void closeLocalDevice(){
		localDevice.terminate();
	}

	public LocalDevice getLocalDevice() {
		
		return localDevice;
	}
	
}
