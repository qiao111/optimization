package com.performance.optimization.design.decorator;

/**
 * 具体的装饰器 负责对核心内容进行html格式化操作,委托了组件进行核心业务处理
 * @author qiaolin
 *
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {

	public PacketHTMLHeaderCreator(IPacketCreator component) {
		super(component);
		System.out.println("Html装饰者构造");
	}

	/**
	 * 封装数据为html
	 */
	public String handleContent() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html>");
		buffer.append("<body>");
		buffer.append(component.handleContent());//业务逻辑处理
		buffer.append("</body>");
		buffer.append("</html>\n");
		return buffer.toString();
	}

}
