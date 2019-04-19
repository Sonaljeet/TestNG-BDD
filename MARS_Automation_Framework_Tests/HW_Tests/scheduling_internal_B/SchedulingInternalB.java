package scheduling_internal_B;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;
import com.serotonin.bacnet4j.ServiceFuture;
import com.serotonin.bacnet4j.enums.DayOfWeek;
import com.serotonin.bacnet4j.enums.Month;
import com.serotonin.bacnet4j.exception.BACnetException;
import com.serotonin.bacnet4j.obj.ObjectProperties;
import com.serotonin.bacnet4j.obj.PropertyTypeDefinition;
import com.serotonin.bacnet4j.service.acknowledgement.ReadPropertyMultipleAck;
import com.serotonin.bacnet4j.service.confirmed.ConfirmedRequestService;
import com.serotonin.bacnet4j.service.confirmed.ReadPropertyMultipleRequest;
import com.serotonin.bacnet4j.service.confirmed.WritePropertyRequest;
import com.serotonin.bacnet4j.service.unconfirmed.TimeSynchronizationRequest;
import com.serotonin.bacnet4j.service.unconfirmed.UnconfirmedCovNotificationRequest;
import com.serotonin.bacnet4j.service.unconfirmed.UnconfirmedRequestService;
import com.serotonin.bacnet4j.type.AmbiguousValue;
import com.serotonin.bacnet4j.type.Encodable;
import com.serotonin.bacnet4j.type.constructed.CalendarEntry;
import com.serotonin.bacnet4j.type.constructed.DateTime;
import com.serotonin.bacnet4j.type.constructed.DeviceObjectPropertyReference;
import com.serotonin.bacnet4j.type.constructed.PropertyReference;
import com.serotonin.bacnet4j.type.constructed.PropertyValue;
import com.serotonin.bacnet4j.type.constructed.ReadAccessResult;
import com.serotonin.bacnet4j.type.constructed.ReadAccessResult.Result;
import com.serotonin.bacnet4j.type.constructed.ReadAccessSpecification;
import com.serotonin.bacnet4j.type.constructed.SequenceOf;
import com.serotonin.bacnet4j.type.constructed.SpecialEvent;
import com.serotonin.bacnet4j.type.constructed.TimeValue;
import com.serotonin.bacnet4j.type.enumerated.ObjectType;
import com.serotonin.bacnet4j.type.enumerated.PropertyIdentifier;
import com.serotonin.bacnet4j.type.primitive.Date;
import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;
import com.serotonin.bacnet4j.type.primitive.Primitive;
import com.serotonin.bacnet4j.type.primitive.Time;
import com.serotonin.bacnet4j.type.primitive.UnsignedInteger;
import com.serotonin.bacnet4j.util.RequestUtils;

import mars.Component.Functions.HWDeviceBaseClass;

public class SchedulingInternalB extends HWDeviceBaseClass{

	private RemoteDevice rd = null;
	private static LocalDevice ld = null;
	private ExtentTest logger = null;
	private List<ObjectIdentifier> oids = new ArrayList<ObjectIdentifier>();
	

	private void initialize() {
		logger = HWDeviceBaseClass.logger;
		ld = HWDeviceBaseClass.localDevice;
		rd = HWDeviceBaseClass.remoteDevice;
	}

	//Read all properties for schedule object
	//Write ExecptionSchedule
	//Write lsitOfPropertyReference
	//TimeSynchronization
	
	@SuppressWarnings("unchecked")
	@Test(description="Read Property Multiple - Required and Optional Properties")
	public void readAllPropMul(Method method) throws InterruptedException {
		initialize();
		try {
			oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();

			// Generate PropertyReferences
			for (ObjectIdentifier oid : oids) {
				if (oid.getObjectType().equals(ObjectType.schedule)) {
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

					//readAccessData(readAccessSpecs);

					
				}

			} // End OID for
			
			PropertyValue val = null;
			SequenceOf<DeviceObjectPropertyReference> listOfObjectPropertyReferences = null;
			ObjectIdentifier objectValueInPropertyRefs = null;
			for(ObjectIdentifier oid1: oids){
				if (oid1.getObjectType().equals(ObjectType.analogValue)) {
					listOfObjectPropertyReferences  = new SequenceOf<DeviceObjectPropertyReference>(
							new DeviceObjectPropertyReference(oid1, PropertyIdentifier.presentValue, null, rd.getObjectIdentifier()));
					val = new PropertyValue(PropertyIdentifier.listOfObjectPropertyReferences, listOfObjectPropertyReferences);
					objectValueInPropertyRefs = oid1;
				}
				if (oid1.getObjectType().equals(ObjectType.schedule) && val != null) {
					//RequestUtils.writePresentValue(ld, rd, oid1, val);
					setAndCheck(rd, oid1, val);
					//setAndCheck(rd, oid1, val);

				}
			}
			Encodable devLocalDate, devLocalDate1;
			Encodable devLocalTime, devLocalTime1;
			
			//Present value of object set in ListofPropRef in schedule..

			Encodable avPresentValue = RequestUtils.getProperty(ld, rd, objectValueInPropertyRefs, PropertyIdentifier.presentValue);
			System.out.println("Object: "+objectValueInPropertyRefs + " PresentValue: "+avPresentValue.toString());
			
			/*devLocalDate = RequestUtils.readProperty(ld, rd, rd.getObjectIdentifier(), PropertyIdentifier.localDate, null);

			//Encodable avPresentValue = RequestUtils.getProperty(ld, rd, objectValueInPropertyRefs, PropertyIdentifier.presentValue);
			//System.out.println("Object: "+objectValueInPropertyRefs + " PresentValue: "+avPresentValue.toString());
			
			devLocalDate = RequestUtils.readProperty(ld, rd, rd.getObjectIdentifier(), PropertyIdentifier.localDate, null);

			devLocalTime = RequestUtils.readProperty(ld, rd, rd.getObjectIdentifier(), PropertyIdentifier.localTime, null);
			
			System.out.println("Date + time: "+devLocalDate.toString() + ": "+ devLocalTime.toString());
			
			DateTime dateAndTime = new DateTime(new Date(2018, Month.JUNE, 29, null), new Time(12, 0, 0, 0));
			TimeSynchronizationRequest tsr =new TimeSynchronizationRequest(dateAndTime );
			
			ld.getEventHandler().synchronizeTime(rd.getAddress(), dateAndTime, true);
			
			devLocalDate1 = RequestUtils.readProperty(ld, rd, rd.getObjectIdentifier(), PropertyIdentifier.localDate, null);
			devLocalTime1 = RequestUtils.readProperty(ld, rd, rd.getObjectIdentifier(), PropertyIdentifier.localTime, null);
			

			System.out.println("Date + time: "+devLocalDate1.toString() + ": "+ devLocalTime1.toString());*/

			

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
	
	@SuppressWarnings("unchecked")

	@Test(description="135.1-2013 - 7.3.2.23.11.1 - Scheduling - Internal - B - Internally Written Datatypes Test, Boolean values")

	//@Test(description="135.1-2013 - 7.3.2.23.11.1 - Scheduling - Internal - B - Internally Written Datatypes Test, Boolean values")

	public void SchedulingBIwrBoolVal(Method method) {
		initialize();
		try {
			oids = ((SequenceOf<ObjectIdentifier>) RequestUtils.sendReadPropertyAllowNull(ld, rd,
					rd.getObjectIdentifier(), PropertyIdentifier.objectList)).getValues();

			for (ObjectIdentifier oid : oids) {
				if (oid.getObjectType().equals(ObjectType.schedule)) {
					getSchedule(rd, oid.getInstanceNumber());
				}

			} // End OID for
		} catch (BACnetException e) {
			e.printStackTrace();
		}
	}
	
	private void getSchedule(RemoteDevice d, int id) {
		 ObjectIdentifier oid = new ObjectIdentifier(ObjectType.schedule, id);
		 
		 PropertyValue pv;

	        //        pv = new PropertyValue(PropertyIdentifier.presentValue, null);

	        //        pv = new PropertyValue(PropertyIdentifier.outOfService,
	        //                new com.serotonin.bacnet4j.type.primitive.Boolean(false));

	        //        Date date = new Date(new GregorianCalendar(2012, Calendar.SEPTEMBER, 24));
	        //        Date unspecified = new Date(-1, Month.valueOf(0), -1, DayOfWeek.valueOf(0));
	        //        pv = new PropertyValue(PropertyIdentifier.effectivePeriod, new DateRange(date, unspecified));


	               CalendarEntry ce = new CalendarEntry(new Date(new GregorianCalendar(2017, Calendar.MAY, 31)));
	                List<TimeValue> timeValues = new ArrayList<TimeValue>();
	                timeValues.add(new TimeValue(new Time(6, 0, 0, 0), new UnsignedInteger(13)));

	               //CalendarEntry ce = new CalendarEntry(new Date(new GregorianCalendar(2000, Calendar.MAY, 29)));
	                //List<TimeValue> timeValues = new ArrayList<TimeValue>();
	                //timeValues.add(new TimeValue(new Time(12, 0, 0, 0), new UnsignedInteger(13)));

	                SpecialEvent se = new SpecialEvent(ce, new SequenceOf<TimeValue>(timeValues), new UnsignedInteger(15));
	                pv = new PropertyValue(PropertyIdentifier.exceptionSchedule, null, se, null);
	                
	             // pv = new PropertyValue(PropertyIdentifier.exceptionSchedule, null, new UnsignedInteger(0), null);
	                

	                //        pv = new PropertyValue(PropertyIdentifier.weeklySchedule, null);
	                //        [DailySchedule [daySchedule=[TimeValue [time=7:0:0.0, value=1], TimeValue [time=16:0:0.0, value=2]]], DailySchedule [daySchedule=[TimeValue [time=7:0:0.0, value=1], TimeValue [time=16:0:0.0, value=2]]], DailySchedule [daySchedule=[TimeValue [time=7:0:0.0, value=1], TimeValue [time=16:0:0.0, value=2]]], DailySchedule [daySchedule=[TimeValue [time=7:0:0.0, value=1], TimeValue [time=16:0:0.0, value=2]]], DailySchedule [daySchedule=[TimeValue [time=7:0:0.0, value=1], TimeValue [time=16:0:0.0, value=2]]], DailySchedule [daySchedule=[TimeValue [time=7:0:0.0, value=1], TimeValue [time=16:0:0.0, value=2]]], DailySchedule [daySchedule=[TimeValue [time=7:0:0.0, value=1], TimeValue [time=16:0:0.0, value=2]]]]

	                //        System.out.println(get(d, oid, pv));
	                setAndCheck(d, oid, pv);

	                //        PropertyReferences refs = new PropertyReferences();
	                //        refs.add(oid, PropertyIdentifier.effectivePeriod, PropertyIdentifier.weeklySchedule,
	                //                PropertyIdentifier.scheduleDefault, PropertyIdentifier.priorityForWriting,
	                //                PropertyIdentifier.outOfService, PropertyIdentifier.statusFlags, PropertyIdentifier.exceptionSchedule,
	                //                PropertyIdentifier.listOfObjectPropertyReferences);
	                //        PropertyValues values = RequestUtils.readProperties(localDevice, d, refs, null);
		
	}

	
    static void setAndCheck(RemoteDevice d, ObjectIdentifier oid, PropertyValue pv) {
        System.out.println("Before: " + get(d, oid, pv));
        set(d, oid, pv);
        System.out.println("After: " + get(d, oid, pv));
    }

    static Encodable get(RemoteDevice d, ObjectIdentifier oid, PropertyValue pv) {

                //Encodable e = RequestUtils.readProperty(localDevice, d, oid, pv.getPropertyIdentifier(),
                  //      pv.getPropertyArrayIndex());

        //        Encodable e = RequestUtils.readProperty(localDevice, d, oid, pv.getPropertyIdentifier(),
        //                pv.getPropertyArrayIndex());

        Encodable e = null;
		try {
			e = RequestUtils.readProperty(ld, d, oid, pv.getPropertyIdentifier(), null);
	        
	        if (e instanceof AmbiguousValue)
	            e = ((AmbiguousValue) e).convertTo(Primitive.class);
		} catch (BACnetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return e;
    }

    static void set(RemoteDevice d, ObjectIdentifier oid, PropertyValue pv) {

		WritePropertyRequest wpr = new WritePropertyRequest(oid, pv.getPropertyIdentifier(), null, pv.getValue(), null);
		ServiceFuture future = ld.send(d, wpr);
    	 
    }
	

}























