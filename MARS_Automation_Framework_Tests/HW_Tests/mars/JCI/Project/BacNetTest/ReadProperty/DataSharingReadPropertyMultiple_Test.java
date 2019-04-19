package mars.JCI.Project.BacNetTest.ReadProperty;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.ServiceFuture;
import com.serotonin.bacnet4j.exception.BACnetException;
import com.serotonin.bacnet4j.obj.ObjectProperties;
import com.serotonin.bacnet4j.obj.PropertyTypeDefinition;
import com.serotonin.bacnet4j.service.acknowledgement.ReadPropertyMultipleAck;
import com.serotonin.bacnet4j.service.confirmed.ConfirmedRequestService;
import com.serotonin.bacnet4j.service.confirmed.ReadPropertyMultipleRequest;
import com.serotonin.bacnet4j.type.constructed.ObjectPropertyReference;
import com.serotonin.bacnet4j.type.constructed.PropertyReference;
import com.serotonin.bacnet4j.type.constructed.ReadAccessResult;
import com.serotonin.bacnet4j.type.constructed.ReadAccessSpecification;
import com.serotonin.bacnet4j.type.constructed.SequenceOf;
import com.serotonin.bacnet4j.type.constructed.ReadAccessResult.Result;
import com.serotonin.bacnet4j.type.enumerated.BinaryPV;
import com.serotonin.bacnet4j.type.enumerated.ObjectType;
import com.serotonin.bacnet4j.type.enumerated.PropertyIdentifier;
import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;
import com.serotonin.bacnet4j.type.primitive.UnsignedInteger;
import com.serotonin.bacnet4j.util.PropertyReferences;
import com.serotonin.bacnet4j.util.PropertyValues;
import com.serotonin.bacnet4j.util.RequestUtils;

import mars.Component.Functions.HWDeviceBaseClass;

public class DataSharingReadPropertyMultiple_Test extends HWDeviceBaseClass{

	private RemoteDevice rd = null;
	private LocalDevice ld= null;
	private ExtentTest logger = null;
	private List<ObjectIdentifier> oids = new ArrayList<ObjectIdentifier>();
	
	private void initialize(){
		logger=HWDeviceBaseClass.logger;
		ld= HWDeviceBaseClass.localDevice;
		rd = HWDeviceBaseClass.remoteDevice;
	}	
	
	@Test(description ="Data sharing Read Multiple Property from Multiple objects")
	public void readMultiplePropertyFromMultipleObjects1(){
		initialize();
		try {
			@SuppressWarnings("unchecked")
			List<ObjectIdentifier> oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd, rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();
		
			System.out.println("Request: " + oids.get(0) + " " + PropertyIdentifier.objectList);
			logger.log(LogStatus.INFO, new String("Request: " + oids.get(0) + " " + PropertyIdentifier.objectList));
			System.out.println("Response: " + oids.get(0) + " " + PropertyIdentifier.objectList + "\n" + oids);
			logger.log(LogStatus.INFO, new String("Response: " + oids.get(0) + " " + PropertyIdentifier.objectList + "\n" + oids));
			
			PropertyReferences refs = new PropertyReferences();
			for (ObjectIdentifier oid : oids) {
				ObjectType type = oid.getObjectType();

				if (ObjectType.analogValue.equals(type)) {
					refs.add(oid, PropertyIdentifier.presentValue);
				}
				if (ObjectType.multiStateValue.equals(type)) {
					refs.add(oid, PropertyIdentifier.stateText);
				}
				if (ObjectType.binaryValue.equals(type)) {
					refs.add(oid, PropertyIdentifier.presentValue);
				}
			}
			PropertyValues pvs = RequestUtils.readProperties(ld, rd, refs, null);
			
			for(ObjectPropertyReference pv: pvs){
				//System.out.println("Object type in pV:"+pv.getObjectIdentifier().getObjectType().getClass().getName() + "\tObjectType.binaryPV:"+BinaryPV.class.getSimpleName());
				
				System.out.println("pvs.getNoErrorCheck(pv)"+pvs.getNoErrorCheck(pv).getClass().getSimpleName() +" BinaryPV.class.getSimpleName()"+BinaryPV.class.getSimpleName());
			}
			
			
		} catch (BACnetException e) {
			System.out.println("Erorr reading object list....");
			e.printStackTrace();
		}
		
	}
	
	@Test(description ="Data sharing Read Multiple Property from Multiple objects")
	public void readMultiplePropertyFromMultipleObjects() throws BACnetException {
		initialize();
		@SuppressWarnings("unchecked")
		List<ObjectIdentifier> oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
				rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();

		System.out.println("Request: " + oids.get(0) + " " + PropertyIdentifier.objectList);
		logger.log(LogStatus.INFO, new String("Request: " + oids.get(0) + " " + PropertyIdentifier.objectList));
		System.out.println("Response: " + oids.get(0) + " " + PropertyIdentifier.objectList + "\n" + oids);
		logger.log(LogStatus.INFO, new String("Response: " + oids.get(0) + " " + PropertyIdentifier.objectList + "\n" + oids));
		
		PropertyReferences refs = new PropertyReferences();
		for (ObjectIdentifier oid : oids) {
			ObjectType type = oid.getObjectType();

			if (ObjectType.analogValue.equals(type)) {
				refs.add(oid, PropertyIdentifier.presentValue);
			}
			if (ObjectType.multiStateValue.equals(type)) {
				refs.add(oid, PropertyIdentifier.stateText);
			}
			if (ObjectType.binaryValue.equals(type)) {
				refs.add(oid, PropertyIdentifier.presentValue);
			}
		}

		PropertyValues pvs = RequestUtils.readProperties(ld, rd, refs, null);
		System.out.println();
		boolean testStatus = false;
		for (ObjectPropertyReference pv : pvs) {
			System.out.println("Request: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier());
			
			if (pv.getObjectIdentifier().getObjectType().equals(ObjectType.binaryValue)) {
				if (pvs.getNoErrorCheck(pv).getClass().getSimpleName().equals(BinaryPV.class.getSimpleName())) {
					System.out.println("Request: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier());
					logger.log(LogStatus.PASS, new String("Request: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier()));
					System.out.println("Response: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier() + " "
							+ pvs.getNoErrorCheck(pv));
					logger.log(LogStatus.PASS, new String("Response: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier() + " "
							+ pvs.getNoErrorCheck(pv)));
					System.out.println("========");
				}else{
					logger.log(LogStatus.FAIL, "Property Value type mismatch for"+pv.getObjectIdentifier() +", Property Identifier: "+pv.getPropertyIdentifier());
				}
			}else if (pv.getObjectIdentifier().getObjectType().equals(ObjectType.analogValue)) {
				if (pvs.getNoErrorCheck(pv).getClass().getSimpleName().equals(UnsignedInteger.class.getSimpleName())) {
					System.out.println("Request: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier());
					logger.log(LogStatus.PASS, new String("Request: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier()));
					System.out.println("Response: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier() + " "
							+ pvs.getNoErrorCheck(pv));
					logger.log(LogStatus.PASS, new String("Response: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier() + " "
							+ pvs.getNoErrorCheck(pv)));
					System.out.println("========");
				}else{
					logger.log(LogStatus.FAIL, "Property Value type mismatch for: "+pv.getObjectIdentifier() +", Property Identifier: "+pv.getPropertyIdentifier());
				}
			}else if(pv.getObjectIdentifier().getObjectType().equals(ObjectType.multiStateValue)){
				if (pvs.getNoErrorCheck(pv).getClass().getSimpleName().equals(BinaryPV.class.getSimpleName())) {
					System.out.println("Request: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier());
					logger.log(LogStatus.PASS, new String("Request: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier()));
					System.out.println("Response: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier() + " "
							+ pvs.getNoErrorCheck(pv));
					logger.log(LogStatus.PASS, new String("Response: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier() + " "
							+ pvs.getNoErrorCheck(pv)));
					System.out.println("========");
				}else{
					logger.log(LogStatus.FAIL, "Property Value type mismatch for"+pv.getObjectIdentifier() +", Property Identifier: "+pv.getPropertyIdentifier());
				}
			}
		}
	}

	@Test(description = "Reading Multiple properties from Single objects")
	public void readMultiplePropertyFromSingleObject() throws BACnetException {
		initialize();
		@SuppressWarnings("unchecked")
		List<ObjectIdentifier> oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
				rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();

		System.out.println("Request: " + oids.get(0) + " " + PropertyIdentifier.objectList);
		logger.log(LogStatus.INFO, new String("Request: " + oids.get(0) + " " + PropertyIdentifier.objectList));
		System.out.println("Response: " + oids.get(0) + " " + PropertyIdentifier.objectList + "\n" + oids);
		logger.log(LogStatus.INFO, new String("Response: " + oids.get(0) + " " + PropertyIdentifier.objectList + "\n" + oids));
		PropertyReferences refs = new PropertyReferences();
		for (ObjectIdentifier oid : oids) {
			ObjectType type = oid.getObjectType();

			if (ObjectType.analogValue.equals(type)) {
				refs.add(oid, PropertyIdentifier.presentValue);
				refs.add(oid, PropertyIdentifier.outOfService);
				refs.add(oid, PropertyIdentifier.objectIdentifier);
				refs.add(oid, PropertyIdentifier.objectType);
				refs.add(oid, PropertyIdentifier.units);
				refs.add(oid, PropertyIdentifier.objectName);
			}

			
			 if (ObjectType.binaryValue.equals(type) ) { 
				refs.add(oid,PropertyIdentifier.presentValue);
				refs.add(oid, PropertyIdentifier.outOfService);
				refs.add(oid, PropertyIdentifier.objectIdentifier);
				refs.add(oid, PropertyIdentifier.objectType);
				refs.add(oid, PropertyIdentifier.statusFlags);
				refs.add(oid, PropertyIdentifier.objectName);
			}
			 
		}

		PropertyValues pvs = RequestUtils.readProperties(ld, rd, refs, null);
		System.out.println();
		String allResponse = "";
		String allRequest = "";
		
		for (ObjectPropertyReference pv : pvs) {
			System.out.println("Request: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier());
			allRequest = new String(String.format("%s   %s", pv.getObjectIdentifier(), pv.getPropertyIdentifier())) +allRequest;
			
			System.out.println("Response: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier() + " "
					+ pvs.getNoErrorCheck(pv));
			
			allResponse = new String(String.format("%20s %20s %20s", pv.getObjectIdentifier() ,  pv.getPropertyIdentifier() , pvs.getNoErrorCheck(pv))) +" \n" +allResponse;
			System.out.println("========");
		}
		logger.log(LogStatus.INFO, new String("Request: <br></br>" + allRequest));
		logger.log(LogStatus.INFO, new String("Response: <br></br>" + allResponse));
	}

	 @Test(description="Reading Single property from multiple objects")
	public void readSinglePropertyFromMultipleObjects() throws BACnetException {
		 initialize();
		@SuppressWarnings("unchecked")
		List<ObjectIdentifier> oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
				rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();

		System.out.println("Request: " + oids.get(0) + " " + PropertyIdentifier.objectList);
		logger.log(LogStatus.INFO, new String("Request: " + oids.get(0) + " " + PropertyIdentifier.objectList));
		System.out.println("Response: " + oids.get(0) + " " + PropertyIdentifier.objectList + "\n" + oids);
		logger.log(LogStatus.INFO, new String("Response: " + oids.get(0) + " " + PropertyIdentifier.objectList + "\n" + oids));
		PropertyReferences refs = new PropertyReferences();
		for (ObjectIdentifier oid : oids) {
			ObjectType type = oid.getObjectType();

			if (ObjectType.analogValue.equals(type)) {
				refs.add(oid, PropertyIdentifier.presentValue);
			}

			if (ObjectType.binaryValue.equals(type)) {
				refs.add(oid, PropertyIdentifier.presentValue);
			}
			if (ObjectType.multiStateValue.equals(type)) {
				refs.add(oid, PropertyIdentifier.presentValue);
			}
		}

		PropertyValues pvs = RequestUtils.readProperties(ld, rd, refs, null);
		System.out.println();
		String allRequests = "";
		String allResponse = "";
		for (ObjectPropertyReference pv : pvs) {
			System.out.println("Request: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier());
			allRequests = new String(pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier())+allRequests;
	
			System.out.println("Response: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier() + " "
					+ pvs.getNoErrorCheck(pv));
			allResponse = new String(pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier() + " "
					+ pvs.getNoErrorCheck(pv)) + allResponse;
			logger.log(LogStatus.INFO, new String("Response: " + pv.getObjectIdentifier() + " " + pv.getPropertyIdentifier() + " "
					+ pvs.getNoErrorCheck(pv)));
			System.out.println("========");
		}
		logger.log(LogStatus.INFO, "Request<br></br>"+allRequests);
		logger.log(LogStatus.INFO, "Response<br></br>"+allResponse);
		
		
	}


	 @SuppressWarnings("unchecked")
	@Test(description="Read Property Multiple - Required Properties")
	public void readRequiredPropMul(Method method) {
		initialize();
		try {
			oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();

			// Generate PropertyReferences
			for (ObjectIdentifier oid : oids) {
				List<PropertyTypeDefinition> objectPropertyList = ObjectProperties
						.getRequiredPropertyTypeDefinitions(oid.getObjectType());
				List<PropertyReference> propertyReferences = new ArrayList<PropertyReference>();

				for (PropertyTypeDefinition ptd : objectPropertyList) {
					propertyReferences.add(new PropertyReference(ptd.getPropertyIdentifier()));
				}

				// Generating read access list
				List<ReadAccessSpecification> readAccessSpecs = new ArrayList<ReadAccessSpecification>();
				ReadAccessSpecification ras = new ReadAccessSpecification(oid,
						new SequenceOf<PropertyReference>(propertyReferences));

				// add to read access list
				readAccessSpecs.add(ras);

				// sending reading multiple request
				readAccessData(readAccessSpecs);

			} // End OID for
		} catch (BACnetException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(description="Read Property Multiple - Optional Properties")
	public void readOptionalPropMul(Method method) {
		initialize();
		try {
			oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();

			// Generate PropertyReferences
			for (ObjectIdentifier oid : oids) {
				List<PropertyTypeDefinition> objectPropertyList = ObjectProperties
						.getOptionalPropertyTypeDefinitions(oid.getObjectType());
				List<PropertyReference> propertyReferences = new ArrayList<PropertyReference>();

				for (PropertyTypeDefinition ptd : objectPropertyList) {
					propertyReferences.add(new PropertyReference(ptd.getPropertyIdentifier()));
				}

				// Generating read access list
				List<ReadAccessSpecification> readAccessSpecs = new ArrayList<ReadAccessSpecification>();
				ReadAccessSpecification ras = new ReadAccessSpecification(oid,
						new SequenceOf<PropertyReference>(propertyReferences));

				// add to read access list
				readAccessSpecs.add(ras);

				// sending reading multiple request
				readAccessData(readAccessSpecs);

			} // End OID for
		} catch (BACnetException e) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(description="Read Property Multiple - Required and Optional Properties")
	public void readAllPropMul(Method method) {
		initialize();
		try {
			oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();

			// Generate PropertyReferences
			for (ObjectIdentifier oid : oids) {
				List<PropertyTypeDefinition> objectPropertyList = ObjectProperties
						.getPropertyTypeDefinitions(oid.getObjectType());
				List<PropertyReference> propertyReferences = new ArrayList<PropertyReference>();

				for (PropertyTypeDefinition ptd : objectPropertyList) {
					propertyReferences.add(new PropertyReference(ptd.getPropertyIdentifier()));
				}

				// Generating read access list
				List<ReadAccessSpecification> readAccessSpecs = new ArrayList<ReadAccessSpecification>();
				ReadAccessSpecification ras = new ReadAccessSpecification(oid,
						new SequenceOf<PropertyReference>(propertyReferences));

				// add to read access list
				readAccessSpecs.add(ras);

				// sending reading multiple request
				readAccessData(readAccessSpecs);

			} // End OID for
		} catch (BACnetException e) {
			e.printStackTrace();
		}
	}

	private void readAccessData(List<ReadAccessSpecification> readAccessSpecs) {

		ConfirmedRequestService service = new ReadPropertyMultipleRequest(
				new SequenceOf<ReadAccessSpecification>(readAccessSpecs));

		try {
			ServiceFuture future = ld.send(rd, service);
			ReadPropertyMultipleAck ack = future.get();
			SequenceOf<ReadAccessResult> results = ack.getListOfReadAccessResults();
			List<ReadAccessResult> test = results.getValues();

			for (ReadAccessResult rslt : test) {
				String resultToWriteToLog = "";
				List<Result> testResults = rslt.getListOfResults().getValues();
				for (Result rs : testResults) {
					if (!rs.isError()) {
						System.out.print(rs.getPropertyIdentifier() + "\t : " + rs.getReadResult());
						resultToWriteToLog = resultToWriteToLog +new String(
								"<b>" + rs.getPropertyIdentifier() + "</b>" + " : " + rs.getReadResult() + "</br>");
					}
					// logger.log(LogStatus.INFO, resultToWriteToLog);
					System.out.println();
					// logger.log(LogStatus.INFO, "");
				}
				logger.log(LogStatus.INFO, resultToWriteToLog);
				System.out.println();
				// logger.log(LogStatus.INFO, "");
			}
			// System.out.println();
			// System.out.println("Choice ID:
			// "+future.get().getChoiceId()+"\nResult :
			// "+future.get().toString());
		} catch (BACnetException e) {
			e.printStackTrace();
		}
	}
	
	
	
	


}
