package liuming.testatm;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 * 功能区
 * @author 那小子’超赞
 */
public class ATM {
	//创建资源管理对象
	Properties pro = new Properties();
	Properties prop = new Properties();
	//ATM的构造方法
	public ATM(){
		try{
			//加载文件
			pro.load(new FileReader("bank.txt"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "文件未找到！");
		}
	}
	
	/**
	 * 查询
	 */
	public void find(){
		JOptionPane.showMessageDialog(null, "你的余额为：" + pro.getProperty("money"));
	}
	
	/**
	 * 取款
	 */
	public void getMoney(){
		String tempTake = JOptionPane.showInputDialog("请输入取款金额：");
		int take = Integer.parseInt(tempTake);
		int money = Integer.parseInt(pro.getProperty("money"));
		if(take > money){
			JOptionPane.showMessageDialog(null, "取款金额大于现有金额！");
		}
		else if(tempTake.matches("1[0-9]00|[1-9]00|2000")){
			//int take = Integer.parseInt(tempTake);
			//int money = Integer.parseInt(pro.getProperty("money"));
			money -= take;
			JOptionPane.showMessageDialog(null, "你的余额为："+money+"");
			new SetCalendar();
			String temp = String.valueOf(money);
			pro.setProperty("money", temp);
			try{
				pro.store(new FileWriter("bank.txt"), null);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "文件不存在！");
			}
		}
		else if(tempTake.matches("[-][0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "取款金额必须大于0！");
		}
		else if(tempTake.matches("[0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "请输入100的整数倍！");
		}
		else{
			JOptionPane.showMessageDialog(null, "xxxxxxxx！");
		}
	}
	
	/**
	 * 存款
	 */
	public void saveMoney(){
		String tempSave = JOptionPane.showInputDialog("请输入取款金额：");
		if(tempSave.matches("(1[0-9]{0,}00|[1-9]00)")){
			int save = Integer.parseInt(tempSave);
			int money = Integer.parseInt(pro.getProperty("money"));
			money += save;
			JOptionPane.showMessageDialog(null, "你的余额为："+money+"");
			new SetCalendar();
			String temp = String.valueOf(money);
			pro.setProperty("money", temp);
			try{
				pro.store(new FileWriter("bank.txt"), null);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "文件不存在！");
			}
		}
		else if(tempSave.matches("[-][0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "请输入正数！");
		}
		else if(tempSave.matches("[0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "请输入100的整数倍！");
		}
		else{
			JOptionPane.showMessageDialog(null, "xxxxxxxx！");
		}
	}
	
	/**
	 * 改密码
	 */
	public void alterPwd(){
		try{
			prop.load(new FileReader("user.txt"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "文件未找到！");
		}
		String tempPwd = JOptionPane.showInputDialog("请输入新密码：");
		if(tempPwd.matches("[0-9]{1,8}")){
			prop.setProperty("pwd", tempPwd);
			new SetCalendar();
			try{
				prop.store(new FileWriter("user.txt"), null);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "文件不存在！");
			}
		}
	}
}
