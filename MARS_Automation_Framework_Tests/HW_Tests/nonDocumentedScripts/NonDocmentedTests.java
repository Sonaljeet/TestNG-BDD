package nonDocumentedScripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.exception.BACnetException;
import com.serotonin.bacnet4j.obj.ObjectProperties;
import com.serotonin.bacnet4j.obj.PropertyTypeDefinition;
import com.serotonin.bacnet4j.type.constructed.SequenceOf;
import com.serotonin.bacnet4j.type.enumerated.ObjectType;
import com.serotonin.bacnet4j.type.enumerated.PropertyIdentifier;
import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;
import com.serotonin.bacnet4j.util.RequestUtils;

import mars.Component.Functions.HWDeviceBaseClass;

public class NonDocmentedTests extends HWDeviceBaseClass {

	private RemoteDevice rd = null;
	private LocalDevice ld = null;
	private ExtentTest logger = null;

	private void initialize() {
		logger = HWDeviceBaseClass.logger;
		ld = HWDeviceBaseClass.localDevice;
		rd = HWDeviceBaseClass.remoteDevice;
	}

	@SuppressWarnings("unchecked")
	@Test(description = "BTL - 7.1.2 - Non-documented Property Test")
	public void finalTest() {
		initialize();
		try {
			List<ObjectIdentifier> oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();

			for (ObjectIdentifier oid : oids) {
				List<PropertyTypeDefinition> objectPropertyList = ObjectProperties
						.getPropertyTypeDefinitions(oid.getObjectType());
				List<PropertyIdentifier> allPropertiesMainList = new ArrayList<PropertyIdentifier>(
						Arrays.asList(PropertyIdentifier.ALL));
				List<PropertyIdentifier> finalAllPropertyList = new ArrayList<>();
				List<PropertyIdentifier> finalSomePropertyList = new ArrayList<>();
				finalAllPropertyList = allPropertiesMainList;

				for (PropertyTypeDefinition pds : objectPropertyList) {
					finalSomePropertyList.add(pds.getPropertyIdentifier());
				}

				finalAllPropertyList.removeAll(finalSomePropertyList);

				sendReadPropertyRequest(oid, finalAllPropertyList);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	private void sendReadPropertyRequest(ObjectIdentifier oid, List<PropertyIdentifier> propertyIdentifierList) {
		System.out.println("Read request received");
		PropertyIdentifier pidLog = null;
		if (!oid.getObjectType().equals(ObjectType.device)) {
			for (PropertyIdentifier pid : propertyIdentifierList) {
				pidLog = pid;
				try {
					if (!pid.equals(PropertyIdentifier.all)) {
						RequestUtils.getProperty(ld, rd, pid);
					}
				} catch (BACnetException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					
					if (e.getMessage().trim().contentEquals("Property: unknownProperty")) {
						logger.log(LogStatus.PASS,
								"Object : " + oid + " : PID: " + pidLog + ": " + new String(e.getMessage()));
					}else{
						logger.log(LogStatus.FAIL,
								"Object : " + oid + " : PID: " + pidLog + ": " + new String(e.getMessage()));
					}
					
				} /*catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}
	}
}
