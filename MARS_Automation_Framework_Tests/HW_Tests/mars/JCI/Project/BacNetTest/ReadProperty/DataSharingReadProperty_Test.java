package mars.JCI.Project.BacNetTest.ReadProperty;
import java.lang.reflect.Method;
import java.util.List;

import org.testng.annotations.Test;

import com.google.common.primitives.UnsignedInteger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.exception.BACnetException;
import com.serotonin.bacnet4j.service.confirmed.ReadPropertyRequest;
import com.serotonin.bacnet4j.type.Encodable;
import com.serotonin.bacnet4j.type.constructed.SequenceOf;
import com.serotonin.bacnet4j.type.enumerated.BinaryPV;
import com.serotonin.bacnet4j.type.enumerated.ObjectType;
import com.serotonin.bacnet4j.type.enumerated.PropertyIdentifier;
import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;
import com.serotonin.bacnet4j.type.primitive.Real;
import com.serotonin.bacnet4j.util.RequestUtils;

import mars.Component.Functions.HWDeviceBaseClass;

public class DataSharingReadProperty_Test extends HWDeviceBaseClass{
	
	private RemoteDevice rd = null;
	private LocalDevice ld= null;
	private ExtentTest logger = null;
	
	private void initialize(){
		logger=HWDeviceBaseClass.logger;
		ld= HWDeviceBaseClass.localDevice;
		rd = HWDeviceBaseClass.remoteDevice;
	}

	
	@Test(description="Data Sharing - ReadProperty- Enumerated property values")
	public void enumPropertyValues(Method method) throws BACnetException {
		initialize();
		boolean testStatus = false;
		Encodable e = null;
		@SuppressWarnings("unchecked")
		List<ObjectIdentifier> oids= ((SequenceOf<ObjectIdentifier>)RequestUtils.sendReadPropertyAllowNull(ld, rd, rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();
		ReadPropertyRequest rpr = new ReadPropertyRequest(oids.get(0), PropertyIdentifier.objectList);
		//System.out.println(rpr);
		System.out.println("Request:\t"+oids.get(0)+" "+PropertyIdentifier.objectList);
		//String info = "Request:\t"+oids.get(0)+" "+PropertyIdentifier.objectList;
		logger.log(LogStatus.INFO, new String("Request:\t"+oids.get(0)+" "+PropertyIdentifier.objectList));
		
		System.out.println("Response: "+oids.get(0)+" "+PropertyIdentifier.objectList+"\n"+oids);
		logger.log(LogStatus.INFO,new String("Response: "+oids.get(0)+" "+PropertyIdentifier.objectList+"\n"+oids));
		for(int i=0; i<oids.size(); i++){
			ObjectType type = oids.get(i).getObjectType();
			if (type.equals(ObjectType.binaryValue)) {
				System.out.println("\nRequest "+oids.get(i)+" "+PropertyIdentifier.presentValue);
				logger.log(LogStatus.INFO, new String("\nRequest "+oids.get(i)+" "+PropertyIdentifier.presentValue));
				
				try {
					e = RequestUtils.getProperty(ld, rd, oids.get(i), PropertyIdentifier.presentValue);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nPresent Value "+e);
				logger.log(LogStatus.INFO, new String("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nPresent Value "+e));
				System.out.println();
				System.out.println("Class def: "+e.getClass().getSimpleName());
				if (e.getClass().getSimpleName().equals(BinaryPV.class.getSimpleName())) {
					System.out.println("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nPresent Value "+e);
					logger.log(LogStatus.PASS, new String("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nPresent Value "+e));
					System.out.println();
				}else{
					logger.log(LogStatus.FAIL, "Property Type mismatch- Expected: "+UnsignedInteger.class.getSimpleName() +" Actual: "+e.getClass().getSimpleName());
				}
			}
		}
	}
	
	@Test(description="Data Sharing - ReadProperty- Unsigned property values")
	public void unsignedPropertyValues() throws BACnetException{
		initialize();
		boolean testStatus = false;
		@SuppressWarnings("unchecked")
		List<ObjectIdentifier> oids= ((SequenceOf<ObjectIdentifier>)RequestUtils.sendReadPropertyAllowNull(ld, rd, rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();
		ReadPropertyRequest rpr = new ReadPropertyRequest(oids.get(0), PropertyIdentifier.objectList);
		//System.out.println(rpr);
		System.out.println("Request:\t"+oids.get(0)+" "+PropertyIdentifier.objectList);
		logger.log(LogStatus.INFO, new String("Request:\t"+oids.get(0)+" "+PropertyIdentifier.objectList));
		
		System.out.println("Response: "+oids.get(0)+" "+PropertyIdentifier.objectList+"\n"+oids);
		logger.log(LogStatus.INFO, new String("Response: "+oids.get(0)+" "+PropertyIdentifier.objectList+"\n"+oids));
		
		for(int i=0; i<oids.size(); i++){
			ObjectType type = oids.get(i).getObjectType();
			if (type.equals(ObjectType.multiStateValue)) {
				System.out.println("\nRequest "+oids.get(i)+" "+PropertyIdentifier.presentValue);
				logger.log(LogStatus.INFO, new String("\nRequest "+oids.get(i)+" "+PropertyIdentifier.presentValue));
				Encodable e = null;
				try {
					e = RequestUtils.getProperty(ld, rd, oids.get(i), PropertyIdentifier.presentValue);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (e.getClass().getSimpleName().equals(UnsignedInteger.class.getSimpleName())) {
					System.out.println("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nPresent Value "+e);
					logger.log(LogStatus.PASS, new String("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nPresent Value "+e));
					System.out.println();
				}else{
					logger.log(LogStatus.FAIL, "Property Type mismatch- Expected: "+UnsignedInteger.class.getSimpleName() +" Actual: "+e.getClass().getSimpleName());
				}
			}
		}
	}
	
	@Test(description="Data Sharing - ReadProperty- Contains BOOLEAN property values")
	public void booleanPropertyValues() throws BACnetException{
		initialize();
		boolean testStatus = false;
		@SuppressWarnings("unchecked")
		List<ObjectIdentifier> oids= ((SequenceOf<ObjectIdentifier>)RequestUtils.sendReadPropertyAllowNull(ld, rd, rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();
		ReadPropertyRequest rpr = new ReadPropertyRequest(oids.get(0), PropertyIdentifier.objectList);
		//System.out.println(rpr);
		System.out.println("Request:\t"+oids.get(0)+" "+PropertyIdentifier.objectList);
		logger.log(LogStatus.INFO, new String("Request:\t"+oids.get(0)+" "+PropertyIdentifier.objectList));
		System.out.println("Response: "+oids.get(0)+" "+PropertyIdentifier.objectList+"\n"+oids);
		logger.log(LogStatus.INFO, new String("Response: "+oids.get(0)+" "+PropertyIdentifier.objectList+"\n"+oids));
		
		for(int i=0; i<oids.size(); i++){
			ObjectType type = oids.get(i).getObjectType();
			if (type.equals(ObjectType.analogValue)) {

				System.out.println("\nRequest "+oids.get(i)+" "+PropertyIdentifier.outOfService);
				logger.log(LogStatus.INFO, new String("\nRequest "+oids.get(i)+" "+PropertyIdentifier.outOfService));
				Encodable e = null;
				try {
					e = RequestUtils.getProperty(ld, rd, oids.get(i), PropertyIdentifier.outOfService);
					
					if (e.getClass().getSimpleName().equals(Boolean.class.getSimpleName())) {
						System.out.println("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nOut Of Service "+e);
						logger.log(LogStatus.PASS, new String("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nOut Of Service "+e));
						System.out.println();
					}else{
						logger.log(LogStatus.FAIL, new String("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nOut Of Service "+e));
						System.out.println("Property data type is : "+e.getClass().getSimpleName());
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	@Test(description="Data Sharing - ReadProperty- Contains REAL property values")
	public void realPropertyValues() throws BACnetException {
		initialize();
		boolean testStatus = false;
		@SuppressWarnings("unchecked")
		List<ObjectIdentifier> oids= ((SequenceOf<ObjectIdentifier>)RequestUtils.sendReadPropertyAllowNull(ld, rd, rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();
		ReadPropertyRequest rpr = new ReadPropertyRequest(oids.get(0), PropertyIdentifier.objectList);
		
		System.out.println("Request:\t"+oids.get(0)+" "+PropertyIdentifier.objectList);
		logger.log(LogStatus.INFO, new String("Request:\t"+oids.get(0)+" "+PropertyIdentifier.objectList));
		System.out.println("Response: "+oids.get(0)+" "+PropertyIdentifier.objectList+"\n"+oids);
		logger.log(LogStatus.INFO, new String("Response: "+oids.get(0)+" "+PropertyIdentifier.objectList+"\n"+oids));
		for(int i=0; i<oids.size(); i++){
			ObjectType type = oids.get(i).getObjectType();
			if (type.equals(ObjectType.analogValue)) {
				System.out.println("\nRequest "+oids.get(i)+" "+PropertyIdentifier.presentValue);
				logger.log(LogStatus.INFO, new String("\nRequest "+oids.get(i)+" "+PropertyIdentifier.presentValue));
				Encodable e = null;
				try {
					e = RequestUtils.getProperty(ld, rd, oids.get(i), PropertyIdentifier.presentValue);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (e.getClass().getSimpleName().equals(Real.class.getSimpleName())) {
					System.out.println("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nPresent Value "+e);
					logger.log(LogStatus.PASS, new String("Response\t"+oids.get(i).getObjectType()+" "+oids.get(i).getInstanceNumber()+"\nPresent Value "+e));
					System.out.println();
				}else{
					logger.log(LogStatus.FAIL, "Property Type mismatch- Expected: "+UnsignedInteger.class.getSimpleName() +" Actual: "+e.getClass().getSimpleName());
				}
			}
		}
	}
}
