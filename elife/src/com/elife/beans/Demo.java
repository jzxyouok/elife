package com.elife.beans;

/**
 * @author 高远</n> 编写时期 2016-4-11 上午10:13:42</n> TODO</n> 邮箱：wgyscsf@163.com</n>
 *         博客 http://blog.csdn.net/wgyscsf</n>
 * 
 */
public class Demo {
	private String sDemo;

	public Demo() {
		super();
	}

	public Demo(String sDemo) {
		super();
		this.sDemo = sDemo;
	}

	@Override
	public String toString() {
		return "Demo [sDemo=" + sDemo + "]";
	}

	public String getsDemo() {
		return sDemo;
	}

	public void setsDemo(String sDemo) {
		this.sDemo = sDemo;
	}
}
