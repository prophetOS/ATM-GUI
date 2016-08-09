package liuming.atm;

import java.io.FileReader;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 * 登陆区
 * @author 那小子’超赞
 *
 */
public class Login {
	//创建资源文件对象
	Properties pro = new Properties();
	//Login类的构造方法
	public Login(){
		try{
			//加载文件
			pro.load(new FileReader("user.txt"));
		}catch(Exception e){
			System.out.println("此文件不存在！");
		}
	}
	//登陆
	public boolean load(){
		for(int i = 0; i < 3 ; i++){
			String name = JOptionPane.showInputDialog("请输入用户名：");
			String pwd = JOptionPane.showInputDialog("请输入密码：");
			try{
				if(name.matches("[a-zA-Z]{1,6}") && pwd.matches("[0-9]{1,8}")){
					if(name.equals(pro.getProperty("name")) && pwd.equals(pro.getProperty("pwd"))){
						JOptionPane.showMessageDialog(null, "登陆成功！");
						return true;
					}
					else{
						JOptionPane.showMessageDialog(null, "用户名密码错误！");
					}
				}
				else{
					System.out.println("输入错误！");
				}
			}catch(NullPointerException Number){
				JOptionPane.showMessageDialog(null,"欢迎使用，再见！");
				System.exit(0);
			}

		}
		return false;
	}
	
}
