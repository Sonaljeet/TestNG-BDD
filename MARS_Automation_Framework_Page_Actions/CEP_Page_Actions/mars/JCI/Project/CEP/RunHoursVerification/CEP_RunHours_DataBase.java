package mars.JCI.Project.CEP.RunHoursVerification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class CEP_RunHours_DataBase {

	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public void connectToCEPPDB() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionURL = "jdbc:sqlserver://ceppsql.database.windows.net;"
				+ "databaseName=ceppsqldb;user=jciazdeploy;password=jpv2Tur5wZpg7SJb;";
		try {

			Class.forName(driverName);
			// System.out.println("Connecting");
			con = DriverManager.getConnection(connectionURL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet userFetchedAssetDetailsForRawData() {
		connectToCEPPDB();
		String sql = "select AssetId as AssetID,ProjectId as ProjectID,AssetSQLID,CustomerName,ProjectName,AssetName from AssetDetails order by CustomerName;";
				// where CustomerName in('ARIA RESORT & CASINO','CITY OF PHOENIX AVIATION FACILITIES','EGRMC','UT HEALTH SCIENCE CENTER SAN ANTONIO','JCI GWS GENERAL MOTORS','HARLEY DAVIDSON MOTOR CO','NEWPORT CORP') order by CustomerName
				//"Select AssetId, ProjectId, CustomerName, AssetName from AssetDetails order by AssetID;";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public ResultSet userFetchedAssetDetails() {
		connectToCEPPDB();
		String sql = "select AssetId as AssetID,ProjectId as ProjectID,AssetSQLID,CustomerName,ProjectName,AssetName from AssetDetails where AssetSQLID in (339 ,340 ,1524 ,1525 ,1526 ,1527 ,1528 ,2105 ,2106 ,2107 ,2108 ,2109 ,2110 ,2111 ,2112 ,2113 ,2114 ,2700 ,2701 ,2731 ,3060 ,3069 ,3070 ,3074 ,3075 ,3120 ,3121 ,3142 ,3173 ,3174 ,3180 ,3190 ,3195 ,3206 ,3207 ,3208 ,3209 ,3210 ,3211 ,3212 ,3213 ,3214 ,3215 ,3219 ,3225 ,3244 ,3245 ,3246 ,3267 ,3268 ,3269 ,3270 ,3271 ,3272 ,3284 ,3285 ,3286 ,3290 ,3291 ,3292 ,3293 ,3294 ,3299 ,3300 ,3301 ,3302 ,3303 ,3304 ,3316 ,3381 ,3405 ,3435 ,3436 ,3443 ,3446 ,3460 ,3463 ,3595 ,3786 ,3792 ,3793 ,3794 ,3795 ,3835 ,3836 ,3837 ,3856 ,3902 ,3904 ,3905 ,3924 ,3925 ,3926 ,3939 ,3940 ,3952 ,3958 ,3959 ,3960 ,3961 ,3962 ,3963 ,3964 ,3967 ,3969 ,3970 ,3971 ,3972 ,3973 ,3977 ,3978 ,3979 ,3980 ,3982 ,3983 ,3984 ,3985 ,3986 ,3987 ,3988 ,3989 ,3990 ,3993 ,3994 ,3995 ,3996 ,4003 ,4004 ,4006 ,4007 ,4008 ,4009 ,4010 ,4011 ,4012 ,4013 ,4014 ,4015 ,4016 ,4022 ,4023 ,4024 ,4025 ,4026 ,4027 ,4028 ,4029 ,4030 ,4031 ,4032 ,4050 ,4051 ,4052 ,4053 ,4064 ,4065 ,4066 ,4067 ,4068 ,4069 ,4070 ,4071 ,4072 ,4081 ,4082 ,4083 ,4084 ,4085 ,4086 ,4087 ,4088 ,4091 ,4092 ,4095 ,4096 ,4097 ,4098 ,4099 ,4100 ,4101 ,4102 ,4103 ,4104 ,4105 ,4106 ,4108 ,4112 ,4113 ,4114 ,4115 ,4116 ,4117 ,4118 ,4119 ,4120 ,4121 ,4130 ,4131 ,4132 ,4133 ,4135 ,4136 ,4138 ,4139 ,4140 ,4141 ,4144 ,4145 ,4149 ,4150 ,4151 ,4152 ,4153 ,4154 ,4155 ,4160 ,4161 ,4165 ,4166 ,4168 ,4169 ,4170 ,4171 ,4172 ,4173 ,4175 ,4176 ,4177 ,4178 ,4179 ,4193 ,4194 ,4195 ,4196 ,4197 ,4198 ,4199 ,4200 ,4201 ,4202 ,4203 ,4208 ,4212 ,4213 ,4214 ,4216 ,4220 ,4221 ,4228 ,4229 ,4234 ,4235 ,4236 ,4237 ,4239 ,4243 ,4244 ,4245 ,4246 ,4247 ,4248 ,4249 ,4252 ,4253 ,4255 ,4256 ,4257 ,4258 ,4259 ,4260 ,4261 ,4262 ,4263 ,4264 ,4265 ,4266 ,4267 ,4270 ,4271 ,4273 ,4274 ,4275 ,4276 ,4277 ,4280 ,4288 ,4289 ,4291 ,4292 ,4293 ,4294 ,4295 ,4296 ,4297 ,4298 ,4299 ,4300 ,4302 ,4303 ,4304 ,4305 ,4306 ,4307 ,4317 ,4318 ,4319 ,4320 ,4321 ,4322 ,4323 ,4324 ,4325 ,4326 ,4327 ,4328 ,4329 ,4330 ,4331 ,4332 ,4333 ,4334 ,4335 ,4336 ,4337 ,4338 ,4346 ,4347 ,4348 ,4349 ,4350 ,4351 ,4352 ,4353 ,4355 ,4356 ,4357 ,4361 ,4362 ,4363 ,4364 ,4365 ,4366 ,4367 ,4368 ,4371 ,4372 ,4373 ,4374 ,4375 ,4376 ,4378 ,4379 ,4380 ,4381 ,4383 ,4384 ,4385 ,4388 ,4389 ,4390 ,4391 ,4392 ,4393 ,4394 ,4395 ,4396 ,4397 ,4398 ,4401 ,4402 ,4403 ,4404 ,4405 ,4406 ,4407 ,4408 ,4411 ,4414 ,4415 ,4416 ,4432 ,4439 ,4440 ,4441 ,4442 ,4443 ,4444 ,4446 ,4447 ,4448 ,4449 ,4450 ,4451 ,4455 ,4456 ,4457 ,4458 ,4459 ,4460 ,4461 ,4462 ,4463 ,4464 ,4465 ,4466 ,4468 ,4469 ,4473 ,4474 ,4475 ,4476 ,4477 ,4483 ,4499 ,4500 ,4501 ,4502 ,4507 ,4508 ,4509 ,4510 ,4522 ,4523 ,4524 ,4525 ,4526 ,4527 ,4534 ,4535 ,4536 ,4537 ,4538 ,4539 ,4540 ,4541 ,4542 ,4543 ,4544 ,4545 ,4546 ,4547 ,4548 ,4549 ,4550 ,4552 ,4553 ,4554 ,4555 ,4556 ,4557 ,4558 ,4559 ,4560 ,4571 ,4572 ,4573 ,4574 ,4575 ,4576 ,4577 ,4578 ,4579 ,4580 ,4581 ,4582 ,4583 ,4584 ,4585 ,4586 ,4587 ,4588 ,4589 ,4590 ,4591 ,4592 ,4593 ,4594 ,4595 ,4596 ,4597 ,4598 ,4599 ,4601 ,4602 ,4603 ,4604 ,4605 ,4606 ,4607 ,4608 ,4609 ,4610 ,4611 ,4612 ,4615 ,4616 ,4617 ,4621 ,4622 ,4623 ,4624 ,4625 ,4626 ,4627 ,4628 ,4635 ,4636 ,4639 ,4640 ,4641 ,4642 ,4643 ,4644 ,4645 ,4646 ,4649 ,4650 ,4652 ,4653 ,4654 ,4655 ,4657 ,4664 ,4665 ,4666 ,4667 ,4668 ,4669 ,4670 ,4671 ,4672 ,4673 ,4677 ,4678 ,4679 ,4680 ,4681 ,4682 ,4683 ,4684 ,4685 ,4686 ,4687 ,4688 ,4693 ,4694 ,4695 ,4696 ,4697 ,4698 ,4699 ,4700 ,4703 ,4704 ,4705 ,4708 ,4709 ,4710 ,4715 ,4716 ,4717 ,4718 ,4722 ,4723 ,4724 ,4725 ,4726 ,4727 ,4729 ,4730 ,4736 ,4737 ,4738 ,4739 ,4740 ,4741 ,4742 ,4743 ,4744 ,4745 ,4746 ,4747 ,4748 ,4749 ,4750 ,4751 ,4752 ,4753 ,4754 ,4755 ,4756 ,4757 ,4758 ,4759 ,4760 ,4761 ,4762 ,4766 ,4767 ,4768 ,4769 ,4770 ,4771 ,4774 ,4775 ,4777 ,4778 ,4779 ,4780 ,4783 ,4784 ,4785 ,4786 ,4787 ,4788 ,4789 ,4790 ,4791 ,4792 ,4793 ,4794 ,4795 ,4796 ,4797 ,4798 ,4799 ,4800 ,4801 ,4802 ,4803 ,4804 ,4805 ,4806 ,4807 ,4810 ,4811 ,4812 ,4813 ,4814 ,4815 ,4816 ,4817 ,4818 ,4819 ,4820 ,4821 ,4822 ,4823 ,4824 ,4825 ,4826 ,4827 ,4828 ,4829 ,4830 ,4831 ,4832 ,4833 ,4834 ,4835 ,4836 ,4837 ,4838 ,4839 ,4840 ,4841 ,4844 ,4845 ,4846 ,4847 ,4848 ,4849 ,4851 ,4853 ,4855 ,4856 ,4857 ,4858 ,4859 ,4860 ,4861 ,4862 ,4863 ,4864 ,4865 ,4866 ,4867 ,4868 ,4869 ,4870 ,4871 ,4872 ,4873 ,4874 ,4875 ,4876 ,4877 ,4878 ,4879 ,4880 ,4881 ,4882 ,4883 ,4884 ,4885 ,4886 ,4887 ,4888 ,4889 ,4890 ,4891 ,4892 ,4893 ,4894 ,4895 ,4896 ,4897 ,4898 ,4899 ,4900 ,4902 ,4903 ,4904 ,4905 ,4906 ,4907 ,4908 ,4909 ,4910 ,4911 ,4912 ,4913 ,4914 ,4915 ,4916 ,4917 ,4918 ,4919 ,4920 ,4921 ,4927 ,4928 ,4929 ,4930 ,4931 ,4932 ,4933 ,4934 ,4936 ,4937 ,4938 ,4939 ,4940 ,4941 ,4942 ,4943 ,4944 ,4945 ,4946 ,4947 ,4948 ,4949 ,4950 ,4951 ,4952 ,4953 ,4954 ,4955 ,4956 ,4957 ,4958 ,4959 ,4960 ,4961 ,4962 ,4963 ,4964 ,4965 ,4967 ,4968 ,4969 ,4970 ,4971 ,4972 ,4973 ,4974 ,4975 ,4976 ,4977 ,4978 ,4979 ,4980 ,4981 ,4982 ,4983 ,4984 ,4985 ,4986 ,4987 ,4988 ,4989 ,4991 ,4992 ,4993 ,4994 ,4995 ,4996 ,4997 ,4998 ,4999 ,5000 ,5002 ,5003 ,5004 ,5006 ,5007 ,5008 ,5009 ,5011 ,5012 ,5013 ,5014 ,5015 ,5016 ,5017 ,5018 ,5019 ,5021 ,5022 ,5023 ,5024 ,5025 ,5026 ,5027 ,5028 ,5029 ,5030 ,5031 ,5032 ,5033 ,5034 ,5035 ,5036 ,5037 ,5038 ,5039 ,5040 ,5041 ,5042 ,5043 ,5044 ,5045 ,5046 ,5047 ,5048 ,5051 ,5052 ,5053 ,5054 ,5055 ,5056 ,5057 ,5058 ,5059 ,5060 ,5061 ,5062 ,5064 ,5065 ,5066 ,5067 ,5068 ,5069 ,5070 ,5071 ,5072 ,5073 ,5074 ,5075 ,5076 ,5077 ,5078 ,5079 ,5080 ,5081 ,5082 ,5083 ,5084 ,5085 ,5086 ,5087 ,5088 ,5089 ,5090 ,5091 ,5092 ,5093 ,5094 ,5095 ,5096 ,5097 ,5098 ,5099 ,5101 ,5102 ,5103 ,5104 ,5105 ,5106 ,5107 ,5108 ,5109 ,5110 ,5111 ,5112 ,5113 ,5114 ,5115 ,5116 ,5117 ,5118 ,5119 ,5120 ,5121 ,5122 ,5123 ,5124 ,5125 ,5126 ,5127 ,5128 ,5129 ,5130 ,5131 ,5132 ,5133 ,5134 ,5135 ,5136 ,5137 ,5138 ,5139 ,5140 ,5141 ,5142 ,5143 ,5144 ,5145 ,5146 ,5147 ,5148 ,5149 ,5150 ,5151 ,5152 ,5153 ,5154 ,5155 ,5156 ,5157 ,5158 ,5159 ,5160 ,5161 ,5162 ,5163 ,5164 ,5165 ,5166 ,5167 ,5168 ,5169 ,5170 ,5171 ,5172 ,5173 ,5174 ,5175 ,5176 ,5177 ,5178 ,5179 ,5180 ,5181 ,5182 ,5183 ,5184 ,5185 ,5186 ,5187 ,5188 ,5189 ,5190 ,5191 ,5192 ,5195 ,5196 ,5197 ,5198 ,5199 ,5203 ,5204 ,5205 ,5206 ,5207 ,5208 ,5209 ,5210 ,5211 ,5212 ,5213 ,5214 ,5215 ,5216 ,5217 ,5218 ,5219 ,5220 ,5221 ,5222 ,5223 ,5224 ,5225 ,5226 ,5227 ,5228 ,5229 ,5230 ,5231 ,5232 ,5233 ,5234 ,5235 ,5236 ,5237 ,5238 ,5239 ,5240 ,5241 ,5242 ,5243 ,5244 ,5245 ,5246 ,5247 ,5248 ,5249 ,5250 ,5251 ,5252 ,5253 ,5254 ,5255 ,5256 ,5257 ,5258 ,5259 ,5260 ,5261 ,5262 ,5263 ,5264 ,5265 ,5266 ,5268 ,5269 ,5270 ,5271 ,5272 ,5273 ,5274 ,5275 ,5276 ,5277 ,5278 ,5279 ,5280 ,5281 ,5282 ,5283 ,5284 ,5285 ,5288 ,5289 ,5290 ,5291 ,5292 ,5293 ,5294 ,5295 ,5296 ,5297 ,5298 ,5299);";
				//"Select AssetId, ProjectId, CustomerName, AssetName from AssetDetails order by AssetID;";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void connectUATDB() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionURL = "jdbc:sqlserver://cepusql.database.windows.net;"
				+ "databaseName=cepuatsqldb;user=jciazdeploy;password=U4LeJdwNTZVEBpSm;";
		try {
			// System.load("C:/Users/jaroraso/Downloads/MicrosoftJDBCDriver6.2forSQLServer/sqljdbc_6.2/enu/auth/x64/sqljdbc_auth.dll");
			Class.forName(driverName);
			// System.out.println("Connecting");
			con = DriverManager.getConnection(connectionURL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addDataToTable(String customerName,String projectName,String assetName,String assetID, String attributeID, double dailyDeltaValue, double rawDataValue,
			String isDailyDeltaData, String isRawData, boolean isEqual,String date) {
		connectUATDB();
		try {
			String sql = "INSERT INTO RunHoursVerification values('"+customerName+"','"+projectName+"','"+assetName+"''" + assetID + "','" + attributeID + "',"
					+ dailyDeltaValue + "," + rawDataValue + ",'" + isDailyDeltaData + "','" + isRawData + "','"
					+ isEqual + "','"+date+"')";
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addDataToRawDataTable(String customer, String project,String assetName, String assetID, String pointID, String attributeName, int count) {
		connectUATDB();
		try {
			String sql = "INSERT INTO RawDataCountVerification values('"+customer+"','"+project+"','"+assetName+"','" + assetID + "','" + pointID + "','"+attributeName+"',"
					+ count + ",'2018-12-20 00:00:00')";
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
