package liuming.atm;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * 功能区
 * @author 那小子’超赞
 */
public class ATM {
	//创建资源文件对象
	Properties pro = new Properties();
	
	public ATM(){
		try{
			//加载资源文件
			pro.load(new FileReader("bank.txt"));
		}catch(Exception e){
			System.out.println("此文件不存在！");
		}
	}
	
	/**查询*/
	public void find(){
		//通过键（money）获得相应的值
		String money = pro.getProperty("money");
		JOptionPane.showMessageDialog(null, "你的余额为："+money);
	}
	
	/**取款*/
	public void getMoney(){
		String tempTake = JOptionPane.showInputDialog("请输入取款金额:");
		int take = Integer.parseInt(tempTake);
		
		int money = Integer.parseInt(pro.getProperty("money"));
		
		if(tempTake.matches("1[\\d]00|[1-9]00|2000")){
			money -= take;
			JOptionPane.showMessageDialog(null, "你的余额为："+money);
			String tempMoney = String.valueOf(money);
			//设置键（money）的值
			pro.setProperty("money", tempMoney);
			try{
				//写入文件
				pro.store(new FileWriter("bank.txt"), null);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "文件不存在！");
			}
		}
		else if(tempTake.matches("[-][0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "取款数必须大于0！");
		}
		else if(tempTake.matches("[0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "必须是100的整数倍！");
		}
		else if(take > money){
			JOptionPane.showMessageDialog(null, "取款金额大于现有金额！");
		}
		else {
			JOptionPane.showMessageDialog(null, "请输入（0-9）之间的数！");
		}
	}
	
	/**存款*/
	public void saveMoney(){
		String tempSave = JOptionPane.showInputDialog("请输入存款金额：");
		int money = Integer.parseInt(pro.getProperty("money"));
		
		if(tempSave.matches("1[\\d]00|[1-9]00")){
			int save = Integer.parseInt(tempSave);
			money += save;
			JOptionPane.showMessageDialog(null, "你的余额为："+money);
			String tempMoney = String.valueOf(money);
			//设置键（money）的值
			pro.setProperty("money", tempMoney);
			try{
				//写入文件
				pro.store(new FileWriter("bank.txt"), null);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "文件不存在！");
			}
		}
		else if(tempSave.matches("[-][0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "取款数必须大于0！");
		}
		else if(tempSave.matches("[0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "必须是100的整数倍！");
		}
		else {
			JOptionPane.showMessageDialog(null, "请输入（0-9）之间的数！");
		}
	}
}
