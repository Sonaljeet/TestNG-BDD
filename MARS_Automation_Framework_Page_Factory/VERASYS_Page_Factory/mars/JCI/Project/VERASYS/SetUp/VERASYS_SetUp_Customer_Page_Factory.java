package mars.JCI.Project.VERASYS.SetUp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class VERASYS_SetUp_Customer_Page_Factory {
	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new Verasys login page factory.
	 *
	 * @param driver the driver
	 */
	public VERASYS_SetUp_Customer_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** All WebElements are identified by @FindBy annotation. */
	@FindBy(css ="a[automation-id='tabCust']")
	WebElement customerTab;
	/**
	 * Gets the Customer Tab.
	 *
	 * @return the Customer Tab.
	 */
	public WebElement getCustomerTab() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerTab, logger)) {
			return this.customerTab;
		} else {
			return null;
		}
	}		
	
	@FindBy(css= "span[automation-id=spncustref]")
	WebElement customerID;
	/**
	 * Gets the Customer ID.
	 *
	 * @return the Customer ID.
	 */
	public WebElement getCustomerID() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerID, logger)) {
			return this.customerID;
		} else {
			return null;
		}
	}	
	
	@FindBy(name ="CustomerName")
	WebElement customerName;
	/**
	 * Gets the Customer Name.
	 *
	 * @return the Customer Name.
	 */
	public WebElement getCustomerName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerName, logger)) {
			return this.customerName;
		} else {
			return null;
		}
	}	
	
	@FindBy(name ="Address_2")
	WebElement address_2;
	/**
	 * Gets the Customer Address_2.
	 *
	 * @return the Customer Address_2.
	 */
	public WebElement getAddress_2() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, address_2, logger)) {
			return this.address_2;
		} else {
			return null;
		}
	}	
	@FindBy(name ="Address_1")
	WebElement address_1;
	/**
	 * Gets the Customer Address_1.
	 *
	 * @return the Customer Address_1.
	 */
	public WebElement getAddress_1() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, address_1, logger)) {
			return this.address_1;
		} else {
			return null;
		}
	}	
	@FindBy(name ="Abbreviation")
	WebElement abbreviation;
	/**
	 * Gets the Customer Abbreviation.
	 *
	 * @return the Customer Abbreviation.
	 */
	public WebElement getAbbreviation() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, abbreviation, logger)) {
			return this.abbreviation;
		} else {
			return null;
		}
	}	
	@FindBy(name ="CustBillingNumber")
	WebElement customerBillingId;
	/**
	 * Gets the JCI Customer Billing ID.
	 *
	 * @return the customerBillingId.
	 */
	public WebElement getCustomerBillingId() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerBillingId, logger)) {
			return this.customerBillingId;
		} else {
			return null;
		}
	}	
	
	@FindBy(css = "select[automation-id=drpdwnCustState]")
	WebElement state;
	/**
	 * Gets the Customer State.
	 *
	 * @return the Customer State.
	 */
	public WebElement getState() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, state, logger)) {
			return this.state;
		} else {
			return null;
		}
	}	
	
	@FindBy(css = "select[automation-id=drpdwnCustCountry]")
	WebElement country;
	/**
	 * Gets the Customer Country.
	 *
	 * @return the Customer Country.
	 */
	public WebElement getCountry() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, country, logger)) {
			return this.country;
		} else {
			return null;
		}
	}	
	@FindBy(css = "select[automation-id=drpdwnCustCity]")
	WebElement city;
	/**
	 * Gets the Customer City.
	 *
	 * @return the Customer City.
	 */
	public WebElement getCity() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, city, logger)) {
			return this.city;
		} else {
			return null;
		}
	}	


	@FindBy(name ="Zipcode")
	WebElement zipcode;
	/**
	 * Gets the Customer Zipcode.
	 *
	 * @return the Customer Zipcode.
	 */
	public WebElement getZipcode() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, zipcode, logger)) {
			return this.zipcode;
		} else {
			return null;
		}
	}	

	@FindBy(id ="customerLogo")
	WebElement uploadCustomerLogo;
	/**
	 * Gets the Customer Logo Upload .
	 *
	 * @return the upload logo button.
	 */
	public WebElement getUploadCustomerLogo() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, uploadCustomerLogo, logger)) {
			return this.uploadCustomerLogo;
		} else {
			return null;
		}
	}	
	@FindBy(id ="viewLogo")
	WebElement viewLogo;
	/**
	 * Gets the View Customer Logo.
	 *
	 * @return the View Customer Logo.
	 */
	public WebElement getViewLogo() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, viewLogo, logger)) {
			return this.viewLogo;
		} else {
			return null;
		}
	}
	
	@FindBy(name ="ContactType")
	WebElement contactType;
	/**
	 * Gets the Customer Contact Type.
	 *
	 * @return the Customer Contact Type.
	 */
	public WebElement getContactType() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, contactType, logger)) {
			return this.contactType;
		} else {
			return null;
		}
	}
	
	@FindBy(css="input[automation-id=txtStartDate]")
	WebElement startDate;
	/**
	 * Gets the Customer StartDate.
	 *
	 * @return the Customer StartDate.
	 */
	public WebElement getStartDate() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, startDate, logger)) {
			return this.startDate;
		} else {
			return null;
		}
	}
		@FindBy(css="input[automation-id=txtEndDate]")
		WebElement endDate;
		/**
		 * Gets the Customer EndDate.
		 *
		 * @return the Customer EndDate.
		 */
		public WebElement getEndDate() {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, endDate, logger)) {
				return this.endDate;
			} else {
				return null;
			}
	}
		@FindBy(id ="drpdwnCustCurrency")
		WebElement currency;
		/**
		 * Gets the Customer Currency.
		 *
		 * @return the Customer Currency.
		 */
		public WebElement getCurrency() {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, currency, logger)) {
				return this.currency;
			} else {
				return null;
			}
		}

			@FindBy(id ="drpdwnCustUnitCost")
			WebElement costUnit;
			/**
			 * Gets the Customer Cost Unit per Kwh.
			 *
			 * @return the Customer Cost Unit per Kwh.
			 */
			public WebElement getCostUnit() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, costUnit, logger)) {
					return this.costUnit;
				} else {
					return null;
				}
	}

			@FindBy(css= "input[automation-id=txtCustContactName]")
			WebElement contactName;
			/**
			 * Gets the Customer Contact Name.
			 *
			 * @return the Customer Contact Name.
			 */
			public WebElement getContactName() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, contactName, logger)) {
					return this.contactName;
				} else {
					return null;
				}
	}
			
			@FindBy(name ="Designation")
			WebElement designation;
			/**
			 * Gets the Customer Designation.
			 *
			 * @return the Customer Designation.
			 */
			public WebElement getDesignation() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, designation, logger)) {
					return this.designation;
				} else {
					return null;
				}
	}
			@FindBy(name ="ContactNo")
			WebElement contactNo;
			/**
			 * Gets the Customer Contact Number.
			 *
			 * @return the Customer Contact Number.
			 */
			public WebElement getContactNo() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, contactNo, logger)) {
					return this.contactNo;
				} else {
					return null;
				}
	}
			@FindBy(name ="Email")
			WebElement email;
			/**
			 * Gets the Customer Email.
			 *
			 * @return the Customer Email.
			 */
			public WebElement getEmail() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, email, logger)) {
					return this.email;
				} else {
					return null;
				}
	}
			@FindBy(xpath ="//button[contains(text(),'Add')]")
			WebElement addBtn;
			/**
			 * Gets Add Button.
			 *
			 * @return Add Button.
			 */
			public WebElement getAddBtn() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, addBtn, logger)) {
					return this.addBtn;
				} else {
					return null;
				}
	}
			@FindBy(xpath ="//button[contains(text(),'Update')]")
			WebElement updateBtn;
			/**
			 * Gets Update Button.
			 *
			 * @return Update Button.
			 */
			public WebElement getUpdateBtn() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, updateBtn, logger)) {
					return this.updateBtn;
				} else {
					return null;
				}
	}
			@FindBy(xpath ="//button[contains(text(),'Clear')]")
			WebElement clearBtn;
			/**
			 * Gets Clear Button.
			 *
			 * @return Clear Button.
			 */
			public WebElement getClearBtn() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, clearBtn, logger)) {
					return this.clearBtn;
				} else {
					return null;
				}
	}

			@FindBy(xpath ="//div[contains(text(),'Customer name must contains')]")
			WebElement customerNameError;
			/**
			 * Gets Clear Button.
			 *
			 * @return Clear Button.
			 */
			public WebElement getCustomerNameError() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerNameError, logger)) {
					return this.customerNameError;
				} else {
					return null;
				}
	}	
			@FindBy(xpath ="//div[contains(text(),'Please enter customer name')]")
			WebElement mandatoryCustomerNameError;
			/**
			 * Gets Clear Button.
			 *
			 * @return Clear Button.
			 */
			public WebElement getMandatoryCustomerNameError() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, mandatoryCustomerNameError, logger)) {
					return this.mandatoryCustomerNameError;
				} else {
					return null;
				}
	}	
			/**
			 * Gets No of records Lable.
			 *
			 * @return No of records Lable.
			 */
			@FindBy(css= "label[automation_id=noOfRecords]")
			WebElement noOfRecords;
			/**
			 * Gets Clear Button.
			 *
			 * @return Clear Button.
			 */
			public WebElement getNoOfRecords() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, noOfRecords, logger)) {
					return this.noOfRecords;
				} else {
					return null;
				}
	}	
			
			/**
			 * Gets Success message toaster.
			 *
			 * @return Success message toaster.
			 */
			@FindBy(css="span.toast-message")
			WebElement toastMessage;
			/**
			 * Gets Alert Messages.
			 *
			 * @return Alert Messages.
			 */
			public WebElement getToastMessage() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, toastMessage, logger)) {
					return this.toastMessage;
				} else {
					return null;
				}
	}	
			/**
			 * Gets Success message toaster.
			 *
			 * @return Success message toaster.
			 */
			@FindBy(css="div.toast toast-error")
			WebElement toastErrorMessage;
			/**
			 * Gets Clear Button.
			 *
			 * @return Clear Button.
			 */
			public WebElement getToastErrorMessage() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, toastErrorMessage, logger)) {
					return this.toastErrorMessage;
				} else {
					return null;
				}
	}	
			@FindBy(css="section.customer-setup")
			WebElement customerSection;
			/**
			 * Gets Clear Button.
			 *
			 * @return Clear Button.
			 */
			public WebElement getcustomerSection() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerSection, logger)) {
					return this.customerSection;
				} else {
					return null;
				}
	}
			
			@FindBy(css="input#CustRefId")
			WebElement custIDSearch;
			/**
			 * Gets Customer ID search box.
			 *
			 * @return Customer ID search box.
			 */
			public WebElement getCustIDSearch() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, custIDSearch, logger)) {
					return this.custIDSearch;
				} else {
					return null;
				}
	}
			
			@FindBy(xpath="//div[@id='customergrid']//table/tbody")
			WebElement custGrid;
			/**
			 * Gets Customer grid.
			 *
			 * @return Customer grid tbody.
			 */
			public WebElement getCustGrid() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, custGrid, logger)) {
					return this.custGrid;
				} else {
					return null;
				}
	}
			
			
			/**
			 * Gets Calender Table.
			 *
			 * @return Calender Table.
			 */
			@FindBy(className="datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top")
			WebElement tblCalendar;
			public WebElement getCalender() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, tblCalendar, logger)) {
					return this.tblCalendar;
				} else {
					return null;
				}
	}
			
			/**
			 * Gets Previous button on date picker.
			 *
			 * @return btnPrevious .
			 */
			@FindBy(css="th.prev")
			WebElement btnPrevious;
			public WebElement getBtnPrevious() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, btnPrevious, logger)) {
					return this.btnPrevious;
				} else {
					return null;
				}
	}
			/**
			 * Gets Next button on date picker.
			 *
			 * @return btnNext .
			 */
			@FindBy(css="th.next")
			WebElement btnNext;
			public WebElement getBtnNext() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, btnNext, logger)) {
					return this.btnNext;
				} else {
					return null;
				}
	}
			/**
			 * Gets year on date picker.
			 *
			 * @return year .
			 */
			@FindBy(css="div.datepicker-years")
			WebElement lblYear;
			public WebElement getlblYear() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, lblYear, logger)) {
					return this.lblYear;
				} else {
					return null;
				}
	}
			/**
			 * Gets month on date picker.
			 *
			 * @return month .
			 */
			@FindBy(css="div.datepicker-months")
			WebElement lblMonth;
			public WebElement getlblMonth() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, lblMonth, logger)) {
					return this.lblMonth;
				} else {
					return null;
				}
	}
			/**
			 * Gets date on date picker.
			 *
			 * @return date .
			 */
			@FindBy(css="div.datepicker-days")
			WebElement lblDate;
			public WebElement getlblDate() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, lblDate, logger)) {
					return this.lblDate;
				} else {
					return null;
				}
	}
			
			/**
			 * Gets next button on date picker.
			 *
			 * @return date .
			 */
			@FindBy(xpath="/html/body/div[2]/div[1]/table/thead/tr[2]/th[3]")
			WebElement dateNext;
			public WebElement getdateNext() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, dateNext, logger)) {
					return this.dateNext;
				} else {
					return null;
				}
	}	
			
			@FindBy(id ="CustomerName")
			WebElement serachCustName;
			/**
			 * Gets the Customer Name.
			 *
			 * @return the Customer Name.
			 */
			public WebElement getSearchCustName() {
				if (commonFunctions.WebElementCommon.waitForElementPresent(driver, serachCustName, logger)) {
					return this.serachCustName;
				} else {
					return null;
				}
			}
			
			
}
