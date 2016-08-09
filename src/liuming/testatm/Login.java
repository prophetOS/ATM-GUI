package liuming.testatm;

import java.io.FileReader;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 * 登陆
 * @author 那小子’超赞
 */
public class Login {
	//创建资源管理对象
	static Properties pro = new Properties();
	String str = "user.txt";
	//Login类的构造方法
	public Login(){
		try{
			//加载文件
			pro.load(new FileReader(str));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "文件不存在！");
		}
	}
	//登陆方法
	public static boolean load(){
		int i = 0;
		do{
			String name = JOptionPane.showInputDialog("请输入用户名：");
			String pwd = JOptionPane.showInputDialog("请输入密码：");
			try{
				if(name.matches("[a-zA-Z]{1,6}") && pwd.matches("[0-9]{1,8}")){
					if(name.equals(pro.getProperty("name")) && pwd.equals(pro.getProperty("pwd"))){
						JOptionPane.showMessageDialog(null, "登陆成功！");
						return true;
					}
					else{
						JOptionPane.showMessageDialog(null, "用户名或密码错误！");
						i++;
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "输入非法！");
					i++;
				}
			}catch(NullPointerException nullPoint){
				JOptionPane.showMessageDialog(null, "谢谢使用。\n    再见！");
				System.exit(0);
			}
		}while(i<3);
		return false;
	}
}
