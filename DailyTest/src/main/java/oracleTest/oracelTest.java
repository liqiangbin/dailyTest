package oracleTest;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class oracelTest {
	/**
	 * 一个非常标准的连接Oracle数据库的示例代码
	 */
	public void testOracle(String[] key,String[] name,String[] role)
	{
	    Connection con = null;// 创建一个数据库连接
	    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	    int result ;// 创建一个结果集对象
	    try
	    {
	        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接数据库！");
	        String url = "jdbc:oracle:" + "thin:@10.100.16.25:1521:ipos";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String user = "interdb";// 用户名,系统默认的账户名
	        String password = "interdb";// 你安装时选设置的密码
	        con = DriverManager.getConnection(url, user, password);// 获取连接
	        System.out.println("连接成功！");
	        
	        //以下字段上生产需要检查修改
	        int signNO=77; //注意：sql语句中需要修改时间
	        int IDNO=452; 
	        String pubRsaStr="30819F300D06092A864886F70D010101050003818D0030818902818100CB7EC350D691F1A00BB8E80150BAFED135C582C7CB11FD81E1CE475183C7BB2E5CB39D62E901B8EB3D8A4A3657A6FF29F82881E5580923F9FFF003CA845113CC6B031D2399D932D08044E9FCAEA153AFF46195D75CE6EA594012B7F94245C49CDD55AE9DA81F79AFC8E6939CC4FBE4C992F03F7A2825EC59FA8DEB23BA33F2B90203010001";
	        String res_secret="41504D5059445A4659445A4641504D5041504D5059445A46";
	        Date date=new Date();
	        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
	        String createDate=format.format(date);
	        for (int i = 0; i < key.length; i++) {
	        	IDNO+=1;
	        	signNO+=1;
				System.out.println("key="+key[i]+"|name="+name[i]);
				//插入O_APP
				 String sql1 = "INSERT INTO O_APP (ID,KEY,NAME,PARTNERS_ID,STAT,SIGN_METHOD,RES_NEED_SIGN,TYPE,CREATE_DATE,LAST_UPDATE_TS,ACQ_BRH_ID,MERCH_ID)"
				 		+ " VALUES ("+IDNO+",'"+key[i]+"','"+name[i]+"','1','1','rsa','1',3,'20161115','15-11月-16','0302500000','"+key[i]+"')";
			        pre = con.prepareStatement(sql1);// 实例化预编译语句
			        result= pre.executeUpdate(sql1);
			        System.out.println("表1受影响的记录="+result);
			    //插入O_SIGN_SECRET
			        String sql2 = "INSERT INTO O_SIGN_SECRET (ID,APP_KEY,VERSION,REQ_SECRET,RES_SECRET,DATA_SECRET,LAST_USE_TM,CREATE_TM,OPR_ID)"
			        		+ "VALUES ('"+signNO+"','"+key[i]+"','1','"+pubRsaStr+"','"+res_secret+"','57c71307','20990101','"+createDate+"','Bin')";
			        pre = con.prepareStatement(sql2);// 实例化预编译语句
			        result= pre.executeUpdate(sql2);
			        System.out.println("表2受影响的记录="+result);
			        
			        for (int j = 0; j < role.length; j++){
			        //开始通过数据库配置权限
			        String sql3 = "INSERT INTO O_APP_API (APP_ID,API_ID)"
			        		+ "VALUES ('"+IDNO+"','"+role[j]+"')";
			        pre = con.prepareStatement(sql3);// 实例化预编译语句
			        result= pre.executeUpdate(sql3);
			        System.out.println("表3受影响的记录="+result);
					}
			}
	        }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    finally
	    {
	        try
	        {
	            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
	            // 注意关闭的顺序，最后使用的最先关闭
	           /* if (result != null)
	                result.close();*/
	            if (pre != null)
	                pre.close();
	            if (con != null)
	                con.close();
	            System.out.println("数据库连接已关闭！");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	public static void main(String args[]){
		String[] role={"310","311","312","331","332","333","334","790"};
		TestExcel excel=new TestExcel();
		ArrayList<Tmcc> list=excel.getExcelData();
		String[] key=new String[list.size()];
		String[] name=new String[list.size()];
		System.out.println("获取到的list.size()="+list.size());
		for (int i=0;i<list.size();i++) {
			Tmcc tmcc=list.get(i);
			System.out.println(tmcc.getKey()+"|"+tmcc.getName());
			key[i]=tmcc.getKey();
			name[i]=tmcc.getName().replaceAll(" ", "").replaceAll(" ", "");
		}
		System.out.println("看看赋值后的结果："+key[list.size()-1]+"|"+name[list.size()-1]);
		oracelTest test=new oracelTest();
		test.testOracle(key,name,role);
	}
}