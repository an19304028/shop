
package command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import presentation.RequestContext;




public abstract class CommandFactory {
	public static AbstractCommand getCommand(RequestContext rc) {

		AbstractCommand command = null;

		Properties p = new Properties();
		String name = null;
		
		try {
			// プロパティファイルを読み込む
			
			InputStream file = CommandFactory.class.getClassLoader().getResourceAsStream("commands.properties");
			//p.load(new FileInputStream("shops/WEB-INF/classes/command/commands.properties"));
			p.load(file);
		

			// パスに対応した文字列を取得します
			name = p.getProperty(rc.getCommandPath());
			System.out.println("getCommandPath:"+rc.getCommandPath());
			System.out.println("Commandプロパティ名:"+name);

			// 指定された名前のクラスに対応したClassクラスの
			// インスタンスを取得する（名前は完全限定名であること）
			Class c = Class.forName(name);

			// Classクラスのインスタンスを利用して
			// 対応するクラスのインスタンス化を行う
			command = (AbstractCommand) c.newInstance();

		} catch (FileNotFoundException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		} catch (InstantiationException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		}

		return command;
	}
}

