package DataSharingWriteProperty_Test;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.exception.BACnetException;
import com.serotonin.bacnet4j.service.confirmed.WritePropertyRequest;
import com.serotonin.bacnet4j.type.Encodable;
import com.serotonin.bacnet4j.type.constructed.SequenceOf;
import com.serotonin.bacnet4j.type.enumerated.BinaryPV;
import com.serotonin.bacnet4j.type.enumerated.ObjectType;
import com.serotonin.bacnet4j.type.enumerated.PropertyIdentifier;
import com.serotonin.bacnet4j.type.primitive.Boolean;
import com.serotonin.bacnet4j.type.primitive.CharacterString;
import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;
import com.serotonin.bacnet4j.type.primitive.Real;
import com.serotonin.bacnet4j.type.primitive.Unsigned16;
import com.serotonin.bacnet4j.util.RequestUtils;
import com.serotonin.bacnet4j.util.sero.ByteQueue;

import mars.Component.Functions.HWDeviceBaseClass;

public class DatSharingWritePropertySingle extends HWDeviceBaseClass{


	private RemoteDevice rd = null;
	private LocalDevice ld= null;
	private ExtentTest logger = null;
	
	private void initialize(){
		logger=HWDeviceBaseClass.logger;
		ld= HWDeviceBaseClass.localDevice;
		rd = HWDeviceBaseClass.remoteDevice;
	}
	
	@Test(description = "DSWP - B -BTL - 9.22.1.X2 Write Property REAL")
	@SuppressWarnings("unchecked")
	public void dataSharingWritePropertyReal() throws BACnetException{
		
		initialize();
		List<ObjectIdentifier> oids = null;
		try {
			oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();
			for(ObjectIdentifier oid: oids){
				if (oid.getObjectType().equals(ObjectType.analogValue)) {
					Encodable currentVal = RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue);
					
					System.out.println("Request: "+oid +" " +"presentValue ");
					logger.log(LogStatus.PASS, new String("Request: "+oid +" " +"presentValue "));
					
					System.out.println("Response: "+oid +" " +"presentValue "+currentVal);
					logger.log(LogStatus.PASS, new String("Response: "+oid +" " +"presentValue "+currentVal));

					if (currentVal.getClass().getSimpleName().equals(Real.class.getSimpleName())) {
						Float newValToWrite = (float) (Float.parseFloat(currentVal.toString())+(int)(Math.random()*10));
						
						WritePropertyRequest wp = new WritePropertyRequest(oid, PropertyIdentifier.presentValue, null, new Real(newValToWrite), null);
						ld.send(rd, wp);					
						
						System.out.println("Request: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue));
						logger.log(LogStatus.PASS, new String("Request: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue)) +"\n");
						
						System.out.println("Response: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue));
						logger.log(LogStatus.PASS, new String("Response: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue)) +"\n");
						System.out.println();
					}else{
						System.out.println("Not able to write the property for "+oid);
					}
				}
			}
		} catch (BACnetException e3) {
			logger.log(LogStatus.ERROR, new String(e3.getMessage()));
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(description = "DSWP - B -BTL - 9.22.1.X2 Write Property BOOLEAN for unwritable property")
	public void dataSharingWritePropertyBoolean() {

		initialize();
		List<ObjectIdentifier> oids = null;
		try {
			oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();
			for(ObjectIdentifier oid: oids){
				if (oid.getObjectType().equals(ObjectType.analogValue)) {
					Encodable currentVal = RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.outOfService);
					
					System.out.println("Request: "+oid +" " +"outOfService ");
					logger.log(LogStatus.PASS, new String("Request: "+oid +" " +"outOfService "));
					
					System.out.println("Response: "+oid +" " +"outOfService "+currentVal);
					logger.log(LogStatus.PASS, new String("Response: "+oid +" " +"outOfService "+currentVal));
					
					if (currentVal.equals(new Boolean(true))) {
						WritePropertyRequest wp = new WritePropertyRequest(oid, PropertyIdentifier.outOfService, null, new Boolean(false), null);
						ld.send(rd, wp);					
						
						System.out.println("Request: "+oid +" outOfService "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.outOfService));
						logger.log(LogStatus.PASS, new String("Request: "+oid +" outOfService "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.outOfService)));
						
						System.out.println("Response: "+oid +" outOfService "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.outOfService));
						logger.log(LogStatus.PASS, new String("Response: "+oid +" outOfService "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.outOfService)));
					}else if(currentVal.equals(new Boolean(false))){
						
						WritePropertyRequest wp = new WritePropertyRequest(oid, PropertyIdentifier.outOfService, null, new Boolean(true), null);

						System.out.println("Request: "+oid +" outOfService "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.enable));
						logger.log(LogStatus.PASS, new String("Request: "+oid +" outOfService "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.outOfService)));
						
						System.out.println("Response: "+oid +" enable "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.outOfService));
						logger.log(LogStatus.PASS, new String("Response: "+oid +" enable "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.outOfService)));
					}else{
						logger.log(LogStatus.FAIL, new String("Not able to write the property for"+oid));
					}
				}
			}
		} catch (BACnetException e3) {
			System.out.println(e3);
			String errMessage = ExceptionUtils.getStackTrace(e3);
			logger.log(LogStatus.ERROR, new String(e3.toString()));
			//logger.log(LogStatus.ERROR, new String(e3.getMessage()));
		}
	}


	@SuppressWarnings("unchecked")
	@Test(description = "DSWP - B -BTL - 9.22.1.X2 Write Property BOOLEAN")
	public void dataSharingWritePropertyBooleanPositive(){
		initialize();
		List<ObjectIdentifier> oids = null;
		try {
			oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();
			for(ObjectIdentifier oid: oids){
				if (oid.getObjectType().equals(ObjectType.trendLog)) {
					Encodable currentVal = RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.enable);
					
					System.out.println("Request: "+oid +" " +"enable ");
					logger.log(LogStatus.PASS, new String("Request: "+oid +" " +"enable "));
					
					System.out.println("Response: "+oid +" " +"enable "+currentVal);
					logger.log(LogStatus.PASS, new String("Response: "+oid +" " +"enable "+currentVal));
					
					if (currentVal.equals(new Boolean(true))) {
						WritePropertyRequest wp = new WritePropertyRequest(oid, PropertyIdentifier.enable, null, new Boolean(false), null);
						ld.send(rd, wp);					
						
						System.out.println("Request: "+oid +" enable "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.enable));
						logger.log(LogStatus.PASS, new String("Request: "+oid +" enable "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.enable)));
						
						System.out.println("Response: "+oid +" enable "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.enable));
						logger.log(LogStatus.PASS, new String("Response: "+oid +" enable "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.enable)));
					}else if(currentVal.equals(new Boolean(false))){
						
						WritePropertyRequest wp = new WritePropertyRequest(oid, PropertyIdentifier.enable, null, new Boolean(true), null);
						ld.send(rd, wp);
						System.out.println("Request: "+oid +" enable "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.enable));
						logger.log(LogStatus.PASS, new String("Request: "+oid +" enable "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.enable)));
						
						System.out.println("Response: "+oid +" enable "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.enable));
						logger.log(LogStatus.PASS, new String("Response: "+oid +" enable "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.enable)));
					}else{
						logger.log(LogStatus.FAIL, new String("Not able to write the property for "+oid));
					}
				}
			}
		} catch (BACnetException e3) {
			String errMessage = ExceptionUtils.getStackTrace(e3);
			logger.log(LogStatus.ERROR, new String(errMessage));
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(description = "DSWP - B -BTL - 9.22.1.X2 Write Property Unsigned")
	public void dataSharingWritePropertyUnSigned(){
		
		initialize();
		List<ObjectIdentifier> oids = null;
		try {
			oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();
			for(ObjectIdentifier oid: oids){
				if (oid.getObjectType().equals(ObjectType.multiStateValue)) {
					Encodable currentVal = RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.numberOfStates);
					
					System.out.println("Request: "+oid +" " +"numberOfStates ");
					logger.log(LogStatus.PASS, new String("Request: "+oid +" " +"numberOfStates "));
					
					System.out.println("Response: "+oid +" " +"numberOfStates "+currentVal);
					logger.log(LogStatus.PASS, new String("Response: "+oid +" " +"numberOfStates "+currentVal));
					
					int currentIntVal = Integer.parseInt(currentVal.toString());
					
					for (int i = 1; i <= currentIntVal; i++) {
						WritePropertyRequest wp = new WritePropertyRequest(oid, PropertyIdentifier.presentValue, null, new Unsigned16(i), null);
						ld.send(rd, wp);
						
						System.out.println("Request: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue));
						logger.log(LogStatus.PASS, new String("Request: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue)));
						
						System.out.println("Response: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue));
						logger.log(LogStatus.PASS, new String("Response: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue)));
						
					}
				}
			}
		} catch (BACnetException e3) {
			String errMessage = ExceptionUtils.getStackTrace(e3);
			logger.log(LogStatus.ERROR, new String(errMessage));
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(description = "DSWP - B -BTL - 9.22.1.X2 Write Property Enumerated")
	public void dataSharingWritePropertyEnumerated(){
		
		initialize();
		List<ObjectIdentifier> oids = null;
		try {
			oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();
			for(ObjectIdentifier oid: oids){
				if (oid.getObjectType().equals(ObjectType.binaryValue)) {
					Encodable currentVal = RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue);
					System.out.println("currentVal"+currentVal.getClass().getSimpleName());
					System.out.println("Request: "+oid +" " +"presentValue ");
					logger.log(LogStatus.PASS, new String("Request: "+oid +" " +"presentValue "));
					
					System.out.println("Response: "+oid +" " +"presentValue "+currentVal);
					logger.log(LogStatus.PASS, new String("Response: "+oid +" " +"presentValue "+currentVal));
					
					if (currentVal.equals(BinaryPV.inactive)) {
						WritePropertyRequest wp = new WritePropertyRequest(oid, PropertyIdentifier.presentValue, null, BinaryPV.active, null);
						ld.send(rd, wp);
						
						System.out.println("Request: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue));
						logger.log(LogStatus.PASS, new String("Request: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue)));
						
						System.out.println("Response: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue));
						logger.log(LogStatus.PASS, new String("Response: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue)));
						
					}else if(currentVal.equals(BinaryPV.active)){
						WritePropertyRequest wp = new WritePropertyRequest(oid, PropertyIdentifier.presentValue, null, BinaryPV.inactive, null);
						ld.send(rd, wp);
						
						System.out.println("Request: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue));
						logger.log(LogStatus.PASS, new String("Request: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue)));
						
						System.out.println("Response: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue));
						logger.log(LogStatus.PASS, new String("Response: "+oid +" presentValue "+RequestUtils.getProperty(ld, rd, oid, PropertyIdentifier.presentValue)));
					}else{
						System.out.println("Invalid state to write");
						logger.log(LogStatus.FAIL, "Invalid state to write");
					}
				}
			}
		} catch (BACnetException e3) {
			String errMessage = ExceptionUtils.getStackTrace(e3);
			logger.log(LogStatus.ERROR, new String(errMessage));
		}
	}
	
	
	

}
