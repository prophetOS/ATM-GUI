package liuming.testatm;

import javax.swing.JOptionPane;

import liuming.testatm.ATM;
import liuming.testatm.Login;
import liuming.testatm.MainView;

public class MainView {

	/**
	 * 主方法
	 * @author 那小子’超赞
	 * @param args
	 */
	public MainView(){
		//创建一个ATM的对象,用于调用ATM类中的方法
		ATM atm = new ATM();
		//创建一个Login的对象，用于调用Login类中的方法
		Login login = new Login();
		boolean log = login.load();

		if(log == false){
			JOptionPane.showMessageDialog(null, "非法用户！");
			System.exit(0);
		}
		
		do{
			try{
				String str = JOptionPane.showInputDialog(
						"1、取款\n2、存款\n3、查询\n4、改密码\n5、取卡\n请选择：");
				if(str.matches("[1-5]")){
					int choose = Integer.parseInt(str);
					switch(choose){
					case 1:
						atm.getMoney();//调用ATM类中的getMoney方法
						break;
					case 2:
						atm.saveMoney();//调用ATM类中的saveMoney方法
						break;
					case 3:
						atm.find();//调用ATM类中的find方法
						break;
					case 4:
						atm.alterPwd();
						break;
					case 5:
						JOptionPane.showMessageDialog(null, "欢迎使用，再见！");
						System.exit(0);
						break;
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "输入错误！");
				}
			}catch(NullPointerException nullPoint){
				JOptionPane.showMessageDialog(null, "系统繁忙！请稍后再试...");
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}while(true);
	}

	public static void main(String[] args) {
		MainView atm = new MainView();
	}

}
